<%@ include file="/WEB-INF/pages/include/include.jsp"%>
<div class="notices">
<c:if test="${param.hasMessages}">
	<div class="success">
		<p>
			<span class="label"><fmt:message key="dlt.success" /></span>
			<spring:message code="${param.messageKey}"></spring:message>
		</p>
	</div>
</c:if>
</div>
<div class="shell nogroup">
	<div class="grouplist">

		<div class="form_input">
			<c:set var="error" value="${model.errormessages}"></c:set>
			<c:if test="${! empty error}">
				<p class="error">
					<spring:message code="${model.errormessages}"></spring:message>
				</p>
			</c:if>
		</div>
		<h2>
			<fmt:message key="dlt.group.label.selectgroup" />
		</h2>
		<ul id="grouplist">
			<c:forEach var="groups" items="${groupList}" >
				<li id="group_${groups.id}"><a href="${contextRoot}/people.html?groupID=${groups.id}"><c:out value="${groups.groupName}" /></a></li>
			</c:forEach>
		</ul>

	</div>

</div>

