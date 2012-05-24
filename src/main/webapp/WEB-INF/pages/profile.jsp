<%@ include file="/WEB-INF/pages/include/include.jsp"%>
<div class="inner group" role="main">
	<c:set var="successfullChangePassword"
		value="${model.successfullChangePassword}"></c:set>
	<c:set var="successfulEditProfile"
		value="${errorMap.successfulEditProfile}"></c:set>
	<c:if test="${! empty successfullChangePassword}">
		<div class="alert alert-success">
			<strong><fmt:message key="dlt.edit.profile.successmsg" /></strong>
			<spring:message code="${model.successfullChangePassword}"></spring:message>
		</div>
	</c:if>
	<c:if test="${! empty successfulEditProfile}">
		<div class="alert alert-success">
			<strong><fmt:message key="dlt.edit.profile.successmsg" /></strong>
			<spring:message code="${errorMap.successfulEditProfile}"></spring:message>
		</div>
	</c:if>
	<%@include file="changePassword.jsp"%>
	<%@include file="userProfile.jsp"%>
</div>

