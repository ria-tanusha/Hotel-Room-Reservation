package com.hotel.room.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hotel.room.reservation.model.database.RoomsReserved;

@Repository
public interface RoomsReservedRepository extends JpaRepository<RoomsReserved, Integer>{
	
	@Query("Select rr from RoomsReserved rr where rr.reservation.reservation_id = :reservationId")
	public List<Object> getlistFindByReservationId(@Param("reservationId") int reservationId);
}
