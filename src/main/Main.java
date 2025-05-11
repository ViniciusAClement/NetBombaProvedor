package main;

import java.util.List;
import java.util.Scanner;

import main.model.entity.Assinatura;
import main.model.entity.Cliente;
import main.model.entity.Endereco;
import main.model.entity.Plano;
import main.model.service.ClienteService;
import main.model.service.PlanoService;

public class Main {
	public static void main (String[] args) {
		int escolha = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("==========================================");
		System.out.println("                NET BOMBA");
		System.out.println("==========================================");
		while(escolha != 3) {
			System.out.println("==========================================");
			System.out.println("1 - Vizualizar Tabela de Clientes");
			System.out.println("2 - Vizualizar Tabela de Planos");
			System.out.println("3 - Sair");
			System.out.println("==========================================");
			escolha = sc.nextInt();
			
			switch(escolha) {
			case 1:
				int escolhaTabelaCliente = 0;
				List <Cliente> clienteTable= ClienteService.readClienteTable();
				for (Cliente cliente : clienteTable) {
					System.out.println("+++++++++++++++++++++++++++++++++++");
					System.out.println("ID: "+ cliente.getId());
					System.out.println("Nome: "+ cliente.getNome());
					System.out.println("Status da Internet: "+ cliente.getAssinatura().getPlano().getMegas()+" Megas    "+cliente.getAssinatura().isStatus());
					System.out.println("+++++++++++++++++++++++++++++++++++");
				}
				while(escolhaTabelaCliente != 9) {
					System.out.println("--------------------------------------");
					System.out.println("1 - Vizualizar Cliente");
					System.out.println("2 - Adicionar Novo Cliente");
					System.out.println("9 - Voltar");
					System.out.println("--------------------------------------");
					
					escolhaTabelaCliente = sc.nextInt();
					
					switch (escolhaTabelaCliente) {
						case 1:
							int escolhaTelaCliente;
							
							System.out.print("Informe o id do cliente: ");
							int idDoCliente = sc.nextInt();
							System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
							Cliente cliente = ClienteService.readClienteById(idDoCliente);
							System.out.println("ID: " + cliente.getId());
							System.out.println("Nome: " + cliente.getNome());
							System.out.println("CPF: " + cliente.getCpf());
							System.out.println("Endereço: " + cliente.getEndereco().getRua() + " Nº" + cliente.getEndereco().getNumero());
							System.out.println("Velocidade da Internet: " + cliente.getAssinatura().getPlano().getMegas());
							System.out.println("Mensalidade: " + cliente.getAssinatura().getPlano().getPreco());
							boolean internetBoolean = cliente.getAssinatura().isStatus();
							String statusDaInternet = (internetBoolean) ? "Ativa" : "Cancelada";
							System.out.println("Status da Internet: " + statusDaInternet);
							System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
							
							
							System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
							System.out.println("1 - Deletar Cliente");
							System.out.println("2 - Editar Cliente");
							System.out.println("9 - voltar");
							System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
							
							escolhaTelaCliente = sc.nextInt();
							
							switch(escolhaTelaCliente){
								case 1:
									ClienteService.deleteCliente(cliente.getId());
									break;
								case 2:
									System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
									sc.nextLine();
									System.out.printf("Insira o novo nome(Antigo: %s): ",cliente.getNome());
									String novoNome = sc.nextLine();
									System.out.printf("insira o novo CPF(Antigo: %s): ", cliente.getCpf());
									String novoCpf = sc.nextLine();
									System.out.printf("Insira a nova rua (Antiga: %s): ", cliente.getEndereco().getRua());
									String novaRua = sc.nextLine();
									System.out.printf("Insira a novo numero da casa (Antigo: %d): ", cliente.getEndereco().getNumero());
									int novoNumero = sc.nextInt();
									System.out.printf("Insira o id do novo plano (Antigo: %s): ", cliente.getAssinatura().getPlano().getId());
									int novoIdDoPlano = sc.nextInt();
									System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
									
									ClienteService.editCliente(cliente.getId(), novoNome, novoCpf, novaRua, novoNumero, novoIdDoPlano);
									break;
								case 9:
									break;
								default:
									System.out.println("Não entendi, amigo");
									break;
							}
						break;
						case 2:
							System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
							sc.nextLine();
							System.out.printf("Insira o nome: ");
							String novoNome = sc.nextLine();
							System.out.printf("insira o CPF: ");
							String novoCpf = sc.nextLine();
							System.out.printf("Insira a rua : ");
							String novaRua = sc.nextLine();
							System.out.printf("Insira o numero da casa: ");
							int novoNumero = sc.nextInt();
							System.out.printf("Insira o id do plano: ");
							int novoIdDoPlano = sc.nextInt();
							System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
							
							ClienteService.createCliente(novoNome, novoCpf, novaRua, novoNumero, novoIdDoPlano);
							break;
					}
				}
				break;
			
			case 2:
				List <Plano> planoTable = PlanoService.readPlanoTable();
				for (Plano plano : planoTable) {
					System.out.println("***********************************");
					System.out.println("ID: " + plano.getId());
					System.out.println("Megas: " + plano.getMegas());
					System.out.println("Preço: " + plano.getPreco());
					System.out.println("***********************************");
				}
				break;
			case 3:
				break;
				
			default:
				System.out.println("Tente novamente");
				continue;
			}
		}
	}
}
