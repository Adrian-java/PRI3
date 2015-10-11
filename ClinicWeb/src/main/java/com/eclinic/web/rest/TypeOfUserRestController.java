package com.eclinic.web.rest;

import java.io.IOException;

import com.eclinic.dao.PermissionDAO;
import com.eclinic.dao.TypeOfUserDAO;
import com.eclinic.domain.Permission;
import com.eclinic.domain.TypeOfUser;
import com.eclinic.service.TypeOfUserService;




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
 * Spring Rest controller that handles CRUD requests for TypeOfUser entities
 * 
 */
@Path("/TypeOfUser")
@Component("TypeOfUserRestController")
public class TypeOfUserRestController {

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

	
	
	public TypeOfUserRestController(){}
	
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
	 * Delete an existing TypeOfUser entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{typeofuser_id}")
	@DELETE
	public void deleteTypeOfUser(@PathParam("typeofuser_id") Integer typeofuser_id) {
		TypeOfUser typeofuser = typeOfUserDAO.findTypeOfUserByPrimaryKey(typeofuser_id);
		typeOfUserService.deleteTypeOfUser(typeofuser);
	}

	/**
	 * Select an existing TypeOfUser entity
	 * 
	 */

	
	@GET
	@Path("/{typeofuser_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadTypeOfUser(@PathParam("typeofuser_id") Integer typeofuser_id) {
		return Response.ok(typeOfUserDAO.findTypeOfUserByPrimaryKey(typeofuser_id)).build();
	}

	

	/**
	 * Create a new TypeOfUser entity
	 * 
	 */

	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newTypeOfUser( TypeOfUser typeofuser) {
		typeOfUserService.saveTypeOfUser(typeofuser);
		return Response.ok(typeOfUserDAO.findTypeOfUserByPrimaryKey(typeofuser.getId())).build();
	}

	/**
	 * Delete an existing Permission entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{typeofuser_id}/permission/{permission_id}")
	public Response deleteTypeOfUserPermission(@PathParam("typeofuser_id") Integer typeofuser_id,
			@PathParam("related_permission_id") Integer related_permission_id) {
		return Response.ok(typeOfUserService.deleteTypeOfUserPermission(typeofuser_id, related_permission_id)).build();
	}

	/**
	 * Create a new Permission entity
	 * 
	 */

	
	@Path("/{typeofuser_id}/permission")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newTypeOfUserPermission(@PathParam("typeofuser_id") Integer typeofuser_id,
			Permission permission) {
		typeOfUserService.saveTypeOfUserPermission(typeofuser_id, permission);
		return Response.ok(permissionDAO.findPermissionByPrimaryKey(permission.getId())).build();
	}

	/**
	 * Save an existing Permission entity
	 * 
	 */

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{typeofuser_id}/permission")
	@PUT
	public Response saveTypeOfUserPermission(@PathParam("typeofuser_id") Integer typeofuser_id,
			Permission permission) {
		typeOfUserService.saveTypeOfUserPermission(typeofuser_id, permission);
		return Response.ok(permissionDAO.findPermissionByPrimaryKey(permission.getId())).build();
	}

	/**
	 * Show all TypeOfUser entities
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */

	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listTypeOfUsers() throws JsonGenerationException, JsonMappingException, IOException {
		return  Response.ok(new ObjectMapper().writeValueAsString(typeOfUserService.loadTypeOfUsers())).build();
	}

	/**
	 * View an existing Permission entity
	 * 
	 */

	
	@GET
	@Path("/{typeofuser_id}/permission/{permission_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadTypeOfUserPermission(@PathParam("typeofuser_id") Integer typeofuser_id,
			@PathParam("related_permission_id") Integer related_permission_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(related_permission_id, -1, -1);

		return Response.ok(permission).build();
	}

	/**
	 * Get Permission entity by TypeOfUser
	 * 
	 */

	@GET
	@Path("/{typeofuser_id}/permission")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTypeOfUserPermission(@PathParam("typeofuser_id") Integer typeofuser_id) {
		return Response.ok(typeOfUserDAO.findTypeOfUserByPrimaryKey(typeofuser_id).getPermission()).build();
	}

	/**
	 * Save an existing TypeOfUser entity
	 * 
	 */

	
	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveTypeOfUser(TypeOfUser typeofuser) {
		typeOfUserService.saveTypeOfUser(typeofuser);
		return Response.ok(typeOfUserDAO.findTypeOfUserByPrimaryKey(typeofuser.getId())).build();
	}
}
