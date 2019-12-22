package com.capgemini.hotelbookingmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.beans.RoomBean;
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

	@Override
	public List<RoomBean> getHotel(String hotelName) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public HotelBean getHotel(String hotelName) {
//		return userDAO.getHotel(hotelName);
//	}

}//end of the UserServiceImple class
