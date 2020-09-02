package com.hotel.room.book.controller;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.room.book.processor.BookReservationProcessor;
import com.hotel.room.book.processor.DeleteReservationProcessor;
import com.hotel.room.book.processor.ViewReservationProcessor;
import com.hotel.room.reservation.model.view.DeleteReservationRequest;
import com.hotel.room.reservation.model.view.DeleteReservationResponse;
import com.hotel.room.reservation.model.view.Response;
import com.hotel.room.reservation.model.view.RoomBookingViewRequest;
import com.hotel.room.reservation.model.view.RoomBookingViewResponse;
import com.hotel.room.reservation.model.view.ViewReservationRequest;
import com.hotel.room.reservation.model.view.ViewReservationResponse;

@RestController
//@RequestMapping("/reservation")
public class ReservationController {

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

	@RequestMapping(value = "/reservation", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Response<RoomBookingViewResponse>> bookReservation(
			@Valid @RequestBody RoomBookingViewRequest roomBookingRequest) {

		Response response = new Response();
		response.setData(bookReservationProcessor.process(roomBookingRequest));
		response.setMessage("Success Transaction");
		response.setSuccess(true);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/reservation/{reservationId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Response<ViewReservationResponse>> viewReservation(
			@PathVariable("reservationId") String reservationId) {

		ViewReservationRequest viewReservationRequest = new ViewReservationRequest();
		viewReservationRequest.setReservationId(Integer.parseInt(reservationId));

		Response response = new Response();
		response.setData(viewReservationProcessor.process(viewReservationRequest));
		response.setMessage("Success Transaction");
		response.setSuccess(true);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/reservation/{reservationId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	public ResponseEntity<Response<DeleteReservationResponse>> deleteReservation(
			@PathVariable("reservationId") String reservationId) {

		DeleteReservationRequest deleteReservationRequest = new DeleteReservationRequest();
		deleteReservationRequest.setReservationId(Integer.parseInt(reservationId));

		Response response = new Response();
		response.setData(deleteReservationProcessor.process(deleteReservationRequest));
		response.setMessage("Success Transaction");
		response.setSuccess(true);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
