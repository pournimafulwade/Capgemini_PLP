package com.capgemini.hotelbookingmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.beans.HotelResponse;
import com.capgemini.hotelbookingmanagement.beans.RoomBean;
import com.capgemini.hotelbookingmanagement.service.AdminService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true" )
public class AdminController {
	@Autowired
	private AdminService adminService;

	@PostMapping(path = "/addHotel")
	public HotelResponse addHotel(@RequestBody HotelBean hotelBean) {
		boolean add = adminService.addHotel(hotelBean);
		// List<HotelBean> hotelList=adminService.addHotel(hotelBean);
		HotelResponse hotelResponse = new HotelResponse();
		if (add) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("success");
			hotelResponse.setDescription("Hotel Added successfully...");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Unble to add hotel...");
		}
		return hotelResponse;
	}// end of the addHotel()

	@DeleteMapping(path = "/deleteHotel")
	public HotelResponse removeHotel(@RequestParam int hotelId) {
		boolean isDeleted = adminService.removeHotel(hotelId);
		HotelResponse hotelResponse = new HotelResponse();
		if (isDeleted) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Hotel get Deleted...");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Unable to detete the hotel...");
		}
		return hotelResponse;
	}// end of the removeHotel()

	@PostMapping(path = "/updateHotel")
	public HotelResponse updateHotel(@RequestBody HotelBean hotelBean) {
		boolean isupdated = adminService.updateHotel(hotelBean);
		HotelResponse hotelResponse = new HotelResponse();
		if (isupdated) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Hotel Details updated successfully...");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("failed");
			hotelResponse.setDescription("Unable to update Hotel Details...");
		}
		return hotelResponse;
	}// end of the updateHotel()

	@GetMapping(path = "/hotelList")
	public HotelResponse hotelList() {
		List<HotelBean> hotelList = adminService.getHotelList();
		HotelResponse hotelResponse = new HotelResponse();
		if (hotelList != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Hotel List found....");
			hotelResponse.setHotelList(hotelList);
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Unable to find the hotel List...");
		}
		return hotelResponse;
	}// end of the hotelList()

	@PutMapping(path = "/addRoom")
	public HotelResponse addRoom(@RequestBody RoomBean roomBean) {
		boolean isAdded = adminService.addRoom(roomBean);
		HotelResponse response = new HotelResponse();
		if (isAdded) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Room Added");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Room is not Added");
		}
		return response;
	}// end of the addRoom()

	@DeleteMapping(path = "/deleteRoom")
	public HotelResponse deleteRoom(@RequestParam int roomId) {
		boolean isDeleted = adminService.deleteRoom(roomId);
		HotelResponse response = new HotelResponse();
		if (isDeleted) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Room Delete");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Room is not Deleted");
		}
		return response;
	}// end of the deleteRoom()

	@PostMapping("/updateRoom")
	public HotelResponse updateRoom(@RequestBody RoomBean roomBean) {
		boolean isUpdated = adminService.updateRoom(roomBean);
		HotelResponse response = new HotelResponse();
		if (isUpdated) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Room Updated");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Room is not updated");
		}
		return response;
	}// end of the updateRoom()

	@GetMapping(path = "/getRoom")
	public HotelResponse getRoom(String hotelName) {
		List<RoomBean> roomList = adminService.getRoom(hotelName);

		HotelResponse response = new HotelResponse();
		if (roomList != null) {

			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Room details is displayed");

			response.setRoomList(roomList);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Room of hotel" + hotelName + "Not Found");
		}
		return response;
	}//end of the getRoom()
}//end of the AdminController class 
