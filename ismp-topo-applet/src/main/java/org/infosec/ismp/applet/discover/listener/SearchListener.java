package org.infosec.ismp.applet.discover.listener;

import java.util.List;
import java.util.Map;

import org.infosec.ismp.manager.rmi.tm.discover.model.Node;


/**
 * 搜索监听器接口
 * @author Wu Guojie
 * @date 2009-6-11
 * @version 1.0
 */
public interface SearchListener {
	/**
	 * 添加消息
	 * @param message
	 * 消息
	 */
	void addSearchMessage(String message);
	/**
	 * 刷新进度条
	 * @param percent
	 * 进度
	 */
	void reloadPercentBar(int percent);
	/**
	 * 搜索结束
	 * @param list
	 * 搜索结果
	 */
	void onSearchFinished(List<Node> list);
	/**
	 * 搜索结束
	 * @param map
	 * 搜索结果
	 */
	void onSearchFinished(Map<String,List> map);
	/**
	 * 能否搜索
	 * @param isRunning
	 * 是否正在搜索
	 */
	void canSearch(boolean isRunning);
	/**
	 * 远程服务没响应
	 */
	void remoteServiceNotResponse(String message);
	/**
	 * 远程方法执行出错
	 * @param executeName
	 * 执行的操作名称
	 */
	void remoteServiceExecuteError(String error);
	/**
	 * 输入参数错误
	 * @param error
	 * 错误内容
	 */
	void inputError(String error);
	/**
	 * 搜索过程出错
	 * @param error
	 * 错误内容
	 */
	void doSearchError(String error);
	/**
	 * 保存发现信息是否成功
	 * @param isSuccessed
	 * 是否成功
	 */
	void saveDBSuccessed(boolean isSuccessed);
}
