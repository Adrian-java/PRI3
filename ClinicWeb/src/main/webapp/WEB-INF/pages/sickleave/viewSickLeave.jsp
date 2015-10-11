<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.sickleave-resources"/>
<html>
<head>
<title>View <fmt:message key="sickleave.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="sickleave.title"/> Details</h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexSickLeave"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>	
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="sickleave.id.title"/>:
						</td>
						<td>
							${sickleave.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="sickleave.datefrom.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${sickleave.dateFrom.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="sickleave.dateto.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${sickleave.dateTo.time}"/>
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="patient.title"/></h1>
					
						<c:if test='${sickleave.patient != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="patient.id.title"/>:
						</td>
						<td>
							${sickleave.patient.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.name.title"/>:
						</td>
						<td>
							${sickleave.patient.name}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.surname.title"/>:
						</td>
						<td>
							${sickleave.patient.surname}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.pesel.title"/>:
						</td>
						<td>
							${sickleave.patient.pesel}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.dateofbirth.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${sickleave.patient.dateOfBirth.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.email.title"/>:
						</td>
						<td>
							${sickleave.patient.EMail}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.phonenr.title"/>:
						</td>
						<td>
							${sickleave.patient.phoneNr}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.confirmed.title"/>:
						</td>
						<td>
							${sickleave.patient.confirmed}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editSickLeavePatient?sickleave_id=${sickleave.id}&patient_id=${sickleave.patient.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteSickLeavePatient?sickleave_id=${sickleave.id}&related_patient_id=${sickleave.patient.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${sickleave.patient == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newSickLeavePatient?sickleave_id=${sickleave.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="patient.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="visit.title"/></h1>
					
						<c:if test='${sickleave.visit != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="visit.id.title"/>:
						</td>
						<td>
							${sickleave.visit.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="visit.dateofvisit.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${sickleave.visit.dateOfVisit.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="visit.isleave.title"/>:
						</td>
						<td>
							${sickleave.visit.isLeave}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="visit.special.title"/>:
						</td>
						<td>
							${sickleave.visit.special}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editSickLeaveVisit?sickleave_id=${sickleave.id}&visit_id=${sickleave.visit.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteSickLeaveVisit?sickleave_id=${sickleave.id}&related_visit_id=${sickleave.visit.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${sickleave.visit == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newSickLeaveVisit?sickleave_id=${sickleave.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="visit.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="doctor.title"/></h1>
					
						<c:if test='${sickleave.doctor != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="doctor.id.title"/>:
						</td>
						<td>
							${sickleave.doctor.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="doctor.name.title"/>:
						</td>
						<td>
							${sickleave.doctor.name}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="doctor.surname.title"/>:
						</td>
						<td>
							${sickleave.doctor.surname}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editSickLeaveDoctor?sickleave_id=${sickleave.id}&doctor_id=${sickleave.doctor.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteSickLeaveDoctor?sickleave_id=${sickleave.id}&related_doctor_id=${sickleave.doctor.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${sickleave.doctor == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newSickLeaveDoctor?sickleave_id=${sickleave.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="doctor.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>