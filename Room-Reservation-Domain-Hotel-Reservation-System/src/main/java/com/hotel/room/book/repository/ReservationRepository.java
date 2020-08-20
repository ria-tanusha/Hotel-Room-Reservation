package com.hotel.room.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.room.reservation.domain.model.database.Reservation;

@Repository
public interface ReservationRepository  extends JpaRepository<Reservation, Integer> {

}
