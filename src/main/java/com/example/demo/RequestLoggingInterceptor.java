package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RequestLoggingInterceptor implements HandlerInterceptor {
	
	private static final Logger logger= LoggerFactory.getLogger(RequestLoggingInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response) {
		logger.info("Incoming Request: Methos={}, URI={}, IP={}", request.getMethod(), request.getRequestURI(), request.getRemoteAddr());
		return true;
	}

	public void  postHandle(HttpServletRequest request, HttpServletResponse response) {
		//log after the handler has executed but before the view is render
	}
}
