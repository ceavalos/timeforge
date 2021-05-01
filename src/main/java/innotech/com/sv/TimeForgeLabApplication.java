package innotech.com.sv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TimeForgeLabApplication implements CommandLineRunner{
	
	@Value("${innotec.com.ACCOUNT_SID}")	
	String account_id; 
	
	
	@Value("${innotec.com.AUTH_TOKEN}")	
	String token;

	
	
	private final static Logger logger = LoggerFactory.getLogger(TimeForgeLabApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(TimeForgeLabApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Proceso Iniciado exitosamente!.");
		 System.out.println(" account_id= "+account_id+" token="+token);
		
	}

}
