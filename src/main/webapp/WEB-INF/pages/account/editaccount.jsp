<%@ include file="/WEB-INF/pages/include/include.jsp"%>
<div class="inner group">
	<h1 class="page-title">
		<fmt:message key="dlt.createaccount.title.message" />
	</h1>
	<span class="page-info"><fmt:message
			key="dlt.createaccount.introduction.message" /></span>
	<div class="form box">
		<%@ include file="/WEB-INF/pages/include/errorTemplate.jsp"%>
		<form:form method="post" id="profileForm"
			modelAttribute="editAccountForm">
			<form:hidden path="merchantID" value="${merchantID}" />
			<form:hidden path="accountID" value="${accountID}" />
			<div class="form_input">
				<form:label path="accountName">
					<fmt:message key="dlt.people.label.accountname" />
				</form:label>
				<form:input path="accountName" id="accountName" />
			</div>
			<button type="submit">
				<fmt:message key="own.generic.button.label.save" />
			</button>
			<a class="button primary"
				href="${contextRoot}/view/merchant/account/create"><fmt:message
					key="own.generic.button.label.cancel" /></a>
		</form:form>
	</div>
</div>