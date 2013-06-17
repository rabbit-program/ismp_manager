package edu.sjtu.infosec.ismp.manager.EM.comm;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import edu.sjtu.infosec.ismp.manager.EM.util.ConvertUtil;
import edu.sjtu.infosec.ismp.manager.EM.util.CurrencyConverter;
import edu.sjtu.infosec.ismp.manager.EM.util.DateConverter;
import edu.sjtu.infosec.ismp.manager.EM.util.SqlTimestampConverter;

/**
* Action基类.
*
* @version 1.0 11 May 2009
* @author zhou chenye
*/
public class BaseAction extends DispatchAction{
    
    /**
     * 日志
     */
    protected final Log log = LogFactory.getLog(getClass());

    /**
     * defaultLong
     */
    private static  Long defaultLong = null;

    static {
        ConvertUtils.register(new CurrencyConverter(), Double.class);
        ConvertUtils.register(new DateConverter(), Date.class);
        ConvertUtils.register(new DateConverter(), String.class);
        ConvertUtils.register(new SqlTimestampConverter(null), Timestamp.class);
        ConvertUtils.register(new LongConverter(defaultLong), Long.class);
        ConvertUtils.register(new IntegerConverter(defaultLong), Integer.class);
    }
    
    /**
     * Convenience method to get Spring-initialized beans
     * 
     * @param name
     * Spring bean
     * @return Object bean from ApplicationContext
     */
    public Object getBean(String name) {
        ApplicationContext ctx = WebApplicationContextUtils
                .getRequiredWebApplicationContext(servlet.getServletContext());
        return ctx.getBean(name);
    }

    
    
    /**
     * @see edu.sjtu.infosec.ismp.manager.util.assessment.ConvertUtil#convert(java.lang.Object)
     * @param o
     * BO or Form
     * @throws Exception
     * Exception
     * @return Object
     * Object
     */
    protected Object convert(Object o) throws Exception {
        return ConvertUtil.convert(o);
    }

    /**
     * @see edu.sjtu.infosec.ismp.manager.util.assessment.ConvertUtil#convertLists(java.lang.Object)
     * 
     * @param o
     * Object
     * @throws Exception
     * Exception
     * @return Object
     * Object
     */
    protected Object convertLists(Object o) throws Exception {
        return ConvertUtil.convertLists(o);
    }

    /**
     * 获取查询参数
     * @param request
     * HttpServletRequest
     * @return 查询参数Map
     * @throws UnsupportedEncodingException 
     * UnsupportedEncodingException
     */
    public Map getParamMap(HttpServletRequest request) throws UnsupportedEncodingException {
        
        Map paramMap = new HashMap();
        Enumeration paramEnum = request.getParameterNames();
        while(paramEnum.hasMoreElements()) {
            
            //String encoding = "ISO-8859-1";
            String paramName = (String) paramEnum.nextElement();
            System.out.println(paramName);
            String paramValue = request.getParameter(paramName);
            
            if(paramValue != null && !"".equals(paramValue.trim())) {
                //paramValue = new String(paramValue.getBytes(encoding), "utf-8");
                System.out.println(paramValue);
                paramMap.put(paramName, paramValue);
                request.setAttribute(paramName, paramValue);
            }
        }
        
        return paramMap;
    }
    
    /**
     * Convenience method to initialize messages in a subclass.
     * 
     * @param request
     *            the current request
     * @return the populated (or empty) messages
     */
    public ActionMessages getMessages(HttpServletRequest request) {
        ActionMessages messages = null;
        HttpSession session = request.getSession();

        if (request.getAttribute(Globals.MESSAGE_KEY) != null) {
            messages = (ActionMessages) request
                    .getAttribute(Globals.MESSAGE_KEY);
            saveMessages(request, messages);
        } else if (session.getAttribute(Globals.MESSAGE_KEY) != null) {
            messages = (ActionMessages) session
                    .getAttribute(Globals.MESSAGE_KEY);
            saveMessages(request, messages);
            session.removeAttribute(Globals.MESSAGE_KEY);
        } else {
            messages = new ActionMessages();
        }

        return messages;
    }

