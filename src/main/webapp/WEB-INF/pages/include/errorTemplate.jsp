<div class="notices">

<c:if test="${hasErrorMessages}">
	<div class="error">
		<p>
			<span class="label"><fmt:message key="dlt.error" /></span>
			<spring:message code="${errorMessageKey}"></spring:message>
		</p>
	</div>
</c:if>
<c:if test="${hasMessages}">
	<div class="success">
		<p>
			<span class="label"><fmt:message key="dlt.success" /></span>
			<spring:message code="${messageKey}"></spring:message>
		</p>
	</div>
</c:if>

<spring:hasBindErrors name="${formName}">
	<c:forEach items="${errors.globalErrors}" var="error">
		<div class="error">
			<p>
				<span class="label"><fmt:message key="dlt.error" /></span>
				<spring:message code="${error.code}" />
			</p>
		</div>
	</c:forEach>
</spring:hasBindErrors>
<c:if test="${hasAlertMessages}">
	<div class="alert">
		<p>
			<span class="label"><fmt:message key="dlt.notice" /></span>
			<spring:message code="${alertMessageKey}"></spring:message>
		</p>
	</div>
</c:if>
</div>