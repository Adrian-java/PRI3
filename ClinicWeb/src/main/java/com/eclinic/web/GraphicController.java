package com.eclinic.web;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.GraphicDAO;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Graphic;

import com.eclinic.service.GraphicService;

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
 * Spring MVC controller that handles CRUD requests for Graphic entities
 * 
 */

@Controller("GraphicController")
public class GraphicController {

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages Graphic entities
	 * 
	 */
	@Autowired
	private GraphicDAO graphicDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Graphic entities
	 * 
	 */
	@Autowired
	private GraphicService graphicService;

	/**
	 * Create a new Doctor entity
	 * 
	 */
	@RequestMapping("/newGraphicDoctor")
	public ModelAndView newGraphicDoctor(@RequestParam Integer graphic_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("graphic_id", graphic_id);
		mav.addObject("doctor", new Doctor());
		mav.addObject("newFlag", true);
		mav.setViewName("graphic/doctor/editDoctor.jsp");

		return mav;
	}

	/**
	 * Select the Graphic entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteGraphic")
	public ModelAndView confirmDeleteGraphic(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("graphic", graphicDAO.findGraphicByPrimaryKey(idKey));
		mav.setViewName("graphic/deleteGraphic.jsp");

		return mav;
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@RequestMapping("/deleteGraphicDoctor")
	public ModelAndView deleteGraphicDoctor(@RequestParam Integer graphic_id, @RequestParam Integer related_doctor_id) {
		ModelAndView mav = new ModelAndView();

		Graphic graphic = graphicService.deleteGraphicDoctor(graphic_id, related_doctor_id);

		mav.addObject("graphic_id", graphic_id);
		mav.addObject("graphic", graphic);
		mav.setViewName("graphic/viewGraphic.jsp");

		return mav;
	}

	/**
	 * Create a new Graphic entity
	 * 
	 */
	@RequestMapping("/newGraphic")
	public ModelAndView newGraphic() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("graphic", new Graphic());
		mav.addObject("newFlag", true);
		mav.setViewName("graphic/editGraphic.jsp");

		return mav;
	}

	/**
	 * Show all Doctor entities by Graphic
	 * 
	 */
	@RequestMapping("/listGraphicDoctor")
	public ModelAndView listGraphicDoctor(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("graphic", graphicDAO.findGraphicByPrimaryKey(idKey));
		mav.setViewName("graphic/doctor/listDoctor.jsp");

		return mav;
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@RequestMapping("/saveGraphicDoctor")
	public ModelAndView saveGraphicDoctor(@RequestParam Integer graphic_id, @ModelAttribute Doctor doctor) {
		Graphic parent_graphic = graphicService.saveGraphicDoctor(graphic_id, doctor);

		ModelAndView mav = new ModelAndView();
		mav.addObject("graphic_id", graphic_id);
		mav.addObject("graphic", parent_graphic);
		mav.setViewName("graphic/viewGraphic.jsp");

		return mav;
	}

	/**
	 * Save an existing Graphic entity
	 * 
	 */
	@RequestMapping("/saveGraphic")
	public String saveGraphic(@ModelAttribute Graphic graphic) {
		graphicService.saveGraphic(graphic);
		return "forward:/indexGraphic";
	}

	/**
	 */
	@RequestMapping("/graphicController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Edit an existing Graphic entity
	 * 
	 */
	@RequestMapping("/editGraphic")
	public ModelAndView editGraphic(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("graphic", graphicDAO.findGraphicByPrimaryKey(idKey));
		mav.setViewName("graphic/editGraphic.jsp");

		return mav;
	}

	/**
	 * View an existing Doctor entity
	 * 
	 */
	@RequestMapping("/selectGraphicDoctor")
	public ModelAndView selectGraphicDoctor(@RequestParam Integer graphic_id, @RequestParam Integer doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("graphic_id", graphic_id);
		mav.addObject("doctor", doctor);
		mav.setViewName("graphic/doctor/viewDoctor.jsp");

		return mav;
	}

	/**
	 * Select the child Doctor entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteGraphicDoctor")
	public ModelAndView confirmDeleteGraphicDoctor(@RequestParam Integer graphic_id, @RequestParam Integer related_doctor_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("doctor", doctorDAO.findDoctorByPrimaryKey(related_doctor_id));
		mav.addObject("graphic_id", graphic_id);
		mav.setViewName("graphic/doctor/deleteDoctor.jsp");

		return mav;
	}

	/**
	 * Select an existing Graphic entity
	 * 
	 */
	@RequestMapping("/selectGraphic")
	public ModelAndView selectGraphic(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("graphic", graphicDAO.findGraphicByPrimaryKey(idKey));
		mav.setViewName("graphic/viewGraphic.jsp");

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
	 * Delete an existing Graphic entity
	 * 
	 */
	@RequestMapping("/deleteGraphic")
	public String deleteGraphic(@RequestParam Integer idKey) {
		Graphic graphic = graphicDAO.findGraphicByPrimaryKey(idKey);
		graphicService.deleteGraphic(graphic);
		return "forward:/indexGraphic";
	}

	/**
	 * Show all Graphic entities
	 * 
	 */
	@RequestMapping("/indexGraphic")
	public ModelAndView listGraphics() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("graphics", graphicService.loadGraphics());

		mav.setViewName("graphic/listGraphics.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Graphic entities
	 * 
	 */
	public String indexGraphic() {
		return "redirect:/indexGraphic";
	}

	/**
	 * Edit an existing Doctor entity
	 * 
	 */
	@RequestMapping("/editGraphicDoctor")
	public ModelAndView editGraphicDoctor(@RequestParam Integer graphic_id, @RequestParam Integer doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("graphic_id", graphic_id);
		mav.addObject("doctor", doctor);
		mav.setViewName("graphic/doctor/editDoctor.jsp");

		return mav;
	}
}