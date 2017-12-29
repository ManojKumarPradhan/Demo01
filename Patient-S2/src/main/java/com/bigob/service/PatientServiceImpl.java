package com.bigob.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigob.bean.PatientBean;
import com.bigob.dao.PatientDAO;
import com.bigob.domain.Patient;
import com.bigob.util.ServiceUtil;

@Service
public class PatientServiceImpl implements PatientService {

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
		return mapDomainToBean(dao.findOne(pId));
	}

	@Override
	public List<PatientBean> getAllPatient() {
		List<PatientBean> patientsBeans = new ArrayList<>();
		dao.findAll().forEach(patient -> {
			patientsBeans.add(mapDomainToBean(patient));
		});
		return patientsBeans;
	}

	@Override
	public String deletePatient(Integer pId) {
		dao.delete(pId);
		return ((dao.findOne(pId) instanceof Patient)==true)? "Patient Still Exits" : "Patient Discharge Sucessfully" ;
	}
	
	@Override
	public List<PatientBean> getAllPatientByName(String name) {
		List<PatientBean> patientBeans=new ArrayList<>();
		dao.allPatientByName(name).forEach(patient->{
			patientBeans.add(mapDomainToBean(patient));
		});
		return patientBeans;
	}

	
	private Patient mapBeanToDomain(PatientBean patientBean) {
		Patient patient = new Patient();
		if (patientBean.getfName().length() > 0 && patientBean.getfName() != null) {
			patient.setfName(patientBean.getfName());
		}
		if (patientBean.getlName().length() > 0 && patientBean.getlName() != null) {
			patient.setlName(patientBean.getlName());
		}
		if (patientBean.getMobile().length() > 0 && patientBean.getMobile() != null) {
			patient.setMobile(patientBean.getMobile());
		}
		if (patientBean.getEmail().length() > 0 && patientBean.getEmail() != null) {
			patient.setEmail(patientBean.getEmail());
		}
		if (patientBean.getCreatedDate().length() > 0 && patientBean.getCreatedDate() != null) {
			patient.setCreatedDate(utils.stringToDate(patientBean.getCreatedDate()));
		}
		return patient;
	}

	private PatientBean mapDomainToBean(Patient patient) {
		PatientBean patientBean = new PatientBean();
		if (patient.getpId() > 0 && patient.getpId() != null) {
			patientBean.setpId(patient.getpId());
		}
		if (patient.getfName().length() > 0 && patient.getfName() != null) {
			patientBean.setfName(patient.getfName());
		}
		if (patient.getlName().length() > 0 && patient.getlName() != null) {
			patientBean.setlName(patient.getlName());
		}
		if (patient.getMobile().length() > 0 && patient.getMobile() != null) {
			patientBean.setMobile(patient.getMobile());
		}
		if (patient.getEmail().length() > 0 && patient.getEmail() != null) {
			patientBean.setEmail(patient.getEmail());
		}
		if (patient.getCreatedDate() != null && patient.getCreatedDate() instanceof Date) {
			patientBean.setCreatedDate(utils.dateToString(patient.getCreatedDate()));
		}
		return patientBean;
	}

	
	

}
