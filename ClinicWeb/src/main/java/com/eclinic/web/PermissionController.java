package com.eclinic.web;

import com.eclinic.dao.ModuleDAO;
import com.eclinic.dao.PermissionDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.dao.TypeOfUserDAO;

import com.eclinic.domain.Module;
import com.eclinic.domain.Permission;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.TypeOfUser;

import com.eclinic.service.PermissionService;

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
 * Spring MVC controller that handles CRUD requests for Permission entities
 * 
 */

@Controller("PermissionController")
public class PermissionController {

	/**
	 * DAO injected by Spring that manages Module entities
	 * 
	 */
	@Autowired
	private ModuleDAO moduleDAO;

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
	 * DAO injected by Spring that manages TypeOfUser entities
	 * 
	 */
	@Autowired
	private TypeOfUserDAO typeOfUserDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Permission entities
	 * 
	 */
	@Autowired
	private PermissionService permissionService;

	/**
	 * Edit an existing Module entity
	 * 
	 */
	@RequestMapping("/editPermissionModule")
	public ModelAndView editPermissionModule(@RequestParam Integer permission_id, @RequestParam Integer module_id) {
		Module module = moduleDAO.findModuleByPrimaryKey(module_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("permission_id", permission_id);
		mav.addObject("module", module);
		mav.setViewName("permission/module/editModule.jsp");

		return mav;
	}

	/**
	 * Edit an existing SystemUser entity
	 * 
	 */
	@RequestMapping("/editPermissionSystemUser")
	public ModelAndView editPermissionSystemUser(@RequestParam Integer permission_id, @RequestParam Integer systemuser_id) {
		SystemUser systemuser = systemUserDAO.findSystemUserByPrimaryKey(systemuser_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("permission_id", permission_id);
		mav.addObject("systemuser", systemuser);
		mav.setViewName("permission/systemuser/editSystemUser.jsp");

		return mav;
	}

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	@RequestMapping("/deletePermissionSystemUser")
	public ModelAndView deletePermissionSystemUser(@RequestParam Integer permission_id, @RequestParam Integer related_systemuser_id) {
		ModelAndView mav = new ModelAndView();

		Permission permission = permissionService.deletePermissionSystemUser(permission_id, related_systemuser_id);

		mav.addObject("permission_id", permission_id);
		mav.addObject("permission", permission);
		mav.setViewName("permission/viewPermission.jsp");

		return mav;
	}

	/**
	 * Create a new SystemUser entity
	 * 
	 */
	@RequestMapping("/newPermissionSystemUser")
	public ModelAndView newPermissionSystemUser(@RequestParam Integer permission_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("permission_id", permission_id);
		mav.addObject("systemuser", new SystemUser());
		mav.addObject("newFlag", true);
		mav.setViewName("permission/systemuser/editSystemUser.jsp");

		return mav;
	}

	/**
	 * Create a new TypeOfUser entity
	 * 
	 */
	@RequestMapping("/newPermissionTypeOfUsers")
	public ModelAndView newPermissionTypeOfUsers(@RequestParam Integer permission_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("permission_id", permission_id);
		mav.addObject("typeofuser", new TypeOfUser());
		mav.addObject("newFlag", true);
		mav.setViewName("permission/typeofusers/editTypeOfUsers.jsp");

		return mav;
	}

	/**
	 * Save an existing Permission entity
	 * 
	 */
	@RequestMapping("/savePermission")
	public String savePermission(@ModelAttribute Permission permission) {
		permissionService.savePermission(permission);
		return "forward:/indexPermission";
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
	 * Edit an existing TypeOfUser entity
	 * 
	 */
	@RequestMapping("/editPermissionTypeOfUsers")
	public ModelAndView editPermissionTypeOfUsers(@RequestParam Integer permission_id, @RequestParam Integer typeofusers_id) {
		TypeOfUser typeofuser = typeOfUserDAO.findTypeOfUserByPrimaryKey(typeofusers_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("permission_id", permission_id);
		mav.addObject("typeofuser", typeofuser);
		mav.setViewName("permission/typeofusers/editTypeOfUsers.jsp");

		return mav;
	}

	/**
	 * Show all Permission entities
	 * 
	 */
	@RequestMapping("/indexPermission")
	public ModelAndView listPermissions() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("permissions", permissionService.loadPermissions());

		mav.setViewName("permission/listPermissions.jsp");

		return mav;
	}

	/**
	 * Create a new Module entity
	 * 
	 */
	@RequestMapping("/newPermissionModule")
	public ModelAndView newPermissionModule(@RequestParam Integer permission_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("permission_id", permission_id);
		mav.addObject("module", new Module());
		mav.addObject("newFlag", true);
		mav.setViewName("permission/module/editModule.jsp");

		return mav;
	}

	/**
	 * Select the child TypeOfUser entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePermissionTypeOfUsers")
	public ModelAndView confirmDeletePermissionTypeOfUsers(@RequestParam Integer permission_id, @RequestParam Integer related_typeofusers_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("typeofuser", typeOfUserDAO.findTypeOfUserByPrimaryKey(related_typeofusers_id));
		mav.addObject("permission_id", permission_id);
		mav.setViewName("permission/typeofusers/deleteTypeOfUsers.jsp");

		return mav;
	}

	/**
	 * Save an existing TypeOfUser entity
	 * 
	 */
	@RequestMapping("/savePermissionTypeOfUsers")
	public ModelAndView savePermissionTypeOfUsers(@RequestParam Integer permission_id, @ModelAttribute TypeOfUser typeofusers) {
		Permission parent_permission = permissionService.savePermissionTypeOfUsers(permission_id, typeofusers);

		ModelAndView mav = new ModelAndView();
		mav.addObject("permission_id", permission_id);
		mav.addObject("permission", parent_permission);
		mav.setViewName("permission/viewPermission.jsp");

		return mav;
	}

	/**
	 * View an existing TypeOfUser entity
	 * 
	 */
	@RequestMapping("/selectPermissionTypeOfUsers")
	public ModelAndView selectPermissionTypeOfUsers(@RequestParam Integer permission_id, @RequestParam Integer typeofusers_id) {
		TypeOfUser typeofuser = typeOfUserDAO.findTypeOfUserByPrimaryKey(typeofusers_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("permission_id", permission_id);
		mav.addObject("typeofuser", typeofuser);
		mav.setViewName("permission/typeofusers/viewTypeOfUsers.jsp");

		return mav;
	}

	/**
	 * Delete an existing TypeOfUser entity
	 * 
	 */
	@RequestMapping("/deletePermissionTypeOfUsers")
	public ModelAndView deletePermissionTypeOfUsers(@RequestParam Integer permission_id, @RequestParam Integer related_typeofusers_id) {
		ModelAndView mav = new ModelAndView();

		Permission permission = permissionService.deletePermissionTypeOfUsers(permission_id, related_typeofusers_id);

		mav.addObject("permission_id", permission_id);
		mav.addObject("permission", permission);
		mav.setViewName("permission/viewPermission.jsp");

		return mav;
	}

	/**
	 * Show all Module entities by Permission
	 * 
	 */
	@RequestMapping("/listPermissionModule")
	public ModelAndView listPermissionModule(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("permission", permissionDAO.findPermissionByPrimaryKey(idKey));
		mav.setViewName("permission/module/listModule.jsp");

		return mav;
	}

	/**
	 * Edit an existing Permission entity
	 * 
	 */
	@RequestMapping("/editPermission")
	public ModelAndView editPermission(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("permission", permissionDAO.findPermissionByPrimaryKey(idKey));
		mav.setViewName("permission/editPermission.jsp");

		return mav;
	}

	/**
	 * Save an existing Module entity
	 * 
	 */
	@RequestMapping("/savePermissionModule")
	public ModelAndView savePermissionModule(@RequestParam Integer permission_id, @ModelAttribute Module module) {
		Permission parent_permission = permissionService.savePermissionModule(permission_id, module);

		ModelAndView mav = new ModelAndView();
		mav.addObject("permission_id", permission_id);
		mav.addObject("permission", parent_permission);
		mav.setViewName("permission/viewPermission.jsp");

		return mav;
	}

	/**
	 * Select an existing Permission entity
	 * 
	 */
	@RequestMapping("/selectPermission")
	public ModelAndView selectPermission(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("permission", permissionDAO.findPermissionByPrimaryKey(idKey));
		mav.setViewName("permission/viewPermission.jsp");

		return mav;
	}

	/**
	 * View an existing Module entity
	 * 
	 */
	@RequestMapping("/selectPermissionModule")
	public ModelAndView selectPermissionModule(@RequestParam Integer permission_id, @RequestParam Integer module_id) {
		Module module = moduleDAO.findModuleByPrimaryKey(module_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("permission_id", permission_id);
		mav.addObject("module", module);
		mav.setViewName("permission/module/viewModule.jsp");

		return mav;
	}

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	@RequestMapping("/deletePermission")
	public String deletePermission(@RequestParam Integer idKey) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(idKey);
		permissionService.deletePermission(permission);
		return "forward:/indexPermission";
	}

	/**
	 * Select the child SystemUser entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePermissionSystemUser")
	public ModelAndView confirmDeletePermissionSystemUser(@RequestParam Integer permission_id, @RequestParam Integer related_systemuser_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("systemuser", systemUserDAO.findSystemUserByPrimaryKey(related_systemuser_id));
		mav.addObject("permission_id", permission_id);
		mav.setViewName("permission/systemuser/deleteSystemUser.jsp");

		return mav;
	}

	/**
	 * Show all TypeOfUser entities by Permission
	 * 
	 */
	@RequestMapping("/listPermissionTypeOfUsers")
	public ModelAndView listPermissionTypeOfUsers(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("permission", permissionDAO.findPermissionByPrimaryKey(idKey));
		mav.setViewName("permission/typeofusers/listTypeOfUsers.jsp");

		return mav;
	}

	/**
	 * View an existing SystemUser entity
	 * 
	 */
	@RequestMapping("/selectPermissionSystemUser")
	public ModelAndView selectPermissionSystemUser(@RequestParam Integer permission_id, @RequestParam Integer systemuser_id) {
		SystemUser systemuser = systemUserDAO.findSystemUserByPrimaryKey(systemuser_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("permission_id", permission_id);
		mav.addObject("systemuser", systemuser);
		mav.setViewName("permission/systemuser/viewSystemUser.jsp");

		return mav;
	}

	/**
	 * Select the Permission entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePermission")
	public ModelAndView confirmDeletePermission(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("permission", permissionDAO.findPermissionByPrimaryKey(idKey));
		mav.setViewName("permission/deletePermission.jsp");

		return mav;
	}

	/**
	 * Select the child Module entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePermissionModule")
	public ModelAndView confirmDeletePermissionModule(@RequestParam Integer permission_id, @RequestParam Integer related_module_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("module", moduleDAO.findModuleByPrimaryKey(related_module_id));
		mav.addObject("permission_id", permission_id);
		mav.setViewName("permission/module/deleteModule.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/permissionController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Create a new Permission entity
	 * 
	 */
	@RequestMapping("/newPermission")
	public ModelAndView newPermission() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("permission", new Permission());
		mav.addObject("newFlag", true);
		mav.setViewName("permission/editPermission.jsp");

		return mav;
	}

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	@RequestMapping("/savePermissionSystemUser")
	public ModelAndView savePermissionSystemUser(@RequestParam Integer permission_id, @ModelAttribute SystemUser systemuser) {
		Permission parent_permission = permissionService.savePermissionSystemUser(permission_id, systemuser);

		ModelAndView mav = new ModelAndView();
		mav.addObject("permission_id", permission_id);
		mav.addObject("permission", parent_permission);
		mav.setViewName("permission/viewPermission.jsp");

		return mav;
	}

	/**
	 * Delete an existing Module entity
	 * 
	 */
	@RequestMapping("/deletePermissionModule")
	public ModelAndView deletePermissionModule(@RequestParam Integer permission_id, @RequestParam Integer related_module_id) {
		ModelAndView mav = new ModelAndView();

		Permission permission = permissionService.deletePermissionModule(permission_id, related_module_id);

		mav.addObject("permission_id", permission_id);
		mav.addObject("permission", permission);
		mav.setViewName("permission/viewPermission.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Permission entities
	 * 
	 */
	public String indexPermission() {
		return "redirect:/indexPermission";
	}

	/**
	 * Show all SystemUser entities by Permission
	 * 
	 */
	@RequestMapping("/listPermissionSystemUser")
	public ModelAndView listPermissionSystemUser(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("permission", permissionDAO.findPermissionByPrimaryKey(idKey));
		mav.setViewName("permission/systemuser/listSystemUser.jsp");

		return mav;
	}
}