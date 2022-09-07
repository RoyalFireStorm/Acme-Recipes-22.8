<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="authenticated.bulletin.label.moment" path="moment" width="20%"/>
	<acme:list-column code="authenticated.bulletin.label.heading" path="heading" width="20%"/>
	<acme:list-column code="authenticated.bulletin.label.text" path="text" width="20%"/>
	<acme:list-column code="authenticated.bulletin.label.email" path="email" width="20%"/>
	<jstl:if test="${critical}">
		<acme:list-column code="authenticated.bulletin.label.critical" path="critical" width="20%"/>
	</jstl:if>	
	<acme:list-column code="authenticated.bulletin.label.critical" path="critical" width="20%"/>
</acme:list>