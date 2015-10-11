package com.eclinic.web;

import com.eclinic.dao.StatusOfVisitDAO;
import com.eclinic.dao.VisitDAO;

import com.eclinic.domain.StatusOfVisit;
import com.eclinic.domain.Visit;

import com.eclinic.service.StatusOfVisitService;

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
 * Spring MVC controller that handles CRUD requests for StatusOfVisit entities
 * 
 */

@Controller("StatusOfVisitController")
public class StatusOfVisitController {

	/**
	 * DAO injected by Spring that manages StatusOfVisit entities
	 * 
	 */
	@Autowired
	private StatusOfVisitDAO statusOfVisitDAO;

	/**
	 * DAO injected by Spring that manages Visit entities
	 * 
	 */
	@Autowired
	private VisitDAO visitDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for StatusOfVisit entities
	 * 
	 */
	@Autowired
	private StatusOfVisitService statusOfVisitService;

	/**
	 * View an existing Visit entity
	 * 
	 */
	@RequestMapping("/selectStatusOfVisitVisits")
	public ModelAndView selectStatusOfVisitVisits(@RequestParam Integer statusofvisit_id, @RequestParam Integer visits_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(visits_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusofvisit_id", statusofvisit_id);
		mav.addObject("visit", visit);
		mav.setViewName("statusofvisit/visits/viewVisits.jsp");

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
	 * Delete an existing StatusOfVisit entity
	 * 
	 */
	@RequestMapping("/deleteStatusOfVisit")
	public String deleteStatusOfVisit(@RequestParam Integer idKey) {
		StatusOfVisit statusofvisit = statusOfVisitDAO.findStatusOfVisitByPrimaryKey(idKey);
		statusOfVisitService.deleteStatusOfVisit(statusofvisit);
		return "forward:/indexStatusOfVisit";
	}

	/**
	 * Select the child Visit entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteStatusOfVisitVisits")
	public ModelAndView confirmDeleteStatusOfVisitVisits(@RequestParam Integer statusofvisit_id, @RequestParam Integer related_visits_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visit", visitDAO.findVisitByPrimaryKey(related_visits_id));
		mav.addObject("statusofvisit_id", statusofvisit_id);
		mav.setViewName("statusofvisit/visits/deleteVisits.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/statusofvisitController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Save an existing Visit entity
	 * 
	 */
	@RequestMapping("/saveStatusOfVisitVisits")
	public ModelAndView saveStatusOfVisitVisits(@RequestParam Integer statusofvisit_id, @ModelAttribute Visit visits) {
		StatusOfVisit parent_statusofvisit = statusOfVisitService.saveStatusOfVisitVisits(statusofvisit_id, visits);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusofvisit_id", statusofvisit_id);
		mav.addObject("statusofvisit", parent_statusofvisit);
		mav.setViewName("statusofvisit/viewStatusOfVisit.jsp");

		return mav;
	}

	/**
	 * Show all StatusOfVisit entities
	 * 
	 */
	@RequestMapping("/indexStatusOfVisit")
	public ModelAndView listStatusOfVisits() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusofvisits", statusOfVisitService.loadStatusOfVisits());

		mav.setViewName("statusofvisit/listStatusOfVisits.jsp");

		return mav;
	}

	/**
	 * Select an existing StatusOfVisit entity
	 * 
	 */
	@RequestMapping("/selectStatusOfVisit")
	public ModelAndView selectStatusOfVisit(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusofvisit", statusOfVisitDAO.findStatusOfVisitByPrimaryKey(idKey));
		mav.setViewName("statusofvisit/viewStatusOfVisit.jsp");

		return mav;
	}

	/**
	 * Create a new StatusOfVisit entity
	 * 
	 */
	@RequestMapping("/newStatusOfVisit")
	public ModelAndView newStatusOfVisit() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusofvisit", new StatusOfVisit());
		mav.addObject("newFlag", true);
		mav.setViewName("statusofvisit/editStatusOfVisit.jsp");

		return mav;
	}

	/**
	 * Edit an existing StatusOfVisit entity
	 * 
	 */
	@RequestMapping("/editStatusOfVisit")
	public ModelAndView editStatusOfVisit(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusofvisit", statusOfVisitDAO.findStatusOfVisitByPrimaryKey(idKey));
		mav.setViewName("statusofvisit/editStatusOfVisit.jsp");

		return mav;
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	@RequestMapping("/deleteStatusOfVisitVisits")
	public ModelAndView deleteStatusOfVisitVisits(@RequestParam Integer statusofvisit_id, @RequestParam Integer related_visits_id) {
		ModelAndView mav = new ModelAndView();

		StatusOfVisit statusofvisit = statusOfVisitService.deleteStatusOfVisitVisits(statusofvisit_id, related_visits_id);

		mav.addObject("statusofvisit_id", statusofvisit_id);
		mav.addObject("statusofvisit", statusofvisit);
		mav.setViewName("statusofvisit/viewStatusOfVisit.jsp");

		return mav;
	}

	/**
	 * Select the StatusOfVisit entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteStatusOfVisit")
	public ModelAndView confirmDeleteStatusOfVisit(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusofvisit", statusOfVisitDAO.findStatusOfVisitByPrimaryKey(idKey));
		mav.setViewName("statusofvisit/deleteStatusOfVisit.jsp");

		return mav;
	}

	/**
	 * Entry point to show all StatusOfVisit entities
	 * 
	 */
	public String indexStatusOfVisit() {
		return "redirect:/indexStatusOfVisit";
	}

	/**
	 * Save an existing StatusOfVisit entity
	 * 
	 */
	@RequestMapping("/saveStatusOfVisit")
	public String saveStatusOfVisit(@ModelAttribute StatusOfVisit statusofvisit) {
		statusOfVisitService.saveStatusOfVisit(statusofvisit);
		return "forward:/indexStatusOfVisit";
	}

	/**
	 * Show all Visit entities by StatusOfVisit
	 * 
	 */
	@RequestMapping("/listStatusOfVisitVisits")
	public ModelAndView listStatusOfVisitVisits(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusofvisit", statusOfVisitDAO.findStatusOfVisitByPrimaryKey(idKey));
		mav.setViewName("statusofvisit/visits/listVisits.jsp");

		return mav;
	}

	/**
	 * Edit an existing Visit entity
	 * 
	 */
	@RequestMapping("/editStatusOfVisitVisits")
	public ModelAndView editStatusOfVisitVisits(@RequestParam Integer statusofvisit_id, @RequestParam Integer visits_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(visits_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusofvisit_id", statusofvisit_id);
		mav.addObject("visit", visit);
		mav.setViewName("statusofvisit/visits/editVisits.jsp");

		return mav;
	}

	/**
	 * Create a new Visit entity
	 * 
	 */
	@RequestMapping("/newStatusOfVisitVisits")
	public ModelAndView newStatusOfVisitVisits(@RequestParam Integer statusofvisit_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("statusofvisit_id", statusofvisit_id);
		mav.addObject("visit", new Visit());
		mav.addObject("newFlag", true);
		mav.setViewName("statusofvisit/visits/editVisits.jsp");

		return mav;
	}
}