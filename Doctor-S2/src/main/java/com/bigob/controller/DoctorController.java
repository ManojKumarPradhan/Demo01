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

import com.bigob.bean.DoctorBean;
import com.bigob.bean.PatientBean;
import com.bigob.feign.PatientProxy;
import com.bigob.service.DoctorService;
import com.bigob.util.PropertyUtil;
import com.bigob.util.ServiceConst;
import com.google.gson.JsonObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/doctor")
@Api(value = "Doctor-Service", description = "CRUD operation on Doctor")
public class DoctorController {

	@Autowired
	DoctorService doctorService;

	@Autowired
	PropertyUtil props;

	@Autowired
	PatientProxy proxy;

	@ApiOperation("Get All Doctors")
	@GetMapping("/getAllDatoct")
	public ResponseEntity<String> getAllDoctor() {
		ResponseEntity<String> entity = null;
		try {
			JSONObject jsonObject = new JSONObject().put("Doctors", doctorService.getAllDoctor())
					.put("status", HttpStatus.FOUND).put("message", "All Doctr Fetched");
			entity = new ResponseEntity<>(jsonObject.toString(), HttpStatus.FOUND);
		} catch (Exception e) {
			JSONObject jsonObject;
			try {
				jsonObject = new JSONObject().put("Message", "No Doctor FOUND").put("status",
						HttpStatus.INTERNAL_SERVER_ERROR);
				entity = new ResponseEntity<>(jsonObject.toString(), HttpStatus.FOUND);
			} catch (JSONException e1) {
				e1.printStackTrace();
			}

		}
		return entity;
	}

	@ApiOperation("Create A Doctor")
	@PostMapping("/create")
	public ResponseEntity<String> createDoctor(@RequestBody DoctorBean doctorBean) {
		doctorBean.setJoiningDate(getDate());
		return new ResponseEntity<String>(doctorService.ceateDoctor(doctorBean).toString(), HttpStatus.OK);
	}

	@ApiOperation("Get Doctor By ID")
	@GetMapping("/getDoctorById")
	public ResponseEntity<DoctorBean> getDoctorByID(@PathParam("dId") Integer dId) {
		return new ResponseEntity<DoctorBean>(doctorService.getDoctorById(dId), HttpStatus.FOUND);
	}

	@ApiOperation("Delete a Dactor By ID")
	@DeleteMapping("/delete/{dId}")
	public ResponseEntity<String> deleteDoctor(@PathVariable("dId") Integer dId) {
		return new ResponseEntity<String>(doctorService.deleteDoctor(dId), HttpStatus.GONE);
	}

	@GetMapping("/getDoctorByName/{name}")
	public ResponseEntity<String> getDoctorByName(String name) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("DoctorDetails", doctorService.getDoctrsByName(name).toString());
		jsonObject.addProperty("status", HttpStatus.FOUND.toString());
		jsonObject.addProperty("Message", "All the Doctor By name " + name);
		return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.FOUND);
	}

	@ApiOperation("Add Patient in Doctor Service")
	@PostMapping(value = "addPatient", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addPatientByDoctor(@RequestBody PatientBean patientBean) {
		patientBean.setCreatedDate(props.getPropertyFromKey(ServiceConst.DATE_fORMAT));
		return new ResponseEntity<String>(proxy.addPAtient(patientBean).getBody(), HttpStatus.CREATED);
	}

	private String getDate() {
		return new SimpleDateFormat(props.getPropertyFromKey(ServiceConst.DATE_fORMAT)).format(new Date());
	}
}
