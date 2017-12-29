package com.bigob.util;

public interface ServiceConstand {
	String DATE_FORMAT="patient.date.format";
	String PATIENT_BY_NAME="from Patient pat where pat.fName like %"+":name"+"%";
}
