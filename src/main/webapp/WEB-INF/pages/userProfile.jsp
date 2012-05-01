<div class="app_info profile">
	<h1>Your Profile</h1>
	<form  action="">
		<div class="form_input">
			<p class="label">Current Email Address:</p>
			<p class="input">${userProfile.emailAddress}</p>
		</div>

		<div class="form_input">
			<label for="profile_email">New Email Address</label>
			<?php if ($_GET["error"] == "true"): ?>
			<p class="error">You did not enter a valid email address.</p>
			<?php endif; ?>
			<input type="text" id="profile_email" name="profile_email" value="">
		</div>

		<div class="form_input">
			<label for="profile_email_verify">Verify Email Address</label> <input
				type="text" id="profile_email_verify" name="profile_email_verify"
				value="">
		</div>

		<div class="name">
			<div class="form_input">
				<label for="profile_first_name">First Name</label> <input
					type="text" id="profile_first_name" name="profile_first_name"
					value="${userProfile.firstName}">
			</div>

			<div class="form_input">
				<label for="profile_last_name">Last Name</label> <input type="text"
					id="profile_last_name" name="profile_last_name"
					value="${userProfile.lastName}">
			</div>
		</div>

		<div class="community_profile group">
			<small>This name is shown when you participate in
				LifeWay&#8217;s Community features.</small>

			<div class="form_input">
				<label for="profile_display_name">Display Name</label> <input
					type="text" id="profile_display_name" name="profile_display_name"
					value="${userProfile.displayName}">
				<?php if ($_GET["checking"] == "true"): ?>
				<span class="note checking">Checking...</span>

				<?php elseif ($_GET["available"] == "true"): ?>
				<span class="note available">That display name is available!</span>

				<?php elseif ($_GET["taken"] == "true"): ?>
				<span class="note taken">Sorry, that display name is taken.</span>

				<?php elseif ($_GET["you"] == "true"): ?>
				<span class="note you">This is you!</span>

				<?php elseif ($_GET["enter"] == "true"): ?>
				<span class="note enter">Please enter a display name.</span>

				<?php endif; ?>
			</div>
		</div>

		<button type="submit" onsubmit="/save">Save Changes</button>
	</form>
</div>