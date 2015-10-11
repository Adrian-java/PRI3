<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.typeofuser-resources"/>
<html>
<head>
<title>Edit <fmt:message key="typeofuser.title"/> <fmt:message key="permission.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
	<div id="content">
		<h1><fmt:message key="navigation.edit"/> <fmt:message key="permission.title"/></h1>
		<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectTypeOfUser?idKey=${typeofuser_id}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
		<form:form action="${pageContext.request.contextPath}/saveTypeOfUserPermission" method="POST" modelAttribute="permission">
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="permission.id.title"/>:
						</td>
						<td>
							<c:choose>
								<c:when test='${newFlag}' >
							<form:input id="permission_id" path="id" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "permission_id",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="permission.id.help"/>", constraints : {places:0}}})); </script>
								</c:when>
								<c:otherwise>
							${permission.id}
						&nbsp;
									<form:hidden id="permission_id" path="id"/>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="permission.display.title"/>:
						</td>
						<td>
							<form:checkbox id="permission_display" path="display" />
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "permission_display",widgetType : "dijit.form.CheckBox",widgetAttrs : {}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="permission.edit.title"/>:
						</td>
						<td>
							<form:checkbox id="permission_edit" path="edit" />
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "permission_edit",widgetType : "dijit.form.CheckBox",widgetAttrs : {}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="permission.execute.title"/>:
						</td>
						<td>
							<form:checkbox id="permission_execute" path="execute" />
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "permission_execute",widgetType : "dijit.form.CheckBox",widgetAttrs : {}})); </script>
						</td>
					</tr>
				</tbody>
			</table>
			<span class="inputbutton"><input class="savebutton" id="save" type="submit" value="<fmt:message key="navigation.save"/>"/></span>
			<script type="text/javascript">Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'save', event:'onclick'}));</script>
				<input type="hidden" name="typeofuser_id" value="${typeofuser_id}" >
				
				
		</form:form>
		<div class="clear">&nbsp;</div>
	</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
