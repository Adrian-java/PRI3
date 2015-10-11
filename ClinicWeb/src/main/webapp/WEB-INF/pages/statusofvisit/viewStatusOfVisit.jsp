<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.statusofvisit-resources"/>
<html>
<head>
<title>View <fmt:message key="statusofvisit.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="statusofvisit.title"/> Details</h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexStatusOfVisit"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>	
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="statusofvisit.id.title"/>:
						</td>
						<td>
							${statusofvisit.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="statusofvisit.type.title"/>:
						</td>
						<td>
							${statusofvisit.type}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="visit.title"/></h1>
					
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newStatusOfVisitVisits?statusofvisit_id=${statusofvisit.id}&"><span><img src="${pageContext.request.contextPath}/images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="visit.title"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<thead>
					<tr>
						<th class="thead">&nbsp;</th>
						<th class="thead"><fmt:message key="visit.id.title"/></th>
						<th class="thead"><fmt:message key="visit.dateofvisit.title"/></th>
						<th class="thead"><fmt:message key="visit.isleave.title"/></th>
						<th class="thead"><fmt:message key="visit.special.title"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${statusofvisit.visits}" var="current"  varStatus="i">	
						<c:choose>
							<c:when test="${(i.count) % 2 == 0}">
					    		<c:set var="rowclass" value="rowtwo"/>
							</c:when>
							<c:otherwise>
					    		<c:set var="rowclass" value="rowone"/>
							</c:otherwise>
						</c:choose>
					<tr class="${rowclass}">
						<td nowrap="nowrap">
							<a title="<fmt:message key="navigation.view" />" href="${pageContext.request.contextPath}/selectStatusOfVisitVisits?statusofvisit_id=${statusofvisit.id}&visits_id=${current.id}&"><img src="images/icons/view.gif" /></a>
							<a title="<fmt:message key="navigation.edit" />" href="${pageContext.request.contextPath}/editStatusOfVisitVisits?statusofvisit_id=${statusofvisit.id}&visits_id=${current.id}&"><img src="images/icons/edit.gif" /></a>
							<a title="<fmt:message key="navigation.delete" />" href="${pageContext.request.contextPath}/confirmDeleteStatusOfVisitVisits?statusofvisit_id=${statusofvisit.id}&related_visits_id=${current.id}&"><img src="images/icons/delete.gif" /></a>
						</td>
						<td>
							${current.id}
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${current.dateOfVisit.time}"/>
						&nbsp;
						</td>
						<td>
							${current.isLeave}
						&nbsp;
						</td>
						<td>
							${current.special}
						&nbsp;
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>