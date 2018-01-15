<!DOCTYPE html>
<html>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular.min.js">
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular-resource.js"></script>

<body>
	<h1>Weather Report</h1>
	<ul>
		<li><p>
				<b>Current Weather:</b> <br>
				<%= request.getParameter("currentweathercondition")%>
				<br>
				<%= request.getParameter("temperature")%>
				<br>
				<%= request.getParameter("windspeed")%>
				<br>
				<%= request.getParameter("cityname")%>
			</p></li>

	</ul>

</body>
</body>

</html>