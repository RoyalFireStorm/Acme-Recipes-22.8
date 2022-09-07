<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="any.recipe.label.code" path="code" width="20%"/>
	<acme:list-column code="any.recipe.label.heading" path="heading" width="20%"/>
	<acme:list-column code="any.recipe.label.description" path="description" width="20%"/>
	<acme:list-column code="any.recipe.label.notes" path="notes" width="20%"/>
	<acme:list-column code="any.recipe.label.link" path="link" width="20%"/>
	<acme:list-column code="any.recipe.label.ingredient" path="quantityIngredient" width="20%"/>
	<acme:list-column code="any.recipe.label.utensil" path="quantityUtensil" width="20%"/>
	
	
</acme:list>