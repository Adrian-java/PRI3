<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.visit-resources"/>
<html>
<head>
<title>View <fmt:message key="visit.title"/> <fmt:message key="receptionist.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="navigation.view"/> <fmt:message key="receptionist.title"/></h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectVisit?idKey=${visit_id}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
		
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="receptionist.id.title"/>:
						</td>
						<td>
							${receptionist.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="receptionist.name.title"/>:
						</td>
						<td>
							${receptionist.name}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="receptionist.surname.title"/>:
						</td>
						<td>
							${receptionist.surname}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="receptionist.phonenr.title"/>:
						</td>
						<td>
							${receptionist.phoneNr}
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
