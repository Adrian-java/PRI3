package com.eclinic.web;

import com.eclinic.dao.TypeOfVisitDAO;
import com.eclinic.dao.VisitDAO;

import com.eclinic.domain.TypeOfVisit;
import com.eclinic.domain.Visit;

import com.eclinic.service.TypeOfVisitService;

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
 * Spring MVC controller that handles CRUD requests for TypeOfVisit entities
 * 
 */

@Controller("TypeOfVisitController")
public class TypeOfVisitController {

	/**
	 * DAO injected by Spring that manages TypeOfVisit entities
	 * 
	 */
	@Autowired
	private TypeOfVisitDAO typeOfVisitDAO;

	/**
	 * DAO injected by Spring that manages Visit entities
	 * 
	 */
	@Autowired
	private VisitDAO visitDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for TypeOfVisit entities
	 * 
	 */
	@Autowired
	private TypeOfVisitService typeOfVisitService;

	/**
	 * Save an existing TypeOfVisit entity
	 * 
	 */
	@RequestMapping("/saveTypeOfVisit")
	public String saveTypeOfVisit(@ModelAttribute TypeOfVisit typeofvisit) {
		typeOfVisitService.saveTypeOfVisit(typeofvisit);
		return "forward:/indexTypeOfVisit";
	}

	/**
	 * Edit an existing TypeOfVisit entity
	 * 
	 */
	@RequestMapping("/editTypeOfVisit")
	public ModelAndView editTypeOfVisit(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("typeofvisit", typeOfVisitDAO.findTypeOfVisitByPrimaryKey(idKey));
		mav.setViewName("typeofvisit/editTypeOfVisit.jsp");

		return mav;
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */
	@RequestMapping("/saveTypeOfVisitVisits")
	public ModelAndView saveTypeOfVisitVisits(@RequestParam Integer typeofvisit_id, @ModelAttribute Visit visits) {
		TypeOfVisit parent_typeofvisit = typeOfVisitService.saveTypeOfVisitVisits(typeofvisit_id, visits);

		ModelAndView mav = new ModelAndView();
		mav.addObject("typeofvisit_id", typeofvisit_id);
		mav.addObject("typeofvisit", parent_typeofvisit);
		mav.setViewName("typeofvisit/viewTypeOfVisit.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/typeofvisitController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Show all Visit entities by TypeOfVisit
	 * 
	 */
	@RequestMapping("/listTypeOfVisitVisits")
	public ModelAndView listTypeOfVisitVisits(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("typeofvisit", typeOfVisitDAO.findTypeOfVisitByPrimaryKey(idKey));
		mav.setViewName("typeofvisit/visits/listVisits.jsp");

		return mav;
	}

	/**
	 * Delete an existing TypeOfVisit entity
	 * 
	 */
	@RequestMapping("/deleteTypeOfVisit")
	public String deleteTypeOfVisit(@RequestParam Integer idKey) {
		TypeOfVisit typeofvisit = typeOfVisitDAO.findTypeOfVisitByPrimaryKey(idKey);
		typeOfVisitService.deleteTypeOfVisit(typeofvisit);
		return "forward:/indexTypeOfVisit";
	}

	/**
	 * Create a new TypeOfVisit entity
	 * 
	 */
	@RequestMapping("/newTypeOfVisit")
	public ModelAndView newTypeOfVisit() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("typeofvisit", new TypeOfVisit());
		mav.addObject("newFlag", true);
		mav.setViewName("typeofvisit/editTypeOfVisit.jsp");

		return mav;
	}

	/**
	 * View an existing Visit entity
	 * 
	 */
	@RequestMapping("/selectTypeOfVisitVisits")
	public ModelAndView selectTypeOfVisitVisits(@RequestParam Integer typeofvisit_id, @RequestParam Integer visits_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(visits_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("typeofvisit_id", typeofvisit_id);
		mav.addObject("visit", visit);
		mav.setViewName("typeofvisit/visits/viewVisits.jsp");

		return mav;
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	@RequestMapping("/deleteTypeOfVisitVisits")
	public ModelAndView deleteTypeOfVisitVisits(@RequestParam Integer typeofvisit_id, @RequestParam Integer related_visits_id) {
		ModelAndView mav = new ModelAndView();

		TypeOfVisit typeofvisit = typeOfVisitService.deleteTypeOfVisitVisits(typeofvisit_id, related_visits_id);

		mav.addObject("typeofvisit_id", typeofvisit_id);
		mav.addObject("typeofvisit", typeofvisit);
		mav.setViewName("typeofvisit/viewTypeOfVisit.jsp");

		return mav;
	}

	/**
	 * Select the child Visit entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTypeOfVisitVisits")
	public ModelAndView confirmDeleteTypeOfVisitVisits(@RequestParam Integer typeofvisit_id, @RequestParam Integer related_visits_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visit", visitDAO.findVisitByPrimaryKey(related_visits_id));
		mav.addObject("typeofvisit_id", typeofvisit_id);
		mav.setViewName("typeofvisit/visits/deleteVisits.jsp");

		return mav;
	}

	/**
	 * Show all TypeOfVisit entities
	 * 
	 */
	@RequestMapping("/indexTypeOfVisit")
	public ModelAndView listTypeOfVisits() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("typeofvisits", typeOfVisitService.loadTypeOfVisits());

		mav.setViewName("typeofvisit/listTypeOfVisits.jsp");

		return mav;
	}

	/**
	 * Select the TypeOfVisit entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTypeOfVisit")
	public ModelAndView confirmDeleteTypeOfVisit(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("typeofvisit", typeOfVisitDAO.findTypeOfVisitByPrimaryKey(idKey));
		mav.setViewName("typeofvisit/deleteTypeOfVisit.jsp");

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
	 * Entry point to show all TypeOfVisit entities
	 * 
	 */
	public String indexTypeOfVisit() {
		return "redirect:/indexTypeOfVisit";
	}

	/**
	 * Create a new Visit entity
	 * 
	 */
	@RequestMapping("/newTypeOfVisitVisits")
	public ModelAndView newTypeOfVisitVisits(@RequestParam Integer typeofvisit_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("typeofvisit_id", typeofvisit_id);
		mav.addObject("visit", new Visit());
		mav.addObject("newFlag", true);
		mav.setViewName("typeofvisit/visits/editVisits.jsp");

		return mav;
	}

	/**
	 * Select an existing TypeOfVisit entity
	 * 
	 */
	@RequestMapping("/selectTypeOfVisit")
	public ModelAndView selectTypeOfVisit(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("typeofvisit", typeOfVisitDAO.findTypeOfVisitByPrimaryKey(idKey));
		mav.setViewName("typeofvisit/viewTypeOfVisit.jsp");

		return mav;
	}

	/**
	 * Edit an existing Visit entity
	 * 
	 */
	@RequestMapping("/editTypeOfVisitVisits")
	public ModelAndView editTypeOfVisitVisits(@RequestParam Integer typeofvisit_id, @RequestParam Integer visits_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(visits_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("typeofvisit_id", typeofvisit_id);
		mav.addObject("visit", visit);
		mav.setViewName("typeofvisit/visits/editVisits.jsp");

		return mav;
	}
}