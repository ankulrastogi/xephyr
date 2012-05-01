<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="inner group" role="main">
	<div class="app_callout">
		<div class="box">
			<h1>Test</h1>
			<form action="doLogin" method="POST">

				<div class="form_input">
					<label for="email">Email</label> <input id="email" name="email"
						type="text" value="">
				</div>
				<div class="form_input">
					<label for="username">Username</label> <input id="username" name="username"
						type="text" value="">
				</div>
				
					<div class="form_input">
					<label for="password">Password</label> <input id="password"
						name="password" type="password" value=""> <a
						class="forgot" href="password_recover.php">Forgot</a>
				</div>

				<button class="primary" type="submit" >Sign In</button>
			</form>
		</div>

		<div class="app_help">
			<p>Dont have
				<a class="button primary"> New </a>
			</p>
			<p> HELP
				 <a href="https://support.lifeway.com/app/answers/list" target="_blank">FAQ</a>Question
			</p>
		</div>
	</div>

	<div class="app_info">
	<fmt:message key="dlt.login.label.aboutdlt"/>
	
		
	</div>
</div>