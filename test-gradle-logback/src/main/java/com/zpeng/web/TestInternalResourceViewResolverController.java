package com.zpeng.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestInternalResourceViewResolverController {
	private static final Logger logger = LoggerFactory.getLogger(TestInternalResourceViewResolverController.class);
	
	@RequestMapping("/testResolver")
	public ModelAndView toJsp(){
		logger.info("request testResolver.");
		ModelAndView mv = new ModelAndView();
		mv.addObject("name","toJsp");
		mv.setViewName("/jsp/test");
		return mv;
	}
}
