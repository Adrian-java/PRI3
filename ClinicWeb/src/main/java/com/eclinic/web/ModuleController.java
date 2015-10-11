package com.eclinic.web;

import com.eclinic.dao.ModuleDAO;
import com.eclinic.dao.PermissionDAO;

import com.eclinic.domain.Module;
import com.eclinic.domain.Permission;

import com.eclinic.service.ModuleService;

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
 * Spring MVC controller that handles CRUD requests for Module entities
 * 
 */

@Controller("ModuleController")
public class ModuleController {

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
	 * Service injected by Spring that provides CRUD operations for Module entities
	 * 
	 */
	@Autowired
	private ModuleService moduleService;

	/**
	 * Edit an existing Permission entity
	 * 
	 */
	@RequestMapping("/editModulePermissions")
	public ModelAndView editModulePermissions(@RequestParam Integer module_id, @RequestParam Integer permissions_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(permissions_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("module_id", module_id);
		mav.addObject("permission", permission);
		mav.setViewName("module/permissions/editPermissions.jsp");

		return mav;
	}

	/**
	 * Select an existing Module entity
	 * 
	 */
	@RequestMapping("/selectModule")
	public ModelAndView selectModule(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("module", moduleDAO.findModuleByPrimaryKey(idKey));
		mav.setViewName("module/viewModule.jsp");

		return mav;
	}

	/**
	 * Select the child Permission entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteModulePermissions")
	public ModelAndView confirmDeleteModulePermissions(@RequestParam Integer module_id, @RequestParam Integer related_permissions_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("permission", permissionDAO.findPermissionByPrimaryKey(related_permissions_id));
		mav.addObject("module_id", module_id);
		mav.setViewName("module/permissions/deletePermissions.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Module entities
	 * 
	 */
	public String indexModule() {
		return "redirect:/indexModule";
	}

	/**
	 * Show all Module entities
	 * 
	 */
	@RequestMapping("/indexModule")
	public ModelAndView listModules() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("modules", moduleService.loadModules());

		mav.setViewName("module/listModules.jsp");

		return mav;
	}

	/**
	 * View an existing Permission entity
	 * 
	 */
	@RequestMapping("/selectModulePermissions")
	public ModelAndView selectModulePermissions(@RequestParam Integer module_id, @RequestParam Integer permissions_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(permissions_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("module_id", module_id);
		mav.addObject("permission", permission);
		mav.setViewName("module/permissions/viewPermissions.jsp");

		return mav;
	}

	/**
	 * Show all Permission entities by Module
	 * 
	 */
	@RequestMapping("/listModulePermissions")
	public ModelAndView listModulePermissions(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("module", moduleDAO.findModuleByPrimaryKey(idKey));
		mav.setViewName("module/permissions/listPermissions.jsp");

		return mav;
	}

	/**
	 * Edit an existing Module entity
	 * 
	 */
	@RequestMapping("/editModule")
	public ModelAndView editModule(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("module", moduleDAO.findModuleByPrimaryKey(idKey));
		mav.setViewName("module/editModule.jsp");

		return mav;
	}

	/**
	 * Create a new Module entity
	 * 
	 */
	@RequestMapping("/newModule")
	public ModelAndView newModule() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("module", new Module());
		mav.addObject("newFlag", true);
		mav.setViewName("module/editModule.jsp");

		return mav;
	}

	/**
	 * Select the Module entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteModule")
	public ModelAndView confirmDeleteModule(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("module", moduleDAO.findModuleByPrimaryKey(idKey));
		mav.setViewName("module/deleteModule.jsp");

		return mav;
	}

	/**
	 * Save an existing Permission entity
	 * 
	 */
	@RequestMapping("/saveModulePermissions")
	public ModelAndView saveModulePermissions(@RequestParam Integer module_id, @ModelAttribute Permission permissions) {
		Module parent_module = moduleService.saveModulePermissions(module_id, permissions);

		ModelAndView mav = new ModelAndView();
		mav.addObject("module_id", module_id);
		mav.addObject("module", parent_module);
		mav.setViewName("module/viewModule.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/moduleController/binary.action")
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
	 * Delete an existing Permission entity
	 * 
	 */
	@RequestMapping("/deleteModulePermissions")
	public ModelAndView deleteModulePermissions(@RequestParam Integer module_id, @RequestParam Integer related_permissions_id) {
		ModelAndView mav = new ModelAndView();

		Module module = moduleService.deleteModulePermissions(module_id, related_permissions_id);

		mav.addObject("module_id", module_id);
		mav.addObject("module", module);
		mav.setViewName("module/viewModule.jsp");

		return mav;
	}

	/**
	 * Delete an existing Module entity
	 * 
	 */
	@RequestMapping("/deleteModule")
	public String deleteModule(@RequestParam Integer idKey) {
		Module module = moduleDAO.findModuleByPrimaryKey(idKey);
		moduleService.deleteModule(module);
		return "forward:/indexModule";
	}

	/**
	 * Create a new Permission entity
	 * 
	 */
	@RequestMapping("/newModulePermissions")
	public ModelAndView newModulePermissions(@RequestParam Integer module_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("module_id", module_id);
		mav.addObject("permission", new Permission());
		mav.addObject("newFlag", true);
		mav.setViewName("module/permissions/editPermissions.jsp");

		return mav;
	}

	/**
	 * Save an existing Module entity
	 * 
	 */
	@RequestMapping("/saveModule")
	public String saveModule(@ModelAttribute Module module) {
		moduleService.saveModule(module);
		return "forward:/indexModule";
	}
}