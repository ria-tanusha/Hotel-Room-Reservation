package com.hotel.room.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.room.reservation.model.database.Room;

@Repository
public interface RoomRepository  extends JpaRepository<Room, Integer> {

}
