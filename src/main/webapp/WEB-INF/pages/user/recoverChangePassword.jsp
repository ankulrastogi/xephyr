<%@ include file="/WEB-INF/pages/include/include.jsp"%>
<div class="inner group">
	<c:set var="serviceDown" value="${model.serviceDown}"></c:set>
	<c:if test="${! empty serviceDown}">
		<p class="error">
			<spring:message code="${model.serviceDown}"></spring:message>
		</p>
	</c:if>
	<h1 class="page-title">
		<fmt:message key="dlt.title.recover.change.password"></fmt:message>
	</h1>
	<span class="page-info"><fmt:message
			key="dlt.text.recover.change.password" /></span>

	<div class="form box">
		<form action="tempPassword.html" method="POST">
			<c:set var="error" value="${model.errormessage}"></c:set>
			<div class="form_input">

				<c:set var="currentpassword" value="${model.currentpassword}"></c:set>
				<c:set var="newpassword" value="${model.newpassword}"></c:set>
				<c:set var="verifynewpassword" value="${model.verifynewpassword}"></c:set>
				<c:set var="verifyCurrentPassword"
					value="${model.verifyCurrentPassword}"></c:set>
				<c:set var="verifyPasswords" value="${model.verifyPasswords}"></c:set>
				<c:set var="verifyNewPasswordLength"
					value="${model.verifyNewPasswordLength}"></c:set>
				<c:set var="verifyPasswordFormat"
					value="${model.verifyPasswordFormat}"></c:set>
				<c:set var="verifyCurrentPasswordLength"
					value="${model.verifyCurrentPasswordLength}"></c:set>
				<label for="new_password_verify"><fmt:message
						key="dlt.label.recover.temporary.password" /></label> <input
					type="password" id="currentPassword" name="currentPassword"
					value="">
					<c:choose>
					<c:when test="${! empty currentpassword}">
						<p class="error">
							<spring:message code="${model.currentpassword}"></spring:message>
						</p>
					</c:when>
					<c:when test="${! empty verifyCurrentPasswordLength}">
						<p class="error">
							<spring:message code="${model.verifyCurrentPasswordLength}"></spring:message>
						</p>
					</c:when>
					<c:when test="${! empty verifyCurrentPassword}">
						<p class="error">
							<spring:message code="${model.verifyCurrentPassword}"></spring:message>
						</p>
					</c:when>
				</c:choose>
			</div>

			<div class="form_input">
				<label for="new_password"><fmt:message
						key="dlt.login.label.newpassword" /></label>
				<input type="password" id="newPassword" name="newPassword" value=""
					maxlength="50">
				<p class="note">
					<fmt:message key="dlt.login.label.password.errr.msg" />
				</p>
				<c:choose>
					<c:when test="${! empty newpassword}">
						<p class="error">
							<spring:message code="${model.newpassword}"></spring:message>
						</p>
					</c:when>
					<c:when test="${! empty verifyNewPasswordLength}">
						<p class="error">
							<spring:message code="${model.verifyNewPasswordLength}"></spring:message>
						</p>
					</c:when>
					<c:when test="${! empty verifyPasswordFormat}">
						<p class="error">
							<spring:message code="${model.verifyPasswordFormat}"></spring:message>
						</p>
					</c:when>
				</c:choose>
			</div>

			<div class="form_input">
				<label for="new_password_verify"><fmt:message
						key="dlt.login.label.verifypassword" /></label>
				<input type="password" id="verifyNewPassword"
					name="verifyNewPassword" value="" maxlength="50">
				<c:choose>
					<c:when test="${! empty verifynewpassword}">
						<p class="error">
							<spring:message code="${model.verifynewpassword}"></spring:message>
						</p>
					</c:when>
					<c:when test="${! empty verifyPasswords}">
						<p class="error">
							<spring:message code="${model.verifyPasswords}"></spring:message>
						</p>
					</c:when>
				</c:choose>					
			</div>

			<button type="submit" class="primary">
				<fmt:message key="dlt.submit.save" />
			</button>
		</form>
	</div>
</div>