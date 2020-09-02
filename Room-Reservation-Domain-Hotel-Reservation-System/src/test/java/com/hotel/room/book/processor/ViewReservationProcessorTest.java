package com.hotel.room.book.processor;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hotel.room.book.exceptionhandling.NoReservationFoundException;
import com.hotel.room.reservation.model.view.ViewReservationRequest;
import com.hotel.room.reservation.model.view.ViewReservationResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ViewReservationProcessorTest {

	@Autowired
	private ViewReservationProcessor viewReservationProcessor;

	@Test
	public void processTest() {

		ViewReservationRequest viewReservationRequest = new ViewReservationRequest();
		viewReservationRequest.setReservationId(11);

		try {
			ViewReservationResponse viewReservationResponse = viewReservationProcessor.process(viewReservationRequest);
			assertNotNull(viewReservationResponse);
		} catch (NoReservationFoundException ex) {
			ex.getMessage();
		}
	}

	@Test
	public void processTestwithInvalidid() {

		ViewReservationRequest viewReservationRequest = new ViewReservationRequest();
		viewReservationRequest.setReservationId(10);

		try {
			ViewReservationResponse viewReservationResponse = viewReservationProcessor.process(viewReservationRequest);
			assertNotNull(viewReservationResponse);
		} catch (NoReservationFoundException ex) {
			ex.getMessage();
		}
	}

}
