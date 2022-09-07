<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">
	<acme:input-textbox code="any.ingredient.label.name" path="name"/>
	<acme:input-textbox code="any.ingredient.label.code" path="code"/>
	<acme:input-textarea code="any.ingredient.label.description" path="description"/>
	<acme:input-money code="any.ingredient.label.retailPrice" path="retailPrice"/>
	<acme:input-url code="any.ingredient.label.link" path="link"/>
</acme:form>