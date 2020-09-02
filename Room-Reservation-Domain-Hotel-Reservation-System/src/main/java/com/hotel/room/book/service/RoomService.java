package com.hotel.room.book.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.room.book.repository.RoomRepository;
import com.hotel.room.reservation.model.database.Room;


@Service
public class RoomService {
	
	@Autowired
	RoomRepository roomRepository;

	public void onCreate(Object obj) {
		roomRepository.save(Room.class.cast(obj));
	}

	public Room onView(String id) {
		Optional<Room> reservationOpt=roomRepository.findById(Integer.parseInt(id));
		if(reservationOpt.isPresent()) {
			 return reservationOpt.get();
		}
		return new Room();
	}

}
