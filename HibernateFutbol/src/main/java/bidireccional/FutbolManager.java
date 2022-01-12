package bidireccional;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * This program demonstrates using JPA annotations in Hibernate in order to
 * implement a one-to-many association mapping.
 * 
 * @author www.codejava.net
 *
 */
public class FutbolManager {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		// loads configuration and mappings
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder();
		registry.applySettings(configuration.getProperties());
		registry.build();

		// obtains the session
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();

		Jugador jugador1 = new Jugador(25, 5, "Pedro");

		session.save(jugador1);

		Integer jugadorID = jugador1.getId();

		t.commit();

		jugador1 = (Jugador) session.get(Jugador.class, jugadorID);
		System.out.println(jugador1.getNombre() + "----" + jugador1.getId());

		jugador1 = (Jugador) session.load(Jugador.class, jugadorID);
		System.out.println(jugador1.getNombre() + "####" + jugador1.getId());

		Query query = session.createNativeQuery("SELECT jugador.nombre, jugador.id FROM jugador");
		List<Object[]> result = query.getResultList();

		for (Object[] Jugadores : result) {

			System.out.println("Jugador " + Jugadores[0] + " " + Jugadores[1]);

		}

		session.close();
	}
}