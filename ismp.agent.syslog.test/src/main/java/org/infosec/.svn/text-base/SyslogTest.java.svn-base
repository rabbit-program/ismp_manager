package org.infosec;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import org.infosec.ismp.model.Syslog;
import org.infosec.ismp.model.syslog.SyslogParser;

public class SyslogTest {
	private String m_parserClassName;

	private int m_port;

	private SyslogParser m_parser;

	public void start() throws Exception {
		DatagramSocket socket = new DatagramSocket(514);
		while (true) {
			byte[] buff = new byte[0xff];
			DatagramPacket pkt = new DatagramPacket(buff, 0, buff.length);
			socket.receive(pkt);
			if (m_parser == null) {
				try {
					Class clz = Class.forName(m_parserClassName);
					m_parser = (SyslogParser) clz.newInstance();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			if (m_parser != null) {
				byte[] data = pkt.getData();
				boolean flag = m_parser.isRightSyslog(data, data.length);
				if (flag) {
					Syslog syslog = m_parser.parseSyslog(data, data.length);
				}
			}
		}
	}

	public void setParserClassName(String parserClassName) {
		m_parserClassName = parserClassName;
	}

	public void setPort(int port) {
		m_port = port;
	}

}
