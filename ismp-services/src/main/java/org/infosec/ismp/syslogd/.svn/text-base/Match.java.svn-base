package org.infosec.ismp.syslogd;

import java.io.Serializable;

/**
 * 定义匹配类型
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 *
 */
public class Match implements Serializable {
	private String type;// 匹配类型（substr或者regex)
	private String expression;

	public Match(String type, String expression) {
		this.type = type;
		this.expression = expression;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

}
