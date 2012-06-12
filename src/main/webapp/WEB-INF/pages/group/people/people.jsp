
<%@ include file="/WEB-INF/pages/include/include.jsp"%>
<div class="shell">

	<%@ include file="/WEB-INF/pages/include/groupheader.jsp"%>

	<div class="section">


		<div class="content">


			<c:set var="formName" value="people" />
			<%@ include file="/WEB-INF/pages/include/errorTemplate.jsp"%>


			<form:form id="peopleForm" method="post" modelAttribute="account"
				action="people.html">
				<div class="add-user form">




					<a href="" class="button"><fmt:message
							key="dlt.people.title.addnewuser" /></a>

					<div class="wrap">


						<div class="input-2 text-2">
							<form:hidden path="merchantID" id="merchantID" value="${param.groupId}" />
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
				<div id="remove-modal" class="modal confirm">
    
                        <div class="content">
                            <h2>	<fmt:message key="dlt.people.model.label.removeuser"/></h2>
                            <p><fmt:message key="dlt.people.model.label.confirmmsg"/></p>
                            <p class="name"></p>
                        </div>
                        
                        <p class="close"><a class="button confirm" href=""><fmt:message key="dlt.people.model.label.confirm"/></a> <a class="button simplemodal-close" href=""><fmt:message key="dlt.people.model.label.cancel"/></a></p>
                        
                    </div>
    		<div id="invite-modal" class="modal confirm">

				<div class="content">
					<h2>
						<fmt:message key="dlt.people.model.label.inviteemailmsg" />
					</h2>
					<p>
						<fmt:message key="dlt.people.model.label.inviteemailconfirm" />
					</p>
					<p class="name"></p>
				</div>

				<p class="close">
					<a class="button confirm" href=""><fmt:message
							key="dlt.people.model.label.send" /></a> <a
						class="button simplemodal-close" href=""><fmt:message
							key="dlt.people.model.label.cancel" /></a>
				</p>

			</div>

		</div>
		<!-- /.content -->

	</div>
	<!-- /.section -->

</div>
<!-- /.shell -->
