<%@ include file="/WEB-INF/pages/include/include.jsp"%>
<div class="shell">

	<%@ include file="/WEB-INF/pages/include/groupheader.jsp"%>

	<div class="section">


		<div class="content"></div>

	</div>

</div>

<%@ include file="/WEB-INF/pages/include/include.jsp"%>
<div class="shell">

	<%@ include file="/WEB-INF/pages/include/groupheader.jsp"%>

	<div class="section">


		<div class="content">

			<input type="hidden" value="${userModal}" id="modalPopup">
			<%@ include file="/WEB-INF/pages/include/errorTemplate.jsp"%>
			<form:form id="addAccountForm" method="post" modelAttribute="account"
				action="people.html">
				<div class="add-user form">
					<div class="crtAccountBtn">
						<button class="primary" type="button">
							<fmt:message key="dlt.group.create.account.button" />
						</button>
					</div>
					<div class="wrap">
						<div class="input-2 text-2">
							<form:hidden path="merchantID" id="merchantId"
								value="${merchantId}" />
							<label class="label-1" for="accountName"><fmt:message
									key="dlt.people.label.email" /></label>
							<div class="wrap">
								<form:input id="accountName" path="accountName" />
								<p class="hint">
									<fmt:message key="dlt.people.note.email.errmsg" />
								</p>

							</div>
						</div>
						<div class="input-3">
							<form:button id="addNewUserButton" type="submit">
								<fmt:message key="dlt.people.button.add" />
							</form:button>
							<!-- <button type="button">Cancel</button> -->
						</div>
					</div>
				</div>
			</form:form>
		</div>
		<!-- /.content -->
	</div>
	<!-- /.section -->
</div>
<!-- /.shell -->
