package persistance;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;
@Embeddable
public class ReservationPk implements Serializable{
private String clientFk;
private int hotelFk;
private Date dateDebut;
private Date dateFin;
public String getClientFk() {
	return clientFk;
}
public void setClientFk(String clientFk) {
	this.clientFk = clientFk;
}
public int getHotelFk() {
	return hotelFk;
}
public void setHotelFk(int hotelFk) {
	this.hotelFk = hotelFk;
}
public Date getDateDebut() {
	return dateDebut;
}
public void setDateDebut(Date dateDebut) {
	this.dateDebut = dateDebut;
}
public Date getDateFin() {
	return dateFin;
}
public void setDateFin(Date dateFin) {
	this.dateFin = dateFin;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((clientFk == null) ? 0 : clientFk.hashCode());
	result = prime * result + ((dateDebut == null) ? 0 : dateDebut.hashCode());
	result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
	result = prime * result + hotelFk;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ReservationPk other = (ReservationPk) obj;
	if (clientFk == null) {
		if (other.clientFk != null)
			return false;
	} else if (!clientFk.equals(other.clientFk))
		return false;
	if (dateDebut == null) {
		if (other.dateDebut != null)
			return false;
	} else if (!dateDebut.equals(other.dateDebut))
		return false;
	if (dateFin == null) {
		if (other.dateFin != null)
			return false;
	} else if (!dateFin.equals(other.dateFin))
		return false;
	if (hotelFk != other.hotelFk)
		return false;
	return true;
}

}
