package com.capgemini.hotelbookingmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelbookingmanagement.beans.RoomBean;
import com.capgemini.hotelbookingmanagement.dao.RoomDAO;
@Service
public class RoomServiceImplementation implements RoomService {
	@Autowired
	private RoomDAO roomDAO;

	@Override
	public boolean addRoom(RoomBean roomBean) {
		return roomDAO.addRoom(roomBean);
	}

	@Override
	public boolean deleteRoom(int roomId) {
		return roomDAO.deleteRoom(roomId);
	}

	@Override
	public boolean updateRoom(RoomBean roomBean) {
		return roomDAO.updateRoom(roomBean);
	}

	@Override
	public List<RoomBean> getRoom(String hotelName) {
		return roomDAO.getRoom(hotelName);
	}

	@Override
	public boolean deleteHotelRoom(int hotelId) {
		return roomDAO.deleteHotelRoom(hotelId);
	}

}
