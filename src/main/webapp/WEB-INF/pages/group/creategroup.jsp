<%@ include file="/WEB-INF/pages/include/include.jsp"%>
<div class="shell nogroup">
	
	<div class="content">

		<h1>
			<fmt:message key="dlt.group.create" />
		</h1>

		<div class="box-1">
			<img class="right"
				src="<%=request.getContextPath()%>/resources/img/content/about-groups-illustration.png"
				alt="">
			<h2>
				<fmt:message key="dlt.about.groups" />
			</h2>
			<p>
				<fmt:message key="dlt.before.using" />
			</p>

			<p class="label">
				<fmt:message key="dlt.group.represents" />
			</p>
			<ul class="last">
				<li><fmt:message key="dlt.your.church" /></li>
				<li><fmt:message key="dlt.childrent.ministry" /></li>
				<li><fmt:message key="dlt.bible.study" /></li>
			</ul>

		</div>
		<div class="notices">
			<c:set var="formName" value="groupForm" />
			<%@ include file="../include/errorTemplate.jsp"%>
		</div>

		<div class="form">
			<form:form modelAttribute="groupForm" action="create.html"
				method="post">
				<div class="input-1 text-1">
					<label for="group-name"><fmt:message key="dlt.group.name" /></label>
					<form:input type="text" path="groupName" id="groupName"
						name="groupName" value="" />
					<p class="hint">
						<fmt:message key="dlt.e.g" />
						<span><fmt:message key="dlt.fellowship.bible" /></span>
						<fmt:message key="dlt.or" />
						<span><fmt:message key="dlt.kid.ministry" /></span>
					</p>
				</div>
				<div class="input-1 checklist-1">
					<p class="label">
						<fmt:message key="dlt.select.curriculum" />
					</p>
					<ul>
						<c:forEach items="${unAssignedCurriculumsList}" var="_entry"
							varStatus="_row">
							<li><form:checkbox path="unassignedCurriculums"
									value="${_entry.id}" id="curriculum-${_row.count}" /> <label
								for="curriculum-${_row.count}"><c:out
										value="${_entry.curriculumName}" /> </label></li>
						</c:forEach>
					</ul>

				</div>
				<button type="submit">
					<fmt:message key="dlt.create" />
				</button>
			</form:form>
		</div>

		<div class="box-2">
			<h3>
				<fmt:message key="dlt.not.admin" />
			</h3>
			<p>
				<fmt:message key="dlt.after.naming.group" />
				<em><fmt:message key="dlt.people" /></em>
				<fmt:message key="dlt.someone.else.admin" />
			</p>
		</div>


	</div>
	<!-- /.content -->

</div>
<!-- /.shell -->
