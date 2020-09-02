package com.hotel.room.book.validator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import com.hotel.room.book.exceptionhandling.NoReservationFoundException;
import com.hotel.room.reservation.model.view.GuestView;

@Service
public class GuestValidator {

	public void guestDetailsValidation(GuestView guestView) {

		if (Objects.isNull(guestView)) {
			throw new NoReservationFoundException("Please provide guest details");
		}

		if (Strings.isEmpty(guestView.getFirstName())) {
			throw new NoReservationFoundException("Please provide Guest First name");
		}

		if (Strings.isEmpty(guestView.getLastName())) {
			throw new NoReservationFoundException("Please provide Guest Last name");
		}

		if (Strings.isEmpty(guestView.getIdentifierNumber())) {
			throw new NoReservationFoundException("Please provide Guest Identifier number");
		}

		if (Objects.isNull(guestView.getAge())) {
			throw new NoReservationFoundException("Please provide Guest age");
		}

		if (Strings.isEmpty(guestView.getPhoneNumber())) {
			throw new NoReservationFoundException("Please provide Guest mobile number");
		}

		mobileValidation(guestView.getPhoneNumber());
	}

	private void mobileValidation(String phNo) {
		if (phNo.length() < 0) {
			throw new NoReservationFoundException("Please provide 10 digit Guest mobile number");
		}

		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
		Matcher m = p.matcher(phNo);
		boolean flag = (m.find() && m.group().equals(phNo));
		if (flag == false) {
			throw new NoReservationFoundException("Please provide valid Guest mobile number");
		}

	}

}
