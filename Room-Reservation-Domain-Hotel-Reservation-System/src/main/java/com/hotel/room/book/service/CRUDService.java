package com.hotel.room.book.service;

import java.util.List;

public interface CRUDService {

	 public void onCreate(Object obj);
	 
	 public Object onView(String str);
	 
	 public void onUpdate();
	 
	 public void onDelete();
	 
	 public List<Object> getlistFindByAnotherField(String str);
	 
	 
}
