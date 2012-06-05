<%@page import="org.springframework.security.web.context.HttpSessionSecurityContextRepository"%>
<%@ include file="/WEB-INF/pages/include/include.jsp"%>
<div class="header wrapper">
	<div class="header inner group" id="topbar">
		<a class="logo" href="http://www.lifeway.com/"><img
			src="<%=request.getContextPath()%>/resources/img/logo.png"
			alt="LifeWay"></a>
		<h1 class="app">
			<span><fmt:message key="dlt.title.image" /></span>
			<fmt:message key="dlt.title.heading" />
		</h1>
		<c:set var="securityContext" value="<%= request.getSession().getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY) %>" />
		<c:if test="${not empty securityContext}">
			<ul class="menu">


			<li class="first"><a href="">Help</a></li>
			<li><a href="">About</a></li>
			<li><a href="/dlt/profile/edit.html">Profile</a></li>
			<li class="last"><a href="/j_spring_security_logout">Logout</a></li>
		</ul>
			
		</c:if> 
			</div>
</div>