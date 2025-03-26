package Sistema_Bancario_Simples.demo.repository;

import Sistema_Bancario_Simples.demo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Scanner;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    @Autowired
    public ClienteService(ClienteRepository repository){
        this.repository = repository;
    }

    // Exibe o menu
    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("\n===== MENU ======");
            System.out.println("\n1. Cadastrar novo cliente");
            System.out.println("2. Listar clientes cadastrados");
            System.out.println("3. Excluir clientes cadastrados");
            System.out.println("4. Modificar cadastrado");
            System.out.println("5. Excluir todos os clientes");
            System.out.println("&. Sair");
            System.out.println("Escolha uma opção: ");

            input = scanner.nextLine();

            switch (input) {
                case "&":
                    System.out.println("Programa encerrado");
                    return; // Sai do loop e encerra o programa
                case "1":
                    cadastrarCliente(scanner);  // Chama o metodo cadastrar cliente
                    break;
                case "2":
                    listarClientes(scanner);  // Lista clientes
                    break;
                case "3":
                    excluirCliente(scanner); //Exclui um cliente
                case "4":
                    modificarCliente(scanner); //Modificar cadastro cliente
                case "5":
                    excluirTabela(scanner); //Exclui a tabela e todos os clientes
            }
        }
    }

    //1.Cadastra os clientes
    public void cadastrarCliente(Scanner scanner){
        System.out.println("Informe seus dados a baixo: ");
        String nome = "";
        while(nome.isEmpty()){
            System.out.println("Digite seu nome: ");
            nome = scanner.nextLine();
            if(nome.isEmpty()){
                System.out.println("O nome não pode estar vazio.");
            }
        }
        String conta = "";
        while(conta.isEmpty()){
            System.out.println("Digite seu número da conta: ");
            conta = scanner.nextLine();
            if(conta.isEmpty()){
                System.out.println("A conta não pode ser vazia");
            }
        }

        Double saldo = null;
        while(saldo == null){
            System.out.println("Digite seu saldo: ");
            saldo = scanner.nextDouble();
        }

        Cliente cliente = new Cliente(nome, conta, saldo);
        repository.save(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
        scanner.nextLine();
    }

    //2.Listar clientes
    public void listarClientes(Scanner scanner){
        Iterable<Cliente> clientes = repository.findAll();
        boolean temCliente = false;
        for(Cliente c : clientes) {
            System.out.println(c);
            temCliente = true;
        }
        if(!temCliente){
            System.out.println("Nenhum cliente cadastrado");
        }
        scanner.nextLine();
    }

    //3.Excluir cliente  / Modificar primaryKey
    public void excluirCliente(Scanner scanner){
        System.out.println("Digite o Id do cliente que deseja excluir :");
        Integer idExcluir = scanner.nextInt();
        repository.deleteById(idExcluir);
        System.out.println("Cliente excluido com sucesso!");
    }

    //4.Modificar cadastro
    public void modificarCliente(Scanner scanner){
        listarClientes(scanner);

        System.out.println("Digite o Id do cliente que deseja modificar: ");
        Integer idModificar = scanner.nextInt();

        //Verifica se o cliente existe
        Optional<Cliente> optionalCliente = repository.findById(idModificar);
        if(optionalCliente.isEmpty()){
            System.out.println("Cliente não encontrado!");
            return;
        }

        Cliente cliente = optionalCliente.get();

        System.out.println("Nome atual: " + cliente.getNome());
        System.out.println("Novo nome (ou pressione ENTER para manter): ");
        String novoNome = scanner.next();
        if(!novoNome.isBlank()){
            cliente.setNome(novoNome);
        }

        System.out.println("Conta atual: " + cliente.getNome());
        System.out.println("Nova conta (ou pressione ENTER para manter): ");
        String novaConta = scanner.next();
        if(!novaConta.isBlank()){
            cliente.setConta(novaConta);
        }

        System.out.println("Saldo atual: " + cliente.getSaldo());
        System.out.println("Novo saldo (ou pressione ENTER para manter): ");
        Double novoSaldo = scanner.nextDouble();
        if(novoSaldo != null){
                cliente.setSaldo(novoSaldo);
        }
        repository.save(cliente);
        System.out.println("Cliente modificado com sucesso");
        scanner.next();
    }

    //5.Excluir todos os clientes
    public void excluirTabela(Scanner scanner){
    //listarClientes(scanner);
    System.out.println("Deseja apagar tudo? y/n");
    String confirmar = scanner.next();
    if(confirmar.equals("y")) {
        repository.deleteAll();
        System.out.println("Apagado com sucesso");
        } else {
        System.out.println("Operação cancelada");
        }
    scanner.next();
    }
}