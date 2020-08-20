package com.hotel.room.book.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.room.book.repository.RoomsReservedRepository;
import com.room.reservation.domain.model.database.RoomsReserved;

@Service
public class RoomsReservedService implements CRUDService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	RoomsReservedRepository roomReservedRepository;
	

	@Override
	public void onCreate(Object obj) {
	}

	@Override
	public RoomsReserved onView(String id) {
		Optional<RoomsReserved> roomsReservedOpt = roomReservedRepository.findById(Integer.parseInt(id));
		if (roomsReservedOpt.isPresent()) {
			return roomsReservedOpt.get();
		}
		return new RoomsReserved();
	}

	@Override
	public void onUpdate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Object> getlistFindByAnotherField(String reservationId) {
		Query query = entityManager
				.createQuery("Select rr from RoomsReserved rr where rr.reservation.reservation_id ='" + Integer.parseInt(reservationId)+"'");
		
		return query.getResultList();
	}

}