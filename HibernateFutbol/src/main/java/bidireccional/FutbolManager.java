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

		/*
		Equipo equipo = new Equipo();
		Entrenador entrenador = new Entrenador();

		entrenador.setNombre("paco");

		equipo.setNombre("a");
		equipo.setCiudad("madrid");
		equipo.setEntrenador(entrenador);

		session.save(entrenador);
		session.save(equipo);

		session.getTransaction().commit();
		*/
		session.close();
	}
}