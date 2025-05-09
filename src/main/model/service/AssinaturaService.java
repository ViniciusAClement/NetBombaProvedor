package main.model.service;

import main.model.dao.AssinaturaDAO;
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
}
