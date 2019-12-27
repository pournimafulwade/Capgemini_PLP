package com.capgemini.hotelbookingmanagement.dao;

import java.util.List;

import com.capgemini.hotelbookingmanagement.beans.RoomBean;
import com.capgemini.hotelbookingmanagement.customexeption.HotelException;

public interface RoomDAO {
	public boolean addRoom(RoomBean roomBean) throws HotelException;

	public boolean deleteRoom(int roomId) throws HotelException;

	public boolean updateRoom(RoomBean roomBean) throws HotelException;

	public List<RoomBean> getRoom(String hotelName) throws HotelException;

	public boolean deleteHotelRoom(int hotelId) throws HotelException;

}
