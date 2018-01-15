package com.agiletrailblazers.weather.forcast.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * 
 * @author NIKSHITHA
 * This class is replacement for .xml files for spring container initialization
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.agiletrailblazers.weather.forcast")
public class Application extends WebMvcConfigurerAdapter {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/*
	 * Configure View Resolver
	 */
	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

}