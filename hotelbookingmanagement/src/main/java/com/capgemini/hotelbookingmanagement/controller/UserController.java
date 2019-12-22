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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.beans.HotelResponse;
import com.capgemini.hotelbookingmanagement.beans.RoomBean;
import com.capgemini.hotelbookingmanagement.beans.UserBean;
import com.capgemini.hotelbookingmanagement.service.AdminService;
import com.capgemini.hotelbookingmanagement.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true" )
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/userLogin")
	@ResponseBody //object is coming into the body of the request
	public HotelResponse userLogin(@RequestParam String userEmail ,@RequestParam String userPassword) {
		UserBean login=userService.userLogin(userEmail, userPassword);
		HotelResponse hotelResponse=new HotelResponse();
		if (login!=null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Users Logged in........");
//			hotelResponse.setUserBean(login);
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("User Login Failed........");
		}
		return hotelResponse;
	}//End of UserLogin()
	
	@PostMapping(path = "/userRegistration")
	//@ResponseBody //object is coming into the body of the request
	public HotelResponse registerUser(@RequestBody UserBean userBean) {
		boolean register=userService.userRegister(userBean);
		HotelResponse hotelResponse=new HotelResponse();
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
	}//End of registerUser()

	@GetMapping("/getHotel")
	// @ResponseBody
	public HotelResponse getHotel(@RequestParam String hotelName) {
		List<RoomBean> hotelBean = userService.getHotel(hotelName);
		HotelResponse response = new HotelResponse();
		if (hotelBean != null) {
//			RoomBean roomBean = new RoomBean();
			response.setStatusCode(201);
			response.setMessage("Success!!");
			response.setDescription("Hotel Details found....");
			response.setHotelBean(hotelBean);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed !!");
			response.setDescription("Hotel record " + hotelName + "not found ...");

		}
		return response;
	}// End of getHotel()
}//end of the UserController class