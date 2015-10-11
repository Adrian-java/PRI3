<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.recipe-resources"/>
<html>
<head>
<title>Edit <fmt:message key="recipe.title"/> <fmt:message key="patient.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
	<div id="content">
		<h1><fmt:message key="navigation.edit"/> <fmt:message key="patient.title"/></h1>
		<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectRecipe?idrKey=${recipe_idr}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
		<form:form action="${pageContext.request.contextPath}/saveRecipePatient" method="POST" modelAttribute="patient">
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="patient.id.title"/>:
						</td>
						<td>
							<c:choose>
								<c:when test='${newFlag}' >
							<form:input id="patient_id" path="id" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "patient_id",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="patient.id.help"/>", constraints : {places:0}}})); </script>
								</c:when>
								<c:otherwise>
							${patient.id}
						&nbsp;
									<form:hidden id="patient_id" path="id"/>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="patient.name.title"/>:
						</td>
						<td>
							<form:input id="patient_name" path="name" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "patient_name",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="patient.name.help"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="patient.surname.title"/>:
						</td>
						<td>
							<form:input id="patient_surname" path="surname" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "patient_surname",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="patient.surname.help"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="patient.pesel.title"/>:
						</td>
						<td>
							<form:input id="patient_pesel" path="pesel" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "patient_pesel",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="patient.pesel.help"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="patient.dateofbirth.title"/>:
						</td>
						<td>
							<input id="patient_dateOfBirth" name="dateOfBirth" type="text" value="<fmt:formatDate value="${patient.dateOfBirth.time}" pattern="yyyy-MM-dd"/>" dojoType="dijit.form.DateTextBox" constraints="{datePattern:'<fmt:message key="date.format"/>'}" trim="true" promptMessage="<fmt:message key="date.format" />" invalidMessage="<fmt:message key="date.format.invalid" /> <fmt:message key="date.format" />." style="width:300px;" />
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="patient.email.title"/>:
						</td>
						<td>
							<form:input id="patient_EMail" path="EMail" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "patient_EMail",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="patient.email.help"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="patient.phonenr.title"/>:
						</td>
						<td>
							<form:input id="patient_phoneNr" path="phoneNr" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "patient_phoneNr",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="patient.phonenr.help"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="patient.confirmed.title"/>:
						</td>
						<td>
							<form:input id="patient_confirmed" path="confirmed" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "patient_confirmed",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="patient.confirmed.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
				</tbody>
			</table>
			<span class="inputbutton"><input class="savebutton" id="save" type="submit" value="<fmt:message key="navigation.save"/>"/></span>
			<script type="text/javascript">Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'save', event:'onclick'}));</script>
				<input type="hidden" name="recipe_idr" value="${recipe_idr}" >
				
				
		</form:form>
		<div class="clear">&nbsp;</div>
	</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
