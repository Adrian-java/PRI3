package com.eclinic.web;

import com.eclinic.dao.LoginHistoryDAO;
import com.eclinic.dao.WorkerDAO;

import com.eclinic.domain.LoginHistory;
import com.eclinic.domain.Worker;

import com.eclinic.service.LoginHistoryService;

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
 * Spring MVC controller that handles CRUD requests for LoginHistory entities
 * 
 */

@Controller("LoginHistoryController")
public class LoginHistoryController {

	/**
	 * DAO injected by Spring that manages LoginHistory entities
	 * 
	 */
	@Autowired
	private LoginHistoryDAO loginHistoryDAO;

	/**
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for LoginHistory entities
	 * 
	 */
	@Autowired
	private LoginHistoryService loginHistoryService;

	/**
	 * Show all Worker entities by LoginHistory
	 * 
	 */
	@RequestMapping("/listLoginHistoryWorker")
	public ModelAndView listLoginHistoryWorker(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("loginhistory", loginHistoryDAO.findLoginHistoryByPrimaryKey(idKey));
		mav.setViewName("loginhistory/worker/listWorker.jsp");

		return mav;
	}

	/**
	 * Select an existing LoginHistory entity
	 * 
	 */
	@RequestMapping("/selectLoginHistory")
	public ModelAndView selectLoginHistory(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("loginhistory", loginHistoryDAO.findLoginHistoryByPrimaryKey(idKey));
		mav.setViewName("loginhistory/viewLoginHistory.jsp");

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
	 * Edit an existing Worker entity
	 * 
	 */
	@RequestMapping("/editLoginHistoryWorker")
	public ModelAndView editLoginHistoryWorker(@RequestParam Integer loginhistory_id, @RequestParam Integer worker_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(worker_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("loginhistory_id", loginhistory_id);
		mav.addObject("worker", worker);
		mav.setViewName("loginhistory/worker/editWorker.jsp");

		return mav;
	}

	/**
	 * Show all LoginHistory entities
	 * 
	 */
	@RequestMapping("/indexLoginHistory")
	public ModelAndView listLoginHistorys() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("loginhistorys", loginHistoryService.loadLoginHistorys());

		mav.setViewName("loginhistory/listLoginHistorys.jsp");

		return mav;
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */
	@RequestMapping("/saveLoginHistoryWorker")
	public ModelAndView saveLoginHistoryWorker(@RequestParam Integer loginhistory_id, @ModelAttribute Worker worker) {
		LoginHistory parent_loginhistory = loginHistoryService.saveLoginHistoryWorker(loginhistory_id, worker);

		ModelAndView mav = new ModelAndView();
		mav.addObject("loginhistory_id", loginhistory_id);
		mav.addObject("loginhistory", parent_loginhistory);
		mav.setViewName("loginhistory/viewLoginHistory.jsp");

		return mav;
	}

	/**
	 * Edit an existing LoginHistory entity
	 * 
	 */
	@RequestMapping("/editLoginHistory")
	public ModelAndView editLoginHistory(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("loginhistory", loginHistoryDAO.findLoginHistoryByPrimaryKey(idKey));
		mav.setViewName("loginhistory/editLoginHistory.jsp");

		return mav;
	}

	/**
	 * Delete an existing LoginHistory entity
	 * 
	 */
	@RequestMapping("/deleteLoginHistory")
	public String deleteLoginHistory(@RequestParam Integer idKey) {
		LoginHistory loginhistory = loginHistoryDAO.findLoginHistoryByPrimaryKey(idKey);
		loginHistoryService.deleteLoginHistory(loginhistory);
		return "forward:/indexLoginHistory";
	}

	/**
	 */
	@RequestMapping("/loginhistoryController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Create a new LoginHistory entity
	 * 
	 */
	@RequestMapping("/newLoginHistory")
	public ModelAndView newLoginHistory() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("loginhistory", new LoginHistory());
		mav.addObject("newFlag", true);
		mav.setViewName("loginhistory/editLoginHistory.jsp");

		return mav;
	}

	/**
	 * Select the child Worker entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteLoginHistoryWorker")
	public ModelAndView confirmDeleteLoginHistoryWorker(@RequestParam Integer loginhistory_id, @RequestParam Integer related_worker_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("worker", workerDAO.findWorkerByPrimaryKey(related_worker_id));
		mav.addObject("loginhistory_id", loginhistory_id);
		mav.setViewName("loginhistory/worker/deleteWorker.jsp");

		return mav;
	}

	/**
	 * Entry point to show all LoginHistory entities
	 * 
	 */
	public String indexLoginHistory() {
		return "redirect:/indexLoginHistory";
	}

	/**
	 * Save an existing LoginHistory entity
	 * 
	 */
	@RequestMapping("/saveLoginHistory")
	public String saveLoginHistory(@ModelAttribute LoginHistory loginhistory) {
		loginHistoryService.saveLoginHistory(loginhistory);
		return "forward:/indexLoginHistory";
	}

	/**
	 * Create a new Worker entity
	 * 
	 */
	@RequestMapping("/newLoginHistoryWorker")
	public ModelAndView newLoginHistoryWorker(@RequestParam Integer loginhistory_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("loginhistory_id", loginhistory_id);
		mav.addObject("worker", new Worker());
		mav.addObject("newFlag", true);
		mav.setViewName("loginhistory/worker/editWorker.jsp");

		return mav;
	}

	/**
	 * Select the LoginHistory entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteLoginHistory")
	public ModelAndView confirmDeleteLoginHistory(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("loginhistory", loginHistoryDAO.findLoginHistoryByPrimaryKey(idKey));
		mav.setViewName("loginhistory/deleteLoginHistory.jsp");

		return mav;
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	@RequestMapping("/deleteLoginHistoryWorker")
	public ModelAndView deleteLoginHistoryWorker(@RequestParam Integer loginhistory_id, @RequestParam Integer related_worker_id) {
		ModelAndView mav = new ModelAndView();

		LoginHistory loginhistory = loginHistoryService.deleteLoginHistoryWorker(loginhistory_id, related_worker_id);

		mav.addObject("loginhistory_id", loginhistory_id);
		mav.addObject("loginhistory", loginhistory);
		mav.setViewName("loginhistory/viewLoginHistory.jsp");

		return mav;
	}

	/**
	 * View an existing Worker entity
	 * 
	 */
	@RequestMapping("/selectLoginHistoryWorker")
	public ModelAndView selectLoginHistoryWorker(@RequestParam Integer loginhistory_id, @RequestParam Integer worker_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(worker_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("loginhistory_id", loginhistory_id);
		mav.addObject("worker", worker);
		mav.setViewName("loginhistory/worker/viewWorker.jsp");

		return mav;
	}
}