package innotech.com.sv.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestParam;

import innotech.com.sv.modelos.Mensaje;
import innotech.com.sv.modelos.SendMessage;
import innotech.com.sv.paginator.PageRender;
import innotech.com.sv.service.IMessage;
import innotech.com.sv.service.ISendMessage;
import innotech.com.sv.service.SendMessageImp;
import innotech.com.sv.service.TwilioServiceImp;

@Controller
@SessionAttributes("messagee")
@RequestMapping("/mensaje")
public class MensajesController {

	@Autowired
	IMessage servicioMensaje;
	
	@Autowired
	TwilioServiceImp TwilioenvioSms;
	
	@Autowired
	SendMessageImp servicioEnvMensajeImp;
	
	@Autowired
	ISendMessage mensajeConfirma;
	
	
	String elementos ="10";
	
	@RequestMapping("/envio")
	public String inicio(Model modelo,  HttpServletRequest request, RedirectAttributes flash) {
		
		Mensaje message = new Mensaje();
		
		modelo.addAttribute("messagee", message);
		modelo.addAttribute("titulo", "Envio de mensajes!.");
		//
		return "form";
	}	
	
	@RequestMapping(value = "/listar")
	public String listar(@RequestParam(name="page", defaultValue="0") int page, Model modelo, 
			    HttpServletRequest request) {
		
        int elemento = Integer.parseInt(this.elementos);  
		
        PageRequest  pageRequest =  PageRequest.of(page, elemento);
		Page<Mensaje> mensajes = servicioMensaje.findAll(pageRequest) ;
		
		PageRender<Mensaje> pageRender = new PageRender<>("/mensaje/listar", mensajes, elemento) ;
		
		//
		modelo.addAttribute("titulo", "Listado de Mensajes enviados");
		modelo.addAttribute("datos", mensajes);
		modelo.addAttribute("page",pageRender);
		
		return "listar";
	}
	
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String forma(@Valid @ModelAttribute(value="messagee") Mensaje message, BindingResult result, Model model,			             
			            SessionStatus status, RedirectAttributes flash) {
		//
		System.out.println("En controlador forma =" + result.hasErrors());
		//
		if (result.hasErrors()) {
			//System.out.println("con errores al momento de enviar mensaje");
			//model.addAttribute("error", "<<Error>> Debe llenar destinatario y mensaje a enviar");			
			return "form";
		}
		SendMessage envioMensaje= TwilioenvioSms.envioSms(message, model);
		
		if (envioMensaje != null) {
			servicioMensaje.save(message);
			servicioEnvMensajeImp.save(envioMensaje);
			//
			String mensajeFlash ="Mensaje Almacenado con éxito" ;
			flash.addFlashAttribute("success", mensajeFlash);
		} else {
			String mensajeFlash ="Error al enviar el mensaje!!. "+model.getAttribute("error"); ;			
			flash.addFlashAttribute("error", mensajeFlash);
		}
			
		
		status.setComplete();
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/ver/{id}")
	public String confirmacion(@PathVariable(value = "id") Long id, Model modelo, 
			    HttpServletRequest request) {

		
		//mensajeConfirma.findByMensage(message);
		Mensaje message = servicioMensaje.findById(id);
		SendMessage confirma = mensajeConfirma.findByMensage(message);
		//
		System.out.println("confirma= " + confirma);
		if (confirma != null) {
			
		
		modelo.addAttribute("titulo", "Listado de confirmacion de mensajes enviados");
		modelo.addAttribute("datos",confirma );
		
		
		return "ver";
		} else {
			return "redirect:/mensaje/listar";
		}
	}
}
