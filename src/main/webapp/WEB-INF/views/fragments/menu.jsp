<%--
- menu.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<acme:menu-option code="master.menu.any.user-account.list" action="/any/user-account/list"/>
		<acme:menu-option code="master.menu.any.peep.list" action="/any/peep/list"/>
		<acme:menu-option code="master.menu.any.product" >
			<acme:menu-suboption code="master.menu.any.utensil" action="/any/utensil/list"/>
			<acme:menu-suboption code="master.menu.any.ingredient" action="/any/ingredient/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.any.recipeList" action="/any/recipe/list-all"/>
		</acme:menu-option>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-Alvaro" action="https://twitter.com/home?lang=es"/>
		</acme:menu-option>
		
		 <acme:menu-option code="master.menu.authenticated" access="isAuthenticated()">
			<%--<acme:menu-suboption code="master.menu.authenticated.money-exchage" action="/authenticated/money-exchange/perform"/>--%>
			<acme:menu-suboption code="master.menu.authenticated.bulletin.list" action="/authenticated/bulletin/list"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">			
			<acme:menu-suboption code="master.menu.administrator.dashboard" action="/administrator/administrator-dashboard/show"/>
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.populate-initial" action="/administrator/populate-initial"/>
			<acme:menu-suboption code="master.menu.administrator.populate-sample" action="/administrator/populate-sample"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.shut-down" action="/administrator/shut-down"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.epicure" access="hasRole('Epicure')">						
			<acme:menu-suboption code="master.menu.epicure.dashboard" action="/epicure/epicure-dashboard/show"/>		
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.chef" access="hasRole('Chef')">						
			<acme:menu-suboption code="master.menu.chef.ingredients" action="/chef/ingredient/list"/>
			<acme:menu-suboption code="master.menu.chef.utensils" action="/chef/utensil/list"/>		
			<acme:menu-suboption code="master.menu.chef.recipes" action="/chef/recipe/list-all"/>				
		</acme:menu-option>

	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()"/>
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()"/>

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated">
			<acme:menu-suboption code="master.menu.authenticated.system-configurator.show" action="/authenticated/system-configurator/show"/>
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated"/>
	</acme:menu-right>
</acme:menu-bar>

