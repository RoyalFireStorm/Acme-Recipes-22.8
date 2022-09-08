<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="epicure.finedish.label.status" path="status" width="20%"/>
	<acme:list-column code="epicure.finedish.label.code" path="code" width="20%"/>
	<acme:list-column code="epicure.finedish.label.request" path="request" width="20%"/>
	<acme:list-column code="epicure.finedish.label.budget" path="budget" width="20%"/>
	<acme:list-column code="epicure.finedish.label.startDate" path="startDate" width="20%"/>
	<acme:list-column code="epicure.finedish.label.endDate" path="endDate" width="20%"/>
	<acme:list-column code="epicure.finedish.label.chef.username" path="chef.userAccount.username" width="20%"/>
	<acme:list-column code="epicure.finedish.label.recipe" path="recipe.heading" width="20%"/>
	<acme:list-column code="epicure.finedish.label.link" path="link" width="20%"/>
</acme:list>