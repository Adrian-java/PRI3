<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.visit-resources"/>
<html>
<head>
<title>View <fmt:message key="visit.title"/> <fmt:message key="sickleave.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="navigation.view"/> <fmt:message key="sickleave.title"/></h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectVisit?idKey=${visit_id}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="sickleave.id.title"/>:
						</td>
						<td>
							${sickleave.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="sickleave.datefrom.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${sickleave.dateFrom.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="sickleave.dateto.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${sickleave.dateTo.time}"/>
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/deleteVisitSickLeaves?visit_id=${visit_id}&related_sickleaves_id=${sickleave.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
