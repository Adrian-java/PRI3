<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.doctor-resources"/>
<html>
<head>
<title>Edit <fmt:message key="doctor.title"/> <fmt:message key="visitscheduler.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
	<div id="content">
		<h1><fmt:message key="navigation.edit"/> <fmt:message key="visitscheduler.title"/></h1>
		<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectDoctor?idKey=${doctor_id}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
		<form:form action="${pageContext.request.contextPath}/saveDoctorVisitSchedulers" method="POST" modelAttribute="visitscheduler">
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="visitscheduler.id.title"/>:
						</td>
						<td>
							<c:choose>
								<c:when test='${newFlag}' >
							<form:input id="visitscheduler_id" path="id" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "visitscheduler_id",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="visitscheduler.id.help"/>", constraints : {places:0}}})); </script>
								</c:when>
								<c:otherwise>
							${visitscheduler.id}
						&nbsp;
									<form:hidden id="visitscheduler_id" path="id"/>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="visitscheduler.numberofday.title"/>:
						</td>
						<td>
							<form:input id="visitscheduler_numberOfDay" path="numberOfDay" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "visitscheduler_numberOfDay",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="visitscheduler.numberofday.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="visitscheduler.numberofmonth.title"/>:
						</td>
						<td>
							<form:input id="visitscheduler_numberOfMonth" path="numberOfMonth" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "visitscheduler_numberOfMonth",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="visitscheduler.numberofmonth.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="visitscheduler.timeofvisit.title"/>:
						</td>
						<td>
							<input id="visitscheduler_timeOfVisit" name="timeOfVisit" type="text" value="<fmt:formatDate value="${visitscheduler.timeOfVisit.time}" timeStyle="short" type="time" />" style="width:300px;"/>
						</td>
					</tr>
				</tbody>
			</table>
			<span class="inputbutton"><input class="savebutton" id="save" type="submit" value="<fmt:message key="navigation.save"/>"/></span>
			<script type="text/javascript">Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'save', event:'onclick'}));</script>
				<input type="hidden" name="doctor_id" value="${doctor_id}" >
				
				
		</form:form>
		<div class="clear">&nbsp;</div>
	</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
