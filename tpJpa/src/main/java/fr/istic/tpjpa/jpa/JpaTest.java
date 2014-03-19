package fr.istic.tpjpa.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
		JpaTest test = new JpaTest(manager);

//		EntityTransaction tx = manager.getTransaction();
//		tx.begin();
//
//		Home home=new Home();
//		home.setAdresse("rennes");
//		home.setSuperficie("150"); 
//		home.setAdresseIp("8.8.8.8");
//
//		
//
//		List <Home> listeMaison = new ArrayList<Home>();
//		listeMaison.add(home);
//		Person person=new Person();
//		person.setNom("Mame");
//		person.setPrenom("Sylla");
//		person.setHome(listeMaison);
//		home.setPersonne(person);
//		manager.persist(home);
//		manager.persist(person);
//
//		tx.commit();
//
//		// TODO run request
//
//		System.out.println(".. done");
		
		EntityTransaction tx = manager.getTransaction();

        tx.begin();

        try {

            test.createHome();

        } catch (Exception e) {

            e.printStackTrace();

        }

        tx.commit();

        test.listPersonnes();

           

       manager.close();

        System.out.println(".. done");
		
		
	}
	
	
	private void createHome(){
		
		int numberHome = manager.createQuery("Select h From Home h", Home.class).getResultList().size();

        if (numberHome == 0) {

            Person person = new Person("Fidy");

            manager.persist(person);

            manager.persist(new Home("Saint Anne",person));

            manager.persist(new Home("Rennes",person));

        }
		
		
		
	}
	
	
	
	private void listPersonnes() {

        List<Home> resultList = manager.createQuery("Select h From Home h", Home.class).getResultList();

        System.out.println("number of houses:" + resultList.size());

        for (Home next : resultList) {

            System.out.println("next home: " + next.getAdresse());

        }
	
	}
	private void listPersonnesByGenre(Boolean genre) {

		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		// assuming a is an Integer  
		// if returning multiple fields, look into using a Tuple 
//		    or specifying the return type as an Object or Object[]
		
		CriteriaQuery<Boolean> query = criteriaBuilder.createQuery(Boolean.class);
		//Root<Person.class> from = query.from(Person.class);
//		query.select(from.get("genre")).where(from.get("genre").equals(true));
		query.select(from.get("genre")).where(from.get("genre").equals(true));
	
	}
	
	
	
	

}
