package com.carnote.controller;

import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carnote.utils.HttpUtils;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/kakao.htm", method = RequestMethod.GET)
	public String kakao(HttpServletRequest req, Model model) {
		
		String url = "https://kauth.kakao.com/oauth/authorize?client_id=03af96156f4ca7cf793f550ada6581e7&redirect_uri=http://dohee.net&response_type=code";
		String zzz = HttpUtils.get(url);
		
		
		model.addAttribute("data", zzz);
		//model.addAttribute("serverTime", formattedDate );
		
		return "common/server_response";
	}
	
	
}
