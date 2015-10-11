package com.eclinic.web.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.PatientCardDAO;
import com.eclinic.dao.ReceptionistDAO;
import com.eclinic.dao.SickLeaveDAO;
import com.eclinic.dao.StatusOfVisitDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.dao.TypeOfVisitDAO;
import com.eclinic.dao.VisitDAO;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.PatientCard;
import com.eclinic.domain.Receptionist;
import com.eclinic.domain.SickLeave;
import com.eclinic.domain.StatusOfVisit;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.TypeOfVisit;
import com.eclinic.domain.Visit;
import com.eclinic.model.VisitModel;
import com.eclinic.model.VisitUser;
import com.eclinic.service.PatientCardService;
import com.eclinic.service.VisitService;


/**
 * Spring Rest controller that handles CRUD requests for Visit entities
 * 
 */
@Path("/Visit")
@Component("VisitRestController")
public class VisitRestController {

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages PatientCard entities
	 * 
	 */
	@Autowired
	private PatientCardDAO patientCardDAO;

	/**
	 * DAO injected by Spring that manages Receptionist entities
	 * 
	 */
	@Autowired
	private ReceptionistDAO receptionistDAO;

	/**
	 * DAO injected by Spring that manages SickLeave entities
	 * 
	 */
	
	@Autowired
	private PatientCardService patientCardService;
	
	
	@Autowired
	private SickLeaveDAO sickLeaveDAO;

	/**
	 * DAO injected by Spring that manages StatusOfVisit entities
	 * 
	 */
	@Autowired
	private StatusOfVisitDAO statusOfVisitDAO;

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
	 * Service injected by Spring that provides CRUD operations for Visit entities
	 * 
	 */
	@Autowired
	private VisitService visitService;
	
