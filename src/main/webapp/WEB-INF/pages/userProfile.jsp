<%@ include file="/WEB-INF/pages/include/include.jsp"%>

<script src="<%=request.getContextPath() %>/resources/js/profileForm.js"></script>
	<c:set var="serviceDown" value="${errorMap.serviceDown}"></c:set>
	<div class="app_info profile">
   		<c:if test="${! empty serviceDown}">
			<p class="error">	<spring:message code="${errorMap.serviceDown}"></spring:message></p>
		</c:if>	
	<h1><fmt:message key="dlt.your.profile"/></h1>
	<form method="post" id="profileForm" action="save.html">
		<div class="form_input">
			<p class="label"><fmt:message key="dlt.current.email.address"/></p>
			<p class="input">${userProfile.emailAddress}</p>
		</div>
		<c:set var="profileEmailBlank" value="${errorMap.profileEmailBlank}"></c:set>
		<c:set var="profileEmailError" value="${errorMap.profileEmailError}"></c:set>
		<c:set var="profileEmailVerifyBlank" value="${errorMap.profileEmailVerifyBlank}"></c:set>
		<c:set var="profileEmailVerifyError" value="${errorMap.profileEmailVerifyError}"></c:set>
		<c:set var="emailMismatch" value="${errorMap.emailMismatch}"></c:set>
		<c:set var="firstNameBlank" value="${errorMap.firstNameBlank}"></c:set>
		<c:set var="lastNameBlank" value="${errorMap.lastNameBlank}"></c:set>
		<c:set var="displayNameBlank" value="${errorMap.displayNameBlank}"></c:set>
		<c:set var="successfulEditProfile" value="${errorMap.successfulEditProfile}"></c:set>
		<c:set var="unSuccessfulEditProfile" value="${errorMap.unSuccessfulEditProfile}"></c:set>
		<c:set var="unSuccessfulEditProfileReason" value="${errorMap.unSuccessfulEditProfileReason}"></c:set>
		<div class="form_input">
			<label for="profile_email"><fmt:message key="dlt.new.email.address"/></label>
			<input type="text" id="profile_email" name="profile_email" value="${userProfile.newEmailAddress}">
			<c:choose>
				<c:when test="${! empty profileEmailBlank}">
					<p class="error"><spring:message code="${errorMap.profileEmailBlank}"></spring:message></p>
				</c:when>
				<c:when test="${! empty profileEmailError}">
					<p class="error"><spring:message code="${errorMap.profileEmailError}"></spring:message></p>
				</c:when>
			</c:choose>
		</div>

		<div class="form_input">
			<label for="profile_email_verify"><fmt:message key="dlt.verify.email.address"/></label> <input
				type="text" id="profile_email_verify" name="profile_email_verify" value="${userProfile.emailAddressVerify}">
			<c:choose>
				<c:when test="${! empty profileEmailVerifyBlank}">
					<p class="error"><spring:message code="${errorMap.profileEmailVerifyBlank}"></spring:message></p>
				</c:when>
				<c:when test="${! empty profileEmailVerifyError}">
					<p class="error"><spring:message code="${errorMap.profileEmailVerifyError}"></spring:message></p>
				</c:when>
				<c:when test="${! empty emailMismatch}">
					<p class="error"><spring:message code="${errorMap.emailMismatch}"></spring:message></p>
				</c:when>
				<c:when test="${! empty unSuccessfulEditProfileReason}">
					<p class="error"><spring:message code="${errorMap.unSuccessfulEditProfileReason}"></spring:message>
					</p>
				</c:when>
			</c:choose>
		</div>

		<div class="name">
			<div class="form_input">
				<label for="profile_first_name"><fmt:message key="dlt.first.name"/></label> <input
					type="text" id="profile_first_name" name="profile_first_name"
					value="${userProfile.firstName}">
				<c:if test="${! empty firstNameBlank}">
					<p class="error">
						<spring:message code="${errorMap.firstNameBlank}"></spring:message>
					</p>
				</c:if>
			</div>

			<div class="form_input">
				<label for="profile_last_name"><fmt:message key="dlt.last.name"/></label> <input type="text"
					id="profile_last_name" name="profile_last_name"
					value="${userProfile.lastName}">
				<c:if test="${! empty lastNameBlank}">
					<p class="error">
						<spring:message code="${errorMap.lastNameBlank}"></spring:message>
					</p>
				</c:if>
			</div>
		</div>

		<div class="community_profile group">
			<small><fmt:message key="dlt.community.features"/></small>

			<div class="form_input">
				<label for="profile_display_name"><fmt:message key="dlt.display.name"/></label> <input
					type="text" id="profile_display_name" name="profile_display_name"
					value="${userProfile.displayName}">
					<input type="hidden" id="old_display_name" name="old_display_name"
					value="${userProfile.displayName}">
					<input type="hidden" id="displayNameValid" name="displayNameValid"
					value="true">
				
				<span id="note_checking"  class="note checking" style="display:none"><fmt:message key="dlt.display.name.checking"/></span>

				<span id="note_available" class="note available" style="display:none"><fmt:message key="dlt.display.name.available"/></span>

				<span id="note_taken" class="note taken" style="display:none"><fmt:message key="dlt.display.name.taken"/></span>

				<span id="note_you" class="note you" style="display:none"><fmt:message key="dlt.this.is.you"/></span>

				<span id="note_enter" class="note enter" style="display:none"><fmt:message key="dlt.display.name.please.enter"/></span>
				
				<span id="note_down" class="note taken" style="display:none"><fmt:message key="dlt.error.service.down"/></span>
				
				<span id="note_error" class="note taken" style="display:none"><fmt:message key="dlt.error.displayName"/></span>
				
				<c:if test="${! empty displayNameBlank}">
					<span id="div_error" class="note enter" >
						<spring:message code="${errorMap.displayNameBlank}"></spring:message>
					</span>
				</c:if>
				</div>
		</div>

		<button type="submit"><fmt:message key="dlt.save.changes"/></button>
	</form>
</div>