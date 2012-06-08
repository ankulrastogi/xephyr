<%@ include file="/WEB-INF/pages/include/include.jsp"%>
<div class="inner group">
	<h1 class="page-title">
		<fmt:message key="dlt.createaccount.title.message" />
	</h1>
	<span class="page-info"><fmt:message
			key="dlt.createaccount.introduction.message" /></span>
	<div class="form box">
		<form:form method="POST" modelAttribute="registrationFormModel"
			id="registrationForm">
			<div class="form_input">
				<form:label path="email">
					<fmt:message key="dlt.createaccount.form.label.email" />
				</form:label>
				<form:input id="email" name="email" path="email" />
				<spring:bind path="registrationFormModel.email">
					<c:if test="${status.error}">
						<p class="error">
							<form:errors path="email" />
						</p>
					</c:if>
				</spring:bind>
			</div>

			<div class="form_input">
				<form:label path="verifyEmail">
					<fmt:message key="dlt.createaccount.form.label.verifyemail" />
				</form:label>
				<form:input path="verifyEmail" id="verifyEmail" name="verifyEmail" />
				<spring:bind path="registrationFormModel.verifyEmail">
					<c:if test="${status.error}">
						<p class="error">
							<form:errors path="verifyEmail" />
						</p>
					</c:if>
				</spring:bind>
			</div>

			<div class="form_input">
				<form:label path="firstName">
					<fmt:message key="dlt.createaccount.form.label.firstname" />
				</form:label>
				<form:input id="firstName" name="firstName" path="firstName" />
				<spring:bind path="registrationFormModel.firstName">
					<c:if test="${status.error}">
						<p class="error">
							<form:errors path="firstName" />
						</p>
					</c:if>
				</spring:bind>
			</div>

			<div class="form_input">
				<form:label path="lastName">
					<fmt:message key="dlt.createaccount.form.label.lastname" />
				</form:label>
				<form:input id="lastName" name="lastName" path="lastName" />
				<spring:bind path="registrationFormModel.lastName">
					<c:if test="${status.error}">
						<p class="error">
							<form:errors path="lastName" />
						</p>
					</c:if>
				</spring:bind>
			</div>

			<div class="form_input">
				<form:label path="password">
					<fmt:message key="dlt.createaccount.form.label.password" />
				</form:label>
				<form:input id="password" name="password" path="password" />
				<p class="note">Password must be at least seven characters and
					contain one number and one letter.</p>
				<spring:bind path="registrationFormModel.password">
					<c:if test="${status.error}">
						<p class="error">
							<form:errors path="password" />
						</p>
					</c:if>
				</spring:bind>	
			</div>

			<div class="form_input">
				<form:label path="verifyPassword">
					<fmt:message key="dlt.createaccount.form.label.verifypassword" />
				</form:label>
				<form:input id="verifyPassword" name="verifyPassword"
					path="verifyPassword" />
					<spring:bind path="registrationFormModel.verifyPassword">
					<c:if test="${status.error}">
						<p class="error">
							<form:errors path="verifyPassword" />
						</p>
					</c:if>
				</spring:bind>
			</div>

			<button type="submit" class="primary">
				<fmt:message key="dlt.createaccount.form.label.register" />
			</button>
			<p class="info">
				<fmt:message key="dlt.account.info.createaccount" />
			</p>
		</form:form>
	</div>
</div>