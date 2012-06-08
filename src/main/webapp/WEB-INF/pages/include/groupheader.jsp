<%@ include file="/WEB-INF/pages/include/include.jsp"%>

<div class="group-hdr">
	<h1>
			Welcome <c:out value="${username}"></c:out>
	</h1>
	
	
</div>

<div class="tabs">
	<c:set var="navClassesValue" value="" />
	<c:set var="navCurriculumValue" value="" />
	<c:set var="navPeopleValue" value="" />

	<c:if test="${navigation == 'classes' }">
		<c:set var="navClassesValue" value="active" />
	</c:if>
	<c:if test="${navigation == 'curriculum' }">
		<c:set var="navCurriculumValue" value="active" />
	</c:if>
	<c:if test="${navigation == 'people' }">
		<c:set var="navPeopleValue" value="active" />
	</c:if>
	
	<a class="cls ${navClassesValue}" id="classes" href=""><fmt:message key="dlt.groupheader.label.classes" /></a> 
	<a class="crr ${navCurriculumValue}" id="curriculum" href="${contextRoot}/curriculum/curriculumlist.html?groupId=${sessionScope.activeGroup.id}"><fmt:message key="dlt.groupheader.label.curriculum" /></a> 
	<a class="ppl ${navPeopleValue}" id="people" href="${contextRoot}/people.html?groupId=${sessionScope.activeGroup.id}"><fmt:message key="dlt.groupheader.label.people" /></a>
</div>