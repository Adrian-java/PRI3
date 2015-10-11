package com.eclinic.service;

import com.eclinic.domain.Admin;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.LoginHistory;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Receptionist;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.Worker;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Worker entities
 * 
 */
public interface WorkerService {

	/**
	 * Delete an existing LoginHistory entity
	 * 
	 */
	public Worker deleteWorkerLoginHistories(Integer worker_id, Integer related_loginhistories_id);

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	public Worker deleteWorkerDoctor(Integer worker_id_1, Integer related_doctor_id);

	/**
	 * Save an existing LoginHistory entity
	 * 
	 */
	public Worker saveWorkerLoginHistories(Integer id, LoginHistory related_loginhistories);

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	public void deleteWorker(Worker worker);

	/**
	 * Save an existing Admin entity
	 * 
	 */
	public Worker saveWorkerAdmin(Integer id_1, Admin related_admin);

	/**
	 * Save an existing Patient entity
	 * 
	 */
	public Worker saveWorkerPatient(Integer id_2, Patient related_patient);

	/**
	 * Save an existing Worker entity
	 * 
	 */
	public void saveWorker(Worker worker_1);

	/**
	 * Return a count of all Worker entity
	 * 
	 */
	public Integer countWorkers();

	/**
	 * Delete an existing Receptionist entity
	 * 
	 */
	public Worker deleteWorkerReceptionist(Integer worker_id_2, Integer related_receptionist_id);

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	public Worker saveWorkerDoctor(Integer id_3, Doctor related_doctor);

	/**
	 * Load an existing Worker entity
	 * 
	 */
	public Set<Worker> loadWorkers();

	/**
	 * Delete an existing Admin entity
	 * 
	 */
	public Worker deleteWorkerAdmin(Integer worker_id_3, Integer related_admin_id);

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	public Worker deleteWorkerSystemUsers(Integer worker_id_4, Integer related_systemusers_id);

	/**
	 */
	public Worker findWorkerByPrimaryKey(Integer id_4);

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	public Worker deleteWorkerPatient(Integer worker_id_5, Integer related_patient_id);

	/**
	 * Save an existing Receptionist entity
	 * 
	 */
	public Worker saveWorkerReceptionist(Integer id_5, Receptionist related_receptionist);

	/**
	 * Return all Worker entity
	 * 
	 */
	public List<Worker> findAllWorkers(Integer startResult, Integer maxRows);

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	public Worker saveWorkerSystemUsers(Integer id_6, SystemUser related_systemusers);
}