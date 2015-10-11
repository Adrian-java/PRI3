<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.typeofuser-resources"/>
<html>
<head>
<title>View <fmt:message key="typeofuser.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="typeofuser.title"/> Details</h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexTypeOfUser"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>	
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="typeofuser.id.title"/>:
						</td>
						<td>
							${typeofuser.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="typeofuser.type.title"/>:
						</td>
						<td>
							${typeofuser.type}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="permission.title"/></h1>
					
						<c:if test='${typeofuser.permission != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="permission.id.title"/>:
						</td>
						<td>
							${typeofuser.permission.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="permission.display.title"/>:
						</td>
						<td>
							${typeofuser.permission.display}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="permission.edit.title"/>:
						</td>
						<td>
							${typeofuser.permission.edit}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="permission.execute.title"/>:
						</td>
						<td>
							${typeofuser.permission.execute}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editTypeOfUserPermission?typeofuser_id=${typeofuser.id}&permission_id=${typeofuser.permission.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteTypeOfUserPermission?typeofuser_id=${typeofuser.id}&related_permission_id=${typeofuser.permission.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${typeofuser.permission == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newTypeOfUserPermission?typeofuser_id=${typeofuser.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="permission.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>