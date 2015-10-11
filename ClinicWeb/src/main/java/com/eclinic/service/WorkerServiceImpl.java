package com.eclinic.service;

import com.eclinic.dao.AdminDAO;
import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.LoginHistoryDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.ReceptionistDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.dao.WorkerDAO;

import com.eclinic.domain.Admin;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.LoginHistory;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Receptionist;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.Worker;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Worker entities
 * 
 */

@Service("WorkerService")
@Transactional
public class WorkerServiceImpl implements WorkerService {

	/**
	 * DAO injected by Spring that manages Admin entities
	 * 
	 */
	@Autowired
	private AdminDAO adminDAO;

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages LoginHistory entities
	 * 
	 */
	@Autowired
	private LoginHistoryDAO loginHistoryDAO;

	/**
	 * DAO injected by Spring that manages Patient entities
	 * 
	 */
	@Autowired
	private PatientDAO patientDAO;

	/**
	 * DAO injected by Spring that manages Receptionist entities
	 * 
	 */
	@Autowired
	private ReceptionistDAO receptionistDAO;

	/**
	 * DAO injected by Spring that manages SystemUser entities
	 * 
	 */
	@Autowired
	private SystemUserDAO systemUserDAO;

	/**
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;
	
	/**
	 * Instantiates a new WorkerServiceImpl.
	 *
	 */
	public WorkerServiceImpl() {
	}

	/**
	 * Delete an existing LoginHistory entity
	 * 
	 */
	@Transactional
	public Worker deleteWorkerLoginHistories(Integer worker_id, Integer related_loginhistories_id) {
		LoginHistory related_loginhistories = loginHistoryDAO.findLoginHistoryByPrimaryKey(related_loginhistories_id, -1, -1);

		Worker worker = workerDAO.findWorkerByPrimaryKey(worker_id, -1, -1);

		related_loginhistories.setWorker(null);
		worker.getLoginHistories().remove(related_loginhistories);

		loginHistoryDAO.remove(related_loginhistories);
		loginHistoryDAO.flush();

		return worker;
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@Transactional
	public Worker deleteWorkerDoctor(Integer worker_id, Integer related_doctor_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(worker_id, -1, -1);
		Doctor related_doctor = doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);

		worker.setDoctor(null);
		related_doctor.getWorkers().remove(worker);
		worker = workerDAO.store(worker);
		workerDAO.flush();

		related_doctor = doctorDAO.store(related_doctor);
		doctorDAO.flush();

		doctorDAO.remove(related_doctor);
		doctorDAO.flush();

		return worker;
	}

	/**
	 * Save an existing LoginHistory entity
	 * 
	 */
	@Transactional
	public Worker saveWorkerLoginHistories(Integer id, LoginHistory related_loginhistories) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(id, -1, -1);
		LoginHistory existingloginHistories = loginHistoryDAO.findLoginHistoryByPrimaryKey(related_loginhistories.getId());

		// copy into the existing record to preserve existing relationships
		if (existingloginHistories != null) {
			existingloginHistories.setId(related_loginhistories.getId());
			existingloginHistories.setDateLogin(related_loginhistories.getDateLogin());
			existingloginHistories.setSessionNumber(related_loginhistories.getSessionNumber());
			existingloginHistories.setDateLogout(related_loginhistories.getDateLogout());
			related_loginhistories = existingloginHistories;
		}

		related_loginhistories.setWorker(worker);
		worker.getLoginHistories().add(related_loginhistories);
		related_loginhistories = loginHistoryDAO.store(related_loginhistories);
		loginHistoryDAO.flush();

		worker = workerDAO.store(worker);
		workerDAO.flush();

		return worker;
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	@Transactional
	public void deleteWorker(Worker worker) {
		workerDAO.remove(worker);
		workerDAO.flush();
	}

	/**
	 * Save an existing Admin entity
	 * 
	 */
	@Transactional
	public Worker saveWorkerAdmin(Integer id, Admin related_admin) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(id, -1, -1);
		Admin existingadmin = adminDAO.findAdminByPrimaryKey(related_admin.getId());

		// copy into the existing record to preserve existing relationships
		if (existingadmin != null) {
			existingadmin.setId(related_admin.getId());
			existingadmin.setIsSuper(related_admin.getIsSuper());
			related_admin = existingadmin;
		} else {
			related_admin = adminDAO.store(related_admin);
			adminDAO.flush();
		}

