package main.model.service;

import java.math.BigDecimal;

import main.model.dao.PlanoDAO;
import main.model.entity.Plano;

public class PlanoService {
	
	public static Plano createPlano( int megas, BigDecimal preco) {
		Plano plano = new Plano.Builder()
				.megas(megas)
				.preco(preco)
				.builder();
		PlanoDAO.addPlano(plano);
		return plano;
	}
	
	public static Plano readPlanoById ( int id ) {
		return PlanoDAO.getPlano(id);
	}
}
