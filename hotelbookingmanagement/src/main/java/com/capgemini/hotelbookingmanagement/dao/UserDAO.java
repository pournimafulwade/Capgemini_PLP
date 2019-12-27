package com.capgemini.hotelbookingmanagement.dao;

import java.util.List;

import com.capgemini.hotelbookingmanagement.beans.BookingBean;
import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.beans.UserBean;
import com.capgemini.hotelbookingmanagement.customexeption.HotelException;

public interface UserDAO {
	public UserBean userLogin(String userEmail, String userPassword) throws HotelException;

	public boolean userRegister(UserBean userBean) throws HotelException;

//	List<HotelBean> getAllHotel() throws HotelException;

//	public List<HotelBean> getHotel(String location) throws HotelException;

	public boolean updateUserProfile(UserBean userBean) throws HotelException;

//	public boolean booking(BookingBean bookingBean) throws HotelException;

//	boolean booking1(BookingBean bookingBean) throws HotelException;

//	public double bill(int userId) throws HotelException;

//	public float countOfDay(String checkinDate, String checkoutDate) throws HotelException;

	public int countOfUser(String userType) throws HotelException;

	public List<UserBean> getAllUser() throws HotelException;

}// end of the UserDAO interface