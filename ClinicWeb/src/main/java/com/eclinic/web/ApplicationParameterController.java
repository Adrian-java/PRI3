package com.eclinic.web;

import com.eclinic.dao.ApplicationParameterDAO;

import com.eclinic.domain.ApplicationParameter;

import com.eclinic.service.ApplicationParameterService;

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
 * Spring MVC controller that handles CRUD requests for ApplicationParameter entities
 * 
 */

@Controller("ApplicationParameterController")
public class ApplicationParameterController {

	/**
	 * DAO injected by Spring that manages ApplicationParameter entities
	 * 
	 */
	@Autowired
	private ApplicationParameterDAO applicationParameterDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for ApplicationParameter entities
	 * 
	 */
	@Autowired
	private ApplicationParameterService applicationParameterService;

	/**
	 * Delete an existing ApplicationParameter entity
	 * 
	 */
	@RequestMapping("/deleteApplicationParameter")
	public String deleteApplicationParameter(@RequestParam Integer idKey) {
		ApplicationParameter applicationparameter = applicationParameterDAO.findApplicationParameterByPrimaryKey(idKey);
		applicationParameterService.deleteApplicationParameter(applicationparameter);
		return "forward:/indexApplicationParameter";
	}

	/**
	 * Select the ApplicationParameter entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteApplicationParameter")
	public ModelAndView confirmDeleteApplicationParameter(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("applicationparameter", applicationParameterDAO.findApplicationParameterByPrimaryKey(idKey));
		mav.setViewName("applicationparameter/deleteApplicationParameter.jsp");

		return mav;
	}

	/**
	 * Edit an existing ApplicationParameter entity
	 * 
	 */
	@RequestMapping("/editApplicationParameter")
	public ModelAndView editApplicationParameter(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("applicationparameter", applicationParameterDAO.findApplicationParameterByPrimaryKey(idKey));
		mav.setViewName("applicationparameter/editApplicationParameter.jsp");

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
	 * Entry point to show all ApplicationParameter entities
	 * 
	 */
	public String indexApplicationParameter() {
		return "redirect:/indexApplicationParameter";
	}

	/**
	 * Select an existing ApplicationParameter entity
	 * 
	 */
	@RequestMapping("/selectApplicationParameter")
	public ModelAndView selectApplicationParameter(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("applicationparameter", applicationParameterDAO.findApplicationParameterByPrimaryKey(idKey));
		mav.setViewName("applicationparameter/viewApplicationParameter.jsp");

		return mav;
	}

	/**
	 * Show all ApplicationParameter entities
	 * 
	 */
	@RequestMapping("/indexApplicationParameter")
	public ModelAndView listApplicationParameters() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("applicationparameters", applicationParameterService.loadApplicationParameters());

		mav.setViewName("applicationparameter/listApplicationParameters.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/applicationparameterController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Save an existing ApplicationParameter entity
	 * 
	 */
	@RequestMapping("/saveApplicationParameter")
	public String saveApplicationParameter(@ModelAttribute ApplicationParameter applicationparameter) {
		applicationParameterService.saveApplicationParameter(applicationparameter);
		return "forward:/indexApplicationParameter";
	}

	/**
	 * Create a new ApplicationParameter entity
	 * 
	 */
	@RequestMapping("/newApplicationParameter")
	public ModelAndView newApplicationParameter() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("applicationparameter", new ApplicationParameter());
		mav.addObject("newFlag", true);
		mav.setViewName("applicationparameter/editApplicationParameter.jsp");

		return mav;
	}
}