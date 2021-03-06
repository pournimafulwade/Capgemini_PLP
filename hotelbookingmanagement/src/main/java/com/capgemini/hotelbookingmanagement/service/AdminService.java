package com.capgemini.hotelbookingmanagement.service;

import java.util.Date;
import java.util.List;

import com.capgemini.hotelbookingmanagement.beans.BookingBean;
import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.beans.RoomBean;
import com.capgemini.hotelbookingmanagement.beans.UserBean;
import com.capgemini.hotelbookingmanagement.customexeption.HotelException;

public interface AdminService {

	public boolean addHotel(HotelBean hotelBean);

	public boolean removeHotel(int hotelId);

	public boolean updateHotel(HotelBean hotelBean);

	public List<HotelBean> getHotelList();

	public List<UserBean> getAllUser();
	
	public List<UserBean> getAllEmployee();

	public boolean addRoom(RoomBean roomBean);

	public boolean deleteRoom(int roomId);

	public boolean updateRoom(RoomBean roomBean);

	public List<RoomBean> getRoom(String hotelName);

	public List<BookingBean> bookingList();
	
    public List<BookingBean> guestListOfSpecificHotel(int hotelId);

    public List<BookingBean> bookingListOnSpecificDate(Date checkinDate);
    
    public BookingBean viewBookingStatus(String userName);
    
	public boolean deleteHotelRoom(int hotelId);
	
	public int countOfUser(String userType);

}//end of the AdminService interface
