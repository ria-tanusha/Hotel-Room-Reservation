package com.hotel.room.book.bookReservationConverter;

import org.springframework.stereotype.Service;

import com.hotel.room.reservation.model.view.RoomBookingViewResponse;
import com.hotel.room.reservation.model.view.StatusView;

@Service
public class BookReservationResponseConverter {

	public RoomBookingViewResponse databaseToViewResObjectConverter() {

		RoomBookingViewResponse roomBookingResponse = new RoomBookingViewResponse();
		StatusView status=new StatusView();
		status.setMessage("Reservation is successfully booked");
		status.setStatusCode("SUCCESS with 200 OK status code");
		roomBookingResponse.setStatus(status);
		return roomBookingResponse;
	}

}
