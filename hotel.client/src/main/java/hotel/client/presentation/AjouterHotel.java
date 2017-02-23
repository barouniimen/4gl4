package hotel.client.presentation;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistance.Adress;
import persistance.Hotel;
import persistance.NombreEtoiles;
import services.IAdminHotelRemote;

public class AjouterHotel {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		IAdminHotelRemote proxy = (IAdminHotelRemote) context
				.lookup("gestion.hotel-ear/gestion.hotel-ejb/AdminHotel!services.IAdminHotelRemote");
		Hotel hotel = new Hotel();
		hotel.setNom("palace");
		hotel.setEtoiles(NombreEtoiles.deux);
		proxy.ajouterHotel(hotel);
		
	}

}
