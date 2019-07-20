<!DOCTYPE html>
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
	</head>
	
	<body>
		<jsp:useBean id="login" class="dao.Authentication"/>
		<jsp:setProperty property="*" name="login"/>
	
		<h3><jsp:getProperty property="validation" name="login"/></h3>
	</body>
</html>