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
import com.capgemini.hotelbookingmanagement.customexeption.HotelException;
@Repository
public class HotelDAOImplementation implements HotelDAO {
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	@Override
	public boolean addHotel(HotelBean hotelBean) throws HotelException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		boolean isAdded = false;
		try {
			entityTransaction.begin();
			entityManager.persist(hotelBean);
			entityTransaction.commit();
			isAdded = true;
		} catch (Exception e) {
			throw new HotelException("unavailable to add");
		}
		entityManager.close();
		return isAdded;
	}

	@Override
	public boolean removeHotel(int hotelId) throws HotelException {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("hotelmanagementpersistence");
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
			throw new HotelException("No Hotel available to delete");
		}

		entityManager.close();
		return isDeleted;
	}

	@Override
	public boolean updateHotel(HotelBean hotelBean) throws HotelException {
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
				existingHotelInfo.setLocation(location);
			}

			try {
				EntityTransaction entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				entityManager.persist(existingHotelInfo);
				entityTransaction.commit();

				isUpdated = true;

			} catch (Exception e) {
				throw new HotelException("unavailable to update Hotel Details");
			}
			entityManager.close();
		}
		return isUpdated;
	}

	@Override
	public List<HotelBean> getHotelList() throws HotelException {
		EntityManager manager = entityManagerFactory.createEntityManager();
		String jpql = "from HotelBean";
		Query query = manager.createQuery(jpql);

		List<HotelBean> hotelsList = null;
		try {
			hotelsList = query.getResultList();

		} catch (Exception e) {
			throw new HotelException("Unavailable to Show Hotel List");
		}
		return hotelsList;
	}

//	@Override
//	public List<HotelBean> getAllHotel() throws HotelException {
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
//	}

}
