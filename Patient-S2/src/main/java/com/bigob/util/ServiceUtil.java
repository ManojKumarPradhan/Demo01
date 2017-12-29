package com.bigob.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceUtil {

	@Autowired
	PropertyUtil prop;
	
	public Date stringToDate(String sDate) {
		Date date=null;
		try {
			date=new SimpleDateFormat(prop.getDateFormatByKey(ServiceConstand.DATE_FORMAT)).parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public String dateToString(Date date) {
		return new SimpleDateFormat(prop.getDateFormatByKey(ServiceConstand.DATE_FORMAT)).format(date);
	}
}
