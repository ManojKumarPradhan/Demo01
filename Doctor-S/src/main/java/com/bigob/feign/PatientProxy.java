package com.bigob.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bigob.bean.PatientBean;

//@FeignClient(name = "patient")
@FeignClient(name = "ZUULAPI")
public interface PatientProxy {

	@RequestMapping(method = RequestMethod.POST, value = "/api/patient/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addPatient(@RequestBody PatientBean patientBean);
}
