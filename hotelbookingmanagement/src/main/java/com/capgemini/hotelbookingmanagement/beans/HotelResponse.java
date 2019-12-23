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
	private UserBean userBean;
	private HotelBean hotelBean1;
	private List<UserBean> userList;
	private  List<BookingBean>  bookingList;
	private BookingBean bookingBean;
	private double price;

	// getters and setters
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

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public HotelBean getHotelBean1() {
		return hotelBean1;
	}

	public void setHotelBean1(HotelBean hotelBean1) {
		this.hotelBean1 = hotelBean1;
	}

	public List<UserBean> getUserList() {
		return userList;
	}

	public void setUserList(List<UserBean> userList) {
		this.userList = userList;
	}
	public List<BookingBean> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<BookingBean> bookingList) {
		this.bookingList = bookingList;
	}

	public BookingBean getBookingBean() {
		return bookingBean;
	}

	public void setBookingBean(BookingBean bookingBean) {
		this.bookingBean = bookingBean;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}// end of the HotelResponse class