package innotech.com.sv.Configurations;

import com.twilio.Twilio; 
import com.twilio.converter.Promoter; 
import com.twilio.rest.api.v2010.account.Message; 
import com.twilio.type.PhoneNumber;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration
@PropertySource("classpath:configuraciones.properties")
public class TwilioConf { 
	
	@Value("${innotec.com.ACCOUNT_SID}")	
	private String acccount_id ;
	
	@Value("${innotec.com.AUTH_TOKEN}")	
	private  String auth_token ;
	
	@Value("${innotec.com.NUMBER}")
	private String numero;

	public String getAcccount_id() {
		return acccount_id;
	}

	public void setAcccount_id(String acccount_id) {
		this.acccount_id = acccount_id;
	}

	public String getAuth_token() {
		return auth_token;
	}

	public void setAuth_token(String auth_token) {
		this.auth_token = auth_token;
	}

	public String getNumber() {
		return numero;
	}

	public void setNumber(String number) {
		this.numero = number;
	}
	
	
	
	// Find your Account Sid and Token at twilio.com/console 
 /*   public static final String ACCOUNT_SID = "ACb05d1c796a0a12aec9d355c038e71151"; 
    public static final String AUTH_TOKEN = "70769ca3bdb8beb087782f96bc2f9406"; 
 */
/*
	 public void servicio() { 
        

    }; 
    	*/
}