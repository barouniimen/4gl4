package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import persistance.Chambre;
import persistance.Hotel;
import persistance.NombreEtoiles;

@Stateless
public class AdminHotel implements IAdminHotelRemote {

	@PersistenceContext
	EntityManager em;

	@Override
	public void ajouterHotel(Hotel hotel) {
		em.persist(hotel);
	}

	@Override
	public void supprimerHotel(Hotel hotel) {
		// solution 1- supprimer chambre manuellement

		hotel = em.find(Hotel.class, hotel.getId());
		// il faut supprimer le bout master d'abord
		// for (Chambre c : hotel.getChambres()) {
		// em.remove(c);
		// }

		// solution 2- rajouter cascade=CascadeType.REMOVE au niveau de
		// la liste de chambres au niveau de Hotel

		// solution 3- Détacher les chambres et les garder dans la BD
		for (Chambre c : hotel.getChambres()) {
			c.setHotel(null);
			em.merge(c);
			// sans cascade
		}
		em.remove(hotel);

	}

	@Override
	public void modifierHotel(Hotel hotel) {
		em.merge(hotel);

	}

	@Override
	public void affecterChambre(Hotel hotel, Chambre chambre) {
		// //ajouter la chambre la BD
		// em.persist(chambre);
		//
		// //récupérer la liste des chambres
		// List<Chambre> chambres = hotel.getChambres();
		// chambres.add(chambre);
		// hotel.setChambres(chambres);
		// //update hotel
		// em.merge(hotel);

		// chambre est le bout master, on doit donc affecter l'hotel à la
		// chambre
		// et non l'inverse
		em.persist(chambre);
		chambre.setHotel(hotel);

	}

	@Override
	public Hotel chercherHotel(int id) {

		return em.find(Hotel.class, id);
	}

	@Override
	public List<Hotel> recupererListHotels() {
		TypedQuery<Hotel> query = em.createQuery("select h from Hotel h", Hotel.class);
		return query.getResultList();
	}

	@Override
	public List<Hotel> chercherHotelParNom(String nom) {
		TypedQuery<Hotel> query = em.createNamedQuery("byname", Hotel.class);
		query.setParameter("nom", nom);
		return query.getResultList();
	}

	@Override
	public List<Hotel> chercherParNomEtEtoiles(String nom, NombreEtoiles e) {
		TypedQuery<Hotel> query = em.createNamedQuery("bynameAndEtoiles", Hotel.class);
		query.setParameter("nom", nom);
		query.setParameter("e", e);

		return query.getResultList();
	}

	@Override
	public List<Hotel> chercherParCodePostal(int code) {
		// TODO Auto-generated method stub
		return null;
	}

}
