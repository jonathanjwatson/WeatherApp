package com.tts.WeatherApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.tts.WeatherApp.domain.ZipCode;
import com.tts.WeatherApp.repository.ZipCodeRepository;

@Service
public class WeatherService {
	@Value("${api_key}")
	private String apiKey;

	@Autowired
	ZipCodeRepository zipCodeRepository;

	public Response getForecast(String zipCode) {
		ZipCode newZipCode = new ZipCode();
		newZipCode.setNumber(zipCode);
		zipCodeRepository.save(newZipCode);

		String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "&units=imperial&appid="
				+ apiKey;
		RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.getForObject(url, Response.class);
		try {
			return restTemplate.getForObject(url, Response.class);
		} catch (HttpClientErrorException ex) {
			// TODO: Log the exception.
			Response response = new Response();
			response.setName("error");
			return response;
		}
	}

}