package com.capgemini.hotelbookingmanagement.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "room_info")
public class RoomBean {
	@Column
	@Id
	private int roomId;
	@Column
//	@Pattern(regexp = "\\d+\\.\\d+")
	private double roomRent;
	@Column
	private String roomType;
	@Column
//	@Pattern(regexp = "\\d{1,4}")
	private int roomCapacity;
	@Column
	private String roomStatus;
	@Column
//	@Pattern(regexp = "\\d{1,10}")
	private int hotelId;
	@Column
	private String imgURL;

	// getters and setters
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public double getRoomRent() {
		return roomRent;
	}

	public void setRoomRent(double roomRent) {
		this.roomRent = roomRent;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getRoomCapacity() {
		return roomCapacity;
	}

	public void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
}// end of the RoomBean class
