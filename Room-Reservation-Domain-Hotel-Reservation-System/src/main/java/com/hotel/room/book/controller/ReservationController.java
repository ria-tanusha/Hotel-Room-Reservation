package com.hotel.room.book.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.room.book.processor.BookReservationProcessor;
import com.hotel.room.book.processor.DeleteReservationProcessor;
import com.hotel.room.book.processor.GuestBookingProcessor;
import com.hotel.room.book.processor.ViewReservationProcessor;
import com.room.reservation.domain.model.view.DeleteReservationRequest;
import com.room.reservation.domain.model.view.DeleteReservationResponse;
import com.room.reservation.domain.model.view.GuestViewRequest;
import com.room.reservation.domain.model.view.GuestViewResponse;
import com.room.reservation.domain.model.view.RoomBookingViewRequest;
import com.room.reservation.domain.model.view.RoomBookingViewResponse;
import com.room.reservation.domain.model.view.ViewReservationRequest;
import com.room.reservation.domain.model.view.ViewReservationResponse;

@RestController
@RequestMapping("/Reservation")
public class ReservationController {
	
	@Autowired
	private GuestBookingProcessor guestBookingProcessor;

	@Autowired
	private BookReservationProcessor bookReservationProcessor;
	
	@Autowired
	private ViewReservationProcessor viewReservationProcessor;
	
	@Autowired
	private DeleteReservationProcessor deleteReservationProcessor;

	@GetMapping(path = "/ping")
	@ResponseBody
	public String serviceState() {
		return "Room-Reservation-Domain-Hotel-Reservation-System  is up & running....."
				+ LocalDateTime.now().toString();
	}

	@RequestMapping(value = "/guest", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	GuestViewResponse guestAdd(@RequestBody GuestViewRequest guestViewRequest) {
		return guestBookingProcessor.process(guestViewRequest);
	}
	
	
	@RequestMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	RoomBookingViewResponse bookReservation(@RequestBody RoomBookingViewRequest roomBookingRequest) {
		return bookReservationProcessor.process(roomBookingRequest);
	}
	
	@RequestMapping(value = "/view/{reservationId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	ViewReservationResponse viewReservation(@PathVariable("reservationId") String reservationId ) {
		ViewReservationRequest viewReservationRequest=new ViewReservationRequest();
		viewReservationRequest.setReservationId(Integer.parseInt(reservationId));
		return viewReservationProcessor.process(viewReservationRequest);
	}
	
	@RequestMapping(value = "/delete/{reservationId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	DeleteReservationResponse deleteReservation(@PathVariable("reservationId") String reservationId ) {
		DeleteReservationRequest deleteReservationRequest=new DeleteReservationRequest();
		deleteReservationRequest.setReservationId(Integer.parseInt(reservationId));
		return deleteReservationProcessor.process(deleteReservationRequest);
	}
}
