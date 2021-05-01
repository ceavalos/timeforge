package innotech.com.sv.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import innotech.com.sv.Configurations.TwilioConf;
import innotech.com.sv.modelos.Mensaje;
import innotech.com.sv.modelos.SendMessage;



@Service
public class TwilioServiceImp {
		
	
	
	
	@Autowired
	TwilioConf twilioConf;
	
	
	public SendMessage envioSms(Mensaje mensaje, Model modelo) {
		//logica para enviar el mensaje.
		String respuesta1=null, respuesta2=null;
		SendMessage Enviomensaje = new  SendMessage();
		//		
		
		if (mensaje.getPara1() != null) {
			System.out.println("mensaje.getPara1()="+mensaje.getPara1());
			respuesta1 = envioSms(mensaje.getPara1(), mensaje.getMensaje(), modelo);			
		}
		//
		if (mensaje.getPara2() != null) {
			System.out.println("mensaje.getPara2()="+mensaje.getPara2());
			respuesta2 = envioSms(mensaje.getPara1(), mensaje.getMensaje(), modelo);			
		}
		if (respuesta1 != null) {
			Enviomensaje.setMessage(mensaje);
			Enviomensaje.setTwilioConfirmation(respuesta1);
			Enviomensaje.setDate_time_Send(new Date());			
			//envioMensaje.save(Enviomensaje);
			return Enviomensaje;
		} else {
			return null;
		}
		
		
	}
	
	
	public String envioSms(String destino, String mensaje, Model modelo) {
		
		System.out.println("twilioConf.getAcccount_id()="+ twilioConf.getAcccount_id()+" twilioConf.getAuth_token()="+twilioConf.getAuth_token());
		
		Twilio.init(twilioConf.getAcccount_id(), twilioConf.getAuth_token());
		
		
		
		/*Message message = Message.creator(new com.twilio.type.PhoneNumber("+50378885252"),
				"MGbc3eae91b352c06b585995496522e8c3", "hello world!$$$$").create();
		*/
		System.out.println("destino= "+destino+ " Mensaje="+mensaje);
		try {
			Message message = Message.creator(new com.twilio.type.PhoneNumber(destino),
					"MGbc3eae91b352c06b585995496522e8c3", mensaje).create();
			System.out.println(message.getSid());		

			return message.getSid();
		} catch (Exception e) {
			System.out.println("Error al intentar enviar el mensaje " + e.getMessage());
			modelo.addAttribute("error", e.getMessage());
			return null;
		}
		
		//
		 
		
		//return null;
	}

	
}
