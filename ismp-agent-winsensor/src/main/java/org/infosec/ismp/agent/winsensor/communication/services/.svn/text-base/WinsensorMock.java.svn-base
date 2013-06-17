package org.infosec.ismp.agent.winsensor.communication.services;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.eclipse.jetty.client.ContentExchange;
import org.eclipse.jetty.client.HttpClient;



/**
 * @author Rocky
 * @version create time：Sep 27, 2010 2:00:56 PM
 * 
 */
public class WinsensorMock {
	
	public void synchronousRequest() {
		HttpClient httpClient = new HttpClient();
		httpClient.setConnectorType(HttpClient.CONNECTOR_SELECT_CHANNEL);
		
		try {
			httpClient.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ContentExchange contentExchange = new ContentExchange();
		contentExchange.setMethod("GET");
		contentExchange.setURL("http://localhost:8080/hostResource?xml=cpu");
		
		try {
			httpClient.send(contentExchange);
			contentExchange.waitForDone();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Response status: "+contentExchange.getResponseStatus());
		
		String responseContent;
		try {
			responseContent = contentExchange.getResponseContent();
			System.out.println("responseContent: " + responseContent);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void asynchronousRequest() {
		HttpClient client = new HttpClient();
		client.setConnectorType(HttpClient.CONNECTOR_SELECT_CHANNEL);
		
		try {
			client.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ContentExchange exchange = new ContentExchange(){
			@Override
			protected void onResponseComplete() throws IOException {
				super.onResponseComplete();
				String responseContent = this.getResponseContent();
				
				System.out.println("responseContent: " + responseContent);
			}
		};
		
		exchange.setMethod("GET");
		exchange.setURL("http://localhost:8080");
		
		try {
			client.send(exchange);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WinsensorMock mock = new WinsensorMock();
		mock.synchronousRequest();
//		mock.asynchronousRequest();
	}

}
