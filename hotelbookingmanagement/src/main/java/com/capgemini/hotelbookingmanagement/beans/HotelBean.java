package com.capgemini.hotelbookingmanagement.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hotel")
public class HotelBean {
	@Id
	@Column
	private int hotelId;
	@Column
	private String hotelName;
	@Column
	private String location;
	
	//getters and setters
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
	
	@Override
	public String toString() {
		return "HotelBean [hotelName=" + hotelName + ", location=" + location + "]";
	}
}//end of the HotelBean
