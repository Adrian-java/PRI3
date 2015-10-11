package com.eclinic.web;

import com.eclinic.dao.PermissionDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.dao.WorkerDAO;

import com.eclinic.domain.Permission;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.Worker;

import com.eclinic.service.SystemUserService;

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
 * Spring MVC controller that handles CRUD requests for SystemUser entities
 * 
 */

@Controller("SystemUserController")
public class SystemUserController {

	/**
	 * DAO injected by Spring that manages Permission entities
	 * 
	 */
	@Autowired
	private PermissionDAO permissionDAO;

	/**
	 * DAO injected by Spring that manages SystemUser entities
	 * 
	 */
	@Autowired
	private SystemUserDAO systemUserDAO;

	/**
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for SystemUser entities
	 * 
	 */
	@Autowired
	private SystemUserService systemUserService;

	/**
	 * Create a new Worker entity
	 * 
	 */
	@RequestMapping("/newSystemUserWorker")
	public ModelAndView newSystemUserWorker(@RequestParam Integer systemuser_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("systemuser_id", systemuser_id);
		mav.addObject("worker", new Worker());
		mav.addObject("newFlag", true);
		mav.setViewName("systemuser/worker/editWorker.jsp");

		return mav;
	}

	/**
	 * Entry point to show all SystemUser entities
	 * 
	 */
	public String indexSystemUser() {
		return "redirect:/indexSystemUser";
	}

	/**
	 * Edit an existing Worker entity
	 * 
	 */
	@RequestMapping("/editSystemUserWorker")
	public ModelAndView editSystemUserWorker(@RequestParam Integer systemuser_id, @RequestParam Integer worker_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(worker_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("systemuser_id", systemuser_id);
		mav.addObject("worker", worker);
		mav.setViewName("systemuser/worker/editWorker.jsp");

		return mav;
	}

	/**
	 * Edit an existing SystemUser entity
	 * 
	 */
	@RequestMapping("/editSystemUser")
	public ModelAndView editSystemUser(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("systemuser", systemUserDAO.findSystemUserByPrimaryKey(idKey));
		mav.setViewName("systemuser/editSystemUser.jsp");

		return mav;
	}

	/**
	 * Show all Worker entities by SystemUser
	 * 
	 */
	@RequestMapping("/listSystemUserWorker")
	public ModelAndView listSystemUserWorker(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("systemuser", systemUserDAO.findSystemUserByPrimaryKey(idKey));
		mav.setViewName("systemuser/worker/listWorker.jsp");

		return mav;
	}

	/**
	 * Select the child Permission entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteSystemUserPermissions")
	public ModelAndView confirmDeleteSystemUserPermissions(@RequestParam Integer systemuser_id, @RequestParam Integer related_permissions_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("permission", permissionDAO.findPermissionByPrimaryKey(related_permissions_id));
		mav.addObject("systemuser_id", systemuser_id);
		mav.setViewName("systemuser/permissions/deletePermissions.jsp");

		return mav;
	}

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	@RequestMapping("/deleteSystemUser")
	public String deleteSystemUser(@RequestParam Integer idKey) {
		SystemUser systemuser = systemUserDAO.findSystemUserByPrimaryKey(idKey);
		systemUserService.deleteSystemUser(systemuser);
		return "forward:/indexSystemUser";
	}

	/**
	 * Save an existing Permission entity
	 * 
	 */
	@RequestMapping("/saveSystemUserPermissions")
	public ModelAndView saveSystemUserPermissions(@RequestParam Integer systemuser_id, @ModelAttribute Permission permissions) {
		SystemUser parent_systemuser = systemUserService.saveSystemUserPermissions(systemuser_id, permissions);

		ModelAndView mav = new ModelAndView();
		mav.addObject("systemuser_id", systemuser_id);
		mav.addObject("systemuser", parent_systemuser);
		mav.setViewName("systemuser/viewSystemUser.jsp");

		return mav;
	}

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	@RequestMapping("/deleteSystemUserPermissions")
	public ModelAndView deleteSystemUserPermissions(@RequestParam Integer systemuser_id, @RequestParam Integer related_permissions_id) {
		ModelAndView mav = new ModelAndView();

		SystemUser systemuser = systemUserService.deleteSystemUserPermissions(systemuser_id, related_permissions_id);

		mav.addObject("systemuser_id", systemuser_id);
		mav.addObject("systemuser", systemuser);
		mav.setViewName("systemuser/viewSystemUser.jsp");

		return mav;
	}

	/**
	 * Show all Permission entities by SystemUser
	 * 
	 */
	@RequestMapping("/listSystemUserPermissions")
	public ModelAndView listSystemUserPermissions(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("systemuser", systemUserDAO.findSystemUserByPrimaryKey(idKey));
		mav.setViewName("systemuser/permissions/listPermissions.jsp");

		return mav;
	}

	/**
	 * Create a new SystemUser entity
	 * 
	 */
	@RequestMapping("/newSystemUser")
	public ModelAndView newSystemUser() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("systemuser", new SystemUser());
		mav.addObject("newFlag", true);
		mav.setViewName("systemuser/editSystemUser.jsp");

		return mav;
	}

