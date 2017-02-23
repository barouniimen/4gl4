package hotel.client.presentation;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistance.Chambre;
import persistance.Hotel;
import persistance.NombreEtoiles;
import services.IAdminHotelRemote;

public class ListerHotelsParNomEtNbreEtoiles {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		IAdminHotelRemote adminHotelRemote = (IAdminHotelRemote) context
				.lookup("gestion.hotel-ear/gestion.hotel-ejb/AdminHotel!services.IAdminHotelRemote");
		List<Hotel> hotels = adminHotelRemote.chercherParNomEtEtoiles("palace", NombreEtoiles.deux);

		for (Hotel hotel : hotels) {
			System.out.println(hotel.getNom());
		}
	}
}
