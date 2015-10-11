package com.eclinic.web;

import com.eclinic.dao.ReceptionistDAO;
import com.eclinic.dao.VisitDAO;
import com.eclinic.dao.WorkerDAO;

import com.eclinic.domain.Receptionist;
import com.eclinic.domain.Visit;
import com.eclinic.domain.Worker;

import com.eclinic.service.ReceptionistService;

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
 * Spring MVC controller that handles CRUD requests for Receptionist entities
 * 
 */

@Controller("ReceptionistController")
public class ReceptionistController {

	/**
	 * DAO injected by Spring that manages Receptionist entities
	 * 
	 */
	@Autowired
	private ReceptionistDAO receptionistDAO;

	/**
	 * DAO injected by Spring that manages Visit entities
	 * 
	 */
	@Autowired
	private VisitDAO visitDAO;

	/**
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Receptionist entities
	 * 
	 */
	@Autowired
	private ReceptionistService receptionistService;

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	@RequestMapping("/deleteReceptionistWorkers")
	public ModelAndView deleteReceptionistWorkers(@RequestParam Integer receptionist_id, @RequestParam Integer related_workers_id) {
		ModelAndView mav = new ModelAndView();

		Receptionist receptionist = receptionistService.deleteReceptionistWorkers(receptionist_id, related_workers_id);

		mav.addObject("receptionist_id", receptionist_id);
		mav.addObject("receptionist", receptionist);
		mav.setViewName("receptionist/viewReceptionist.jsp");

		return mav;
	}

	/**
	 * Select the child Worker entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteReceptionistWorkers")
	public ModelAndView confirmDeleteReceptionistWorkers(@RequestParam Integer receptionist_id, @RequestParam Integer related_workers_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("worker", workerDAO.findWorkerByPrimaryKey(related_workers_id));
		mav.addObject("receptionist_id", receptionist_id);
		mav.setViewName("receptionist/workers/deleteWorkers.jsp");

		return mav;
	}

	/**
	 * Show all Receptionist entities
	 * 
	 */
	@RequestMapping("/indexReceptionist")
	public ModelAndView listReceptionists() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("receptionists", receptionistService.loadReceptionists());

		mav.setViewName("receptionist/listReceptionists.jsp");

