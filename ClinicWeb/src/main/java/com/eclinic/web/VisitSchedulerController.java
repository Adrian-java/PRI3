package com.eclinic.web;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.SpecializationDAO;
import com.eclinic.dao.VisitSchedulerDAO;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.VisitScheduler;

import com.eclinic.service.VisitSchedulerService;

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
 * Spring MVC controller that handles CRUD requests for VisitScheduler entities
 * 
 */

@Controller("VisitSchedulerController")
public class VisitSchedulerController {

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
	 * Service injected by Spring that provides CRUD operations for VisitScheduler entities
	 * 
	 */
	@Autowired
	private VisitSchedulerService visitSchedulerService;

	/**
	 * Show all VisitScheduler entities
	 * 
	 */
	@RequestMapping("/indexVisitScheduler")
	public ModelAndView listVisitSchedulers() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visitschedulers", visitSchedulerService.loadVisitSchedulers());

		mav.setViewName("visitscheduler/listVisitSchedulers.jsp");

		return mav;
	}

	/**
	 * Show all Specialization entities by VisitScheduler
	 * 
	 */
	@RequestMapping("/listVisitSchedulerSpecialization")
	public ModelAndView listVisitSchedulerSpecialization(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visitscheduler", visitSchedulerDAO.findVisitSchedulerByPrimaryKey(idKey));
		mav.setViewName("visitscheduler/specialization/listSpecialization.jsp");

		return mav;
	}

	/**
	 * Delete an existing VisitScheduler entity
	 * 
	 */
	@RequestMapping("/deleteVisitScheduler")
	public String deleteVisitScheduler(@RequestParam Integer idKey) {
		VisitScheduler visitscheduler = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(idKey);
		visitSchedulerService.deleteVisitScheduler(visitscheduler);
		return "forward:/indexVisitScheduler";
	}

	/**
	 * View an existing Specialization entity
	 * 
	 */
	@RequestMapping("/selectVisitSchedulerSpecialization")
	public ModelAndView selectVisitSchedulerSpecialization(@RequestParam Integer visitscheduler_id, @RequestParam Integer specialization_id) {
		Specialization specialization = specializationDAO.findSpecializationByPrimaryKey(specialization_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("visitscheduler_id", visitscheduler_id);
		mav.addObject("specialization", specialization);
		mav.setViewName("visitscheduler/specialization/viewSpecialization.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/visitschedulerController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Edit an existing VisitScheduler entity
	 * 
	 */
	@RequestMapping("/editVisitScheduler")
	public ModelAndView editVisitScheduler(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visitscheduler", visitSchedulerDAO.findVisitSchedulerByPrimaryKey(idKey));
		mav.setViewName("visitscheduler/editVisitScheduler.jsp");

		return mav;
	}

	/**
	 * Create a new VisitScheduler entity
	 * 
	 */
	@RequestMapping("/newVisitScheduler")
	public ModelAndView newVisitScheduler() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visitscheduler", new VisitScheduler());
		mav.addObject("newFlag", true);
		mav.setViewName("visitscheduler/editVisitScheduler.jsp");

		return mav;
	}

	/**
	 * Edit an existing Doctor entity
	 * 
	 */
	@RequestMapping("/editVisitSchedulerDoctor")
	public ModelAndView editVisitSchedulerDoctor(@RequestParam Integer visitscheduler_id, @RequestParam Integer doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("visitscheduler_id", visitscheduler_id);
		mav.addObject("doctor", doctor);
		mav.setViewName("visitscheduler/doctor/editDoctor.jsp");

		return mav;
	}

	/**
	 * Select the VisitScheduler entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteVisitScheduler")
	public ModelAndView confirmDeleteVisitScheduler(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visitscheduler", visitSchedulerDAO.findVisitSchedulerByPrimaryKey(idKey));
		mav.setViewName("visitscheduler/deleteVisitScheduler.jsp");

		return mav;
	}

	/**
	 * Show all Doctor entities by VisitScheduler
	 * 
	 */
	@RequestMapping("/listVisitSchedulerDoctor")
	public ModelAndView listVisitSchedulerDoctor(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visitscheduler", visitSchedulerDAO.findVisitSchedulerByPrimaryKey(idKey));
		mav.setViewName("visitscheduler/doctor/listDoctor.jsp");

		return mav;
	}

	/**
	 * Edit an existing Specialization entity
	 * 
	 */
	@RequestMapping("/editVisitSchedulerSpecialization")
	public ModelAndView editVisitSchedulerSpecialization(@RequestParam Integer visitscheduler_id, @RequestParam Integer specialization_id) {
		Specialization specialization = specializationDAO.findSpecializationByPrimaryKey(specialization_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("visitscheduler_id", visitscheduler_id);
		mav.addObject("specialization", specialization);
		mav.setViewName("visitscheduler/specialization/editSpecialization.jsp");

		return mav;
	}

	/**
	 * View an existing Doctor entity
	 * 
	 */
	@RequestMapping("/selectVisitSchedulerDoctor")
	public ModelAndView selectVisitSchedulerDoctor(@RequestParam Integer visitscheduler_id, @RequestParam Integer doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("visitscheduler_id", visitscheduler_id);
		mav.addObject("doctor", doctor);
		mav.setViewName("visitscheduler/doctor/viewDoctor.jsp");

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
	 * Delete an existing Specialization entity
	 * 
	 */
	@RequestMapping("/deleteVisitSchedulerSpecialization")
	public ModelAndView deleteVisitSchedulerSpecialization(@RequestParam Integer visitscheduler_id, @RequestParam Integer related_specialization_id) {
		ModelAndView mav = new ModelAndView();

		VisitScheduler visitscheduler = visitSchedulerService.deleteVisitSchedulerSpecialization(visitscheduler_id, related_specialization_id);

		mav.addObject("visitscheduler_id", visitscheduler_id);
		mav.addObject("visitscheduler", visitscheduler);
		mav.setViewName("visitscheduler/viewVisitScheduler.jsp");

		return mav;
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@RequestMapping("/deleteVisitSchedulerDoctor")
	public ModelAndView deleteVisitSchedulerDoctor(@RequestParam Integer visitscheduler_id, @RequestParam Integer related_doctor_id) {
		ModelAndView mav = new ModelAndView();

		VisitScheduler visitscheduler = visitSchedulerService.deleteVisitSchedulerDoctor(visitscheduler_id, related_doctor_id);

		mav.addObject("visitscheduler_id", visitscheduler_id);
		mav.addObject("visitscheduler", visitscheduler);
		mav.setViewName("visitscheduler/viewVisitScheduler.jsp");

		return mav;
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@RequestMapping("/saveVisitSchedulerDoctor")
	public ModelAndView saveVisitSchedulerDoctor(@RequestParam Integer visitscheduler_id, @ModelAttribute Doctor doctor) {
		VisitScheduler parent_visitscheduler = visitSchedulerService.saveVisitSchedulerDoctor(visitscheduler_id, doctor);

		ModelAndView mav = new ModelAndView();
		mav.addObject("visitscheduler_id", visitscheduler_id);
		mav.addObject("visitscheduler", parent_visitscheduler);
		mav.setViewName("visitscheduler/viewVisitScheduler.jsp");

		return mav;
	}

	/**
	 * Select the child Doctor entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteVisitSchedulerDoctor")
	public ModelAndView confirmDeleteVisitSchedulerDoctor(@RequestParam Integer visitscheduler_id, @RequestParam Integer related_doctor_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("doctor", doctorDAO.findDoctorByPrimaryKey(related_doctor_id));
		mav.addObject("visitscheduler_id", visitscheduler_id);
		mav.setViewName("visitscheduler/doctor/deleteDoctor.jsp");

		return mav;
	}

	/**
	 * Save an existing VisitScheduler entity
	 * 
	 */
	@RequestMapping("/saveVisitScheduler")
	public String saveVisitScheduler(@ModelAttribute VisitScheduler visitscheduler) {
		visitSchedulerService.saveVisitScheduler(visitscheduler);
		return "forward:/indexVisitScheduler";
	}

	/**
	 * Select an existing VisitScheduler entity
	 * 
	 */
	@RequestMapping("/selectVisitScheduler")
	public ModelAndView selectVisitScheduler(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visitscheduler", visitSchedulerDAO.findVisitSchedulerByPrimaryKey(idKey));
		mav.setViewName("visitscheduler/viewVisitScheduler.jsp");

		return mav;
	}

	/**
	 * Entry point to show all VisitScheduler entities
	 * 
	 */
	public String indexVisitScheduler() {
		return "redirect:/indexVisitScheduler";
	}

	/**
	 * Select the child Specialization entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteVisitSchedulerSpecialization")
	public ModelAndView confirmDeleteVisitSchedulerSpecialization(@RequestParam Integer visitscheduler_id, @RequestParam Integer related_specialization_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("specialization", specializationDAO.findSpecializationByPrimaryKey(related_specialization_id));
		mav.addObject("visitscheduler_id", visitscheduler_id);
		mav.setViewName("visitscheduler/specialization/deleteSpecialization.jsp");

		return mav;
	}

	/**
	 * Create a new Doctor entity
	 * 
	 */
	@RequestMapping("/newVisitSchedulerDoctor")
	public ModelAndView newVisitSchedulerDoctor(@RequestParam Integer visitscheduler_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("visitscheduler_id", visitscheduler_id);
		mav.addObject("doctor", new Doctor());
		mav.addObject("newFlag", true);
		mav.setViewName("visitscheduler/doctor/editDoctor.jsp");

		return mav;
	}

	/**
	 * Save an existing Specialization entity
	 * 
	 */
	@RequestMapping("/saveVisitSchedulerSpecialization")
	public ModelAndView saveVisitSchedulerSpecialization(@RequestParam Integer visitscheduler_id, @ModelAttribute Specialization specialization) {
		VisitScheduler parent_visitscheduler = visitSchedulerService.saveVisitSchedulerSpecialization(visitscheduler_id, specialization);

		ModelAndView mav = new ModelAndView();
		mav.addObject("visitscheduler_id", visitscheduler_id);
		mav.addObject("visitscheduler", parent_visitscheduler);
		mav.setViewName("visitscheduler/viewVisitScheduler.jsp");

		return mav;
	}

	/**
	 * Create a new Specialization entity
	 * 
	 */
	@RequestMapping("/newVisitSchedulerSpecialization")
	public ModelAndView newVisitSchedulerSpecialization(@RequestParam Integer visitscheduler_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("visitscheduler_id", visitscheduler_id);
		mav.addObject("specialization", new Specialization());
		mav.addObject("newFlag", true);
		mav.setViewName("visitscheduler/specialization/editSpecialization.jsp");

		return mav;
	}
}