package com.bigob.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigob.bean.PatientBean;
import com.bigob.dao.PatientDAO;
import com.bigob.domain.Patient;
import com.bigob.util.ServiceUtil;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	PatientDAO dao;
	
	@Autowired
	ServiceUtil utils;
	
	@Override
	public PatientBean createPatient(PatientBean patientBean) {
		return mapDomainToBean(dao.save(mapBeanToDomain(patientBean)));
	}

	@Override
	public PatientBean getPatientById(Integer pId) {
		return null;
	}

	private Patient mapBeanToDomain(PatientBean patientBean) {
		Patient patient=new Patient();
		if(patientBean.getfName().length()>0 && patientBean.getfName()!=null) {
			patient.setfName(patientBean.getfName());
		}
		if(patientBean.getlName().length()>0 && patientBean.getlName()!=null) {
			patient.setlName(patientBean.getlName());
		}
		if(patientBean.getMobile().length()>0 && patientBean.getMobile()!=null) {
			patient.setMobile(patientBean.getMobile());
		}
		if(patientBean.getEmail().length()>0 && patientBean.getEmail()!=null) {
			patient.setEmail(patientBean.getEmail());
		}
		if(patientBean.getCreatedDate().length()>0 && patientBean.getCreatedDate()!=null) {
			patient.setCreatedDate(utils.stringToDate(patientBean.getCreatedDate()));
		}
		return patient;
	}
	
	private PatientBean mapDomainToBean(Patient patient) {
		PatientBean patientBean=new PatientBean();
		if(patient.getfName().length()>0 && patient.getfName()!=null) {
			patientBean.setfName(patientBean.getfName());
		}
		if(patient.getlName().length()>0 && patient.getlName()!=null) {
			patientBean.setlName(patientBean.getlName());
		}
		if(patient.getMobile().length()>0 && patient.getMobile()!=null) {
			patientBean.setMobile(patientBean.getMobile());
		}
		if(patient.getEmail().length()>0 && patient.getEmail()!=null) {
			patientBean.setEmail(patientBean.getEmail());
		}
		if(patient.getCreatedDate()!=null && patient.getCreatedDate() instanceof Date) {
			patientBean.setCreatedDate(utils.dateToString(patient.getCreatedDate()));
		}
		return patientBean;
	}
}
