package com.capgemini.hotelbookingmanagement.dao;

import java.util.Date;
import java.util.List;

import com.capgemini.hotelbookingmanagement.beans.BookingBean;
import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.beans.RoomBean;
import com.capgemini.hotelbookingmanagement.beans.UserBean;

public interface AdminDAO {
	public boolean addHotel(HotelBean hotelBean);

	public boolean removeHotel(int hotelId);

	public boolean updateHotel(HotelBean hotelBean);

	public List<HotelBean> getHotelList();

	public List<UserBean> getAllUser();

	public boolean addRoom(RoomBean roomBean);

	public boolean deleteRoom(int roomId);

	public boolean updateRoom(RoomBean roomBean);

	public List<RoomBean> getRoom(String hotelName);

	public List<BookingBean> bookingList();

	public List<BookingBean> guestListOfSpecificHotel(int hotelId);

	public List<BookingBean> bookingListOnSpecificDate(Date checkinDate);

	public BookingBean viewBookingStatus(String userName);

}// end of the AdminDAO Interface
