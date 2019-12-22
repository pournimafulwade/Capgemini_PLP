package com.capgemini.hotelbookingmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.beans.RoomBean;
import com.capgemini.hotelbookingmanagement.dao.AdminDAO;
@Service
public class AdminServiceImple implements AdminService {
@Autowired
private AdminDAO adminDAO;
	@Override
	public boolean addHotel(HotelBean hotelBean) {
		return adminDAO.addHotel(hotelBean);
	}
	@Override
	public boolean removeHotel(int hotelId) {
		return adminDAO.removeHotel(hotelId);
	}
	@Override
	public boolean updateHotel(HotelBean hotelBean) {
		return adminDAO.updateHotel(hotelBean);
	}
	@Override
	public List<HotelBean> getHotelList() {
		return adminDAO.getHotelList();
	}
	@Override
	public boolean addRoom(RoomBean roomBean) {
		return adminDAO.addRoom(roomBean);
	}
	@Override
	public boolean deleteRoom(int roomId) {
		return adminDAO.deleteRoom(roomId);
	}
	@Override
	public boolean updateRoom(RoomBean roomBean) {
		return adminDAO.updateRoom(roomBean);
	}
	@Override
	public List<RoomBean> getRoom(String hotelName) {
		return adminDAO.getRoom(hotelName);
	}
}//end of the AdminServiceImple class
