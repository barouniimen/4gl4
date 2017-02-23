package persistance;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Client implements Serializable{
private String cin;
private String nom;
private String prenom;
private List<Reservation> reservation;
@Id
public String getCin() {
	return cin;
}
public void setCin(String cin) {
	this.cin = cin;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
@OneToMany(mappedBy="client")
public List<Reservation> getReservation() {
	return reservation;
}
public void setReservation(List<Reservation> reservation) {
	this.reservation = reservation;
}

}
