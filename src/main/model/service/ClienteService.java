package main.model.service;

import main.model.dao.ClienteDAO;
import main.model.entity.Assinatura;
import main.model.entity.Cliente;
import main.model.entity.Endereco;

public class ClienteService {
	public static void createCliente ( String nome, String cpf, String rua, int numero, int plano) {
		Endereco endereco = EnderecoService.createEndereco(rua, numero);
		Assinatura assinatura = AssinaturaService.createAssinatura(PlanoService.readPlanoById(plano));
		
		Cliente cliente = new Cliente.Builder()
				.nome(nome)
				.cpf(cpf)
				.endereco(endereco)
				.Assinatura(assinatura)
				.build();
		
		ClienteDAO.addCliente(cliente);
	}
}
