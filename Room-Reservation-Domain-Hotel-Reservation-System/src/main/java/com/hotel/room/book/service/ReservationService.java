package com.hotel.room.book.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.room.book.repository.ReservationRepository;
import com.hotel.room.reservation.model.database.Reservation;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;

	public void createOrUpdate(Object obj) {
		reservationRepository.save(Reservation.class.cast(obj));
	}

	public Reservation viewEntity(int id) {
		Optional<Reservation> reservationOpt=reservationRepository.findById(id);
		if(reservationOpt.isPresent()) {
			 return reservationOpt.get();
		}
		return null;
	}


}
