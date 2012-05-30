
<%@ include file="/WEB-INF/pages/include/include.jsp"%>
<div class="shell">

	<%@ include file="/WEB-INF/pages/include/groupheader.jsp"%>

	<div class="section">

		<div class="content">
			<input type="hidden" value="${userModal}" id="modalPopup">
			<c:if test="${param.hasAlertMessages}">
	  			<div class="notices">
	            	<div class="success">
	                	<p>
	                		<span class="label"><fmt:message key="dlt.edit.profile.successmsg" /></span>
							<spring:message code="${param.alertMessageKey}"></spring:message>
						</p>
	                </div>
	            </div>
            </c:if>
			<div class="add-user form">
				<a href="" class="button"><fmt:message
						key="dlt.people.title.addnewuser" /></a>

				<div class="wrap">

					<form:form id="peopleForm" name="peopleForm" method="post"
						modelAttribute="user" action="people.html">
						<div class="input-2 text-2">
							<form:hidden path="groupID" id="groupID" value="${param.groupId}" />
							<label class="label-1" for="emailAddresses"><fmt:message
									key="dlt.people.label.email" /></label>
							<div class="wrap">
								<form:input id="emailAddresses" path="emailAddresses" />
								<p class="hint">
									<fmt:message key="dlt.people.note.email.errmsg" />
								</p>
								<spring:bind path="user.emailAddresses">
									<c:if test="${status.error}">
										<div class="error">
											<p>
												<span class="label"><fmt:message key="dlt.error" /></span>
												<form:errors path="emailAddresses" />
											</p>
										</div>
									</c:if>
								</spring:bind>
							</div>
						</div>
						<div class="input-2">
							<label class="label-1" for="userRole"><fmt:message
									key="dlt.people.label.role" /></label>
							<div class="wrap">
								<form:select path="userRole" items="${roleList}"
									itemLabel="value" itemValue="id">
								</form:select>
							</div>
						</div>
						<div class="input-2">
							<label class="label-1"><fmt:message
									key="dlt.people.lablel.addtoclass" /></label>
							<div class="wrap">
								<div class="checklist-1 scroll-box-1"></div>
								<p class="hint">
									<fmt:message key="dlt.people.note.classes" />
								</p>
							</div>
						</div>

						<div class="input-3 checklist-1"></div>
						<div class="input-3 checklist-1">
							<form:checkbox path="inviteToBeSent" id="inviteToBeSent"
								checked="checked" />
							<form:label path="inviteToBeSent">
								<fmt:message key="dlt.people.invite.notification" />
							</form:label>
						</div>
						<div class="input-3">
							<form:button type="submit">
								<fmt:message key="dlt.people.button.add" />
							</form:button>
							<!-- <button type="button">Cancel</button> -->
						</div>

					</form:form>
				</div>

			</div>

			<display:table name="peopleList" requestURI="/people.html"
				defaultsort="1" export="false" id="tableList" uid="peopleList" pagesize="3" >
				<display:column property="name" title="Name" headerClass="name" class="name"
					sortable="true" sortProperty="name" defaultorder="ascending" />
				<display:column property="role.value" title="Role"
					headerClass="role " class="role" sortable="true" sortProperty="role"/>
				<display:column property="status" title="Status"
					headerClass="status" class="status" sortable="true" sortProperty="status"/>
				<display:column class="action" sortable="false">
					<c:url var="inviteUrl" value="/people/invite.html">
						<c:param name="groupId">
							<c:out value="${tableList.groupID}" />
						</c:param>
						<c:param name="peopleId">
							<c:out value="${tableList.groupInviteeID}" />
						</c:param>
					</c:url>
					<c:if test="${tableList.status.value != 'Active'}">
						<a href="${inviteUrl}" class="invite">Send Invite</a>
					</c:if>

					<c:choose>
						<c:when test="${tableList.status.value=='Active'}">
							<c:set var="queryString" value="ssoId=${tableList.ssoID}"></c:set>
						</c:when>
						<c:otherwise>
							<c:set var="queryString"
								value="peopleId=${tableList.groupInviteeID}"></c:set>
						</c:otherwise>
					</c:choose>
					<a
						href="${contextRoot}/people/edit.html?groupId=${param.groupId}&${queryString}"
						class="edit">Edit</a>
					<a
						href="${contextRoot}/people/remove.html?groupId=${param.groupId}&${queryString}"
						class="remove">Remove</a>
				</display:column>
			</display:table>
			<!-- 
				<div id="remove-modal" class="modal confirm">
    
                        <div class="content">
                            <h2>	<fmt:message key="dlt.people.model.label.removeuser"/></h2>
                            <p><fmt:message key="dlt.people.model.label.confirmmsg"/></p>
                            <p class="name"></p>
                        </div>
                        
                        <p class="close"><a class="button confirm" href=""><fmt:message key="dlt.people.model.label.confirm"/></a> <a class="button simplemodal-close" href=""><fmt:message key="dlt.people.model.label.cancel"/></a></p>
                        
                    </div>
                     -->
                    
                    <div id="invite-modal" class="modal confirm">
    
                        <div class="content">
                            <h2><fmt:message key="dlt.people.model.label.inviteemailmsg"/></h2>
                            <p><fmt:message key="dlt.people.model.label.inviteemailconfirm"/></p>
                            <p class="name"></p>
                        </div>
                        
                        <p class="close"><a class="button confirm" href=""><fmt:message key="dlt.people.model.label.send"/></a> <a class="button simplemodal-close" href=""><fmt:message key="dlt.people.model.label.cancel"/></a></p>
                        
                    </div>

		</div>
		<!-- /.content -->

	</div>
	<!-- /.section -->

</div>
<!-- /.shell -->
