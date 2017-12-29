package com.bigob.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bigob.bean.PatientBean;

@RibbonClient
@FeignClient(name="patient-proxy")
public interface PatientProxy {

	@RequestMapping(method=RequestMethod.POST,value="/patient/create", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addPAtient(@RequestBody PatientBean patientBean);
}
