package com.bigob.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bigob.bean.DoctorBean;

@Service
public interface DoctorService {

	public List<DoctorBean> getAllDoctor();

	public DoctorBean ceateDoctor(DoctorBean doctorBean);

	public DoctorBean getDoctorById(Integer dId);

	public List<DoctorBean> getDoctrsByName(String name);

	public String deleteDoctor(Integer dId);
}
