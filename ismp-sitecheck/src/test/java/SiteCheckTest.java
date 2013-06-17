import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.http.ConnectionManager;
import org.htmlparser.scanners.ScriptScanner;
import org.htmlparser.tags.ScriptTag;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.util.SimpleNodeIterator;
import org.infosec.ismp.sitecheck.HttpSiteMonitor;
import org.infosec.ismp.sitecheck.SiteCheck;
import org.infosec.ismp.sitecheck.SiteCheckParser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SiteCheckTest {
	public static void main(String[] args)  {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext*.xml");
		SiteCheck site =(SiteCheck) context.getBean("siteCheck");
		site.start();
		site.siteCheck("1", "www.163.com", 5000);
		
//		HttpSiteMonitor m = new HttpSiteMonitor("http://www.pudong.gov.cn");
//		m.httpOnline();
//		ConnectionManager manager = new ConnectionManager();
//		URL url = new URL("");
//		URLConnection con = url.openConnection();
//		con.setConnectTimeout(timeout);


		
		
//		/* 1 生成 HttpClinet 对象并设置参数*/
//		  HttpClient httpClient=new HttpClient();
//		  //设置 Http 连接超时为5秒
//		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
//		  
//		  /*2 生成 GetMethod 对象并设置参数*/
//		  GetMethod getMethod=new GetMethod(url);	 
//		  //设置 get 请求超时为 5 秒
//		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT,5000);
//		  //设置请求重试处理，用的是默认的重试处理：请求三次
//		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
//		          new DefaultHttpMethodRetryHandler());
//		  
//		  /*3 执行 HTTP GET 请求*/
//		  try{ 
//			  int statusCode = httpClient.executeMethod(getMethod);
//			  /*4 判断访问的状态码*/
//		      if (statusCode != HttpStatus.SC_OK) 
//		      {
//		System.err.println("Method failed: "+ getMethod.getStatusLine());
//		      }
//		  
//		      /*5 处理 HTTP 响应内容*/
//		      //HTTP响应头部信息，这里简单打印
//		  Header[] headers=getMethod.getResponseHeaders();
//		      for(Header  h:  headers)
//		  	      System.out.println(h.getName()+" "+h.getValue());
//		      //读取 HTTP 响应内容，这里简单打印网页内容
//		      byte[] responseBody = getMethod.getResponseBody();//读取为字节数组
//		System.out.println(new String(responseBody));
//		      //读取为 InputStream，在网页内容数据量大时候推荐使用
//		      InputStream response = getMethod.getResponseBodyAsStream();//
//		}
//		catch (HttpException e) 
//		{
//			  // 发生致命的异常，可能是协议不对或者返回的内容有问题
//				  System.out.println("Please check your provided http address!");
//		e.printStackTrace();
//			 } 
//		catch (IOException e)
//		  {
//			        // 发生网络异常
//				e.printStackTrace();
//			 } finally {
//				         /*6 .释放连接*/
//					getMethod.releaseConnection();		   
//				    }
//			

	}
}
