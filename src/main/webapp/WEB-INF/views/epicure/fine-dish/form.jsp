<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">
	<acme:input-textbox code="epicure.finedish.label.status" path="status"/>
	<acme:input-textbox code="epicure.finedish.label.code" path="code"/>
	<acme:input-textarea code="epicure.finedish.label.request" path="request"/>
	<acme:input-money code="epicure.finedish.label.budget" path="budget"/>
	<acme:input-moment code="epicure.finedish.label.startDate" path="startDate"/>
	<acme:input-moment code="epicure.finedish.label.endDate" path="endDate"/>
	<acme:input-url code="epicure.finedish.label.link" path="link"/>
	<acme:input-textbox code="epicure.finedish.label.recipe" path="recipe.heading"/>
	<b><acme:message code="epicure.finedish.label.chef"/></b>
	<acme:input-textbox code="epicure.finedish.label.chef.username" path="chef.userAccount.username"/>
	<acme:input-textbox code="epicure.finedish.label.chef.organisation" path="chef.organisation"/>
	<acme:input-textbox code="epicure.finedish.label.chef.assertion" path="chef.assertion"/>
	<acme:input-url code="epicure.finedish.label.chef.link" path="chef.link"/>
	<acme:input-email code="epicure.finedish.label.chef.email" path="chef.userAccount.identity.email"/>
</acme:form>