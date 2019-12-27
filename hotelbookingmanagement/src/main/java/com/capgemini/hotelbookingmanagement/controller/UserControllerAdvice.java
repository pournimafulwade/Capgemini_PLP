package com.capgemini.hotelbookingmanagement.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.hotelbookingmanagement.beans.HotelResponse;
import com.capgemini.hotelbookingmanagement.customexeption.HotelException;

@RestControllerAdvice
public class UserControllerAdvice {
	@ExceptionHandler(HotelException.class)
	public HotelResponse hotelErrorResponse(HotelException e) {
	HotelResponse hotelResponse = new HotelResponse();
	hotelResponse.setStatusCode(401);
	hotelResponse.setMessage("Failed");
	hotelResponse.setDescription(e.getMessage());
	return hotelResponse;
	}

}
