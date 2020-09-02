package com.hotel.room.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EntityScan({"com.hotel.room.reservation.model.*"})
@SpringBootApplication
@EnableEurekaClient
public class RoomReservationDomainHotelReservationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomReservationDomainHotelReservationSystemApplication.class, args);
	}

}
