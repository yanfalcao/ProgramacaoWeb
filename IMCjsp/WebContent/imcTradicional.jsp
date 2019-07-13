<!DOCTYPE html>
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
	</head>
	
	<body>
		<jsp:useBean id="Calculator" class="business.Calculator" scope="page"/>
		<jsp:setProperty property="*" name="Calculator"/>
	
		<fieldset>
			<legend>Result:</legend>
			<h3>
				<jsp:getProperty property="imcTradicional" name="Calculator"/>
			</h3>
			</fieldset>"
	</body>
</html> 