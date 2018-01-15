package com.agiletrailblazers.weather.forcast.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.agiletrailblazers.weather.forcast.Model.Report;
import com.agiletrailblazers.weather.forcast.Model.Weather;

/**
 * 
 * @author NIKSHITHA This class acts as service layer for calling Restful
 *         Webservice
 */
@RestController
@RequestMapping("/")
public class WeatherController {

	@Autowired
	private Report report;

	@Autowired(required = true)
	RestTemplate restTemplate;

	
	

	/*
	 * This method gets the weather report from Weather API
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView weatherReport(@RequestParam String postalCode) {

		ObjectMapper mapper= new ObjectMapper();
		ModelAndView model = new ModelAndView("report");

		// This below commented code is for server side validation for postal code.As of
		// now it is implemented on UI.
		/*
		 * if(!(StringUtils.isEmpty(postalCode))&& postalCode.length()==5) {
		 */

		String zipCode = postalCode;
		String country = "us";
		String appId = "783ac9240116b1cf09d452079874d9e9";

		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("postalCode", zipCode);
		uriVariables.put("country", country);
		uriVariables.put("appId", appId);
		String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "," + country + "&appid="
				+ appId;

		try {
			String response = restTemplate.getForObject(url, String.class, uriVariables);

			try {
				// After getting response as json,Here conversion of json to string is performed
				// below.
				report = mapper.readValue(response, Report.class);

			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (HttpClientErrorException e) {
			// Exception Handled in case of any data not found case from API.
			model = new ModelAndView("error");
			model.addObject("Citynotfound", "Please provide Valid Zip code");
		}

		List<Weather> l = report.getWeather();
		if (l != null) {
			String main = null;
			String desc = null;
			if (l.listIterator().hasNext()) {
				main = l.listIterator().next().getMain();
				model.addObject("weathermain", main);
				desc = l.listIterator().next().getDescription();
				model.addObject("weatherdesc", desc);
			}

			model.addObject("temparature", report.getMain().getTemp());
			model.addObject("windspeed", report.getWind().getSpeed());
			model.addObject("cityname", report.getName());

		}

		return model;
	}

}
