package fr.istic.tpjpa.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.tpjpa.domain.Home;
import fr.istic.tpjpa.domain.Person;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		//JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		Home home=new Home();
		home.setAdresse("rennes");
		home.setSuperficie("150"); 
		home.setAdresseIp("8.8.8.8");
		
		manager.persist(home);
		 
		List <Home> listeMaison = new ArrayList<Home>();
		listeMaison.add(home);
		
	Person person=new Person();
	person.setNom("Mame");
	person.setHome(listeMaison);
	manager.persist(person);

		tx.commit();

		// TODO run request

		System.out.println(".. done");
	}

}
