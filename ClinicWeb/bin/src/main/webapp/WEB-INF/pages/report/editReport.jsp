<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.report-resources"/>
<html>
<head>
<title>Edit <fmt:message key="report.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
	<div id="content">
		<h1><fmt:message key="navigation.edit"/> <fmt:message key="report.title"/></h1>
		<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexReport"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
		<form:form action="${pageContext.request.contextPath}/saveReport" method="POST" modelAttribute="report">
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="report.id.title"/>:
						</td>
						<td>
							<c:choose>
								<c:when test='${newFlag}' >
							<form:input id="report_id" path="id" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "report_id",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="report.id.help"/>", constraints : {places:0}}})); </script>
								</c:when>
								<c:otherwise>
							${report.id}
						&nbsp;
									<form:hidden id="report_id" path="id"/>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="report.datefrom.title"/>:
						</td>
						<td>
							<input id="report_dateFrom" name="dateFrom" type="text" value="<fmt:formatDate value="${report.dateFrom.time}" pattern="yyyy-MM-dd"/>" dojoType="dijit.form.DateTextBox" constraints="{datePattern:'<fmt:message key="date.format"/>'}" trim="true" promptMessage="<fmt:message key="date.format" />" invalidMessage="<fmt:message key="date.format.invalid" /> <fmt:message key="date.format" />." style="width:300px;" />
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="report.dateto.title"/>:
						</td>
						<td>
							<input id="report_dateTo" name="dateTo" type="text" value="<fmt:formatDate value="${report.dateTo.time}" pattern="yyyy-MM-dd"/>" dojoType="dijit.form.DateTextBox" constraints="{datePattern:'<fmt:message key="date.format"/>'}" trim="true" promptMessage="<fmt:message key="date.format" />" invalidMessage="<fmt:message key="date.format.invalid" /> <fmt:message key="date.format" />." style="width:300px;" />
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="report.description.title"/>:
						</td>
						<td>
							<form:input id="report_description" path="description" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "report_description",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="report.description.help"/>"}})); </script>
						</td>
					</tr>
				</tbody>
			</table>
			<span class="inputbutton"><input class="savebutton" id="save" type="submit" value="<fmt:message key="navigation.save"/>"/></span>
			<script type="text/javascript">Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'save', event:'onclick'}));</script>
		</form:form>
		<div class="clear">&nbsp;</div>
	</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>