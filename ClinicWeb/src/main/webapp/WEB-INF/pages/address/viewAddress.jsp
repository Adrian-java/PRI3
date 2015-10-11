<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.address-resources"/>
<html>
<head>
<title>View <fmt:message key="address.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="address.title"/> Details</h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexAddress"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>	
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="address.id.title"/>:
						</td>
						<td>
							${address.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="address.city.title"/>:
						</td>
						<td>
							${address.city}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="address.countrycode.title"/>:
						</td>
						<td>
							${address.countryCode}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="address.province.title"/>:
						</td>
						<td>
							${address.province}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="address.country.title"/>:
						</td>
						<td>
							${address.country}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="address.countrycodecity.title"/>:
						</td>
						<td>
							${address.countryCodeCity}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="address.homenr.title"/>:
						</td>
						<td>
							${address.homeNr}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="clear">&nbsp;</div>
			<div class="spacer">&nbsp;</div>
			<h1><fmt:message key="patient.title"/></h1>
					
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newAddressPatients?address_id=${address.id}&"><span><img src="${pageContext.request.contextPath}/images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="patient.title"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<thead>
					<tr>
						<th class="thead">&nbsp;</th>
						<th class="thead"><fmt:message key="patient.id.title"/></th>
						<th class="thead"><fmt:message key="patient.name.title"/></th>
						<th class="thead"><fmt:message key="patient.surname.title"/></th>
						<th class="thead"><fmt:message key="patient.pesel.title"/></th>
						<th class="thead"><fmt:message key="patient.dateofbirth.title"/></th>
						<th class="thead"><fmt:message key="patient.email.title"/></th>
						<th class="thead"><fmt:message key="patient.phonenr.title"/></th>
						<th class="thead"><fmt:message key="patient.confirmed.title"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${address.patients}" var="current"  varStatus="i">	
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
							<a title="<fmt:message key="navigation.view" />" href="${pageContext.request.contextPath}/selectAddressPatients?address_id=${address.id}&patients_id=${current.id}&"><img src="images/icons/view.gif" /></a>
							<a title="<fmt:message key="navigation.edit" />" href="${pageContext.request.contextPath}/editAddressPatients?address_id=${address.id}&patients_id=${current.id}&"><img src="images/icons/edit.gif" /></a>
							<a title="<fmt:message key="navigation.delete" />" href="${pageContext.request.contextPath}/confirmDeleteAddressPatients?address_id=${address.id}&related_patients_id=${current.id}&"><img src="images/icons/delete.gif" /></a>
						</td>
						<td>
							${current.id}
						&nbsp;
						</td>
						<td>
							${current.name}
						&nbsp;
						</td>
						<td>
							${current.surname}
						&nbsp;
						</td>
						<td>
							${current.pesel}
						&nbsp;
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${current.dateOfBirth.time}"/>
						&nbsp;
						</td>
						<td>
							${current.EMail}
						&nbsp;
						</td>
						<td>
							${current.phoneNr}
						&nbsp;
						</td>
						<td>
							${current.confirmed}
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