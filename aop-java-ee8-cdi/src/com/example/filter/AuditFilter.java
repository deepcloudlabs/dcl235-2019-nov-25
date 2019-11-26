package com.example.filter;

import java.io.IOException;
import java.time.ZonedDateTime;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "/*")
public class AuditFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
		HttpServletRequest _request = (HttpServletRequest) request;
		String queryString = _request.getQueryString();
		queryString = queryString == null ? "" : "?" + queryString;
		System.err.println("A request is received from " + _request.getRemoteHost() + ":" + _request.getRemotePort() + " to "
				+ _request.getServletPath() + queryString + " at "+ ZonedDateTime.now());
		try {
			chain.doFilter(request, response);
			System.err.println("The response is send at "+ZonedDateTime.now());
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
