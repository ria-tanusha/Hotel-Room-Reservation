package com.hotel.room.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan({"com.room.reservation.domain.model.*"})
@SpringBootApplication
public class RoomReservationDomainHotelReservationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomReservationDomainHotelReservationSystemApplication.class, args);
	}

}