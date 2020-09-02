package com.hotel.room.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.room.reservation.model.database.Guest;

@Repository
public interface GuestRepository  extends JpaRepository<Guest, Integer> {

}
