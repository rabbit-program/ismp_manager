package org.infosec.ismp.sitecheck;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.htmlparser.Parser;
import org.htmlparser.util.ParserException;
import org.infosec.ismp.model.poller.PollStatus;
import org.infosec.ismp.model.poller.ServiceMonitor;
import org.infosec.ismp.poller.monitor.http.HttpMonitor;

public class HttpSiteMonitor {
	private String m_ipAddr;
	private String statusCode;
	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public long getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(long responseTime) {
		this.responseTime = responseTime;
	}

	private long responseTime=-1;
	public String getIpAddr() {
		return m_ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		m_ipAddr = ipAddr;
	}

	public HttpSiteMonitor(String ipAddr){
		m_ipAddr=ipAddr;
	}
	
	public void httpOnline() throws HttpException, IOException {
		/* 1 生成 HttpClinet 对象并设置参数*/
		HttpClient httpClient=new HttpClient();
		  //设置 Http 连接超时为5秒
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);		  
		  /*2 生成 GetMethod 对象并设置参数*/
		GetMethod getMethod=new GetMethod(m_ipAddr);	 
		  //设置 get 请求超时为 5 秒
		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT,5000);
		  //设置请求重试处理，用的是默认的重试处理：请求三次
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
		          new DefaultHttpMethodRetryHandler());
		 /*3 执行 HTTP GET 请求*/
	
		long startTime=System.currentTimeMillis();
		if(HttpStatus.SC_OK==httpClient.executeMethod(getMethod)){
			statusCode="Up";
			responseTime=System.currentTimeMillis()-startTime;
		}else
		{
			statusCode="Down";
			responseTime=-1;
		}
		
		 /*6 .释放连接*/
		getMethod.releaseConnection();
			
		
				
	}
	
}
