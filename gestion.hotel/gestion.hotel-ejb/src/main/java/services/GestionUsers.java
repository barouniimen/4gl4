package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import persistance.Agence;
import persistance.Personne;

@Stateless
public class GestionUsers implements IGestionUsers {

	@PersistenceContext
	EntityManager em;

	@Override
	public Personne authentifier(String login, String pwd) {
		TypedQuery<Personne> query = em.createQuery("Select p from Personne p where p.login=:login and p.password=:pwd",
				Personne.class);
		query.setParameter("login", login);
		query.setParameter("pwd", pwd);
		return query.getSingleResult();
	}

	@Override
	public boolean managerHasAgency(String cinManager) {
		TypedQuery<Agence> query = em.createQuery("select a from Agence a where a.manager.cin=:cin", Agence.class);
		query.setParameter("cin", cinManager);
		if(query.getSingleResult()!=null){
			return true;
		}
		return false;
	}

}
