package services;

import javax.ejb.Local;

import persistance.Personne;

@Local
public interface IGestionUsers {

	Personne authentifier(String login, String pwd);

	boolean managerHasAgency(String cinManager);
}
