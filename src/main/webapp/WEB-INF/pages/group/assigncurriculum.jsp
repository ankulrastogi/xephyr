<%@ include file="/WEB-INF/pages/include/include.jsp"%>
<div class="shell nogroup">
	<div class="content">
		
		<div class="notices">

			<c:set var="formName" value="groupForm" />
			<c:if test="${hasMessages}">
				<div class="success">
					<p>
						<span class="label"><fmt:message key="dlt.success" /></span>
						<spring:message code="${messageKey}"></spring:message>
					</p>
				</div>
			</c:if>
			<div class="alert">
				<p>
					<span class="label"><fmt:message key="dlt.success.group.notice" /></span> <fmt:message key="dlt.success.group.notice.import.curriculum" />
				</p>
			</div>
			<c:if test="${hasErrorMessages}">
				<div class="error">
					<p>
						<span class="label"><fmt:message key="dlt.error" /></span>
						<spring:message code="${errorMessageKey}"></spring:message>
					</p>
				</div>
			</c:if>


			<spring:hasBindErrors name="${formName}">
				<c:forEach items="${errors.globalErrors}" var="error">
					<div class="error">
						<p>
							<span class="label"><fmt:message key="dlt.error" /></span>
							<spring:message code="${error.code}" />
						</p>
					</div>
				</c:forEach>
			</spring:hasBindErrors>
			<c:if test="${hasAlertMessages}">
				<div class="alert">
					<p>
						<span class="label"><fmt:message key="dlt.notice" /></span>
						<spring:message code="${alertMessageKey}"></spring:message>
					</p>
				</div>
			</c:if>

		</div>
		

		<div class="form">
			<form:form modelAttribute="groupForm" action="import.html"
				method="post">
				<div class="input-1 checklist-1">
					<p class="label">
						<fmt:message key="dlt.group.label.unassignedcurriculum" />
					</p>

					<ul>
						<c:forEach items="${unAssignedCurriculumsList}" var="_entry"
							varStatus="_row">
							<li>
							
							<form:checkbox path="unassignedCurriculums" value="${_entry.id}" id="curriculum-${_row.count}" /> <label
								for="curriculum-${_row.count}"><c:out
										value="${_entry.curriculumName}"></c:out> </label></li>
						</c:forEach>
					</ul>
				</div>
				<div class="input-1 choose-group">
					<p class="label">
						<fmt:message key="dlt.group.label.choosegroup" />
					</p>
					<ul>
						<li class="first"><form:radiobutton path="chooseGroup"
							id="existing-group" value="existing-group" />
							<label for="existing-group"><fmt:message
									key="dlt.existing.group" /></label><select name="existingGroup"
							id="group-select">
								<c:forEach items="${existingGroupsList}" var="_entry"
									varStatus="_row">
									<option value="${_entry.id}" id="existing-group-${_row.count}">
										<c:out value="${_entry.groupName}"></c:out>
									</option>
								</c:forEach>
						</select></li>
						<li class="last"><form:radiobutton  path="chooseGroup"
							id="new-group" value="new-group"/> <label for="new-group"><fmt:message
									key="dlt.new.group" /></label>
							<div class="wrap">
								<form:input path="groupName" id="groupName" name="groupName" value=""/>

								<p class="hint">
									<fmt:message key="dlt.e.g" />
									<span><fmt:message key="dlt.fellowship.bible" /></span>
									<fmt:message key="dlt.or" />
									<span><fmt:message key="dlt.kid.ministry" /></span>
								</p>
							</div></li>
					</ul>
				</div>
				<div class="buttons-1">
					<button class="choose" type="submit" name="submit">
						<fmt:message key="dlt.group.label.add" />
					</button>
					<button class="later" type="submit" name="chooseLater">
						<fmt:message key="dlt.group.label.chooselater" />
					</button>
				</div>
			</form:form>
		</div>

		<div class="box-1">

			<img class="right"
				src="<%=request.getContextPath()%>/resources/img/content/about-groups-illustration.png"
				alt="">

			<h2>
				<fmt:message key="dlt.group.label.about" />
			</h2>

			<p>
				<fmt:message key="dlt.group.label.aboutdesc" />
			</p>

			<p class="label">
				<fmt:message key="dlt.group.label.grouprepresent" />
			</p>
			<ul class="last">
				<li><fmt:message key="dlt.group.label.church" /></li>
				<li><fmt:message key="dlt.group.label.childrenministry" /></li>
				<li><fmt:message key="dlt.group.label.biblestudy" /></li>
			</ul>

		</div>

	</div>
	<!-- /.content -->

</div>
<!-- /.shell -->

