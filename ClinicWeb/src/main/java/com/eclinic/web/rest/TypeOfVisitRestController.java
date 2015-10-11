package com.eclinic.web.rest;

import java.io.IOException;

import com.eclinic.dao.TypeOfVisitDAO;
import com.eclinic.dao.VisitDAO;
import com.eclinic.domain.TypeOfVisit;
import com.eclinic.domain.Visit;
import com.eclinic.service.TypeOfVisitService;




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
 * Spring Rest controller that handles CRUD requests for TypeOfVisit entities
 * 
 */
@Path("/TypeOfVisit")
@Component("TypeOfVisitRestController")
public class TypeOfVisitRestController {

	/**
	 * DAO injected by Spring that manages TypeOfVisit entities
	 * 
	 */
	@Autowired
	private TypeOfVisitDAO typeOfVisitDAO;

	/**
	 * DAO injected by Spring that manages Visit entities
	 * 
	 */
	@Autowired
	private VisitDAO visitDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for TypeOfVisit entities
	 * 
	 */
	@Autowired
	private TypeOfVisitService typeOfVisitService;

	
	public TypeOfVisitRestController(){}
	
	
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
	 * View an existing Visit entity
	 * 
	 */

	
	@GET
	@Path("/{typeofvisit_id}/visits/{visit_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadTypeOfVisitVisits(@PathParam("typeofvisit_id") Integer typeofvisit_id,
			@PathParam("related_visits_id") Integer related_visits_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(related_visits_id, -1, -1);


		return Response.ok(visit).build();
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{typeofvisit_id}/visits/{visit_id}")
	public Response deleteTypeOfVisitVisits(@PathParam("typeofvisit_id") Integer typeofvisit_id,
			@PathParam("related_visits_id") Integer related_visits_id) {
		return Response.ok(typeOfVisitService.deleteTypeOfVisitVisits(typeofvisit_id, related_visits_id)).build();
	}
	

	/**
	 * Delete an existing TypeOfVisit entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{typeofvisit_id}")
	@DELETE
	public void deleteTypeOfVisit(@PathParam("typeofvisit_id") Integer typeofvisit_id) {
		TypeOfVisit typeofvisit = typeOfVisitDAO.findTypeOfVisitByPrimaryKey(typeofvisit_id);
		typeOfVisitService.deleteTypeOfVisit(typeofvisit);
	}

	/**
	 * Save an existing TypeOfVisit entity
	 * 
	 */

	
	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveTypeOfVisit( TypeOfVisit typeofvisit) {
		typeOfVisitService.saveTypeOfVisit(typeofvisit);
		return Response.ok(typeOfVisitDAO.findTypeOfVisitByPrimaryKey(typeofvisit.getId())).build();
	}

	/**
	 * Create a new TypeOfVisit entity
	 * 
	 */

	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newTypeOfVisit( TypeOfVisit typeofvisit) {
		typeOfVisitService.saveTypeOfVisit(typeofvisit);
		return Response.ok(typeOfVisitDAO.findTypeOfVisitByPrimaryKey(typeofvisit.getId())).build();
	}


	/**
	 * Show all Visit entities by TypeOfVisit
	 * 
	 */

	
	@GET
	@Path("/{typeofvisit_id}/visits")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTypeOfVisitVisits(@PathParam("typeofvisit_id") Integer typeofvisit_id) {
		return Response.ok(typeOfVisitDAO.findTypeOfVisitByPrimaryKey(typeofvisit_id).getVisits()).build();
	}

	/**
	 * Show all TypeOfVisit entities
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */

	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listTypeOfVisits() throws JsonGenerationException, JsonMappingException, IOException {
		return  Response.ok(new ObjectMapper().writeValueAsString(typeOfVisitService.loadTypeOfVisits())).build();
	}

	/**
	 * Create a new Visit entity
	 * 
	 */

	
	@Path("/{typeofvisit_id}/visits")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newTypeOfVisitVisits(@PathParam("typeofvisit_id") Integer typeofvisit_id,
			Visit visit) {
		typeOfVisitService.saveTypeOfVisitVisits(typeofvisit_id, visit);
		return Response.ok(visitDAO.findVisitByPrimaryKey(visit.getId())).build();
	}

	/**
	 * Select an existing TypeOfVisit entity
	 * 
	 */

	
	@GET
	@Path("/{typeofvisit_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadTypeOfVisit(@PathParam("typeofvisit_id") Integer typeofvisit_id) {
		return Response.ok(typeOfVisitDAO.findTypeOfVisitByPrimaryKey(typeofvisit_id)).build();
	}
	/**
	 * Save an existing Visit entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{typeofvisit_id}/visits")
	@PUT
	public Response saveTypeOfVisitVisits(@PathParam("typeofvisit_id") Integer typeofvisit_id,
			Visit visits) {
		typeOfVisitService.saveTypeOfVisitVisits(typeofvisit_id, visits);
		return Response.ok(visitDAO.findVisitByPrimaryKey(visits.getId())).build();
	}
}
