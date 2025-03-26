package Sistema_Bancario_Simples.demo;

import Sistema_Bancario_Simples.demo.repository.ClienteRepository;
import Sistema_Bancario_Simples.demo.repository.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}
