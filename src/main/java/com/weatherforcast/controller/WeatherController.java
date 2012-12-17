/**
 * 
 */
package com.weatherforcast.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.weatherforcast.formData.WeatherData;
import com.weatherforcast.logic.WeatherLogic;

/**
 * @author vivek.mehra
 *
 */
@Controller
@RequestMapping("/displayWheather")
public class WeatherController {

	@Autowired
	private WeatherLogic wetherLogic;

	// Display the form on the get request
	@RequestMapping(method = RequestMethod.GET)
	public String showValidatinForm(Map<String, WeatherData> model) {
		WeatherData weatherData = new WeatherData();
		model.put("weatherData", weatherData);
		return "showWether";
	}

	// Process the form.
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processValidatinForm(@Valid WeatherData weatherData,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("showWether");
		} else {
			try {
				wetherLogic.getDetails(weatherData.getZipCode().toString(),
						weatherData);

			} catch (Exception e) {

				e.printStackTrace();
				return new ModelAndView("showWetherError");
			}

		}

		if (weatherData.getErrorMessage() != null) {
			return new ModelAndView("wetherNotProcessed", "wetherData",
					weatherData);
		} else {
			return new ModelAndView("wetherSuccess", "wetherData", weatherData);
		}
		
	}

}
