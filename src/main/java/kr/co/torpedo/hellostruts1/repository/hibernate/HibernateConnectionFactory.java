package kr.co.torpedo.hellostruts1.repository.hibernate;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import kr.co.torpedo.hellostruts1.domain.Admin;
import kr.co.torpedo.hellostruts1.domain.User;

public class HibernateConnectionFactory {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	static {
		String path = "D:/eclipse_workspace/HelloStruts/src/main/resources/hibernate.cfg.xml";
		Configuration configuration = new Configuration().configure(new File(path));
		configuration.addAnnotatedClass(Admin.class);
		configuration.addAnnotatedClass(User.class);
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
