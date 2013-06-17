package edu.sjtu.infosec.ismp.manager.BSAM.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.web.context.support.WebApplicationContextUtils;

import edu.sjtu.infosec.ismp.manager.BSAM.model.MachineRoom;
import edu.sjtu.infosec.ismp.manager.BSAM.service.MachineRoomService;
import edu.sjtu.infosec.ismp.manager.BSAM.service.SubUnitSituationService;
import edu.sjtu.infosec.ismp.util.EscapeUnescape;

public class JiFangServlet extends HttpServlet {
	
    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
	
    	ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(req.getSession().getServletContext());
    	
    	MachineRoomService machineRoomService = (MachineRoomService) ctx.getBean("machineRoomService");
    	SubUnitSituationService subUnitSituationService = (SubUnitSituationService) ctx.getBean("subUnitSituationService");
//    	JiFangRemoteService remoteJiFangService = (JiFangRemoteService) ctx.getBean("remoteJiFangService");
//    	MachineRoomSituationManager machineRoomSituationManager = (MachineRoomSituationManager) ctx.getBean("machineRoomSituationManager");
    	PrintWriter out = resp.getWriter();
		String value = "";
		String oper = req.getParameter("oper");
		String id = req.getParameter("name");///机房这里的name指的是机房id
		id = id == null ? "1" : id;
		id = EscapeUnescape.unescape(id);
//        Integer id = 0;
//        List<MachineRoom>  machineRoomList = machineRoomService.getMachineRoomByName(name);
//		if(null != machineRoomList && null != machineRoomList.get(0)){
//			id = machineRoomList.get(0).getId();
//		}
        if(oper.equals("getInitValue")){
        	
        	//value = remoteJiFangService.getInitValues(new Integer(locationIdentify) , name);
        	try {
        		value = subUnitSituationService.getInitValues(Integer.parseInt(id),"JiFang");
//        		value = "ColorRange{red:80;yellow:60;green:40} SubNodes{默认机柜:0;E4机柜:0;C7机柜:0;C4机柜:0;D4机柜:0;A4机柜:0;7号楼3楼:0;6号楼2楼203:0;6号楼2层-1:0;6号楼2层52:0;6号楼2楼22:0;59:0;6号楼2楼6:0;1号楼7楼:0;6号楼2层－5:0;6号楼2层61:0;6号楼2层-9:0;1号楼712:0;6号楼2层039:0;6号楼2楼24:0;6号楼2层-7:0;054:0;4号楼1楼:0;6号楼2层-4:0;6号楼2楼32:0;6号楼2层-57:0;4-1:0;6号楼2层-40:0;6号楼2层53:0;6号楼2层-19:0;1号楼2楼:0;6号楼2层-60:0;6号楼2层-29:0;6号楼2层-66:0;5号楼4楼:0;6号楼2层-48:0;6号楼2楼56:0;6号搂2层-8:0;6号楼2楼20:0;6号楼2楼12:0;6号楼2楼:0;54:0;6号楼2层-74:0;45:0;6号楼2层201:0;73:0;4号楼113:0;6号楼2层42:0;9号楼2楼:0;411:0} HistoryValue{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}";
			} catch (DataAccessResourceFailureException e) {
				e.printStackTrace();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
        }else if(oper.equals("getCurrentValue")){
        	value = subUnitSituationService.getCurrentValues(Integer.parseInt(id), "JiFang");
        	//value = remoteJiFangService.getCurrentValues(new Integer(locationIdentify), name);
//        	value = machineRoomSituationManager.getCurrentValues(name);
//        	value = "ColorRange{red:80;yellow:60;green:40} SubNodes{默认机柜:0;E4机柜:0;C7机柜:0;C4机柜:0;D4机柜:0;A4机柜:0;7号楼3楼:0;6号楼2楼203:0;6号楼2层-1:0;6号楼2层52:0;6号楼2楼22:0;59:0;6号楼2楼6:0;1号楼7楼:0;6号楼2层－5:0;6号楼2层61:0;6号楼2层-9:0;1号楼712:0;6号楼2层039:0;6号楼2楼24:0;6号楼2层-7:0;054:0;4号楼1楼:0;6号楼2层-4:0;6号楼2楼32:0;6号楼2层-57:0;4-1:0;6号楼2层-40:0;6号楼2层53:0;6号楼2层-19:0;1号楼2楼:0;6号楼2层-60:0;6号楼2层-29:0;6号楼2层-66:0;5号楼4楼:0;6号楼2层-48:0;6号楼2楼56:0;6号搂2层-8:0;6号楼2楼20:0;6号楼2楼12:0;6号楼2楼:0;54:0;6号楼2层-74:0;45:0;6号楼2层201:0;73:0;4号楼113:0;6号楼2层42:0;9号楼2楼:0;411:0} HistoryValue{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}";
        }else if(oper.equals("getHistoryValue")){
        	//value = remoteJiFangService.getHistoryValue(null, null, new Integer(locationIdentify), name, 1);
        	String beginTime = req.getParameter("beginTime");
        	String endTime = req.getParameter("endTime");
        	beginTime = EscapeUnescape.unescape(beginTime);
        	endTime = EscapeUnescape.unescape(endTime);
        	String firstIndex = req.getParameter("firstIndex");
        	firstIndex = (firstIndex == null) ? "0" : firstIndex;
            try {
            	value = subUnitSituationService.getHistoryValue(beginTime, endTime, Integer.parseInt(id), "JiFang", new Integer(firstIndex));
//            	value = machineRoomSituationManager.getHistoryValue(beginTime, endTime, name, new Integer(firstIndex));
//            	value = "ColorRange{red:80;yellow:60;green:40} SubNodes{默认机柜:0;E4机柜:0;C7机柜:0;C4机柜:0;D4机柜:0;A4机柜:0;7号楼3楼:0;6号楼2楼203:0;6号楼2层-1:0;6号楼2层52:0;6号楼2楼22:0;59:0;6号楼2楼6:0;1号楼7楼:0;6号楼2层－5:0;6号楼2层61:0;6号楼2层-9:0;1号楼712:0;6号楼2层039:0;6号楼2楼24:0;6号楼2层-7:0;054:0;4号楼1楼:0;6号楼2层-4:0;6号楼2楼32:0;6号楼2层-57:0;4-1:0;6号楼2层-40:0;6号楼2层53:0;6号楼2层-19:0;1号楼2楼:0;6号楼2层-60:0;6号楼2层-29:0;6号楼2层-66:0;5号楼4楼:0;6号楼2层-48:0;6号楼2楼56:0;6号搂2层-8:0;6号楼2楼20:0;6号楼2楼12:0;6号楼2楼:0;54:0;6号楼2层-74:0;45:0;6号楼2层201:0;73:0;4号楼113:0;6号楼2层42:0;9号楼2楼:0;411:0} HistoryValue{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}";
			} catch (DataAccessResourceFailureException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
        }
//        System.out.println(value);
        out.println(EscapeUnescape.escape(value));
	}
}
