package com.eclinic.service;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.VisitScheduler;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for VisitScheduler entities
 * 
 */
public interface VisitSchedulerService {

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	public VisitScheduler saveVisitSchedulerDoctor(Integer id, Doctor related_doctor);

	/**
	 * Return all VisitScheduler entity
	 * 
	 */
	public List<VisitScheduler> findAllVisitSchedulers(Integer startResult, Integer maxRows);

	/**
	 * Load an existing VisitScheduler entity
	 * 
	 */
	public Set<VisitScheduler> loadVisitSchedulers();

	/**
	 */
	public VisitScheduler findVisitSchedulerByPrimaryKey(Integer id_1);

	/**
	 * Save an existing Specialization entity
	 * 
	 */
	public VisitScheduler saveVisitSchedulerSpecialization(Integer id_2, Specialization related_specialization);

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	public VisitScheduler deleteVisitSchedulerDoctor(Integer visitscheduler_id, Integer related_doctor_id);

	/**
	 * Return a count of all VisitScheduler entity
	 * 
	 */
	public Integer countVisitSchedulers();

	/**
	 * Delete an existing VisitScheduler entity
	 * 
	 */
	public void deleteVisitScheduler(VisitScheduler visitscheduler);

	/**
	 * Delete an existing Specialization entity
	 * 
	 */
	public VisitScheduler deleteVisitSchedulerSpecialization(Integer visitscheduler_id_1, Integer related_specialization_id);

	/**
	 * Save an existing VisitScheduler entity
	 * 
	 */
	public void saveVisitScheduler(VisitScheduler visitscheduler_1);
}