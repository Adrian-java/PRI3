<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.patient-resources"/>
<html>
<head>
<title>View <fmt:message key="patient.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="patient.title"/> Details</h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexPatient"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>	
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="patient.id.title"/>:
						</td>
						<td>
							${patient.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="patient.name.title"/>:
						</td>
						<td>
							${patient.name}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="patient.surname.title"/>:
						</td>
						<td>
							${patient.surname}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="patient.pesel.title"/>:
						</td>
						<td>
							${patient.pesel}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="patient.dateofbirth.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${patient.dateOfBirth.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="patient.email.title"/>:
						</td>
						<td>
							${patient.EMail}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="patient.phonenr.title"/>:
						</td>
						<td>
							${patient.phoneNr}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="patient.confirmed.title"/>:
						</td>
						<td>
							${patient.confirmed}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="address.title"/></h1>
					
						<c:if test='${patient.address != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="address.id.title"/>:
						</td>
						<td>
							${patient.address.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="address.city.title"/>:
						</td>
						<td>
							${patient.address.city}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="address.countrycode.title"/>:
						</td>
						<td>
							${patient.address.countryCode}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="address.province.title"/>:
						</td>
						<td>
							${patient.address.province}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="address.country.title"/>:
						</td>
						<td>
							${patient.address.country}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="address.countrycodecity.title"/>:
						</td>
						<td>
							${patient.address.countryCodeCity}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="address.homenr.title"/>:
						</td>
						<td>
							${patient.address.homeNr}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editPatientAddress?patient_id=${patient.id}&address_id=${patient.address.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeletePatientAddress?patient_id=${patient.id}&related_address_id=${patient.address.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${patient.address == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newPatientAddress?patient_id=${patient.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="address.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="patientcard.title"/></h1>
					
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newPatientPatientCards?patient_id=${patient.id}&"><span><img src="${pageContext.request.contextPath}/images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="patientcard.title"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<thead>
					<tr>
						<th class="thead">&nbsp;</th>
						<th class="thead"><fmt:message key="patientcard.id.title"/></th>
						<th class="thead"><fmt:message key="patientcard.registerdate.title"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${patient.patientCards}" var="current"  varStatus="i">	
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
							<a title="<fmt:message key="navigation.view" />" href="${pageContext.request.contextPath}/selectPatientPatientCards?patient_id=${patient.id}&patientcards_id=${current.id}&"><img src="images/icons/view.gif" /></a>
							<a title="<fmt:message key="navigation.edit" />" href="${pageContext.request.contextPath}/editPatientPatientCards?patient_id=${patient.id}&patientcards_id=${current.id}&"><img src="images/icons/edit.gif" /></a>
							<a title="<fmt:message key="navigation.delete" />" href="${pageContext.request.contextPath}/confirmDeletePatientPatientCards?patient_id=${patient.id}&related_patientcards_id=${current.id}&"><img src="images/icons/delete.gif" /></a>
						</td>
						<td>
							${current.id}
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${current.registerDate.time}"/>
						&nbsp;
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="recipe.title"/></h1>
					
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newPatientRecipes?patient_id=${patient.id}&"><span><img src="${pageContext.request.contextPath}/images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="recipe.title"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<thead>
					<tr>
						<th class="thead">&nbsp;</th>
						<th class="thead"><fmt:message key="recipe.idr.title"/></th>
						<th class="thead"><fmt:message key="recipe.date.title"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${patient.recipes}" var="current"  varStatus="i">	
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
							<a title="<fmt:message key="navigation.view" />" href="${pageContext.request.contextPath}/selectPatientRecipes?patient_id=${patient.id}&recipes_idr=${current.idr}&"><img src="images/icons/view.gif" /></a>
							<a title="<fmt:message key="navigation.edit" />" href="${pageContext.request.contextPath}/editPatientRecipes?patient_id=${patient.id}&recipes_idr=${current.idr}&"><img src="images/icons/edit.gif" /></a>
							<a title="<fmt:message key="navigation.delete" />" href="${pageContext.request.contextPath}/confirmDeletePatientRecipes?patient_id=${patient.id}&related_recipes_idr=${current.idr}&"><img src="images/icons/delete.gif" /></a>
						</td>
						<td>
							${current.idr}
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${current.date.time}"/>
						&nbsp;
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="worker.title"/></h1>
					
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newPatientWorkers?patient_id=${patient.id}&"><span><img src="${pageContext.request.contextPath}/images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="worker.title"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<thead>
					<tr>
						<th class="thead">&nbsp;</th>
						<th class="thead"><fmt:message key="worker.id.title"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${patient.workers}" var="current"  varStatus="i">	
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
							<a title="<fmt:message key="navigation.view" />" href="${pageContext.request.contextPath}/selectPatientWorkers?patient_id=${patient.id}&workers_id=${current.id}&"><img src="images/icons/view.gif" /></a>
							<a title="<fmt:message key="navigation.edit" />" href="${pageContext.request.contextPath}/editPatientWorkers?patient_id=${patient.id}&workers_id=${current.id}&"><img src="images/icons/edit.gif" /></a>
							<a title="<fmt:message key="navigation.delete" />" href="${pageContext.request.contextPath}/confirmDeletePatientWorkers?patient_id=${patient.id}&related_workers_id=${current.id}&"><img src="images/icons/delete.gif" /></a>
						</td>
						<td>
							${current.id}
						&nbsp;
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="sickleave.title"/></h1>
					
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newPatientSickLeaves?patient_id=${patient.id}&"><span><img src="${pageContext.request.contextPath}/images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="sickleave.title"/></span></a></div>
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
					<c:forEach items="${patient.sickLeaves}" var="current"  varStatus="i">	
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
							<a title="<fmt:message key="navigation.view" />" href="${pageContext.request.contextPath}/selectPatientSickLeaves?patient_id=${patient.id}&sickleaves_id=${current.id}&"><img src="images/icons/view.gif" /></a>
							<a title="<fmt:message key="navigation.edit" />" href="${pageContext.request.contextPath}/editPatientSickLeaves?patient_id=${patient.id}&sickleaves_id=${current.id}&"><img src="images/icons/edit.gif" /></a>
							<a title="<fmt:message key="navigation.delete" />" href="${pageContext.request.contextPath}/confirmDeletePatientSickLeaves?patient_id=${patient.id}&related_sickleaves_id=${current.id}&"><img src="images/icons/delete.gif" /></a>
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