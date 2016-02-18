package com.zpeng.web;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestInternalResourceViewResolverController {
	private static final Logger logger = LoggerFactory.getLogger(TestInternalResourceViewResolverController.class);
	
	@Autowired
    private ServletContext context;
    
	@RequestMapping("/testResolver")
	public ModelAndView toJsp(){
		logger.info("request testResolver.");
		Resource resource = new ServletContextResource(context, "/WEB-INF/web.xml");
		logger.info("------------" + resource.getFilename());;
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("name","toJsp");
		mv.setViewName("/jsp/test");
		return mv;
	}
}
