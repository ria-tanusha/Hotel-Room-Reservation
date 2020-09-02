package com.hotel.room.book.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.room.book.repository.RoomsReservedRepository;

@Service
public class RoomsReservedService {


	@Autowired
	RoomsReservedRepository roomReservedRepository;
	

	public List<Object> getlistFindByReservationId(int reservationId) {
       return roomReservedRepository.getlistFindByReservationId(reservationId);
	}

}