		worker.setAdmin(related_admin);
		related_admin.getWorkers().add(worker);
		worker = workerDAO.store(worker);
		workerDAO.flush();

		related_admin = adminDAO.store(related_admin);
		adminDAO.flush();

		return worker;
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */
	@Transactional
	public Worker saveWorkerPatient(Integer id, Patient related_patient) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(id, -1, -1);
		Patient existingpatient = patientDAO.findPatientByPrimaryKey(related_patient.getId());

		// copy into the existing record to preserve existing relationships
		if (existingpatient != null) {
			existingpatient.setId(related_patient.getId());
			existingpatient.setName(related_patient.getName());
			existingpatient.setSurname(related_patient.getSurname());
			existingpatient.setDateOfBirth(related_patient.getDateOfBirth());
			existingpatient.setEMail(related_patient.getEMail());
			existingpatient.setPhoneNr(related_patient.getPhoneNr());
			existingpatient.setConfirmed(related_patient.getConfirmed());
			related_patient = existingpatient;
		} else {
			related_patient = patientDAO.store(related_patient);
			patientDAO.flush();
		}

		worker.setPatient(related_patient);
		related_patient.getWorkers().add(worker);
		worker = workerDAO.store(worker);
		workerDAO.flush();

		related_patient = patientDAO.store(related_patient);
		patientDAO.flush();

		return worker;
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */
	@Transactional
	public void saveWorker(Worker worker) {
		Worker existingWorker = workerDAO.findWorkerByPrimaryKey(worker.getId());

		if (existingWorker != null) {
			if (existingWorker != worker) {
				existingWorker.setId(worker.getId());
			}
			worker = workerDAO.store(existingWorker);
		} else {
			worker = workerDAO.store(worker);
		}
		workerDAO.flush();
	}

