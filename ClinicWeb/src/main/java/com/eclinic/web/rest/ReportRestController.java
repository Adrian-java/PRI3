package com.eclinic.web.rest;

import java.io.IOException;

import com.eclinic.dao.ReportDAO;
import com.eclinic.domain.Report;
import com.eclinic.service.ReportService;




import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;


/**
 * Spring Rest controller that handles CRUD requests for Report entities
 * 
 */
@Path("/Report")
@Component("ReportRestController")
public class ReportRestController {

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

	
	public ReportRestController() {
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
	 * Save an existing Report entity
	 * 
	 */

	
	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveReport(Report report) {
		reportService.saveReport(report);
		return Response.ok(reportDAO.findReportByPrimaryKey(report.getId())).build();
	}

	/**
	 * Create a new Report entity
	 * 
	 */

	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newReport( Report report) {
		reportService.saveReport(report);
		return Response.ok(reportDAO.findReportByPrimaryKey(report.getId())).build();
	}


	/**
	 * Show all Report entities
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */

	
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listReports() throws JsonGenerationException, JsonMappingException, IOException {
		return  Response.ok(new ObjectMapper().writeValueAsString(reportService.loadReports())).build();
	}

	/**
	 * Select an existing Report entity
	 * 
	 */

	
	@GET
	@Path("/{report_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadReport(@PathParam("report_id") Integer report_id) {
		return Response.ok(reportDAO.findReportByPrimaryKey(report_id)).build();
	}


	/**
	 * Delete an existing Report entity
	 * 
	 */

	
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{report_id}")
	@DELETE
	public void deleteReport(@PathParam("report_id") Integer report_id) {
		Report report = reportDAO.findReportByPrimaryKey(report_id);
		reportService.deleteReport(report);
	}
}