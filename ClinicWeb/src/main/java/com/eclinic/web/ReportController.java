package com.eclinic.web;

import com.eclinic.dao.ReportDAO;

import com.eclinic.domain.Report;

import com.eclinic.service.ReportService;

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
 * Spring MVC controller that handles CRUD requests for Report entities
 * 
 */

@Controller("ReportController")
public class ReportController {

	/**
	 * DAO injected by Spring that manages Report entities
	 * 
	 */
	@Autowired
	private ReportDAO reportDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Report entities
	 * 
	 */
	@Autowired
	private ReportService reportService;

	/**
	 * Save an existing Report entity
	 * 
	 */
	@RequestMapping("/saveReport")
	public String saveReport(@ModelAttribute Report report) {
		reportService.saveReport(report);
		return "forward:/indexReport";
	}

	/**
	 */
	@RequestMapping("/reportController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Show all Report entities
	 * 
	 */
	@RequestMapping("/indexReport")
	public ModelAndView listReports() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("reports", reportService.loadReports());

		mav.setViewName("report/listReports.jsp");

		return mav;
	}

	/**
	 * Create a new Report entity
	 * 
	 */
	@RequestMapping("/newReport")
	public ModelAndView newReport() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("report", new Report());
		mav.addObject("newFlag", true);
		mav.setViewName("report/editReport.jsp");

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
	 * Select an existing Report entity
	 * 
	 */
	@RequestMapping("/selectReport")
	public ModelAndView selectReport(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("report", reportDAO.findReportByPrimaryKey(idKey));
		mav.setViewName("report/viewReport.jsp");

		return mav;
	}

	/**
	 * Edit an existing Report entity
	 * 
	 */
	@RequestMapping("/editReport")
	public ModelAndView editReport(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("report", reportDAO.findReportByPrimaryKey(idKey));
		mav.setViewName("report/editReport.jsp");

		return mav;
	}

	/**
	 * Select the Report entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteReport")
	public ModelAndView confirmDeleteReport(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("report", reportDAO.findReportByPrimaryKey(idKey));
		mav.setViewName("report/deleteReport.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Report entities
	 * 
	 */
	public String indexReport() {
		return "redirect:/indexReport";
	}

	/**
	 * Delete an existing Report entity
	 * 
	 */
	@RequestMapping("/deleteReport")
	public String deleteReport(@RequestParam Integer idKey) {
		Report report = reportDAO.findReportByPrimaryKey(idKey);
		reportService.deleteReport(report);
		return "forward:/indexReport";
	}
}