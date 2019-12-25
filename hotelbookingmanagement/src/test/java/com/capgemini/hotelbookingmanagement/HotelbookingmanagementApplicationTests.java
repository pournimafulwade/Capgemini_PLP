package com.capgemini.hotelbookingmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.hotelbookingmanagement.beans.BookingBean;
import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.beans.RoomBean;
import com.capgemini.hotelbookingmanagement.beans.UserBean;
import com.capgemini.hotelbookingmanagement.service.AdminService;
import com.capgemini.hotelbookingmanagement.service.UserService;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelbookingmanagementApplicationTests {
	@Autowired
	private UserService userService;
	@Autowired
	private AdminService adminService;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testUserAuthentication() {
		TestCase.assertNotNull(userService.userLogin("pournima@gmail.com", "Pournima07"));
	}
	
	@Test
	public void testRegisterUser() {
		UserBean userBean = new UserBean();
//		userBean.setUserId(5);
		userBean.setUserName("Priti ");
		userBean.setUserEmail("priti@gmail.com");
		userBean.setUserPassword("Priti07");
		userBean.setAddress("Star pg,karnataka");
		userBean.setMobile("8945672316");
		userBean.setNationality("Indian");
		userBean.setUserType("User");
		TestCase.assertEquals(true, userService.userRegister(userBean));
	}
	
	@Test
	public void testUpdateUserProfile() {
		UserBean userBean = new UserBean();
		userBean.setUserId(3);
		userBean.setAddress("Jay Ganesh chawl,Mumbai");
		userBean.setMobile("78945613127");
		userBean.setUserPassword("Abhishek07");
		TestCase.assertEquals(true, userService.updateUserProfile(userBean));

	}
	
	@Test
	public void testAddHotel() {
		HotelBean hotelBean = new HotelBean();
		hotelBean.setHotelId(8);
		hotelBean.setHotelName("Horizone");
		hotelBean.setLocation("Mumbai");
		TestCase.assertEquals(true, adminService.addHotel(hotelBean));
	}
	
	@Test
	public void testUpdateHotel() {
		HotelBean hotelBean = new HotelBean();
		hotelBean.setHotelId(3);
		hotelBean.setHotelName("Hotel Paradise");
		hotelBean.setLocation("Karnataka");
		TestCase.assertEquals(true, adminService.updateHotel(hotelBean));
	}
	
	@Test
	public void testAddRoom() {
		RoomBean roomBean = new RoomBean();
		roomBean.setRoomId(5);
		roomBean.setRoomRent(5999.99);
		roomBean.setRoomCapacity(4);
		roomBean.setRoomStatus("Available");
		roomBean.setRoomType("AC");
		roomBean.setHotelId(3);
		TestCase.assertEquals(true, adminService.addRoom(roomBean));
	}
	
	@Test
	public void testUpdateRoom() {
		RoomBean roomBean = new RoomBean();
		roomBean.setRoomId(1);
		roomBean.setRoomRent(2999.50);
		roomBean.setRoomStatus("Available");
		roomBean.setRoomType("Non-AC");
		roomBean.setRoomCapacity(2);
		roomBean.setHotelId(1);
		TestCase.assertEquals(true, adminService.updateRoom(roomBean));
	}
	
	@Test
	public void testDeleteRoom() {
		boolean roomBean = adminService.deleteRoom(1);
		assertEquals(true, roomBean);
	}
	
	@Test
	public void testViewBookingStatus() {
		BookingBean bookingBean = adminService.viewBookingStatus("kartik tyagi");
		assertEquals(null, bookingBean);
	}

	@Test
	public void testRemoveHotel() {
		boolean hotelBean = adminService.removeHotel(7);
		assertEquals(true, hotelBean);
	}
	@Test
	public void testBooking() {
		boolean booking = userService.booking(2, 2, 4);
		assertEquals(true, booking);
	}

	@Test
	public void testBooking1() {
		boolean booking = userService.booking1(3, 2, 3);
		assertEquals(true, booking);
	}
	@Test
	public void testBill() {
		double bill = userService.bill(2);
		assertEquals(47976.0, bill);
	}


}
