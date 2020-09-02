package com.hotel.room.book.cancelReservationConverter;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hotel.room.reservation.model.view.DeleteReservationResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CancelReservationResponseConverterTest {

	@Autowired
	private CancelReservationResponseConverter cancelReservationResponseConverter;

	@Test
	public void databaseToViewResObjectConverterTst() {

		DeleteReservationResponse deleteReservationResponse = cancelReservationResponseConverter
				.databaseToViewResObjectConverter();
		assertNotNull(deleteReservationResponse);

	}

}
