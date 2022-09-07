<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="any.utensil.label.name" path="name" width="20%"/>
	<acme:list-column code="any.utensil.label.code" path="code" width="20%"/>
	<acme:list-column code="any.utensil.label.description" path="description" width="20%"/>
	<acme:list-column code="any.utensil.label.retailPrice" path="retailPrice" width="20%"/>
	<acme:list-column code="any.utensil.label.link" path="link" width="20%"/>
</acme:list>