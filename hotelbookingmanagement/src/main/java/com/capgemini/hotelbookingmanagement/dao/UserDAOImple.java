package com.capgemini.hotelbookingmanagement.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelbookingmanagement.beans.BookingBean;
import com.capgemini.hotelbookingmanagement.beans.HotelBean;
import com.capgemini.hotelbookingmanagement.beans.RoomBean;
import com.capgemini.hotelbookingmanagement.beans.UserBean;
import com.capgemini.hotelbookingmanagement.customexeption.HotelException;

@Repository
public class UserDAOImple implements UserDAO {
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public UserBean userLogin(String userEmail, String userPassword) throws HotelException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from UserBean where userEmail = :userEmail and userPassword = :userPassword ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userEmail", userEmail);
		query.setParameter("userPassword", userPassword);

		UserBean userBean = null;
		try {
			userBean = (UserBean) query.getSingleResult();
		} catch (Exception e) {
			throw new HotelException("Enter valid credentials");
		}
		return userBean;
	}// end of the userLogin()

	@Override
	public boolean userRegister(UserBean userBean) throws HotelException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		boolean isAdded = false;
		try {
			transaction.begin();
			entityManager.persist(userBean);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			throw new HotelException("Unable to Register");
		}
		entityManager.close();
		return isAdded;
	}// end of the userRegister()

	@Override
	public List<HotelBean> getAllHotel() throws HotelException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from HotelBean";
		Query query = entityManager.createQuery(jpql);

		List<HotelBean> hotelList = null;
		try {
			hotelList = query.getResultList();

		} catch (Exception e) {
			throw new HotelException("Unavailable to Show Hotel List"); 	
		}

		return hotelList;

	}// end of the getAllHotel()

