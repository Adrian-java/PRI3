package com.eclinic.service;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.SickLeaveDAO;
import com.eclinic.dao.VisitDAO;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.SickLeave;
import com.eclinic.domain.Visit;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for SickLeave entities
 * 
 */

@Service("SickLeaveService")
@Transactional
public class SickLeaveServiceImpl implements SickLeaveService {

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages Patient entities
	 * 
	 */
	@Autowired
	private PatientDAO patientDAO;

	/**
	 * DAO injected by Spring that manages SickLeave entities
	 * 
	 */
	@Autowired
	private SickLeaveDAO sickLeaveDAO;

	/**
	 * DAO injected by Spring that manages Visit entities
	 * 
	 */
	@Autowired
	private VisitDAO visitDAO;

	/**
	 * Instantiates a new SickLeaveServiceImpl.
	 *
	 */
	public SickLeaveServiceImpl() {
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@Transactional
	public SickLeave deleteSickLeaveDoctor(Integer sickleave_id, Integer related_doctor_id) {
		SickLeave sickleave = sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave_id, -1, -1);
		Doctor related_doctor = doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);

		sickleave.setDoctor(null);
		related_doctor.getSickLeaves().remove(sickleave);
		sickleave = sickLeaveDAO.store(sickleave);
		sickLeaveDAO.flush();

		related_doctor = doctorDAO.store(related_doctor);
		doctorDAO.flush();

		doctorDAO.remove(related_doctor);
		doctorDAO.flush();

		return sickleave;
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@Transactional
	public SickLeave saveSickLeaveDoctor(Integer id, Doctor related_doctor) {
		SickLeave sickleave = sickLeaveDAO.findSickLeaveByPrimaryKey(id, -1, -1);
		Doctor existingdoctor = doctorDAO.findDoctorByPrimaryKey(related_doctor.getId());

		// copy into the existing record to preserve existing relationships
		if (existingdoctor != null) {
			existingdoctor.setId(related_doctor.getId());
			existingdoctor.setName(related_doctor.getName());
			existingdoctor.setSurname(related_doctor.getSurname());
			related_doctor = existingdoctor;
		}

		sickleave.setDoctor(related_doctor);
		related_doctor.getSickLeaves().add(sickleave);
		sickleave = sickLeaveDAO.store(sickleave);
		sickLeaveDAO.flush();

		related_doctor = doctorDAO.store(related_doctor);
		doctorDAO.flush();

		return sickleave;
	}

	/**
	 * Load an existing SickLeave entity
	 * 
	 */
	@Transactional
	public Set<SickLeave> loadSickLeaves() {
		return sickLeaveDAO.findAllSickLeaves();
	}

	/**
	 */
	@Transactional
	public SickLeave findSickLeaveByPrimaryKey(Integer id) {
		return sickLeaveDAO.findSickLeaveByPrimaryKey(id);
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	@Transactional
	public SickLeave deleteSickLeavePatient(Integer sickleave_id, Integer related_patient_id) {
		SickLeave sickleave = sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave_id, -1, -1);
		Patient related_patient = patientDAO.findPatientByPrimaryKey(related_patient_id, -1, -1);

		sickleave.setPatient(null);
		related_patient.getSickLeaves().remove(sickleave);
		sickleave = sickLeaveDAO.store(sickleave);
		sickLeaveDAO.flush();

		related_patient = patientDAO.store(related_patient);
		patientDAO.flush();

		patientDAO.remove(related_patient);
		patientDAO.flush();

		return sickleave;
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	@Transactional
	public SickLeave deleteSickLeaveVisit(Integer sickleave_id, Integer related_visit_id) {
		SickLeave sickleave = sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave_id, -1, -1);
		Visit related_visit = visitDAO.findVisitByPrimaryKey(related_visit_id, -1, -1);

		sickleave.setVisit(null);
		related_visit.getSickLeaves().remove(sickleave);
		sickleave = sickLeaveDAO.store(sickleave);
		sickLeaveDAO.flush();

		related_visit = visitDAO.store(related_visit);
		visitDAO.flush();

		visitDAO.remove(related_visit);
		visitDAO.flush();

		return sickleave;
	}

	/**
	 * Return a count of all SickLeave entity
	 * 
	 */
	@Transactional
	public Integer countSickLeaves() {
		return ((Long) sickLeaveDAO.createQuerySingleResult("select count(o) from SickLeave o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */
	@Transactional
	public SickLeave saveSickLeaveVisit(Integer id, Visit related_visit) {
		SickLeave sickleave = sickLeaveDAO.findSickLeaveByPrimaryKey(id, -1, -1);
		Visit existingvisit = visitDAO.findVisitByPrimaryKey(related_visit.getId());

		// copy into the existing record to preserve existing relationships
		if (existingvisit != null) {
			existingvisit.setId(related_visit.getId());
			existingvisit.setDateOfVisit(related_visit.getDateOfVisit());
			existingvisit.setDescriptionOfVisit(related_visit.getDescriptionOfVisit());
			existingvisit.setIsLeave(related_visit.getIsLeave());
			existingvisit.setSpecial(related_visit.getSpecial());
			related_visit = existingvisit;
		}

		sickleave.setVisit(related_visit);
		related_visit.getSickLeaves().add(sickleave);
		sickleave = sickLeaveDAO.store(sickleave);
		sickLeaveDAO.flush();

		related_visit = visitDAO.store(related_visit);
		visitDAO.flush();

		return sickleave;
	}

	/**
	 * Save an existing SickLeave entity
	 * 
	 */
	@Transactional
	public void saveSickLeave(SickLeave sickleave) {
		SickLeave existingSickLeave = sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave.getId());

		if (existingSickLeave != null) {
			if (existingSickLeave != sickleave) {
				existingSickLeave.setId(sickleave.getId());
				existingSickLeave.setDateFrom(sickleave.getDateFrom());
				existingSickLeave.setDateTo(sickleave.getDateTo());
			}
			sickleave = sickLeaveDAO.store(existingSickLeave);
		} else {
			sickleave = sickLeaveDAO.store(sickleave);
		}
		sickLeaveDAO.flush();
	}

	/**
	 * Delete an existing SickLeave entity
	 * 
	 */
	@Transactional
	public void deleteSickLeave(SickLeave sickleave) {
		sickLeaveDAO.remove(sickleave);
		sickLeaveDAO.flush();
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */
	@Transactional
	public SickLeave saveSickLeavePatient(Integer id, Patient related_patient) {
		SickLeave sickleave = sickLeaveDAO.findSickLeaveByPrimaryKey(id, -1, -1);
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
		}

		sickleave.setPatient(related_patient);
		related_patient.getSickLeaves().add(sickleave);
		sickleave = sickLeaveDAO.store(sickleave);
		sickLeaveDAO.flush();

		related_patient = patientDAO.store(related_patient);
		patientDAO.flush();

		return sickleave;
	}

	/**
	 * Return all SickLeave entity
	 * 
	 */
	@Transactional
	public List<SickLeave> findAllSickLeaves(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<SickLeave>(sickLeaveDAO.findAllSickLeaves(startResult, maxRows));
	}
}
