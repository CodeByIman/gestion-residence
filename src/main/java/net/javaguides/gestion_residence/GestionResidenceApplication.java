package net.javaguides.gestion_residence;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "net.javaguides.gestion_residence")
@EnableScheduling
public class GestionResidenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionResidenceApplication.class, args);
	}

}
