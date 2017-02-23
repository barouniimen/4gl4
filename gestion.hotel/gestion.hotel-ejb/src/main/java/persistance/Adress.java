package persistance;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Adress implements Serializable{

	private String cite;
	private Integer codePostal;
	private String ville;
	
	public String getCite() {
		return cite;
	}
	public void setCite(String cite) {
		this.cite = cite;
	}
	public Integer getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
}
