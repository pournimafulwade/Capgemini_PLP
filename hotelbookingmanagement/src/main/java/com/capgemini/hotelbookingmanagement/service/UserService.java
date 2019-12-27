package com.capgemini.hotelbookingmanagement.service;

import java.util.List;

import com.capgemini.hotelbookingmanagement.beans.BookingBean;
import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.beans.UserBean;
import com.capgemini.hotelbookingmanagement.customexeption.HotelException;

public interface UserService {
	public UserBean userLogin(String userEmail, String userPassword);

	public boolean userRegister(UserBean userBean);

//	List<HotelBean> getAllHotel();

//	public List<HotelBean> getHotel(String location);

	public boolean updateUserProfile(UserBean userBean);

//	public boolean booking(BookingBean bookingBean);

//	boolean booking1(BookingBean bookingBean);

//	public double bill(int userId);

//	public float countOfDay(String checkinDate,String checkoutDate);

	public int countOfUser(String userType) throws HotelException;

	public List<UserBean> getAllUser() throws HotelException;
}// end of the UserService interface
