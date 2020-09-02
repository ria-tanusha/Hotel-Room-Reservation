package com.hotel.room.book.validator;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hotel.room.book.exceptionhandling.NoReservationFoundException;
import com.hotel.room.reservation.model.view.GuestView;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GuestValidatorTest {
	@Autowired
	private GuestValidator guestValidator;

	@Test
	public void guestDetailsValidationTest() {
		try {
			guestValidator.guestDetailsValidation(null);
		} catch (NoReservationFoundException ex) {
			ex.getMessage();
		}
	}

	@Test
	public void guestDetailsValidationTestforFirstName() {
		GuestView guestView = new GuestView();
		guestView.setAge(1);
		guestView.setFirstName(null);
		guestView.setGuestId(1);
		guestView.setIdentifierNumber("1234");
		guestView.setLastName("Roy");
		guestView.setPhoneNumber("9876543210");
		try {
			guestValidator.guestDetailsValidation(guestView);
		} catch (NoReservationFoundException ex) {
			ex.getMessage();
		}
	}

	@Test
	public void guestDetailsValidationTestforLastName() {
		GuestView guestView = new GuestView();
		guestView.setAge(1);
		guestView.setFirstName("Sona");
		guestView.setGuestId(1);
		guestView.setIdentifierNumber("1234");
		guestView.setLastName(null);
		guestView.setPhoneNumber("9876543210");
		try {
			guestValidator.guestDetailsValidation(guestView);
		} catch (NoReservationFoundException ex) {
			ex.getMessage();
		}
	}

	@Test
	public void guestDetailsValidationTestforAge() {
		GuestView guestView = new GuestView();
		guestView.setFirstName("Sona");
		guestView.setGuestId(1);
		guestView.setIdentifierNumber("1234");
		guestView.setLastName("Roy");
		guestView.setPhoneNumber("9876543210");
		try {
			guestValidator.guestDetailsValidation(guestView);
		} catch (NoReservationFoundException ex) {
			ex.getMessage();
		}
	}

	@Test
	public void guestDetailsValidationTestforIdNumber() {
		GuestView guestView = new GuestView();
		guestView.setAge(65);
		guestView.setFirstName("Sona");
		guestView.setGuestId(1);
		guestView.setIdentifierNumber(null);
		guestView.setLastName("Roy");
		guestView.setPhoneNumber("9876543210");
		try {
			guestValidator.guestDetailsValidation(guestView);
		} catch (NoReservationFoundException ex) {
			ex.getMessage();
		}
	}
	
	@Test
	public void guestDetailsValidationTestforPhNo() {
		GuestView guestView = new GuestView();
		guestView.setAge(65);
		guestView.setFirstName("Sona");
		guestView.setGuestId(1);
		guestView.setIdentifierNumber(null);
		guestView.setLastName("Roy");
		guestView.setPhoneNumber(null);
		try {
			guestValidator.guestDetailsValidation(guestView);
		} catch (NoReservationFoundException ex) {
			ex.getMessage();
		}
	}
}
