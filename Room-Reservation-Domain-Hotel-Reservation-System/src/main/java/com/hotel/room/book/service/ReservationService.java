package com.hotel.room.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.room.book.repository.ReservationRepository;
import com.room.reservation.domain.model.database.Reservation;

@Service
public class ReservationService implements CRUDService {
	
	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public void onCreate(Object obj) {
		reservationRepository.save(Reservation.class.cast(obj));
	}

	@Override
	public Reservation onView(String identifier_number) {
		Optional<Reservation> reservationOpt=reservationRepository.findById(Integer.parseInt(identifier_number));
		if(reservationOpt.isPresent()) {
			 return reservationOpt.get();
		}
		return new Reservation();
	}

	@Override
	public void onUpdate() {
	}

	@Override
	public void onDelete() {
	}

	@Override
	public List<Object> getlistFindByAnotherField(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	

}
