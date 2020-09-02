package com.hotel.room.book.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.room.book.bookReservationConverter.BookReservationRequestConverter;
import com.hotel.room.book.bookReservationConverter.BookReservationResponseConverter;
import com.hotel.room.book.service.GuestService;
import com.hotel.room.reservation.model.database.Guest;
import com.hotel.room.reservation.model.view.RoomBookingViewRequest;
import com.hotel.room.reservation.model.view.RoomBookingViewResponse;

@Service
public class BookReservationProcessor {

	@Autowired
	private GuestService guestService;

	@Autowired
	private BookReservationRequestConverter bookReservationRequestConverter;

	@Autowired
	private BookReservationResponseConverter bookReservationResponseConverter;

	public RoomBookingViewResponse process(RoomBookingViewRequest roomBookingRequest) {

		// Convert View request into Database request
		Guest guest = bookReservationRequestConverter.viewToDatabaseReObjectConverter(roomBookingRequest);

		// Create Reservation through JPA repository layer
		guestService.createOrUpdate(guest);

		// Convert Database response into view response
		RoomBookingViewResponse roomBookingResponse = bookReservationResponseConverter
				.databaseToViewResObjectConverter();

		return roomBookingResponse;
	}

}
