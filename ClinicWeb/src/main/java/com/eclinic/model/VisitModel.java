package com.eclinic.model;

import java.util.Calendar;
import java.util.Date;

public class VisitModel {

	private Calendar dateOfVisit;

	private String descriptionOfVisit;

	private boolean isLeave;

	private boolean special;

	private String doctorLogin;

	private String statusOfVisit;

	private String recepcionistLogin;

	private String typeOfVisit;

	private String patientPesel;

	public Calendar getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(Calendar dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public String getDescriptionOfVisit() {
		return descriptionOfVisit;
	}

	public void setDescriptionOfVisit(String descriptionOfVisit) {
		this.descriptionOfVisit = descriptionOfVisit;
	}

	public boolean getIsLeave() {
		return isLeave;
	}

	public void setIsLeave(boolean isLeave) {
		this.isLeave = isLeave;
	}

	public boolean getSpecial() {
		return special;
	}

	public void setSpecial(boolean special) {
		this.special = special;
	}

	public String getDoctorLogin() {
		return doctorLogin;
	}

	public void setDoctorLogin(String doctorLogin) {
		this.doctorLogin = doctorLogin;
	}

	public String getStatusOfVisit() {
		return statusOfVisit;
	}

	public void setStatusOfVisit(String statusOfVisit) {
		this.statusOfVisit = statusOfVisit;
	}

	public String getRecepcionistLogin() {
		return recepcionistLogin;
	}

	public void setRecepcionistLogin(String recepcionistLogin) {
		this.recepcionistLogin = recepcionistLogin;
	}

	public String getTypeOfVisit() {
		return typeOfVisit;
	}

	public void setTypeOfVisit(String typeOfVisit) {
		this.typeOfVisit = typeOfVisit;
	}

	public String getPatientPesel() {
		return patientPesel;
	}

	public void setPatientPesel(String patientPesel) {
		this.patientPesel = patientPesel;
	}
	
	

}
