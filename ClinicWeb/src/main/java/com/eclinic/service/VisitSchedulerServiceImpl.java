package com.eclinic.service;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.SpecializationDAO;
import com.eclinic.dao.VisitSchedulerDAO;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.VisitScheduler;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for VisitScheduler entities
 * 
 */

@Service("VisitSchedulerService")
@Transactional
public class VisitSchedulerServiceImpl implements VisitSchedulerService {

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages Specialization entities
	 * 
	 */
	@Autowired
	private SpecializationDAO specializationDAO;

	/**
	 * DAO injected by Spring that manages VisitScheduler entities
	 * 
	 */
	@Autowired
	private VisitSchedulerDAO visitSchedulerDAO;

	/**
	 * Instantiates a new VisitSchedulerServiceImpl.
	 *
	 */
	public VisitSchedulerServiceImpl() {
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@Transactional
	public VisitScheduler saveVisitSchedulerDoctor(Integer id, Doctor related_doctor) {
		VisitScheduler visitscheduler = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(id, -1, -1);
		Doctor existingdoctor = doctorDAO.findDoctorByPrimaryKey(related_doctor.getId());

		// copy into the existing record to preserve existing relationships
		if (existingdoctor != null) {
			existingdoctor.setId(related_doctor.getId());
			existingdoctor.setName(related_doctor.getName());
			existingdoctor.setSurname(related_doctor.getSurname());
			related_doctor = existingdoctor;
		}

		visitscheduler.setDoctor(related_doctor);
		related_doctor.getVisitSchedulers().add(visitscheduler);
		visitscheduler = visitSchedulerDAO.store(visitscheduler);
		visitSchedulerDAO.flush();

		related_doctor = doctorDAO.store(related_doctor);
		doctorDAO.flush();

		return visitscheduler;
	}

	/**
	 * Return all VisitScheduler entity
	 * 
	 */
	@Transactional
	public List<VisitScheduler> findAllVisitSchedulers(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<VisitScheduler>(visitSchedulerDAO.findAllVisitSchedulers(startResult, maxRows));
	}

	/**
	 * Load an existing VisitScheduler entity
	 * 
	 */
	@Transactional
	public Set<VisitScheduler> loadVisitSchedulers() {
		return visitSchedulerDAO.findAllVisitSchedulers();
	}

	/**
	 */
	@Transactional
	public VisitScheduler findVisitSchedulerByPrimaryKey(Integer id) {
		return visitSchedulerDAO.findVisitSchedulerByPrimaryKey(id);
	}

	/**
	 * Save an existing Specialization entity
	 * 
	 */
	@Transactional
	public VisitScheduler saveVisitSchedulerSpecialization(Integer id, Specialization related_specialization) {
		VisitScheduler visitscheduler = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(id, -1, -1);
		Specialization existingspecialization = specializationDAO.findSpecializationByPrimaryKey(related_specialization.getId());

		// copy into the existing record to preserve existing relationships
		if (existingspecialization != null) {
			existingspecialization.setId(related_specialization.getId());
			existingspecialization.setName(related_specialization.getName());
			existingspecialization.setDescription(related_specialization.getDescription());
			related_specialization = existingspecialization;
		}

		visitscheduler.setSpecialization(related_specialization);
		related_specialization.getVisitSchedulers().add(visitscheduler);
		visitscheduler = visitSchedulerDAO.store(visitscheduler);
		visitSchedulerDAO.flush();

		related_specialization = specializationDAO.store(related_specialization);
		specializationDAO.flush();

		return visitscheduler;
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@Transactional
	public VisitScheduler deleteVisitSchedulerDoctor(Integer visitscheduler_id, Integer related_doctor_id) {
		VisitScheduler visitscheduler = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitscheduler_id, -1, -1);
		Doctor related_doctor = doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);

		visitscheduler.setDoctor(null);
		related_doctor.getVisitSchedulers().remove(visitscheduler);
		visitscheduler = visitSchedulerDAO.store(visitscheduler);
		visitSchedulerDAO.flush();

		related_doctor = doctorDAO.store(related_doctor);
		doctorDAO.flush();

		doctorDAO.remove(related_doctor);
		doctorDAO.flush();

		return visitscheduler;
	}

	/**
	 * Return a count of all VisitScheduler entity
	 * 
	 */
	@Transactional
	public Integer countVisitSchedulers() {
		return ((Long) visitSchedulerDAO.createQuerySingleResult("select count(o) from VisitScheduler o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing VisitScheduler entity
	 * 
	 */
	@Transactional
	public void deleteVisitScheduler(VisitScheduler visitscheduler) {
		visitSchedulerDAO.remove(visitscheduler);
		visitSchedulerDAO.flush();
	}

	/**
	 * Delete an existing Specialization entity
	 * 
	 */
	@Transactional
	public VisitScheduler deleteVisitSchedulerSpecialization(Integer visitscheduler_id, Integer related_specialization_id) {
		VisitScheduler visitscheduler = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitscheduler_id, -1, -1);
		Specialization related_specialization = specializationDAO.findSpecializationByPrimaryKey(related_specialization_id, -1, -1);

		visitscheduler.setSpecialization(null);
		related_specialization.getVisitSchedulers().remove(visitscheduler);
		visitscheduler = visitSchedulerDAO.store(visitscheduler);
		visitSchedulerDAO.flush();

		related_specialization = specializationDAO.store(related_specialization);
		specializationDAO.flush();

		specializationDAO.remove(related_specialization);
		specializationDAO.flush();

		return visitscheduler;
	}

	/**
	 * Save an existing VisitScheduler entity
	 * 
	 */
	@Transactional
	public void saveVisitScheduler(VisitScheduler visitscheduler) {
		VisitScheduler existingVisitScheduler = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitscheduler.getId());

		if (existingVisitScheduler != null) {
			if (existingVisitScheduler != visitscheduler) {
				existingVisitScheduler.setId(visitscheduler.getId());
				existingVisitScheduler.setNumberOfDay(visitscheduler.getNumberOfDay());
				existingVisitScheduler.setNumberOfMonth(visitscheduler.getNumberOfMonth());
				existingVisitScheduler.setDescription(visitscheduler.getDescription());
				existingVisitScheduler.setTimeOfVisit(visitscheduler.getTimeOfVisit());
			}
			visitscheduler = visitSchedulerDAO.store(existingVisitScheduler);
		} else {
			visitscheduler = visitSchedulerDAO.store(visitscheduler);
		}
		visitSchedulerDAO.flush();
	}
}
