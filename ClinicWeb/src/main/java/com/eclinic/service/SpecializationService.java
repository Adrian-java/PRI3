package com.eclinic.service;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.SpecalVisitField;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.VisitScheduler;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Specialization entities
 * 
 */
public interface SpecializationService {

	/**
	 * Delete an existing SpecalVisitField entity
	 * 
	 */
	public Specialization deleteSpecializationSpecalVisitFields(Integer specialization_id, Integer related_specalvisitfields_id);

	/**
	 * Save an existing Specialization entity
	 * 
	 */
	public void saveSpecialization(Specialization specialization);

	/**
	 */
	public Specialization findSpecializationByPrimaryKey(Integer id);

	/**
	 * Return all Specialization entity
	 * 
	 */
	public List<Specialization> findAllSpecializations(Integer startResult, Integer maxRows);

	/**
	 * Save an existing VisitScheduler entity
	 * 
	 */
	public Specialization saveSpecializationVisitSchedulers(Integer id_1, VisitScheduler related_visitschedulers);

	/**
	 * Load an existing Specialization entity
	 * 
	 */
	public Set<Specialization> loadSpecializations();

	/**
	 * Delete an existing VisitScheduler entity
	 * 
	 */
	public Specialization deleteSpecializationVisitSchedulers(Integer specialization_id_1, Integer related_visitschedulers_id);

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	public Specialization deleteSpecializationDoctor(Integer specialization_id_2, Integer related_doctor_id);

	/**
	 * Delete an existing Specialization entity
	 * 
	 */
	public void deleteSpecialization(Specialization specialization_1);

	/**
	 * Return a count of all Specialization entity
	 * 
	 */
	public Integer countSpecializations();

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	public Specialization saveSpecializationDoctor(Integer id_2, Doctor related_doctor);

	/**
	 * Save an existing SpecalVisitField entity
	 * 
	 */
	public Specialization saveSpecializationSpecalVisitFields(Integer id_3, SpecalVisitField related_specalvisitfields);
}