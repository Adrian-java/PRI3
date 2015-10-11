<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.visit-resources"/>
<html>
<head>
<title>Edit <fmt:message key="visit.title"/> <fmt:message key="patientcard.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
	<div id="content">
		<h1><fmt:message key="navigation.edit"/> <fmt:message key="patientcard.title"/></h1>
		<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectVisit?idKey=${visit_id}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
		<form:form action="${pageContext.request.contextPath}/saveVisitPatientCard" method="POST" modelAttribute="patientcard">
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="patientcard.id.title"/>:
						</td>
						<td>
							<c:choose>
								<c:when test='${newFlag}' >
							<form:input id="patientcard_id" path="id" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "patientcard_id",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="patientcard.id.help"/>", constraints : {places:0}}})); </script>
								</c:when>
								<c:otherwise>
							${patientcard.id}
						&nbsp;
									<form:hidden id="patientcard_id" path="id"/>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="patientcard.registerdate.title"/>:
						</td>
						<td>
							<input id="patientcard_registerDate" name="registerDate" type="text" value="<fmt:formatDate value="${patientcard.registerDate.time}" pattern="yyyy-MM-dd"/>" dojoType="dijit.form.DateTextBox" constraints="{datePattern:'<fmt:message key="date.format"/>'}" trim="true" promptMessage="<fmt:message key="date.format" />" invalidMessage="<fmt:message key="date.format.invalid" /> <fmt:message key="date.format" />." style="width:300px;" />
						</td>
					</tr>
				</tbody>
			</table>
			<span class="inputbutton"><input class="savebutton" id="save" type="submit" value="<fmt:message key="navigation.save"/>"/></span>
			<script type="text/javascript">Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'save', event:'onclick'}));</script>
				<input type="hidden" name="visit_id" value="${visit_id}" >
				
				
				
				
		</form:form>
		<div class="clear">&nbsp;</div>
	</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
