package com.capgemini.hotelbookingmanagement.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelResponse {
	
	private int statusCode;
	private String message;
	private String description;
	private List<HotelBean> hotelList;
	private List<RoomBean> roomList;
	private List<RoomBean> hotelBean;
//	private List<UserBean> userList;
	
	//getters and setters 
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<HotelBean> getHotelList() {
		return hotelList;
	}
	public void setHotelList(List<HotelBean> hotelList) {
		this.hotelList = hotelList;
	}
	public List<RoomBean> getHotelBean() {
		return hotelBean;
	}
	public void setHotelBean(List<RoomBean> hotelBean) {
		this.hotelBean = hotelBean;
	}
	public List<RoomBean> getRoomList() {
		return roomList;
	}
	public void setRoomList(List<RoomBean> roomList) {
		this.roomList = roomList;
	}
}//end of the HotelResponse class