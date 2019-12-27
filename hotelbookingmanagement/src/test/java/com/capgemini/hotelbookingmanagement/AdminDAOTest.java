package com.capgemini.hotelbookingmanagement;


import org.junit.jupiter.api.Test;

import com.capgemini.hotelbookingmanagement.beans.UserBean;
import com.capgemini.hotelbookingmanagement.customexeption.HotelException;
import com.capgemini.hotelbookingmanagement.dao.UserDAO;

import junit.framework.TestCase;


public class AdminDAOTest {
	private UserDAO userDAO;
	@Test
	public void testLogin() {
		TestCase.assertNull(userDAO.userLogin("pournima@gmail.com", "Pournima07"));
	}
	@Test
	public void testRegister() throws HotelException {
		UserBean userBean = new UserBean();
		userBean.setUserName("Joey Tribbiani");
		userBean.setUserEmail("joey@gmail.com");
		userBean.setUserPassword("Tribbiani07");
		userBean.setMobile("7894561365");
		userBean.setNationality("American");
		userBean.setAddress("America");
		userBean.setUserType("employee");
		userBean.setHotelId(3);
	TestCase.assertTrue(userDAO.userRegister(userBean));
	}
	@Test
	public void testUpdateUserProfile() {
		UserBean userBean = new UserBean();
		userBean.setUserId(4);
		userBean.setAddress("Star PG,Bangalore");
		userBean.setUserPassword("AMRUTA07");
		userDAO.updateUserProfile(userBean);
	}
	
}
