package managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import persistance.Hotel;
import services.IAdminHotelLocal;

@ManagedBean
@ViewScoped
public class ManageHotels {

	private List<Hotel> hotels;
	@EJB
	IAdminHotelLocal adminHotelLocal;
	private Hotel hotel;

	private Boolean renderUpdateForm = false;

	
	@PostConstruct
	public void init() {
		hotel = new Hotel();
		hotels = new ArrayList<>();
		hotels = adminHotelLocal.recupererListHotels();
	}

	public String supprimerHotel() {
		adminHotelLocal.supprimerHotel(hotel);
		return "";
	}

	public String updateHotel() {
		System.out.println(hotel.getId());
		adminHotelLocal.modifierHotel(hotel);
		return "manager/affecterHotels?faces-redirect=true";
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Boolean getRenderUpdateForm() {
		return renderUpdateForm;
	}

	public void setRenderUpdateForm(Boolean renderUpdateForm) {
		this.renderUpdateForm = renderUpdateForm;
	}

}
