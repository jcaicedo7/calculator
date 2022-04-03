package com.capitole.scm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDate {
	private final static String PATTERN = "dd-MM-yyyy HH:mm:ss";

	public static String dateToString(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(PATTERN);
		String dateString = formatter.format(date);
		return dateString;
	}	
}