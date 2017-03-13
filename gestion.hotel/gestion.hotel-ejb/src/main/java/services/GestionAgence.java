package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import persistance.Agence;
import persistance.Manager;

@Stateless
public class GestionAgence implements IGestionAgenceLocal {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Agence ajouterAgence(Agence agence) {
		// TODO Auto-generated method stub
		em.persist(agence);
		return agence;
	}

	@Override
	public void affecterAgenceManager(Agence agence, Manager manager) {
		manager = em.find(Manager.class, manager.getCin());
		manager.setAgence(agence);
		
	}
	

}
