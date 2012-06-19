<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", -1);
%>
<!DOCTYPE html>
<!--[if lt IE 7 ]><html lang="en" class="no-js ie6" id="dlt-com"><![endif]--> 
<!--[if IE 7 ]><html lang="en" class="no-js ie7" id="dlt-com"><![endif]--> 
<!--[if IE 8 ]><html lang="en" class="no-js ie8" id="dlt-com"><![endif]--> 
<!--[if IE 9 ]><html lang="en" class="no-js ie9" id="dlt-com"><![endif]--> 
<!--[if (gt IE 9)|!(IE)]><!--><html lang="en" class="no-js" id="dlt-com"><!--<![endif]--> 
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<title><fmt:message key="dlt.title"/></title>

<meta name="description" content="">

<link rel="shortcut icon" href="<%=request.getContextPath() %>/resources/img/favicon.ico">
<link rel="apple-touch-icon" href="<%=request.getContextPath() %>/resources/img/apple-touch-icon.png">

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/style.css">

<script src="<%=request.getContextPath() %>/resources/js/libs/modernizr-2.5.3.min.js"></script>
<script type="text/javascript" src="https://use.typekit.com/yiy1stl.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/libs/jquery-1.7.2.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/libs/jquery.simplemodal.1.4.2.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/libs/json2.js"></script>
<script type="text/javascript">try{Typekit.load();}catch(e){}</script>
</head>
<body>
<tiles:useAttribute id="navigation" name="navigation" scope="request" ignore="true"/>

<tiles:insertAttribute name="header" />
<tiles:insertAttribute name="body" />
<tiles:insertAttribute name="footer" />

<!--[if (lt IE 9) & (!IEMobile)]>
			<script src="js/libs/DOMAssistant-2.8.js"></script>
			<script src="js/libs/selectivizr-min.js"></script>
		<![endif]-->
<script src="<%=request.getContextPath() %>/resources/js/helper.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/functions.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/onload.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/script.js"></script>
</body>
<head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="Expires" content="-1">
</head>
</html>
