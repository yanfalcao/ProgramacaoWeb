<!DOCTYPE html>
<html>
    <head>
		<title>Zero to One Hundred</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    </head>
	
    <body>
    	<jsp:useBean id="game" class="business.Game" scope="session"></jsp:useBean>
    	<jsp:setProperty property="*" name="game"/>
    	
		<form>
        	<fieldset>
			<legend>Zero to One Hundred Result</legend><br>
			<h3>
				<jsp:getProperty property="result" name="game"/>
			</h3><br>
			
			<h3>
				<jsp:getProperty property="attempts" name="game"/>
			</h3>
            </fieldset>
		</form>
    </body>
</html>