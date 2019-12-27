package com.capgemini.hotelbookingmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelbookingmanagement.beans.HotelResponse;
import com.capgemini.hotelbookingmanagement.beans.UserBean;
import com.capgemini.hotelbookingmanagement.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class UserController {
	@Autowired
	private UserService userService;
	public static final String SUCCESS = "success";
	public static final String FAILURE = "failed";

	@GetMapping(path = "/userLogin")
	@ResponseBody // object is coming into the body of the request
	public HotelResponse userLogin(@Valid @RequestParam String userEmail, @RequestParam String userPassword) {
		UserBean userBean = userService.userLogin(userEmail, userPassword);
		HotelResponse hotelResponse = new HotelResponse();
		if (userBean != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage(SUCCESS);
			hotelResponse.setDescription("Users Logged in........");
			hotelResponse.setUserBean(userBean);
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage(FAILURE);
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
			hotelResponse.setMessage(SUCCESS);
			hotelResponse.setDescription("Users Registered.......");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage(FAILURE);
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
			hotelResponse.setMessage(SUCCESS);
			hotelResponse.setDescription("User Details Updated.......");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage(FAILURE);
			hotelResponse.setDescription("Update Failed........");
		}
		return hotelResponse;
	}// End of updateUser()
	
	@GetMapping(path = "/countOfUser")
	public HotelResponse countOfUser(@RequestParam String userType) {
		int countOfUser = userService.countOfUser(userType);
		HotelResponse hotelResponse = new HotelResponse();
		if (countOfUser > 0) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage(SUCCESS);
			hotelResponse.setDescription("count generated...");
			hotelResponse.setCount(countOfUser);
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage(FAILURE);
			hotelResponse.setDescription("count not found...");
		}
		return hotelResponse;
	}
	
	@GetMapping(path = "/getAllUsers")
	public HotelResponse getAllUser() {
		List<UserBean> userList = userService.getAllUser();
		HotelResponse hotelResponse = new HotelResponse();
		if (userList != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage(SUCCESS);
			hotelResponse.setDescription("Users Data Found........");
			hotelResponse.setUserList(userList);
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage(FAILURE);
			hotelResponse.setDescription("User data not Found........");
		}
		return hotelResponse;
	}// end of the getAllUsers()

//	@GetMapping(path = "/getHotel")
//	public HotelResponse getHotel(String location) {
//		List<HotelBean> list = userService.getHotel(location);
//		HotelResponse hotelResponse = new HotelResponse();
//		if (list != null) {
//			hotelResponse.setStatusCode(201);
//			hotelResponse.setMessage(SUCCESS);
//			hotelResponse.setDescription("Hotels details found");
//			hotelResponse.setHotelList(list);
//		} else {
//			hotelResponse.setStatusCode(401);
//			hotelResponse.setMessage(FAILURE);
//			hotelResponse.setDescription("No hotel found in given location");
//		}
//		return hotelResponse;
//	}

//	@PutMapping(path = "/booking")
//	public HotelResponse booking(@RequestBody BookingBean bookingBean) {
//		boolean isAdded = userService.booking(bookingBean);
//		HotelResponse hotelResponse = new HotelResponse();
//		if (isAdded) {
//			hotelResponse.setStatusCode(201);
//			hotelResponse.setMessage(SUCCESS);
//			hotelResponse.setDescription("booking done successful..!!");
//		} else {
//			hotelResponse.setStatusCode(401);
//			hotelResponse.setMessage(FAILURE);
//			hotelResponse.setDescription("Unable to book successfully");
//		}
//		return hotelResponse;
//	} // end of the booking()

//	@PutMapping(path = "/bookingEmployee")
//	public HotelResponse booking1(@RequestBody BookingBean bookingBean) {
//		boolean isAdded = userService.booking1(bookingBean);
//		HotelResponse hotelResponse = new HotelResponse();
//		if (isAdded) {
//			hotelResponse.setStatusCode(201);
//			hotelResponse.setMessage(SUCCESS);
//			hotelResponse.setDescription("booking done successful..!!");
//		} else {
//			hotelResponse.setStatusCode(401);
//			hotelResponse.setMessage(FAILURE);
//			hotelResponse.setDescription("Unable to book room!!");
//		}
//		return hotelResponse;
//	}

//	@GetMapping(path = "/totalBill")
//	public HotelResponse totalBill(@RequestParam int userId) {
//		double bill = userService.bill(userId);
//		BookingBean bookingBean = new BookingBean();
//		HotelResponse hotelResponse = new HotelResponse();
//		if (bill > 0) {
//			hotelResponse.setStatusCode(201);
//			hotelResponse.setMessage(SUCCESS);
//			hotelResponse.setPrice(bill);
//			hotelResponse.setDescription("Total Amount to be Paid...");
//		} else {
//			hotelResponse.setStatusCode(401);
//			hotelResponse.setMessage(FAILURE);
//			hotelResponse.setDescription("Please Book a room");
//		}
//		return hotelResponse;
//	}

//	@PutMapping(path = "/countOfDay")
//	public HotelResponse countOfDay(@RequestParam String checkinDate, @RequestParam String checkoutDate) {
//		float daysBetween = userService.countOfDay(checkinDate, checkoutDate);
//
//		HotelResponse hotelResponse = new HotelResponse();
//		if (daysBetween != 0) {
//			hotelResponse.setStatusCode(201);
//			hotelResponse.setMessage(SUCCESS);
//			hotelResponse.setDescription("Number of days generated...");
//			hotelResponse.setDaysBetween(daysBetween);
//		} else {
//			hotelResponse.setStatusCode(401);
//			hotelResponse.setMessage(FAILURE);
//			hotelResponse.setDescription("Number of days cannot be genereated...");
//		}
//		return hotelResponse;
//	}
}// end of the UserController class