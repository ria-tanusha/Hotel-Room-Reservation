package com.hotel.room.book.bookReservationConverter;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hotel.room.reservation.model.view.RoomBookingViewResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookReservationResponseConverterTest {

	@Autowired
	private BookReservationResponseConverter bookReservationResponseConverter;

	@Test
	public void databaseToViewResObjectConverterTst() {

		RoomBookingViewResponse roomBookingViewResponse = bookReservationResponseConverter
				.databaseToViewResObjectConverter();
		assertNotNull(roomBookingViewResponse);

	}

}
