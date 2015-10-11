<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.visit-resources"/>
<html>
<head>
<title>View <fmt:message key="visit.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="visit.title"/> Details</h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexVisit"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>	
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="visit.id.title"/>:
						</td>
						<td>
							${visit.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="visit.dateofvisit.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${visit.dateOfVisit.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="visit.isleave.title"/>:
						</td>
						<td>
							${visit.isLeave}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="visit.special.title"/>:
						</td>
						<td>
							${visit.special}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="patientcard.title"/></h1>
					
						<c:if test='${visit.patientCard != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="patientcard.id.title"/>:
						</td>
						<td>
							${visit.patientCard.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patientcard.registerdate.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${visit.patientCard.registerDate.time}"/>
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editVisitPatientCard?visit_id=${visit.id}&patientcard_id=${visit.patientCard.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteVisitPatientCard?visit_id=${visit.id}&related_patientcard_id=${visit.patientCard.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${visit.patientCard == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newVisitPatientCard?visit_id=${visit.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="patientcard.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="typeofvisit.title"/></h1>
					
						<c:if test='${visit.typeOfVisit != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="typeofvisit.id.title"/>:
						</td>
						<td>
							${visit.typeOfVisit.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="typeofvisit.name.title"/>:
						</td>
						<td>
							${visit.typeOfVisit.name}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="typeofvisit.duration.title"/>:
						</td>
						<td>
							${visit.typeOfVisit.duration}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editVisitTypeOfVisit?visit_id=${visit.id}&typeofvisit_id=${visit.typeOfVisit.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteVisitTypeOfVisit?visit_id=${visit.id}&related_typeofvisit_id=${visit.typeOfVisit.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${visit.typeOfVisit == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newVisitTypeOfVisit?visit_id=${visit.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="typeofvisit.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="receptionist.title"/></h1>
					
						<c:if test='${visit.receptionist != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="receptionist.id.title"/>:
						</td>
						<td>
							${visit.receptionist.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="receptionist.name.title"/>:
						</td>
						<td>
							${visit.receptionist.name}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="receptionist.surname.title"/>:
						</td>
						<td>
							${visit.receptionist.surname}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="receptionist.phonenr.title"/>:
						</td>
						<td>
							${visit.receptionist.phoneNr}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editVisitReceptionist?visit_id=${visit.id}&receptionist_id=${visit.receptionist.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteVisitReceptionist?visit_id=${visit.id}&related_receptionist_id=${visit.receptionist.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${visit.receptionist == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newVisitReceptionist?visit_id=${visit.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="receptionist.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="statusofvisit.title"/></h1>
					
						<c:if test='${visit.statusOfVisit != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="statusofvisit.id.title"/>:
						</td>
						<td>
							${visit.statusOfVisit.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="statusofvisit.type.title"/>:
						</td>
						<td>
							${visit.statusOfVisit.type}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editVisitStatusOfVisit?visit_id=${visit.id}&statusofvisit_id=${visit.statusOfVisit.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteVisitStatusOfVisit?visit_id=${visit.id}&related_statusofvisit_id=${visit.statusOfVisit.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${visit.statusOfVisit == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newVisitStatusOfVisit?visit_id=${visit.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="statusofvisit.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="doctor.title"/></h1>
					
						<c:if test='${visit.doctor != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="doctor.id.title"/>:
						</td>
						<td>
							${visit.doctor.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="doctor.name.title"/>:
						</td>
						<td>
							${visit.doctor.name}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="doctor.surname.title"/>:
						</td>
						<td>
							${visit.doctor.surname}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editVisitDoctor?visit_id=${visit.id}&doctor_id=${visit.doctor.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteVisitDoctor?visit_id=${visit.id}&related_doctor_id=${visit.doctor.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${visit.doctor == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newVisitDoctor?visit_id=${visit.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="doctor.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="sickleave.title"/></h1>
					
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newVisitSickLeaves?visit_id=${visit.id}&"><span><img src="${pageContext.request.contextPath}/images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="sickleave.title"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<thead>
					<tr>
						<th class="thead">&nbsp;</th>
						<th class="thead"><fmt:message key="sickleave.id.title"/></th>
						<th class="thead"><fmt:message key="sickleave.datefrom.title"/></th>
						<th class="thead"><fmt:message key="sickleave.dateto.title"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${visit.sickLeaves}" var="current"  varStatus="i">	
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
							<a title="<fmt:message key="navigation.view" />" href="${pageContext.request.contextPath}/selectVisitSickLeaves?visit_id=${visit.id}&sickleaves_id=${current.id}&"><img src="images/icons/view.gif" /></a>
							<a title="<fmt:message key="navigation.edit" />" href="${pageContext.request.contextPath}/editVisitSickLeaves?visit_id=${visit.id}&sickleaves_id=${current.id}&"><img src="images/icons/edit.gif" /></a>
							<a title="<fmt:message key="navigation.delete" />" href="${pageContext.request.contextPath}/confirmDeleteVisitSickLeaves?visit_id=${visit.id}&related_sickleaves_id=${current.id}&"><img src="images/icons/delete.gif" /></a>
						</td>
						<td>
							${current.id}
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${current.dateFrom.time}"/>
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${current.dateTo.time}"/>
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