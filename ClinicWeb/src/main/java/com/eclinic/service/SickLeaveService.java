package com.eclinic.service;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.SickLeave;
import com.eclinic.domain.Visit;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for SickLeave entities
 * 
 */
public interface SickLeaveService {

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	public SickLeave deleteSickLeaveDoctor(Integer sickleave_id, Integer related_doctor_id);

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	public SickLeave saveSickLeaveDoctor(Integer id, Doctor related_doctor);

	/**
	 * Load an existing SickLeave entity
	 * 
	 */
	public Set<SickLeave> loadSickLeaves();

	/**
	 */
	public SickLeave findSickLeaveByPrimaryKey(Integer id_1);

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	public SickLeave deleteSickLeavePatient(Integer sickleave_id_1, Integer related_patient_id);

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	public SickLeave deleteSickLeaveVisit(Integer sickleave_id_2, Integer related_visit_id);

	/**
	 * Return a count of all SickLeave entity
	 * 
	 */
	public Integer countSickLeaves();

	/**
	 * Save an existing Visit entity
	 * 
	 */
	public SickLeave saveSickLeaveVisit(Integer id_2, Visit related_visit);

	/**
	 * Save an existing SickLeave entity
	 * 
	 */
	public void saveSickLeave(SickLeave sickleave);

	/**
	 * Delete an existing SickLeave entity
	 * 
	 */
	public void deleteSickLeave(SickLeave sickleave_1);

	/**
	 * Save an existing Patient entity
	 * 
	 */
	public SickLeave saveSickLeavePatient(Integer id_3, Patient related_patient);

	/**
	 * Return all SickLeave entity
	 * 
	 */
	public List<SickLeave> findAllSickLeaves(Integer startResult, Integer maxRows);
}