package com.bigob.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bigob.bean.PatientBean;

@Service
public interface PatientService {

	public PatientBean createPatient(PatientBean patientBean);

	public PatientBean getPatientById(Integer pId);

	public List<PatientBean> getAllPatient();
	
	public String deletePatient(Integer pId);
	
	public List<PatientBean> getAllPatientByName(String name);
}
