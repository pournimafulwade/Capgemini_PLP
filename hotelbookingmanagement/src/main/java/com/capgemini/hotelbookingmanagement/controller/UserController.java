package com.capgemini.hotelbookingmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.beans.HotelResponse;
import com.capgemini.hotelbookingmanagement.beans.UserBean;
import com.capgemini.hotelbookingmanagement.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping(path = "/userLogin")
	@ResponseBody // object is coming into the body of the request
	public HotelResponse userLogin(@Valid @RequestParam String userEmail, @RequestParam String userPassword) {
		UserBean userBean = userService.userLogin(userEmail, userPassword);
		HotelResponse hotelResponse = new HotelResponse();
		if (userBean != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Users Logged in........");
			hotelResponse.setUserBean(userBean);
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("User Login Failed........");
		}
		return hotelResponse;
	}// End of UserLogin()

	@PostMapping(path = "/userRegistration")
	// @ResponseBody //object is coming into the body of the request
	public HotelResponse registerUser(@Valid @RequestBody UserBean userBean) {
		boolean register = userService.userRegister(userBean);
		HotelResponse hotelResponse = new HotelResponse();
		if (register) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Users Registered.......");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("User Registration Failed........");
		}
		return hotelResponse;
	}// End of registerUser()

	@PostMapping(path = "/updateUserProfile")
	public HotelResponse updateUser(@RequestBody UserBean userBean) {
		boolean isUpdate = userService.updateUserProfile(userBean);
		HotelResponse hotelResponse = new HotelResponse();
		if (isUpdate) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("User Details Updated.......");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Update Failed........");
		}
		return hotelResponse;
	}// End of updateUser()
	
	@GetMapping(path = "/getHotel")
	public HotelResponse getHotel(String location) {
		List<HotelBean> list = userService.getHotel(location);
		HotelResponse hotelResponse = new HotelResponse();
		if (list != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Hotels details found");
			hotelResponse.setHotelList(list);
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("No hotel found in given location");
		}
		return hotelResponse;
	}

	@PutMapping(path = "/booking")
	public HotelResponse booking(@RequestParam int userId, @RequestParam int roomId, @RequestParam int hotelId) {
		 boolean isAdded = userService.booking(userId, roomId,hotelId);
		 HotelResponse hotelResponse = new  HotelResponse();
		 if(isAdded) {
			 hotelResponse.setStatusCode(201);
			 hotelResponse.setMessage("Success");
			 hotelResponse.setDescription("booking done successful..!!");
		 }else {
			 hotelResponse.setStatusCode(401);
			 hotelResponse.setMessage("Failed");
			 hotelResponse.setDescription("Unable to book successfully");
		 }
		return hotelResponse;
	} //end of the booking()
	
	
	@PutMapping(path = "/bookingEmployee")
	public HotelResponse booking1(@RequestParam int userId, @RequestParam int roomId, @RequestParam int hotelId) {
		 boolean isAdded = userService.booking1(userId, roomId,hotelId);
		 HotelResponse response = new  HotelResponse();
		 if(isAdded) {
			 response.setStatusCode(201);
			 response.setMessage("Success");
			 response.setDescription("booking done successful..!!");
		 }else {
			 response.setStatusCode(401);
			 response.setMessage("Failed");
			 response.setDescription("Unable to book room!!");
		 }
		return response;
	}
	
	
	@GetMapping(path = "/totalBill")
	public HotelResponse totalBill(@RequestParam int userId) {
		double bill = userService.bill(userId);

		HotelResponse response = new HotelResponse();
		if (bill > 0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setPrice(bill);
			response.setDescription("Total Amount to be Paid...");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setPrice(bill);
			response.setDescription("Please Book a room");
		}
		return response;
	}
	
	
//	@GetMapping("/getHotel")
//	// @ResponseBody
//	public HotelResponse getHotel(@RequestParam String hotelName) {
////		List<RoomBean> hotelBean = userService.getHotel(hotelName);
//		HotelBean hotelBean = userService.getHotel(hotelName);
//		HotelResponse response = new HotelResponse();
//		if (hotelBean != null) {
////			RoomBean roomBean = new RoomBean();
//			response.setStatusCode(201);
//			response.setMessage("Success!!");
//			response.setDescription("Hotel Details found....");
//			response.setHotelBean1(hotelBean);
//		} else {
//			response.setStatusCode(401);
//			response.setMessage("Failed !!");
//			response.setDescription("Hotel record " + hotelName + "not found ...");
//
//		}
//		return response;
//	}// End of getHotel()
}// end of the UserController class