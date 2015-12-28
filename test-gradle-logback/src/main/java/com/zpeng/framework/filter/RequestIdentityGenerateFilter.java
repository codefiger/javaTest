package com.zpeng.framework.filter;

import java.io.IOException;
import java.util.Random;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class RequestIdentityGenerateFilter implements Filter {
	private static Random random = new Random();

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		int randomInt = random.nextInt();
		String randomStr = String.format("%08x", randomInt);
		res.setHeader("rpid", randomStr);
		org.slf4j.MDC.put("rpid", String.format("[rpid=%s]", randomStr));
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

}