	/**
	 * View an existing Permission entity
	 * 
	 */
	@RequestMapping("/selectSystemUserPermissions")
	public ModelAndView selectSystemUserPermissions(@RequestParam Integer systemuser_id, @RequestParam Integer permissions_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(permissions_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("systemuser_id", systemuser_id);
		mav.addObject("permission", permission);
		mav.setViewName("systemuser/permissions/viewPermissions.jsp");

		return mav;
	}

	/**
	 * Show all SystemUser entities
	 * 
	 */
	@RequestMapping("/indexSystemUser")
	public ModelAndView listSystemUsers() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("systemusers", systemUserService.loadSystemUsers());

		mav.setViewName("systemuser/listSystemUsers.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/systemuserController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
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
	 * Create a new Permission entity
	 * 
	 */
	@RequestMapping("/newSystemUserPermissions")
	public ModelAndView newSystemUserPermissions(@RequestParam Integer systemuser_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("systemuser_id", systemuser_id);
		mav.addObject("permission", new Permission());
		mav.addObject("newFlag", true);
		mav.setViewName("systemuser/permissions/editPermissions.jsp");

		return mav;
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */
	@RequestMapping("/saveSystemUserWorker")
	public ModelAndView saveSystemUserWorker(@RequestParam Integer systemuser_id, @ModelAttribute Worker worker) {
		SystemUser parent_systemuser = systemUserService.saveSystemUserWorker(systemuser_id, worker);

		ModelAndView mav = new ModelAndView();
		mav.addObject("systemuser_id", systemuser_id);
		mav.addObject("systemuser", parent_systemuser);
		mav.setViewName("systemuser/viewSystemUser.jsp");

		return mav;
	}

	/**
	 * Edit an existing Permission entity
	 * 
	 */
	@RequestMapping("/editSystemUserPermissions")
	public ModelAndView editSystemUserPermissions(@RequestParam Integer systemuser_id, @RequestParam Integer permissions_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(permissions_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("systemuser_id", systemuser_id);
		mav.addObject("permission", permission);
		mav.setViewName("systemuser/permissions/editPermissions.jsp");

		return mav;
	}

	/**
	 * Select an existing SystemUser entity
	 * 
	 */
	@RequestMapping("/selectSystemUser")
	public ModelAndView selectSystemUser(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("systemuser", systemUserDAO.findSystemUserByPrimaryKey(idKey));
		mav.setViewName("systemuser/viewSystemUser.jsp");

		return mav;
	}

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	@RequestMapping("/saveSystemUser")
	public String saveSystemUser(@ModelAttribute SystemUser systemuser) {
		systemUserService.saveSystemUser(systemuser);
		return "forward:/indexSystemUser";
	}

	/**
	 * View an existing Worker entity
	 * 
	 */
	@RequestMapping("/selectSystemUserWorker")
	public ModelAndView selectSystemUserWorker(@RequestParam Integer systemuser_id, @RequestParam Integer worker_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(worker_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("systemuser_id", systemuser_id);
		mav.addObject("worker", worker);
		mav.setViewName("systemuser/worker/viewWorker.jsp");

		return mav;
	}

	/**
	 * Select the SystemUser entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteSystemUser")
	public ModelAndView confirmDeleteSystemUser(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("systemuser", systemUserDAO.findSystemUserByPrimaryKey(idKey));
		mav.setViewName("systemuser/deleteSystemUser.jsp");

		return mav;
	}

	/**
	 * Select the child Worker entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteSystemUserWorker")
	public ModelAndView confirmDeleteSystemUserWorker(@RequestParam Integer systemuser_id, @RequestParam Integer related_worker_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("worker", workerDAO.findWorkerByPrimaryKey(related_worker_id));
		mav.addObject("systemuser_id", systemuser_id);
		mav.setViewName("systemuser/worker/deleteWorker.jsp");

		return mav;
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	@RequestMapping("/deleteSystemUserWorker")
	public ModelAndView deleteSystemUserWorker(@RequestParam Integer systemuser_id, @RequestParam Integer related_worker_id) {
		ModelAndView mav = new ModelAndView();

		SystemUser systemuser = systemUserService.deleteSystemUserWorker(systemuser_id, related_worker_id);

		mav.addObject("systemuser_id", systemuser_id);
		mav.addObject("systemuser", systemuser);
		mav.setViewName("systemuser/viewSystemUser.jsp");

		return mav;
	}
}