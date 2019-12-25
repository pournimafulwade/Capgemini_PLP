package com.capgemini.hotelbookingmanagement.dao;

import java.util.List;

import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.beans.UserBean;
import com.capgemini.hotelbookingmanagement.customexeption.HotelException;

public interface UserDAO {
	public UserBean userLogin(String userEmail, String userPassword)throws HotelException;

	public boolean userRegister(UserBean userBean)throws HotelException;

	List<HotelBean> getAllHotel()throws HotelException;

	public List<HotelBean> getHotel(String location) throws HotelException;

//	HotelBean getHotel(String hotelName);

	public boolean updateUserProfile(UserBean userBean)throws HotelException;
	
//	public boolean updateUserProfile(String userPassword, String mobile, String address);

	public boolean booking(int userId, int roomId, int hotelId)throws HotelException;

	boolean booking1(int userId, int roomId, int hotelId)throws HotelException;

	public double bill(int userId)throws HotelException;

}// end of the UserDAO interface