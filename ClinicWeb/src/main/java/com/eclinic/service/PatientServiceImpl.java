package com.eclinic.service;

import com.eclinic.dao.AddressDAO;
import com.eclinic.dao.PatientCardDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.RecipeDAO;
import com.eclinic.dao.SickLeaveDAO;
import com.eclinic.dao.WorkerDAO;

import com.eclinic.domain.Address;
import com.eclinic.domain.Patient;
import com.eclinic.domain.PatientCard;
import com.eclinic.domain.Recipe;
import com.eclinic.domain.SickLeave;
import com.eclinic.domain.Worker;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Patient entities
 * 
 */

@Service("PatientService")
@Transactional
public class PatientServiceImpl implements PatientService {

	/**
	 * DAO injected by Spring that manages Address entities
	 * 
	 */
	@Autowired
	private AddressDAO addressDAO;

	/**
	 * DAO injected by Spring that manages PatientCard entities
	 * 
	 */
	@Autowired
	private PatientCardDAO patientCardDAO;

	/**
	 * DAO injected by Spring that manages Patient entities
	 * 
	 */
	@Autowired
	private PatientDAO patientDAO;

	/**
	 * DAO injected by Spring that manages Recipe entities
	 * 
	 */
	@Autowired
	private RecipeDAO recipeDAO;

	/**
	 * DAO injected by Spring that manages SickLeave entities
	 * 
	 */
	@Autowired
	private SickLeaveDAO sickLeaveDAO;

