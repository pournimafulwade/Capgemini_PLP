package com.capgemini.hotelbookingmanagement.dao;

import java.text.SimpleDateFormat;
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
			throw new HotelException("Enter valid credentials");
		}
		return userBean;
	}// end of the userLogin()

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
			throw new HotelException("Unable to Register");
		}
		entityManager.close();
		return isAdded;
	}// end of the userRegister()

//	@Override
//	public List<HotelBean> getAllHotel() {
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		String jpql = "from HotelBean";
//		Query query = entityManager.createQuery(jpql);
//
//		List<HotelBean> hotelList = null;
//		try {
//			hotelList = query.getResultList();
//
//		} catch (Exception e) {
//			throw new HotelException("Unavailable to Show Hotel List");
//		}
//
//		return hotelList;
//
//	}// end of the getAllHotel()

	@Override
	public boolean updateUserProfile(UserBean userBean) {
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
	public int countOfUser(String userType) throws HotelException {
		int count = 0;

		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("hotelmanagementpersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<UserBean> userList = null;
		String jpql = "from UserBean where userType=:userType";
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userType", userType);
		userList = query.getResultList();
		for (UserBean userBean : userList) {
			System.out.println("-------------" + userBean.getUserId());
			count++;
		}
		entityTransaction.commit();
		entityManager.close();
		return count;
	}

	@Override
	public List<UserBean> getAllUser() throws HotelException {
		EntityManager manager = entityManagerFactory.createEntityManager();
		String jpql = "from UserBean where userType = 'user'";
		Query query = manager.createQuery(jpql);

		List<UserBean> userList = null;
		try {
			userList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

//	@Override
//	public List<HotelBean> getHotel(String location) {
//		EntityManagerFactory entityManagerFactory = Persistence
//				.createEntityManagerFactory("hotelmanagementpersistence");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		try {
//			EntityTransaction entityTransaction = entityManager.getTransaction();
//			String jpql = "from HotelBeans where location=: location";
//			entityTransaction.begin();
//			Query query = entityManager.createQuery(jpql);
//			query.setParameter("location", location);
//			List<HotelBean> list = null;
//			list = query.getResultList();
//			entityTransaction.commit();
//			return list;
//		} catch (Exception e) {
//			throw new HotelException("Hotel not found in this location..");
//		}
//	}// end of the getHotel()

//	@Override
//	public boolean booking(BookingBean bookingBean) {
//		double roomRent = 0;
//		String hotelName = null;
//		String checkinDate;
//		String checkoutDate;
//		String modeOfPayment = null;
//		String paymentStatus = null;
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		EntityTransaction transaction = null;
//		boolean isadd = false;
//		float daysBetween = 0;
//		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy MM dd");
//		try {
//			transaction = entityManager.getTransaction();
//
//			String jpql = "from UserBean where userId=:userId";
//			Query query = entityManager.createQuery(jpql);
//			query.setParameter("userId", bookingBean.getUserId());
//			UserBean userBean = (UserBean) query.getSingleResult();
//
//			String jpql1 = "from HotelBean where hotelId=:hotelId";
//			Query query1 = entityManager.createQuery(jpql1);
//			query1.setParameter("hotelId", bookingBean.getHotelId());
//			HotelBean hotelBean = (HotelBean) query1.getSingleResult();
//			hotelName = hotelBean.getHotelName();
//
//			String jpql2 = "from RoomBean where roomId=:roomId";
//			Query query2 = entityManager.createQuery(jpql2);
//			query2.setParameter("roomId", bookingBean.getRoomId());
//			RoomBean roomBean = (RoomBean) query2.getSingleResult();
//			roomRent = roomBean.getRoomRent();
//
//			Date dateBefore = myFormat.parse(bookingBean.getCheckinDate());
//			Date dateAfter = myFormat.parse(bookingBean.getCheckoutDate());
//			long difference = dateAfter.getTime() - dateBefore.getTime();
//			daysBetween = (difference / (1000 * 60 * 60 * 24));
//
//			bookingBean.setRoomRent(roomRent);
//			bookingBean.setHotelName(hotelName);
//			bookingBean.setTotalDays((int) daysBetween);
//
//			transaction.begin();
//			entityManager.persist(bookingBean);
//			System.out.println("booking done!");
//			transaction.commit();
//			isadd = true;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new HotelException("Unavailable to Book ");
//		}
//		return isadd;
//	}// end of the booking()

//	@Override
//	public boolean booking1(BookingBean bean) {
//		double roomRent = 0;
//		String hotelName = null;
//		String checkinDate;
//		String checkoutDate;
//		String modeOfPayment = null;
//		String paymentStatus = null;
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		EntityTransaction transaction = null;
//		boolean isadd = false;
//		float daysBetween = 0;
//		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy MM dd");
//		try {
//			transaction = entityManager.getTransaction();
//
//			String jpql = "from UserBean where userId=:userId";
//			Query query = entityManager.createQuery(jpql);
//			query.setParameter("userId", bean.getUserId());
//			UserBean userBean = (UserBean) query.getSingleResult();
//
//			String jpql1 = "from UserBean where hotelId=:hotelId";
//			Query query1 = entityManager.createQuery(jpql1);
//			query1.setParameter("hotelId", bean.getHotelId());
//			HotelBean hotelBean = (HotelBean) query1.getSingleResult();
//			hotelName = hotelBean.getHotelName();
//
//			String jpql2 = "from RoomBean where roomId=:roomId";
//			Query query2 = entityManager.createQuery(jpql2);
//			query2.setParameter("roomId", bean.getRoomId());
//			RoomBean roomBean = (RoomBean) query2.getSingleResult();
//			roomRent = roomBean.getRoomRent();
//
//			Date dateBefore = myFormat.parse(bean.getCheckinDate());
//			Date dateAfter = myFormat.parse(bean.getCheckoutDate());
//			long difference = dateAfter.getTime() - dateBefore.getTime();
//			daysBetween = (difference / (1000 * 60 * 60 * 24));
//
//			bean.setRoomRent(roomRent);
//			bean.setHotelName(hotelName);
//			bean.setTotalDays((int) daysBetween);
//
//			transaction.begin();
//			entityManager.persist(bean);
//			System.out.println("booking done!");
//			transaction.commit();
//			isadd = true;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new HotelException("Unavailable to Book ");
//		}
//		return isadd;
//	}// end of the booking1()

//	@Override
//	public double bill(int userId) {
//		double bill = 0;
//		try {
//			EntityManager entityManager = entityManagerFactory.createEntityManager();
//			String jpql = "select totalDays*(sum(roomRent)) from BookingBean where userId =: userId";
//			Query query = entityManager.createQuery(jpql);
//			query.setParameter("userId", userId);
//			bill = (double) query.getSingleResult();
//			return bill;
//
//		} catch (Exception e) {
//			throw new HotelException("Billing not possible ");
//
//		}
//	}// end of the bill()



//	@Override
//	public float countOfDay(String checkinDate, String checkoutDate) throws HotelException {
//		float daysBetween = 0;
//		SimpleDateFormat myFormat = new SimpleDateFormat("dd-mm-yyyy");
//		try {
//			Date dateBefore = myFormat.parse(checkinDate);
//			Date dateAfter = myFormat.parse(checkoutDate);
//			long difference = dateAfter.getTime() - dateBefore.getTime();
//			daysBetween = (difference / (1000 * 60 * 60 * 24));
//		} catch (Exception e) {
//			throw new HotelException("Count of days not found...");
//		}
//		return daysBetween;
//	}
}// end of the userDAOImple class
