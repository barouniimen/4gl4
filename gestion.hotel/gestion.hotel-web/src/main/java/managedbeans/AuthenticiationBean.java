package managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import persistance.Client;
import persistance.Manager;
import persistance.Personne;
import services.IGestionUsers;

@ManagedBean
@SessionScoped
public class AuthenticiationBean {

	private String login;
	private String password;
	private Personne personne;
	@EJB
	private IGestionUsers gestionUsers;

	public String login() {
		personne = gestionUsers.authentifier(login, password);
		if (personne != null) {
			if (personne instanceof Client) {
				return "client/home?faces-redirect=true";
			} else if (personne instanceof Manager) {
				if(gestionUsers.managerHasAgency(personne.getCin())==true){
					return "manager/affecterHotels?faces-redirect=true";
				}
				else
				return "manager/createAgency?faces-redirect=true";
			} else
				return "login";
		} else
			return "login";
	}

	public IGestionUsers getGestionUsers() {
		return gestionUsers;
	}

	public void setGestionUsers(IGestionUsers gestionUsers) {
		this.gestionUsers = gestionUsers;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

}
