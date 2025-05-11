package main.model.service;

import java.math.BigDecimal;
import java.util.List;

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
	
	public static void editPlano ( int id, int megas, BigDecimal preco) {
		PlanoDAO.editPlano(id, megas, preco);
	}
	
	public static void deletePlano ( int id ) {
		PlanoDAO.deletePlano(id);
	}
	
	public static List<Plano> readPlanoTable (){
		return PlanoDAO.readPlanoTable();
	}
}
