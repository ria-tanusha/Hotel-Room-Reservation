package com.hotel.room.book.processor;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hotel.room.book.exceptionhandling.NoReservationFoundException;
import com.hotel.room.reservation.model.view.RoomBookingViewRequest;
import com.hotel.room.reservation.model.view.RoomBookingViewResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookReservationProcessorTest {

	@Autowired
	private BookReservationProcessor bookReservationProcessor;

	@Test
	public void processTest() {

		RoomBookingViewRequest roomBookingRequest = new RoomBookingViewRequest();
		roomBookingRequest.setCheckInDt(null);

		try {
			RoomBookingViewResponse roomBookingViewResponse = bookReservationProcessor.process(roomBookingRequest);
			assertNotNull(roomBookingViewResponse);
		} catch (NoReservationFoundException ex) {
			ex.getMessage();
		}
	}

}
