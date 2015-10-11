package com.eclinic.web;

import com.eclinic.dao.SpecalVisitFieldDAO;
import com.eclinic.dao.SpecializationDAO;

import com.eclinic.domain.SpecalVisitField;
import com.eclinic.domain.Specialization;

import com.eclinic.service.SpecalVisitFieldService;

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
 * Spring MVC controller that handles CRUD requests for SpecalVisitField entities
 * 
 */

@Controller("SpecalVisitFieldController")
public class SpecalVisitFieldController {

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
	 * Service injected by Spring that provides CRUD operations for SpecalVisitField entities
	 * 
	 */
	@Autowired
	private SpecalVisitFieldService specalVisitFieldService;

	/**
	 * View an existing Specialization entity
	 * 
	 */
	@RequestMapping("/selectSpecalVisitFieldSpecialization")
	public ModelAndView selectSpecalVisitFieldSpecialization(@RequestParam Integer specalvisitfield_id, @RequestParam Integer specialization_id) {
		Specialization specialization = specializationDAO.findSpecializationByPrimaryKey(specialization_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("specalvisitfield_id", specalvisitfield_id);
		mav.addObject("specialization", specialization);
		mav.setViewName("specalvisitfield/specialization/viewSpecialization.jsp");

		return mav;
	}

	/**
	 * Delete an existing Specialization entity
	 * 
	 */
	@RequestMapping("/deleteSpecalVisitFieldSpecialization")
	public ModelAndView deleteSpecalVisitFieldSpecialization(@RequestParam Integer specalvisitfield_id, @RequestParam Integer related_specialization_id) {
		ModelAndView mav = new ModelAndView();

		SpecalVisitField specalvisitfield = specalVisitFieldService.deleteSpecalVisitFieldSpecialization(specalvisitfield_id, related_specialization_id);

		mav.addObject("specalvisitfield_id", specalvisitfield_id);
		mav.addObject("specalvisitfield", specalvisitfield);
		mav.setViewName("specalvisitfield/viewSpecalVisitField.jsp");

		return mav;
	}

	/**
	 * Show all Specialization entities by SpecalVisitField
	 * 
	 */
	@RequestMapping("/listSpecalVisitFieldSpecialization")
	public ModelAndView listSpecalVisitFieldSpecialization(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("specalvisitfield", specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(idKey));
		mav.setViewName("specalvisitfield/specialization/listSpecialization.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/specalvisitfieldController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Create a new Specialization entity
	 * 
	 */
	@RequestMapping("/newSpecalVisitFieldSpecialization")
	public ModelAndView newSpecalVisitFieldSpecialization(@RequestParam Integer specalvisitfield_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("specalvisitfield_id", specalvisitfield_id);
		mav.addObject("specialization", new Specialization());
		mav.addObject("newFlag", true);
		mav.setViewName("specalvisitfield/specialization/editSpecialization.jsp");

		return mav;
	}

	/**
	 * Delete an existing SpecalVisitField entity
	 * 
	 */
	@RequestMapping("/deleteSpecalVisitField")
	public String deleteSpecalVisitField(@RequestParam Integer idKey) {
		SpecalVisitField specalvisitfield = specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(idKey);
		specalVisitFieldService.deleteSpecalVisitField(specalvisitfield);
		return "forward:/indexSpecalVisitField";
	}

	/**
	 * Save an existing Specialization entity
	 * 
	 */
	@RequestMapping("/saveSpecalVisitFieldSpecialization")
	public ModelAndView saveSpecalVisitFieldSpecialization(@RequestParam Integer specalvisitfield_id, @ModelAttribute Specialization specialization) {
		SpecalVisitField parent_specalvisitfield = specalVisitFieldService.saveSpecalVisitFieldSpecialization(specalvisitfield_id, specialization);

		ModelAndView mav = new ModelAndView();
		mav.addObject("specalvisitfield_id", specalvisitfield_id);
		mav.addObject("specalvisitfield", parent_specalvisitfield);
		mav.setViewName("specalvisitfield/viewSpecalVisitField.jsp");

		return mav;
	}

	/**
	 * Select an existing SpecalVisitField entity
	 * 
	 */
	@RequestMapping("/selectSpecalVisitField")
	public ModelAndView selectSpecalVisitField(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("specalvisitfield", specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(idKey));
		mav.setViewName("specalvisitfield/viewSpecalVisitField.jsp");

		return mav;
	}

	/**
	 * Select the SpecalVisitField entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteSpecalVisitField")
	public ModelAndView confirmDeleteSpecalVisitField(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("specalvisitfield", specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(idKey));
		mav.setViewName("specalvisitfield/deleteSpecalVisitField.jsp");

		return mav;
	}

	/**
	 * Show all SpecalVisitField entities
	 * 
	 */
	@RequestMapping("/indexSpecalVisitField")
	public ModelAndView listSpecalVisitFields() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("specalvisitfields", specalVisitFieldService.loadSpecalVisitFields());

		mav.setViewName("specalvisitfield/listSpecalVisitFields.jsp");

		return mav;
	}

	/**
	 * Save an existing SpecalVisitField entity
	 * 
	 */
	@RequestMapping("/saveSpecalVisitField")
	public String saveSpecalVisitField(@ModelAttribute SpecalVisitField specalvisitfield) {
		specalVisitFieldService.saveSpecalVisitField(specalvisitfield);
		return "forward:/indexSpecalVisitField";
	}

	/**
	 * Edit an existing Specialization entity
	 * 
	 */
	@RequestMapping("/editSpecalVisitFieldSpecialization")
	public ModelAndView editSpecalVisitFieldSpecialization(@RequestParam Integer specalvisitfield_id, @RequestParam Integer specialization_id) {
		Specialization specialization = specializationDAO.findSpecializationByPrimaryKey(specialization_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("specalvisitfield_id", specalvisitfield_id);
		mav.addObject("specialization", specialization);
		mav.setViewName("specalvisitfield/specialization/editSpecialization.jsp");

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
	 * Entry point to show all SpecalVisitField entities
	 * 
	 */
	public String indexSpecalVisitField() {
		return "redirect:/indexSpecalVisitField";
	}

	/**
	 * Select the child Specialization entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteSpecalVisitFieldSpecialization")
	public ModelAndView confirmDeleteSpecalVisitFieldSpecialization(@RequestParam Integer specalvisitfield_id, @RequestParam Integer related_specialization_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("specialization", specializationDAO.findSpecializationByPrimaryKey(related_specialization_id));
		mav.addObject("specalvisitfield_id", specalvisitfield_id);
		mav.setViewName("specalvisitfield/specialization/deleteSpecialization.jsp");

		return mav;
	}

	/**
	 * Edit an existing SpecalVisitField entity
	 * 
	 */
	@RequestMapping("/editSpecalVisitField")
	public ModelAndView editSpecalVisitField(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("specalvisitfield", specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(idKey));
		mav.setViewName("specalvisitfield/editSpecalVisitField.jsp");

		return mav;
	}

	/**
	 * Create a new SpecalVisitField entity
	 * 
	 */
	@RequestMapping("/newSpecalVisitField")
	public ModelAndView newSpecalVisitField() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("specalvisitfield", new SpecalVisitField());
		mav.addObject("newFlag", true);
		mav.setViewName("specalvisitfield/editSpecalVisitField.jsp");

		return mav;
	}
}