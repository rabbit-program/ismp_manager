package edu.sjtu.infosec.ismp.manager.VPM.pm.comm;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * create Ajax 解析对象
 * @author LiuQing
 *
 */
public class HtmlFactory {
	/**
	 * 编码转换 （解决中文乱码问题）
	 * @param name
	 */
	public static String conversionCoding(String name)
	{
		return setConversionCoding(name,"UTF-8");
	}
	public static String conversionCoding(String name,String charcode)
	{
		return setConversionCoding(name,charcode);
	}
	private static String setConversionCoding(String name,String charcode){
		 try {
				return new String(name.getBytes("iso-8859-1"),charcode);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return null;
	}
	/**
	 * 判断是否为Null
	 * @param obj
	 * @return
	 */
	public static boolean isNotNull(Object obj)
	{
		return obj != null;
	}
	/**
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str)
	{
		if(isNotNull(str))
		{
			return !"".equals(str);
		}
		return false;
	}
    public static Object reflectionObject(Object obj,String getMethodName)
    {
          try {
			  Class<?> classType = obj.getClass(); 
			  Method getMethod = classType.getMethod(getMethodName, new Class[]{}); 
			  return  getMethod.invoke(obj, new Object[]{});
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
    }
    /**
     * 把数据冲刷到页面
     * @param response 请求相应
     * @param sbf 
     */
    public static void flushData(HttpServletResponse response,StringBuffer sbf)
    {
    	response.setContentType("text/xml;charset=utf-8");
		PrintWriter out;
		try {
			sbf.insert(0,"<List>");
			sbf.insert(sbf.length(),"</List>");
			out = response.getWriter();
			out.println(sbf.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	/**
	 * 获取分页对象
	 * @return Page
	 */
	public static PMPage getPage(HttpServletRequest request)
	{
		PMPage page = new PMPage();
		// 获得当前页
		String curpage = request.getParameter("curpage") != null
				&& (!request.getParameter("curpage").equals("")) ? request
				.getParameter("curpage") : "1";
		// 设置当前页跟开始位置
		page.setCurrentPage(Integer.parseInt(curpage));
		//设置当前页跟开始位置
		page.setBeginIndex((page.getCurrentPage() - 1) * page.getEveryPage());
		return page;
	}
	private static void beginData(StringBuffer sbf,String bs)
	{
		sbf.append("<"+bs+">");
	}
	private static void endData(StringBuffer sbf,String bs)
	{
		sbf.append("</"+bs+">");
	}
    private static void getObjectDataArray(Map<Object,Map<String,String>> objMap,StringBuffer sbf,Map<String,Object[]> args)
    {
    	for(Iterator<Map.Entry<Object, Map<String,String>>> iters =objMap.entrySet().iterator();iters.hasNext();){
    		Entry<Object, Map<String,String>> maps = iters.next();
    		for(Iterator<Map.Entry<String, String>> iter =maps.getValue().entrySet().iterator();iter.hasNext();){
    			Entry<String,String>  map = iter.next();
    			Object ele =reflectionObject(maps.getKey(), map.getValue());
    			ele =comparisonKey(args,map,ele);
    			sbf.append("<"+map.getValue()+">").append(ele == null ?"":ele).append("</"+map.getValue()+">");
    		}
    	}
    }
    private static Object comparisonKey(Map<String,Object[]> map,Entry<String,String> key,Object value){
    	if(!(map == null) && !(value == null)){
	    	 for(Iterator<Map.Entry<String, Object[]>> iter= map.entrySet().iterator();iter.hasNext();){
	    		 Entry<String, Object[]> entry = iter.next();
	    		 if(entry.getKey().equals(key.getValue())){
	    			 if(entry.getValue().length == 1){
	    				 Object[][] obx = (Object[][]) entry.getValue()[0];
	    				 for(Object[] oa : obx){
		    				 if(oa[0].toString().equals(value.toString())){
		    					 key.setValue(key.getKey());
		    					 return oa[1];
		    				 }
	    				 }
	    			 }else if(entry.getValue().length == 2){
	    				 Object[][] obx = (Object[][]) entry.getValue()[1];
	    				 key.setValue((String) entry.getValue()[0]);
	    				 for(Object[] oa : obx){
	    					 if(oa.length == 2 && oa[0].toString().equals(value.toString())){
	    						  return oa[1];
	    					 }else if(oa.length == 3 && entry.getValue()[0].equals(key.getKey())){
	       						 if(oa[0].toString().equals(value.toString())){
	    							 return oa[1];
	    						 }else{
	    							 return oa[2];
	    						 }
	    					 }
	    				 }
	    			 }	
	    		 }
	    	 }
    	}
    	key.setValue(key.getKey());
    	return value;
    }
    private static void getObjectDataArray(Object[] obj,StringBuffer sbf)
    {
    	  sbf.append("<"+obj[0]+">").append(obj[1] == null ?"":obj[1]).append("</"+obj[0]+">");
    }
    private static void getObjectArray(Object[][] objs,Object obj,StringBuffer sbf,String bs)
    {
    	Map<Object,Map<String,String>> maps = new HashMap<Object,Map<String,String>>(); 
    	Map<String,Object[]> mapValue=new HashMap<String,Object[]>();
    	Map<String,String> map = null;
    	beginData(sbf,bs);
		  if(!(obj == null)){
			  map=new HashMap<String,String>();
			  reflectionMap(obj,map,objs,mapValue);
			  maps.put(obj, map);
		  }
		  if(!(objs == null)){
			   for(Object[] objstr: objs){
                   if(!(objstr[0] == null)){
	   				    if("String".equals(objstr[0].getClass().getSimpleName())){
	   				    	if("ADD".equals(objstr[0].toString().toUpperCase())){
		   				    		if("String[][]".equals(objstr[1].getClass().getSimpleName())){
		   				    			Object[][] objts =(Object[][]) objstr[1];
		   				    			for(Object[] oj : objts){
		   				    				getObjectDataArray(oj,sbf);
		   				    			}
		   				    		}else{
		   				    			objstr[0] = objstr[1];
		   				    			objstr[1] = objstr[2];
		   				    			getObjectDataArray(objstr,sbf);
		   				    		}
		   				    	}
					    }else{
                             if(objstr.length > 1){
	                                 if(!(objstr[1] == null)){
	 	 					    		Object[][] oele =(Object[][]) objstr[1];
	 	 					    		map  =new HashMap<String,String>();
	 						    		for(Object[] objeles : oele){
		 				   				    	if(objeles.length == 2){
		 					   				    	if("String[][]".equals(objeles[1].getClass().getSimpleName())){
		 					   				    	     if(!(objeles[1] == null)){
		 					   				    	    	    Object[] o ={(String[][])objeles[1]};
		 					   				    				mapValue.put(objeles[0].toString(),o);
		 					   				    		}
		 					   				    	  
		 					   				    	}
		 				   				    	}else if(objeles.length ==3){
		 					   				    	if("String[][]".equals(objeles[2].getClass().getSimpleName())){
		 					   				    	     if(!(objeles[2] == null)){
		 					   				    	    	    Object[] o ={objeles[0],objeles[2]};
		 					   				    				mapValue.put(objeles[1].toString(),o);
		 					   				    		}
		 					   				    	}
		 				   				    	}
		 				   				     map.put(objeles[0].toString(), objeles[1].toString());
	 						    		}
	 						    		  maps.put(objstr[0], map);
	                              }
                             }
					    }
                   }
			   }
		  }
		 getObjectDataArray(maps,sbf,mapValue);
		 endData(sbf, bs);
    }
    private static void reflectionMap(Object obj,Map<String,String> map,Object[][] args,Map<String,Object[]> mapvalue){
	       Class<?> classType = obj.getClass();       
		   Field fieldList[] = classType.getDeclaredFields();   
		   try {
				   for(Field field : fieldList) {
					  	  String fieldName = field.getName();       
						  String firstLetter = fieldName.substring(0, 1).toUpperCase();      
						  String getMethodName = "get" + firstLetter + fieldName.substring(1);
					      map.put(fieldName, getMethodName);
				  }
		     }catch(Exception e) {
				 e.printStackTrace();
			 }  
		     if(!(args == null)){
		    	 for(Object[] objts : args){
		    		 if(objts[0] == null){
		    			 map.remove(objts[1]);
		    		 }else if(objts.length == 3){
		    			     Object[][] cObj = (Object[][]) objts[2];
		    			     if(cObj[0].length == 3){
		    			    	 map.put(objts[0].toString(), objts[1].toString());
		    			     } 
		    				 Object[] objx={objts[0],cObj};
		    				 mapvalue.put(objts[1].toString(), objx);
		    			 }
		    		 }
		    	 }
    }
    public static void getDataArray(Object obj,StringBuffer sbf){
    	getObjectArray(null,obj,sbf,"SH");
    }    
    public static void getDataArray(Object obj,StringBuffer sbf,String bs){
    	getObjectArray(null,obj,sbf,bs);    	
    }
    public static void getDataArray(Object obj,StringBuffer sbf,Object[][] objs){
    	getObjectArray(objs,obj,sbf,"SH");    	
    }
    public static void getDataArray(Object obj,StringBuffer sbf,String bs,Object[][] objs){
    	getObjectArray(objs,obj,sbf,bs); 
    }
    public static void getDataArray(Object obj,StringBuffer sbf,Object[][] objs,String bs){
    	getObjectArray(objs,obj,sbf,bs); 
    }
    public static void getDataArray(Object[][] objs,StringBuffer sbf,String bs)
    {
    	getObjectArray(objs,null,sbf,bs);
    }
    public static void getDataArray(Object[][] objs,StringBuffer sbf)
    {
    	getObjectArray(objs,null,sbf,"SH");	
    }

}
