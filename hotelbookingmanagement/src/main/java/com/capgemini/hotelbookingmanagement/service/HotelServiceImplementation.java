package com.capgemini.hotelbookingmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.dao.HotelDAO;
@Service
public class HotelServiceImplementation implements HotelService {
	@Autowired
	private HotelDAO hotelDAO;

	@Override
	public boolean addHotel(HotelBean hotelBean) {
		return hotelDAO.addHotel(hotelBean);
	}

	@Override
	public boolean removeHotel(int hotelId) {
		return hotelDAO.removeHotel(hotelId);
	}

	@Override
	public boolean updateHotel(HotelBean hotelBean) {
		return hotelDAO.updateHotel(hotelBean);
	}

	@Override
	public List<HotelBean> getHotelList() {
		return hotelDAO.getHotelList();
	}

//	@Override
//	public List<HotelBean> getAllHotel() {
//		return hotelDAO.getAllHotel();
//	}

}
