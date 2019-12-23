package com.capgemini.hotelbookingmanagement.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelbookingmanagement.beans.BookingBean;
import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.beans.RoomBean;
import com.capgemini.hotelbookingmanagement.beans.UserBean;
import com.capgemini.hotelbookingmanagement.dao.AdminDAO;

@Service
public class AdminServiceImple implements AdminService {
	@Autowired
	private AdminDAO adminDAO;

	@Override
	public boolean addHotel(HotelBean hotelBean) {
		return adminDAO.addHotel(hotelBean);
	}

	@Override
	public boolean removeHotel(int hotelId) {
		return adminDAO.removeHotel(hotelId);
	}

	@Override
	public boolean updateHotel(HotelBean hotelBean) {
		return adminDAO.updateHotel(hotelBean);
	}

	@Override
	public List<HotelBean> getHotelList() {
		return adminDAO.getHotelList();
	}

	@Override
	public boolean addRoom(RoomBean roomBean) {
		return adminDAO.addRoom(roomBean);
	}

	@Override
	public boolean deleteRoom(int roomId) {
		return adminDAO.deleteRoom(roomId);
	}

	@Override
	public boolean updateRoom(RoomBean roomBean) {
		return adminDAO.updateRoom(roomBean);
	}

	@Override
	public List<RoomBean> getRoom(String hotelName) {
		return adminDAO.getRoom(hotelName);
	}

	@Override
	public List<UserBean> getAllUser() {
		return adminDAO.getAllUser();
	}

	@Override
	public List<BookingBean> bookingList() {
		return adminDAO.bookingList();
	}

	@Override
	public List<BookingBean> guestListOfSpecificHotel(int hotelId) {
		return adminDAO.guestListOfSpecificHotel(hotelId);
	}

	@Override
	public List<BookingBean> bookingListOnSpecificDate(Date checkinDate) {
		return adminDAO.bookingListOnSpecificDate(checkinDate);
	}

	@Override
	public BookingBean viewBookingStatus(String userName) {
		return adminDAO.viewBookingStatus(userName);
	}
}// end of the AdminServiceImple class
