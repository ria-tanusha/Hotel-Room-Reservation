package com.hotel.room.book.helperConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LocalDateTimeConverter implements Converter<String,LocalDateTime> {

	@Override
	public LocalDateTime convert(String date) {
		return LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
	}


}
