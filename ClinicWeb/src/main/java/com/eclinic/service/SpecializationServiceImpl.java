package com.eclinic.service;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.SpecalVisitFieldDAO;
import com.eclinic.dao.SpecializationDAO;
import com.eclinic.dao.VisitSchedulerDAO;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.SpecalVisitField;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.VisitScheduler;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Specialization entities
 * 
 */

@Service("SpecializationService")
@Transactional
public class SpecializationServiceImpl implements SpecializationService {

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages SpecalVisitField entities
	 * 
	 */
	@Autowired
	private SpecalVisitFieldDAO specalVisitFieldDAO;

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
	 * Instantiates a new SpecializationServiceImpl.
	 *
	 */
	public SpecializationServiceImpl() {
	}

	/**
	 * Delete an existing SpecalVisitField entity
	 * 
	 */
	@Transactional
	public Specialization deleteSpecializationSpecalVisitFields(Integer specialization_id, Integer related_specalvisitfields_id) {
		SpecalVisitField related_specalvisitfields = specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(related_specalvisitfields_id, -1, -1);

		Specialization specialization = specializationDAO.findSpecializationByPrimaryKey(specialization_id, -1, -1);

		related_specalvisitfields.setSpecialization(null);
		specialization.getSpecalVisitFields().remove(related_specalvisitfields);

		specalVisitFieldDAO.remove(related_specalvisitfields);
		specalVisitFieldDAO.flush();

		return specialization;
	}

	/**
	 * Save an existing Specialization entity
	 * 
	 */
	@Transactional
	public void saveSpecialization(Specialization specialization) {
		Specialization existingSpecialization = specializationDAO.findSpecializationByPrimaryKey(specialization.getId());

		if (existingSpecialization != null) {
			if (existingSpecialization != specialization) {
				existingSpecialization.setId(specialization.getId());
				existingSpecialization.setName(specialization.getName());
				existingSpecialization.setDescription(specialization.getDescription());
			}
			specialization = specializationDAO.store(existingSpecialization);
		} else {
			specialization = specializationDAO.store(specialization);
		}
		specializationDAO.flush();
	}

	/**
	 */
	@Transactional
	public Specialization findSpecializationByPrimaryKey(Integer id) {
		return specializationDAO.findSpecializationByPrimaryKey(id);
	}

	/**
	 * Return all Specialization entity
	 * 
	 */
	@Transactional
	public List<Specialization> findAllSpecializations(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Specialization>(specializationDAO.findAllSpecializations(startResult, maxRows));
	}

	/**
	 * Save an existing VisitScheduler entity
	 * 
	 */
	@Transactional
	public Specialization saveSpecializationVisitSchedulers(Integer id, VisitScheduler related_visitschedulers) {
		Specialization specialization = specializationDAO.findSpecializationByPrimaryKey(id, -1, -1);
		VisitScheduler existingvisitSchedulers = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(related_visitschedulers.getId());

		// copy into the existing record to preserve existing relationships
		if (existingvisitSchedulers != null) {
			existingvisitSchedulers.setId(related_visitschedulers.getId());
			existingvisitSchedulers.setNumberOfDay(related_visitschedulers.getNumberOfDay());
			existingvisitSchedulers.setNumberOfMonth(related_visitschedulers.getNumberOfMonth());
			existingvisitSchedulers.setDescription(related_visitschedulers.getDescription());
			existingvisitSchedulers.setTimeOfVisit(related_visitschedulers.getTimeOfVisit());
			related_visitschedulers = existingvisitSchedulers;
		}

		related_visitschedulers.setSpecialization(specialization);
		specialization.getVisitSchedulers().add(related_visitschedulers);
		related_visitschedulers = visitSchedulerDAO.store(related_visitschedulers);
		visitSchedulerDAO.flush();

		specialization = specializationDAO.store(specialization);
		specializationDAO.flush();

		return specialization;
	}

	/**
	 * Load an existing Specialization entity
	 * 
	 */
	@Transactional
	public Set<Specialization> loadSpecializations() {
		return specializationDAO.findAllSpecializations();
	}

