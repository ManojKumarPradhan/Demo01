package com.bigob.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigob.bean.DoctorBean;
import com.bigob.dao.DoctorDAO;
import com.bigob.domain.Doctor;
import com.bigob.util.ServiceUtil;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	ServiceUtil util;
	
	@Autowired
	DoctorDAO dao;
	
	@Override
	public List<DoctorBean> getAllDoctor() {
		List<DoctorBean> doctorBeans=new ArrayList<>();
		dao.findAll().forEach(doctor->{
			doctorBeans.add(mapDomainToBean(doctor));
		});
		return doctorBeans;
	}

	@Override
	public DoctorBean ceateDoctor(DoctorBean doctorBean) {
		return mapDomainToBean(dao.save(mapBeanToDomain(doctorBean)));
	}

	@Override
	public DoctorBean getDoctorById(Integer dId) {
		return mapDomainToBean(dao.findOne(dId));
	}

	@Override
	public List<DoctorBean> getDoctrsByName(String name) {
		List<DoctorBean> doctorBeans=new ArrayList<>();
		dao.getDoctorByName(name).forEach(doctor->{
			doctorBeans.add(mapDomainToBean(doctor));
		});
		return doctorBeans;
	}

	@Override
	public String deleteDoctor(Integer dId) {
		dao.delete(dId);
		return (dao.findOne(dId) instanceof Doctor) ? "Doctor is Not delected " : " Doctor information is clear from Database" ;
	}

	private DoctorBean mapDomainToBean(Doctor doctor) {
		DoctorBean doctorBean=new DoctorBean();
		if(doctor.getdId()>0 && doctor.getdId()!=null) {
			doctorBean.setdId(doctor.getdId());
		}
		if(doctor.getfName().length()>0 && doctor.getfName()!=null) {
			doctorBean.setfName(doctor.getfName());
		}
		if(doctor.getLname().length()>0 && doctor.getLname()!=null) {
			doctorBean.setLname(doctor.getLname());
		}
		if(doctor.getMobile().length()>0 && doctor.getMobile()!=null) {
			doctorBean.setMonile(doctor.getMobile());
		}
		if(doctor.getEmail().length()>0 && doctor.getMobile()!=null) {
			doctorBean.setEmail(doctor.getMobile());
		}
		if(doctor.getEntryTime().length()>0 && doctor.getEntryTime()!=null) {
			doctorBean.setEntryTime(doctor.getEntryTime());
		}
		if(doctor.getExitTime().length()>0 && doctor.getExitTime()!=null) {
			doctorBean.setExitTime(doctor.getExitTime());
		}
		if(doctor.getJoiningDate() != null && doctor.getJoiningDate() instanceof Date) {
			doctorBean.setJoiningDate(util.dateToString(doctor.getJoiningDate()));
		}
		return doctorBean;
	}
	
	private Doctor mapBeanToDomain(DoctorBean doctorBean) {
		Doctor doctor=new Doctor();
		if(doctorBean.getfName().length()>0 && doctorBean.getfName() !=null ) {
			doctor.setfName(doctorBean.getfName());
		}
		if(doctorBean.getLname().length()>0 && doctorBean.getLname() !=null ) {
			doctor.setLname(doctorBean.getLname());
		}
		if(doctorBean.getMonile().length()>0 && doctorBean.getMonile() !=null ) {
			doctor.setMobile(doctorBean.getMonile());
		}
		if(doctorBean.getEmail().length()>0 && doctorBean.getEmail() !=null ) {
			doctor.setEmail(doctorBean.getEmail());
		}
		if(doctorBean.getEntryTime().length()>0 && doctorBean.getEntryTime() !=null ) {
			doctor.setEntryTime(doctorBean.getEntryTime());
		}
		if(doctorBean.getExitTime().length()>0 && doctorBean.getExitTime() !=null ) {
			doctor.setExitTime(doctorBean.getExitTime());
		}
		if(doctorBean.getJoiningDate()!=null && doctorBean.getJoiningDate().length()>0) {
			doctor.setJoiningDate(util.stringToDate(doctorBean.getJoiningDate()));
		}
		return doctor;
	}
}
