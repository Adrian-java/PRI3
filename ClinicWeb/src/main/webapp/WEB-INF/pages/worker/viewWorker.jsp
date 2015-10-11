<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.worker-resources"/>
<html>
<head>
<title>View <fmt:message key="worker.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="worker.title"/> Details</h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexWorker"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>	
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="worker.id.title"/>:
						</td>
						<td>
							${worker.id}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="patient.title"/></h1>
					
						<c:if test='${worker.patient != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="patient.id.title"/>:
						</td>
						<td>
							${worker.patient.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.name.title"/>:
						</td>
						<td>
							${worker.patient.name}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.surname.title"/>:
						</td>
						<td>
							${worker.patient.surname}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.pesel.title"/>:
						</td>
						<td>
							${worker.patient.pesel}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.dateofbirth.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${worker.patient.dateOfBirth.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.email.title"/>:
						</td>
						<td>
							${worker.patient.EMail}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.phonenr.title"/>:
						</td>
						<td>
							${worker.patient.phoneNr}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.confirmed.title"/>:
						</td>
						<td>
							${worker.patient.confirmed}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editWorkerPatient?worker_id=${worker.id}&patient_id=${worker.patient.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteWorkerPatient?worker_id=${worker.id}&related_patient_id=${worker.patient.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${worker.patient == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newWorkerPatient?worker_id=${worker.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="patient.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="admin.title"/></h1>
					
						<c:if test='${worker.admin != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="admin.id.title"/>:
						</td>
						<td>
							${worker.admin.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="admin.issuper.title"/>:
						</td>
						<td>
							${worker.admin.isSuper}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editWorkerAdmin?worker_id=${worker.id}&admin_id=${worker.admin.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteWorkerAdmin?worker_id=${worker.id}&related_admin_id=${worker.admin.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${worker.admin == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newWorkerAdmin?worker_id=${worker.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="admin.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="receptionist.title"/></h1>
					
						<c:if test='${worker.receptionist != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="receptionist.id.title"/>:
						</td>
						<td>
							${worker.receptionist.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="receptionist.name.title"/>:
						</td>
						<td>
							${worker.receptionist.name}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="receptionist.surname.title"/>:
						</td>
						<td>
							${worker.receptionist.surname}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="receptionist.phonenr.title"/>:
						</td>
						<td>
							${worker.receptionist.phoneNr}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editWorkerReceptionist?worker_id=${worker.id}&receptionist_id=${worker.receptionist.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteWorkerReceptionist?worker_id=${worker.id}&related_receptionist_id=${worker.receptionist.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${worker.receptionist == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newWorkerReceptionist?worker_id=${worker.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="receptionist.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="doctor.title"/></h1>
					
						<c:if test='${worker.doctor != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="doctor.id.title"/>:
						</td>
						<td>
							${worker.doctor.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="doctor.name.title"/>:
						</td>
						<td>
							${worker.doctor.name}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="doctor.surname.title"/>:
						</td>
						<td>
							${worker.doctor.surname}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editWorkerDoctor?worker_id=${worker.id}&doctor_id=${worker.doctor.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteWorkerDoctor?worker_id=${worker.id}&related_doctor_id=${worker.doctor.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${worker.doctor == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newWorkerDoctor?worker_id=${worker.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="doctor.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="loginhistory.title"/></h1>
					
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newWorkerLoginHistories?worker_id=${worker.id}&"><span><img src="${pageContext.request.contextPath}/images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="loginhistory.title"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<thead>
					<tr>
						<th class="thead">&nbsp;</th>
						<th class="thead"><fmt:message key="loginhistory.id.title"/></th>
						<th class="thead"><fmt:message key="loginhistory.datelogin.title"/></th>
						<th class="thead"><fmt:message key="loginhistory.sessionnumber.title"/></th>
						<th class="thead"><fmt:message key="loginhistory.datelogout.title"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${worker.loginHistories}" var="current"  varStatus="i">	
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
							<a title="<fmt:message key="navigation.view" />" href="${pageContext.request.contextPath}/selectWorkerLoginHistories?worker_id=${worker.id}&loginhistories_id=${current.id}&"><img src="images/icons/view.gif" /></a>
							<a title="<fmt:message key="navigation.edit" />" href="${pageContext.request.contextPath}/editWorkerLoginHistories?worker_id=${worker.id}&loginhistories_id=${current.id}&"><img src="images/icons/edit.gif" /></a>
							<a title="<fmt:message key="navigation.delete" />" href="${pageContext.request.contextPath}/confirmDeleteWorkerLoginHistories?worker_id=${worker.id}&related_loginhistories_id=${current.id}&"><img src="images/icons/delete.gif" /></a>
						</td>
						<td>
							${current.id}
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${current.dateLogin.time}"/>
						&nbsp;
						</td>
						<td>
							${current.sessionNumber}
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${current.dateLogout.time}"/>
						&nbsp;
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="systemuser.title"/></h1>
					
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newWorkerSystemUsers?worker_id=${worker.id}&"><span><img src="${pageContext.request.contextPath}/images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="systemuser.title"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<thead>
					<tr>
						<th class="thead">&nbsp;</th>
						<th class="thead"><fmt:message key="systemuser.id.title"/></th>
						<th class="thead"><fmt:message key="systemuser.login.title"/></th>
						<th class="thead"><fmt:message key="systemuser.password.title"/></th>
						<th class="thead"><fmt:message key="systemuser.registerdate.title"/></th>
						<th class="thead"><fmt:message key="systemuser.isactive.title"/></th>
						<th class="thead"><fmt:message key="systemuser.changedpassword.title"/></th>
						<th class="thead"><fmt:message key="systemuser.email.title"/></th>
						<th class="thead"><fmt:message key="systemuser.unregisterdate.title"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${worker.systemUsers}" var="current"  varStatus="i">	
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
							<a title="<fmt:message key="navigation.view" />" href="${pageContext.request.contextPath}/selectWorkerSystemUsers?worker_id=${worker.id}&systemusers_id=${current.id}&"><img src="images/icons/view.gif" /></a>
							<a title="<fmt:message key="navigation.edit" />" href="${pageContext.request.contextPath}/editWorkerSystemUsers?worker_id=${worker.id}&systemusers_id=${current.id}&"><img src="images/icons/edit.gif" /></a>
							<a title="<fmt:message key="navigation.delete" />" href="${pageContext.request.contextPath}/confirmDeleteWorkerSystemUsers?worker_id=${worker.id}&related_systemusers_id=${current.id}&"><img src="images/icons/delete.gif" /></a>
						</td>
						<td>
							${current.id}
						&nbsp;
						</td>
						<td>
							${current.login}
						&nbsp;
						</td>
						<td>
							${current.password}
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${current.registerDate.time}"/>
						&nbsp;
						</td>
						<td>
							${current.isActive}
						&nbsp;
						</td>
						<td>
							${current.changedPassword}
						&nbsp;
						</td>
						<td>
							${current.email}
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${current.unregisterDate.time}"/>
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