	/**
	 * Delete an existing VisitScheduler entity
	 * 
	 */
	@Transactional
	public Specialization deleteSpecializationVisitSchedulers(Integer specialization_id, Integer related_visitschedulers_id) {
		VisitScheduler related_visitschedulers = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(related_visitschedulers_id, -1, -1);

		Specialization specialization = specializationDAO.findSpecializationByPrimaryKey(specialization_id, -1, -1);

		related_visitschedulers.setSpecialization(null);
		specialization.getVisitSchedulers().remove(related_visitschedulers);

		visitSchedulerDAO.remove(related_visitschedulers);
		visitSchedulerDAO.flush();

		return specialization;
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@Transactional
	public Specialization deleteSpecializationDoctor(Integer specialization_id, Integer related_doctor_id) {
		Specialization specialization = specializationDAO.findSpecializationByPrimaryKey(specialization_id, -1, -1);
		Doctor related_doctor = doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);

		specialization.setDoctor(null);
		related_doctor.getSpecializations().remove(specialization);
		specialization = specializationDAO.store(specialization);
		specializationDAO.flush();

		related_doctor = doctorDAO.store(related_doctor);
		doctorDAO.flush();

		doctorDAO.remove(related_doctor);
		doctorDAO.flush();

		return specialization;
	}

	/**
	 * Delete an existing Specialization entity
	 * 
	 */
	@Transactional
	public void deleteSpecialization(Specialization specialization) {
		specializationDAO.remove(specialization);
		specializationDAO.flush();
	}

	/**
	 * Return a count of all Specialization entity
	 * 
	 */
	@Transactional
	public Integer countSpecializations() {
		return ((Long) specializationDAO.createQuerySingleResult("select count(o) from Specialization o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@Transactional
	public Specialization saveSpecializationDoctor(Integer id, Doctor related_doctor) {
		Specialization specialization = specializationDAO.findSpecializationByPrimaryKey(id, -1, -1);
		Doctor existingdoctor = doctorDAO.findDoctorByPrimaryKey(related_doctor.getId());

		// copy into the existing record to preserve existing relationships
		if (existingdoctor != null) {
			existingdoctor.setId(related_doctor.getId());
			existingdoctor.setName(related_doctor.getName());
			existingdoctor.setSurname(related_doctor.getSurname());
			related_doctor = existingdoctor;
		}

		specialization.setDoctor(related_doctor);
		related_doctor.getSpecializations().add(specialization);
		specialization = specializationDAO.store(specialization);
		specializationDAO.flush();

		related_doctor = doctorDAO.store(related_doctor);
		doctorDAO.flush();

		return specialization;
	}

	/**
	 * Save an existing SpecalVisitField entity
	 * 
	 */
	@Transactional
	public Specialization saveSpecializationSpecalVisitFields(Integer id, SpecalVisitField related_specalvisitfields) {
		Specialization specialization = specializationDAO.findSpecializationByPrimaryKey(id, -1, -1);
		SpecalVisitField existingspecalVisitFields = specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(related_specalvisitfields.getId());

		// copy into the existing record to preserve existing relationships
		if (existingspecalVisitFields != null) {
			existingspecalVisitFields.setId(related_specalvisitfields.getId());
			existingspecalVisitFields.setName(related_specalvisitfields.getName());
			existingspecalVisitFields.setValue(related_specalvisitfields.getValue());
			existingspecalVisitFields.setTypeOfValue(related_specalvisitfields.getTypeOfValue());
			related_specalvisitfields = existingspecalVisitFields;
		}

		related_specalvisitfields.setSpecialization(specialization);
		specialization.getSpecalVisitFields().add(related_specalvisitfields);
		related_specalvisitfields = specalVisitFieldDAO.store(related_specalvisitfields);
		specalVisitFieldDAO.flush();

		specialization = specializationDAO.store(specialization);
		specializationDAO.flush();

		return specialization;
	}
}
