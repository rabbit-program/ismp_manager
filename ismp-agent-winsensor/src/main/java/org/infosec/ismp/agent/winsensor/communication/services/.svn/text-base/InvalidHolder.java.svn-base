package org.infosec.ismp.agent.winsensor.communication.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Rocky
 * @version create time：Sep 29, 2010 4:00:45 PM
 * 
 */
public class InvalidHolder extends HttpServlet {

	private static final long serialVersionUID = -3212517884826475043L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String remoteAddr = req.getRemoteAddr();
		System.out.println("Invalid addr: " + remoteAddr);
	}
}
