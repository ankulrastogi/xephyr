<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="inner group">
	<h1 class="page-title">
		<fmt:message key="dlt.label.password.recovery" />
	</h1>
	<span class="page-info"><fmt:message
			key="dlt.text.password.recovery" /></span>

	<div class="form box">

		<form:form modelAttribute="user" action="recoverPassword.html"
			method="post">
			<div class="form_input">
				<label for=email><fmt:message key="dlt.login.label.email" /></label>

				<spring:bind path="user.emailAddress">
					<c:if test="${status.error}">
						<p class="error">
							<form:errors path="emailAddress" />
						</p>
					</c:if>
					<c:if test="${hasMessages}">
						<p class="error">
							<spring:message code="${messageKey}"></spring:message>
						</p>
					</c:if>
				</spring:bind>

				<form:input id="email" path="emailAddress" />

			</div>

			<button type="submit" class="primary">
				<fmt:message key="dlt.form.submit" />
			</button>
		</form:form>

	</div>
</div>