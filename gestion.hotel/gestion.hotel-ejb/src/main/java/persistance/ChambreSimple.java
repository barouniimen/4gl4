package persistance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="C_S")
public class ChambreSimple extends Chambre {
	private Boolean avecBalcon;

	public Boolean getAvecBalcon() {
		return avecBalcon;
	}

	public void setAvecBalcon(Boolean avecBalcon) {
		this.avecBalcon = avecBalcon;
	}

}
