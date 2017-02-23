package services;

import java.util.List;

import javax.ejb.Remote;

import persistance.Chambre;
import persistance.Hotel;
import persistance.NombreEtoiles;

@Remote
public interface IAdminHotelRemote {

	void ajouterHotel(Hotel hotel);

	void supprimerHotel(Hotel hotel);

	void modifierHotel(Hotel hotel);

	void affecterChambre(Hotel hotel, Chambre chambre);

	Hotel chercherHotel(int id);

	List<Hotel> recupererListHotels();

	List<Hotel> chercherHotelParNom(String nom);

	List<Hotel> chercherParNomEtEtoiles(String nom, NombreEtoiles e);

	List<Hotel> chercherParCodePostal(int code);
}
