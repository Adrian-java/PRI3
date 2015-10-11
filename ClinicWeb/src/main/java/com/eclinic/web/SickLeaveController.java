package com.eclinic.web;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.SickLeaveDAO;
import com.eclinic.dao.VisitDAO;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.SickLeave;
import com.eclinic.domain.Visit;

import com.eclinic.service.SickLeaveService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

/**
 * Spring MVC controller that handles CRUD requests for SickLeave entities
 * 
 */

@Controller("SickLeaveController")
public class SickLeaveController {

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
	 * Service injected by Spring that provides CRUD operations for SickLeave entities
	 * 
	 */
	@Autowired
	private SickLeaveService sickLeaveService;

	/**
	 * Register custom, context-specific property editors
	 * 
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register static property editors.
		binder.registerCustomEditor(java.util.Calendar.class, new org.skyway.spring.util.databinding.CustomCalendarEditor());
		binder.registerCustomEditor(byte[].class, new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(false));
		binder.registerCustomEditor(Boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(true));
		binder.registerCustomEditor(java.math.BigDecimal.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class, new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class, new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Long.class, true));
		binder.registerCustomEditor(Double.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Double.class, true));
	}

	/**
	 * View an existing Doctor entity
	 * 
	 */
	@RequestMapping("/selectSickLeaveDoctor")
	public ModelAndView selectSickLeaveDoctor(@RequestParam Integer sickleave_id, @RequestParam Integer doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("sickleave_id", sickleave_id);
		mav.addObject("doctor", doctor);
		mav.setViewName("sickleave/doctor/viewDoctor.jsp");

		return mav;
	}

