package com.tts.WeatherApp;

import lombok.Data;

@Data
public class Request {
    private String zipCode;

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
    
    
}