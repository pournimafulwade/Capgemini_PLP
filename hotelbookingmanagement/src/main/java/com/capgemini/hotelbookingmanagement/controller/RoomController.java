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

import com.capgemini.hotelbookingmanagement.beans.HotelResponse;
import com.capgemini.hotelbookingmanagement.beans.RoomBean;
import com.capgemini.hotelbookingmanagement.service.RoomService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class RoomController {
	@Autowired
	private RoomService roomService;
	
	public static final String SUCCESS = "success";
	public static final String FAILURE = "failed";
	
	@PutMapping(path = "/addRoom")
	public HotelResponse addRoom(@RequestBody RoomBean roomBean) {
		boolean isAdded = roomService.addRoom(roomBean);
		HotelResponse hotelResponse = new HotelResponse();
		if (isAdded) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage(SUCCESS);
			hotelResponse.setDescription("Room Added");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage(FAILURE);
			hotelResponse.setDescription("Room is not Added");
		}
		return hotelResponse;
	}// end of the addRoom()
	
	@DeleteMapping(path = "/deleteRoom")
	public HotelResponse deleteRoom(@RequestParam int roomId) {
		boolean isDeleted = roomService.deleteRoom(roomId);
		HotelResponse hotelResponse = new HotelResponse();
		if (isDeleted) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage(SUCCESS);
			hotelResponse.setDescription("Room Delete");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage(FAILURE);
			hotelResponse.setDescription("Room is not Deleted");
		}
		return hotelResponse;
	}// end of the deleteRoom()

	@PostMapping("/updateRoom")
	public HotelResponse updateRoom(@RequestBody RoomBean roomBean) {
		boolean isUpdated = roomService.updateRoom(roomBean);
		HotelResponse hotelResponse = new HotelResponse();
		if (isUpdated) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage(SUCCESS);
			hotelResponse.setDescription("Room Updated");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage(FAILURE);
			hotelResponse.setDescription("Room is not updated");
		}
		return hotelResponse;
	}// end of the updateRoom()
	
	@GetMapping(path = "/getRoom")
	public HotelResponse getRoom(String hotelName) {
		List<RoomBean> roomList = roomService.getRoom(hotelName);

		HotelResponse hotelResponse = new HotelResponse();
		if (roomList != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage(SUCCESS);
			hotelResponse.setDescription("Room details is displayed");
			hotelResponse.setRoomList(roomList);
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage(FAILURE);
			hotelResponse.setDescription("Room of hotel" + hotelName + "Not Found");
		}
		return hotelResponse;
	}// end of the getRoom()
	
	@DeleteMapping(path = "/deleteHotelRoom")
	public HotelResponse deleteHotelRoom(@RequestParam int hotelId) {
		boolean isDeleted = roomService.deleteHotelRoom(hotelId);
		HotelResponse hotelResponse = new HotelResponse();
		if (isDeleted) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage(SUCCESS);
			hotelResponse.setDescription("Room Delete");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage(FAILURE);
			hotelResponse.setDescription("Room is not Deleted");
		}
		return hotelResponse;
	}

}
