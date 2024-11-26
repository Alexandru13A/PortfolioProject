package ro.alexandru.PortfolioBackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("ro.alexandru.PortfolioCore.entity")
public class PortfolioBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioBackEndApplication.class, args);
	}

}
