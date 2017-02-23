package persistance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="C_D")
public class ChambreDouble extends Chambre{
	private Boolean avecSalon;

	public Boolean getAvecSalon() {
		return avecSalon;
	}

	public void setAvecSalon(Boolean avecSalon) {
		this.avecSalon = avecSalon;
	}
}
