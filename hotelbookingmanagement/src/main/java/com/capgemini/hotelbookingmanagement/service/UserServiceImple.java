package com.capgemini.hotelbookingmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelbookingmanagement.beans.BookingBean;
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
		return userDAO.userLogin(userEmail, userPassword);
	}

	@Override
	public boolean userRegister(UserBean userBean) {
		return userDAO.userRegister(userBean);
	}

//	@Override
//	public List<HotelBean> getAllHotel() {
//		return userDAO.getAllHotel();
//	}

//	@Override
//	public List<HotelBean> getHotel(String location) {
//		return userDAO.getHotel(location);
//	}

	@Override
	public boolean updateUserProfile(UserBean userBean) {
		return userDAO.updateUserProfile(userBean);
	}

	@Override
	public int countOfUser(String userType) throws HotelException {
		return userDAO.countOfUser(userType);
	}

	@Override
	public List<UserBean> getAllUser() throws HotelException {
		return userDAO.getAllUser();
	}

//	@Override
//	public boolean booking(BookingBean bookingBean) {
//		return userDAO.booking(bookingBean);
//	}

//	@Override
//	public boolean booking1(BookingBean bookingBean) {
//		return userDAO.booking1(bookingBean);
//	}

//	@Override
//	public double bill(int userId) {
//		return userDAO.bill(userId);
//	}

//	@Override
//	public float countOfDay(String checkinDate, String checkoutDate) {
//		return userDAO.countOfDay(checkinDate, checkoutDate);
//	}
}// end of the UserServiceImple class
