package org.hibernate.bugs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	// Entities are auto-discovered, so just add them anywhere on class-path
	// Add your tests, using standard JUnit.
	@Test
	public void hhh123Test() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		Entity1 entity1 = new Entity1("key");
		entityManager.persist( entity1 );

		Property property1 = new Property("admin");
		entityManager.persist( property1 );

		Property property2 = new Property("name");
		entityManager.persist( property2 );

		Entity2 entity2 = new Entity2("key", Arrays.asList(property1, property2));
		entityManager.persist( entity2 );

		List<Object[]> results = entityManager.createQuery(
						"select e1, e2 " +
						"from Entity1 e1 " +
						"left join Entity2 e2 on e1.uuid = e2.uuid and exists (" +
						"select 1 from e2.properties p where p.name = :propertyName)")
				.setParameter("propertyName", "admin")
				.getResultList();
		assertEquals(1, results.size());

		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
