package com.bigob.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bigob.domain.Doctor;
import com.bigob.util.ServiceConst;

public interface DoctorDAO extends CrudRepository<Doctor, Integer>{

	@Query(value=ServiceConst.GET_DOCTOR_BY_NAME)
	public List<Doctor> getDoctorByName(@Param("name") String name);
}