	/**
	 * Return a count of all Worker entity
	 * 
	 */
	@Transactional
	public Integer countWorkers() {
		return ((Long) workerDAO.createQuerySingleResult("select count(o) from Worker o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Receptionist entity
	 * 
	 */
	@Transactional
	public Worker deleteWorkerReceptionist(Integer worker_id, Integer related_receptionist_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(worker_id, -1, -1);
		Receptionist related_receptionist = receptionistDAO.findReceptionistByPrimaryKey(related_receptionist_id, -1, -1);

		worker.setReceptionist(null);
		related_receptionist.getWorkers().remove(worker);
		worker = workerDAO.store(worker);
		workerDAO.flush();

		related_receptionist = receptionistDAO.store(related_receptionist);
		receptionistDAO.flush();

		receptionistDAO.remove(related_receptionist);
		receptionistDAO.flush();

		return worker;
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@Transactional
	public Worker saveWorkerDoctor(Integer id, Doctor related_doctor) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(id, -1, -1);
		Doctor existingdoctor = doctorDAO.findDoctorByPrimaryKey(related_doctor.getId());

		// copy into the existing record to preserve existing relationships
		if (existingdoctor != null) {
			existingdoctor.setId(related_doctor.getId());
			existingdoctor.setName(related_doctor.getName());
			existingdoctor.setSurname(related_doctor.getSurname());
			related_doctor = existingdoctor;
		} else {
			related_doctor = doctorDAO.store(related_doctor);
			doctorDAO.flush();
		}

		worker.setDoctor(related_doctor);
		related_doctor.getWorkers().add(worker);
		worker = workerDAO.store(worker);
		workerDAO.flush();

		related_doctor = doctorDAO.store(related_doctor);
		doctorDAO.flush();

		return worker;
	}

	/**
	 * Load an existing Worker entity
	 * 
	 */
	@Transactional
	public Set<Worker> loadWorkers() {
		return workerDAO.findAllWorkers();
	}

	/**
	 * Delete an existing Admin entity
	 * 
	 */
	@Transactional
	public Worker deleteWorkerAdmin(Integer worker_id, Integer related_admin_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(worker_id, -1, -1);
		Admin related_admin = adminDAO.findAdminByPrimaryKey(related_admin_id, -1, -1);

		worker.setAdmin(null);
		related_admin.getWorkers().remove(worker);
		worker = workerDAO.store(worker);
		workerDAO.flush();

		related_admin = adminDAO.store(related_admin);
		adminDAO.flush();

		adminDAO.remove(related_admin);
		adminDAO.flush();

		return worker;
	}

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	@Transactional
	public Worker deleteWorkerSystemUsers(Integer worker_id, Integer related_systemusers_id) {
		SystemUser related_systemusers = systemUserDAO.findSystemUserByPrimaryKey(related_systemusers_id, -1, -1);

		Worker worker = workerDAO.findWorkerByPrimaryKey(worker_id, -1, -1);

		related_systemusers.setWorker(null);
		worker.getSystemUsers().remove(related_systemusers);

		systemUserDAO.remove(related_systemusers);
		systemUserDAO.flush();

		return worker;
	}

	/**
	 */
	@Transactional
	public Worker findWorkerByPrimaryKey(Integer id) {
		return workerDAO.findWorkerByPrimaryKey(id);
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	@Transactional
	public Worker deleteWorkerPatient(Integer worker_id, Integer related_patient_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(worker_id, -1, -1);
		Patient related_patient = patientDAO.findPatientByPrimaryKey(related_patient_id, -1, -1);

		worker.setPatient(null);
		related_patient.getWorkers().remove(worker);
		worker = workerDAO.store(worker);
		workerDAO.flush();

		related_patient = patientDAO.store(related_patient);
		patientDAO.flush();

		patientDAO.remove(related_patient);
		patientDAO.flush();

		return worker;
	}

	/**
	 * Save an existing Receptionist entity
	 * 
	 */
	@Transactional
	public Worker saveWorkerReceptionist(Integer id, Receptionist related_receptionist) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(id, -1, -1);
		Receptionist existingreceptionist = receptionistDAO.findReceptionistByPrimaryKey(related_receptionist.getId());

		// copy into the existing record to preserve existing relationships
		if (existingreceptionist != null) {
			existingreceptionist.setId(related_receptionist.getId());
			existingreceptionist.setName(related_receptionist.getName());
			existingreceptionist.setSurname(related_receptionist.getSurname());
			existingreceptionist.setPhoneNr(related_receptionist.getPhoneNr());
			existingreceptionist.setAccess(related_receptionist.getAccess());
			related_receptionist = existingreceptionist;
		} else {
			related_receptionist = receptionistDAO.store(related_receptionist);
			receptionistDAO.flush();
		}

		worker.setReceptionist(related_receptionist);
		related_receptionist.getWorkers().add(worker);
		worker = workerDAO.store(worker);
		workerDAO.flush();

		related_receptionist = receptionistDAO.store(related_receptionist);
		receptionistDAO.flush();

		return worker;
	}

	/**
	 * Return all Worker entity
	 * 
	 */
	@Transactional
	public List<Worker> findAllWorkers(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Worker>(workerDAO.findAllWorkers(startResult, maxRows));
	}

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	@Transactional
	public Worker saveWorkerSystemUsers(Integer id, SystemUser related_systemusers) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(id, -1, -1);
		SystemUser existingsystemUsers = systemUserDAO.findSystemUserByPrimaryKey(related_systemusers.getId());

		// copy into the existing record to preserve existing relationships
		if (existingsystemUsers != null) {
			existingsystemUsers.setId(related_systemusers.getId());
			existingsystemUsers.setPesel(related_systemusers.getPesel());
			existingsystemUsers.setPassword(related_systemusers.getPassword());
			existingsystemUsers.setDescription(related_systemusers.getDescription());
			existingsystemUsers.setRegisterDate(related_systemusers.getRegisterDate());
			existingsystemUsers.setIsActive(related_systemusers.getIsActive());
			existingsystemUsers.setChangedPassword(related_systemusers.getChangedPassword());
			existingsystemUsers.setEmail(related_systemusers.getEmail());
			existingsystemUsers.setUnregisterDate(related_systemusers.getUnregisterDate());
			related_systemusers = existingsystemUsers;
		}

		related_systemusers.setWorker(worker);
		worker.getSystemUsers().add(related_systemusers);
		related_systemusers = systemUserDAO.store(related_systemusers);
		systemUserDAO.flush();

		worker = workerDAO.store(worker);
		workerDAO.flush();

		return worker;
	}
}
