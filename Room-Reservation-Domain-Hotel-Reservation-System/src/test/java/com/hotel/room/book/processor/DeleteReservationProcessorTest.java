package com.hotel.room.book.processor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DeleteReservationProcessorTest {

	@InjectMocks
	private DeleteReservationProcessor deleteReservationProcessor;

	@Test
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void processTest() {

	}
}
