package bidireccional;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * This program demonstrates using JPA annotations in Hibernate in order to
 * implement a one-to-many association mapping.
 * 
 * @author www.codejava.net
 *
 */
public class FutbolManager {

	public static void main(String[] args) {

		// loads configuration and mappings
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder();
		registry.applySettings(configuration.getProperties());
		registry.build();

		// obtains the session
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		

		Jugador jugador1= new Jugador();
		Integer userID=jugador1.getId();
		/*
		 jugador1 =(Jugador) session.get(Jugador.class, userID);
		 System.out.println(jugador.getUserName()+"----"+jugador.getUserMessage);
		
		 jugador1 =(Jugador) session.load(Jugador.class, userID);
		*/
		
		session.close();
	}
}