package com.crazybunqnq.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	private String charEncoding = null;
    /**
     * Default constructor. 
     */
    public EncodingFilter() {
    }

    public void init(FilterConfig fConfig) throws ServletException {
    	charEncoding = fConfig.getInitParameter("encoding");
    	if (charEncoding == null) {
			throw new ServletException("EncodingFilter中的编码设置为空！！！");
		}
    }

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//如果当前应用的编码与请求的编码不一致，则将请求编码设置为当前应用默认的编码，将response的编码也设置为当前应用默认的编码
		if (!charEncoding.equals(request.getCharacterEncoding())) {
			request.setCharacterEncoding(charEncoding);
		}
		response.setCharacterEncoding(charEncoding);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}
}
