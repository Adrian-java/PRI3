package com.eclinic.service;

import com.eclinic.domain.Receptionist;
import com.eclinic.domain.Visit;
import com.eclinic.domain.Worker;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Receptionist entities
 * 
 */
public interface ReceptionistService {

	/**
	 * Load an existing Receptionist entity
	 * 
	 */
	public Set<Receptionist> loadReceptionists();

	/**
	 * Delete an existing Receptionist entity
	 * 
	 */
	public void deleteReceptionist(Receptionist receptionist);

	/**
	 * Save an existing Visit entity
	 * 
	 */
	public Receptionist saveReceptionistVisits(Integer id, Visit related_visits);

	/**
	 */
	public Receptionist findReceptionistByPrimaryKey(Integer id_1);

	/**
	 * Save an existing Worker entity
	 * 
	 */
	public Receptionist saveReceptionistWorkers(Integer id_2, Worker related_workers);

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	public Receptionist deleteReceptionistVisits(Integer receptionist_id, Integer related_visits_id);

	/**
	 * Save an existing Receptionist entity
	 * 
	 */
	public Integer saveReceptionist(Receptionist receptionist_1);

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	public Receptionist deleteReceptionistWorkers(Integer receptionist_id_1, Integer related_workers_id);

	/**
	 * Return all Receptionist entity
	 * 
	 */
	public List<Receptionist> findAllReceptionists(Integer startResult, Integer maxRows);

	/**
	 * Return a count of all Receptionist entity
	 * 
	 */
	public Integer countReceptionists();
}