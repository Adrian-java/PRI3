<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.worker-resources"/>
<html>
<head>
<title>View <fmt:message key="worker.title"/> <fmt:message key="loginhistory.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="navigation.view"/> <fmt:message key="loginhistory.title"/></h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectWorker?idKey=${worker_id}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
		
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
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
