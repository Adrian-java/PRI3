<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.loginhistory-resources"/>
<html>
<head>
<title>View <fmt:message key="loginhistory.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="loginhistory.title"/> Details</h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexLoginHistory"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>	
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="loginhistory.id.title"/>:
						</td>
						<td>
							${loginhistory.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="loginhistory.datelogin.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${loginhistory.dateLogin.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="loginhistory.sessionnumber.title"/>:
						</td>
						<td>
							${loginhistory.sessionNumber}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="loginhistory.datelogout.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${loginhistory.dateLogout.time}"/>
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="worker.title"/></h1>
					
						<c:if test='${loginhistory.worker != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="worker.id.title"/>:
						</td>
						<td>
							${loginhistory.worker.id}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editLoginHistoryWorker?loginhistory_id=${loginhistory.id}&worker_id=${loginhistory.worker.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteLoginHistoryWorker?loginhistory_id=${loginhistory.id}&related_worker_id=${loginhistory.worker.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${loginhistory.worker == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newLoginHistoryWorker?loginhistory_id=${loginhistory.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="worker.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>