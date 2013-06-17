/**
 * 上海交通大学信息安全工程学院和上海鹏越惊鸿技术有限发展公司拥有所有版权。
 */
package org.infosec.ismp.agent.console;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Main类负责从AGENT_SERVER_HOME/lib中加载所有的类，从AGENT_SERVER_HOME/conf中加载所有的配置文件，
 * 然后启动Agent Server。启动程序时classpath中只需要包含Main类，其他依赖都可以放在/lib中，由Main去 寻找自动加载。
 * 
 * $Author: guoxw $ $Date: 2011-03-23 15:28:11 +0800 (周三, 23 三月 2011) $ $Revision: 3661 $
 * 
 */
public final class Main {
	public static final String TASK_DEFAULT_CLASS = "org.test.Test";

	
	static final String AGENT_HOME_PROPERTY = "ismp.agent.home";
	
	private Set<File> agentClassPath=  new HashSet<File>(5);

	/**
	 * Matches any file that has a name ending in ".jar".
	 */
	private static FilenameFilter m_jarFilter = new FilenameFilter() {
		public boolean accept(File dir, String name) {
			return name.endsWith(".jar");
		}
	};
	
	/**
	 * Matches any file that is a directory
	 */
	private static FileFilter m_dirFilter = new FileFilter() {
		public boolean accept(File pathname) {
			return pathname.isDirectory();
		}
	};

	private File m_agentHome;
	private ClassLoader m_classLoader;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Main app = new Main();
		
		List<String> tokens = new LinkedList<String>(Arrays.asList(args));
		app.parseExtensions(tokens);
		
		File confDir = new File(app.getAgentHome(),"conf");
		app.addClassPath(confDir);
		
		File homeLibDir = new File(app.getAgentHome(),"lib");
		app.addExtensionDirectory(homeLibDir);
		
		app.addClassPathList(System.getProperty("agent.classpath"));
		
