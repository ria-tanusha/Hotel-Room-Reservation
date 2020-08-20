package com.hotel.room.book.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.room.book.service.ReservationService;
import com.hotel.room.book.viewReservationConverter.ViewReservationResponseConverter;
import com.room.reservation.domain.model.database.Reservation;
import com.room.reservation.domain.model.view.ViewReservationRequest;
import com.room.reservation.domain.model.view.ViewReservationResponse;

@Service
public class ViewReservationProcessor {

	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private ViewReservationResponseConverter viewReservationResponseConverter;

	public ViewReservationResponse process(ViewReservationRequest viewReservationRequest) {

		// Create Reservation through JPA repository layer
		Reservation reservation=reservationService.onView(String.valueOf(viewReservationRequest.getReservationId()));;

		// Convert Database response into view response
		ViewReservationResponse viewReservationResponse = viewReservationResponseConverter
				.databaseToViewResObjectConverter(reservation);

		return viewReservationResponse;
	}

}
