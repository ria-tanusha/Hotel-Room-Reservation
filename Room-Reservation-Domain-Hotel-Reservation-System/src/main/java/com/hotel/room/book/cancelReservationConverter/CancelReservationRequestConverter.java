package com.hotel.room.book.cancelReservationConverter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.stereotype.Service;

import com.hotel.room.book.repository.RoomsReservedRepository;
import com.hotel.room.book.service.ReservationService;
import com.hotel.room.book.service.RoomsReservedService;
import com.room.reservation.domain.model.database.Guest;
import com.room.reservation.domain.model.database.Reservation;
import com.room.reservation.domain.model.database.RoomsReserved;
import com.room.reservation.domain.model.view.DeleteReservationRequest;

@Service
public class CancelReservationRequestConverter {
	
	@Autowired
	private RoomsReservedService roomsReservedService;
	
	@Autowired
	private ReservationService reservationService;
	
//	@Autowired
//	RoomsReservedRepository roomReservedRepository;

	public Reservation viewToDatabaseReObjectConverter(DeleteReservationRequest deleteReservationRequest) {
		
		int reservationId=deleteReservationRequest.getReservationId();
		Reservation reservation=reservationService.onView(String.valueOf(reservationId));
		reservation.setActive(false);
		
		// Fetch list of Database entity RoomReserved using reservationId
		List<Object> roomsReservedList=roomsReservedService.getlistFindByAnotherField(String.valueOf(reservationId));
		if(roomsReservedList.size()>0) {
			roomsReservedList.stream().forEach(roomRes->{
				RoomsReserved roomReserved=RoomsReserved.class.cast(roomRes);
				roomReserved.setActive(false);
			});
		}
		
		//roomsReservedList.add(roomsReserved);
		//reservation.setRoomsReserveds(roomsReservedList);

		return reservation;
	}

}
