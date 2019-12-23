package com.capgemini.hotelbookingmanagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelbookingmanagement.beans.BookingBean;
import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.beans.HotelResponse;
import com.capgemini.hotelbookingmanagement.beans.RoomBean;
import com.capgemini.hotelbookingmanagement.beans.UserBean;
import com.capgemini.hotelbookingmanagement.service.AdminService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class AdminController {
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private AdminService adminService;

	@GetMapping(path = "/getAllUsers")
	public HotelResponse getAllUser() {
		List<UserBean> userList = adminService.getAllUser();
		HotelResponse hotelResponse = new HotelResponse();
		if (userList != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Users Data Found........");
			hotelResponse.setUserList(userList);
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("User data not Found........");
		}
		return hotelResponse;
	}// end of the getAllUsers()

	@PostMapping(path = "/addHotel")
	public HotelResponse addHotel(@RequestBody HotelBean hotelBean) {
		boolean isAdded = adminService.addHotel(hotelBean);
		// List<HotelBean> hotelList=adminService.addHotel(hotelBean);
		HotelResponse hotelResponse = new HotelResponse();
		if (isAdded) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("success");
			hotelResponse.setDescription("Hotel Added successfully...");
			hotelResponse.setHotelBean1(hotelBean);
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
		HotelResponse hotelResponse = new HotelResponse();
		if (isAdded) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Room Added");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Room is not Added");
		}
		return hotelResponse;
	}// end of the addRoom()

	@DeleteMapping(path = "/deleteRoom")
	public HotelResponse deleteRoom(@RequestParam int roomId) {
		boolean isDeleted = adminService.deleteRoom(roomId);
		HotelResponse hotelResponse = new HotelResponse();
		if (isDeleted) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Room Delete");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Room is not Deleted");
		}
		return hotelResponse;
	}// end of the deleteRoom()

	@PostMapping("/updateRoom")
	public HotelResponse updateRoom(@RequestBody RoomBean roomBean) {
		boolean isUpdated = adminService.updateRoom(roomBean);
		HotelResponse hotelResponse = new HotelResponse();
		if (isUpdated) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Room Updated");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Room is not updated");
		}
		return hotelResponse;
	}// end of the updateRoom()

	@GetMapping(path = "/getRoom")
	public HotelResponse getRoom(String hotelName) {
		List<RoomBean> roomList = adminService.getRoom(hotelName);

		HotelResponse hotelResponse = new HotelResponse();
		if (roomList != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Room details is displayed");
			hotelResponse.setRoomList(roomList);
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Room of hotel" + hotelName + "Not Found");
		}
		return hotelResponse;
	}// end of the getRoom()

	@GetMapping(path = "/bookingList")
	public HotelResponse bookingListOfSpecificHotel() {
		List<BookingBean> bookingList = adminService.bookingList();
		HotelResponse hotelResponse = new HotelResponse();
		if (bookingList != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Booking details found");
			hotelResponse.setBookingList(bookingList);
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Booking details not found");
		}
		return hotelResponse;
	}// end of the bookingListOfSpecificHotel()

	@GetMapping(path = "/guestListOfSpecificHotel")
	public HotelResponse guestListOfSpecificHotel(int hotelId) {
		List<BookingBean> guestList = adminService.guestListOfSpecificHotel(hotelId);
		HotelResponse hotelResponse = new HotelResponse();
		if (guestList != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Guest list found");
			hotelResponse.setBookingList(guestList);
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Guest list not found");
		}
		return hotelResponse;
	}// end of the guestListOfSpecificHotel()

	@GetMapping(path = "/bookingListOnSpecificDate")
	public HotelResponse bookingListOnSpecificDate(@RequestParam("checkinDate/") Date checkinDate) {
		List<BookingBean> bookingList = adminService.bookingListOnSpecificDate(checkinDate);
		HotelResponse hotelResponse = new HotelResponse();
		if (bookingList != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Guest list found");
			hotelResponse.setBookingList(bookingList);
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Guest list not found");
		}
		return hotelResponse;
	}// end of the bookingListOnSpecificDate()
	
	@GetMapping(path = "/viewStatus")
	public HotelResponse viewBookingStatus(String userName) {
	BookingBean viewBookingStatus = adminService.viewBookingStatus(userName);
		HotelResponse hotelResponse = new HotelResponse();
		if (viewBookingStatus != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Booking Status Found...");
			hotelResponse.setBookingBean(viewBookingStatus);
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Booking Status not found...");
		}
		return hotelResponse;
	}

}// end of the AdminController class
