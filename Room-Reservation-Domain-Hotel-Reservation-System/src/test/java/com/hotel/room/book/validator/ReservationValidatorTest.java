package com.hotel.room.book.validator;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hotel.room.book.exceptionhandling.NoReservationFoundException;
import com.hotel.room.book.processor.BookReservationProcessor;
import com.hotel.room.reservation.model.view.RoomBookingViewRequest;
import com.hotel.room.reservation.model.view.RoomBookingViewResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ReservationValidatorTest {
	
	@Autowired
	private ReservationValidator reservationValidator;

	@Test
	public void reservationValidationCheckInDtTest() {
		RoomBookingViewRequest roomBookingRequest = new RoomBookingViewRequest();
		roomBookingRequest.setCheckInDt(null);

		try {
			reservationValidator.reservationValidation(roomBookingRequest);
		} catch (NoReservationFoundException ex) {
			ex.getMessage();
		}
	}
	
	@Test
	public void reservationValidationCheckOutDtTest() {
		RoomBookingViewRequest roomBookingRequest = new RoomBookingViewRequest();
		roomBookingRequest.setCheckInDt("2020-08-19");
		roomBookingRequest.setCheckOutDt(null);

		try {
			reservationValidator.reservationValidation(roomBookingRequest);
		} catch (NoReservationFoundException ex) {
			ex.getMessage();
		}
	}

}
