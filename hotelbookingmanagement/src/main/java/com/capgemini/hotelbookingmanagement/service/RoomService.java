package com.capgemini.hotelbookingmanagement.service;

import java.util.List;

import com.capgemini.hotelbookingmanagement.beans.RoomBean;

public interface RoomService {
	public boolean addRoom(RoomBean roomBean);

	public boolean deleteRoom(int roomId);

	public boolean updateRoom(RoomBean roomBean);

	public List<RoomBean> getRoom(String hotelName);

	public boolean deleteHotelRoom(int hotelId);


}
