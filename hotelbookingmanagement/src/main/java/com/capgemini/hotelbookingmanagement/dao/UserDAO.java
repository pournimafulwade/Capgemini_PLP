package com.capgemini.hotelbookingmanagement.dao;

import java.util.List;

import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.beans.UserBean;

public interface UserDAO {
	public UserBean userLogin(String userEmail, String userPassword);

	public boolean userRegister(UserBean userBean);

	List<HotelBean> getAllHotel();

	public List<HotelBean> getHotel(String location);

//	HotelBean getHotel(String hotelName);

	public boolean updateUserProfile(UserBean userBean);

	public boolean booking(int userId, int roomId, int hotelId);

	boolean booking1(int userId, int roomId, int hotelId);

	public double bill(int userId);

}// end of the UserDAO interface