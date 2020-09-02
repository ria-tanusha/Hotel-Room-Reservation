package com.hotel.room.book.processor;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.room.book.exceptionhandling.NoReservationFoundException;
import com.hotel.room.book.service.ReservationService;
import com.hotel.room.book.viewReservationConverter.ViewReservationResponseConverter;
import com.hotel.room.reservation.model.database.Reservation;
import com.hotel.room.reservation.model.view.ViewReservationRequest;
import com.hotel.room.reservation.model.view.ViewReservationResponse;

@Service
public class ViewReservationProcessor {

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private ViewReservationResponseConverter viewReservationResponseConverter;

	public ViewReservationResponse process(ViewReservationRequest viewReservationRequest) {

		// Create Reservation through JPA repository layer
		Reservation reservation = reservationService.viewEntity(viewReservationRequest.getReservationId());
		if (Objects.isNull(reservation)) {
			throw new NoReservationFoundException("Invalid Reservation id");
		}

		// Convert Database response into view response
		ViewReservationResponse viewReservationResponse = viewReservationResponseConverter
				.databaseToViewResObjectConverter(reservation);

		return viewReservationResponse;
	}

}
