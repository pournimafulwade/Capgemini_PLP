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
import com.capgemini.hotelbookingmanagement.customexeption.HotelException;
@Repository
public class RoomDAOImplementation implements RoomDAO {
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	@Override
	public boolean addRoom(RoomBean roomBean) throws HotelException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		boolean isAdded = false;
		try {
			entityTransaction.begin();
			entityManager.persist(roomBean);
			entityTransaction.commit();
			isAdded = true;

		} catch (Exception e) {
			throw new HotelException("Hotel Already exists..");
		}
		entityManager.close();

		return isAdded;
	}

	@Override
	public boolean deleteRoom(int roomId) throws HotelException {
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
			throw new HotelException("Room cannot be deleted..");
		}
		entityManager.close();
		return isDeleted;
	}

	@Override
	public boolean updateRoom(RoomBean roomBean) throws HotelException {
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
			throw new HotelException("Update not possible..");
		}
		manager.close();
		return isUpdate;
	}

	@Override
	public List<RoomBean> getRoom(String hotelName) throws HotelException {
		List<RoomBean> roomList = null;
		int hotelId = 0;
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("hotelmanagementpersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
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
	}

	@Override
	public boolean deleteHotelRoom(int hotelId) throws HotelException {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("hotelmanagementpersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		boolean isDeleted = false;
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			String jpql = "delete from RoomBean where hotelId =: hotelId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("hotelId", hotelId);
			int result = query.executeUpdate();
			entityTransaction.commit();
			isDeleted = true;

		} catch (Exception e) {
			throw new HotelException("Room cannot be deleted..");
		}
		entityManager.close();
		return isDeleted;
	}

}
