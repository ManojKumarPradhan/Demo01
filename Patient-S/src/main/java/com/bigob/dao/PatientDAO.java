package com.bigob.dao;

import org.springframework.data.repository.CrudRepository;

import com.bigob.domain.Patient;

public interface PatientDAO extends CrudRepository<Patient, Integer>{

}
