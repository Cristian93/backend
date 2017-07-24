package com.demo.springboot.demo;

//import com.demo.springboot.ws.ComparendosResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*@Bean
	CommandLineRunner lookup (ServicioComparendo service){

		return  args -> {
			IdentificacionDto id = new IdentificacionDto();
			id.setNumero("8909039388");
			id.setTipo(4);
            ComparendosResponse rs = service.getComparendos(id);
            System.out.println("aaaaaaaaaaaaa" + rs.getReturn().getComparendos().get(0).getCodigoInfraccion());
		};
	}*/
}
