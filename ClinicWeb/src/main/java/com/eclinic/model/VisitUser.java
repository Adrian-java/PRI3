package com.eclinic.model;

import com.eclinic.domain.SystemUser;
import com.eclinic.domain.Visit;

public class VisitUser {

	private SystemUser systemUser;
	
	private Visit visit;

	public SystemUser getSystemUser() {
		return systemUser;
	}

	public void setSystemUser(SystemUser systemUser) {
		this.systemUser = systemUser;
	}

	public Visit getVisit() {
		return visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}
	
}
