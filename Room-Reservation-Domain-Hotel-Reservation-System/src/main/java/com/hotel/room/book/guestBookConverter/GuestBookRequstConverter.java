package com.hotel.room.book.guestBookConverter;

import org.springframework.stereotype.Service;

import com.room.reservation.domain.model.database.Guest;
import com.room.reservation.domain.model.view.GuestViewRequest;

@Service
public class GuestBookRequstConverter {

	
	public Guest viewToDatabaseReObjectConverter(
			GuestViewRequest guestViewRequest) {

		// Prepare Database entity Guest Information
		Guest dbGuest = new Guest();
		dbGuest.setAge(guestViewRequest.getAge());
		dbGuest.setFirst_name(guestViewRequest.getFirstName());
		dbGuest.setIdentifier_number(guestViewRequest.getIdentifierNumber());
		dbGuest.setLast_name(guestViewRequest.getLastName());
		dbGuest.setPhone(guestViewRequest.getPhoneNumber());

		return dbGuest;
	}
}
