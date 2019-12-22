package com.capgemini.hotelbookingmanagement.dao;

import java.util.List;

import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.beans.RoomBean;
import com.capgemini.hotelbookingmanagement.beans.UserBean;

public interface UserDAO {
	public UserBean userLogin(String userEmail,String userPassword);
	public boolean userRegister(UserBean userBean);
	List<HotelBean> getAllHotel();
	HotelBean getHotel(String hotelName);
//	 List<RoomBean> getHotel(String hotelName);


}
