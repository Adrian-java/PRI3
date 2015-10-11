package com.eclinic.web.rest;

import java.io.IOException;

import com.eclinic.dao.StatusOfVisitDAO;
import com.eclinic.dao.VisitDAO;
import com.eclinic.domain.StatusOfVisit;
import com.eclinic.domain.Visit;
import com.eclinic.service.StatusOfVisitService;




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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring Rest controller that handles CRUD requests for StatusOfVisit entities
 * 
 */
@Path("/StatusOfVisit")
@Component("StatusOfVisitRestController")
public class StatusOfVisitRestController {

	/**
	 * DAO injected by Spring that manages StatusOfVisit entities
	 * 
	 */
	@Autowired
	private StatusOfVisitDAO statusOfVisitDAO;

	/**
	 * DAO injected by Spring that manages Visit entities
	 * 
	 */
	@Autowired
	private VisitDAO visitDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for StatusOfVisit entities
	 * 
	 */
	@Autowired
	private StatusOfVisitService statusOfVisitService;

	/**
	 * Save an existing Visit entity
	 * 
	 */
	@RequestMapping(value = "/StatusOfVisit/{statusofvisit_id}/visits", method = RequestMethod.PUT)
	@ResponseBody
	public Visit saveStatusOfVisitVisits(@PathVariable Integer statusofvisit_id, @RequestBody Visit visits) {
		statusOfVisitService.saveStatusOfVisitVisits(statusofvisit_id, visits);
		return visitDAO.findVisitByPrimaryKey(visits.getId());
	}
	
	public StatusOfVisitRestController(){}

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
	 * Delete an existing Visit entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{statusofvisit_id}/visits/{visit_id}")
	public Response deleteStatusOfVisitVisits(@PathParam("statusofvisit_id") Integer statusofvisit_id,
			@PathParam("related_visits_id") Integer related_visits_id) {
		return Response.ok(statusOfVisitService.deleteStatusOfVisitVisits(statusofvisit_id, related_visits_id)).build();
	}

	/**
	 * Create a new StatusOfVisit entity
	 * 
	 */

	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newStatusOfVisit( StatusOfVisit statusofvisit) {
		statusOfVisitService.saveStatusOfVisit(statusofvisit);
		return Response.ok(statusOfVisitDAO.findStatusOfVisitByPrimaryKey(statusofvisit.getId())).build();
	}

	/**
	 * Select an existing StatusOfVisit entity
	 * 
	 */

	@GET
	@Path("/{statusofvisit_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadStatusOfVisit(@PathParam("statusofvisit_id") Integer statusofvisit_id) {
		return Response.ok(statusOfVisitDAO.findStatusOfVisitByPrimaryKey(statusofvisit_id)).build();
	}

	/**
	 * Create a new Visit entity
	 * 
	 */

	
	@Path("/{statusofvisit_id}/visits")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newStatusOfVisitVisits(@PathParam("statusofvisit_id") Integer statusofvisit_id,
			Visit visit) {
		statusOfVisitService.saveStatusOfVisitVisits(statusofvisit_id, visit);
		return Response.ok(visitDAO.findVisitByPrimaryKey(visit.getId())).build();
	}

	/**
	 * Show all StatusOfVisit entities
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */


	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listStatusOfVisits() throws JsonGenerationException, JsonMappingException, IOException {
		return  Response.ok(new ObjectMapper().writeValueAsString(statusOfVisitService.loadStatusOfVisits())).build();
	}

	/**
	 * Show all Visit entities by StatusOfVisit
	 * 
	 */

	
	@GET
	@Path("/{statusofvisit_id}/visits")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStatusOfVisitVisits(@PathParam("statusofvisit_id") Integer statusofvisit_id) {
		return Response.ok(statusOfVisitDAO.findStatusOfVisitByPrimaryKey(statusofvisit_id).getVisits()).build();
	}
	

	/**
	 * Delete an existing StatusOfVisit entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{statusofvisit_id}")
	@DELETE
	public void deleteStatusOfVisit(@PathParam("statusofvisit_id") Integer statusofvisit_id) {
		StatusOfVisit statusofvisit = statusOfVisitDAO.findStatusOfVisitByPrimaryKey(statusofvisit_id);
		statusOfVisitService.deleteStatusOfVisit(statusofvisit);
	}

	/**
	 * View an existing Visit entity
	 * 
	 */

	
	@GET
	@Path("/{statusofvisit_id}/visits/{visit_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadStatusOfVisitVisits(@PathParam("statusofvisit_id") Integer statusofvisit_id,
			@PathParam("related_visits_id") Integer related_visits_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(related_visits_id, -1, -1);
		return Response.ok(visit).build();
	}

	/**
	 * Save an existing StatusOfVisit entity
	 * 
	 */

	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveStatusOfVisit(StatusOfVisit statusofvisit) {
		statusOfVisitService.saveStatusOfVisit(statusofvisit);
		return Response.ok(statusOfVisitDAO.findStatusOfVisitByPrimaryKey(statusofvisit.getId())).build();
	}
}