		try{
			app.runTaskClass(tokens);
			System.exit(0);
		}catch(ClassNotFoundException e){
			System.out.println("Could not load class: " + e.getMessage());
            try {
                ClassLoader cl = app.getClassLoader();
                if (cl != null) {
                    System.out.println("Class loader setup: ");
                    printClassLoaderTree(cl);
                }
            } catch (MalformedURLException e1) {
            }
            System.exit(1);

		}catch(Throwable t){
			System.out.println("Failed to execute main task. Reason: " + t);
            System.exit(1);

		}
		
	}

	private void addClassPathList(String fileList) {
		if (fileList != null && fileList.length() > 0) {
            StringTokenizer tokenizer = new StringTokenizer(fileList, ";");
            while (tokenizer.hasMoreTokens()) {
                addClassPath(new File(tokenizer.nextToken()));
            }
        }

		
	}

	private void runTaskClass(List<String> tokens)throws Throwable {
		StringBuilder buffer = new StringBuilder();
        buffer.append(System.getProperty("java.vendor"));
        buffer.append(" ");
        buffer.append(System.getProperty("java.version"));
        buffer.append(" ");
        buffer.append(System.getProperty("java.home"));
        System.out.println("Java Runtime: " + buffer.toString());

        buffer = new StringBuilder();
        buffer.append("current="); 
        buffer.append(Runtime.getRuntime().totalMemory()/1024L); 
        buffer.append("k  free="); 
        buffer.append(Runtime.getRuntime().freeMemory()/1024L); 
        buffer.append("k  max="); 
        buffer.append(Runtime.getRuntime().maxMemory()/1024L); 
        buffer.append("k");
        System.out.println("  Heap sizes: " + buffer.toString());

        List jvmArgs = ManagementFactory.getRuntimeMXBean().getInputArguments();
        buffer = new StringBuilder(); 
        if(jvmArgs!=null){
            for (Object arg : jvmArgs) {
                buffer.append(" ").append(arg);
            }
        }
        System.out.println("    JVM args:" + buffer.toString());

        System.out.println("ISMP_AGENT_HOME: " + getAgentHome());

        ClassLoader cl = getClassLoader();
		Thread.currentThread().setContextClassLoader(cl);

        // Use reflection to run the task.
        try {
            String[] args = tokens.toArray(new String[tokens.size()]);
            Class task = cl.loadClass(TASK_DEFAULT_CLASS);
            Method runTask = task.getMethod("main", new Class[] {
                String[].class, InputStream.class, PrintStream.class
            });
            runTask.invoke(task.newInstance(), new Object[] {
                args, System.in, System.out
            });
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }

		
	}

	private static void printClassLoaderTree(ClassLoader cl) {
		// TODO Auto-generated method stub
		
	}

	private ClassLoader getClassLoader() throws MalformedURLException{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 将文件夹下的所有jar文件加入类路径，以及子文件下的文件
	 * @param homeLibDir
	 */
	private void addExtensionDirectory(File homeLibDir) {
		if(!homeLibDir.exists()){//文件夹不存在
			return;
		}
		if(!homeLibDir.isDirectory()){//不是文件夹
			addClassPath(homeLibDir);
			return;
		}
	    File[] jarFiles = homeLibDir.listFiles(m_jarFilter);
	    if(jarFiles!=null){
		    for(File tempFile :jarFiles){
		    	addClassPath(tempFile);
		    }
	    }

		
	    File[] dirFiles = homeLibDir.listFiles(m_dirFilter);
	    if(dirFiles!=null){
		    for(File tempFile :dirFiles){//遍历子文件夹
		    	addExtensionDirectory(tempFile);
		    }
	    }

		
	}

	/**
	 * 将文件加入类路径集合中
	 * @param classpath
	 */
	private void addClassPath(File classpath) {
		agentClassPath.add(classpath);
		
	}

	/**
	 * 解析字符List化的参数
	 * @param tokens
	 */
	private void parseExtensions(List<String> tokens) {
		if (tokens.isEmpty()) {
            return;
        }

        int count = tokens.size();
        int i = 0;

        // Parse for all --extdir and --noDefExt options
        while (i < count) {
			// String token = tokens.get(i);
			// // If token is an extension dir option
			// if (token.equals("--extdir")) {
			// // Process token
			// count--;
			// tokens.remove(i);
			//
			// // If no extension directory is specified, or next token is
			// // another option
			// if (i >= count || tokens.get(i).startsWith("-")) {
			// System.out.println("Extension directory not specified.");
			// System.out.println("Ignoring extension directory option.");
			// continue;
			// }
			//
			// // Process extension dir token
			// count--;
			// File extDir = new File(tokens.remove(i));
			//
			// if (!canUseExtdir()) {
			// System.out.println("Extension directory feature not available due to the system classpath being able to load: "
			// + TASK_DEFAULT_CLASS);
			// System.out.println("Ignoring extension directory option.");
			// continue;
			// }
			//
			// if (!extDir.isDirectory()) {
			// System.out.println("Extension directory specified is not valid directory: "
			// + extDir);
			// System.out.println("Ignoring extension directory option.");
			// continue;
			// }
			//
			// addExtensionDirectory(extDir);
			// } else if (token.equals("--noDefExt")) { // If token is
			// // --noDefExt option
			// count--;
			// tokens.remove(i);
			// useDefExt = false;
			// } else {
			// i++;
			// }
        }

		
	}

	/**
	 * 通过Main类所在的jar包所在路径
	 * 
	 * @return
	 */
	private static File findOwnJarLocation() {
		ClassLoader l = Thread.currentThread().getContextClassLoader();
		try {
			String classFile = Main.class.getName().replace('.', '/')
					+ ".class";
			URL url = l.getResource(classFile);

			JarURLConnection jarConnection = (JarURLConnection) url
					.openConnection();
			url = jarConnection.getJarFileURL();

			URI baseURI = new URI(url.toString()).resolve(".");
			return new File(baseURI).getCanonicalFile();

		} catch (Exception e) {
			// do nothing
		}
		return null;
	}

	/**
	 * Agent Server 所在目录
	 * 
	 * @return
	 */
	private File getAgentHome() {
		if (m_agentHome == null) {
			if (System.getProperty(AGENT_HOME_PROPERTY) != null) {
				m_agentHome = new File(System.getProperty(AGENT_HOME_PROPERTY));
			}
		}

		if (m_agentHome == null) {
			File jarFile = findOwnJarLocation();
			if (jarFile != null) {
				m_agentHome = jarFile.getParentFile();
			}
		}
		return m_agentHome;
	}

}
