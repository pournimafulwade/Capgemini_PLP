package com.capgemini.hotelbookingmanagement.service;

import java.util.List;

import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.beans.RoomBean;

public interface AdminService {

	public boolean addHotel(HotelBean hotelBean);
	public boolean removeHotel(int hotelId);
	public boolean updateHotel(HotelBean hotelBean);
	public List<HotelBean> getHotelList();
	public boolean addRoom(RoomBean roomBean);
	public boolean deleteRoom(int roomId);
	public boolean updateRoom(RoomBean roomBean);
	public List<RoomBean> getRoom(String hotelName);
}
