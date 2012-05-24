<%@ include file="/WEB-INF/pages/include/include.jsp"%>
<div class="app_callout password">
	<c:set var="serviceDown" value="${model.serviceDown}"></c:set>
	<c:if test="${! empty serviceDown}">
		<p class="error">
			<spring:message code="${model.serviceDown}"></spring:message>
		</p>
	</c:if>
	<div class="box">
		<h1>
			<fmt:message key="dlt.login.label.changepassword" />
		</h1>
		<form action="/dlt/profile/verifyPassword.html" method="POST">
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
				<label for="current_password"><fmt:message
						key="dlt.login.label.currentpassword" /></label> <input type="password"
					id="currentPassword" name="currentPassword" value="">
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
						key="dlt.login.label.newpassword" /></label> <input type="password"
					id="newPassword" name="newPassword" value="" maxlength="50">
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
						key="dlt.login.label.verifypassword" /></label> <input type="password"
					id="verifyNewPassword" name="verifyNewPassword" value=""
					maxlength="50">
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
			<div class="form_input"></div>
			<button type="submit">
				<fmt:message key="dlt.login.btn.changepassword" />
			</button>
		</form>
	</div>
</div>
