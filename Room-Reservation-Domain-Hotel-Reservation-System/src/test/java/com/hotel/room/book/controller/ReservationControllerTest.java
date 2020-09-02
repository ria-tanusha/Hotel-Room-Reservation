package com.hotel.room.book.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hotel.room.book.processor.BookReservationProcessor;
import com.hotel.room.book.processor.DeleteReservationProcessor;
import com.hotel.room.book.processor.ViewReservationProcessor;
import com.hotel.room.reservation.model.view.DeleteReservationResponse;
import com.hotel.room.reservation.model.view.RoomBookingViewRequest;
import com.hotel.room.reservation.model.view.RoomBookingViewResponse;
import com.hotel.room.reservation.model.view.ViewReservationResponse;

@ExtendWith(MockitoExtension.class)
public class ReservationControllerTest {

	@InjectMocks
	private ReservationController reservationController;
	
	@Mock
	private BookReservationProcessor bookReservationProcessor;

	@Mock
	private ViewReservationProcessor viewReservationProcessor;

	@Mock
	private DeleteReservationProcessor deleteReservationProcessor;
	
	@Test
	public  void serviceStateTest() {
		reservationController.serviceState();
	}
	
	@Test
	public  void bookReservationTest() {
		RoomBookingViewRequest roomBookingRequest=new RoomBookingViewRequest();
		
		RoomBookingViewResponse res=new RoomBookingViewResponse();
		when(bookReservationProcessor.process(any())).thenReturn(res);
		reservationController.bookReservation(roomBookingRequest);
	}
	
	@Test
	public  void viewReservationTest() {
		
		ViewReservationResponse res=new ViewReservationResponse();
		when(viewReservationProcessor.process(any())).thenReturn(res);
		reservationController.viewReservation("10");
	}
	
	@Test
	public  void deleteReservationTest() {
		
		DeleteReservationResponse res=new DeleteReservationResponse();
		when(deleteReservationProcessor.process(any())).thenReturn(res);
		reservationController.deleteReservation("10");
	}
}
