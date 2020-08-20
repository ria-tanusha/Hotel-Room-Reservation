package com.hotel.room.book.guestBookConverter;

import org.springframework.stereotype.Service;

import com.room.reservation.domain.model.view.GuestViewResponse;
import com.room.reservation.domain.model.view.StatusView;

@Service
public class GuestBookResponseConverter {

	public GuestViewResponse databaseToViewResObjectConverter() {

		GuestViewResponse guestViewResponse = new GuestViewResponse();
		guestViewResponse.setReason("Success with Guest Information");
		StatusView status=new StatusView();
		status.setMessage("SUCCESS");
		status.setStatusCode("200 OK status code");
		guestViewResponse.setStatus(status);
		return guestViewResponse;
	}
}