		return mav;
	}

	/**
	 * Edit an existing Visit entity
	 * 
	 */
	@RequestMapping("/editReceptionistVisits")
	public ModelAndView editReceptionistVisits(@RequestParam Integer receptionist_id, @RequestParam Integer visits_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(visits_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("receptionist_id", receptionist_id);
		mav.addObject("visit", visit);
		mav.setViewName("receptionist/visits/editVisits.jsp");

		return mav;
	}

	/**
	 * Show all Visit entities by Receptionist
	 * 
	 */
	@RequestMapping("/listReceptionistVisits")
	public ModelAndView listReceptionistVisits(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("receptionist", receptionistDAO.findReceptionistByPrimaryKey(idKey));
		mav.setViewName("receptionist/visits/listVisits.jsp");

		return mav;
	}

	/**
	 * Create a new Visit entity
	 * 
	 */
	@RequestMapping("/newReceptionistVisits")
	public ModelAndView newReceptionistVisits(@RequestParam Integer receptionist_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("receptionist_id", receptionist_id);
		mav.addObject("visit", new Visit());
		mav.addObject("newFlag", true);
		mav.setViewName("receptionist/visits/editVisits.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Receptionist entities
	 * 
	 */
	public String indexReceptionist() {
		return "redirect:/indexReceptionist";
	}

	/**
	 * Delete an existing Receptionist entity
	 * 
	 */
	@RequestMapping("/deleteReceptionist")
	public String deleteReceptionist(@RequestParam Integer idKey) {
		Receptionist receptionist = receptionistDAO.findReceptionistByPrimaryKey(idKey);
		receptionistService.deleteReceptionist(receptionist);
		return "forward:/indexReceptionist";
	}

	/**
	 * Select the child Visit entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteReceptionistVisits")
	public ModelAndView confirmDeleteReceptionistVisits(@RequestParam Integer receptionist_id, @RequestParam Integer related_visits_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visit", visitDAO.findVisitByPrimaryKey(related_visits_id));
		mav.addObject("receptionist_id", receptionist_id);
		mav.setViewName("receptionist/visits/deleteVisits.jsp");

		return mav;
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */
	@RequestMapping("/saveReceptionistWorkers")
	public ModelAndView saveReceptionistWorkers(@RequestParam Integer receptionist_id, @ModelAttribute Worker workers) {
		Receptionist parent_receptionist = receptionistService.saveReceptionistWorkers(receptionist_id, workers);

		ModelAndView mav = new ModelAndView();
		mav.addObject("receptionist_id", receptionist_id);
		mav.addObject("receptionist", parent_receptionist);
		mav.setViewName("receptionist/viewReceptionist.jsp");

		return mav;
	}

	/**
	 * Select the Receptionist entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteReceptionist")
	public ModelAndView confirmDeleteReceptionist(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("receptionist", receptionistDAO.findReceptionistByPrimaryKey(idKey));
		mav.setViewName("receptionist/deleteReceptionist.jsp");

		return mav;
	}

	/**
	 * View an existing Visit entity
	 * 
	 */
	@RequestMapping("/selectReceptionistVisits")
	public ModelAndView selectReceptionistVisits(@RequestParam Integer receptionist_id, @RequestParam Integer visits_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(visits_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("receptionist_id", receptionist_id);
		mav.addObject("visit", visit);
		mav.setViewName("receptionist/visits/viewVisits.jsp");

		return mav;
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	@RequestMapping("/deleteReceptionistVisits")
	public ModelAndView deleteReceptionistVisits(@RequestParam Integer receptionist_id, @RequestParam Integer related_visits_id) {
		ModelAndView mav = new ModelAndView();

		Receptionist receptionist = receptionistService.deleteReceptionistVisits(receptionist_id, related_visits_id);

		mav.addObject("receptionist_id", receptionist_id);
		mav.addObject("receptionist", receptionist);
		mav.setViewName("receptionist/viewReceptionist.jsp");

		return mav;
	}

	/**
	 * Select an existing Receptionist entity
	 * 
	 */
	@RequestMapping("/selectReceptionist")
	public ModelAndView selectReceptionist(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("receptionist", receptionistDAO.findReceptionistByPrimaryKey(idKey));
		mav.setViewName("receptionist/viewReceptionist.jsp");

		return mav;
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */
	@RequestMapping("/saveReceptionistVisits")
	public ModelAndView saveReceptionistVisits(@RequestParam Integer receptionist_id, @ModelAttribute Visit visits) {
		Receptionist parent_receptionist = receptionistService.saveReceptionistVisits(receptionist_id, visits);

		ModelAndView mav = new ModelAndView();
		mav.addObject("receptionist_id", receptionist_id);
		mav.addObject("receptionist", parent_receptionist);
		mav.setViewName("receptionist/viewReceptionist.jsp");

		return mav;
	}

	/**
	 * Create a new Receptionist entity
	 * 
	 */
	@RequestMapping("/newReceptionist")
	public ModelAndView newReceptionist() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("receptionist", new Receptionist());
		mav.addObject("newFlag", true);
		mav.setViewName("receptionist/editReceptionist.jsp");

		return mav;
	}

	/**
	 * Save an existing Receptionist entity
	 * 
	 */
	@RequestMapping("/saveReceptionist")
	public String saveReceptionist(@ModelAttribute Receptionist receptionist) {
		receptionistService.saveReceptionist(receptionist);
		return "forward:/indexReceptionist";
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
	 * Edit an existing Receptionist entity
	 * 
	 */
	@RequestMapping("/editReceptionist")
	public ModelAndView editReceptionist(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("receptionist", receptionistDAO.findReceptionistByPrimaryKey(idKey));
		mav.setViewName("receptionist/editReceptionist.jsp");

		return mav;
	}

	/**
	 * Create a new Worker entity
	 * 
	 */
	@RequestMapping("/newReceptionistWorkers")
	public ModelAndView newReceptionistWorkers(@RequestParam Integer receptionist_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("receptionist_id", receptionist_id);
		mav.addObject("worker", new Worker());
		mav.addObject("newFlag", true);
		mav.setViewName("receptionist/workers/editWorkers.jsp");

		return mav;
	}

	/**
	 * Edit an existing Worker entity
	 * 
	 */
	@RequestMapping("/editReceptionistWorkers")
	public ModelAndView editReceptionistWorkers(@RequestParam Integer receptionist_id, @RequestParam Integer workers_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(workers_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("receptionist_id", receptionist_id);
		mav.addObject("worker", worker);
		mav.setViewName("receptionist/workers/editWorkers.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/receptionistController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Show all Worker entities by Receptionist
	 * 
	 */
	@RequestMapping("/listReceptionistWorkers")
	public ModelAndView listReceptionistWorkers(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("receptionist", receptionistDAO.findReceptionistByPrimaryKey(idKey));
		mav.setViewName("receptionist/workers/listWorkers.jsp");

		return mav;
	}

	/**
	 * View an existing Worker entity
	 * 
	 */
	@RequestMapping("/selectReceptionistWorkers")
	public ModelAndView selectReceptionistWorkers(@RequestParam Integer receptionist_id, @RequestParam Integer workers_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(workers_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("receptionist_id", receptionist_id);
		mav.addObject("worker", worker);
		mav.setViewName("receptionist/workers/viewWorkers.jsp");

		return mav;
	}
}