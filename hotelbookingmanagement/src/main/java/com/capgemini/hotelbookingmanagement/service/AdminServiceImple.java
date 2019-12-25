package com.capgemini.hotelbookingmanagement.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelbookingmanagement.beans.BookingBean;
import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.beans.RoomBean;
import com.capgemini.hotelbookingmanagement.beans.UserBean;
import com.capgemini.hotelbookingmanagement.customexeption.HotelException;
import com.capgemini.hotelbookingmanagement.dao.AdminDAO;

@Service
public class AdminServiceImple implements AdminService {
	@Autowired
	private AdminDAO adminDAO;

	@Override
	public boolean addHotel(HotelBean hotelBean) {
		try {
			return adminDAO.addHotel(hotelBean);
		} catch (HotelException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeHotel(int hotelId) {
		try {
			return adminDAO.removeHotel(hotelId);
		} catch (HotelException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateHotel(HotelBean hotelBean) {
		try {
			return adminDAO.updateHotel(hotelBean);
		} catch (HotelException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<HotelBean> getHotelList() {
		try {
			return adminDAO.getHotelList();
		} catch (HotelException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addRoom(RoomBean roomBean) {
		try {
			return adminDAO.addRoom(roomBean);
		} catch (HotelException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteRoom(int roomId) {
		try {
			return adminDAO.deleteRoom(roomId);
		} catch (HotelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateRoom(RoomBean roomBean) {
		try {
			return adminDAO.updateRoom(roomBean);
		} catch (HotelException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<RoomBean> getRoom(String hotelName) {
		try {
			return adminDAO.getRoom(hotelName);
		} catch (HotelException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserBean> getAllUser() {
		try {
			return adminDAO.getAllUser();
		} catch (HotelException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<BookingBean> bookingList() {
		try {
			return adminDAO.bookingList();
		} catch (HotelException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<BookingBean> guestListOfSpecificHotel(int hotelId) {
		try {
			return adminDAO.guestListOfSpecificHotel(hotelId);
		} catch (HotelException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<BookingBean> bookingListOnSpecificDate(Date checkinDate) {
		try {
			return adminDAO.bookingListOnSpecificDate(checkinDate);
		} catch (HotelException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BookingBean viewBookingStatus(String userName) {
		try {
			return adminDAO.viewBookingStatus(userName);
		} catch (HotelException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteHotelRoom(int hotelId) {
		try {
			return adminDAO.deleteHotelRoom(hotelId);
		} catch (HotelException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<UserBean> getAllEmployee() {
		return adminDAO.getAllEmployee();
	}

	@Override
	public int countOfUser(String userType) {
		try {
			return adminDAO.countOfUser(userType);
		} catch (HotelException e) {
			e.printStackTrace();
		}
		return 0;
	}
}// end of the AdminServiceImple class
