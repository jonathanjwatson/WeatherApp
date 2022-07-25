package com.tts.WeatherApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.WeatherApp.domain.ZipCode;
import com.tts.WeatherApp.repository.ZipCodeRepository;

@Service
public class ZipCodeService {
	@Autowired
	ZipCodeRepository zipCodeRepository;

	public List<ZipCode> getAllZipCodes() {
		List<ZipCode> zipCodes = new ArrayList<>();

		zipCodeRepository.findAll().forEach(zipCodes::add);

		return zipCodes;
	}
}