	/**
	 * Select the child Visit entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteSickLeaveVisit")
	public ModelAndView confirmDeleteSickLeaveVisit(@RequestParam Integer sickleave_id, @RequestParam Integer related_visit_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visit", visitDAO.findVisitByPrimaryKey(related_visit_id));
		mav.addObject("sickleave_id", sickleave_id);
		mav.setViewName("sickleave/visit/deleteVisit.jsp");

		return mav;
	}

	/**
	 * Delete an existing SickLeave entity
	 * 
	 */
	@RequestMapping("/deleteSickLeave")
	public String deleteSickLeave(@RequestParam Integer idKey) {
		SickLeave sickleave = sickLeaveDAO.findSickLeaveByPrimaryKey(idKey);
		sickLeaveService.deleteSickLeave(sickleave);
		return "forward:/indexSickLeave";
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */
	@RequestMapping("/saveSickLeavePatient")
	public ModelAndView saveSickLeavePatient(@RequestParam Integer sickleave_id, @ModelAttribute Patient patient) {
		SickLeave parent_sickleave = sickLeaveService.saveSickLeavePatient(sickleave_id, patient);

		ModelAndView mav = new ModelAndView();
		mav.addObject("sickleave_id", sickleave_id);
		mav.addObject("sickleave", parent_sickleave);
		mav.setViewName("sickleave/viewSickLeave.jsp");

		return mav;
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	@RequestMapping("/deleteSickLeavePatient")
	public ModelAndView deleteSickLeavePatient(@RequestParam Integer sickleave_id, @RequestParam Integer related_patient_id) {
		ModelAndView mav = new ModelAndView();

		SickLeave sickleave = sickLeaveService.deleteSickLeavePatient(sickleave_id, related_patient_id);

		mav.addObject("sickleave_id", sickleave_id);
		mav.addObject("sickleave", sickleave);
		mav.setViewName("sickleave/viewSickLeave.jsp");

		return mav;
	}

	/**
	 * Show all Visit entities by SickLeave
	 * 
	 */
	@RequestMapping("/listSickLeaveVisit")
	public ModelAndView listSickLeaveVisit(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sickleave", sickLeaveDAO.findSickLeaveByPrimaryKey(idKey));
		mav.setViewName("sickleave/visit/listVisit.jsp");

		return mav;
	}

	/**
	 * Select the child Doctor entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteSickLeaveDoctor")
	public ModelAndView confirmDeleteSickLeaveDoctor(@RequestParam Integer sickleave_id, @RequestParam Integer related_doctor_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("doctor", doctorDAO.findDoctorByPrimaryKey(related_doctor_id));
		mav.addObject("sickleave_id", sickleave_id);
		mav.setViewName("sickleave/doctor/deleteDoctor.jsp");

		return mav;
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@RequestMapping("/saveSickLeaveDoctor")
	public ModelAndView saveSickLeaveDoctor(@RequestParam Integer sickleave_id, @ModelAttribute Doctor doctor) {
		SickLeave parent_sickleave = sickLeaveService.saveSickLeaveDoctor(sickleave_id, doctor);

		ModelAndView mav = new ModelAndView();
		mav.addObject("sickleave_id", sickleave_id);
		mav.addObject("sickleave", parent_sickleave);
		mav.setViewName("sickleave/viewSickLeave.jsp");

		return mav;
	}

	/**
	 * Create a new Patient entity
	 * 
	 */
	@RequestMapping("/newSickLeavePatient")
	public ModelAndView newSickLeavePatient(@RequestParam Integer sickleave_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("sickleave_id", sickleave_id);
		mav.addObject("patient", new Patient());
		mav.addObject("newFlag", true);
		mav.setViewName("sickleave/patient/editPatient.jsp");

		return mav;
	}

	/**
	 * Edit an existing Doctor entity
	 * 
	 */
	@RequestMapping("/editSickLeaveDoctor")
	public ModelAndView editSickLeaveDoctor(@RequestParam Integer sickleave_id, @RequestParam Integer doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("sickleave_id", sickleave_id);
		mav.addObject("doctor", doctor);
		mav.setViewName("sickleave/doctor/editDoctor.jsp");

		return mav;
	}

	/**
	 * Edit an existing Visit entity
	 * 
	 */
	@RequestMapping("/editSickLeaveVisit")
	public ModelAndView editSickLeaveVisit(@RequestParam Integer sickleave_id, @RequestParam Integer visit_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(visit_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("sickleave_id", sickleave_id);
		mav.addObject("visit", visit);
		mav.setViewName("sickleave/visit/editVisit.jsp");

		return mav;
	}

	/**
	 * View an existing Patient entity
	 * 
	 */
	@RequestMapping("/selectSickLeavePatient")
	public ModelAndView selectSickLeavePatient(@RequestParam Integer sickleave_id, @RequestParam Integer patient_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(patient_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("sickleave_id", sickleave_id);
		mav.addObject("patient", patient);
		mav.setViewName("sickleave/patient/viewPatient.jsp");

		return mav;
	}

	/**
	 * Show all Doctor entities by SickLeave
	 * 
	 */
	@RequestMapping("/listSickLeaveDoctor")
	public ModelAndView listSickLeaveDoctor(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sickleave", sickLeaveDAO.findSickLeaveByPrimaryKey(idKey));
		mav.setViewName("sickleave/doctor/listDoctor.jsp");

		return mav;
	}

	/**
	 * Create a new Visit entity
	 * 
	 */
	@RequestMapping("/newSickLeaveVisit")
	public ModelAndView newSickLeaveVisit(@RequestParam Integer sickleave_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("sickleave_id", sickleave_id);
		mav.addObject("visit", new Visit());
		mav.addObject("newFlag", true);
		mav.setViewName("sickleave/visit/editVisit.jsp");

		return mav;
	}

	/**
	 * Show all SickLeave entities
	 * 
	 */
	@RequestMapping("/indexSickLeave")
	public ModelAndView listSickLeaves() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sickleaves", sickLeaveService.loadSickLeaves());

		mav.setViewName("sickleave/listSickLeaves.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/sickleaveController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Select an existing SickLeave entity
	 * 
	 */
	@RequestMapping("/selectSickLeave")
	public ModelAndView selectSickLeave(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sickleave", sickLeaveDAO.findSickLeaveByPrimaryKey(idKey));
		mav.setViewName("sickleave/viewSickLeave.jsp");

		return mav;
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */
	@RequestMapping("/saveSickLeaveVisit")
	public ModelAndView saveSickLeaveVisit(@RequestParam Integer sickleave_id, @ModelAttribute Visit visit) {
		SickLeave parent_sickleave = sickLeaveService.saveSickLeaveVisit(sickleave_id, visit);

		ModelAndView mav = new ModelAndView();
		mav.addObject("sickleave_id", sickleave_id);
		mav.addObject("sickleave", parent_sickleave);
		mav.setViewName("sickleave/viewSickLeave.jsp");

		return mav;
	}

	/**
	 * Edit an existing Patient entity
	 * 
	 */
	@RequestMapping("/editSickLeavePatient")
	public ModelAndView editSickLeavePatient(@RequestParam Integer sickleave_id, @RequestParam Integer patient_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(patient_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("sickleave_id", sickleave_id);
		mav.addObject("patient", patient);
		mav.setViewName("sickleave/patient/editPatient.jsp");

		return mav;
	}

	/**
	 * Select the child Patient entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteSickLeavePatient")
	public ModelAndView confirmDeleteSickLeavePatient(@RequestParam Integer sickleave_id, @RequestParam Integer related_patient_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patient", patientDAO.findPatientByPrimaryKey(related_patient_id));
		mav.addObject("sickleave_id", sickleave_id);
		mav.setViewName("sickleave/patient/deletePatient.jsp");

		return mav;
	}

	/**
	 * Entry point to show all SickLeave entities
	 * 
	 */
	public String indexSickLeave() {
		return "redirect:/indexSickLeave";
	}

	/**
	 * Create a new Doctor entity
	 * 
	 */
	@RequestMapping("/newSickLeaveDoctor")
	public ModelAndView newSickLeaveDoctor(@RequestParam Integer sickleave_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("sickleave_id", sickleave_id);
		mav.addObject("doctor", new Doctor());
		mav.addObject("newFlag", true);
		mav.setViewName("sickleave/doctor/editDoctor.jsp");

		return mav;
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	@RequestMapping("/deleteSickLeaveVisit")
	public ModelAndView deleteSickLeaveVisit(@RequestParam Integer sickleave_id, @RequestParam Integer related_visit_id) {
		ModelAndView mav = new ModelAndView();

		SickLeave sickleave = sickLeaveService.deleteSickLeaveVisit(sickleave_id, related_visit_id);

		mav.addObject("sickleave_id", sickleave_id);
		mav.addObject("sickleave", sickleave);
		mav.setViewName("sickleave/viewSickLeave.jsp");

		return mav;
	}

	/**
	 * Create a new SickLeave entity
	 * 
	 */
	@RequestMapping("/newSickLeave")
	public ModelAndView newSickLeave() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sickleave", new SickLeave());
		mav.addObject("newFlag", true);
		mav.setViewName("sickleave/editSickLeave.jsp");

		return mav;
	}

	/**
	 * Select the SickLeave entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteSickLeave")
	public ModelAndView confirmDeleteSickLeave(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sickleave", sickLeaveDAO.findSickLeaveByPrimaryKey(idKey));
		mav.setViewName("sickleave/deleteSickLeave.jsp");

		return mav;
	}

	/**
	 * Show all Patient entities by SickLeave
	 * 
	 */
	@RequestMapping("/listSickLeavePatient")
	public ModelAndView listSickLeavePatient(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sickleave", sickLeaveDAO.findSickLeaveByPrimaryKey(idKey));
		mav.setViewName("sickleave/patient/listPatient.jsp");

		return mav;
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@RequestMapping("/deleteSickLeaveDoctor")
	public ModelAndView deleteSickLeaveDoctor(@RequestParam Integer sickleave_id, @RequestParam Integer related_doctor_id) {
		ModelAndView mav = new ModelAndView();

		SickLeave sickleave = sickLeaveService.deleteSickLeaveDoctor(sickleave_id, related_doctor_id);

		mav.addObject("sickleave_id", sickleave_id);
		mav.addObject("sickleave", sickleave);
		mav.setViewName("sickleave/viewSickLeave.jsp");

		return mav;
	}

	/**
	 * View an existing Visit entity
	 * 
	 */
	@RequestMapping("/selectSickLeaveVisit")
	public ModelAndView selectSickLeaveVisit(@RequestParam Integer sickleave_id, @RequestParam Integer visit_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(visit_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("sickleave_id", sickleave_id);
		mav.addObject("visit", visit);
		mav.setViewName("sickleave/visit/viewVisit.jsp");

		return mav;
	}

	/**
	 * Save an existing SickLeave entity
	 * 
	 */
	@RequestMapping("/saveSickLeave")
	public String saveSickLeave(@ModelAttribute SickLeave sickleave) {
		sickLeaveService.saveSickLeave(sickleave);
		return "forward:/indexSickLeave";
	}

	/**
	 * Edit an existing SickLeave entity
	 * 
	 */
	@RequestMapping("/editSickLeave")
	public ModelAndView editSickLeave(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sickleave", sickLeaveDAO.findSickLeaveByPrimaryKey(idKey));
		mav.setViewName("sickleave/editSickLeave.jsp");

		return mav;
	}
}