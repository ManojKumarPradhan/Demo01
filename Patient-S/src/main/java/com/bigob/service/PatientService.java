package com.bigob.service;

import org.springframework.stereotype.Service;

import com.bigob.bean.PatientBean;

@Service
public interface PatientService {

	public PatientBean createPatient(PatientBean patientBean);
	public PatientBean getPatientById(Integer pId);
}
