package services;

import javax.ejb.Local;

import persistance.Agence;
import persistance.Manager;

@Local
public interface IGestionAgenceLocal {

	Agence ajouterAgence(Agence agence);

	void affecterAgenceManager(Agence agence, Manager manager);

}
