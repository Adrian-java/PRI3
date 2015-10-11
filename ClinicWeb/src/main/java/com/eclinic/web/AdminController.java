package com.eclinic.web;

import com.eclinic.dao.AdminDAO;
import com.eclinic.dao.WorkerDAO;

import com.eclinic.domain.Admin;
import com.eclinic.domain.Worker;

import com.eclinic.service.AdminService;

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
 * Spring MVC controller that handles CRUD requests for Admin entities
 * 
 */

@Controller("AdminController")
public class AdminController {

	/**
	 * DAO injected by Spring that manages Admin entities
	 * 
	 */
	@Autowired
	private AdminDAO adminDAO;

	/**
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Admin entities
	 * 
	 */
	@Autowired
	private AdminService adminService;

	/**
	 * Edit an existing Worker entity
	 * 
	 */
	@RequestMapping("/editAdminWorkers")
	public ModelAndView editAdminWorkers(@RequestParam Integer admin_id, @RequestParam Integer workers_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(workers_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("admin_id", admin_id);
		mav.addObject("worker", worker);
		mav.setViewName("admin/workers/editWorkers.jsp");

		return mav;
	}

	/**
	 * Delete an existing Admin entity
	 * 
	 */
	@RequestMapping("/deleteAdmin")
	public String deleteAdmin(@RequestParam Integer idKey) {
		Admin admin = adminDAO.findAdminByPrimaryKey(idKey);
		adminService.deleteAdmin(admin);
		return "forward:/indexAdmin";
	}

	/**
	 * Create a new Admin entity
	 * 
	 */
	@RequestMapping("/newAdmin")
	public ModelAndView newAdmin() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("admin", new Admin());
		mav.addObject("newFlag", true);
		mav.setViewName("admin/editAdmin.jsp");

		return mav;
	}

	/**
	 * Create a new Worker entity
	 * 
	 */
	@RequestMapping("/newAdminWorkers")
	public ModelAndView newAdminWorkers(@RequestParam Integer admin_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("admin_id", admin_id);
		mav.addObject("worker", new Worker());
		mav.addObject("newFlag", true);
		mav.setViewName("admin/workers/editWorkers.jsp");

		return mav;
	}

	/**
	 * Show all Worker entities by Admin
	 * 
	 */
	@RequestMapping("/listAdminWorkers")
	public ModelAndView listAdminWorkers(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("admin", adminDAO.findAdminByPrimaryKey(idKey));
		mav.setViewName("admin/workers/listWorkers.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/adminController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	@RequestMapping("/deleteAdminWorkers")
	public ModelAndView deleteAdminWorkers(@RequestParam Integer admin_id, @RequestParam Integer related_workers_id) {
		ModelAndView mav = new ModelAndView();

		Admin admin = adminService.deleteAdminWorkers(admin_id, related_workers_id);

		mav.addObject("admin_id", admin_id);
		mav.addObject("admin", admin);
		mav.setViewName("admin/viewAdmin.jsp");

		return mav;
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */
	@RequestMapping("/saveAdminWorkers")
	public ModelAndView saveAdminWorkers(@RequestParam Integer admin_id, @ModelAttribute Worker workers) {
		Admin parent_admin = adminService.saveAdminWorkers(admin_id, workers);

		ModelAndView mav = new ModelAndView();
		mav.addObject("admin_id", admin_id);
		mav.addObject("admin", parent_admin);
		mav.setViewName("admin/viewAdmin.jsp");

		return mav;
	}

	/**
	 * View an existing Worker entity
	 * 
	 */
	@RequestMapping("/selectAdminWorkers")
	public ModelAndView selectAdminWorkers(@RequestParam Integer admin_id, @RequestParam Integer workers_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(workers_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("admin_id", admin_id);
		mav.addObject("worker", worker);
		mav.setViewName("admin/workers/viewWorkers.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Admin entities
	 * 
	 */
	public String indexAdmin() {
		return "redirect:/indexAdmin";
	}

	/**
	 * Edit an existing Admin entity
	 * 
	 */
	@RequestMapping("/editAdmin")
	public ModelAndView editAdmin(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("admin", adminDAO.findAdminByPrimaryKey(idKey));
		mav.setViewName("admin/editAdmin.jsp");

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
	 * Save an existing Admin entity
	 * 
	 */
	@RequestMapping("/saveAdmin")
	public String saveAdmin(@ModelAttribute Admin admin) {
		adminService.saveAdmin(admin);
		return "forward:/indexAdmin";
	}

	/**
	 * Select an existing Admin entity
	 * 
	 */
	@RequestMapping("/selectAdmin")
	public ModelAndView selectAdmin(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("admin", adminDAO.findAdminByPrimaryKey(idKey));
		mav.setViewName("admin/viewAdmin.jsp");

		return mav;
	}

	/**
	 * Select the child Worker entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteAdminWorkers")
	public ModelAndView confirmDeleteAdminWorkers(@RequestParam Integer admin_id, @RequestParam Integer related_workers_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("worker", workerDAO.findWorkerByPrimaryKey(related_workers_id));
		mav.addObject("admin_id", admin_id);
		mav.setViewName("admin/workers/deleteWorkers.jsp");

		return mav;
	}

	/**
	 * Select the Admin entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteAdmin")
	public ModelAndView confirmDeleteAdmin(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("admin", adminDAO.findAdminByPrimaryKey(idKey));
		mav.setViewName("admin/deleteAdmin.jsp");

		return mav;
	}

	/**
	 * Show all Admin entities
	 * 
	 */
	@RequestMapping("/indexAdmin")
	public ModelAndView listAdmins() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("admins", adminService.loadAdmins());

		mav.setViewName("admin/listAdmins.jsp");

		return mav;
	}
}