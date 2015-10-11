package com.eclinic.web;

import com.eclinic.dao.PermissionDAO;
import com.eclinic.dao.TypeOfUserDAO;

import com.eclinic.domain.Permission;
import com.eclinic.domain.TypeOfUser;

import com.eclinic.service.TypeOfUserService;

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
 * Spring MVC controller that handles CRUD requests for TypeOfUser entities
 * 
 */

@Controller("TypeOfUserController")
public class TypeOfUserController {

	/**
	 * DAO injected by Spring that manages Permission entities
	 * 
	 */
	@Autowired
	private PermissionDAO permissionDAO;

	/**
	 * DAO injected by Spring that manages TypeOfUser entities
	 * 
	 */
	@Autowired
	private TypeOfUserDAO typeOfUserDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for TypeOfUser entities
	 * 
	 */
	@Autowired
	private TypeOfUserService typeOfUserService;

	/**
	 * Select an existing TypeOfUser entity
	 * 
	 */
	@RequestMapping("/selectTypeOfUser")
	public ModelAndView selectTypeOfUser(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("typeofuser", typeOfUserDAO.findTypeOfUserByPrimaryKey(idKey));
		mav.setViewName("typeofuser/viewTypeOfUser.jsp");

		return mav;
	}

	/**
	 * Save an existing TypeOfUser entity
	 * 
	 */
	@RequestMapping("/saveTypeOfUser")
	public String saveTypeOfUser(@ModelAttribute TypeOfUser typeofuser) {
		typeOfUserService.saveTypeOfUser(typeofuser);
		return "forward:/indexTypeOfUser";
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
	@RequestMapping("/deleteTypeOfUserPermission")
	public ModelAndView deleteTypeOfUserPermission(@RequestParam Integer typeofuser_id, @RequestParam Integer related_permission_id) {
		ModelAndView mav = new ModelAndView();

		TypeOfUser typeofuser = typeOfUserService.deleteTypeOfUserPermission(typeofuser_id, related_permission_id);

		mav.addObject("typeofuser_id", typeofuser_id);
		mav.addObject("typeofuser", typeofuser);
		mav.setViewName("typeofuser/viewTypeOfUser.jsp");

		return mav;
	}

	/**
	 * Show all TypeOfUser entities
	 * 
	 */
	@RequestMapping("/indexTypeOfUser")
	public ModelAndView listTypeOfUsers() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("typeofusers", typeOfUserService.loadTypeOfUsers());

		mav.setViewName("typeofuser/listTypeOfUsers.jsp");

		return mav;
	}

	/**
	 * Create a new Permission entity
	 * 
	 */
	@RequestMapping("/newTypeOfUserPermission")
	public ModelAndView newTypeOfUserPermission(@RequestParam Integer typeofuser_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("typeofuser_id", typeofuser_id);
		mav.addObject("permission", new Permission());
		mav.addObject("newFlag", true);
		mav.setViewName("typeofuser/permission/editPermission.jsp");

		return mav;
	}

	/**
	 * Create a new TypeOfUser entity
	 * 
	 */
	@RequestMapping("/newTypeOfUser")
	public ModelAndView newTypeOfUser() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("typeofuser", new TypeOfUser());
		mav.addObject("newFlag", true);
		mav.setViewName("typeofuser/editTypeOfUser.jsp");

		return mav;
	}

	/**
	 * Select the TypeOfUser entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTypeOfUser")
	public ModelAndView confirmDeleteTypeOfUser(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("typeofuser", typeOfUserDAO.findTypeOfUserByPrimaryKey(idKey));
		mav.setViewName("typeofuser/deleteTypeOfUser.jsp");

		return mav;
	}

	/**
	 * Delete an existing TypeOfUser entity
	 * 
	 */
	@RequestMapping("/deleteTypeOfUser")
	public String deleteTypeOfUser(@RequestParam Integer idKey) {
		TypeOfUser typeofuser = typeOfUserDAO.findTypeOfUserByPrimaryKey(idKey);
		typeOfUserService.deleteTypeOfUser(typeofuser);
		return "forward:/indexTypeOfUser";
	}

	/**
	 * Select the child Permission entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTypeOfUserPermission")
	public ModelAndView confirmDeleteTypeOfUserPermission(@RequestParam Integer typeofuser_id, @RequestParam Integer related_permission_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("permission", permissionDAO.findPermissionByPrimaryKey(related_permission_id));
		mav.addObject("typeofuser_id", typeofuser_id);
		mav.setViewName("typeofuser/permission/deletePermission.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/typeofuserController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * View an existing Permission entity
	 * 
	 */
	@RequestMapping("/selectTypeOfUserPermission")
	public ModelAndView selectTypeOfUserPermission(@RequestParam Integer typeofuser_id, @RequestParam Integer permission_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(permission_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("typeofuser_id", typeofuser_id);
		mav.addObject("permission", permission);
		mav.setViewName("typeofuser/permission/viewPermission.jsp");

		return mav;
	}

	/**
	 * Save an existing Permission entity
	 * 
	 */
	@RequestMapping("/saveTypeOfUserPermission")
	public ModelAndView saveTypeOfUserPermission(@RequestParam Integer typeofuser_id, @ModelAttribute Permission permission) {
		TypeOfUser parent_typeofuser = typeOfUserService.saveTypeOfUserPermission(typeofuser_id, permission);

		ModelAndView mav = new ModelAndView();
		mav.addObject("typeofuser_id", typeofuser_id);
		mav.addObject("typeofuser", parent_typeofuser);
		mav.setViewName("typeofuser/viewTypeOfUser.jsp");

		return mav;
	}

	/**
	 * Edit an existing Permission entity
	 * 
	 */
	@RequestMapping("/editTypeOfUserPermission")
	public ModelAndView editTypeOfUserPermission(@RequestParam Integer typeofuser_id, @RequestParam Integer permission_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(permission_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("typeofuser_id", typeofuser_id);
		mav.addObject("permission", permission);
		mav.setViewName("typeofuser/permission/editPermission.jsp");

		return mav;
	}

	/**
	 * Edit an existing TypeOfUser entity
	 * 
	 */
	@RequestMapping("/editTypeOfUser")
	public ModelAndView editTypeOfUser(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("typeofuser", typeOfUserDAO.findTypeOfUserByPrimaryKey(idKey));
		mav.setViewName("typeofuser/editTypeOfUser.jsp");

		return mav;
	}

	/**
	 * Entry point to show all TypeOfUser entities
	 * 
	 */
	public String indexTypeOfUser() {
		return "redirect:/indexTypeOfUser";
	}

	/**
	 * Show all Permission entities by TypeOfUser
	 * 
	 */
	@RequestMapping("/listTypeOfUserPermission")
	public ModelAndView listTypeOfUserPermission(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("typeofuser", typeOfUserDAO.findTypeOfUserByPrimaryKey(idKey));
		mav.setViewName("typeofuser/permission/listPermission.jsp");

		return mav;
	}
}