<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<title>Title</title>

<meta name="description" content="">

<link rel="shortcut icon" href="<%=request.getContextPath() %>/resources/img/favicon.ico">
<link rel="apple-touch-icon" href="<%=request.getContextPath() %>/resources/img/apple-touch-icon.png">

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/account.css">

<script src="../../resources/js/libs/modernizr-2.min.js"></script>
<script type="text/javascript" src="https://use.typekit.com/yiy1stl.js"></script>
<script type="text/javascript">try{Typekit.load();}catch(e){}</script>
</head>
<body>

<tiles:insertAttribute name="header" />
<tiles:insertAttribute name="navigation" />
<tiles:insertAttribute name="body" />
<tiles:insertAttribute name="footer" />

</body>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script>window.jQuery || document.write("<script src='<%=request.getContextPath() %>/resources/js/libs/jquery-1.7.2.min.js'>\x3C/script>")</script>

<!--[if (lt IE 9) & (!IEMobile)]>
			<script src="js/libs/DOMAssistant-2.8.js"></script>
			<script src="js/libs/selectivizr-min.js"></script>
		<![endif]-->

<script src="../../resources/js/functions.js"></script>
<script src="../../resources/js/onload.js"></script>
</html>
