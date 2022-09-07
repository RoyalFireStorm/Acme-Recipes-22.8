<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">
	<acme:input-textbox code="any.user.list.label.role" path="roles"/>
	<acme:input-textbox code="any.user.list.label.username" path="username"/>
	<acme:input-email code="any.user.list.label.email" path="identity.email"/>
</acme:form>