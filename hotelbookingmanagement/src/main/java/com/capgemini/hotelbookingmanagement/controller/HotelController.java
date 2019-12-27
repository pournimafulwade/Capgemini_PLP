package com.capgemini.hotelbookingmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.beans.HotelResponse;
import com.capgemini.hotelbookingmanagement.beans.UserBean;
import com.capgemini.hotelbookingmanagement.service.HotelService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class HotelController {
	@Autowired
	private HotelService hotelService;
	
	public static final String SUCCESS = "success";
	public static final String FAILURE = "failed";
	
	
	@PostMapping(path = "/addHotel")
	public HotelResponse addHotel(@RequestBody HotelBean hotelBean) {
		boolean isAdded = hotelService.addHotel(hotelBean);
		HotelResponse hotelResponse = new HotelResponse();
		if (isAdded) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage(SUCCESS);
			hotelResponse.setDescription("Hotel Added successfully...");
			hotelResponse.setHotelBean1(hotelBean);
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage(FAILURE);
			hotelResponse.setDescription("Unble to add hotel...");
		}
		return hotelResponse;
	}// end of the addHotel()
	
	@DeleteMapping(path = "/deleteHotel")
	public HotelResponse removeHotel(@RequestParam int hotelId) {
		boolean isDeleted = hotelService.removeHotel(hotelId);
		HotelResponse hotelResponse = new HotelResponse();
		if (isDeleted) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage(SUCCESS);
			hotelResponse.setDescription("Hotel get Deleted...");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage(FAILURE);
			hotelResponse.setDescription("Unable to detete the hotel...");
		}
		return hotelResponse;
	}// end of the removeHotel()
	@PostMapping(path = "/updateHotel")
	public HotelResponse updateHotel(@RequestBody HotelBean hotelBean) {
		boolean isupdated = hotelService.updateHotel(hotelBean);
		HotelResponse hotelResponse = new HotelResponse();
		if (isupdated) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage(SUCCESS);
			hotelResponse.setDescription("Hotel Details updated successfully...");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage(FAILURE);
			hotelResponse.setDescription("Unable to update Hotel Details...");
		}
		return hotelResponse;
	}// end of the updateHotel()
	
	@GetMapping(path = "/hotelList")
	public HotelResponse hotelList() {
		List<HotelBean> hotelList = hotelService.getHotelList();
		HotelResponse hotelResponse = new HotelResponse();
		if (hotelList != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage(SUCCESS);
			hotelResponse.setDescription("Hotel List found....");
			hotelResponse.setHotelList(hotelList);
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage(FAILURE);
			hotelResponse.setDescription("Unable to find the hotel List...");
		}
		return hotelResponse;
	}// end of the hotelList()

	@GetMapping(path = "/getAllHotels")
	public HotelResponse getAllHotels() {
		List<HotelBean> hotelList = hotelService.getHotelList();
		HotelResponse hotelResponse = new HotelResponse();
		if (hotelList != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage(SUCCESS);
			hotelResponse.setDescription("Hotel Data Found........");
			hotelResponse.setHotelList(hotelList);
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage(FAILURE);
			hotelResponse.setDescription("Hotel data not Found........");
		}
		return hotelResponse;
	}// end of the getAllUsers()
}
