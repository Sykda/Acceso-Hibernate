package com.onetomany;

import java.util.HashSet;
import java.util.Set;

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
public class StockManager {

	public static void main(String[] args) {

		// loads configuration and mappings
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder();
		registry.applySettings(configuration.getProperties());
		registry.build();

		// obtains the session
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Category category = new Category("Computer");

		Product pc = new Product("DELL PC", "Quad-core PC", 1200, category);

		Product laptop = new Product("MacBook", "Apple High-end laptop", 2100, category);

		Product phone = new Product("iPhone 5", "Apple Best-selling smartphone", 499, category);

		Product tablet = new Product("iPad 3", "Apple Best-selling tablet", 1099, category);

		Set<Product> products = new HashSet<Product>();
		products.add(pc);
		products.add(laptop);
		products.add(phone);
		products.add(tablet);

		category.setProducts(products);

		session.save(category);

		session.getTransaction().commit();
		session.close();
	}
}