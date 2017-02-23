package persistance;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_hotel")
@NamedQueries({
	@NamedQuery(name="byname",query="select h from Hotel h where h.nom=:nom"),
	@NamedQuery(name="bycodePostal",query="select h from Hotel h where h.adress.codePostal=:c"),
	@NamedQuery(name="bynameAndEtoiles", query="select h from Hotel h where h.nom=:nom and h.etoiles=:e")
	
})
public class Hotel implements Serializable{


	private static final long serialVersionUID = 1L;
	private int id;
	private String nom;
	private NombreEtoiles etoiles;
	private Adress Adress;
	private List<Chambre> chambres;
	private List<Agence> agences;
	private List<Reservation> reservation;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "t_nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public NombreEtoiles getEtoiles() {
		return etoiles;
	}

	public void setEtoiles(NombreEtoiles etoiles) {
		this.etoiles = etoiles;
	}

	@Embedded
	public Adress getAdress() {
		return Adress;
	}

	public void setAdress(Adress adress) {
		Adress = adress;
	}

	@OneToMany(mappedBy="hotel", fetch=FetchType.EAGER)
	public List<Chambre> getChambres() {
		return chambres;
	}

	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}

	@ManyToMany(mappedBy="hotels")
	public List<Agence> getAgences() {
		return agences;
	}

	public void setAgences(List<Agence> agences) {
		this.agences = agences;
	}
@OneToMany(mappedBy="hotel")
	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

	

}
