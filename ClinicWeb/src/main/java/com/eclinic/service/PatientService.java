package com.eclinic.service;

import com.eclinic.domain.Address;
import com.eclinic.domain.Patient;
import com.eclinic.domain.PatientCard;
import com.eclinic.domain.Recipe;
import com.eclinic.domain.SickLeave;
import com.eclinic.domain.Worker;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Patient entities
 * 
 */
public interface PatientService {

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	public Patient deletePatientWorkers(Integer patient_id, Integer related_workers_id);

	/**
	 * Delete an existing Address entity
	 * 
	 */
	public Patient deletePatientAddress(Integer patient_id_1, Integer related_address_id);

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	public void deletePatient(Patient patient);

	/**
	 * Save an existing Worker entity
	 * 
	 */
	public Patient savePatientWorkers(Integer id, Worker related_workers);

	/**
	 */
	public Patient findPatientByPrimaryKey(Integer id_1);

	/**
	 * Delete an existing Recipe entity
	 * 
	 */
	public Patient deletePatientRecipes(Integer patient_id_2, Integer related_recipes_idr);

	/**
	 * Return a count of all Patient entity
	 * 
	 */
	public Integer countPatients();

	/**
	 * Save an existing Patient entity
	 * 
	 */
	public Integer savePatient(Patient patient_1);

	/**
	 * Save an existing SickLeave entity
	 * 
	 */
	public Patient savePatientSickLeaves(Integer id_2, SickLeave related_sickleaves);

	/**
	 * Load an existing Patient entity
	 * 
	 */
	public Set<Patient> loadPatients();

	/**
	 * Save an existing Address entity
	 * 
	 */
	public Patient savePatientAddress(Integer id_3, Address related_address);

	/**
	 * Delete an existing PatientCard entity
	 * 
	 */
	public Patient deletePatientPatientCards(Integer patient_id_3, Integer related_patientcards_id);

	/**
	 * Delete an existing SickLeave entity
	 * 
	 */
	public Patient deletePatientSickLeaves(Integer patient_id_4, Integer related_sickleaves_id);

	/**
	 * Save an existing PatientCard entity
	 * 
	 */
	public Patient savePatientPatientCards(Integer id_4, PatientCard related_patientcards);

	/**
	 * Save an existing Recipe entity
	 * 
	 */
	public Patient savePatientRecipes(Integer id_5, Recipe related_recipes);

	/**
	 * Return all Patient entity
	 * 
	 */
	public List<Patient> findAllPatients(Integer startResult, Integer maxRows);
}