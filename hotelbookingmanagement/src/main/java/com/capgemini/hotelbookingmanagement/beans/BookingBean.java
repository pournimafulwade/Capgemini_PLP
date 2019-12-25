package com.capgemini.hotelbookingmanagement.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "booking_info")
public class BookingBean {
	@Id
	@Column
	private int bookingId;
	@Column
	private int roomId;
	@Column
	private int userId;
	@Column
	private double roomRent;
	@Column
	private String paymentStatus;
	@Column
	private String modeOfPayment;
	@Column
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	private Date checkinDate;
	@Column
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	private Date checkoutDate;
	@Column
	private int totalDays;
	@Column
	private int hotelId;
	@Column
	private String userName;
	@Column
	private String hotelName;

	// getters and setters

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getRoomRent() {
		return roomRent;
	}

	public void setRoomRent(double roomRent) {
		this.roomRent = roomRent;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public int getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
}// end of the BookingBean class
