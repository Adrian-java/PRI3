<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.systemuser-resources"/>
<html>
<head>
<title>View <fmt:message key="systemuser.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="systemuser.title"/> Details</h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexSystemUser"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>	
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="systemuser.id.title"/>:
						</td>
						<td>
							${systemuser.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="systemuser.login.title"/>:
						</td>
						<td>
							${systemuser.login}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="systemuser.password.title"/>:
						</td>
						<td>
							${systemuser.password}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="systemuser.registerdate.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${systemuser.registerDate.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="systemuser.isactive.title"/>:
						</td>
						<td>
							${systemuser.isActive}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="systemuser.changedpassword.title"/>:
						</td>
						<td>
							${systemuser.changedPassword}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="systemuser.email.title"/>:
						</td>
						<td>
							${systemuser.email}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="systemuser.unregisterdate.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${systemuser.unregisterDate.time}"/>
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="worker.title"/></h1>
					
						<c:if test='${systemuser.worker != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="worker.id.title"/>:
						</td>
						<td>
							${systemuser.worker.id}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editSystemUserWorker?systemuser_id=${systemuser.id}&worker_id=${systemuser.worker.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteSystemUserWorker?systemuser_id=${systemuser.id}&related_worker_id=${systemuser.worker.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${systemuser.worker == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newSystemUserWorker?systemuser_id=${systemuser.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="worker.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="permission.title"/></h1>
					
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newSystemUserPermissions?systemuser_id=${systemuser.id}&"><span><img src="${pageContext.request.contextPath}/images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="permission.title"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<thead>
					<tr>
						<th class="thead">&nbsp;</th>
						<th class="thead"><fmt:message key="permission.id.title"/></th>
						<th class="thead"><fmt:message key="permission.display.title"/></th>
						<th class="thead"><fmt:message key="permission.edit.title"/></th>
						<th class="thead"><fmt:message key="permission.execute.title"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${systemuser.permissions}" var="current"  varStatus="i">	
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
							<a title="<fmt:message key="navigation.view" />" href="${pageContext.request.contextPath}/selectSystemUserPermissions?systemuser_id=${systemuser.id}&permissions_id=${current.id}&"><img src="images/icons/view.gif" /></a>
							<a title="<fmt:message key="navigation.edit" />" href="${pageContext.request.contextPath}/editSystemUserPermissions?systemuser_id=${systemuser.id}&permissions_id=${current.id}&"><img src="images/icons/edit.gif" /></a>
							<a title="<fmt:message key="navigation.delete" />" href="${pageContext.request.contextPath}/confirmDeleteSystemUserPermissions?systemuser_id=${systemuser.id}&related_permissions_id=${current.id}&"><img src="images/icons/delete.gif" /></a>
						</td>
						<td>
							${current.id}
						&nbsp;
						</td>
						<td>
							${current.display}
						&nbsp;
						</td>
						<td>
							${current.edit}
						&nbsp;
						</td>
						<td>
							${current.execute}
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