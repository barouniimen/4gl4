package persistance;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reservation implements Serializable{
private ReservationPk reservationPk;
private Client client;
private Hotel hotel;
@EmbeddedId
public ReservationPk getReservationPk() {
	return reservationPk;
}
public void setReservationPk(ReservationPk reservationPk) {
	this.reservationPk = reservationPk;
}
@ManyToOne
@JoinColumn(name="clientFk",insertable=false,updatable=false)
public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}
@ManyToOne
@JoinColumn(name="hotelFk",insertable=false,updatable=false)
public Hotel getHotel() {
	return hotel;
}
public void setHotel(Hotel hotel) {
	this.hotel = hotel;
}

}
