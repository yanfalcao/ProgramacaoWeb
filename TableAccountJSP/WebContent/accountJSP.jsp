<html>
	<body>
	<jsp:useBean id="calculator" class="business.Calculator" scope="page"/>
	<jsp:setProperty property="*" name="calculator"/>	
		<fieldset>
			<legend>Account:</legend><br>
			<h3>
				<jsp:getProperty property="totalExpense" name="calculator"/>
			</h3>
			
			<h3>
				<jsp:getProperty property="totalPerPerson" name="calculator"/>
			</h3>
		</fieldset>
	</body>
</html>