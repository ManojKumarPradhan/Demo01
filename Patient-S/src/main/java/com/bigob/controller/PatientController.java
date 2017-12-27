package com.bigob.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bigob.bean.PatientBean;
import com.bigob.service.PatientService;
import com.bigob.util.PropertyUtil;
import com.bigob.util.ServiceConstand;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	PatientService patientService;
	
	@Autowired
	PropertyUtil prop;
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ResponseEntity<String> createPatient(@RequestBody PatientBean patientBean){
		patientBean.setCreatedDate(getFrmatedStringDate(prop.getDateFormatByKey(ServiceConstand.DATE_FORMAT)));
		JsonObject jsonObject=new JsonObject();
		jsonObject.addProperty("patientBean", patientService.createPatient(patientBean).toString());
		jsonObject.addProperty("status", HttpStatus.CREATED.toString());
		return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.CREATED);
	}
	
	
	
	private String getFrmatedStringDate(String sDate) {
		return new SimpleDateFormat(sDate).format(new Date());
	}
}
