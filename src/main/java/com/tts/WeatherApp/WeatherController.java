package com.tts.WeatherApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WeatherController {
	@Autowired
	private WeatherService weatherService;

//    @GetMapping
//    public String getIndex(Model model) {
//        Response response = weatherService.getForecast("43210");
//        model.addAttribute("data", response);
//        return "index";
//    }
	@GetMapping
	public String getIndex(Model model) {
		model.addAttribute("request", new Request());
		return "index";
	}

	@PostMapping
	public String postIndex(Request request, Model model) {
//		System.out.printf("ZIP CODE: %s", request.getZipCode());
		Response data = weatherService.getForecast(request.getZipCode());
		model.addAttribute("data", data);
		return "index";
	}
}