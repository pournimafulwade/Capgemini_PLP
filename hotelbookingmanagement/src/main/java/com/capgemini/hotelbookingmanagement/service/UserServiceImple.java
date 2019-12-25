package com.capgemini.hotelbookingmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.beans.UserBean;
import com.capgemini.hotelbookingmanagement.customexeption.HotelException;
import com.capgemini.hotelbookingmanagement.dao.UserDAO;

@Service
public class UserServiceImple implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public UserBean userLogin(String userEmail, String userPassword) {
		try {
			return userDAO.userLogin(userEmail, userPassword);
		} catch (HotelException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean userRegister(UserBean userBean) {
		try {
			return userDAO.userRegister(userBean);
		} catch (HotelException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<HotelBean> getAllHotel() {
		try {
			return userDAO.getAllHotel();
		} catch (HotelException e) {
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public HotelBean getHotel(String hotelName) {
//		return userDAO.getHotel(hotelName);
//	}

	@Override
	public boolean updateUserProfile(UserBean userBean) {
		try {
			return userDAO.updateUserProfile(userBean);
		} catch (HotelException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<HotelBean> getHotel(String location) {
		try {
			return userDAO.getHotel(location);
		} catch (HotelException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean booking(int userId, int roomId, int hotelId) {
		try {
			return userDAO.booking(userId, roomId, hotelId);
		} catch (HotelException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean booking1(int userId, int roomId, int hotelId) {
		try {
			return userDAO.booking1(userId, roomId, hotelId);
		} catch (HotelException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public double bill(int userId) {
		try {
			return userDAO.bill(userId);
		} catch (HotelException e) {
			e.printStackTrace();
		}
		return userId;
	}

//	@Override
//	public boolean updateUserProfile(String userPassword, String mobile, String address) {
//		return userDAO.updateUserProfile(userPassword, mobile, address);
//	}
}// end of the UserServiceImple class
