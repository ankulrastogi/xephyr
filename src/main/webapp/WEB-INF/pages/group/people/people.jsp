

<div class="shell">

	<%@ include file="/WEB-INF/pages/include/groupheader.jsp"%>

	<div class="section">

		<div class="content">

			<div class="add-user form">
				<a href="" class="button">Add New User</a>

				<div class="wrap">
					<form>
						<div class="input-2 text-2">
							<label class="label-1" for="email">Email:</label>
							<div class="wrap">
								<input type="text" id="email" name="email">
								<p class="hint">Use comma seperated addresses to add
									multiple users at once</p>
							</div>
						</div>
						<div class="input-2">
							<label class="label-1" for="role">Role:</label>
							<div class="wrap">
								<select name="role" id="role">
									<option value="">Choose</option>
									<option value="admin">Admin</option>
									<option value="teacher">Teacher</option>
								</select>
							</div>
						</div>
						<div class="input-2">
							<label class="label-1">Add to class: <span>(optional)</span></label>
							<div class="wrap">
								<div class="checklist-1 scroll-box-1">
									<ul>
										<li><input name="class-1" id="class-1" type="checkbox"><label
											for="class-1" title="First Class Name Class Name">First
												Class Name Class Name</label></li>
										<li><input name="class-2" id="class-2" type="checkbox"><label
											for="class-2"
											title="Second Class Name Class Name Class Name Class Name Class Name Class Name">Second
												Class Name Class Name Class Name Class Name Class Name Class
												Name</label></li>
										<li><input name="class-3" id="class-3" type="checkbox"><label
											for="class-3" title="Third Class Name Class Name">Third
												Class Name Class Name</label></li>
										<li><input name="class-4" id="class-4" type="checkbox"><label
											for="class-4" title="Fourth Class Name Class Name">Fourth
												Class Name Class Name</label></li>
										<li><input name="class-5" id="class-5" type="checkbox"><label
											for="class-5" title="Fifth Class Name Class Name">Fifth
												Class Name Class Name</label></li>
									</ul>
								</div>
								<p class="hint">
									Classes can be created and managed on the <span>Classes</span>
									tab
								</p>
							</div>
						</div>
						<div class="input-3 checklist-1">
							<ul>
								<li><input name="invite" id="invite" type="checkbox"
									checked="checked"><label for="invite">Send
										invite email</label></li>
							</ul>
						</div>
						<div class="input-3">
							<button type="submit">Add</button>
							<!-- <button type="button">Cancel</button> -->
						</div>

					</form>
				</div>

			</div>


			<div class="paging">
				<p class="showing">Showing 21&ndash;40 of 55</p>
				<ul class="pages">
					<li class="label">Pages:</li>
					<li class="previous"><a href="#">Previous</a></li>
					<li><a href="#">1</a></li>
					<li>2</li>
					<li><a href="#">3</a></li>
					<li class="next"><a href="#">Next</a></li>
				</ul>
			</div>

			<div class="paging">
				<p class="showing">Showing 1&ndash;15 of 15</p>
				<ul class="pages">
					<li class="label">Pages:</li>
					<li class="previous"><a href="#" class="inactive">Previous</a></li>
					<li>1</li>
					<li class="next"><a href="#" class="inactive">Next</a></li>
				</ul>
			</div>

			<div class="paging">
				<p class="showing">Showing 41&ndash;55 of 55</p>
				<ul class="pages">
					<li class="label">Pages:</li>
					<li class="previous"><a href="#">Previous</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li>3</li>
					<li class="next"><a href="#" class="inactive">Next</a></li>
				</ul>
			</div>

			<table class="users">
				<thead>
					<tr>
						<th class="name"><a href="" class="sort-asc">Name</a></th>
						<th class="role"><a href="" class="sort-desc">Role</a></th>
						<th class="status"><a href="">Status</a></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="name">Firstname Lastname</td>
						<td class="role">Admin</td>
						<td class="status">Active</td>
						<td class="action"><a href="" class="edit">Edit</a><a href=""
							class="remove">Remove</a></td>
					</tr>
					<tr>
						<td class="name"><div>emailaddress@domain.com</div></td>
						<td class="role">Teacher</td>
						<td class="status">No invite sent</td>
						<td class="action"><a href="" class="invite">Send Invite</a><a
							href="" class="edit">Edit</a><a href="" class="remove">Remove</a></td>
					</tr>
					<tr>
						<td class="name"><div>emailaddress@domain.com.asdfasdfasdfasdf</div></td>
						<td class="role">Admin</td>
						<td class="status">Invite Sent</td>
						<td class="action"><a href="" class="invite">Send Invite</a><a
							href="" class="edit">Edit</a><a href="" class="remove">Remove</a></td>
					</tr>
					<tr>
						<td class="name"><div>Firstname Lastname</div></td>
						<td class="role">Admin</td>
						<td class="status">Active</td>
						<td class="action"><a href="" class="edit">Edit</a><a href=""
							class="remove">Remove</a></td>
					</tr>
					<tr>
						<td class="name">Firstname Lastname</td>
						<td class="role">Admin</td>
						<td class="status">Active</td>
						<td class="action"><a href="" class="edit">Edit</a><a href=""
							class="remove">Remove</a></td>
					</tr>
					<tr>
						<td class="name">Firstname Lastname</td>
						<td class="role">Teacher</td>
						<td class="status">Active</td>
						<td class="action"><a href="" class="edit">Edit</a><a href=""
							class="remove">Remove</a></td>
					</tr>
					<tr>
						<td class="name">Firstname Lastname</td>
						<td class="role">Teacher</td>
						<td class="status">Active</td>
						<td class="action"><a href="" class="edit">Edit</a><a href=""
							class="remove">Remove</a></td>
					</tr>
					<tr>
						<td class="name">Firstname Lastname</td>
						<td class="role">Teacher</td>
						<td class="status">Active</td>
						<td class="action"><a href="" class="edit">Edit</a><a href=""
							class="remove">Remove</a></td>
					</tr>
					<tr>
						<td class="name">Firstname Lastname</td>
						<td class="role">Teacher</td>
						<td class="status">Active</td>
						<td class="action"><a href="" class="edit">Edit</a><a href=""
							class="remove">Remove</a></td>
					</tr>
					<tr>
						<td class="name">Firstname Lastname</td>
						<td class="role">Teacher</td>
						<td class="status">Active</td>
						<td class="action"><a href="" class="edit">Edit</a><a href=""
							class="remove">Remove</a></td>
					</tr>
					<tr>
						<td class="name">Firstname Lastname</td>
						<td class="role">Teacher</td>
						<td class="status">Active</td>
						<td class="action"><a href="" class="edit">Edit</a><a href=""
							class="remove">Remove</a></td>
					</tr>
					<tr>
						<td class="name">Firstname Lastname</td>
						<td class="role">Teacher</td>
						<td class="status">Active</td>
						<td class="action"><a href="" class="edit">Edit</a><a href=""
							class="remove">Remove</a></td>
					</tr>
					<tr>
						<td class="name">Firstname Lastname</td>
						<td class="role">Teacher</td>
						<td class="status">Active</td>
						<td class="action"><a href="" class="edit">Edit</a><a href=""
							class="remove">Remove</a></td>
					</tr>
					<tr>
						<td class="name">Firstname Lastname</td>
						<td class="role">Teacher</td>
						<td class="status">Active</td>
						<td class="action"><a href="" class="edit">Edit</a><a href=""
							class="remove">Remove</a></td>
					</tr>
					<tr>
						<td class="name">Firstname Lastname</td>
						<td class="role">Teacher</td>
						<td class="status">Active</td>
						<td class="action"><a href="" class="edit">Edit</a><a href=""
							class="remove">Remove</a></td>
					</tr>
					<tr>
						<td class="name">Firstname Lastname</td>
						<td class="role">Teacher</td>
						<td class="status">Active</td>
						<td class="action"><a href="" class="edit">Edit</a><a href=""
							class="remove">Remove</a></td>
					</tr>
					<tr>
						<td class="name">Firstname Lastname</td>
						<td class="role">Teacher</td>
						<td class="status">Active</td>
						<td class="action"><a href="" class="edit">Edit</a><a href=""
							class="remove">Remove</a></td>
					</tr>
					<tr>
						<td class="name">Firstname Lastname</td>
						<td class="role">Teacher</td>
						<td class="status">Active</td>
						<td class="action"><a href="" class="edit">Edit</a><a href=""
							class="remove">Remove</a></td>
					</tr>
					<tr>
						<td class="name">Firstname Lastname</td>
						<td class="role">Teacher</td>
						<td class="status">Active</td>
						<td class="action"><a href="" class="edit">Edit</a><a href=""
							class="remove">Remove</a></td>
					</tr>
					<tr>
						<td class="name">Firstname Lastname</td>
						<td class="role">Teacher</td>
						<td class="status">Active</td>
						<td class="action"><a href="" class="edit">Edit</a><a href=""
							class="remove">Remove</a></td>
					</tr>
				</tbody>
			</table>

			<div class="paging">
				<p class="showing">Showing 21&ndash;40 of 52</p>
				<ul class="pages">
					<li class="label">Pages:</li>
					<li class="previous"><a href="#">Previous</a></li>
					<li><a href="#">1</a></li>
					<li>2</li>
					<li><a href="#">3</a></li>
					<li class="next"><a href="#">Next</a></li>
				</ul>
			</div>





		</div>
		<!-- /.content -->

	</div>
	<!-- /.section -->

</div>
<!-- /.shell -->
