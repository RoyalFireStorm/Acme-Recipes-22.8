<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">
	<acme:input-textbox code="chef.finedish.label.status" path="status"/>
	<acme:input-textbox code="chef.finedish.label.code" path="code"/>
	<acme:input-textarea code="chef.finedish.label.request" path="request"/>
	<acme:input-money code="chef.finedish.label.budget" path="budget"/>
	<acme:input-moment code="chef.finedish.label.startDate" path="startDate"/>
	<acme:input-moment code="chef.finedish.label.endDate" path="endDate"/>
	<acme:input-url code="chef.finedish.label.link" path="link"/>
	<acme:input-textbox code="chef.finedish.label.recipe" path="recipe.heading"/>
	<b><acme:message code="chef.finedish.label.epicure" arguments=""/></b>
	<acme:input-textbox code="chef.finedish.label.epicure.username" path="epicure.userAccount.username"/>
	<acme:input-textbox code="chef.finedish.label.epicure.organisation" path="epicure.organisation"/>
	<acme:input-textbox code="chef.finedish.label.epicure.assertion" path="epicure.assertion"/>
	<acme:input-url code="chef.finedish.label.epicure.link" path="epicure.link"/>
	<acme:input-email code="chef.finedish.label.epicure.email" path="epicure.userAccount.identity.email"/>
</acme:form>