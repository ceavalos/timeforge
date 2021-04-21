package innotech.com.sv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TimeForgeLabApplication implements CommandLineRunner{

	private final static Logger logger = LoggerFactory.getLogger(TimeForgeLabApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(TimeForgeLabApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Proceso Iniciado exitosamente!.");
		
	}

}
