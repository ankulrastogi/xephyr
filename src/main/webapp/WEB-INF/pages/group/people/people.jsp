
<%@ include file="/WEB-INF/pages/include/include.jsp"%>
<div class="shell">

	<%@ include file="/WEB-INF/pages/include/groupheader.jsp"%>

	<div class="section">


		<div class="content">


			<%@ include file="/WEB-INF/pages/include/errorTemplate.jsp"%>
			<input type="hidden" id="modalPopup" value="${popup}">	


			<form:form id="peopleForm" method="post" modelAttribute="account"
				action="account/create">
				<div class="add-user form">

					<a href="" class="button"><fmt:message
							key="dlt.people.title.addnewuser" /></a>

					<div class="wrap">
						<div class="input-2 text-2">
							<form:hidden path="merchantID" id="merchantID" value="${sessionScope.merchantID}" />
							<label class="label-1" for="accountName"><fmt:message
									key="dlt.people.label.accountname" /></label>
							<div class="wrap">
								<form:input id="accountName" path="accountName" />
								<p class="hint">
									<fmt:message key="dlt.people.note.email.errmsg" />
								</p>

							</div>
						</div>
						<div class="input-3">
							<form:button id="addNewUserButton" type="submit">
								<fmt:message key="own.generic.button.label.account.create" />
							</form:button>
							<!-- <button type="button">Cancel</button> -->
						</div>
					</div>
				
				</div>
			</form:form>
			
			
			<table class="users">
				<thead>
					<tr>
						<th class="name"><a href="" class="sort-asc">Account Name</a></th>
						<th class="role"><a href="" class="sort-desc">AccountID</a></th>
						<th class="status"><a href="">Status</a></th>
					</tr>
				</thead>
				<tbody>
					<tr class="base hidden">
						<td class="name"></td>
						<td class="role"></td>
						<td class="status"></td>
						<td class="action"><a href="" class="edit">Edit</a><a href=""
							class="remove">Remove</a></td>
					</tr>
				</tbody>
			</table>		
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
<script type="text/javascript">
jQuery( function($){
	ServiceHelper.setupPeoplePageList();
});

</script>
<!-- /.shell -->
