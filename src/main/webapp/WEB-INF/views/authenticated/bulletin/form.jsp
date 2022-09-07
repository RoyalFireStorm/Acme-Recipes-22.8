<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">
	<acme:input-moment code="authenticated.bulletin.label.moment" path="moment"/>
	<acme:input-textbox code="authenticated.bulletin.label.heading" path="heading"/>
	<acme:input-textarea code="authenticated.bulletin.label.text" path="text"/>
	<acme:input-email code="authenticated.bulletin.label.email" path="email"/>
	<acme:input-select code="authenticated.bulletin.label.critical" path="critical">
		<acme:input-option code="authenticated.bulletin.label.true" value="true" selected="${critical == true }"/>
		<acme:input-option code="authenticated.bulletin.label.false" value="false" selected="${critical == false }"/>
	</acme:input-select>
</acme:form>