<!DOCTYPE html>
<html data-ng-app>
<head>
<title>Weather App</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular.min.js">
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular-resource.js"></script>
<script>
	var app = angular.module("weatherapp", [ 'ngResource' ]);
	app.config([ '$httpProvider', function($httpProvider) {
		$httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded; charset=UTF-8';
	} ]);

	app.controller("Postal", function($scope, $http, $window) {

		$http({
			method : 'post',
			url : 'http://localhost:8080/Weather/add',
		}).success(function(data) {});
		$scope.submit = function() {

			var data = 'postalCode=' + $scope.postalcode;
			$http({
				method : 'post',
				url : 'http://localhost:8080/Weather/add',
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				},
				params : {
					postalCode : $scope.postalcode,
				}
			}).success(function(data) {

				if (data.includes('Error')) {
					var citynotfound = data.substr(10, 170);

					$window.location.href = 'http://localhost:8080/Weather/errorui.jsp' + "?citynotfound=" + citynotfound;
				} else {
					$scope.user = data;
					var currentweathercondition = data.substr(10, 50);
					var temperature = data.substring(70, 110);
					var windspeed = data.substring(130, 170);
					var cityname = data.substring(175, 220);

					$window.location.href = 'http://localhost:8080/Weather/ui.jsp' + "?currentweathercondition=" + currentweathercondition + "&temperature=" + temperature + "&windspeed=" + windspeed + "&cityname=" + cityname;


				}
			});

		}
	});
</script>

</head>
<style>
input.ng-invalid {
	border: 2px red solid;
}
</style>
<body ng-app="weatherapp">
	<form data-ng-submit="submit()" name="weatherForm"
		data-ng-controller="Postal">

		<table border="0">
			<tr>
				<td colspan="2"><label>Postal Code:</label></td>

				<td colspan="2">
					<div class="form-group">
						<input type="text" name="postalcode" ng-model="postalcode"
							class="form-control" required ng-Maxlength="5">
					</div>
				</td>
				<p ng-show="weatherForm.postalcode.$error.required"
					class="help-block">Postal Code is required.</p>
				<p ng-show="weatherForm.postalcode.$error.maxlength"
					class="help-block">Maximum 5 characters</p>

			</tr>
			<tr>
				<td colspan="2">
					<center>
						<button type="submit" class="btn btn-primary"
							ng-disabled="weatherForm.$invalid">Submit</button>
					</center>
				</td>
			</tr>
		</table>
	</form>

	<br>
	</div>
</body>
</html>






