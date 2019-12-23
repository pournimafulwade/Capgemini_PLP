package com.capgemini.hotelbookingmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.beans.UserBean;
import com.capgemini.hotelbookingmanagement.dao.UserDAO;

@Service
public class UserServiceImple implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public UserBean userLogin(String userEmail, String userPassword) {
		return userDAO.userLogin(userEmail, userPassword);
	}

	@Override
	public boolean userRegister(UserBean userBean) {
		return userDAO.userRegister(userBean);
	}

	@Override
	public List<HotelBean> getAllHotel() {
		return userDAO.getAllHotel();
	}

//	@Override
//	public HotelBean getHotel(String hotelName) {
//		return userDAO.getHotel(hotelName);
//	}

	@Override
	public boolean updateUserProfile(UserBean userBean) {
		return userDAO.updateUserProfile(userBean);
	}

	@Override
	public List<HotelBean> getHotel(String location) {
		return userDAO.getHotel(location);
	}

	@Override
	public boolean booking(int userId, int roomId, int hotelId) {
		return userDAO.booking(userId, roomId, hotelId);
	}

	@Override
	public boolean booking1(int userId, int roomId, int hotelId) {
		return userDAO.booking1(userId, roomId, hotelId);
	}

	@Override
	public double bill(int userId) {
		return userDAO.bill(userId);
	}
}// end of the UserServiceImple class
