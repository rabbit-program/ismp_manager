/**   
* @Title: HttpsMonitor.java
* @Package org.infosec.ismp.poller.monitor
* @Description: TODO(用一句话描述该文件做什么)
* @author guoxianwei  
* @date 2010-9-14 上午10:05:39
* @version V1.0   
*/


package org.infosec.ismp.poller.monitor;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import java.security.cert.CertificateException;
import org.infosec.ismp.poller.monitor.http.HttpMonitor;

import org.infosec.ismp.util.ParameterMap;

/**
 * @ClassName: HttpsMonitor
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author guoxianwei
 * @date 2010-9-14 上午10:05:39
 * 
 */
public class HttpsMonitor extends HttpMonitor{

    /**
     * Default HTTPS ports.
     */
    private static final int[] DEFAULT_PORTS = { 8443 };

    protected int[] determinePorts(Map<String, Object> parameters) {
        return ParameterMap.getKeyedIntegerArray(parameters, "port", DEFAULT_PORTS);
    }

    protected Socket wrapSocket(Socket socket) throws IOException {
        SSLSocketFactory sslSF = null;
        TrustManager[] tm = { new RelaxedX509TrustManager() };
        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, tm, new java.security.SecureRandom());
        } catch (NoSuchAlgorithmException e) {
            log().error("wrapSocket: Error wrapping socket, throwing runtime exception..."+e);
            throw new IllegalStateException("No such algorith in SSLSocketFactory: "+e);
        } catch (KeyManagementException e) {
            log().error("wrapSocket: Error wrapping socket, throwing runtime exception..."+e);
            throw new IllegalStateException("Key management exception in SSLSocketFactory: "+e);
        }
        sslSF = sslContext.getSocketFactory();
        Socket wrappedSocket;
        InetAddress inetAddress = socket.getInetAddress();
        String hostAddress = inetAddress.getHostAddress();
        int port = socket.getPort();
        wrappedSocket = sslSF.createSocket(socket, hostAddress, port, true);
        return wrappedSocket;
    }
     final class RelaxedX509TrustManager implements X509TrustManager {
        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
        }

        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
        }

        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }
}

