package com.hotel.room.book.cancelReservationConverter;

import org.springframework.stereotype.Service;

import com.hotel.room.reservation.model.view.DeleteReservationResponse;
import com.hotel.room.reservation.model.view.StatusView;

@Service
public class CancelReservationResponseConverter {
	public DeleteReservationResponse databaseToViewResObjectConverter() {

		DeleteReservationResponse deleteReservationResponse = new DeleteReservationResponse();
		// Prepare Status
		StatusView status = new StatusView();
		status.setMessage("Data deleted successfully");
		status.setStatusCode("200 OK status code");
		deleteReservationResponse.setStatus(status);
		
		return deleteReservationResponse;
	}

}
