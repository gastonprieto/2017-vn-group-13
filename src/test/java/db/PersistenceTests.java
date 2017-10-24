package db;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

public abstract class PersistenceTests {
	
	protected EntityManager em = PerThreadEntityManagers.getEntityManager();
	
	@Before
	public void setUp() {
		em.getTransaction().begin();
	}
	
	@After
	public void tearDown() {
		em.getTransaction().rollback();
	}
}
