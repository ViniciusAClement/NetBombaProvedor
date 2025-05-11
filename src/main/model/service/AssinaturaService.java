package main.model.service;

import main.model.dao.AssinaturaDAO;
import main.model.dao.PlanoDAO;
import main.model.entity.Assinatura;
import main.model.entity.Plano;

public class AssinaturaService {
	public static Assinatura createAssinatura( Plano plano ) {
		Assinatura assinatura = new Assinatura.Builder()
				.plano(plano)
				.status(true)
				.build();
		AssinaturaDAO.addAssinatura(assinatura);
		return assinatura;
	}
	
	public static Assinatura readAssinaturaById ( int id ) {
		return AssinaturaDAO.getAssinatura(id);
	}
	
	public static void editAssinatura ( int id, Plano plano, boolean status ) {
		AssinaturaDAO.updateAssinatura(id, plano, status);
	}
	public static void deleteAssinatura ( int id ) {
		AssinaturaDAO.deleteAssinatura(id);
	}
}
