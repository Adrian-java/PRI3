<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.permission-resources"/>
<html>
<head>
<title>View <fmt:message key="permission.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="permission.title"/> Details</h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexPermission"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>	
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="permission.id.title"/>:
						</td>
						<td>
							${permission.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="permission.display.title"/>:
						</td>
						<td>
							${permission.display}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="permission.edit.title"/>:
						</td>
						<td>
							${permission.edit}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="permission.execute.title"/>:
						</td>
						<td>
							${permission.execute}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="systemuser.title"/></h1>
					
						<c:if test='${permission.systemUser != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="systemuser.id.title"/>:
						</td>
						<td>
							${permission.systemUser.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="systemuser.login.title"/>:
						</td>
						<td>
							${permission.systemUser.login}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="systemuser.password.title"/>:
						</td>
						<td>
							${permission.systemUser.password}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="systemuser.registerdate.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${permission.systemUser.registerDate.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="systemuser.isactive.title"/>:
						</td>
						<td>
							${permission.systemUser.isActive}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="systemuser.changedpassword.title"/>:
						</td>
						<td>
							${permission.systemUser.changedPassword}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="systemuser.email.title"/>:
						</td>
						<td>
							${permission.systemUser.email}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="systemuser.unregisterdate.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${permission.systemUser.unregisterDate.time}"/>
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editPermissionSystemUser?permission_id=${permission.id}&systemuser_id=${permission.systemUser.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeletePermissionSystemUser?permission_id=${permission.id}&related_systemuser_id=${permission.systemUser.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${permission.systemUser == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newPermissionSystemUser?permission_id=${permission.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="systemuser.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="module.title"/></h1>
					
						<c:if test='${permission.module != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="module.id.title"/>:
						</td>
						<td>
							${permission.module.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="module.name.title"/>:
						</td>
						<td>
							${permission.module.name}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="module.visibility.title"/>:
						</td>
						<td>
							${permission.module.visibility}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editPermissionModule?permission_id=${permission.id}&module_id=${permission.module.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeletePermissionModule?permission_id=${permission.id}&related_module_id=${permission.module.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${permission.module == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newPermissionModule?permission_id=${permission.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="module.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="typeofuser.title"/></h1>
					
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newPermissionTypeOfUsers?permission_id=${permission.id}&"><span><img src="${pageContext.request.contextPath}/images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="typeofuser.title"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<thead>
					<tr>
						<th class="thead">&nbsp;</th>
						<th class="thead"><fmt:message key="typeofuser.id.title"/></th>
						<th class="thead"><fmt:message key="typeofuser.type.title"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${permission.typeOfUsers}" var="current"  varStatus="i">	
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
							<a title="<fmt:message key="navigation.view" />" href="${pageContext.request.contextPath}/selectPermissionTypeOfUsers?permission_id=${permission.id}&typeofusers_id=${current.id}&"><img src="images/icons/view.gif" /></a>
							<a title="<fmt:message key="navigation.edit" />" href="${pageContext.request.contextPath}/editPermissionTypeOfUsers?permission_id=${permission.id}&typeofusers_id=${current.id}&"><img src="images/icons/edit.gif" /></a>
							<a title="<fmt:message key="navigation.delete" />" href="${pageContext.request.contextPath}/confirmDeletePermissionTypeOfUsers?permission_id=${permission.id}&related_typeofusers_id=${current.id}&"><img src="images/icons/delete.gif" /></a>
						</td>
						<td>
							${current.id}
						&nbsp;
						</td>
						<td>
							${current.type}
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