<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.systemuser-resources"/>
<html>
<head>
<title>List <fmt:message key="systemuser.title"/>s</title>
</head>
<body>
<div id="contentarea" >
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
	<div id="content">
		<h1>Manage <fmt:message key="systemuser.title"/>s</h1>
		<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newSystemUser"><span><img src="${pageContext.request.contextPath}/images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="systemuser.title"/></span></a></div>
		<div id="tablewrapper">
		<table id="listTable" cellpadding="0" cellspacing="0">
			<thead>
				<tr>
					<th class="thead">&nbsp;</th>
					<th class="thead"><fmt:message key="systemuser.id.title"/></th>
					<th class="thead"><fmt:message key="systemuser.login.title"/></th>
					<th class="thead"><fmt:message key="systemuser.password.title"/></th>
					<th class="thead"><fmt:message key="systemuser.registerdate.title"/></th>
					<th class="thead"><fmt:message key="systemuser.isactive.title"/></th>
					<th class="thead"><fmt:message key="systemuser.changedpassword.title"/></th>
					<th class="thead"><fmt:message key="systemuser.email.title"/></th>
					<th class="thead"><fmt:message key="systemuser.unregisterdate.title"/></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${systemusers}" var="current" varStatus="i">
					<c:choose>
						<c:when test="${(i.count) % 2 == 0}">
		    				<c:set var="rowclass" value="rowtwo"/>
						</c:when>
						<c:otherwise>
		    				<c:set var="rowclass" value="rowone"/>
						</c:otherwise>
					</c:choose>	
				<tr class="${rowclass}">
					<td nowrap="nowrap" class="tabletd">
						<a title="<fmt:message key="navigation.view" />" href="${pageContext.request.contextPath}/selectSystemUser?idKey=${current.id}&"><img src="images/icons/view.gif" /></a>
						<a title="<fmt:message key="navigation.edit" />" href="${pageContext.request.contextPath}/editSystemUser?idKey=${current.id}&"><img src="images/icons/edit.gif" /></a>
						<a title="<fmt:message key="navigation.delete" />" href="${pageContext.request.contextPath}/confirmDeleteSystemUser?idKey=${current.id}&"><img src="images/icons/delete.gif" /></a>
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.id}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.login}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.password}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							<fmt:formatDate dateStyle="short" type="date" value="${current.registerDate.time}"/>
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.isActive}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.changedPassword}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.email}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							<fmt:formatDate dateStyle="short" type="date" value="${current.unregisterDate.time}"/>
						&nbsp;
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>