<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">
	<acme:input-textbox code="any.utensil.label.name" path="name"/>
	<acme:input-textbox code="any.utensil.label.code" path="code"/>
	<acme:input-textarea code="any.utensil.label.description" path="description"/>
	<acme:input-money code="any.utensil.label.retailPrice" path="retailPrice"/>
	<acme:input-url code="any.utensil.label.link" path="link"/>
</acme:form>