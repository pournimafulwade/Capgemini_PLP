package com.capgemini.hotelbookingmanagement.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "hotel")
public class HotelBean {
	@Id
	@Column
	private int hotelId;
	@Column
	@NotBlank(message = "Hotel Name cannot be Empty!!")
	private String hotelName;
	@Column
	@NotBlank(message = "Hotel Location cannot be Empty!!")
	private String location;
	@Column
	private String imgURL;

	// getters and setters
	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	@Override
	public String toString() {
		return "HotelBean [hotelName=" + hotelName + ", location=" + location + "]";
	}
}// end of the HotelBean
