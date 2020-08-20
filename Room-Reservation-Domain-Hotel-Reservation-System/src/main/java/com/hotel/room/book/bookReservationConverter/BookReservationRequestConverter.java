package com.hotel.room.book.bookReservationConverter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.room.book.helperConverter.LocalDateTimeConverter;
import com.hotel.room.book.service.GuestService;
import com.hotel.room.book.service.RoomService;
import com.room.reservation.domain.model.database.Guest;
import com.room.reservation.domain.model.database.Reservation;
import com.room.reservation.domain.model.database.Room;
import com.room.reservation.domain.model.database.RoomsReserved;
import com.room.reservation.domain.model.view.GuestViewRequest;
import com.room.reservation.domain.model.view.RoomBookingViewRequest;
import com.room.reservation.domain.model.view.RoomView;

@Service
public class BookReservationRequestConverter {

	@Autowired
	private LocalDateTimeConverter localDateTimeConverter;

	@Autowired
	private GuestService guestService;
	
	@Autowired
	private RoomService roomService;

	public Guest viewToDatabaseReObjectConverter(RoomBookingViewRequest roomBookingRequest) {

		// Fetch View Payload GuestView
		GuestViewRequest guestview = roomBookingRequest.getGuest();

		// Fetch View Payload RoomView
		RoomView roomView = roomBookingRequest.getRoom();

		// Prepare Database entity Guest
		Guest dbGuest = new Guest();
		dbGuest.setAge(guestview.getAge());
		dbGuest.setFirst_name(guestview.getFirstName());
		dbGuest.setIdentifier_number(guestview.getIdentifierNumber());
		dbGuest.setLast_name(guestview.getLastName());
		dbGuest.setPhone(guestview.getPhoneNumber());

		List<RoomsReserved> roomsReservedList = new ArrayList();
		// Prepare Database entity RoomReserved
		RoomsReserved roomsReserved = new RoomsReserved();
		roomsReserved.setActive(true);
		roomsReserved.setReserved_date(roomBookingRequest.getCheckInDt());
		roomsReserved.setRoom_type(roomView.getRoomType());
		roomsReserved.setRooms_booked(String.valueOf(roomView.getRoomNumber()));
		roomsReservedList.add(roomsReserved);

		List<Reservation> reservationList = new ArrayList();
		// Prepare Database entity Reservation
		Reservation reservation = new Reservation();
		reservation.setCheck_in_date(roomBookingRequest.getCheckInDt());
		reservation.setCheck_out_date(roomBookingRequest.getCheckOutDt());
		reservation.setActive(true);
		reservation.setRoomsReserveds(roomsReservedList);
		reservationList.add(reservation);

		// Set ReservationList into Guest
		dbGuest.setReservations(reservationList);

		// Prepare Database entity Room
		Room room = new Room();
		room.setRoom_features(roomView.getRoomFeatures());
		room.setRoom_type(roomView.getRoomType());
		room.setRoom_rate(roomView.getRoomRate());
		roomService.onCreate(room);
		
		return dbGuest;
	}
}
