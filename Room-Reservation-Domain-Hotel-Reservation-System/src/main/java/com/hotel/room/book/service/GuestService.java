package com.hotel.room.book.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.room.book.repository.GuestRepository;
import com.hotel.room.reservation.model.database.Guest;

@Service
public class GuestService {

	@Autowired
	private GuestRepository guestRepository;

	public void createOrUpdate(Object obj) {
		guestRepository.save(Guest.class.cast(obj));

	}

	public Guest viewEntity(int id) {
		Optional<Guest> guestOpt = guestRepository.findById(id);
		if (guestOpt.isPresent()) {
			return guestOpt.get();
		}
		return null;
	}
}
