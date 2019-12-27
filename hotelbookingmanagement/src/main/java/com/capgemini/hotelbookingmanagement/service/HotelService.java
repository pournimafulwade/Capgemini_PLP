package com.capgemini.hotelbookingmanagement.service;

import java.util.List;

import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.customexeption.HotelException;

public interface HotelService {
	public boolean addHotel(HotelBean hotelBean);

	public boolean removeHotel(int hotelId);

	public boolean updateHotel(HotelBean hotelBean);

	public List<HotelBean> getHotelList();

	//List<HotelBean> getAllHotel();

}
