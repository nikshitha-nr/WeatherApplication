package com.agiletrailblazers.weather.forcast.Model;

/**
 * 
 * @author NIKSHITHA
 *This is a bean for incoming response from API
 */
public class Clouds {
	private int all;

	public int getAll() {
		return all;
	}

	public void setAll(int all) {
		this.all = all;
	}

	@Override
	public String toString() {
		return "Clouds [all=" + all + "]";
	}
}
