package org.infosec.ismp.agent.winsensor.communication.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mortbay.jetty.handler.AbstractHandler;

/**
 * @author Rocky
 * @version create time：Sep 21, 2010 10:19:04 AM
 * 
 */
public class HelloHandler extends AbstractHandler {

	@Override
	public void handle(String target, HttpServletRequest request,
			HttpServletResponse response, int dispatch) throws IOException,
			ServletException {
//		response.setContentType("text/html;charset=utf-8");
//		response.setStatus(HttpServletResponse.SC_OK);
//		response.getWriter().println("<h1>Hello World</h1>");
		
		String urlInfo = request.getParameter("xml");
		System.out.println(urlInfo);
	}

}
