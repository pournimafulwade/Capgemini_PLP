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
@Repository
public class AdminDAOImple implements AdminDAO {
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addHotel(HotelBean hotelBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		boolean isAdded = false;
		try {
			entityTransaction.begin();
			entityManager.persist(hotelBean);
			entityTransaction.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isAdded;
	}//end of the addHotel()

	@Override
	public boolean removeHotel(int hotelId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hotelmanagementpersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		boolean isDeleted = false;

		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			HotelBean hotelBean = entityManager.find(HotelBean.class, hotelId);
			entityManager.remove(hotelBean);
			entityTransaction.commit();
			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return isDeleted;
	}//end of the removeHotel()

	@Override
	public boolean updateHotel(HotelBean hotelBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		HotelBean existingHotelInfo = entityManager.find(HotelBean.class, hotelBean.getHotelId());
		boolean isUpdated = false;

		if (existingHotelInfo != null) {
			String hotelName = hotelBean.getHotelName();
			if (hotelName != null) {
				existingHotelInfo.setHotelName(hotelName);

			}

			String location = hotelBean.getLocation();
			if (location != null) {
				existingHotelInfo.setLocation(location);;
			}
			
			try {
				EntityTransaction entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				entityManager.persist(existingHotelInfo);
				entityTransaction.commit();

				isUpdated = true;

			} catch (Exception e) {
				e.printStackTrace();
			}
			entityManager.close();
		}
		return isUpdated;
	}//end of the updateHotel()

	@Override
	public List<HotelBean> getHotelList() {
		EntityManager manager = entityManagerFactory.createEntityManager();
		String jpql = "from HotelBean";
		Query query = manager.createQuery(jpql);

		List<HotelBean> hotelsList = null;
		try {
			hotelsList = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return hotelsList;
	}//end of the getHotelList()

	@Override
	public boolean addRoom(RoomBean roomBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		boolean isAdded = false;
		try {
			entityTransaction.begin();
			entityManager.persist(roomBean);
			entityTransaction.commit();
			isAdded = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();

		return isAdded;
	}//end of the addRoom()

	@Override
	public boolean deleteRoom(int roomId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hotelmanagementpersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		boolean isDeleted = false;

		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			RoomBean roomBean = entityManager.find(RoomBean.class, roomId);
			entityManager.remove(roomBean);
			entityTransaction.commit();
			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isDeleted;
	}//end of the deleteRoom()

	@Override
	public boolean updateRoom(RoomBean roomBean) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = manager.getTransaction();
		RoomBean roomBean1 = manager.find(RoomBean.class, roomBean.getRoomId());
		if (roomBean != null) {
			if (roomBean.getRoomRent() != 0) {
				roomBean1.setRoomRent(roomBean.getRoomRent());
			}
			if (roomBean.getRoomType() != null) {
			roomBean1.setRoomType(roomBean.getRoomType());
			}
			if (roomBean.getRoomCapacity() != 0) {
				roomBean1.setRoomCapacity(roomBean.getRoomCapacity());
			}
			if (roomBean.getRoomStatus() != null) {
				roomBean1.setRoomStatus(roomBean.getRoomStatus());
			}
		}
		boolean isUpdate = false;
		try {
			entityTransaction.begin();
			manager.persist(roomBean1);
			entityTransaction.commit();
			isUpdate = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return isUpdate;
	}//end of the updateRoom()
	
	@Override
	public List<RoomBean> getRoom(String hotelName) {
		List<RoomBean> roomList = null;
		int hotelId = 0;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hotelmanagementpersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// RoomBeans data = entityManager.find(RoomBeans.class,hotelName);
		HotelBean hotelBeans = new HotelBean();
		String jpql1 = "from HotelBean where hotelName=: hotelName";
		Query query1 = entityManager.createQuery(jpql1);
		query1.setParameter("hotelName", hotelName);
		List<HotelBean> list = query1.getResultList();
		for (HotelBean hotel : list) {
			System.out.println("Id = " + hotel.getHotelId());
			System.out.println("Location = " + hotel.getLocation());
			hotelId = hotel.getHotelId();
		}
			String jpql2 = "from RoomBean where hotelId=:hotelId";
			Query query2 = entityManager.createQuery(jpql2);
			query2.setParameter("hotelId", hotelId);

			roomList = query2.getResultList();
			for (RoomBean room : roomList) {
				room.getHotelId();
				room.getRoomId();
				room.getRoomCapacity();
				room.getRoomCapacity();
				room.getRoomRent();
				room.getRoomStatus();

				roomList.add(room);
				return roomList;
			}
		return null;
	}//end of the getRoom()

	@Override
	public List<UserBean> getAllUser() {
		EntityManager manager = entityManagerFactory.createEntityManager();
		String jpql = "from UserBean where userType <> 'Admin'";
		Query query = manager.createQuery(jpql);

		List<UserBean> userList = null;
		try {
			userList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}//end of the getAllUser()

	@Override
	public List<BookingBean> bookingList() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hotelmanagementpersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		String jpql = "from BookingBean";
		entityTransaction.begin();
		Query query = entityManager.createQuery(jpql);
		//query.setParameter("hotelId", hotelId);
		List<BookingBean> bookingList = null;
		bookingList = query.getResultList();
		entityTransaction.commit();
		return bookingList;
	}//end of the bookingList()

	@Override
	public List<BookingBean> guestListOfSpecificHotel(int hotelId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hotelmanagementpersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		String jpql = "from BookingBean where hotelId=: hotelId";
		entityTransaction.begin();
		Query query = entityManager.createQuery(jpql);
		query.setParameter("hotelId", hotelId);
		List<BookingBean> guestList = null;
		guestList = query.getResultList();
		entityTransaction.commit();
		return guestList;
	}//end of the guestListOfSpecificHotel

	@Override
	public List<BookingBean> bookingListOnSpecificDate(Date checkinDate) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hotelmanagementpersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		String jpql = "from BookingBean where checkinDate=:checkinDate";
		entityTransaction.begin();
		Query query = entityManager.createQuery(jpql);
		query.setParameter("checkinDate", checkinDate);
		List<BookingBean> bookingList = null;
		bookingList = query.getResultList();
		entityTransaction.commit();
		return bookingList;
	}//end of the bookingListOnSpecificDate()

	@Override
	public BookingBean viewBookingStatus(String userName) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hotelmanagementpersistence");
 		EntityManager entityManager = entityManagerFactory.createEntityManager();
 		String jpql ="from BookingBean where userName =: userName";
 		Query query = entityManager.createQuery(jpql);
 		query.setParameter("userName", userName);
		BookingBean bookingBean = (BookingBean)query.getSingleResult();
		entityManager.close();
		return bookingBean;
	}//end of the viewBookingStatus()

}//end of the AdminDAOImple class
