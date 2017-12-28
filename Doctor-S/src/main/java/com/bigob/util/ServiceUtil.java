package com.bigob.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceUtil {

	@Autowired
	PropertyUtil props;
	
	public String dateToString(Date date) {
		return new SimpleDateFormat(props.getPropertyFromKey(ServiceConst.DATE_fORMAT)).format(date);
	}
	
	public Date stringToDate(String sDate) {
		Date date=null;
		try {
			date= new SimpleDateFormat(props.getPropertyFromKey(ServiceConst.DATE_fORMAT)).parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
