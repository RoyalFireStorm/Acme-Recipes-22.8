<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="chef.finedish.label.status" path="status" width="20%"/>
	<acme:list-column code="chef.finedish.label.code" path="code" width="20%"/>
	<acme:list-column code="chef.finedish.label.request" path="request" width="20%"/>
	<acme:list-column code="chef.finedish.label.budget" path="budget" width="20%"/>
	<acme:list-column code="chef.finedish.label.startDate" path="startDate" width="20%"/>
	<acme:list-column code="chef.finedish.label.endDate" path="endDate" width="20%"/>
	<acme:list-column code="chef.finedish.label.epicure" path="epicure.userAccount.username" width="20%"/>
	<acme:list-column code="chef.finedish.label.recipe" path="recipe.heading" width="20%"/>
	<acme:list-column code="chef.finedish.label.link" path="link" width="20%"/>
</acme:list>