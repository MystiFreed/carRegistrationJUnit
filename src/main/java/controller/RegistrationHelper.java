// Mysti Freed, mrfreed@dmacc.edu
// 10/2/2018
// This program is used in combination with CarRegistrationRun.java programs to add/adjust or delete a
// vehicle or owner to the MySQL Database webcarregistration via the auto_info and owner_info tables

package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.AutoInfo;
import model.OwnerInfo;
import model.RegistrationJunction;


public class RegistrationHelper {

	static EntityManagerFactory registrationfactory = Persistence.createEntityManagerFactory("WebCarRegistration");
	
	public void updateCombinedTable() {
		EntityManager em = registrationfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(em);
		em.getTransaction().commit();
		em.close();
	}
	/**
	 * This method closes down the EntityManager after the program is run
	 */
	public void cleanUp() {
		registrationfactory.close();
	}
	
	/**
	 * This method is used to add a vehicle to the database
	 * @param ai = AutoInfo object
	 */
	public void addVehicle(AutoInfo ai) {
		EntityManager af = registrationfactory.createEntityManager();
		af.getTransaction().begin();
		af.persist(ai);
		af.getTransaction().commit();
		af.close();
	}
	
	/**
	 * This method is used to add an owner to the database
	 * @param oi= OwnerInfo object
	 */
	public void addOwner(OwnerInfo oi) {
		EntityManager of = registrationfactory.createEntityManager();
		of.getTransaction().begin();
		of.persist(oi);
		of.getTransaction().commit();
		of.close();
	}
	
	public void setJunctionID(AutoInfo ai, OwnerInfo oi) {
		EntityManager rj = registrationfactory.createEntityManager();
		rj.getTransaction().begin();
		//rj.setProperty(AUTO_ID, ai.getId()); //SET PROPERTY?? VS PERSIST?
		//rj.setProperty(OWNER_ID, oi.getId());
		RegistrationJunction specificMatch = new RegistrationJunction(ai, oi);
		rj.persist(specificMatch); // rollback exception?
		rj.getTransaction().commit();
		rj.close();
	}
	
	/**
	 * This method is used to dispay all the vehicles in the database
	 * @return list of vehicles
	 */
	public List<AutoInfo> displayVehicles() {
		EntityManager af = registrationfactory.createEntityManager();
		TypedQuery<AutoInfo> typedQuery = af.createQuery("select ai from AutoInfo ai", AutoInfo.class);
		List<AutoInfo> displayAll = typedQuery.getResultList();
		af.close();
		return displayAll;
	}
	
	/**
	 * This method is used to update a vehicle in the database
	 * @param update AutoInfo object
	 */
	public void updateVehicle(AutoInfo update) {
		EntityManager af = registrationfactory.createEntityManager();
		af.getTransaction().begin();
		af.merge(update);
		af.getTransaction().commit();
		af.close();
	}
	
	/**
	 * This method is used to update an owner in the database
	 * @param update OwnerInfo object
	 */
	public void updateOwner(OwnerInfo update) {
		EntityManager of = registrationfactory.createEntityManager();
		of.getTransaction().begin();
		of.merge(update);
		of.getTransaction().commit();
		of.close();
	}
	
	/**
	 * This method is used to search the database by the VIN number
	 * @param vin = String
	 * @return list of AutoInfo objects
	 */
	public List<AutoInfo> searchByVin(String vin) {
		EntityManager af = registrationfactory.createEntityManager();
		af.getTransaction().begin();
		TypedQuery<AutoInfo> typedQuery = af.createQuery("select ai from AutoInfo ai where ai.vin = :selectedVin", AutoInfo.class);
		typedQuery.setParameter("selectedVin", vin);
		List<AutoInfo> foundVehicle = typedQuery.getResultList();
		af.close();
		return foundVehicle;
	}
	
	/**
	 * This method is used to search the database by owner last name
	 * @param lastName = String
	 * @return list of OwnerInfo objects
	 */
	public List<OwnerInfo> searchByLast(String lastName) {
		EntityManager of = registrationfactory.createEntityManager();
		of.getTransaction().begin();
		TypedQuery<OwnerInfo> typedQuery = of.createQuery("select oi from OwnerInfo oi where oi.lastName = :selectedLastName", OwnerInfo.class);
		typedQuery.setParameter("selectedLastName", lastName);
		List<OwnerInfo> foundName = typedQuery.getResultList();
		of.close();
		return foundName;
	}
	
	/**
	 * This method is used to search for a vehicle by the ID
	 * @param i = int ID
	 * @return AutoInfo object
	 */
	public AutoInfo searchByIDAuto(int i) {
		EntityManager af = registrationfactory.createEntityManager();
		af.getTransaction().begin();
		AutoInfo idFinder = af.find(AutoInfo.class, i);
		af.close();
		return idFinder;
	}
	
	/**
	 * This method is used to search for an owner by the ID
	 * @param o = int ID
	 * @return OwnerInfo object
	 */
	public OwnerInfo searchByIDOwner(int o) {
		EntityManager oi = registrationfactory.createEntityManager();
		oi.getTransaction().begin();
		OwnerInfo idFinder = oi.find(OwnerInfo.class, o);
		oi.close();
		return idFinder;
	}
	
	/**
	 * This method is used to remove a vehicle from the database, used in combination with the deleteOwner method below
	 * @param remove = AutoInfo object
	 */
	public void deleteVehicle(AutoInfo remove) {
		EntityManager af = registrationfactory.createEntityManager();
		af.getTransaction().begin();
		TypedQuery<AutoInfo> typedQuery = af.createQuery("select af from AutoInfo af where af.vin = :selectedVin", AutoInfo.class);
		typedQuery.setParameter("selectedVin", remove.getVin());
		typedQuery.setMaxResults(1);
		AutoInfo toRemove = typedQuery.getSingleResult();
		af.remove(toRemove);
		af.getTransaction().commit();
		af.close();
	}
	
	/**
	 * This method is used in combination with deleteVehicle method to remove an owner from the database
	 * @param remove = OwnerInfo object
	 */
	public void deleteOwner(OwnerInfo remove) {
		EntityManager oi = registrationfactory.createEntityManager();
		oi.getTransaction().begin();
		TypedQuery<OwnerInfo> typedQuery = oi.createQuery("select oi from OwnerInfo oi where oi.lastName = :selectedLastName", OwnerInfo.class);
		typedQuery.setParameter("selectedLastName", remove.getLastName());
		typedQuery.setMaxResults(1);
		OwnerInfo toRemove = typedQuery.getSingleResult();
		oi.remove(toRemove);
		oi.getTransaction().commit();
		oi.close();
	}
}
