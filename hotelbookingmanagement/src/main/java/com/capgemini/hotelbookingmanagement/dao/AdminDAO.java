package com.capgemini.hotelbookingmanagement.dao;

import java.util.Date;
import java.util.List;

import com.capgemini.hotelbookingmanagement.beans.BookingBean;
import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.beans.RoomBean;
import com.capgemini.hotelbookingmanagement.beans.UserBean;
import com.capgemini.hotelbookingmanagement.customexeption.HotelException;

public interface AdminDAO {
	public boolean addHotel(HotelBean hotelBean)throws HotelException;

	public boolean removeHotel(int hotelId)throws HotelException;

	public boolean updateHotel(HotelBean hotelBean)throws HotelException;

	public List<HotelBean> getHotelList()throws HotelException;

	public List<UserBean> getAllUser()throws HotelException;
	
	public List<UserBean> getAllEmployee();

	public boolean addRoom(RoomBean roomBean)throws HotelException;

	public boolean deleteRoom(int roomId)throws HotelException;

	public boolean updateRoom(RoomBean roomBean)throws HotelException;

	public List<RoomBean> getRoom(String hotelName)throws HotelException;

	public List<BookingBean> bookingList()throws HotelException;

	public List<BookingBean> guestListOfSpecificHotel(int hotelId)throws HotelException;

	public List<BookingBean> bookingListOnSpecificDate(Date checkinDate)throws HotelException;

	public BookingBean viewBookingStatus(String userName)throws HotelException;
	
	public boolean deleteHotelRoom(int hotelId) throws HotelException;
	
	public int countOfUser(String userType) throws HotelException;

}// end of the AdminDAO Interface
