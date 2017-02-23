package hotel.client.presentation;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistance.Hotel;
import services.AdminHotel;
import services.IAdminHotelRemote;

public class SupprimerHotel {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		IAdminHotelRemote proxy = (IAdminHotelRemote) context
				.lookup("gestion.hotel-ear/gestion.hotel-ejb/AdminHotel!services.IAdminHotelRemote");
		Hotel hotel = new Hotel();
		hotel.setId(8);
		proxy.supprimerHotel(hotel);

	}
}
