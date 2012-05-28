<%@ include file="/WEB-INF/pages/include/include.jsp"%>
<div class="inner group" >
	<div class="app_callout">
		<div class="box">
			<h1>
				<fmt:message key="dlt.login.label.signin" />
			</h1>
			
			<form:form method="POST" modelAttribute="loginModel">
			<div class="form_input">
				<label for="email"><fmt:message key="dlt.login.label.email" /></label>
				<form:input path="userName"/>
				<form:errors path="userName" />
			</div>
			<div class="form_input">
			<label for="password"><fmt:message
							key="dlt.login.label.password" /></label>
			<form:input path="password" id="password"/>
			<form:errors path="password"/>				
			</div>
			<button class="primary" type="submit">
					<fmt:message key="dlt.login.label.signin" />
				</button>
			</form:form>
<%-- 			<form action="<c:out value='${contextRoot}'/>/view/merchant/login" method="POST"> --%>
<!-- 				<div class="form_input"> -->
<%-- 					<c:if test="${hasMessages}"> --%>
<!-- 						<p class="alert alert-success"> -->
<%-- 							<strong><fmt:message key="dlt.edit.profile.successmsg" /></strong> --%>
<%-- 							<spring:message code="${messageKey}"></spring:message> --%>
<!-- 						</p> -->
<%-- 					</c:if> --%>
<!-- 				</div> -->
				
<!-- 				<div class="form_input"> -->
<%-- 					<c:set var="error" value="${model.errormessages}"></c:set> --%>
<%-- 					<c:if test="${! empty error}"> --%>
<!-- 						<p class="error"> -->
<%-- 							<spring:message code="${model.errormessages}"></spring:message> --%>
<!-- 						</p> -->
<%-- 					</c:if> --%>

<%-- 					<label for="email"><fmt:message key="dlt.login.label.email" /></label> --%>
<!-- 					<input id="userName" name="userName" type="text" value=""> -->
<!-- 				</div> -->

<!-- 				<div class="form_input"> -->
<%-- 					<label for="password"><fmt:message --%>
<%-- 							key="dlt.login.label.password" /></label> <input id="password" --%>
<!-- 						name="password" type="password" value=""> <a -->
<%-- 						id="recoverURL" class="forgot" href="recoverPassword.html"><fmt:message --%>
<%-- 							key="dlt.login.label.forgotpassword" /></a> --%>
<!-- 				</div> -->

<!-- 				<button class="primary" type="submit"> -->
<%-- 					<fmt:message key="dlt.login.label.signin" /> --%>
<!-- 				</button> -->
<!-- 			</form> -->
		</div>

		<div class="app_help">
			<p>
				<fmt:message key="dlt.login.label.donthavelifewayid" />
				<a class="button primary"> <fmt:message
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
