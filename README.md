# WeatherApplication
A simple weather app that provides current weather using the openweathermap.org API


Steps to run Weather Application:

1. Before we run, we need below software
	a)JDk 1.7.0
	b)Tomcat 8.0
	c)Eclipse IDE
2.Clone git repo to local machine
3.Import the project as an existing maven project in Eclipse
	file >> import >> maven >> existing maven project
4.Configure tomcat server in eclipse
5.Run project on server
	Right click on project >> run >> ron on server
6.After starting the server go to http://localhost:8080/Weather and check the weather by providing zip code in the input box.
7.Validations are performed for the input field as below
	a)Accepts only 5 digits
	b)Input value is required
	c)If the above conditions are not met the submit button won't be enabled
	d)If invalid ZIP code is entered, corresponding error message will be shown
