<%@ include file="/WEB-INF/pages/include/include.jsp"%>
<div id="bg">

	<div id="wrap">

		<div id="topbar">

			<div class="logo">
				<fmt:message key="dlt.title.heading" />
			</div>
			<ul class="menu">

				<c:if test="${alertimport}">
					<li class="alert"><a href="import.html">Import Curriculum</a></li>
				</c:if>
				<li><a href=""><fmt:message
							key="dlt.group.groupHeader.label.help" /></a></li>
				<li><a href=""><fmt:message
							key="dlt.group.groupHeader.label.about" /></a></li>
				<li><a href="<%=request.getContextPath()%>/profile/edit.html"><fmt:message
							key="dlt.group.groupHeader.label.profile" /></a></li>
				<li><a href="<%=request.getContextPath()%>/logout.html"><fmt:message
							key="dlt.group.groupHeader.label.logout" /></a></li>
			</ul>

		</div>
		
		