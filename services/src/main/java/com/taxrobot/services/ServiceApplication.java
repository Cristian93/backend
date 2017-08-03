package com.taxrobot.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

	/*@Bean
	CommandLineRunner lookup (ServicioComparendo service){

		return  args -> {
			GetFineRequestDto id = new GetFineRequestDto();
			id.setNumero("8909039388");
			id.setTipo(4);
            ComparendosResponse rs = service.getComparendos(id);
            System.out.println("aaaaaaaaaaaaa" + rs.getReturn().getComparendos().get(0).getCodigoInfraccion());
		};
	}*/
}
