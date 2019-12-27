package com.capgemini.hotelbookingmanagement.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelbookingmanagement.beans.BookingBean;
import com.capgemini.hotelbookingmanagement.beans.HotelResponse;
import com.capgemini.hotelbookingmanagement.service.BookingService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	public static final String SUCCESS = "success";
	public static final String FAILURE = "failed";

	@GetMapping(path = "/bookingList")
	public HotelResponse bookingListOfSpecificHotel() {
		List<BookingBean> bookingList = bookingService.bookingList();
		HotelResponse hotelResponse = new HotelResponse();
		if (bookingList != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage(SUCCESS);
			hotelResponse.setDescription("Booking details found");
			hotelResponse.setBookingList(bookingList);
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage(FAILURE);
			hotelResponse.setDescription("Booking details not found");
		}
		return hotelResponse;
	}// end of the bookingListOfSpecificHotel()

	@GetMapping(path = "/guestListOfSpecificHotel")
	public HotelResponse guestListOfSpecificHotel(int hotelId) {
		List<BookingBean> guestList = bookingService.guestListOfSpecificHotel(hotelId);
		HotelResponse hotelResponse = new HotelResponse();
		if (guestList != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage(SUCCESS);
			hotelResponse.setDescription("Guest list found");
			hotelResponse.setBookingList(guestList);
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage(FAILURE);
			hotelResponse.setDescription("Guest list not found");
		}
		return hotelResponse;
	}// end of the guestListOfSpecificHotel()

	@GetMapping(path = "/bookingListOnSpecificDate")
	public HotelResponse bookingListOnSpecificDate(@RequestParam("checkinDate/") Date checkinDate) {
		List<BookingBean> bookingList = bookingService.bookingListOnSpecificDate(checkinDate);
		HotelResponse hotelResponse = new HotelResponse();
		if (bookingList != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage(SUCCESS);
			hotelResponse.setDescription("Guest list found");
			hotelResponse.setBookingList(bookingList);
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage(FAILURE);
			hotelResponse.setDescription("Guest list not found");
		}
		return hotelResponse;

	}// end of the bookingListOnSpecificDate()

	@GetMapping(path = "/viewStatus")
	public HotelResponse viewBookingStatus(String userName) {
		BookingBean viewBookingStatus = bookingService.viewBookingStatus(userName);
		HotelResponse hotelResponse = new HotelResponse();
		if (viewBookingStatus != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage(SUCCESS);
			hotelResponse.setDescription("Booking Status Found...");
			hotelResponse.setBookingBean(viewBookingStatus);
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage(FAILURE);
			hotelResponse.setDescription("Booking Status not found...");
		}
		return hotelResponse;
	}

	@PutMapping(path = "/countOfDay")
	public HotelResponse countOfDay(@RequestParam String checkinDate, @RequestParam String checkoutDate) {
		float daysBetween = bookingService.countOfDay(checkinDate, checkoutDate);

		HotelResponse hotelResponse = new HotelResponse();
		if (daysBetween != 0) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage(SUCCESS);
			hotelResponse.setDescription("Number of days generated...");
			hotelResponse.setDaysBetween(daysBetween);
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage(FAILURE);
			hotelResponse.setDescription("Number of days cannot be genereated...");
		}
		return hotelResponse;
	}

	@PutMapping(path = "/booking")
	public HotelResponse booking(@RequestBody BookingBean bookingBean) {
		boolean isAdded = bookingService.booking(bookingBean);
		HotelResponse hotelResponse = new HotelResponse();
		if (isAdded) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage(SUCCESS);
			hotelResponse.setBookingBean(bookingBean);
			hotelResponse.setDescription("booking done successful..!!");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage(FAILURE);
			hotelResponse.setDescription("Unable to book successfully");
		}
		return hotelResponse;
	} // end of the booking()

	@PutMapping(path = "/bookingEmployee")
	public HotelResponse booking1(@RequestBody BookingBean bookingBean) {
		boolean isAdded = bookingService.booking1(bookingBean);
		HotelResponse hotelResponse = new HotelResponse();
		if (isAdded) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage(SUCCESS);
			hotelResponse.setDescription("booking done successful..!!");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage(FAILURE);
			hotelResponse.setDescription("Unable to book room!!");
		}
		return hotelResponse;
	}

	@GetMapping(path = "/totalBill")
	public HotelResponse totalBill(@RequestParam int userId) {
		double bill = bookingService.bill(userId);
		BookingBean bookingBean = new BookingBean();
		HotelResponse hotelResponse = new HotelResponse();
		if (bill > 0) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage(SUCCESS);
			hotelResponse.setPrice(bill);
			hotelResponse.setDescription("Total Amount to be Paid...");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage(FAILURE);
			hotelResponse.setDescription("Please Book a room");
		}
		return hotelResponse;
	}

}
