package innotech.com.sv.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import innotech.com.sv.modelos.Message;



@Controller
@SessionAttributes("messagee")
//@RequestMapping("/mensaje")
public class MensajesController {

	@RequestMapping("/")
	public String inicio(Model modelo,  HttpServletRequest request) {
		
		Message message = new Message();
		
		modelo.addAttribute("messagee", message);
		//
		return "mensaje";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String forma(@Valid Message message, BindingResult result, Model model,
			            SessionStatus status) {
		
		if (result.hasErrors()) {
			System.out.println("con errores al momento de enviar mensaje");
			return "mensaje";
		}
		
		return "redirect:mensaje";
	}
}
