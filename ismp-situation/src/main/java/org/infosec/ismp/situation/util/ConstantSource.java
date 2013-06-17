package org.infosec.ismp.situation.util;

public class ConstantSource {
	
	public static final int PORT = 5000;///UDP接收端口。
	
	public static final int SPACETIME = 3000;///间隔时间：3000毫秒。
	
	public static final int CACHEFIRSTSIZE = 100;///队列一级缓冲区的大小(用来接收分组前事件的队列大小)。

	public static final int CACHESECONDSIZE = 5;///队列二级缓冲区的大小(用来存放分组后事件的队列大小)。
	
	public static final int LISTSIZE = 20;///接收到的数据报解析之后放到一个list，然后达到LISTSIZE之后开始分组。
	
	public static final int ANALYSETIME = 3000;///事件数据分析间隔时间。
}
