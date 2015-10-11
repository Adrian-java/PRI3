package com.eclinic.web.rest;

import java.io.IOException;

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
 * Spring Rest controller that handles CRUD requests for Permission entities
 * 
 */
@Path("/Permission")
@Component("PermissionRestController")
public class PermissionRestController {

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

	
	public PermissionRestController() {
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
	 * View an existing TypeOfUser entity
	 * 
	 */

	
	@GET
	@Path("/{permission_id}/typeOfUsers/{typeofuser_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadPermissionTypeOfUsers(@PathParam("permission_id") Integer permission_id,
			@PathParam("related_typeofusers_id") Integer related_typeofusers_id) {
		TypeOfUser typeofuser = typeOfUserDAO.findTypeOfUserByPrimaryKey(related_typeofusers_id, -1, -1);

		return Response.ok(typeofuser).build();
	}


	/**
	 * Show all Permission entities
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */

	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listPermissions() throws JsonGenerationException, JsonMappingException, IOException {
		return  Response.ok(new ObjectMapper().writeValueAsString(permissionService.loadPermissions())).build();
	}

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{permission_id}/systemUser/{systemuser_id}")
	public Response deletePermissionSystemUser(@PathParam("permission_id") Integer permission_id,
			@PathParam("related_systemuser_id") Integer related_systemuser_id) {
		return Response.ok(permissionService.deletePermissionSystemUser(permission_id, related_systemuser_id)).build();
	}

	/**
	 * Show all TypeOfUser entities by Permission
	 * 
	 */

	
	@GET
	@Path("/{permission_id}/typeOfUsers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPermissionTypeOfUsers(@PathParam("permission_id") Integer permission_id) {
		return Response.ok(permissionDAO.findPermissionByPrimaryKey(permission_id).getTypeOfUsers()).build();
	}

	/**
	 * Select an existing Permission entity
	 * 
	 */

	
	@GET
	@Path("/{permission_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadPermission(@PathParam("permission_id") Integer permission_id) {
		return Response.ok(permissionDAO.findPermissionByPrimaryKey(permission_id)).build();
	}


	/**
	 * Save an existing Permission entity
	 * 
	 */

	

	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Response savePermission(Permission permission) {
		permissionService.savePermission(permission);
		return Response.ok(permissionDAO.findPermissionByPrimaryKey(permission.getId())).build();
	}


	/**
	 * Create a new SystemUser entity
	 * 
	 */

	
	@Path("/{permission_id}/systemUser")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newPermissionSystemUser(@PathParam("permission_id") Integer permission_id,
			SystemUser systemuser) {
		permissionService.savePermissionSystemUser(permission_id, systemuser);
		return Response.ok(systemUserDAO.findSystemUserByPrimaryKey(systemuser.getId())).build();
	}

	/**
	 * Delete an existing Permission entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{permission_id}")
	@DELETE
	public void deleteDoctor(@PathParam("permission_id") Integer permission_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(permission_id);
		permissionService.deletePermission(permission);
		}


	

	/**
	 * View an existing Module entity
	 * 
	 */

	
	@GET
	@Path("/{permission_id}/module/{module_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadPermissionModule(@PathParam("permission_id") Integer permission_id,
			@PathParam("related_module_id") Integer related_module_id) {
		Module module = moduleDAO.findModuleByPrimaryKey(related_module_id, -1, -1);

		return Response.ok(module).build();
	}

	/**
	 * Create a new Module entity
	 * 
	 */

	

	@Path("/{permission_id}/module")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newPermissionModule(@PathParam("permission_id") Integer permission_id,
			Module module) {
		permissionService.savePermissionModule(permission_id, module);
		return Response.ok(moduleDAO.findModuleByPrimaryKey(module.getId())).build();
	}

	/**
	 * Delete an existing TypeOfUser entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{permission_id}/typeOfUsers/{typeofuser_id}")
	public Response deletePermissionTypeOfUsers(@PathParam("permission_id") Integer permission_id,
			@PathParam("related_typeofusers_id") Integer related_typeofusers_id) {
		return Response.ok(permissionService.deletePermissionTypeOfUsers(permission_id, related_typeofusers_id)).build();
	}

	/**
	 * Create a new TypeOfUser entity
	 * 
	 */


	
	@Path("/{permission_id}/typeOfUsers")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newPermissionTypeOfUsers(@PathParam("permission_id") Integer permission_id,
			TypeOfUser typeofuser) {
		permissionService.savePermissionTypeOfUsers(permission_id, typeofuser);
		return Response.ok(typeOfUserDAO.findTypeOfUserByPrimaryKey(typeofuser.getId())).build();
	}
	/**
	 * Get SystemUser entity by Permission
	 * 
	 */
	
	
	@GET
	@Path("/{permission_id}/systemUser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPermissionSystemUser(@PathParam("permission_id") Integer permission_id) {
		return Response.ok(permissionDAO.findPermissionByPrimaryKey(permission_id).getSystemUser()).build();
	}

	/**
	 * Create a new Permission entity
	 * 
	 */

	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newPermission( Permission permission) {
		permissionService.savePermission(permission);
		return Response.ok(permissionDAO.findPermissionByPrimaryKey(permission.getId())).build();
	}

	/**
	 * Delete an existing Module entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{permission_id}/module/{module_id}")
	public Response deletePermissionModule(@PathParam("permission_id") Integer permission_id,
			@PathParam("related_module_id") Integer related_module_id) {
		return Response.ok(permissionService.deletePermissionModule(permission_id, related_module_id)).build();
	}

	/**
	 * Save an existing SystemUser entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{permission_id}/systemUser")
	@PUT
	public Response savePermissionSystemUser(@PathParam("permission_id") Integer permission_id,
			SystemUser systemuser) {
		permissionService.savePermissionSystemUser(permission_id, systemuser);
		return Response.ok(systemUserDAO.findSystemUserByPrimaryKey(systemuser.getId())).build();
	}

	/**
	 * Save an existing Module entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{permission_id}/module")
	@PUT
	public Response savePermissionModule(@PathParam("permission_id") Integer permission_id,
			Module module) {
		permissionService.savePermissionModule(permission_id, module);
		return Response.ok(moduleDAO.findModuleByPrimaryKey(module.getId())).build();
	}

	/**
	 * View an existing SystemUser entity
	 * 
	 */

	
	
	@GET
	@Path("/{permission_id}/systemUser/{systemuser_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadPermissionSystemUser(@PathParam("permission_id") Integer permission_id,
			@PathParam("related_systemuser_id") Integer related_systemuser_id) {
		SystemUser systemuser = systemUserDAO.findSystemUserByPrimaryKey(related_systemuser_id, -1, -1);

		return Response.ok(systemuser).build();
	}

	/**
	 * Get Module entity by Permission
	 * 
	 */

	
	@GET
	@Path("/{permission_id}/module")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPermissionModule(@PathParam("permission_id") Integer permission_id) {
		return Response.ok(permissionDAO.findPermissionByPrimaryKey(permission_id).getModule()).build();
	}

	/**
	 * Save an existing TypeOfUser entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/typeOfUsers")
	@PUT
	public Response savePermissionTypeOfUsers(@PathParam("permission_id") Integer permission_id,
			TypeOfUser typeofusers) {
		permissionService.savePermissionTypeOfUsers(permission_id, typeofusers);
		return Response.ok(typeOfUserDAO.findTypeOfUserByPrimaryKey(typeofusers.getId())).build();
	}
}