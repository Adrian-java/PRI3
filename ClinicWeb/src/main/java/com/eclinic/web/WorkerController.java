package com.eclinic.web;

import com.eclinic.dao.AdminDAO;
import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.LoginHistoryDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.ReceptionistDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.dao.WorkerDAO;

import com.eclinic.domain.Admin;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.LoginHistory;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Receptionist;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.Worker;

import com.eclinic.service.WorkerService;

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
 * Spring MVC controller that handles CRUD requests for Worker entities
 * 
 */

@Controller("WorkerController")
public class WorkerController {

	/**
	 * DAO injected by Spring that manages Admin entities
	 * 
	 */
	@Autowired
	private AdminDAO adminDAO;

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages LoginHistory entities
	 * 
	 */
	@Autowired
	private LoginHistoryDAO loginHistoryDAO;

	/**
	 * DAO injected by Spring that manages Patient entities
	 * 
	 */
	@Autowired
	private PatientDAO patientDAO;

	/**
	 * DAO injected by Spring that manages Receptionist entities
	 * 
	 */
	@Autowired
	private ReceptionistDAO receptionistDAO;

	/**
	 * DAO injected by Spring that manages SystemUser entities
	 * 
	 */
	@Autowired
	private SystemUserDAO systemUserDAO;

	/**
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Worker entities
	 * 
	 */
	@Autowired
	private WorkerService workerService;

