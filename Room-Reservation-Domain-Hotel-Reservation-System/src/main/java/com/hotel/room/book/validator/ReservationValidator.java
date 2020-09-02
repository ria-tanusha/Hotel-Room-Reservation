package com.hotel.room.book.validator;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import com.hotel.room.book.exceptionhandling.NoReservationFoundException;
import com.hotel.room.reservation.model.view.RoomBookingViewRequest;

@Service
public class ReservationValidator {

	public void reservationValidation(RoomBookingViewRequest roomBookingRequest) {

		if (Strings.isEmpty(roomBookingRequest.getCheckInDt())) {
			throw new NoReservationFoundException("Please provide Reservation Check-In-date");
		}

		if (Strings.isEmpty(roomBookingRequest.getCheckOutDt())) {
			throw new NoReservationFoundException("Please provide Reservation Check-Out-date");
		}
	}
}
