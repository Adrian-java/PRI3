package com.eclinic.web;

import com.eclinic.dao.SystemErrorDAO;

import com.eclinic.domain.SystemError;

import com.eclinic.service.SystemErrorService;

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
 * Spring MVC controller that handles CRUD requests for SystemError entities
 * 
 */

@Controller("SystemErrorController")
public class SystemErrorController {

	/**
	 * DAO injected by Spring that manages SystemError entities
	 * 
	 */
	@Autowired
	private SystemErrorDAO systemErrorDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for SystemError entities
	 * 
	 */
	@Autowired
	private SystemErrorService systemErrorService;

	/**
	 * Select the SystemError entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteSystemError")
	public ModelAndView confirmDeleteSystemError(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("systemerror", systemErrorDAO.findSystemErrorByPrimaryKey(idKey));
		mav.setViewName("systemerror/deleteSystemError.jsp");

		return mav;
	}

	/**
	 * Edit an existing SystemError entity
	 * 
	 */
	@RequestMapping("/editSystemError")
	public ModelAndView editSystemError(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("systemerror", systemErrorDAO.findSystemErrorByPrimaryKey(idKey));
		mav.setViewName("systemerror/editSystemError.jsp");

		return mav;
	}

	/**
	 * Entry point to show all SystemError entities
	 * 
	 */
	public String indexSystemError() {
		return "redirect:/indexSystemError";
	}

	/**
	 */
	@RequestMapping("/systemerrorController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Select an existing SystemError entity
	 * 
	 */
	@RequestMapping("/selectSystemError")
	public ModelAndView selectSystemError(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("systemerror", systemErrorDAO.findSystemErrorByPrimaryKey(idKey));
		mav.setViewName("systemerror/viewSystemError.jsp");

		return mav;
	}

	/**
	 * Create a new SystemError entity
	 * 
	 */
	@RequestMapping("/newSystemError")
	public ModelAndView newSystemError() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("systemerror", new SystemError());
		mav.addObject("newFlag", true);
		mav.setViewName("systemerror/editSystemError.jsp");

		return mav;
	}

	/**
	 * Delete an existing SystemError entity
	 * 
	 */
	@RequestMapping("/deleteSystemError")
	public String deleteSystemError(@RequestParam Integer idKey) {
		SystemError systemerror = systemErrorDAO.findSystemErrorByPrimaryKey(idKey);
		systemErrorService.deleteSystemError(systemerror);
		return "forward:/indexSystemError";
	}

	/**
	 * Show all SystemError entities
	 * 
	 */
	@RequestMapping("/indexSystemError")
	public ModelAndView listSystemErrors() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("systemerrors", systemErrorService.loadSystemErrors());

		mav.setViewName("systemerror/listSystemErrors.jsp");

		return mav;
	}

	/**
	 * Save an existing SystemError entity
	 * 
	 */
	@RequestMapping("/saveSystemError")
	public String saveSystemError(@ModelAttribute SystemError systemerror) {
		systemErrorService.saveSystemError(systemerror);
		return "forward:/indexSystemError";
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
}