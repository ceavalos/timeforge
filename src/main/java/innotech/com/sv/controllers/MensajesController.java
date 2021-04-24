package innotech.com.sv.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestParam;  

import innotech.com.sv.modelos.Message;

import innotech.com.sv.service.IMessage;



@Controller
@SessionAttributes("messagee")
@RequestMapping("/mensaje")
public class MensajesController {

	@Autowired
	IMessage servicioMensaje;
	
	@RequestMapping("/envio")
	public String inicio(Model modelo,  HttpServletRequest request, RedirectAttributes flash) {
		
		Message message = new Message();
		
		modelo.addAttribute("messagee", message);
		modelo.addAttribute("titulo", "Envio de mensajes!.");
		//
		return "mensaje";
	}
	
	
	@RequestMapping(value = "/listar")
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model modelo, 
			    HttpServletRequest request) {
		
		List<Message> mensaje = servicioMensaje.findAll();
	      	      
		modelo.addAttribute("titulo", "Listado de Mensajes a enviar");
		modelo.addAttribute("datos", mensaje);
		
		return "listar";
	}
	
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String forma(@Valid Message message, BindingResult result, Model model,			             
			            SessionStatus status, RedirectAttributes flash) {
		//
		System.out.println("En controlador forma =" + result.hasErrors());
		//
		if (result.hasErrors()) {
			System.out.println("con errores al momento de enviar mensaje");
			model.addAttribute("titulo", "Formulario de Envio Mensajes");
			flash.addFlashAttribute("success", "Error al intentar enviar mensaje. No deje vacios Telefono y Mensaje");
			return "mensaje";
		}
		
		servicioMensaje.save(message);
		String mensajeFlash = (String.valueOf(message.getId()) != null) ? "Mensaje Almacenado con éxito" : " Mensaje con Errores!! ";
		flash.addFlashAttribute("success", mensajeFlash);
		
		status.setComplete();
		
		return "redirect:/";
	}
}
