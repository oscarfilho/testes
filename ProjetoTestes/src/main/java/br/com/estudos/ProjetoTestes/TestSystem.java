package br.com.estudos.ProjetoTestes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestSystem {

	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("ProjetoTestes");
	
	public static void main(String[] args) {

		addCustomer(1,"Oscar","Alfredo Filho");
		addCustomer(2,"Vera","Valentim Assuncao Alfredo");
		addCustomer(3,"Nome1","teste22");
		addCustomer(4,"Nome 4","Sobrenome");
		
		getCustomer(2);
		
		getCustomers();
		
		changeFName(3, "Nome alteradooooo");
		
		deleteCustomer(4);
		
		
		ENTITY_MANAGER_FACTORY.close();
	}
	
	private static void addCustomer(int id, String fname, String lname) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		EntityTransaction et = null;
		
		try {
			et = em.getTransaction();
			et.begin(); 
			
			Customer cust = new Customer();
			cust.setID(id);
			cust.setfName(fname);
			cust.setlName(lname);
			
			em.persist(cust);
			
			et.commit();
		}catch (Exception e) {
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	
	private static void getCustomer(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		String query = "SELECT c FROM Customer c WHERE c.id = :custID";
		
		TypedQuery<Customer> tq = em.createQuery(query, Customer.class);
		tq.setParameter("CustID", id);
		
		Customer cust = null;
		
		try {
			cust = tq.getSingleResult();
			System.out.println(cust.getfName() + " " +
				cust.getfName());
		}catch (NoResultException e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	
	private static void getCustomers() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		String strQuery = "SELECT c FROM Customer c WHERE c.id IS NOT NULL";
		
		TypedQuery<Customer> tq = em.createQuery(strQuery, Customer.class);
		List<Customer> custs;
		
		try {
			custs = tq.getResultList();
			custs.forEach(cust->System.out.println(cust.getfName() +
					cust.getlName()));
			
		}catch (NoResultException e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	
	private static void changeFName(int id, String fname) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		
		Customer cust = null;
		
		try {
			et = em.getTransaction();
			
			et.begin();
			cust = em.find(Customer.class, id);
			cust.setfName(fname);

			em.persist(cust);
			et.commit();
			
		}catch (NoResultException e) {
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	
	private static void deleteCustomer(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		
		Customer cust = null;
		
		try {
			et = em.getTransaction();
			
			et.begin();
			cust = em.find(Customer.class, id);
			em.remove(cust);
			em.persist(cust);

			et.commit();
			
		}catch (NoResultException e) {
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}
}
