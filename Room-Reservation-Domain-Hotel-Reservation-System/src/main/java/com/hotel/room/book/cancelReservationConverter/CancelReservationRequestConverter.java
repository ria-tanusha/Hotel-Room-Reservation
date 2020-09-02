package com.hotel.room.book.cancelReservationConverter;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.room.book.exceptionhandling.NoReservationFoundException;
import com.hotel.room.book.service.ReservationService;
import com.hotel.room.book.service.RoomsReservedService;
import com.hotel.room.reservation.model.database.Reservation;
import com.hotel.room.reservation.model.database.RoomsReserved;
import com.hotel.room.reservation.model.view.DeleteReservationRequest;

@Service
public class CancelReservationRequestConverter {

	@Autowired
	private RoomsReservedService roomsReservedService;

	@Autowired
	private ReservationService reservationService;

	public Reservation viewToDatabaseReObjectConverter(DeleteReservationRequest deleteReservationRequest) {

		int reservationId = deleteReservationRequest.getReservationId();
		Reservation reservation = reservationService.viewEntity(reservationId);
		if (Objects.isNull(reservation)) {
			throw new NoReservationFoundException("Invalid Reservation id");
		}

		reservation.setActive(false);

		// Fetch list of Database entity RoomReserved using reservationId
		List<Object> roomsReservedList = roomsReservedService.getlistFindByReservationId(reservationId);
		if (roomsReservedList.size() > 0) {
			roomsReservedList.stream().forEach(roomRes -> {
				RoomsReserved roomReserved = RoomsReserved.class.cast(roomRes);
				roomReserved.setActive(false);
			});
		}

		return reservation;
	}

}
