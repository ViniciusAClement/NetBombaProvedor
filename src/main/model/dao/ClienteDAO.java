package main.model.dao;

import org.hibernate.Session;

import main.model.entity.Cliente;

public class ClienteDAO {
	public static void addCliente ( Cliente cliente ) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(cliente);
		session.getTransaction().commit();
		session.close();
	}
}
