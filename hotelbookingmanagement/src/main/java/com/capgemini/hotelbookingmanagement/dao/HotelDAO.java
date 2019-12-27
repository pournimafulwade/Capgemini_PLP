package com.capgemini.hotelbookingmanagement.dao;

import java.util.List;

import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.customexeption.HotelException;

public interface HotelDAO {
	public boolean addHotel(HotelBean hotelBean) throws HotelException;

	public boolean removeHotel(int hotelId) throws HotelException;

	public boolean updateHotel(HotelBean hotelBean) throws HotelException;

	public List<HotelBean> getHotelList() throws HotelException;

}
