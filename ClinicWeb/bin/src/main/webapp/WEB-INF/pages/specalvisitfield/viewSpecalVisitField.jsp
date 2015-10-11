<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.specalvisitfield-resources"/>
<html>
<head>
<title>View <fmt:message key="specalvisitfield.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="specalvisitfield.title"/> Details</h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexSpecalVisitField"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>	
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
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="specialization.title"/></h1>
					
						<c:if test='${specalvisitfield.specialization != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="specialization.id.title"/>:
						</td>
						<td>
							${specalvisitfield.specialization.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="specialization.name.title"/>:
						</td>
						<td>
							${specalvisitfield.specialization.name}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editSpecalVisitFieldSpecialization?specalvisitfield_id=${specalvisitfield.id}&specialization_id=${specalvisitfield.specialization.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteSpecalVisitFieldSpecialization?specalvisitfield_id=${specalvisitfield.id}&related_specialization_id=${specalvisitfield.specialization.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${specalvisitfield.specialization == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newSpecalVisitFieldSpecialization?specalvisitfield_id=${specalvisitfield.id}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="specialization.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>