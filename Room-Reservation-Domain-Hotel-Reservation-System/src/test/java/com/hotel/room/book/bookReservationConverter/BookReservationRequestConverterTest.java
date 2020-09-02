package com.hotel.room.book.bookReservationConverter;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hotel.room.reservation.model.database.Guest;
import com.hotel.room.reservation.model.view.GuestView;
import com.hotel.room.reservation.model.view.RoomBookingViewRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookReservationRequestConverterTest {

	@Autowired
	private BookReservationRequestConverter bookReservationRequestConverter;

	@Test
	public void viewToDatabaseReObjectConverterTest() {

		RoomBookingViewRequest roomBookingRequest = new RoomBookingViewRequest();
		roomBookingRequest.setCheckInDt("2020-08-18");
		roomBookingRequest.setCheckOutDt("2020-08-19");
		GuestView guest = new GuestView();
		guest.setAge(30);
		guest.setFirstName("Ravi");
		guest.setGuestId(1);
		guest.setIdentifierNumber("1234");
		guest.setLastName("Roy");
		guest.setPhoneNumber("9876543210");
		roomBookingRequest.setGuest(guest);
		roomBookingRequest.setGuestCount(1);
		roomBookingRequest.setRoomCount(2);
		roomBookingRequest.setRoomType("1st class");

		Guest guestres = bookReservationRequestConverter.viewToDatabaseReObjectConverter(roomBookingRequest);
		assertNotNull(guestres);

	}

}
