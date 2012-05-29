<%@ include file="/WEB-INF/pages/include/include.jsp"%>
<div class="inner group">
	<div class="app_callout">
		<div class="box">
			<h1>
				<fmt:message key="dlt.login.label.signin" />
			</h1>
			<form:form name="loginForm" method="POST" modelAttribute="loginModel">

				<div class="form_input">
					<label for="userName"><fmt:message
							key="dlt.login.label.email" /></label>
					<form:input path="userName" id="userName" />
<%-- 					<spring:hasBindErrors  name="loginForm.userName" > --%>
						<p class="error">
							<form:errors path="userName" />
						</p>
<%-- 					</spring:hasBindErrors> --%>

				</div>
				<div class="form_input">
					<label for="password"><fmt:message
							key="dlt.login.label.password" /></label>
					<form:input path="password" id="password" />
					<spring:hasBindErrors name="password">
						<p class="error">
							<form:errors path="password" />
						</p>
					</spring:hasBindErrors>
				</div>
				<button class="primary" type="submit">
					<fmt:message key="dlt.login.label.signin" />
				</button>
			</form:form>
		</div>

		<div class="app_help">
			<p>
				<fmt:message key="dlt.login.label.donthavelifewayid" />

				<a class="button primary"
					href="${contextRoot}/view/merchant/createaccount"> <fmt:message
						key="dlt.login.label.createonennow" /></a>
			</p>
			<p>
				<fmt:message key="dlt.login.label.needhelp" />
				<a href="https://support.lifeway.com/app/answers/list"
					target="_blank"><fmt:message key="dlt.login.label.faq" /></a>
				<fmt:message key="dlt.login.label.question" />
			</p>
		</div>
	</div>

	<div class="app_info">
		<fmt:message key="dlt.login.label.aboutdlt" />
	</div>
</div>
<script language="javascript" type="text/javascript">
	$('#recoverURL').click(function() {
		var anchorHrefValue = $('#recoverURL').attr('href');
		var emailInputVaraiable = $('#emailAddress').attr('value');
		var link = anchorHrefValue + "?email=" + emailInputVaraiable;
		$("#recoverURL").prop("href", link);

	});
</script>
