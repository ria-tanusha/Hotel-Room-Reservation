package com.hotel.room.book.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.room.book.guestBookConverter.GuestBookRequstConverter;
import com.hotel.room.book.guestBookConverter.GuestBookResponseConverter;
import com.hotel.room.book.service.GuestService;
import com.room.reservation.domain.model.database.Guest;
import com.room.reservation.domain.model.view.GuestViewRequest;
import com.room.reservation.domain.model.view.GuestViewResponse;

@Service
public class GuestBookingProcessor {
	
	@Autowired
	private GuestBookRequstConverter guestBookRequstConverter;
	
	@Autowired
	private GuestBookResponseConverter guestBookResponseConverter;
	
	@Autowired
	private GuestService guestService;

	public GuestViewResponse process(GuestViewRequest guestViewRequest) {

		// Convert View request into Database request
		Guest guest = guestBookRequstConverter.viewToDatabaseReObjectConverter(guestViewRequest);

		// Create Guest through JPA repository layer
		guestService.onCreate(guest);

		// Convert Database response into view response
		GuestViewResponse guestViewResponse = guestBookResponseConverter
				.databaseToViewResObjectConverter();

		return guestViewResponse;
	}

}
