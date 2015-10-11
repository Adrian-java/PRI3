<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.recipe-resources"/>
<html>
<head>
<title>View <fmt:message key="recipe.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="recipe.title"/> Details</h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexRecipe"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>	
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recipe.idr.title"/>:
						</td>
						<td>
							${recipe.idr}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="recipe.date.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${recipe.date.time}"/>
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="patient.title"/></h1>
					
						<c:if test='${recipe.patient != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="patient.id.title"/>:
						</td>
						<td>
							${recipe.patient.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.name.title"/>:
						</td>
						<td>
							${recipe.patient.name}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.surname.title"/>:
						</td>
						<td>
							${recipe.patient.surname}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.pesel.title"/>:
						</td>
						<td>
							${recipe.patient.pesel}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.dateofbirth.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${recipe.patient.dateOfBirth.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.email.title"/>:
						</td>
						<td>
							${recipe.patient.EMail}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.phonenr.title"/>:
						</td>
						<td>
							${recipe.patient.phoneNr}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="patient.confirmed.title"/>:
						</td>
						<td>
							${recipe.patient.confirmed}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editRecipePatient?recipe_idr=${recipe.idr}&patient_id=${recipe.patient.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteRecipePatient?recipe_idr=${recipe.idr}&related_patient_id=${recipe.patient.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${recipe.patient == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newRecipePatient?recipe_idr=${recipe.idr}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="patient.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="doctor.title"/></h1>
					
						<c:if test='${recipe.doctor != null}'>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td  class="label">
							<fmt:message key="doctor.id.title"/>:
						</td>
						<td>
							${recipe.doctor.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="doctor.name.title"/>:
						</td>
						<td>
							${recipe.doctor.name}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td  class="label">
							<fmt:message key="doctor.surname.title"/>:
						</td>
						<td>
							${recipe.doctor.surname}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/editRecipeDoctor?recipe_idr=${recipe.idr}&doctor_id=${recipe.doctor.id}&"><span><img src="images/icons/edit.gif" /><fmt:message key="navigation.edit"/></span></a></div>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/confirmDeleteRecipeDoctor?recipe_idr=${recipe.idr}&related_doctor_id=${recipe.doctor.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
						</c:if>
						<c:if test='${recipe.doctor == null}'>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newRecipeDoctor?recipe_idr=${recipe.idr}&"><span><img src="images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="doctor.title"/></span></a></div>
						</c:if>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>