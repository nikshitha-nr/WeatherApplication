package com.agiletrailblazers.weather.forcast.Model;

/**
 * 
 * @author NIKSHITHA
 *This bean captures user entered data in Ui
 */
public class PostalCode {
	private String usPostalCode;
	public String getUsPostalCode() {
		return usPostalCode;
	}

	public void setUsPostalCode(String usPostalCode) {
		this.usPostalCode = usPostalCode;
	}

	@Override
	public String toString() {
		return "PostalCode [usPostalCode=" + usPostalCode + "]";
	}

}
