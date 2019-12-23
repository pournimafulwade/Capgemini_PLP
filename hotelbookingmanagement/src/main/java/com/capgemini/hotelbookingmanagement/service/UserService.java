package com.capgemini.hotelbookingmanagement.service;

import java.util.List;

import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.beans.UserBean;

public interface UserService {
	public UserBean userLogin(String userEmail, String userPassword);

	public boolean userRegister(UserBean userBean);

	List<HotelBean> getAllHotel();

//	HotelBean getHotel(String hotelName);
	
	public List<HotelBean> getHotel(String location);

	public boolean updateUserProfile(UserBean userBean);
	
	public boolean booking(int userId, int roomId, int hotelId);

	boolean booking1(int userId, int roomId, int hotelId);

	public double bill(int userId);


}
