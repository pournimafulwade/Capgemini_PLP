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
public class BookingDAOImplementation implements BookingDAO {
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public List<BookingBean> bookingList() throws HotelException {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("hotelmanagementpersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			String jpql = "from BookingBean";
			entityTransaction.begin();
			Query query = entityManager.createQuery(jpql);
			List<BookingBean> bookingList = null;
			bookingList = query.getResultList();
			entityTransaction.commit();
			return bookingList;
		} catch (Exception e) {
			throw new HotelException("Booking list not found..");
		}
	}

	@Override
	public List<BookingBean> guestListOfSpecificHotel(int hotelId) throws HotelException {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("hotelmanagementpersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			String jpql = "from BookingBean where hotelId=: hotelId";
			entityTransaction.begin();
			Query query = entityManager.createQuery(jpql);
			query.setParameter("hotelId", hotelId);
			List<BookingBean> guestList = null;
			guestList = query.getResultList();
			entityTransaction.commit();
			return guestList;
		} catch (Exception e) {
			throw new HotelException("There is no booking done for this particular hotel..");
		}
	}

	@Override
	public List<BookingBean> bookingListOnSpecificDate(Date checkinDate) throws HotelException {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("hotelmanagementpersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			String jpql = "from BookingBean where checkinDate=:checkinDate";
			entityTransaction.begin();
			Query query = entityManager.createQuery(jpql);
			query.setParameter("checkinDate", checkinDate);
			List<BookingBean> bookingList = null;
			bookingList = query.getResultList();
			entityTransaction.commit();
			return bookingList;
		} catch (Exception e) {
			throw new HotelException("There is no booking for the given date..");
		}
	}

	@Override
	public BookingBean viewBookingStatus(String userName) throws HotelException {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("hotelmanagementpersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			String jpql = "from BookingBean where userName =: userName";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userName", userName);
			BookingBean bookingBean = (BookingBean) query.getSingleResult();
			entityManager.close();
			return bookingBean;
		} catch (Exception e) {
			throw new HotelException("No status found..");
		}
	}

	@Override
	public float countOfDay(String checkinDate, String checkoutDate) throws HotelException {
		float daysBetween = 0;
		SimpleDateFormat myFormat = new SimpleDateFormat("dd-mm-yyyy");
		try {
			Date dateBefore = myFormat.parse(checkinDate);
			Date dateAfter = myFormat.parse(checkoutDate);
			long difference = dateAfter.getTime() - dateBefore.getTime();
			daysBetween = (difference / (1000 * 60 * 60 * 24));
		} catch (Exception e) {
			throw new HotelException("Count of days not found...");
		}
		return daysBetween + 1;
	
	}

	@Override
	public boolean booking(BookingBean bookingBean) throws HotelException {
		double roomRent = 0;
		String hotelName = null;
		String userName=null;
		String checkinDate;
		String checkoutDate;
		String modeOfPayment = null;
		String paymentStatus = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = null;
		boolean isadd = false;
		float daysBetween = 0;
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy MM dd");
		try {
			transaction = entityManager.getTransaction();

			String jpql = "from UserBean where userId=:userId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", bookingBean.getUserId());
			UserBean userBean = (UserBean) query.getSingleResult();
			 userName = userBean.getUserName();

			String jpql1 = "from HotelBean where hotelId=:hotelId";
			Query query1 = entityManager.createQuery(jpql1);
			query1.setParameter("hotelId", bookingBean.getHotelId());
			HotelBean hotelBean = (HotelBean) query1.getSingleResult();
			hotelName = hotelBean.getHotelName();

			String jpql2 = "from RoomBean where roomId=:roomId";
			Query query2 = entityManager.createQuery(jpql2);
			query2.setParameter("roomId", bookingBean.getRoomId());
			RoomBean roomBean = (RoomBean) query2.getSingleResult();
			roomRent = roomBean.getRoomRent();

			Date dateBefore = myFormat.parse(bookingBean.getCheckinDate());
			Date dateAfter = myFormat.parse(bookingBean.getCheckoutDate());
			long difference = dateAfter.getTime() - dateBefore.getTime();
			daysBetween = (difference / (1000 * 60 * 60 * 24));

			bookingBean.setRoomRent(roomRent);
			bookingBean.setHotelName(hotelName);
			bookingBean.setTotalDays((int) daysBetween);
			bookingBean.setUserName(userName);

			transaction.begin();
			entityManager.persist(bookingBean);
			System.out.println("booking done!");
			transaction.commit();
			isadd = true;

		} catch (Exception e) {
			e.printStackTrace();
			throw new HotelException("Unavailable to Book ");
		}
		return isadd;
	}

	@Override
	public boolean booking1(BookingBean bookingBean) throws HotelException {
		double roomRent = 0;
		String hotelName = null;
		String checkinDate;
		String checkoutDate;
		String modeOfPayment = null;
		String paymentStatus = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = null;
		boolean isadd = false;
		float daysBetween = 0;
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy MM dd");
		try {
			transaction = entityManager.getTransaction();

			String jpql = "from UserBean where userId=:userId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", bookingBean.getUserId());
			UserBean userBean = (UserBean) query.getSingleResult();

			String jpql1 = "from UserBean where hotelId=:hotelId";
			Query query1 = entityManager.createQuery(jpql1);
			query1.setParameter("hotelId", bookingBean.getHotelId());
			HotelBean hotelBean = (HotelBean) query1.getSingleResult();
			hotelName = hotelBean.getHotelName();

			String jpql2 = "from RoomBean where roomId=:roomId";
			Query query2 = entityManager.createQuery(jpql2);
			query2.setParameter("roomId", bookingBean.getRoomId());
			RoomBean roomBean = (RoomBean) query2.getSingleResult();
			roomRent = roomBean.getRoomRent();

			Date dateBefore = myFormat.parse(bookingBean.getCheckinDate());
			Date dateAfter = myFormat.parse(bookingBean.getCheckoutDate());
			long difference = dateAfter.getTime() - dateBefore.getTime();
			daysBetween = (difference / (1000 * 60 * 60 * 24));

			bookingBean.setRoomRent(roomRent);
			bookingBean.setHotelName(hotelName);
			bookingBean.setTotalDays((int) daysBetween);

			transaction.begin();
			entityManager.persist(bookingBean);
			System.out.println("booking done!");
			transaction.commit();
			isadd = true;

		} catch (Exception e) {
			e.printStackTrace();
			throw new HotelException("Unavailable to Book ");
		}
		return isadd;
	}

	@Override
	public double bill(int userId) {
		double bill = 0;
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "select totalDays*(sum(roomRent)) from BookingBean where userId =: userId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", userId);
			bill = (double) query.getSingleResult();
			return bill;

		} catch (Exception e) {
			throw new HotelException("Billing not possible ");

		}
	}

}
