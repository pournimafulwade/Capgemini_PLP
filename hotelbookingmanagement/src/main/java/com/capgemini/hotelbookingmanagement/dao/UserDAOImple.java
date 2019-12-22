package com.capgemini.hotelbookingmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;

import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.beans.RoomBean;
import com.capgemini.hotelbookingmanagement.beans.UserBean;

@Repository
public class UserDAOImple implements UserDAO {
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public UserBean userLogin(String userEmail, String userPassword) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from UserBean where userEmail = :userEmail and userPassword = :userPassword ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userEmail", userEmail);
		query.setParameter("userPassword", userPassword);

		UserBean userBean = null;
		try {
			userBean = (UserBean) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} return userBean;
	}//end of the userLogin()

	@Override
	public boolean userRegister(UserBean userBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		boolean isAdded = false;
		try {
			transaction.begin();
			entityManager.persist(userBean);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isAdded;
	}//end of the register()

	@Override
	public List<HotelBean> getAllHotel() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from HotelBean";
		Query query = entityManager.createQuery(jpql);

		List<HotelBean> hotelList = null;
		try {
			hotelList = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return hotelList;

	}

	@Override
	public HotelBean getHotel(String hotelName) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hotelmanagementpersistence");
		EntityManager manager = entityManagerFactory.createEntityManager();
		HotelBean hotelBean = manager.find(HotelBean.class, hotelName);
		List<RoomBean> roomBean = null;
//		if(HotelBean!=null) {
//			int hotelId = HotelBean.getHotelId();
//			String jpql = "FROM RoomInfo WHERE hotelId =: hotelId";
//		//String jpql = "SELECT hotelId FROM HotelBean WHERE hotelName =: hotelName";
//	    //String searchHotel	= "select hotel.id from hotel join room_info.id hotel";
//		Query query = manager.createQuery(jpql);
//		roomInfo = query.getResultList();
//		}
		manager.close();
		entityManagerFactory.close();
        return hotelBean;
	}

}//end of the userDAOImple class
