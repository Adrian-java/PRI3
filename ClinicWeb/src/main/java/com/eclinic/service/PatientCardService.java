package com.eclinic.service;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.PatientCard;
import com.eclinic.domain.Visit;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for PatientCard entities
 * 
 */
public interface PatientCardService {

	/**
	 * Save an existing Patient entity
	 * 
	 */
	public PatientCard savePatientCardPatient(Integer id, Patient related_patient);

	/**
	 * Return a count of all PatientCard entity
	 * 
	 */
	public Integer countPatientCards();

	/**
	 * Return all PatientCard entity
	 * 
	 */
	public List<PatientCard> findAllPatientCards(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	public PatientCard deletePatientCardPatient(Integer patientcard_id, Integer related_patient_id);

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	public PatientCard deletePatientCardDoctor(Integer patientcard_id_1, Integer related_doctor_id);

	/**
	 * Load an existing PatientCard entity
	 * 
	 */
	public Set<PatientCard> loadPatientCards();

	/**
	 * Delete an existing PatientCard entity
	 * 
	 */
	public void deletePatientCard(PatientCard patientcard);

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	public PatientCard savePatientCardDoctor(Integer id_1, Doctor related_doctor);

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	public PatientCard deletePatientCardVisits(Integer patientcard_id_2, Integer related_visits_id);

	/**
	 * Save an existing Visit entity
	 * 
	 */
	public PatientCard savePatientCardVisits(Integer id_2, Visit related_visits);

	/**
	 * Save an existing PatientCard entity
	 * 
	 */
	public Integer savePatientCard(PatientCard patientcard_1);

	/**
	 */
	public PatientCard findPatientCardByPrimaryKey(Integer id_3);
}