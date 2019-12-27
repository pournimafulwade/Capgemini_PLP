package com.capgemini.hotelbookingmanagement.dao;

import java.util.Date;
import java.util.List;

import com.capgemini.hotelbookingmanagement.beans.BookingBean;
import com.capgemini.hotelbookingmanagement.customexeption.HotelException;

public interface BookingDAO {
	public List<BookingBean> bookingList() throws HotelException;

	public List<BookingBean> guestListOfSpecificHotel(int hotelId) throws HotelException;

	public List<BookingBean> bookingListOnSpecificDate(Date checkinDate) throws HotelException;

	public BookingBean viewBookingStatus(String userName) throws HotelException;

	public float countOfDay(String checkinDate, String checkoutDate) throws HotelException;

	public boolean booking(BookingBean bookingBean) throws HotelException;

	boolean booking1(BookingBean bookingBean) throws HotelException;
	
	public double bill(int userId);

}
