<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.specialization-resources"/>
<html>
<head>
<title>View <fmt:message key="specialization.title"/> <fmt:message key="specalvisitfield.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="navigation.view"/> <fmt:message key="specalvisitfield.title"/></h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectSpecialization?idKey=${specialization_id}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
		
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="specalvisitfield.id.title"/>:
						</td>
						<td>
							${specalvisitfield.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="specalvisitfield.name.title"/>:
						</td>
						<td>
							${specalvisitfield.name}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="specalvisitfield.value.title"/>:
						</td>
						<td>
							${specalvisitfield.value}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="specalvisitfield.typeofvalue.title"/>:
						</td>
						<td>
							${specalvisitfield.typeOfValue}
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
