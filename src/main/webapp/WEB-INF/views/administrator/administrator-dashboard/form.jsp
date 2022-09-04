<%--
- form.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>



<acme:message code="administrator.administrator-dashboard.form.label.Title"/>		
	<table class="table table-sm">
		<caption></caption>
			<tr>
				<th id="">
					<acme:message code="administrator.administrator-dashboard.form.label.totalNumberIngredients"/>		
		
				</th>
				<td style= "text-align:right;">
					<acme:print value="${totalNumberIngredients}"/>
				</td>
			</tr>
			<tr>
				<th id="">
					<acme:message code="administrator.administrator-dashboard.form.label.totalNumberUtensils"/>		
		
				</th>
				<td style= "text-align:right;">
					<acme:print value="${totalNumberUtensils}"/>
				</td>	
			</tr>
			<tr>
				<th id="">
					<acme:message code="administrator.administrator-dashboard.form.label.totalNumberOfProposedFineDishes"/>		
		
				</th>
				<td style= "text-align:right;">
					<acme:print value="${totalNumberOfProposedFineDishes}"/>
				</td>		
			</tr>
			<tr>	
				<th id="">
					<acme:message code="administrator.administrator-dashboard.form.label.totalNumberOfAcceptedFineDishes"/>
				</th>
				<td style= "text-align:right;">
					<acme:print value="${totalNumberOfAcceptedFineDishes}"/>
				</td>		
			</tr>
			<tr>	
				<th id="">
					<acme:message code="administrator.administrator-dashboard.form.label.totalNumberOfDeniedFineDishes"/>		
				</th>
				<td style= "text-align:right;">
					<acme:print value="${totalNumberOfDeniedFineDishes}"/> 
				</td>		
			</tr>
	</table>

	<acme:message code="administrator.administrator-dashboard.form.label.ingredientTitle"/>	
	<table class="table table-sm">	
		<caption></caption>
		
		
	<jstl:if test="${empty averageRetailPriceByCurrencyIngredient}">
	<acme:message code="administrator.administrator-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${averageRetailPriceByCurrencyIngredient}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.averageIngredient"/>	
			<acme:print value="${entry.key}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	<jstl:if test="${empty deviationRetailPriceByCurrencyIngredient}">
	<acme:message code="administrator.administrator-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${deviationRetailPriceByCurrencyIngredient}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.deviationIngredient"/>	
			<acme:print value="${entry.key}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	<jstl:if test="${empty minRetailPriceByCurrencyIngredient}">
	<acme:message code="administrator.administrator-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${minRetailPriceByCurrencyIngredient}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.minIngredient"/>	
			<acme:print value="${entry.key}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	<jstl:if test="${empty maxRetailPriceByCurrencyIngredient}">
	<acme:message code="administrator.administrator-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${maxRetailPriceByCurrencyIngredient}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.maxIngredient"/>	
			<acme:print value="${entry.key}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	</table>
	
	<acme:message code="administrator.administrator-dashboard.form.label.utensilTitle"/>	
	<table class="table table-sm">	
		<caption></caption>
		
		
	<jstl:if test="${empty averageRetailPriceByCurrencyUtensil}">
	<acme:message code="administrator.administrator-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${averageRetailPriceByCurrencyUtensil}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.averageUtensil"/>	
			<acme:print value="${entry.key}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	<jstl:if test="${empty deviationRetailPriceByCurrencyUtensil}">
	<acme:message code="administrator.administrator-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${deviationRetailPriceByCurrencyUtensil}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.deviationUtensil"/>	
			<acme:print value="${entry.key}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	<jstl:if test="${empty minRetailPriceByCurrencyUtensil}">
	<acme:message code="administrator.administrator-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${minRetailPriceByCurrencyUtensil}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.minUtensil"/>	
			<acme:print value="${entry.key}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	<jstl:if test="${empty maxRetailPriceByCurrencyUtensil}">
	<acme:message code="administrator.administrator-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${maxRetailPriceByCurrencyUtensil}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.maxUtensil"/>	
			<acme:print value="${entry.key}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	</table>
	
	<acme:message code="administrator.administrator-dashboard.form.label.fineDishTitle"/>	
	<table class="table table-sm">	
		<caption></caption>
		
		
	<jstl:if test="${empty averageBudgetByStatusFineDishes}">
	<acme:message code="administrator.administrator-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${averageBudgetByStatusFineDishes}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.averageFineDish"/>	
			<acme:print value="${entry.key}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	<jstl:if test="${empty deviationBudgetByStatusFineDishes}">
	<acme:message code="administrator.administrator-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${deviationBudgetByStatusFineDishes}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.deviationFineDish"/>	
			<acme:print value="${entry.key}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	<jstl:if test="${empty minBudgetByStatusFineDishes}">
	<acme:message code="administrator.administrator-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${minBudgetByStatusFineDishes}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.minFineDish"/>	
			<acme:print value="${entry.key}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	<jstl:if test="${empty maxBudgetByStatusFineDishes}">
	<acme:message code="administrator.administrator-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${maxBudgetByStatusFineDishes}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.maxFineDish"/>	
			<acme:print value="${entry.key}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	</table>
	
	