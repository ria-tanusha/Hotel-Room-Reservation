package com.hotel.room.book.cancelReservationConverter;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hotel.room.book.exceptionhandling.NoReservationFoundException;
import com.hotel.room.reservation.model.database.Reservation;
import com.hotel.room.reservation.model.view.DeleteReservationRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CancelReservationRequestConverterTest {

	@Autowired
	private CancelReservationRequestConverter cancelReservationRequestConverter;

	@Test
	public void viewToDatabaseReObjectConverterTest() {

		DeleteReservationRequest deleteReservationRequest = new DeleteReservationRequest();
		deleteReservationRequest.setReservationId(11);

		Reservation reservation = cancelReservationRequestConverter
				.viewToDatabaseReObjectConverter(deleteReservationRequest);
		assertNotNull(reservation);

	}

	@Test
	public void viewToDatabaseReObjectConverterWithInvalidIdTest() {

		DeleteReservationRequest deleteReservationRequest = new DeleteReservationRequest();
		deleteReservationRequest.setReservationId(10);

		try {
			Reservation reservation = cancelReservationRequestConverter
					.viewToDatabaseReObjectConverter(deleteReservationRequest);
			assertNotNull(reservation);
		} catch (NoReservationFoundException ex) {
			ex.getMessage();
		}

	}
}
