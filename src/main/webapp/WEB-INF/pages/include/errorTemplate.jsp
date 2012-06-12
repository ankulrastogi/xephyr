<div class="notices">

<c:if test="${not empty requestScope.error}">
<c:forEach items="${requestScope.error}" var="error">
	<div class="error">
			<p>
				<span class="label"><fmt:message key="dlt.error" /></span>
				<spring:message code="${error}" />
			</p>
		</div>
</c:forEach>
</c:if>

<c:if test="${not empty requestScope.success}">
	<div class="success">
		<p>
			<span class="label"><fmt:message key="dlt.success" /></span>
			<spring:message code="${requestScope.success}" />
		</p>
	</div>
</c:if>
</div>