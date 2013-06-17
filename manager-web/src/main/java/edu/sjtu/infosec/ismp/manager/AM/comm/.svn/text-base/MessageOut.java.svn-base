package edu.sjtu.infosec.ismp.manager.AM.comm;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;
/**
 * @author sxq
 */
public class MessageOut {
	/**
	 * 
	 * 
	 * @param out
	 * @param message
	 */
	public static void println(HttpServletResponse response, String message) {
		try {
			System.out.println("Messageddddddddddddddd:"+message);
			response.getWriter().write("<html><body><script>alert('" + message + "');window.history.go(-2);</script><body></html>");			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void println(HttpServletResponse response, String message,int page) {
		try {
			response.getWriter().write("<html><body><script>alert('" + message + "');window.history.go("+page+");</script><body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * 
	 * @param out
	 * @param message
	 */
	public static void print(OutputStream out, String message) {
		try {
			out
					.write(("<html><body><script>alert('" + message + "');</script><body></html>")
							.getBytes());
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 
	 * @param out
	 * @param message
	 * @param url
	 *        
	 */
	public static void print(HttpServletResponse response, String message,
			String url) {
		try {
			OutputStream out = response.getOutputStream();
			out
					.write(("<html><body><script>alert('" + message
							+ "');window.parent['right'].location.reload('"
							+ url + "');</script><body></html>").getBytes());
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * 
	 * @param out
	 * @param message
	 */
	public static void printMessage(HttpServletResponse response, String message) {
		try {
			OutputStream out = response.getOutputStream();
			out.write(message.getBytes());
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * 
	 * @param out
	 * @param message
	 */
	public static void printlnError(HttpServletResponse response, String message) {
		try {
			OutputStream out = response.getOutputStream();
			out
					.write(("<html><body><script>alert('" + message + "');window.history.go(-1);</script><body></html>")
							.getBytes());
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
