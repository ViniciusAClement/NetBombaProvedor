package main;

import main.model.Assinatura;
import main.model.Cliente;
import main.model.Endereco;
import main.model.Plano;
import main.service.AssinaturaService;
import main.service.ClienteService;
import main.service.PlanoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final ClienteService clienteService;
    private final PlanoService planoService;
    private final AssinaturaService assinaturaService;

    public ConsoleRunner(
            ClienteService clienteService,
            PlanoService planoService,
            AssinaturaService assinaturaService
    ) {
        this.clienteService = clienteService;
        this.planoService = planoService;
        this.assinaturaService = assinaturaService;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== NetBomba CLI ===");

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar Plano");
            System.out.println("2 - Cadastrar Cliente");
            System.out.println("3 - Criar Assinatura");
            System.out.println("0 - Sair");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> {
                    System.out.print("Nome do plano: ");
                    String nome = scanner.nextLine();

                    System.out.print("Velocidade (Mbps): ");
                    double velocidade = Double.parseDouble(scanner.nextLine());

                    System.out.print("Preço mensal: ");
                    double preco = Double.parseDouble(scanner.nextLine());

                    Plano plano = planoService.criarPlano(nome, velocidade, preco);
                    System.out.println("Plano criado com ID: " + plano.getId());
                }

                case "2" -> {
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();

                    System.out.print("CPF do cliente: ");
                    String cpf = scanner.nextLine();

                    System.out.println("== Endereço ==");
                    System.out.print("Rua: ");
                    String rua = scanner.nextLine();
                    System.out.print("Número: ");
                    String numero = scanner.nextLine();
                    System.out.print("Bairro: ");
                    String bairro = scanner.nextLine();
                    System.out.print("CEP: ");
                    String cep = scanner.nextLine();
                    System.out.print("Cidade: ");
                    String cidade = scanner.nextLine();
                    System.out.print("Estado: ");
                    String estado = scanner.nextLine();

                    Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado);
                    Cliente cliente = clienteService.criarCliente(nome, cpf, endereco, null);
                    System.out.println("Cliente criado com ID: " + cliente.getId());
                }

                case "3" -> {
                    System.out.print("CPF do cliente: ");
                    String clienteCpf = scanner.nextLine();

                    System.out.print("ID do plano: ");
                    Long planoId = Long.parseLong(scanner.nextLine());

                    Cliente cliente = clienteService.buscarPorCPF(clienteCpf);
                    Plano plano = planoService.buscarPlanoPorId(planoId);

                    Assinatura assinatura = assinaturaService.criarAssinatura(cliente, plano);
                    System.out.println("Assinatura criada com ID: " + assinatura.getId());
                }

                case "0" -> {
                    System.out.println("Encerrando o programa...");
                    return;
                }

                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
