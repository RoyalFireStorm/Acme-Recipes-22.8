<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">
	<acme:input-textbox code="any.recipe.label.code" path="code"/>
	<acme:input-textbox code="any.recipe.label.heading" path="heading"/>
	<acme:input-textarea code="any.recipe.label.description" path="description"/>
	<acme:input-textarea code="any.recipe.label.notes" path="notes"/>
	<acme:input-textarea code="any.recipe.label.link" path="link"/>
	<acme:input-integer code="any.recipe.label.ingredient.number" path="quantityIngredient"/>
	<acme:input-textbox code="any.recipe.label.ingredient.name" path="quantityIngredient.ingredient.name"/>
	<acme:input-textarea code="any.recipe.label.utensil" path="mapUtensil"/>
	
</acme:form>