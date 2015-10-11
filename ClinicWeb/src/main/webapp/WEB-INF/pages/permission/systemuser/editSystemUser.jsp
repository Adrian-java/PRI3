<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.permission-resources"/>
<html>
<head>
<title>Edit <fmt:message key="permission.title"/> <fmt:message key="systemuser.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
	<div id="content">
		<h1><fmt:message key="navigation.edit"/> <fmt:message key="systemuser.title"/></h1>
		<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectPermission?idKey=${permission_id}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
		<form:form action="${pageContext.request.contextPath}/savePermissionSystemUser" method="POST" modelAttribute="systemuser">
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="systemuser.id.title"/>:
						</td>
						<td>
							<c:choose>
								<c:when test='${newFlag}' >
							<form:input id="systemuser_id" path="id" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "systemuser_id",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="systemuser.id.help"/>", constraints : {places:0}}})); </script>
								</c:when>
								<c:otherwise>
							${systemuser.id}
						&nbsp;
									<form:hidden id="systemuser_id" path="id"/>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="systemuser.login.title"/>:
						</td>
						<td>
							<form:input id="systemuser_login" path="login" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "systemuser_login",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="systemuser.login.help"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="systemuser.password.title"/>:
						</td>
						<td>
							<form:input id="systemuser_password" path="password" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "systemuser_password",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="systemuser.password.help"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="systemuser.registerdate.title"/>:
						</td>
						<td>
							<input id="systemuser_registerDate" name="registerDate" type="text" value="<fmt:formatDate value="${systemuser.registerDate.time}" pattern="yyyy-MM-dd"/>" dojoType="dijit.form.DateTextBox" constraints="{datePattern:'<fmt:message key="date.format"/>'}" trim="true" promptMessage="<fmt:message key="date.format" />" invalidMessage="<fmt:message key="date.format.invalid" /> <fmt:message key="date.format" />." style="width:300px;" />
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="systemuser.isactive.title"/>:
						</td>
						<td>
							<form:checkbox id="systemuser_isActive" path="isActive" />
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "systemuser_isActive",widgetType : "dijit.form.CheckBox",widgetAttrs : {}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="systemuser.changedpassword.title"/>:
						</td>
						<td>
							<form:checkbox id="systemuser_changedPassword" path="changedPassword" />
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "systemuser_changedPassword",widgetType : "dijit.form.CheckBox",widgetAttrs : {}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="systemuser.email.title"/>:
						</td>
						<td>
							<form:input id="systemuser_email" path="email" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "systemuser_email",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="systemuser.email.help"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="systemuser.unregisterdate.title"/>:
						</td>
						<td>
							<input id="systemuser_unregisterDate" name="unregisterDate" type="text" value="<fmt:formatDate value="${systemuser.unregisterDate.time}" pattern="yyyy-MM-dd"/>" dojoType="dijit.form.DateTextBox" constraints="{datePattern:'<fmt:message key="date.format"/>'}" trim="true" promptMessage="<fmt:message key="date.format" />" invalidMessage="<fmt:message key="date.format.invalid" /> <fmt:message key="date.format" />." style="width:300px;" />
						</td>
					</tr>
				</tbody>
			</table>
			<span class="inputbutton"><input class="savebutton" id="save" type="submit" value="<fmt:message key="navigation.save"/>"/></span>
			<script type="text/javascript">Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'save', event:'onclick'}));</script>
				<input type="hidden" name="permission_id" value="${permission_id}" >
				
				
				
		</form:form>
		<div class="clear">&nbsp;</div>
	</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
