package com.bigob.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bigob.domain.Patient;
import com.bigob.util.ServiceConstand;

public interface PatientDAO extends CrudRepository<Patient, Integer>{

	@Query(value=ServiceConstand.PATIENT_BY_NAME)
	public List<Patient> allPatientByName(@Param("name")String name);
}
