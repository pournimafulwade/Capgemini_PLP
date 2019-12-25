package com.capgemini.hotelbookingmanagement.customexeption;

public class HotelException extends Exception {
	String message;
	public HotelException(String message) {
		super();
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
}
