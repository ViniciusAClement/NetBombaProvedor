package main.model.dao;

import org.hibernate.Session;

import main.model.entity.Endereco;

public class EnderecoDAO {
	public static void addEndereco ( Endereco endereco ) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(endereco);
		session.getTransaction().commit();
		session.close();
	}
}