//@Override
//public HotelBean getHotel(String hotelName) {
//EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hotelmanagementpersistence");
//EntityManager manager = entityManagerFactory.createEntityManager();
//HotelBean hotelBean = manager.find(HotelBean.class, hotelName);
//List<RoomBean> roomBean = null;
////		if(HotelBean!=null) {
////			int hotelId = HotelBean.getHotelId();
////			String jpql = "FROM RoomInfo WHERE hotelId =: hotelId";
////		//String jpql = "SELECT hotelId FROM HotelBean WHERE hotelName =: hotelName";
////	    //String searchHotel	= "select hotel.id from hotel join room_info.id hotel";
////		Query query = manager.createQuery(jpql);
////		roomInfo = query.getResultList();
////		}
//		manager.close();
//		entityManagerFactory.close();
//        return hotelBean;
//	}//end of the  getHotel()

	@Override
	public boolean updateUserProfile(UserBean userBean) throws HotelException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		UserBean userBean1 = entityManager.find(UserBean.class, userBean.getUserId());
		boolean isUpdate = false;
		if (userBean1 != null) {
			String userPassword = userBean.getUserPassword();
			if (userPassword != null) {
				userBean1.setUserPassword(userPassword);
			}
			String address = userBean.getAddress();
			if (address != null) {
				userBean1.setAddress(address);
			}
			String mobile = userBean.getMobile();
			if (mobile != null) {
				userBean1.setMobile(mobile);
			}
		}
		try {
			entityTransaction.begin();
			entityManager.persist(userBean1);
			entityTransaction.commit();
			isUpdate = true;
		} catch (Exception e) {
			throw new HotelException("Unable to Update the User Profile");
		}
		entityManager.close();
		return isUpdate;
	}// end of the updateUserProfile()

	@Override
	public List<HotelBean> getHotel(String location) throws HotelException {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hotelPersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			String jpql = "from HotelBeans where location=: location";
			entityTransaction.begin();
			Query query = entityManager.createQuery(jpql);
			query.setParameter("location", location);
			List<HotelBean> list = null;
			list = query.getResultList();
			entityTransaction.commit();
			return list;
		}catch(Exception e){
			throw new HotelException("Hotel not found in this location..");
		}
	}// end of the getHotel()

	@Override
	public boolean booking(int userId, int roomId, int hotelId) throws HotelException {
		double roomRent = 0;
		String hotelName = null;
		Date checkinDate = null;
		Date checkoutDate = null;
		String modeOfPayment = null;
		String paymentStatus = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = null;
		boolean isadd = false;

		try {
			transaction = entityManager.getTransaction();

			String jpql = "from UserBean where userId=:userId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", userId);
			UserBean userBean = (UserBean) query.getSingleResult();

			String jpql1 = "from HotelBean where hotelId=:hotelId";
			Query query1 = entityManager.createQuery(jpql1);
			query1.setParameter("hotelId", hotelId);
//     		query1.setParameter("hotelName", hotelName);
			HotelBean hotelBean = (HotelBean) query1.getSingleResult();
			hotelName = hotelBean.getHotelName();

			String jpql2 = "from RoomBean where roomId=:roomId";
			Query query2 = entityManager.createQuery(jpql2);
			query2.setParameter("roomId", roomId);
			RoomBean roomBean = (RoomBean) query2.getSingleResult();
			roomRent = roomBean.getRoomRent();

			BookingBean bookingBean = new BookingBean();
			bookingBean.setUserId(userId);
			bookingBean.setRoomId(roomId);
			bookingBean.setRoomRent(roomRent);
			bookingBean.setHotelName(hotelName);
			bookingBean.setCheckinDate(checkinDate);
			bookingBean.setCheckoutDate(checkoutDate);
			;
			bookingBean.setModeOfPayment(modeOfPayment);
			bookingBean.setPaymentStatus(paymentStatus);
			transaction.begin();
			entityManager.persist(bookingBean);
			System.out.println("booking done!");
			transaction.commit();
			isadd = true;
		} catch (Exception e) {
			throw new HotelException("Unavailable to Book ");
		}
		return isadd;
	}//end of the booking()

	@Override
	public boolean booking1(int userId, int roomId, int hotelId) throws HotelException {
		double roomRent = 0;

		String hotelName = null;
		Date checkinDate = null;
		Date checkoutDate = null;
		String modeOfPayment = null;
		String paymentStatus = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = null;
		boolean isadd = false;
		String userType = null;

		try {
			transaction = entityManager.getTransaction();
//			String jpql4= "from UserBean where userType <> 'Admin'"

			String jpql = "from UserBean where userId=:userId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", userId);

			query.setParameter("userType", userType);
			UserBean userBean = (UserBean) query.getSingleResult();

			String jpql1 = "from UserBean where hotelId=:hotelId";
			Query query1 = entityManager.createQuery(jpql1);
			query1.setParameter("hotelId", hotelId);
//     		query1.setParameter("hotelName", hotelName);
			HotelBean hotelBean = (HotelBean) query1.getSingleResult();
			hotelName = hotelBean.getHotelName();

			String jpql2 = "from RoomBean where roomId=:roomId";
			Query query2 = entityManager.createQuery(jpql2);
			query2.setParameter("roomId", roomId);
			RoomBean roomBean = (RoomBean) query2.getSingleResult();
			roomRent = roomBean.getRoomRent();

			BookingBean bookingBean = new BookingBean();
			bookingBean.setUserId(userId);
			bookingBean.setRoomId(roomId);
			bookingBean.setRoomRent(roomRent);
			bookingBean.setHotelName(hotelName);
			bookingBean.setCheckinDate(checkinDate);
			bookingBean.setCheckoutDate(checkoutDate);
			bookingBean.setModeOfPayment(modeOfPayment);
			bookingBean.setPaymentStatus(paymentStatus);
			transaction.begin();
			entityManager.persist(bookingBean);
			System.out.println("booking done!");
			transaction.commit();
			isadd = true;
		} catch (Exception e) {
			 new HotelException("Unavailable to Book ");
		}
		return isadd;

	}//end of the booking1()

	@Override
	public double bill(int userId) throws HotelException {
		double bill = 0;
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "select sum(roomRent) from BookingBean where userId =: userId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", userId);
			bill = (double) query.getSingleResult();
			return bill;

		} catch (Exception e) {
			throw new HotelException("Billing not possible ");
		}

	}//end of the bill()

//	@Override
//	public boolean updateUserProfile(String userPassword, String mobile, String address) {
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		UserBean userBean = new UserBean();
//		UserBean userBean1 = entityManager.find(UserBean.class, userBean.getUserId());
//		boolean isUpdate = false;
//		if (userBean1 != null) {
//			String userPassword1 = userBean.getUserPassword();
//			if (userPassword1 != null) {
//				userBean1.setUserPassword(userPassword1);
//			}
//			String address1 = userBean.getAddress();
//			if (address1 != null) {
//				userBean1.setAddress(address1);
//			}
//			String mobile1 = userBean.getMobile();
//			if (mobile != null) {
//				userBean1.setMobile(mobile1);
//			}
//		}
//		try {
//			entityTransaction.begin();
//			entityManager.persist(userBean1);
//			entityTransaction.commit();
//			isUpdate = true;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		entityManager.close();
//		return isUpdate;
//	}

}// end of the userDAOImple class
