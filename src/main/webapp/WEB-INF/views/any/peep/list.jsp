<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list readonly="true">
	<acme:list-column code="any.peep.label.moment" path="moment" width="20%"/>
	<acme:list-column code="any.peep.label.heading" path="heading" width="20%"/>
	<acme:list-column code="any.peep.label.writer" path="writer" width="20%"/>
	<acme:list-column code="any.peep.label.text" path="text" width="20%"/>
	<acme:list-column code="any.peep.label.email" path="email" width="20%"/>
</acme:list>