	/**
	 * View an existing Admin entity
	 * 
	 */
	@RequestMapping("/selectWorkerAdmin")
	public ModelAndView selectWorkerAdmin(@RequestParam Integer worker_id, @RequestParam Integer admin_id) {
		Admin admin = adminDAO.findAdminByPrimaryKey(admin_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("worker_id", worker_id);
		mav.addObject("admin", admin);
		mav.setViewName("worker/admin/viewAdmin.jsp");

		return mav;
	}

	/**
	 * Edit an existing Doctor entity
	 * 
	 */
	@RequestMapping("/editWorkerDoctor")
	public ModelAndView editWorkerDoctor(@RequestParam Integer worker_id, @RequestParam Integer doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("worker_id", worker_id);
		mav.addObject("doctor", doctor);
		mav.setViewName("worker/doctor/editDoctor.jsp");

		return mav;
	}

	/**
	 * View an existing LoginHistory entity
	 * 
	 */
	@RequestMapping("/selectWorkerLoginHistories")
	public ModelAndView selectWorkerLoginHistories(@RequestParam Integer worker_id, @RequestParam Integer loginhistories_id) {
		LoginHistory loginhistory = loginHistoryDAO.findLoginHistoryByPrimaryKey(loginhistories_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("worker_id", worker_id);
		mav.addObject("loginhistory", loginhistory);
		mav.setViewName("worker/loginhistories/viewLoginHistories.jsp");

		return mav;
	}

	/**
	 * View an existing SystemUser entity
	 * 
	 */
	@RequestMapping("/selectWorkerSystemUsers")
	public ModelAndView selectWorkerSystemUsers(@RequestParam Integer worker_id, @RequestParam Integer systemusers_id) {
		SystemUser systemuser = systemUserDAO.findSystemUserByPrimaryKey(systemusers_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("worker_id", worker_id);
		mav.addObject("systemuser", systemuser);
		mav.setViewName("worker/systemusers/viewSystemUsers.jsp");

		return mav;
	}

	/**
	 * Select the Worker entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteWorker")
	public ModelAndView confirmDeleteWorker(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("worker", workerDAO.findWorkerByPrimaryKey(idKey));
		mav.setViewName("worker/deleteWorker.jsp");

		return mav;
	}

	/**
	 * Show all Patient entities by Worker
	 * 
	 */
	@RequestMapping("/listWorkerPatient")
	public ModelAndView listWorkerPatient(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("worker", workerDAO.findWorkerByPrimaryKey(idKey));
		mav.setViewName("worker/patient/listPatient.jsp");

		return mav;
	}

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	@RequestMapping("/deleteWorkerSystemUsers")
	public ModelAndView deleteWorkerSystemUsers(@RequestParam Integer worker_id, @RequestParam Integer related_systemusers_id) {
		ModelAndView mav = new ModelAndView();

		Worker worker = workerService.deleteWorkerSystemUsers(worker_id, related_systemusers_id);

		mav.addObject("worker_id", worker_id);
		mav.addObject("worker", worker);
		mav.setViewName("worker/viewWorker.jsp");

		return mav;
	}

	/**
	 * Select the child Patient entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteWorkerPatient")
	public ModelAndView confirmDeleteWorkerPatient(@RequestParam Integer worker_id, @RequestParam Integer related_patient_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patient", patientDAO.findPatientByPrimaryKey(related_patient_id));
		mav.addObject("worker_id", worker_id);
		mav.setViewName("worker/patient/deletePatient.jsp");

		return mav;
	}

	/**
	 * Show all Worker entities
	 * 
	 */
	@RequestMapping("/indexWorker")
	public ModelAndView listWorkers() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("workers", workerService.loadWorkers());

		mav.setViewName("worker/listWorkers.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/workerController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Save an existing Worker entity
	 * 
	 */
	@RequestMapping("/saveWorker")
	public String saveWorker(@ModelAttribute Worker worker) {
		workerService.saveWorker(worker);
		return "forward:/indexWorker";
	}

	/**
	 * Save an existing LoginHistory entity
	 * 
	 */
	@RequestMapping("/saveWorkerLoginHistories")
	public ModelAndView saveWorkerLoginHistories(@RequestParam Integer worker_id, @ModelAttribute LoginHistory loginhistories) {
		Worker parent_worker = workerService.saveWorkerLoginHistories(worker_id, loginhistories);

		ModelAndView mav = new ModelAndView();
		mav.addObject("worker_id", worker_id);
		mav.addObject("worker", parent_worker);
		mav.setViewName("worker/viewWorker.jsp");

		return mav;
	}

	/**
	 * Show all Doctor entities by Worker
	 * 
	 */
	@RequestMapping("/listWorkerDoctor")
	public ModelAndView listWorkerDoctor(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("worker", workerDAO.findWorkerByPrimaryKey(idKey));
		mav.setViewName("worker/doctor/listDoctor.jsp");

		return mav;
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */
	@RequestMapping("/saveWorkerPatient")
	public ModelAndView saveWorkerPatient(@RequestParam Integer worker_id, @ModelAttribute Patient patient) {
		Worker parent_worker = workerService.saveWorkerPatient(worker_id, patient);

		ModelAndView mav = new ModelAndView();
		mav.addObject("worker_id", worker_id);
		mav.addObject("worker", parent_worker);
		mav.setViewName("worker/viewWorker.jsp");

		return mav;
	}

	/**
	 * Edit an existing Admin entity
	 * 
	 */
	@RequestMapping("/editWorkerAdmin")
	public ModelAndView editWorkerAdmin(@RequestParam Integer worker_id, @RequestParam Integer admin_id) {
		Admin admin = adminDAO.findAdminByPrimaryKey(admin_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("worker_id", worker_id);
		mav.addObject("admin", admin);
		mav.setViewName("worker/admin/editAdmin.jsp");

		return mav;
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@RequestMapping("/deleteWorkerDoctor")
	public ModelAndView deleteWorkerDoctor(@RequestParam Integer worker_id, @RequestParam Integer related_doctor_id) {
		ModelAndView mav = new ModelAndView();

		Worker worker = workerService.deleteWorkerDoctor(worker_id, related_doctor_id);

		mav.addObject("worker_id", worker_id);
		mav.addObject("worker", worker);
		mav.setViewName("worker/viewWorker.jsp");

		return mav;
	}

	/**
	 * Edit an existing SystemUser entity
	 * 
	 */
	@RequestMapping("/editWorkerSystemUsers")
	public ModelAndView editWorkerSystemUsers(@RequestParam Integer worker_id, @RequestParam Integer systemusers_id) {
		SystemUser systemuser = systemUserDAO.findSystemUserByPrimaryKey(systemusers_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("worker_id", worker_id);
		mav.addObject("systemuser", systemuser);
		mav.setViewName("worker/systemusers/editSystemUsers.jsp");

		return mav;
	}

	/**
	 * Edit an existing LoginHistory entity
	 * 
	 */
	@RequestMapping("/editWorkerLoginHistories")
	public ModelAndView editWorkerLoginHistories(@RequestParam Integer worker_id, @RequestParam Integer loginhistories_id) {
		LoginHistory loginhistory = loginHistoryDAO.findLoginHistoryByPrimaryKey(loginhistories_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("worker_id", worker_id);
		mav.addObject("loginhistory", loginhistory);
		mav.setViewName("worker/loginhistories/editLoginHistories.jsp");

		return mav;
	}

	/**
	 * Create a new LoginHistory entity
	 * 
	 */
	@RequestMapping("/newWorkerLoginHistories")
	public ModelAndView newWorkerLoginHistories(@RequestParam Integer worker_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("worker_id", worker_id);
		mav.addObject("loginhistory", new LoginHistory());
		mav.addObject("newFlag", true);
		mav.setViewName("worker/loginhistories/editLoginHistories.jsp");

		return mav;
	}

	/**
	 * Delete an existing Receptionist entity
	 * 
	 */
	@RequestMapping("/deleteWorkerReceptionist")
	public ModelAndView deleteWorkerReceptionist(@RequestParam Integer worker_id, @RequestParam Integer related_receptionist_id) {
		ModelAndView mav = new ModelAndView();

		Worker worker = workerService.deleteWorkerReceptionist(worker_id, related_receptionist_id);

		mav.addObject("worker_id", worker_id);
		mav.addObject("worker", worker);
		mav.setViewName("worker/viewWorker.jsp");

		return mav;
	}

	/**
	 * View an existing Doctor entity
	 * 
	 */
	@RequestMapping("/selectWorkerDoctor")
	public ModelAndView selectWorkerDoctor(@RequestParam Integer worker_id, @RequestParam Integer doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("worker_id", worker_id);
		mav.addObject("doctor", doctor);
		mav.setViewName("worker/doctor/viewDoctor.jsp");

		return mav;
	}

	/**
	 * Show all Admin entities by Worker
	 * 
	 */
	@RequestMapping("/listWorkerAdmin")
	public ModelAndView listWorkerAdmin(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("worker", workerDAO.findWorkerByPrimaryKey(idKey));
		mav.setViewName("worker/admin/listAdmin.jsp");

		return mav;
	}

	/**
	 * Create a new Patient entity
	 * 
	 */
	@RequestMapping("/newWorkerPatient")
	public ModelAndView newWorkerPatient(@RequestParam Integer worker_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("worker_id", worker_id);
		mav.addObject("patient", new Patient());
		mav.addObject("newFlag", true);
		mav.setViewName("worker/patient/editPatient.jsp");

		return mav;
	}

	/**
	 * View an existing Patient entity
	 * 
	 */
	@RequestMapping("/selectWorkerPatient")
	public ModelAndView selectWorkerPatient(@RequestParam Integer worker_id, @RequestParam Integer patient_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(patient_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("worker_id", worker_id);
		mav.addObject("patient", patient);
		mav.setViewName("worker/patient/viewPatient.jsp");

		return mav;
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	@RequestMapping("/deleteWorker")
	public String deleteWorker(@RequestParam Integer idKey) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(idKey);
		workerService.deleteWorker(worker);
		return "forward:/indexWorker";
	}

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	@RequestMapping("/saveWorkerSystemUsers")
	public ModelAndView saveWorkerSystemUsers(@RequestParam Integer worker_id, @ModelAttribute SystemUser systemusers) {
		Worker parent_worker = workerService.saveWorkerSystemUsers(worker_id, systemusers);

		ModelAndView mav = new ModelAndView();
		mav.addObject("worker_id", worker_id);
		mav.addObject("worker", parent_worker);
		mav.setViewName("worker/viewWorker.jsp");

		return mav;
	}

	/**
	 * View an existing Receptionist entity
	 * 
	 */
	@RequestMapping("/selectWorkerReceptionist")
	public ModelAndView selectWorkerReceptionist(@RequestParam Integer worker_id, @RequestParam Integer receptionist_id) {
		Receptionist receptionist = receptionistDAO.findReceptionistByPrimaryKey(receptionist_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("worker_id", worker_id);
		mav.addObject("receptionist", receptionist);
		mav.setViewName("worker/receptionist/viewReceptionist.jsp");

		return mav;
	}

	/**
	 * Create a new Doctor entity
	 * 
	 */
	@RequestMapping("/newWorkerDoctor")
	public ModelAndView newWorkerDoctor(@RequestParam Integer worker_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("worker_id", worker_id);
		mav.addObject("doctor", new Doctor());
		mav.addObject("newFlag", true);
		mav.setViewName("worker/doctor/editDoctor.jsp");

		return mav;
	}

	/**
	 * Create a new Admin entity
	 * 
	 */
	@RequestMapping("/newWorkerAdmin")
	public ModelAndView newWorkerAdmin(@RequestParam Integer worker_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("worker_id", worker_id);
		mav.addObject("admin", new Admin());
		mav.addObject("newFlag", true);
		mav.setViewName("worker/admin/editAdmin.jsp");

		return mav;
	}

	/**
	 * Select the child Admin entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteWorkerAdmin")
	public ModelAndView confirmDeleteWorkerAdmin(@RequestParam Integer worker_id, @RequestParam Integer related_admin_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("admin", adminDAO.findAdminByPrimaryKey(related_admin_id));
		mav.addObject("worker_id", worker_id);
		mav.setViewName("worker/admin/deleteAdmin.jsp");

		return mav;
	}

	/**
	 * Select an existing Worker entity
	 * 
	 */
	@RequestMapping("/selectWorker")
	public ModelAndView selectWorker(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("worker", workerDAO.findWorkerByPrimaryKey(idKey));
		mav.setViewName("worker/viewWorker.jsp");

		return mav;
	}

	/**
	 * Save an existing Receptionist entity
	 * 
	 */
	@RequestMapping("/saveWorkerReceptionist")
	public ModelAndView saveWorkerReceptionist(@RequestParam Integer worker_id, @ModelAttribute Receptionist receptionist) {
		Worker parent_worker = workerService.saveWorkerReceptionist(worker_id, receptionist);

		ModelAndView mav = new ModelAndView();
		mav.addObject("worker_id", worker_id);
		mav.addObject("worker", parent_worker);
		mav.setViewName("worker/viewWorker.jsp");

		return mav;
	}

	/**
	 * Delete an existing Admin entity
	 * 
	 */
	@RequestMapping("/deleteWorkerAdmin")
	public ModelAndView deleteWorkerAdmin(@RequestParam Integer worker_id, @RequestParam Integer related_admin_id) {
		ModelAndView mav = new ModelAndView();

		Worker worker = workerService.deleteWorkerAdmin(worker_id, related_admin_id);

		mav.addObject("worker_id", worker_id);
		mav.addObject("worker", worker);
		mav.setViewName("worker/viewWorker.jsp");

		return mav;
	}

	/**
	 * Select the child LoginHistory entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteWorkerLoginHistories")
	public ModelAndView confirmDeleteWorkerLoginHistories(@RequestParam Integer worker_id, @RequestParam Integer related_loginhistories_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("loginhistory", loginHistoryDAO.findLoginHistoryByPrimaryKey(related_loginhistories_id));
		mav.addObject("worker_id", worker_id);
		mav.setViewName("worker/loginhistories/deleteLoginHistories.jsp");

		return mav;
	}

	/**
	 * Select the child Receptionist entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteWorkerReceptionist")
	public ModelAndView confirmDeleteWorkerReceptionist(@RequestParam Integer worker_id, @RequestParam Integer related_receptionist_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("receptionist", receptionistDAO.findReceptionistByPrimaryKey(related_receptionist_id));
		mav.addObject("worker_id", worker_id);
		mav.setViewName("worker/receptionist/deleteReceptionist.jsp");

		return mav;
	}

	/**
	 * Edit an existing Patient entity
	 * 
	 */
	@RequestMapping("/editWorkerPatient")
	public ModelAndView editWorkerPatient(@RequestParam Integer worker_id, @RequestParam Integer patient_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(patient_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("worker_id", worker_id);
		mav.addObject("patient", patient);
		mav.setViewName("worker/patient/editPatient.jsp");

		return mav;
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	@RequestMapping("/deleteWorkerPatient")
	public ModelAndView deleteWorkerPatient(@RequestParam Integer worker_id, @RequestParam Integer related_patient_id) {
		ModelAndView mav = new ModelAndView();

		Worker worker = workerService.deleteWorkerPatient(worker_id, related_patient_id);

		mav.addObject("worker_id", worker_id);
		mav.addObject("worker", worker);
		mav.setViewName("worker/viewWorker.jsp");

		return mav;
	}

	/**
	 * Edit an existing Receptionist entity
	 * 
	 */
	@RequestMapping("/editWorkerReceptionist")
	public ModelAndView editWorkerReceptionist(@RequestParam Integer worker_id, @RequestParam Integer receptionist_id) {
		Receptionist receptionist = receptionistDAO.findReceptionistByPrimaryKey(receptionist_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("worker_id", worker_id);
		mav.addObject("receptionist", receptionist);
		mav.setViewName("worker/receptionist/editReceptionist.jsp");

		return mav;
	}

	/**
	 * Edit an existing Worker entity
	 * 
	 */
	@RequestMapping("/editWorker")
	public ModelAndView editWorker(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("worker", workerDAO.findWorkerByPrimaryKey(idKey));
		mav.setViewName("worker/editWorker.jsp");

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
	 * Save an existing Admin entity
	 * 
	 */
	@RequestMapping("/saveWorkerAdmin")
	public ModelAndView saveWorkerAdmin(@RequestParam Integer worker_id, @ModelAttribute Admin admin) {
		Worker parent_worker = workerService.saveWorkerAdmin(worker_id, admin);

		ModelAndView mav = new ModelAndView();
		mav.addObject("worker_id", worker_id);
		mav.addObject("worker", parent_worker);
		mav.setViewName("worker/viewWorker.jsp");

		return mav;
	}

	/**
	 * Create a new Worker entity
	 * 
	 */
	@RequestMapping("/newWorker")
	public ModelAndView newWorker() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("worker", new Worker());
		mav.addObject("newFlag", true);
		mav.setViewName("worker/editWorker.jsp");

		return mav;
	}

	/**
	 * Create a new Receptionist entity
	 * 
	 */
	@RequestMapping("/newWorkerReceptionist")
	public ModelAndView newWorkerReceptionist(@RequestParam Integer worker_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("worker_id", worker_id);
		mav.addObject("receptionist", new Receptionist());
		mav.addObject("newFlag", true);
		mav.setViewName("worker/receptionist/editReceptionist.jsp");

		return mav;
	}

	/**
	 * Show all SystemUser entities by Worker
	 * 
	 */
	@RequestMapping("/listWorkerSystemUsers")
	public ModelAndView listWorkerSystemUsers(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("worker", workerDAO.findWorkerByPrimaryKey(idKey));
		mav.setViewName("worker/systemusers/listSystemUsers.jsp");

		return mav;
	}

	/**
	 * Show all Receptionist entities by Worker
	 * 
	 */
	@RequestMapping("/listWorkerReceptionist")
	public ModelAndView listWorkerReceptionist(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("worker", workerDAO.findWorkerByPrimaryKey(idKey));
		mav.setViewName("worker/receptionist/listReceptionist.jsp");

		return mav;
	}

	/**
	 * Select the child SystemUser entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteWorkerSystemUsers")
	public ModelAndView confirmDeleteWorkerSystemUsers(@RequestParam Integer worker_id, @RequestParam Integer related_systemusers_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("systemuser", systemUserDAO.findSystemUserByPrimaryKey(related_systemusers_id));
		mav.addObject("worker_id", worker_id);
		mav.setViewName("worker/systemusers/deleteSystemUsers.jsp");

		return mav;
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@RequestMapping("/saveWorkerDoctor")
	public ModelAndView saveWorkerDoctor(@RequestParam Integer worker_id, @ModelAttribute Doctor doctor) {
		Worker parent_worker = workerService.saveWorkerDoctor(worker_id, doctor);

		ModelAndView mav = new ModelAndView();
		mav.addObject("worker_id", worker_id);
		mav.addObject("worker", parent_worker);
		mav.setViewName("worker/viewWorker.jsp");

		return mav;
	}

	/**
	 * Select the child Doctor entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteWorkerDoctor")
	public ModelAndView confirmDeleteWorkerDoctor(@RequestParam Integer worker_id, @RequestParam Integer related_doctor_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("doctor", doctorDAO.findDoctorByPrimaryKey(related_doctor_id));
		mav.addObject("worker_id", worker_id);
		mav.setViewName("worker/doctor/deleteDoctor.jsp");

		return mav;
	}

	/**
	 * Show all LoginHistory entities by Worker
	 * 
	 */
	@RequestMapping("/listWorkerLoginHistories")
	public ModelAndView listWorkerLoginHistories(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("worker", workerDAO.findWorkerByPrimaryKey(idKey));
		mav.setViewName("worker/loginhistories/listLoginHistories.jsp");

		return mav;
	}

	/**
	 * Delete an existing LoginHistory entity
	 * 
	 */
	@RequestMapping("/deleteWorkerLoginHistories")
	public ModelAndView deleteWorkerLoginHistories(@RequestParam Integer worker_id, @RequestParam Integer related_loginhistories_id) {
		ModelAndView mav = new ModelAndView();

		Worker worker = workerService.deleteWorkerLoginHistories(worker_id, related_loginhistories_id);

		mav.addObject("worker_id", worker_id);
		mav.addObject("worker", worker);
		mav.setViewName("worker/viewWorker.jsp");

		return mav;
	}

	/**
	 * Create a new SystemUser entity
	 * 
	 */
	@RequestMapping("/newWorkerSystemUsers")
	public ModelAndView newWorkerSystemUsers(@RequestParam Integer worker_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("worker_id", worker_id);
		mav.addObject("systemuser", new SystemUser());
		mav.addObject("newFlag", true);
		mav.setViewName("worker/systemusers/editSystemUsers.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Worker entities
	 * 
	 */
	public String indexWorker() {
		return "redirect:/indexWorker";
	}
}