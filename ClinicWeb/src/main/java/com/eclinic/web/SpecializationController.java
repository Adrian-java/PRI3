package com.eclinic.web;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.SpecalVisitFieldDAO;
import com.eclinic.dao.SpecializationDAO;
import com.eclinic.dao.VisitSchedulerDAO;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.SpecalVisitField;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.VisitScheduler;

import com.eclinic.service.SpecializationService;

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
 * Spring MVC controller that handles CRUD requests for Specialization entities
 * 
 */

@Controller("SpecializationController")
public class SpecializationController {

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
	 * Service injected by Spring that provides CRUD operations for Specialization entities
	 * 
	 */
	@Autowired
	private SpecializationService specializationService;

	/**
	 * View an existing SpecalVisitField entity
	 * 
	 */
	@RequestMapping("/selectSpecializationSpecalVisitFields")
	public ModelAndView selectSpecializationSpecalVisitFields(@RequestParam Integer specialization_id, @RequestParam Integer specalvisitfields_id) {
		SpecalVisitField specalvisitfield = specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(specalvisitfields_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("specialization_id", specialization_id);
		mav.addObject("specalvisitfield", specalvisitfield);
		mav.setViewName("specialization/specalvisitfields/viewSpecalVisitFields.jsp");

		return mav;
	}

	/**
	 * Show all SpecalVisitField entities by Specialization
	 * 
	 */
	@RequestMapping("/listSpecializationSpecalVisitFields")
	public ModelAndView listSpecializationSpecalVisitFields(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("specialization", specializationDAO.findSpecializationByPrimaryKey(idKey));
		mav.setViewName("specialization/specalvisitfields/listSpecalVisitFields.jsp");

		return mav;
	}

	/**
	 * Save an existing VisitScheduler entity
	 * 
	 */
	@RequestMapping("/saveSpecializationVisitSchedulers")
	public ModelAndView saveSpecializationVisitSchedulers(@RequestParam Integer specialization_id, @ModelAttribute VisitScheduler visitschedulers) {
		Specialization parent_specialization = specializationService.saveSpecializationVisitSchedulers(specialization_id, visitschedulers);

		ModelAndView mav = new ModelAndView();
		mav.addObject("specialization_id", specialization_id);
		mav.addObject("specialization", parent_specialization);
		mav.setViewName("specialization/viewSpecialization.jsp");

		return mav;
	}

	/**
	 * Create a new Doctor entity
	 * 
	 */
	@RequestMapping("/newSpecializationDoctor")
	public ModelAndView newSpecializationDoctor(@RequestParam Integer specialization_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("specialization_id", specialization_id);
		mav.addObject("doctor", new Doctor());
		mav.addObject("newFlag", true);
		mav.setViewName("specialization/doctor/editDoctor.jsp");

		return mav;
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@RequestMapping("/deleteSpecializationDoctor")
	public ModelAndView deleteSpecializationDoctor(@RequestParam Integer specialization_id, @RequestParam Integer related_doctor_id) {
		ModelAndView mav = new ModelAndView();

		Specialization specialization = specializationService.deleteSpecializationDoctor(specialization_id, related_doctor_id);

		mav.addObject("specialization_id", specialization_id);
		mav.addObject("specialization", specialization);
		mav.setViewName("specialization/viewSpecialization.jsp");

		return mav;
	}

	/**
	 * Select the Specialization entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteSpecialization")
	public ModelAndView confirmDeleteSpecialization(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("specialization", specializationDAO.findSpecializationByPrimaryKey(idKey));
		mav.setViewName("specialization/deleteSpecialization.jsp");

		return mav;
	}

	/**
	 * Show all Doctor entities by Specialization
	 * 
	 */
	@RequestMapping("/listSpecializationDoctor")
	public ModelAndView listSpecializationDoctor(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("specialization", specializationDAO.findSpecializationByPrimaryKey(idKey));
		mav.setViewName("specialization/doctor/listDoctor.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/specializationController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@RequestMapping("/saveSpecializationDoctor")
	public ModelAndView saveSpecializationDoctor(@RequestParam Integer specialization_id, @ModelAttribute Doctor doctor) {
		Specialization parent_specialization = specializationService.saveSpecializationDoctor(specialization_id, doctor);

		ModelAndView mav = new ModelAndView();
		mav.addObject("specialization_id", specialization_id);
		mav.addObject("specialization", parent_specialization);
		mav.setViewName("specialization/viewSpecialization.jsp");

		return mav;
	}

	/**
	 * Show all VisitScheduler entities by Specialization
	 * 
	 */
	@RequestMapping("/listSpecializationVisitSchedulers")
	public ModelAndView listSpecializationVisitSchedulers(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("specialization", specializationDAO.findSpecializationByPrimaryKey(idKey));
		mav.setViewName("specialization/visitschedulers/listVisitSchedulers.jsp");

		return mav;
	}

	/**
	 * Delete an existing Specialization entity
	 * 
	 */
	@RequestMapping("/deleteSpecialization")
	public String deleteSpecialization(@RequestParam Integer idKey) {
		Specialization specialization = specializationDAO.findSpecializationByPrimaryKey(idKey);
		specializationService.deleteSpecialization(specialization);
		return "forward:/indexSpecialization";
	}

	/**
	 * Save an existing SpecalVisitField entity
	 * 
	 */
	@RequestMapping("/saveSpecializationSpecalVisitFields")
	public ModelAndView saveSpecializationSpecalVisitFields(@RequestParam Integer specialization_id, @ModelAttribute SpecalVisitField specalvisitfields) {
		Specialization parent_specialization = specializationService.saveSpecializationSpecalVisitFields(specialization_id, specalvisitfields);

		ModelAndView mav = new ModelAndView();
		mav.addObject("specialization_id", specialization_id);
		mav.addObject("specialization", parent_specialization);
		mav.setViewName("specialization/viewSpecialization.jsp");

		return mav;
	}

	/**
	 * Edit an existing Specialization entity
	 * 
	 */
	@RequestMapping("/editSpecialization")
	public ModelAndView editSpecialization(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("specialization", specializationDAO.findSpecializationByPrimaryKey(idKey));
		mav.setViewName("specialization/editSpecialization.jsp");

		return mav;
	}

	/**
	 * View an existing VisitScheduler entity
	 * 
	 */
	@RequestMapping("/selectSpecializationVisitSchedulers")
	public ModelAndView selectSpecializationVisitSchedulers(@RequestParam Integer specialization_id, @RequestParam Integer visitschedulers_id) {
		VisitScheduler visitscheduler = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitschedulers_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("specialization_id", specialization_id);
		mav.addObject("visitscheduler", visitscheduler);
		mav.setViewName("specialization/visitschedulers/viewVisitSchedulers.jsp");

		return mav;
	}

	/**
	 * Select the child VisitScheduler entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteSpecializationVisitSchedulers")
	public ModelAndView confirmDeleteSpecializationVisitSchedulers(@RequestParam Integer specialization_id, @RequestParam Integer related_visitschedulers_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visitscheduler", visitSchedulerDAO.findVisitSchedulerByPrimaryKey(related_visitschedulers_id));
		mav.addObject("specialization_id", specialization_id);
		mav.setViewName("specialization/visitschedulers/deleteVisitSchedulers.jsp");

		return mav;
	}

	/**
	 * View an existing Doctor entity
	 * 
	 */
	@RequestMapping("/selectSpecializationDoctor")
	public ModelAndView selectSpecializationDoctor(@RequestParam Integer specialization_id, @RequestParam Integer doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("specialization_id", specialization_id);
		mav.addObject("doctor", doctor);
		mav.setViewName("specialization/doctor/viewDoctor.jsp");

		return mav;
	}

	/**
	 * Show all Specialization entities
	 * 
	 */
	@RequestMapping("/indexSpecialization")
	public ModelAndView listSpecializations() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("specializations", specializationService.loadSpecializations());

		mav.setViewName("specialization/listSpecializations.jsp");

		return mav;
	}

	/**
	 * Create a new VisitScheduler entity
	 * 
	 */
	@RequestMapping("/newSpecializationVisitSchedulers")
	public ModelAndView newSpecializationVisitSchedulers(@RequestParam Integer specialization_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("specialization_id", specialization_id);
		mav.addObject("visitscheduler", new VisitScheduler());
		mav.addObject("newFlag", true);
		mav.setViewName("specialization/visitschedulers/editVisitSchedulers.jsp");

		return mav;
	}

	/**
	 * Edit an existing SpecalVisitField entity
	 * 
	 */
	@RequestMapping("/editSpecializationSpecalVisitFields")
	public ModelAndView editSpecializationSpecalVisitFields(@RequestParam Integer specialization_id, @RequestParam Integer specalvisitfields_id) {
		SpecalVisitField specalvisitfield = specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(specalvisitfields_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("specialization_id", specialization_id);
		mav.addObject("specalvisitfield", specalvisitfield);
		mav.setViewName("specialization/specalvisitfields/editSpecalVisitFields.jsp");

		return mav;
	}

	/**
	 * Save an existing Specialization entity
	 * 
	 */
	@RequestMapping("/saveSpecialization")
	public String saveSpecialization(@ModelAttribute Specialization specialization) {
		specializationService.saveSpecialization(specialization);
		return "forward:/indexSpecialization";
	}

	/**
	 * Create a new SpecalVisitField entity
	 * 
	 */
	@RequestMapping("/newSpecializationSpecalVisitFields")
	public ModelAndView newSpecializationSpecalVisitFields(@RequestParam Integer specialization_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("specialization_id", specialization_id);
		mav.addObject("specalvisitfield", new SpecalVisitField());
		mav.addObject("newFlag", true);
		mav.setViewName("specialization/specalvisitfields/editSpecalVisitFields.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Specialization entities
	 * 
	 */
	public String indexSpecialization() {
		return "redirect:/indexSpecialization";
	}

	/**
	 * Select an existing Specialization entity
	 * 
	 */
	@RequestMapping("/selectSpecialization")
	public ModelAndView selectSpecialization(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("specialization", specializationDAO.findSpecializationByPrimaryKey(idKey));
		mav.setViewName("specialization/viewSpecialization.jsp");

		return mav;
	}

	/**
	 * Delete an existing VisitScheduler entity
	 * 
	 */
	@RequestMapping("/deleteSpecializationVisitSchedulers")
	public ModelAndView deleteSpecializationVisitSchedulers(@RequestParam Integer specialization_id, @RequestParam Integer related_visitschedulers_id) {
		ModelAndView mav = new ModelAndView();

		Specialization specialization = specializationService.deleteSpecializationVisitSchedulers(specialization_id, related_visitschedulers_id);

		mav.addObject("specialization_id", specialization_id);
		mav.addObject("specialization", specialization);
		mav.setViewName("specialization/viewSpecialization.jsp");

		return mav;
	}

	/**
	 * Select the child Doctor entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteSpecializationDoctor")
	public ModelAndView confirmDeleteSpecializationDoctor(@RequestParam Integer specialization_id, @RequestParam Integer related_doctor_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("doctor", doctorDAO.findDoctorByPrimaryKey(related_doctor_id));
		mav.addObject("specialization_id", specialization_id);
		mav.setViewName("specialization/doctor/deleteDoctor.jsp");

		return mav;
	}

	/**
	 * Edit an existing VisitScheduler entity
	 * 
	 */
	@RequestMapping("/editSpecializationVisitSchedulers")
	public ModelAndView editSpecializationVisitSchedulers(@RequestParam Integer specialization_id, @RequestParam Integer visitschedulers_id) {
		VisitScheduler visitscheduler = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitschedulers_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("specialization_id", specialization_id);
		mav.addObject("visitscheduler", visitscheduler);
		mav.setViewName("specialization/visitschedulers/editVisitSchedulers.jsp");

		return mav;
	}

	/**
	 * Delete an existing SpecalVisitField entity
	 * 
	 */
	@RequestMapping("/deleteSpecializationSpecalVisitFields")
	public ModelAndView deleteSpecializationSpecalVisitFields(@RequestParam Integer specialization_id, @RequestParam Integer related_specalvisitfields_id) {
		ModelAndView mav = new ModelAndView();

		Specialization specialization = specializationService.deleteSpecializationSpecalVisitFields(specialization_id, related_specalvisitfields_id);

		mav.addObject("specialization_id", specialization_id);
		mav.addObject("specialization", specialization);
		mav.setViewName("specialization/viewSpecialization.jsp");

		return mav;
	}

	/**
	 * Select the child SpecalVisitField entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteSpecializationSpecalVisitFields")
	public ModelAndView confirmDeleteSpecializationSpecalVisitFields(@RequestParam Integer specialization_id, @RequestParam Integer related_specalvisitfields_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("specalvisitfield", specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(related_specalvisitfields_id));
		mav.addObject("specialization_id", specialization_id);
		mav.setViewName("specialization/specalvisitfields/deleteSpecalVisitFields.jsp");

		return mav;
	}

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
	 * Edit an existing Doctor entity
	 * 
	 */
	@RequestMapping("/editSpecializationDoctor")
	public ModelAndView editSpecializationDoctor(@RequestParam Integer specialization_id, @RequestParam Integer doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("specialization_id", specialization_id);
		mav.addObject("doctor", doctor);
		mav.setViewName("specialization/doctor/editDoctor.jsp");

		return mav;
	}

	/**
	 * Create a new Specialization entity
	 * 
	 */
	@RequestMapping("/newSpecialization")
	public ModelAndView newSpecialization() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("specialization", new Specialization());
		mav.addObject("newFlag", true);
		mav.setViewName("specialization/editSpecialization.jsp");

		return mav;
	}
}