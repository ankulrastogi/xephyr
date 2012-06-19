<%@ include file="/WEB-INF/pages/include/include.jsp"%>

<div class="group-hdr">
	<h1>
			Welcome <c:out value="${sessionScope.username}"></c:out>
	</h1>
	
	
</div>

<c:set var="navClassesValue" value="" />
<c:set var="navCurriculumValue" value="" />
<c:set var="navPeopleValue" value="" />
<c:set var="changeGroupURL" value="${contextRoot}/people.html" />

<c:if test="${navigation == 'classes' }">
	<c:set var="navClassesValue" value="active" />
	<c:set var="changeGroupURL" value="${contextRoot}/class.html" />
</c:if>
<c:if test="${navigation == 'curriculum' }">
	<c:set var="navCurriculumValue" value="active" />
	<c:set var="changeGroupURL"
		value="${contextRoot}/curriculum/curriculumlist.html" />
</c:if>
<c:if test="${navigation == 'people' }">
	<c:set var="navPeopleValue" value="active" />
	<c:set var="changeGroupURL" value="${contextRoot}/people.html" />
</c:if>
<div class="tabs">
	<a class="cls ${navClassesValue}" id="subscription" href="#"><fmt:message key="dlt.groupheader.label.subscription" /></a> 
	<a class="crr ${navCurriculumValue}" id="profile" href="#"><fmt:message key="dlt.groupheader.label.profile" /></a> 
	<a class="ppl ${navPeopleValue} " id="accounts" href="#"><fmt:message key="dlt.groupheader.label.accounts" /></a>
</div>

