package edu.sjtu.infosec.ismp.manager.AM.web.actions;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.CategoryDataset;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceVO;
import edu.sjtu.infosec.ismp.manager.AM.model.DeviceChartVO;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetDeviceService;
import edu.sjtu.infosec.ismp.manager.AM.comm.DeviceCountChart;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;
import edu.sjtu.infosec.ismp.security.Domain;


public class DeviceAnalysisAction extends Action {
	private AssetDeviceService assetDeviceService;
	private DomainService domainService;

	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}

	public void setAssetDeviceService(AssetDeviceService assetDeviceService) {
		this.assetDeviceService = assetDeviceService;
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		AssetDeviceBO bean = new AssetDeviceBO();
		Integer locId = null;
		if (request.getParameter("locid") != null && !"-1".equals(request.getParameter("locid"))) {
			locId = Integer.parseInt(request.getParameter("locid").toString());
			bean.setLocationId(locId);
		}else{
			bean.setLocationId(null);
		}
		List<DeviceChartVO> datas = assetDeviceService.getDeviceChartData(bean);
		CategoryDataset dataset = DeviceCountChart.createDataset(datas);
		JFreeChart chart = DeviceCountChart.createChart(dataset);
		String path = ServletUtilities.saveChartAsPNG(chart, 1000, 400, request
				.getSession());
		request.setAttribute("deviceImg", path);
		request.setAttribute("locid", locId);
		request.getSession().setAttribute("topcss", "analysis");
//		
//		Page page = new Page();
//		page.setEveryPage(20);
//		String curpage = request.getParameter("curpage") == null ? "1"
//				: request.getParameter("curpage");
//		page.setCurrentPage(Integer.parseInt(curpage));
//		page.setBeginIndex((page.getCurrentPage() - 1) * page.getEveryPage());
//		
//		
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		String domainid = request.getParameter("domainid");
//		String startDate = request.getParameter("startDate");
//		String endDate = request.getParameter("endDate");
//		String deviceType = request.getParameter("deviceType");
//		List<Domain> domainList = new ArrayList<Domain>();
//		domainList.add(domainService.findById(Integer.parseInt(domainid)));
//		Timestamp startRecordTime = new java.sql.Timestamp( df.parse(startDate).getTime());
//		Timestamp endRecordTime = new java.sql.Timestamp( df.parse(endDate).getTime());
//		
//		List<AssetDeviceBO> list = assetDeviceService.findAllByDomain(domainList, startRecordTime, endRecordTime, page.getCurrentPage(), page.getEveryPage());
//		page = PageUtil.createPage(page.getEveryPage(), page.getCurrentPage(), page.getTotalCount());
//		List<AssetDeviceVO> listVO =new ArrayList<AssetDeviceVO>();
//		for(AssetDeviceBO assetBO : list){
//			
//		}
		
	

		return mapping.findForward("success");
	}
}
