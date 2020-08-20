package com.hotel.room.book.viewReservationConverter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.room.book.service.GuestService;
import com.hotel.room.book.service.RoomService;
import com.hotel.room.book.service.RoomsReservedService;
import com.room.reservation.domain.model.database.Guest;
import com.room.reservation.domain.model.database.Reservation;
import com.room.reservation.domain.model.database.Room;
import com.room.reservation.domain.model.database.RoomsReserved;
import com.room.reservation.domain.model.view.GuestViewRequest;
import com.room.reservation.domain.model.view.RoomView;
import com.room.reservation.domain.model.view.StatusView;
import com.room.reservation.domain.model.view.ViewReservationResponse;

@Service
public class ViewReservationResponseConverter {

	@Autowired
	private GuestService guestService;
	
	@Autowired
	private RoomService roomService;

	@Autowired
	private RoomsReservedService roomsReservedService;

	public ViewReservationResponse databaseToViewResObjectConverter(Reservation reservation) {

		ViewReservationResponse viewReservationResponse = new ViewReservationResponse();
		viewReservationResponse.setCheckInDt(reservation.getCheck_in_date());
		viewReservationResponse.setCheckOutDt(reservation.getCheck_out_date());

		Guest guest = guestService.onView(String.valueOf(reservation.getGuest().getGuest_id()));

		// Prepare Guest View Information
		GuestViewRequest guestViewRequest = new GuestViewRequest();
		guestViewRequest.setAge(guest.getAge());
		guestViewRequest.setFirstName(guest.getFirst_name());
		guestViewRequest.setLastName(guest.getLast_name());
		guestViewRequest.setIdentifierNumber(guest.getIdentifier_number());
		guestViewRequest.setPhoneNumber(guest.getPhone());
		viewReservationResponse.setGuest(guestViewRequest);

		// Prepare multiple Room View Information
		List<RoomView> rooms=new ArrayList();
		int reservationId = reservation.getReservation_id();
		
		// Fetch list of Database entity RoomReserved using reservationId
		List<Object> roomsReservedList = roomsReservedService.getlistFindByAnotherField(String.valueOf(reservationId));
		if (roomsReservedList.size() > 0) {
			roomsReservedList.stream().forEach(roomRes -> {
				RoomsReserved roomReserved = RoomsReserved.class.cast(roomRes);
				String roomNumber=roomReserved.getRooms_booked();
				Room room=roomService.onView(roomNumber);
				
				//Prepare each room deatils
				RoomView roomView=new RoomView();
				roomView.setRoomFeatures(room.getRoom_features());
				roomView.setRoomNumber(room.getRoom_number());
				roomView.setRoomRate(room.getRoom_rate());
				roomView.setRoomType(room.getRoom_type());
				rooms.add(roomView);
			});
		}
		viewReservationResponse.setRooms(rooms);

		// viewReservationResponse.setGuestCount(guestCount);

		// Prepare Status
		StatusView status = new StatusView();
		status.setMessage("SUCCESS");
		status.setStatusCode("200 OK status code");
		viewReservationResponse.setStatus(status);
		
		return viewReservationResponse;
	}
}
