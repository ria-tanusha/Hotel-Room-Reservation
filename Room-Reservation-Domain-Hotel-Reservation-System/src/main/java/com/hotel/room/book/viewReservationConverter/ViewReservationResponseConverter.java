package com.hotel.room.book.viewReservationConverter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.room.book.service.GuestService;
import com.hotel.room.book.service.RoomsReservedService;
import com.hotel.room.reservation.model.database.Guest;
import com.hotel.room.reservation.model.database.Reservation;
import com.hotel.room.reservation.model.database.RoomsReserved;
import com.hotel.room.reservation.model.view.GuestView;
import com.hotel.room.reservation.model.view.StatusView;
import com.hotel.room.reservation.model.view.ViewReservationResponse;

@Service
public class ViewReservationResponseConverter {

	@Autowired
	private GuestService guestService;

	@Autowired
	private RoomsReservedService roomsReservedService;

	public ViewReservationResponse databaseToViewResObjectConverter(Reservation reservation) {

		// Fetch database Guest information
		Guest guest = guestService.viewEntity(reservation.getGuest().getGuest_id());

		ViewReservationResponse viewReservationResponse = new ViewReservationResponse();
		viewReservationResponse.setCheckInDt(reservation.getCheck_in_date());
		viewReservationResponse.setCheckOutDt(reservation.getCheck_out_date());
		viewReservationResponse.setGuestCount(reservation.getGuest_count());

		// Prepare Guest View Information
		GuestView guestViewRequest = new GuestView();
		guestViewRequest.setAge(guest.getAge());
		guestViewRequest.setFirstName(guest.getFirst_name());
		guestViewRequest.setLastName(guest.getLast_name());
		guestViewRequest.setIdentifierNumber(guest.getIdentifier_number());
		guestViewRequest.setPhoneNumber(guest.getPhone());
		guestViewRequest.setGuestId(guest.getGuest_id());
		viewReservationResponse.setGuest(guestViewRequest);

		int reservationId = reservation.getReservation_id();

		// Fetch list of Database entity RoomReserved using reservationId
		List<Object> roomsReservedList = roomsReservedService.getlistFindByReservationId(reservationId);
		if (roomsReservedList.size() > 0) {
			Object obj = roomsReservedList.get(0);
			RoomsReserved roomReserved = RoomsReserved.class.cast(obj);

			viewReservationResponse.setRoomCounnt(Integer.parseInt(roomReserved.getRooms_booked()));
			viewReservationResponse.setRoomtype(roomReserved.getRoom_type());
		}

		// Prepare Status
		StatusView status = new StatusView();
		status.setMessage("SUCCESS");
		status.setStatusCode("SUCCESS with 200 OK status code");
		viewReservationResponse.setStatus(status);

		return viewReservationResponse;
	}
}
