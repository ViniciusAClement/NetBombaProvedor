package main.model.dao;

import org.hibernate.Session;

import main.model.entity.Plano;

public class PlanoDAO {
	public static void addPlano(Plano plano) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(plano);
		session.getTransaction().commit();
		session.close();
		
	}
	public static Plano getPlano ( int id ) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Plano plano = session.get(Plano.class, id);
		session.close();
		return plano;
	}
}
