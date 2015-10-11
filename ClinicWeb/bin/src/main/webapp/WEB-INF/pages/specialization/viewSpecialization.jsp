<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.specialization-resources"/>
<html>
<head>
<title>View <fmt:message key="specialization.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="specialization.title"/> Details</h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexSpecialization"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>	
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="specialization.id.title"/>:
						</td>
						<td>
							${specialization.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="specialization.name.title"/>:
						</td>
						<td>
							${specialization.name}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="doctor.title"/></h1>
					
						<c:if test='${specialization.doctor != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="doctor.id.title"/>:
						</td>
						<td>
							${specialization.doctor.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="doctor.name.title"/>:
						</td>
						<td>
							${specialization.doctor.name}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="doctor.surname.title"/>:
						</td>
						<td>
							${specialization.doctor.surname}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editSpecializationDoctor?specialization_id=${specialization.id}&doctor_id=${specialization.doctor.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteSpecializationDoctor?specialization_id=${specialization.id}&related_doctor_id=${specialization.doctor.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${specialization.doctor == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newSpecializationDoctor?specialization_id=${specialization.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="doctor.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="specalvisitfield.title"/></h1>
					
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newSpecializationSpecalVisitFields?specialization_id=${specialization.id}&"><span><img src="${pageContext.request.contextPath}/images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="specalvisitfield.title"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<thead>
					<tr>
						<th class="thead">&nbsp;</th>
						<th class="thead"><fmt:message key="specalvisitfield.id.title"/></th>
						<th class="thead"><fmt:message key="specalvisitfield.name.title"/></th>
						<th class="thead"><fmt:message key="specalvisitfield.value.title"/></th>
						<th class="thead"><fmt:message key="specalvisitfield.typeofvalue.title"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${specialization.specalVisitFields}" var="current"  varStatus="i">	
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
							<a title="<fmt:message key="navigation.view" />" href="${pageContext.request.contextPath}/selectSpecializationSpecalVisitFields?specialization_id=${specialization.id}&specalvisitfields_id=${current.id}&"><img src="images/icons/view.gif" /></a>
							<a title="<fmt:message key="navigation.edit" />" href="${pageContext.request.contextPath}/editSpecializationSpecalVisitFields?specialization_id=${specialization.id}&specalvisitfields_id=${current.id}&"><img src="images/icons/edit.gif" /></a>
							<a title="<fmt:message key="navigation.delete" />" href="${pageContext.request.contextPath}/confirmDeleteSpecializationSpecalVisitFields?specialization_id=${specialization.id}&related_specalvisitfields_id=${current.id}&"><img src="images/icons/delete.gif" /></a>
						</td>
						<td>
							${current.id}
						&nbsp;
						</td>
						<td>
							${current.name}
						&nbsp;
						</td>
						<td>
							${current.value}
						&nbsp;
						</td>
						<td>
							${current.typeOfValue}
						&nbsp;
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="visitscheduler.title"/></h1>
					
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newSpecializationVisitSchedulers?specialization_id=${specialization.id}&"><span><img src="${pageContext.request.contextPath}/images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="visitscheduler.title"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<thead>
					<tr>
						<th class="thead">&nbsp;</th>
						<th class="thead"><fmt:message key="visitscheduler.id.title"/></th>
						<th class="thead"><fmt:message key="visitscheduler.numberofday.title"/></th>
						<th class="thead"><fmt:message key="visitscheduler.numberofmonth.title"/></th>
						<th class="thead"><fmt:message key="visitscheduler.timeofvisit.title"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${specialization.visitSchedulers}" var="current"  varStatus="i">	
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
							<a title="<fmt:message key="navigation.view" />" href="${pageContext.request.contextPath}/selectSpecializationVisitSchedulers?specialization_id=${specialization.id}&visitschedulers_id=${current.id}&"><img src="images/icons/view.gif" /></a>
							<a title="<fmt:message key="navigation.edit" />" href="${pageContext.request.contextPath}/editSpecializationVisitSchedulers?specialization_id=${specialization.id}&visitschedulers_id=${current.id}&"><img src="images/icons/edit.gif" /></a>
							<a title="<fmt:message key="navigation.delete" />" href="${pageContext.request.contextPath}/confirmDeleteSpecializationVisitSchedulers?specialization_id=${specialization.id}&related_visitschedulers_id=${current.id}&"><img src="images/icons/delete.gif" /></a>
						</td>
						<td>
							${current.id}
						&nbsp;
						</td>
						<td>
							${current.numberOfDay}
						&nbsp;
						</td>
						<td>
							${current.numberOfMonth}
						&nbsp;
						</td>
						<td>
							<fmt:formatDate timeStyle="short" type="time" value="${current.timeOfVisit.time}"/>
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