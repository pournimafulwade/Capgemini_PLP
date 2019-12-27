package com.capgemini.hotelbookingmanagement.customexeption;

public class HotelException extends RuntimeException {
	String message;
	public HotelException(String message) {
		super();
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}//end of the class HotelException
