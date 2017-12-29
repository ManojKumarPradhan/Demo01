package com.bigob.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.websocket.server.PathParam;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bigob.bean.PatientBean;
import com.bigob.service.PatientService;
import com.bigob.util.PropertyUtil;
import com.bigob.util.ServiceConstand;
import com.google.gson.JsonObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/patient")
@Api(value="Patient Details", description="CRUD Operation on patient")
public class PatientController {

	@Autowired
	PatientService patientService;

	@Autowired
	PropertyUtil prop;

	@ApiOperation(value="Register A Patient")
	@PostMapping(value = "/create")
	public ResponseEntity<String> createPatient(@RequestBody PatientBean patientBean) {
		patientBean.setCreatedDate(getFrmatedStringDate(prop.getDateFormatByKey(ServiceConstand.DATE_FORMAT)));
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("patientBean", patientService.createPatient(patientBean).toString());
		jsonObject.addProperty("status", HttpStatus.CREATED.toString());
		return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.CREATED);
	}

	@ApiOperation(value="Fetch All Patient")
	@GetMapping("/allPatient")
	public ResponseEntity<String> getAllPatient() {
		ResponseEntity<String> responseEntity = null;
		try {
			JSONObject jsonObject = new JSONObject().put("patientList", patientService.getAllPatient()).put("message",
					"All Patient Fetched");
			responseEntity = new ResponseEntity<String>(jsonObject.toString(), HttpStatus.FOUND);
		} catch (Exception e) {
			try {
				JSONObject jsonObject = new JSONObject().put("Error", "Feching Patient Error");
				responseEntity = new ResponseEntity<String>(jsonObject.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		return responseEntity;
	}
	
	@ApiOperation(value="Register A Patient By ID")
	@GetMapping("/getPatientById")
	public ResponseEntity<PatientBean> getPatientById(@PathParam("pId") Integer pId){
		return  new ResponseEntity<PatientBean>(patientService.getPatientById(pId),HttpStatus.FOUND);
	}
	
	@ApiOperation(value="Discharge A Patient with ID")
	@DeleteMapping("/delete")
	public ResponseEntity<String> deletePatient(@PathParam("pId") Integer pId){
		System.out.println(pId);
		return new ResponseEntity<String>(patientService.deletePatient(pId), HttpStatus.GONE);
	}
	
	@ApiOperation(value="Search All Patient with given Name")
	@GetMapping(value="/byName/{patName}")
	public ResponseEntity<String> getAllPatientByName(@PathVariable("patName") String patName){
		System.out.println(patName);
		ResponseEntity<String> responseEntity = null;
		try {
			/*JSONObject jsonObject = new JSONObject().put("patientList", patientService.getAllPatientByName(patName)).put("message",
					"All Patient Fetched By Name"+patName);*/
			JsonObject jsonObject=new JsonObject();
			jsonObject.addProperty("patients", patientService.getAllPatientByName(patName).toString());
			jsonObject.addProperty("status", HttpStatus.FOUND.toString());
			responseEntity = new ResponseEntity<String>(jsonObject.toString(), HttpStatus.FOUND);
		} catch (Exception e) {
			try {
				JSONObject jsonObject = new JSONObject().put("Error", "Feching Patient Error");
				responseEntity = new ResponseEntity<String>(jsonObject.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		return responseEntity;
	}
	

	private String getFrmatedStringDate(String sDate) {
		return new SimpleDateFormat(sDate).format(new Date());
	}
}