	/**
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;
	

	/**
	 * Instantiates a new PatientServiceImpl.
	 *
	 */
	public PatientServiceImpl() {
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	@Transactional
	public Patient deletePatientWorkers(Integer patient_id, Integer related_workers_id) {
		Worker related_workers = workerDAO.findWorkerByPrimaryKey(related_workers_id, -1, -1);

		Patient patient = patientDAO.findPatientByPrimaryKey(patient_id, -1, -1);

		related_workers.setPatient(null);
		patient.getWorkers().remove(related_workers);

		workerDAO.remove(related_workers);
		workerDAO.flush();

		return patient;
	}

	/**
	 * Delete an existing Address entity
	 * 
	 */
	@Transactional
	public Patient deletePatientAddress(Integer patient_id, Integer related_address_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(patient_id, -1, -1);
		Address related_address = addressDAO.findAddressByPrimaryKey(related_address_id, -1, -1);

		patient.setAddress(null);
		related_address.getPatients().remove(patient);
		patient = patientDAO.store(patient);
		patientDAO.flush();

		related_address = addressDAO.store(related_address);
		addressDAO.flush();

		addressDAO.remove(related_address);
		addressDAO.flush();

		return patient;
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	@Transactional
	public void deletePatient(Patient patient) {
		patientDAO.remove(patient);
		patientDAO.flush();
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */
	@Transactional
	public Patient savePatientWorkers(Integer id, Worker related_workers) {
		Patient patient = patientDAO.findPatientByPrimaryKey(id, -1, -1);
		Worker existingworkers = workerDAO.findWorkerByPrimaryKey(related_workers.getId());

		// copy into the existing record to preserve existing relationships
		if (existingworkers != null) {
			existingworkers.setId(related_workers.getId());
			related_workers = existingworkers;
		} else {
			related_workers = workerDAO.store(related_workers);
			workerDAO.flush();
		}

		related_workers.setPatient(patient);
		patient.getWorkers().add(related_workers);
		related_workers = workerDAO.store(related_workers);
		workerDAO.flush();

		patient = patientDAO.store(patient);
		patientDAO.flush();

		return patient;
	}

	/**
	 */
	@Transactional
	public Patient findPatientByPrimaryKey(Integer id) {
		return patientDAO.findPatientByPrimaryKey(id);
	}

	/**
	 * Delete an existing Recipe entity
	 * 
	 */
	@Transactional
	public Patient deletePatientRecipes(Integer patient_id, Integer related_recipes_idr) {
		Recipe related_recipes = recipeDAO.findRecipeByPrimaryKey(related_recipes_idr, -1, -1);

		Patient patient = patientDAO.findPatientByPrimaryKey(patient_id, -1, -1);

		related_recipes.setPatient(null);
		patient.getRecipes().remove(related_recipes);

		recipeDAO.remove(related_recipes);
		recipeDAO.flush();

		return patient;
	}

	/**
	 * Return a count of all Patient entity
	 * 
	 */
	@Transactional
	public Integer countPatients() {
		return ((Long) patientDAO.createQuerySingleResult("select count(o) from Patient o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */
	@Transactional
	public Integer savePatient(Patient patient) {
		Patient existingPatient = patientDAO.findPatientByPrimaryKey(patient.getId());

		if (existingPatient != null) {
			if (existingPatient != patient) {
				existingPatient.setId(patient.getId());
				existingPatient.setName(patient.getName());
				existingPatient.setSurname(patient.getSurname());
				existingPatient.setDateOfBirth(patient.getDateOfBirth());
				existingPatient.setEMail(patient.getEMail());
				existingPatient.setPhoneNr(patient.getPhoneNr());
				existingPatient.setConfirmed(patient.getConfirmed());
			}
			patient = patientDAO.store(existingPatient);
		} else {
			patient = patientDAO.store(patient);
		}
		patientDAO.flush();
		return patient.getId();
	}

	/**
	 * Save an existing SickLeave entity
	 * 
	 */
	@Transactional
	public Patient savePatientSickLeaves(Integer id, SickLeave related_sickleaves) {
		Patient patient = patientDAO.findPatientByPrimaryKey(id, -1, -1);
		SickLeave existingsickLeaves = sickLeaveDAO.findSickLeaveByPrimaryKey(related_sickleaves.getId());

		// copy into the existing record to preserve existing relationships
		if (existingsickLeaves != null) {
			existingsickLeaves.setId(related_sickleaves.getId());
			existingsickLeaves.setDateFrom(related_sickleaves.getDateFrom());
			existingsickLeaves.setDateTo(related_sickleaves.getDateTo());
			related_sickleaves = existingsickLeaves;
		}

		related_sickleaves.setPatient(patient);
		patient.getSickLeaves().add(related_sickleaves);
		related_sickleaves = sickLeaveDAO.store(related_sickleaves);
		sickLeaveDAO.flush();

		patient = patientDAO.store(patient);
		patientDAO.flush();

		return patient;
	}

	/**
	 * Load an existing Patient entity
	 * 
	 */
	@Transactional
	public Set<Patient> loadPatients() {
		return patientDAO.findAllPatients();
	}

	/**
	 * Save an existing Address entity
	 * 
	 */
	@Transactional
	public Patient savePatientAddress(Integer id, Address related_address) {
		Patient patient = patientDAO.findPatientByPrimaryKey(id, -1, -1);
		Address existingaddress = addressDAO.findAddressByPrimaryKey(related_address.getId());

		// copy into the existing record to preserve existing relationships
		if (existingaddress != null) {
			existingaddress.setId(related_address.getId());
			existingaddress.setCity(related_address.getCity());
			existingaddress.setCountryCode(related_address.getCountryCode());
			existingaddress.setProvince(related_address.getProvince());
			existingaddress.setCountry(related_address.getCountry());
			existingaddress.setCountryCodeCity(related_address.getCountryCodeCity());
			existingaddress.setHomeNr(related_address.getHomeNr());
			related_address = existingaddress;
		}

		patient.setAddress(related_address);
		related_address.getPatients().add(patient);
		patient = patientDAO.store(patient);
		patientDAO.flush();

		related_address = addressDAO.store(related_address);
		addressDAO.flush();

		return patient;
	}

	/**
	 * Delete an existing PatientCard entity
	 * 
	 */
	@Transactional
	public Patient deletePatientPatientCards(Integer patient_id, Integer related_patientcards_id) {
		PatientCard related_patientcards = patientCardDAO.findPatientCardByPrimaryKey(related_patientcards_id, -1, -1);

		Patient patient = patientDAO.findPatientByPrimaryKey(patient_id, -1, -1);

		related_patientcards.setPatient(null);
		patient.getPatientCards().remove(related_patientcards);

		patientCardDAO.remove(related_patientcards);
		patientCardDAO.flush();

		return patient;
	}

	/**
	 * Delete an existing SickLeave entity
	 * 
	 */
	@Transactional
	public Patient deletePatientSickLeaves(Integer patient_id, Integer related_sickleaves_id) {
		SickLeave related_sickleaves = sickLeaveDAO.findSickLeaveByPrimaryKey(related_sickleaves_id, -1, -1);

		Patient patient = patientDAO.findPatientByPrimaryKey(patient_id, -1, -1);

		related_sickleaves.setPatient(null);
		patient.getSickLeaves().remove(related_sickleaves);

		sickLeaveDAO.remove(related_sickleaves);
		sickLeaveDAO.flush();

		return patient;
	}

	/**
	 * Save an existing PatientCard entity
	 * 
	 */
	@Transactional
	public Patient savePatientPatientCards(Integer id, PatientCard related_patientcards) {
		Patient patient = patientDAO.findPatientByPrimaryKey(id, -1, -1);
		PatientCard existingpatientCards = patientCardDAO.findPatientCardByPrimaryKey(related_patientcards.getId());

		// copy into the existing record to preserve existing relationships
		if (existingpatientCards != null) {
			existingpatientCards.setId(related_patientcards.getId());
			existingpatientCards.setRegisterDate(related_patientcards.getRegisterDate());
			related_patientcards = existingpatientCards;
		}

		related_patientcards.setPatient(patient);
		patient.getPatientCards().add(related_patientcards);
		related_patientcards = patientCardDAO.store(related_patientcards);
		patientCardDAO.flush();

		patient = patientDAO.store(patient);
		patientDAO.flush();

		return patient;
	}

	/**
	 * Save an existing Recipe entity
	 * 
	 */
	@Transactional
	public Patient savePatientRecipes(Integer id, Recipe related_recipes) {
		Patient patient = patientDAO.findPatientByPrimaryKey(id, -1, -1);
		Recipe existingrecipes = recipeDAO.findRecipeByPrimaryKey(related_recipes.getIdr());

		// copy into the existing record to preserve existing relationships
		if (existingrecipes != null) {
			existingrecipes.setIdr(related_recipes.getIdr());
			existingrecipes.setDate(related_recipes.getDate());
			existingrecipes.setDrug(related_recipes.getDrug());
			related_recipes = existingrecipes;
		}

		related_recipes.setPatient(patient);
		patient.getRecipes().add(related_recipes);
		related_recipes = recipeDAO.store(related_recipes);
		recipeDAO.flush();

		patient = patientDAO.store(patient);
		patientDAO.flush();

		return patient;
	}

	/**
	 * Return all Patient entity
	 * 
	 */
	@Transactional
	public List<Patient> findAllPatients(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Patient>(patientDAO.findAllPatients(startResult, maxRows));
	}
}
