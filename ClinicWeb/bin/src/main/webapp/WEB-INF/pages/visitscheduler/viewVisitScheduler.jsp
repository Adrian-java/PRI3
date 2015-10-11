<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.visitscheduler-resources"/>
<html>
<head>
<title>View <fmt:message key="visitscheduler.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="visitscheduler.title"/> Details</h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexVisitScheduler"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>	
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="visitscheduler.id.title"/>:
						</td>
						<td>
							${visitscheduler.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="visitscheduler.numberofday.title"/>:
						</td>
						<td>
							${visitscheduler.numberOfDay}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="visitscheduler.numberofmonth.title"/>:
						</td>
						<td>
							${visitscheduler.numberOfMonth}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="visitscheduler.timeofvisit.title"/>:
						</td>
						<td>
							<fmt:formatDate timeStyle="short" type="time" value="${visitscheduler.timeOfVisit.time}"/>
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="specialization.title"/></h1>
					
						<c:if test='${visitscheduler.specialization != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="specialization.id.title"/>:
						</td>
						<td>
							${visitscheduler.specialization.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="specialization.name.title"/>:
						</td>
						<td>
							${visitscheduler.specialization.name}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editVisitSchedulerSpecialization?visitscheduler_id=${visitscheduler.id}&specialization_id=${visitscheduler.specialization.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteVisitSchedulerSpecialization?visitscheduler_id=${visitscheduler.id}&related_specialization_id=${visitscheduler.specialization.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${visitscheduler.specialization == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newVisitSchedulerSpecialization?visitscheduler_id=${visitscheduler.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="specialization.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="doctor.title"/></h1>
					
						<c:if test='${visitscheduler.doctor != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="doctor.id.title"/>:
						</td>
						<td>
							${visitscheduler.doctor.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="doctor.name.title"/>:
						</td>
						<td>
							${visitscheduler.doctor.name}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="doctor.surname.title"/>:
						</td>
						<td>
							${visitscheduler.doctor.surname}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editVisitSchedulerDoctor?visitscheduler_id=${visitscheduler.id}&doctor_id=${visitscheduler.doctor.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteVisitSchedulerDoctor?visitscheduler_id=${visitscheduler.id}&related_doctor_id=${visitscheduler.doctor.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${visitscheduler.doctor == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newVisitSchedulerDoctor?visitscheduler_id=${visitscheduler.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="doctor.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>