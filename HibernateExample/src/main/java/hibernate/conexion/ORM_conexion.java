package hibernate.conexion;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ORM_conexion {

	public static void main(String[] args) {

		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			
			Transaction t = null;

			try {
				
				t = s.beginTransaction();

				User user1 = new User();
				user1.setId(1);
				user1.setUserName("Paco");
				user1.setUserMessage("Hello world from Pepe");
				s.save(user1);
				
				t.commit();

			} catch (Exception e) {
				e.printStackTrace(System.err);
				if (t != null) {
					t.rollback();
				}
			}
		}
	}

}