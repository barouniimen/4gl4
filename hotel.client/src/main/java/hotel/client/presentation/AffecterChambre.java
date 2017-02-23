package hotel.client.presentation;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistance.Chambre;
import persistance.Hotel;
import services.IAdminHotelRemote;

public class AffecterChambre {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		IAdminHotelRemote adminHotelRemote = (IAdminHotelRemote) context
				.lookup("gestion.hotel-ear/gestion.hotel-ejb/AdminHotel!services.IAdminHotelRemote");
		
		Chambre chambre = new Chambre();
		chambre.setNumero(302);
		chambre.setDisponibilite(true);
		Hotel hotel = adminHotelRemote.chercherHotel(8);
		adminHotelRemote.affecterChambre(hotel, chambre);
		
	}
}
