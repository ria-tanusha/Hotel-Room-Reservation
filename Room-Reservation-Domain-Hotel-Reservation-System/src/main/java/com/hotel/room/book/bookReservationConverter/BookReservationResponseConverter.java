package com.hotel.room.book.bookReservationConverter;

import org.springframework.stereotype.Service;

import com.room.reservation.domain.model.view.RoomBookingViewResponse;
import com.room.reservation.domain.model.view.StatusView;

@Service
public class BookReservationResponseConverter {

	public RoomBookingViewResponse databaseToViewResObjectConverter() {

		RoomBookingViewResponse roomBookingResponse = new RoomBookingViewResponse();
		roomBookingResponse.setReason("Success with Book Reservation");
		StatusView status=new StatusView();
		status.setMessage("SUCCESS");
		status.setStatusCode("200 OK status code");
		roomBookingResponse.setStatus(status);
		return roomBookingResponse;
	}

}
