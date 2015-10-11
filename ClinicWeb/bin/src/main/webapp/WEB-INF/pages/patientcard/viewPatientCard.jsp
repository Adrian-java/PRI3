<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.patientcard-resources"/>
<html>
<head>
<title>View <fmt:message key="patientcard.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="patientcard.title"/> Details</h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexPatientCard"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>	
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="patientcard.id.title"/>:
						</td>
						<td>
							${patientcard.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="patientcard.registerdate.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${patientcard.registerDate.time}"/>
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="patient.title"/></h1>
					
						<c:if test='${patientcard.patient != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="patient.id.title"/>:
						</td>
						<td>
							${patientcard.patient.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.name.title"/>:
						</td>
						<td>
							${patientcard.patient.name}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.surname.title"/>:
						</td>
						<td>
							${patientcard.patient.surname}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.pesel.title"/>:
						</td>
						<td>
							${patientcard.patient.pesel}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.dateofbirth.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${patientcard.patient.dateOfBirth.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.email.title"/>:
						</td>
						<td>
							${patientcard.patient.EMail}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.phonenr.title"/>:
						</td>
						<td>
							${patientcard.patient.phoneNr}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.confirmed.title"/>:
						</td>
						<td>
							${patientcard.patient.confirmed}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editPatientCardPatient?patientcard_id=${patientcard.id}&patient_id=${patientcard.patient.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeletePatientCardPatient?patientcard_id=${patientcard.id}&related_patient_id=${patientcard.patient.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${patientcard.patient == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newPatientCardPatient?patientcard_id=${patientcard.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="patient.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="doctor.title"/></h1>
					
						<c:if test='${patientcard.doctor != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="doctor.id.title"/>:
						</td>
						<td>
							${patientcard.doctor.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="doctor.name.title"/>:
						</td>
						<td>
							${patientcard.doctor.name}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="doctor.surname.title"/>:
						</td>
						<td>
							${patientcard.doctor.surname}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editPatientCardDoctor?patientcard_id=${patientcard.id}&doctor_id=${patientcard.doctor.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeletePatientCardDoctor?patientcard_id=${patientcard.id}&related_doctor_id=${patientcard.doctor.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${patientcard.doctor == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newPatientCardDoctor?patientcard_id=${patientcard.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="doctor.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="visit.title"/></h1>
					
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newPatientCardVisits?patientcard_id=${patientcard.id}&"><span><img src="${pageContext.request.contextPath}/images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="visit.title"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<thead>
					<tr>
						<th class="thead">&nbsp;</th>
						<th class="thead"><fmt:message key="visit.id.title"/></th>
						<th class="thead"><fmt:message key="visit.dateofvisit.title"/></th>
						<th class="thead"><fmt:message key="visit.isleave.title"/></th>
						<th class="thead"><fmt:message key="visit.special.title"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${patientcard.visits}" var="current"  varStatus="i">	
						<c:choose>
							<c:when test="${(i.count) % 2 == 0}">
					    		<c:set var="rowclass" value="rowtwo"/>
							</c:when>
							<c:otherwise>
					    		<c:set var="rowclass" value="rowone"/>
							</c:otherwise>
						</c:choose>
					<tr class="${rowclass}">
						<td nowrap="nowrap">
							<a title="<fmt:message key="navigation.view" />" href="${pageContext.request.contextPath}/selectPatientCardVisits?patientcard_id=${patientcard.id}&visits_id=${current.id}&"><img src="images/icons/view.gif" /></a>
							<a title="<fmt:message key="navigation.edit" />" href="${pageContext.request.contextPath}/editPatientCardVisits?patientcard_id=${patientcard.id}&visits_id=${current.id}&"><img src="images/icons/edit.gif" /></a>
							<a title="<fmt:message key="navigation.delete" />" href="${pageContext.request.contextPath}/confirmDeletePatientCardVisits?patientcard_id=${patientcard.id}&related_visits_id=${current.id}&"><img src="images/icons/delete.gif" /></a>
						</td>
						<td>
							${current.id}
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${current.dateOfVisit.time}"/>
						&nbsp;
						</td>
						<td>
							${current.isLeave}
						&nbsp;
						</td>
						<td>
							${current.special}
						&nbsp;
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>