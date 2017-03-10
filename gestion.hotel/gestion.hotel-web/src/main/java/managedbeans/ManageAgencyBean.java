package managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import persistance.Agence;
import services.IGestionAgenceLocal;

@ManagedBean
@RequestScoped
public class ManageAgencyBean {

	private String name;

	@EJB
	IGestionAgenceLocal agenceLocal;
	public String addAgency(){
		Agence agence = new Agence();
		agence.setNom(name);
		agenceLocal.ajouterAgence(agence);
		return "/manager/affecterHotels";
	}
	
	public String getName() {

		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
