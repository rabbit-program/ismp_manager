package org.infosec.ismp.applet.comm.util;


/**
 * 服务器路径获取工具类
 * 
 * @author hzhang
 * @date 2009-6-13
 * 
 */
public class ServerConfig {
    /**
     * 服务路径
     */
    private static String serverPath;
    private static String imagePath;
    /**
     * 服务器配置
     */
    private static ServerConfig config = null;

    /**
     * 服务器路径获取的工具类
     * 
     * @param serverPath
     */
    private ServerConfig(String serverPath) {
        this.serverPath = serverPath;

    }

    /**
     * 获取服务器路径
     * 
     * @return the serverPatth 服务器路径
     */
    public static String getServerPath() {
        return serverPath;
    }

    /**
     * 初始化服务器路径
     * 
     * @param serverPath
     *            服务器路径
     */
    public static void init(String serverPath) {

        if (config == null) {
            config = new ServerConfig(serverPath);

        }
    }

}
