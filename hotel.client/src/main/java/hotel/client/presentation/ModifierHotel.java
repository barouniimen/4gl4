package hotel.client.presentation;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistance.Adress;
import persistance.Hotel;
import persistance.NombreEtoiles;
import services.IAdminHotelRemote;

public class ModifierHotel {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		IAdminHotelRemote adminHotelRemote = (IAdminHotelRemote) context
				.lookup("gestion.hotel-ear/gestion.hotel-ejb/AdminHotel!services.IAdminHotelRemote");
		Hotel hotel = adminHotelRemote.chercherHotel(1);
		hotel.setNom("test");
		adminHotelRemote.modifierHotel(hotel);
	}
}
