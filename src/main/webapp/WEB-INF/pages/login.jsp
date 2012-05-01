<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="inner group" role="main">
	<div class="app_callout">
		<div class="box">
			<h1><fmt:message key="dlt.login.label.signin"/></h1>
			<form action="doLogin" method="POST">

				<div class="form_input">
					<label for="email"><fmt:message key="dlt.login.label.email"/></label> <input id="email" name="email"
						type="text" value="">
				</div>
				
					<div class="form_input">
					<label for="password"><fmt:message key="dlt.login.label.password"/></label> <input id="password"
						name="password" type="password" value=""> <a
						class="forgot" href="password_recover.php"><fmt:message key="dlt.login.label.forgotpassword"/></a>
				</div>

				<button class="primary" type="submit" ><fmt:message key="dlt.login.label.signin"/></button>
			</form>
		</div>

		<div class="app_help">
			<p><fmt:message key="dlt.login.label.donthavelifewayid"/>
				<a class="button primary"> <fmt:message key="dlt.login.label.createonennow"/></a>
			</p>
			<p> <fmt:message key="dlt.login.label.needhelp"/>
				 <a href="https://support.lifeway.com/app/answers/list" target="_blank"><fmt:message key="dlt.login.label.faq"/></a><fmt:message key="dlt.login.label.question"/>
			</p>
		</div>
	</div>

	<div class="app_info">
	<fmt:message key="dlt.login.label.aboutdlt"/>
	<spring:message code="${model.errormessage}"/>
		
	</div>
</div>