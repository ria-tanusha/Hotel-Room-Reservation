package com.hotel.room.book.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.room.book.cancelReservationConverter.CancelReservationRequestConverter;
import com.hotel.room.book.cancelReservationConverter.CancelReservationResponseConverter;
import com.hotel.room.book.service.ReservationService;
import com.hotel.room.reservation.model.database.Reservation;
import com.hotel.room.reservation.model.view.DeleteReservationRequest;
import com.hotel.room.reservation.model.view.DeleteReservationResponse;

@Service
public class DeleteReservationProcessor {

	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private CancelReservationRequestConverter cancelReservationRequestConverter;

	@Autowired
	private CancelReservationResponseConverter cancelReservationResponseConverter;

	public DeleteReservationResponse process(DeleteReservationRequest deleteReservationRequest) {

		// Convert View request into Database request
		Reservation reservation = cancelReservationRequestConverter.viewToDatabaseReObjectConverter(deleteReservationRequest);

		// Delete Reservation through JPA repository layer
		reservationService.createOrUpdate(reservation);

		// Convert Database response into view response
		DeleteReservationResponse deleteReservationResponse = cancelReservationResponseConverter
				.databaseToViewResObjectConverter();

		return deleteReservationResponse;
	}

}
