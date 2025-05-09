package main.model.dao;

import org.hibernate.Session;

import main.model.entity.Assinatura;

public class AssinaturaDAO {
	public static void addAssinatura ( Assinatura assinatura) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(assinatura);
		session.getTransaction().commit();
		session.close();
	}
}
