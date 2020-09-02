package com.hotel.room.book.exceptionhandling;

public class NoReservationFoundException extends RuntimeException {

	String message;

	public NoReservationFoundException(String message) {
		this.message = message;
	}

	public String toString() {
		return message;
	}
}
