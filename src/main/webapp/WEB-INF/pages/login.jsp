<%@page
	import="org.springframework.security.core.AuthenticationException"%>
<%@page import="org.springframework.security.web.WebAttributes"%>
<%@ include file="/WEB-INF/pages/include/include.jsp"%>
<div class="inner group">
		<p>
		<fmt:message key="dlt.login.label.donthavelifewayid" />

		<a class="button primary"
			href="${contextRoot}/view/merchant/createaccount"> <fmt:message
				key="dlt.login.label.createonennow" /></a>
	</p>
	<div class="app_callout">
		<div class="box">
			<h1>
				<fmt:message key="dlt.login.label.signin" />
			</h1>
			<div class="form_input">

				<c:if test="${errorParam == '1'}">
					<c:set var="errorMessage"
						value="<%= ((AuthenticationException)session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION)).getMessage() %>" />
					<p class="error">
						<c:out value="${errorMessage} " />
					</p>
				</c:if>
			</div>

			<form name="loginForm" method="POST"
				action="${contextRoot}/j_spring_security_check">

				<div class="form_input">
					<label for="userName"><fmt:message
							key="dlt.login.label.email" /></label> <input type="text"
						name="userName" />

				</div>
				<div class="form_input">
					<label for="password"><fmt:message
							key="dlt.login.label.password" /></label> <input type="password"
						name="password" />

				</div>
				<button class="primary" type="submit">
					<fmt:message key="dlt.login.label.signin" />
				</button>
			</form>

		</div>

		<div class="app_help">
			<p>
				<fmt:message key="dlt.login.label.needhelp" />
				<a href="https://support.lifeway.com/app/answers/list"
					target="_blank"><fmt:message key="dlt.login.label.faq" /></a>
				<fmt:message key="dlt.login.label.question" />
			</p>
		</div>
	</div>

</div>