    /**
     * Gets the method name based on the mapping passed to it
     * @param request
     *            the current request
     * @param mapping
     *            the current mapping
     * @return actionMethod
     */
    private String getActionMethodWithMapping(HttpServletRequest request,
            ActionMapping mapping) {
        return getActionMethod(request, mapping.getParameter());
    }

    /**
     * Gets the method name based on the prepender passed to it.
     * @param request
     *            the current request
     * @param prepend
     *            the method prepend
     * @return actionMethod           
     */
    protected String getActionMethod(HttpServletRequest request, String prepend) {
        String name = null;

        // for backwards compatibility, try with no prepend first
        name = request.getParameter(prepend);
        if (name != null) {
            // trim any whitespace around - this might happen on buttons
            name = name.trim();
            // lowercase first letter
            return name.replace(name.charAt(0), Character.toLowerCase(name
                    .charAt(0)));
        }

        Enumeration e = request.getParameterNames();

        while (e.hasMoreElements()) {
            String currentName = (String) e.nextElement();

            if (currentName.startsWith(prepend + ".")) {
                if (log.isDebugEnabled()) {
                    log.debug("calling method: " + currentName);
                }

                String[] parameterMethodNameAndArgs = StringUtils.split(
                        currentName, ".");
                name = parameterMethodNameAndArgs[1];
                break;
            }
        }

        return name;
    }
    
    
    
    /**
     * Convenience method for getting an action form base on it's mapped scope.
     * 
     * @param mapping
     *            The ActionMapping used to select this instance
     * @param request
     *            The HTTP request we are processing
     * @return ActionForm the form from the specifies scope, or null if nothing
     *         found
     */
    protected ActionForm getActionForm(ActionMapping mapping,
            HttpServletRequest request) {
        ActionForm actionForm = null;

        // Remove the obsolete form bean
        if (mapping.getAttribute() != null) {
            if ("request".equals(mapping.getScope())) {
                actionForm = (ActionForm) request.getAttribute(mapping
                        .getAttribute());
            } else {
                HttpSession session = request.getSession();
                actionForm = (ActionForm) session.getAttribute(mapping
                        .getAttribute());
            }
        }

        return actionForm;
    }

    /**
     * Convenience method to get the Configuration HashMap from the servlet
     * context.
     * 
     * @return the user's populated form from the session
     */
    public Map getConfiguration() {
        Map config = (HashMap) getServlet().getServletContext().getAttribute(
                Constants.CONFIG);

        // so unit tests don't puke when nothing's been set
        if (config == null) {
            return new HashMap();
        }

        return config;
    }

    /**
     * Convenience method for removing the obsolete form bean.
     * 
     * @param mapping
     *            The ActionMapping used to select this instance
     * @param request
     *            The HTTP request we are processing
     */
    protected void removeFormBean(ActionMapping mapping,
            HttpServletRequest request) {
        // Remove the obsolete form bean
        if (mapping.getAttribute() != null) {
            if ("request".equals(mapping.getScope())) {
                request.removeAttribute(mapping.getAttribute());
            } else {
                HttpSession session = request.getSession();
                session.removeAttribute(mapping.getAttribute());
            }
        }
    }

    /**
     * Convenience method to update a formBean in it's scope
     * 
     * @param mapping
     *            The ActionMapping used to select this instance
     * @param request
     *            The HTTP request we are processing
     * @param form
     *            The ActionForm
     */
    protected void updateFormBean(ActionMapping mapping,
            HttpServletRequest request, ActionForm form) {
        // Remove the obsolete form bean
        if (mapping.getAttribute() != null) {
            if ("request".equals(mapping.getScope())) {
                request.setAttribute(mapping.getAttribute(), form);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute(mapping.getAttribute(), form);
            }
        }
    }
    
    /**
     * map convert to xml
     * 
     * @param object
     *           map object
     * @return String xml
     */
//    protected String map2xml(Object object){
//        XStream xstream=new XStream(new DomDriver());
//        return xstream.toXML(object);       
//    }
//    
//    /**
//     * xml convert to map
//     * 
//     * @param xml
//     *          String xml
//     * @return Object map
//     */
//    public Object xml2map(String xml){
//        XStream xstream=new XStream(new DomDriver());
//        return xstream.fromXML(xml);        
//    }

}
