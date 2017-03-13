package managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import persistance.Agence;
import persistance.Manager;
import services.IGestionAgenceLocal;

@ManagedBean
@RequestScoped
public class ManageAgencyBean {

	private String name;

	@ManagedProperty(value = "#{authenticiationBean}")
	private AuthenticiationBean authBean;

	@EJB
	IGestionAgenceLocal agenceLocal;

	public String addAgency() {
		Agence agence = new Agence();
		agence.setNom(name);
		agence = agenceLocal.ajouterAgence(agence);
		agenceLocal.affecterAgenceManager(agence, (Manager) authBean.getPersonne());
		return "/manager/affecterHotels";
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AuthenticiationBean getAuthBean() {
		return authBean;
	}

	public void setAuthBean(AuthenticiationBean authBean) {
		this.authBean = authBean;
	}

}
