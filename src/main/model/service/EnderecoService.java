package main.model.service;

import main.model.dao.EnderecoDAO;
import main.model.entity.Endereco;

public class EnderecoService {
	public static Endereco createEndereco( String rua, int numero) {
		Endereco endereco = new Endereco.Builder()
				.rua(rua)
				.numero(numero)
				.build();
		EnderecoDAO.addEndereco(endereco);
		return endereco;
	}
}
