<%@ include file="/WEB-INF/pages/include/include.jsp"%>
<div class="inner group">
			<h1 class="page-title"><fmt:message key="dlt.account.label.createaccount"/></h1>
			<span class="page-info">Don't have a LifeWay ID? Create one now.</span>
			
			<div class="form box">
				<form action="">
					<div class="form_input">
						<label for="email">Email</label>
						<input type="text" id="email" name="email" value="">
					</div>
					
					<div class="form_input">
						<label for="verify_email">Verify Email</label>
						<input type="text" id="verify_email" name="verify_email" value="">
					</div>

					<div class="form_input">
						<label for="first_name">First Name</label>
						<?php if ($_GET["error"] == "true"): ?>
						<p class="error">Enter your first name.</p>
						<?php endif; ?>	
						<input type="text" id="first_name" name="first_name" value="">
					</div>
					
					<div class="form_input">
						<label for="last_name">Last Name</label>
						<input type="text" id="last_name" name="last_name" value="">
					</div>

					<fieldset>
						<div class="form_input display_name">
							<p class="info">This name is shown when you participate in LifeWay&rsquo;s Community features.</p>

							<label for="profile_display_name">Display Name</label>
							<input type="text" id="profile_display_name" name="profile_display_name" value="">

							<?php if ($_GET["checking"] == "true"): ?>
								<p class="note checking">Checking...</p>

							<?php elseif ($_GET["available"] == "true"): ?>
								<p class="note available">That display name is available!</p>

							<?php elseif ($_GET["taken"] == "true"): ?>
								<p class="note taken">Sorry, that display name is taken.</p>

							<?php elseif ($_GET["you"] == "true"): ?>
								<p class="note you">This is you!</p>

							<?php elseif ($_GET["enter"] == "true"): ?>
								<p class="note enter">Please enter a display name.</p>

							<?php endif; ?>	
						</div>			
					</fieldset>
					
					<div class="form_input">
						<label for="password">Password</label>
						<input type="text" id="password" name="password" value="">
						<p class="note">Password must be at least seven characters and contain one number and one letter.</p>
					</div>
					
					<div class="form_input">
						<label for="verify_password">Verify Password</label>
						<input type="text" id="verify_password" name="verify_password" value="">
					</div>				

					<button type="submit" class="primary">Create Account</button>
					<p class="info">By clicking &#8220;Create Account,&#8221; I accept LifeWay&#8217;s <a href="#">Terms &amp; Conditions</a>.</p>
				</form>
			</div>
		</div>