package com.capgemini.hotelbookingmanagement.service;

import java.util.Date;
import java.util.List;

import com.capgemini.hotelbookingmanagement.beans.BookingBean;

public interface BookingService {
	public List<BookingBean> bookingList();

	public List<BookingBean> guestListOfSpecificHotel(int hotelId);

	public List<BookingBean> bookingListOnSpecificDate(Date checkinDate);

	public BookingBean viewBookingStatus(String userName);

	public float countOfDay(String checkinDate, String checkoutDate);

	public boolean booking(BookingBean bookingBean);

	boolean booking1(BookingBean bookingBean);

	public double bill(int userId);
}
