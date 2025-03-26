package Sistema_Bancario_Simples.demo;

import Sistema_Bancario_Simples.demo.repository.ClienteRepository;
import Sistema_Bancario_Simples.demo.repository.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class StartApp implements CommandLineRunner {

    private final ClienteService clienteService;

    @Autowired
    private ClienteRepository repository;

    @Autowired
    public StartApp(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @Override
    public void run(String... args) throws Exception {
        clienteService.exibirMenu();
        Scanner scanner = new Scanner(System.in);


    }
}
