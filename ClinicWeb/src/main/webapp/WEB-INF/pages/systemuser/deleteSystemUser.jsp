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
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/deleteSystemUser?idKey=${systemuser.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>