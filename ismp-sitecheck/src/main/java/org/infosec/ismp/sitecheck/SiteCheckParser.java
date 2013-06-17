package org.infosec.ismp.sitecheck;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javassist.expr.NewArray;

import org.apache.log4j.Logger;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.scanners.ScriptScanner;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.ScriptTag;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.util.SimpleNodeIterator;

public class SiteCheckParser {	
	private String url;
	public SiteCheckParser(String url) throws ParserException{
		this.url=url;
	}
	
	/**
	 * 解析页面超链元素
	 * @param nodeid
	 * @return
	 * @throws ParserException
	 */
	public  Set getLinkText() throws ParserException {
		Set linkSet = new HashSet();
		Parser parser = new Parser(url);
		parser.setEncoding("UTF-8");
		NodeFilter filter = new NodeClassFilter(LinkTag.class);
		NodeList links = new NodeList();
		for (NodeIterator e = parser.elements(); e.hasMoreNodes();) {
			e.nextNode().collectInto(links, filter);
		}		
		String tmp_url = url.trim().toLowerCase().replaceFirst("http://", "");//去除HTTP头			
		tmp_url =tmp_url.split("/")[0].split(":")[0];//获取网站主页URL	
		for (int i = 0; i < links.size(); i++) {
			LinkTag linktag = (LinkTag) links.elementAt(i);		
			if(0!=linktag.getLink().trim().toLowerCase().replaceFirst("http://", "").indexOf(tmp_url)){		//如果不是同站链接
				linkSet.add(linktag.getLink());	
			}			
		}
		return linkSet;
	}
	/**
	 * 解析页面script
	 * @param nodeid
	 * @return
	 * @throws ParserException 
	 * @throws NoSuchAlgorithmException 
	 */
	public  Set getScriptText() throws ParserException, NoSuchAlgorithmException {
		Set scriptSet = new HashSet();	
		Parser parser = new Parser(url);		
		parser.setEncoding("UTF-8");
		NodeFilter filter = new NodeClassFilter(ScriptTag.class);	
		ScriptScanner.STRICT = false;//忽略script中的引号
		NodeList scriptList = new NodeList();
		for (NodeIterator e = parser.elements(); e.hasMoreNodes();) {
			e.nextNode().collectInto(scriptList, filter);
		}
//		int size=0;
		for (SimpleNodeIterator iterator = scriptList.elements(); iterator
				.hasMoreNodes();) {
			ScriptTag scripttag = (ScriptTag) iterator.nextNode();
			if (null != scripttag.getScriptCode()
					&& !"".equals(scripttag.getScriptCode())) {
				String md5 = getMD5(scripttag.getScriptCode().getBytes());				
				scriptSet.add(md5);
//				size++;
			}
		}		
//		System.out.println("size:"+size);
//		System.out.println("scriptList:"+scriptList.size());
//		System.out.println("scriptSet:"+scriptSet.size());
		return scriptSet;
	}

	public static String getMD5(byte[] source) throws NoSuchAlgorithmException {
		String s = null;
		char hexDigits[] = { // 用来将字节转换成 16 进制表示的字符
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
				'e', 'f' };
		
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			md.update(source);
			byte tmp[] = md.digest(); // MD5 的计算结果是一个 128 位的长整数，
			// 用字节表示就是 16 个字节
			char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
			// 所以表示成 16 进制需要 32 个字符
			int k = 0; // 表示转换结果中对应的字符位置
			for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
				// 转换成 16 进制字符的转换
				byte byte0 = tmp[i]; // 取第 i 个字节
				str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
				// >>> 为逻辑右移，将符号位一起右移
				str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
			}
			s = new String(str); // 换后的结果转换为字符串	
		return s;
	}
}
