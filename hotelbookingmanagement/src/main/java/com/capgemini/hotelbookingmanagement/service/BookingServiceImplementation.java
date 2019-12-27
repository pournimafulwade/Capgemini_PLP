package com.capgemini.hotelbookingmanagement.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelbookingmanagement.beans.BookingBean;
import com.capgemini.hotelbookingmanagement.dao.BookingDAO;
@Service
public class BookingServiceImplementation implements BookingService {
	@Autowired
	private BookingDAO bookingDAO;
	@Override
	public List<BookingBean> bookingList() {
		return bookingDAO.bookingList();
	}

	@Override
	public List<BookingBean> guestListOfSpecificHotel(int hotelId) {
		return bookingDAO.guestListOfSpecificHotel(hotelId);
	}

	@Override
	public List<BookingBean> bookingListOnSpecificDate(Date checkinDate) {
		return bookingDAO.bookingListOnSpecificDate(checkinDate);
	}

	@Override
	public BookingBean viewBookingStatus(String userName) {
		return bookingDAO.viewBookingStatus(userName);
	}

	@Override
	public float countOfDay(String checkinDate, String checkoutDate) {
		return bookingDAO.countOfDay(checkinDate, checkoutDate);
	}

	@Override
	public boolean booking(BookingBean bookingBean) {
		return bookingDAO.booking(bookingBean);
	}

	@Override
	public boolean booking1(BookingBean bookingBean) {
		return bookingDAO.booking1(bookingBean);
	}

	@Override
	public double bill(int userId) {
		// TODO Auto-generated method stub
		return bookingDAO.bill(userId);
	}

}