	@Autowired 
	private SystemUserDAO systemUserDao;

	
	public VisitRestController(){}
	
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
	 * Delete an existing TypeOfVisit entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}/typeOfVisit/{typeofvisit_id}")
	public Response deleteVisitTypeOfVisit(@PathParam("visit_id") Integer visit_id,
			@PathParam("related_typeofvisit_id") Integer related_typeofvisit_id) {
		return Response.ok(visitService.deleteVisitTypeOfVisit(visit_id, related_typeofvisit_id)).build();
	}

	/**
	 * Delete an existing SickLeave entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}/sickLeaves/{sickleave_id}")
	public Response deleteVisitSickLeaves(@PathParam("visit_id") Integer visit_id,
			@PathParam("related_sickleaves_id") Integer related_sickleaves_id) {
		return Response.ok(visitService.deleteVisitSickLeaves(visit_id, related_sickleaves_id)).build();
	}


	/**
	 * View an existing TypeOfVisit entity
	 * 
	 */

	
	@GET
	@Path("/{visit_id}/typeOfVisit/{typeofvisit_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadVisitTypeOfVisit(@PathParam("visit_id") Integer visit_id,
			@PathParam("related_typeofvisit_id") Integer related_typeofvisit_id) {
		TypeOfVisit typeofvisit = typeOfVisitDAO.findTypeOfVisitByPrimaryKey(related_typeofvisit_id, -1, -1);

		return Response.ok(typeofvisit).build();
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}/doctor/{doctor_id}")
	public Response deleteVisitDoctor(@PathParam("visit_id") Integer visit_id,
			@PathParam("related_doctor_id") Integer related_doctor_id) {
		return Response.ok(visitService.deleteVisitDoctor(visit_id, related_doctor_id)).build();
	}
	/**
	 * Create a new Visit entity
	 * 
	 */

	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newVisit( VisitModel visitmodel) {
		try{
		Doctor d = systemUserDao.findSystemUserByPesel(visitmodel.getDoctorLogin()).getWorker().getDoctor();
		Patient p  = systemUserDao.findSystemUserByPesel(visitmodel.getPatientPesel()).getWorker().getPatient();
		PatientCard pc = patientCardDAO.findPatientCardByPatientId(p);
		if(pc==null){
			pc= new PatientCard();
			pc.setDoctor(d);
			pc.setPatient(p);
			pc.setRegisterDate(systemUserDao.findSystemUserByPesel(visitmodel.getDoctorLogin()).getRegisterDate());
			Integer id = patientCardService.savePatientCard(pc);
		}
		Receptionist r = systemUserDao.findSystemUserByPesel(visitmodel.getRecepcionistLogin()).getWorker().getReceptionist();
		StatusOfVisit sov = statusOfVisitDAO.findStatusOfVisitByType(visitmodel.getStatusOfVisit()).iterator().next();
		TypeOfVisit tof = typeOfVisitDAO.findTypeOfVisitByName(visitmodel.getTypeOfVisit()).iterator().next();
		Visit visit = new Visit();
		visit.setDateOfVisit(visitmodel.getDateOfVisit());
		visit.setDescriptionOfVisit(visitmodel.getDescriptionOfVisit());
		visit.setDoctor(d);
		visit.setIsLeave(visitmodel.getIsLeave());
		visit.setReceptionist(r);
		visit.setSpecial(visitmodel.getSpecial());
		visit.setStatusOfVisit(sov);
		visit.setTypeOfVisit(tof);
		visit.setPatientCard(pc);
		Integer  i = visitService.saveVisit(visit);
		return Response.ok(visitDAO.findVisitByPrimaryKey(i)).build();
		}catch(Exception e){
			return Response.status(Status.NOT_ACCEPTABLE).build();
		}
	}


	/**
	 * Get TypeOfVisit entity by Visit
	 * 
	 */
	
	
	@GET
	@Path("/{visit_id}/typeOfVisit")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVisitTypeOfVisit(@PathParam("visit_id") Integer visit_id) {
		return Response.ok(visitDAO.findVisitByPrimaryKey(visit_id).getTypeOfVisit()).build();
	}

	/**
	 * View an existing SickLeave entity
	 * 
	 */

	
	@GET
	@Path("/{visit_id}/sickLeaves/{sickleave_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadVisitSickLeaves(@PathParam("visit_id") Integer visit_id,
			@PathParam("related_sickleaves_id") Integer related_sickleaves_id) {
		SickLeave sickleave = sickLeaveDAO.findSickLeaveByPrimaryKey(related_sickleaves_id, -1, -1);

		return Response.ok(sickleave).build();
	}


	/**
	 * Get StatusOfVisit entity by Visit
	 * 
	 */


	@GET
	@Path("/{visit_id}/statusOfVisit")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVisitStatusOfVisit(@PathParam("visit_id") Integer visit_id) {
		return Response.ok(visitDAO.findVisitByPrimaryKey(visit_id).getStatusOfVisit()).build();
	}

	/**
	 * Delete an existing Receptionist entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}/receptionist/{receptionist_id}")
	public Response deleteTypeOfUserPermission(@PathParam("visit_id") Integer visit_id,
			@PathParam("related_receptionist_id") Integer related_receptionist_id) {
		return Response.ok(visitService.deleteVisitReceptionist(visit_id, related_receptionist_id)).build();
	}


	/**
	 * Show all SickLeave entities by Visit
	 * 
	 */

	@GET
	@Path("/{visit_id}/sickLeaves")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVisitSickLeaves(@PathParam("visit_id") Integer visit_id) {
		return Response.ok(visitDAO.findVisitByPrimaryKey(visit_id).getSickLeaves()).build();
	}

	/**
	 * Create a new StatusOfVisit entity
	 * 
	 */

	
	@Path("/{visit_id}/statusOfVisit")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newVisitStatusOfVisit(@PathParam("visit_id") Integer visit_id,
			StatusOfVisit statusofvisit) {
		visitService.saveVisitStatusOfVisit(visit_id, statusofvisit);
		return Response.ok(statusOfVisitDAO.findStatusOfVisitByPrimaryKey(statusofvisit.getId())).build();
	}

	/**
	 * Delete an existing PatientCard entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}/patientCard/{patientcard_id}")
	public Response deleteVisitPatientCard(@PathParam("visit_id") Integer visit_id,
			@PathParam("related_patientcard_id") Integer related_patientcard_id) {
		return Response.ok(visitService.deleteVisitPatientCard(visit_id, related_patientcard_id)).build();
	}

	/**
	 * Save an existing SickLeave entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}/sickLeaves")
	@PUT
	public Response saveVisitSickLeaves(@PathParam("visit_id") Integer visit_id,
			SickLeave sickleaves) {
		visitService.saveVisitSickLeaves(visit_id, sickleaves);
		return Response.ok(sickLeaveDAO.findSickLeaveByPrimaryKey(sickleaves.getId())).build();
	}

	/**
	 * View an existing Doctor entity
	 * 
	 */

	
	@GET
	@Path("/{visit_id}/doctor/{doctor_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadVisitDoctor(@PathParam("visit_id") Integer visit_id,
			@PathParam("related_doctor_id") Integer related_doctor_id) {
		Doctor doctor= doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);
		return Response.ok(doctor).build();
	}

	/**
	 * Save an existing Receptionist entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}/receptionist")
	@PUT
	public Response saveVisitReceptionist(@PathParam("visit_id") Integer visit_id,
			Receptionist receptionist) {
		visitService.saveVisitReceptionist(visit_id, receptionist);
		return Response.ok(receptionistDAO.findReceptionistByPrimaryKey(receptionist.getId())).build();
	}

	/**
	 * Delete an existing StatusOfVisit entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}/statusOfVisit/{statusofvisit_id}")
	public Response deleteVisitStatusOfVisit(@PathParam("visit_id") Integer visit_id,
			@PathParam("related_statusofvisit_id") Integer related_statusofvisit_id) {
		return Response.ok(visitService.deleteVisitStatusOfVisit(visit_id, related_statusofvisit_id)).build();
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}")
	@DELETE
	public void deleteVisit(@PathParam("visit_id") Integer visit_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(visit_id);
		visitService.deleteVisit(visit);
	}

	/**
	 * Create a new PatientCard entity
	 * 
	 */

	
	@Path("/{visit_id}/patientCard")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newVisitPatientCard(@PathParam("visit_id") Integer visit_id,
			PatientCard patientcard) {
		visitService.saveVisitPatientCard(visit_id, patientcard);
		return Response.ok(patientCardDAO.findPatientCardByPrimaryKey(patientcard.getId())).build();
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}/doctor")
	@PUT
	public Response saveVisitDoctor(@PathParam("visit_id") Integer visit_id,
			Doctor doctor) {
		visitService.saveVisitDoctor(visit_id, doctor);
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor.getId())).build();
	}

	/**
	 * Select an existing Visit entity
	 * 
	 */

	
	@GET
	@Path("/{visit_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadVisit(@PathParam("visit_id") Integer visit_id) {
		return Response.ok(visitDAO.findVisitByPrimaryKey(visit_id)).build();
	}
	
	@GET
	@Path("/get/{pesel}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVisitByPesel(@PathParam("pesel") String pesel) throws JsonGenerationException, JsonMappingException, DataAccessException, IOException {
		return Response.ok(new ObjectMapper().configure(Feature.FAIL_ON_EMPTY_BEANS,
				false).writeValueAsString(visitDAO.findVisitByPesel(pesel))).build();
	}

	/**
	 * Create a new TypeOfVisit entity
	 * 
	 */

	
	
	@Path("/{visit_id}/typeOfVisit")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newVisitTypeOfVisit(@PathParam("visit_id") Integer visit_id,
			TypeOfVisit typeofvisit) {
		visitService.saveVisitTypeOfVisit(visit_id, typeofvisit);
		return Response.ok(typeOfVisitDAO.findTypeOfVisitByPrimaryKey(typeofvisit.getId())).build();
	}

	
	/**
	 * Show all Visit entities
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */


	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listVisits() throws JsonGenerationException, JsonMappingException, IOException {
		
		List<VisitUser> set = new ArrayList<VisitUser>();
		Set<Visit> visit = visitService.loadVisits();
		Set<SystemUser> sys = systemUserDao.findAllSystemUsers();
		for(Visit v : visit){
			for(SystemUser su : sys){
				if(su.getWorker().getPatient()!=null && v.getPatientCard().getPatient().getId().equals(su.getWorker().getPatient().getId())){
					VisitUser vu = new VisitUser();
					vu.setSystemUser(su);
					vu.setVisit(v);
					set.add(vu);
				}
			}
		}
		
		return  Response.ok(new ObjectMapper().configure(Feature.FAIL_ON_EMPTY_BEANS,
				false).writeValueAsString(set)).build();
	}
	/**
	 * Save an existing TypeOfVisit entity
	 * 
	 */

	
	
	@Path("/{visit_id}/typeOfVisit")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveVisitTypeOfVisit(@PathParam("visit_id") Integer visit_id,
			TypeOfVisit typeofvisit) {
		visitService.saveVisitTypeOfVisit(visit_id, typeofvisit);
		return Response.ok(typeOfVisitDAO.findTypeOfVisitByPrimaryKey(typeofvisit.getId())).build();
	}

	/**
	 * View an existing PatientCard entity
	 * 
	 */

	
	
	@GET
	@Path("/{visit_id}/patientCard/{patientcard_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadVisitPatientCard(@PathParam("visit_id") Integer visit_id,
			@PathParam("related_patientcard_id") Integer related_patientcard_id) {
		PatientCard patientcard = patientCardDAO.findPatientCardByPrimaryKey(related_patientcard_id, -1, -1);
		return Response.ok(patientcard).build();
	}

	/**
	 * Get Receptionist entity by Visit
	 * 
	 */
	
	
	@GET
	@Path("/{visit_id}/receptionist")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVisitReceptionist(@PathParam("visit_id") Integer visit_id) {
		return Response.ok(visitDAO.findVisitByPrimaryKey(visit_id).getReceptionist()).build();
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */

	
	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveVisit(Visit visit) {
		visitService.saveVisit(visit);
		return Response.ok(visitDAO.findVisitByPrimaryKey(visit.getId())).build();
	}

	/**
	 * Create a new SickLeave entity
	 * 
	 */

	@Path("/{visit_id}/sickLeaves")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newVisitSickLeaves(@PathParam("visit_id") Integer visit_id,
			SickLeave sickleave) {
		visitService.saveVisitSickLeaves(visit_id, sickleave);
		return Response.ok(sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave.getId())).build();
	}

	/**
	 * Save an existing StatusOfVisit entity
	 * 
	 */


	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}/statusOfVisit")
	@PUT
	public Response saveVisitStatusOfVisit(@PathParam("visit_id") Integer visit_id,
			StatusOfVisit statusofvisit) {
		visitService.saveVisitStatusOfVisit(visit_id, statusofvisit);
		return Response.ok(statusOfVisitDAO.findStatusOfVisitByPrimaryKey(statusofvisit.getId())).build();
	}

	/**
	 * View an existing StatusOfVisit entity
	 * 
	 */

	@GET
	@Path("/{visit_id}/statusOfVisit/{statusofvisit_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadVisitStatusOfVisit(@PathParam("visit_id") Integer visit_id,
			@PathParam("related_statusofvisit_id") Integer related_statusofvisit_id) {
		StatusOfVisit statusofvisit = statusOfVisitDAO.findStatusOfVisitByPrimaryKey(related_statusofvisit_id, -1, -1);
		return Response.ok(statusofvisit).build();
	}

	/**
	 * View an existing Receptionist entity
	 * 
	 */

	
	@GET
	@Path("/{visit_id}/receptionist/{receptionist_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadVisitReceptionist(@PathParam("visit_id") Integer visit_id,
			@PathParam("related_receptionist_id") Integer related_receptionist_id) {
		Receptionist receptionist = receptionistDAO.findReceptionistByPrimaryKey(related_receptionist_id, -1, -1);
		return Response.ok(receptionist).build();
	}

	/**
	 * Create a new Doctor entity
	 * 
	 */
	
	
	@Path("/{visit_id}/doctor")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newVisitDoctor(@PathParam("visit_id") Integer visit_id,
			Doctor doctor) {
		visitService.saveVisitDoctor(visit_id, doctor);
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor.getId())).build();
	}

	/**
	 * Get PatientCard entity by Visit
	 * 
	 */

	
	@GET
	@Path("/{visit_id}/patientCard")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVisitPatientCard(@PathParam("visit_id") Integer visit_id) {
		return Response.ok(visitDAO.findVisitByPrimaryKey(visit_id).getPatientCard()).build();
	}

	/**
	 * Get Doctor entity by Visit
	 * 
	 */

	@GET
	@Path("/{visit_id}/doctor")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVisitDoctor(@PathParam("visit_id") Integer visit_id) {
		return Response.ok(visitDAO.findVisitByPrimaryKey(visit_id).getDoctor()).build();
	}

	/**
	 * Create a new Receptionist entity
	 * 
	 */

	
	@Path("/{visit_id}/receptionist")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newVisitReceptionist(@PathParam("visit_id") Integer visit_id,
			Receptionist receptionist) {
		visitService.saveVisitReceptionist(visit_id, receptionist);
		return Response.ok(receptionistDAO.findReceptionistByPrimaryKey(receptionist.getId())).build();
	}

	/**
	 * Save an existing PatientCard entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visit_id}/patientCard")
	@PUT
	public Response saveVisitPatientCard(@PathParam("visit_id") Integer visit_id,
			PatientCard patientcard) {
		visitService.saveVisitPatientCard(visit_id, patientcard);
		return Response.ok(patientCardDAO.findPatientCardByPrimaryKey(patientcard.getId())).build();
	}
}
