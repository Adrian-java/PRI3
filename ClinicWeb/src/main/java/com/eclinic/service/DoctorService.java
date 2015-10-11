package com.eclinic.service;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Graphic;
import com.eclinic.domain.PatientCard;
import com.eclinic.domain.Recipe;
import com.eclinic.domain.SickLeave;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.Visit;
import com.eclinic.domain.VisitScheduler;
import com.eclinic.domain.Worker;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Doctor entities
 * 
 */
public interface DoctorService {

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	public void deleteDoctor(Doctor doctor);

	/**
	 * Return all Doctor entity
	 * 
	 */
	public List<Doctor> findAllDoctors(Integer startResult, Integer maxRows);

	/**
	 * Save an existing Specialization entity
	 * 
	 */
	public Doctor saveDoctorSpecializations(Integer id, Specialization related_specializations);

	/**
	 * Save an existing Visit entity
	 * 
	 */
	public Doctor saveDoctorVisits(Integer id_1, Visit related_visits);

	/**
	 * Delete an existing Graphic entity
	 * 
	 */
	public Doctor deleteDoctorGraphics(Integer doctor_id, Integer related_graphics_id);

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	public Doctor deleteDoctorVisits(Integer doctor_id_1, Integer related_visits_id);

	/**
	 * Save an existing Doctor entity
	 * @return 
	 * 
	 */
	public Integer saveDoctor(Doctor doctor_1);

	/**
	 * Delete an existing Recipe entity
	 * 
	 */
	public Doctor deleteDoctorRecipes(Integer doctor_id_2, Integer related_recipes_idr);

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	public Doctor deleteDoctorWorkers(Integer doctor_id_3, Integer related_workers_id);

	/**
	 * Save an existing Worker entity
	 * 
	 */
	public Doctor saveDoctorWorkers(Integer id_2, Worker related_workers);

	/**
	 * Save an existing SickLeave entity
	 * 
	 */
	public Doctor saveDoctorSickLeaves(Integer id_3, SickLeave related_sickleaves);

	/**
	 * Save an existing VisitScheduler entity
	 * 
	 */
	public Doctor saveDoctorVisitSchedulers(Integer id_4, VisitScheduler related_visitschedulers);

	/**
	 * Save an existing Recipe entity
	 * 
	 */
	public Doctor saveDoctorRecipes(Integer id_5, Recipe related_recipes);

	/**
	 * Return a count of all Doctor entity
	 * 
	 */
	public Integer countDoctors();

	/**
	 * Delete an existing Specialization entity
	 * 
	 */
	public Doctor deleteDoctorSpecializations(Integer doctor_id_4, Integer related_specializations_id);

	/**
	 */
	public Doctor findDoctorByPrimaryKey(Integer id_6);

	/**
	 * Delete an existing VisitScheduler entity
	 * 
	 */
	public Doctor deleteDoctorVisitSchedulers(Integer doctor_id_5, Integer related_visitschedulers_id);

	/**
	 * Delete an existing SickLeave entity
	 * 
	 */
	public Doctor deleteDoctorSickLeaves(Integer doctor_id_6, Integer related_sickleaves_id);

	/**
	 * Delete an existing PatientCard entity
	 * 
	 */
	public Doctor deleteDoctorPatientCards(Integer doctor_id_7, Integer related_patientcards_id);

	/**
	 * Save an existing Graphic entity
	 * 
	 */
	public Doctor saveDoctorGraphics(Integer id_7, Graphic related_graphics);

	/**
	 * Save an existing PatientCard entity
	 * 
	 */
	public Doctor saveDoctorPatientCards(Integer id_8, PatientCard related_patientcards);

	/**
	 * Load an existing Doctor entity
	 * 
	 */
	public Set<Doctor> loadDoctors();
}