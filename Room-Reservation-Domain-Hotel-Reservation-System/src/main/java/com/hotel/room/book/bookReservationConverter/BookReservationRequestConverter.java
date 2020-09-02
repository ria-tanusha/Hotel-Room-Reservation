package com.hotel.room.book.bookReservationConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.room.book.service.RoomService;
import com.hotel.room.book.validator.GuestValidator;
import com.hotel.room.reservation.model.database.Guest;
import com.hotel.room.reservation.model.database.Reservation;
import com.hotel.room.reservation.model.database.RoomsReserved;
import com.hotel.room.reservation.model.view.GuestView;
import com.hotel.room.reservation.model.view.RoomBookingViewRequest;

@Service
public class BookReservationRequestConverter {

	@Autowired
	private GuestValidator guestValidator;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public Guest viewToDatabaseReObjectConverter(RoomBookingViewRequest roomBookingRequest) {

		// Fetch View Payload GuestView
		GuestView guestview = roomBookingRequest.getGuest();
		guestValidator.guestDetailsValidation(guestview);

		// Prepare Database entity Guest
		Guest dbGuest = new Guest();
		dbGuest.setAge(guestview.getAge());
		dbGuest.setFirst_name(guestview.getFirstName());
		dbGuest.setIdentifier_number(guestview.getIdentifierNumber());
		dbGuest.setLast_name(guestview.getLastName());
		dbGuest.setPhone(guestview.getPhoneNumber());

		List<Reservation> reservationList = new ArrayList();
		// Prepare Database entity Reservation
		Reservation reservation = new Reservation();
		reservation.setCheck_in_date(roomBookingRequest.getCheckInDt());
		reservation.setCheck_out_date(roomBookingRequest.getCheckOutDt());
		reservation.setActive(true);
		reservation.setGuest_count(roomBookingRequest.getGuestCount());

		List<RoomsReserved> roomsReservedList = new ArrayList();
		LocalDate fromDt = LocalDate.parse(roomBookingRequest.getCheckInDt(), formatter);
		LocalDate toDt = LocalDate.parse(roomBookingRequest.getCheckOutDt(), formatter);
		prepareRoomsReservedList(fromDt, toDt, roomBookingRequest, roomsReservedList);

		// Set & add RoomReservedList into Reservation
		reservation.setRoomsReserveds(roomsReservedList);
		reservationList.add(reservation);

		// Set & add ReservationList into Guest
		dbGuest.setReservations(reservationList);

		return dbGuest;
	}

	private void prepareRoomsReservedList(LocalDate fromDt, LocalDate toDt, RoomBookingViewRequest roomBookingRequest,
			List<RoomsReserved> roomsReservedList) {

		Stream.iterate(fromDt, date -> date.plusDays(1)).limit(ChronoUnit.DAYS.between(fromDt, toDt) + 1)
				.forEach(date -> {

					// Prepare Database entity RoomReserved
					RoomsReserved roomsReserved = new RoomsReserved();
					roomsReserved.setActive(true);
					roomsReserved.setReserved_date(date.toString());
					roomsReserved.setRoom_type(roomBookingRequest.getRoomType());
					roomsReserved.setRooms_booked(String.valueOf(roomBookingRequest.getRoomCount()));
					roomsReservedList.add(roomsReserved);
				});

	}
}
