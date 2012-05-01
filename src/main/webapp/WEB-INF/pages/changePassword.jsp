<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="app_callout password">
	<div class="box">
		<h1><fmt:message key="dlt.login.label.changepassword"/></h1>
		<form action="">
			<div class="form_input">
				<label for="current_password"><fmt:message key="dlt.login.label.currentpassword"/></label> <input
					type="password" id="currentPassword" name="currentPassword"
					value="">
			</div>

			<div class="form_input">
				<label for="new_password"><fmt:message key="dlt.login.label.newpassword"/></label> <input
					type="password" id="newPassword" name="newPassword" value="">
				<p class="note"><fmt:message key="dlt.login.label.password.errr.msg"/></p>
			</div>

			<div class="form_input">
				<label for="new_password_verify"><fmt:message key="dlt.login.label.verifypassword"/></label> <input
					type="password" id="verifyNewPassword" name="verifyNewPassword"
					value="">
			</div>
			<button type="submit" onsubmit="/verifyPassword"><fmt:message key="dlt.login.label.changepassword"/></button>
		</form>
	</div>
</div>
