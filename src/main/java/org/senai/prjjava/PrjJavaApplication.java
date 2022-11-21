package org.senai.prjjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication //Os arrobas significam INJECT
//Foi necessario digitar "alt+shift+o" para importar a biblioteca import org.springframework.web.bind.annotation.RestController
@RestController 
public class PrjJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrjJavaApplication.class, args);
	}

	@GetMapping("/hello")  //
	//Se o "name" estiver vazio a pagina voltará a palavra padrão "world"
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
	return String.format("Hello %s!", name);
	}

}
