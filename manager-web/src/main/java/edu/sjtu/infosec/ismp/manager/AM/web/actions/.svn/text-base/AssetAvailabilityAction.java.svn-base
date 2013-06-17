package edu.sjtu.infosec.ismp.manager.AM.web.actions;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.servlet.ServletUtilities;

import edu.sjtu.infosec.ismp.manager.AM.comm.AssetConstant;
import edu.sjtu.infosec.ismp.manager.AM.comm.BarChart;
import edu.sjtu.infosec.ismp.manager.AM.comm.LineChart;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDailyAvailabilityBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceVO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetMonthlyAvailabilityBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetRawAvailabilityBO;
import edu.sjtu.infosec.ismp.manager.AM.model.DeviceChartVO;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetDailyAvailabilityService;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetDeviceService;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetMonthlyAvailabilityService;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetRawAvailabilityService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;
import edu.sjtu.infosec.ismp.security.Domain;

public class AssetAvailabilityAction extends DispatchAction {

	private AssetDailyAvailabilityService assetDailyAvailabilityService;
	private AssetMonthlyAvailabilityService assetMonthlyAvailabilityService;
	private AssetRawAvailabilityService assetRawAvailabilityService;
	private AssetDeviceService assetDeviceService;
	// 注入委办局 信息 service
	private DomainService domainService;


	public DomainService getDomainService() {
		return domainService;
	}

	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}

	public void setAssetDeviceService(AssetDeviceService assetDeviceService) {
		this.assetDeviceService = assetDeviceService;
	}

	public ActionForward assetAnalysis(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Integer locId = Integer.valueOf(request.getParameter("locid"));
		AssetDeviceBO deviceBO = new AssetDeviceBO(); 
		
//		String curpage = (String) request.getParameter("curpage") == null ? "1"
//				: request.getParameter("curpage");
		deviceBO.setLocationId(locId);
		if (request.getParameter("type") != null) { 
			Integer typeId = Integer.valueOf(request.getParameter("type")); 
			deviceBO.setAssetType(typeId); 
		}
		  
//		int totalCount = assetDeviceService.getCountByAssetDevice(deviceBO);
//		Page page = PageUtil.createPage(10, 1, totalCount); 
//		Page page = PageUtil.createPage(10, 1, 0); 
		
		// 获得当前页
		Page page = new Page();
		String curpage = request.getParameter("curpage") != null
				&& (!request.getParameter("curpage").equals("")) ? request
				.getParameter("curpage") : "1";
		if (request.getParameter("pageSize") != null
				&& (!request.getParameter("pageSize").equals(""))) {
			int pagesize = Integer.parseInt(request.getParameter("pageSize"));
			request.setAttribute("pageSize", request.getParameter("pageSize"));
			page.setEveryPage(pagesize);
		}else{
			page.setEveryPage(10);
		}
		page.setCurrentPage(Integer.parseInt(curpage));
		page = PageUtil.createPage(page.getEveryPage(), page.getCurrentPage(), page.getTotalCount());
//		PageResult pageResult =  assetDeviceService.getPageListByAssetDevice(deviceBO, page);
		List<AssetDeviceBO> deviceBOList =  assetDeviceService.getPageListByAssetDevice(deviceBO, page,null);
		
//		List<DeviceChartVO> deviceChartList = assetDeviceService.getDeviceChartData(deviceBO);
//		List<AssetDeviceBO> deviceList = (List<AssetDeviceBO>)pageResult.getPageList();
		List<AssetDeviceVO> deviceVOList = assetRawAvailabilityService.getListByAssetDeviceVO(deviceBOList); 
		page = PageUtil.createPage(page.getEveryPage(), page.getCurrentPage(), page.getTotalCount());
		request.setAttribute("page", page);
		request.setAttribute("deviceVOList", deviceVOList);

		AssetDeviceBO entity = new AssetDeviceBO();
		entity.setLocationId(locId);
		entity.setAssetType(AssetConstant.NETWORK_DEVICE_TYPE);
		int network = assetDeviceService.getCountByAssetDevice(entity);
		entity.setAssetType(AssetConstant.SECURITY_DEVICE_TYPE);
		int security = assetDeviceService.getCountByAssetDevice(entity);
		entity.setAssetType(AssetConstant.SERVER_DEVICE_TYPE);
		int server = assetDeviceService.getCountByAssetDevice(entity);
		entity.setAssetType(AssetConstant.TERMINAL_DEVICE_TYPE);
		int terminal = assetDeviceService.getCountByAssetDevice(entity);
		Domain domain = domainService.findById(locId);
//		
//		for(DeviceChartVO deviceChartVO : deviceChartList){
//			deviceChartVO.getDataMap().get(AssetConstant.NETWORK_DEVICE_TYPE);
//		}
//		
//		
		request.setAttribute("locId", locId);
		request.setAttribute("network", network);
		request.setAttribute("security", security);
		request.setAttribute("server", server);
		request.setAttribute("terminal", terminal);
		request.setAttribute("location", domain.getDomainName());

		return mapping.findForward("assetAnalysis");
	}

	public ActionForward statisticAnalysis(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int assetId = Integer.parseInt(request.getParameter("deviceId"));
		// 每日参数
		AssetDailyAvailabilityBO dailyAvailabilityBO = new AssetDailyAvailabilityBO();
		dailyAvailabilityBO.setAssetId(assetId);
		// 每月参数
		AssetMonthlyAvailabilityBO monthlyAvailabilityBO = new AssetMonthlyAvailabilityBO();
		monthlyAvailabilityBO.setAssetId(assetId);

		// CPU 每日统计
		dailyAvailabilityBO.setAvailabilityType(AssetConstant.AVAILABILITY_CPU);
		String cpuDImg = getDailyChart(dailyAvailabilityBO, request);
		request.setAttribute("cpuDImg", cpuDImg);
		// CPU 每月统计
		monthlyAvailabilityBO
				.setAvailabilityType(AssetConstant.AVAILABILITY_CPU);
		String cpuMImg = getMonthlyChart(monthlyAvailabilityBO, request);
		request.setAttribute("cpuMImg", cpuMImg);
		// CPU 每年统计
		String cpuYImg = getYearChart(monthlyAvailabilityBO, request);
		request.setAttribute("cpuYImg", cpuYImg);
		// 硬盘每日统计
		dailyAvailabilityBO.setAvailabilityType(AssetConstant.AVAILABILITY_HD);
		String harDImg = getDailyChart(dailyAvailabilityBO, request);
		request.setAttribute("harDImg", harDImg);
		// 硬盘每月统计
		monthlyAvailabilityBO
				.setAvailabilityType(AssetConstant.AVAILABILITY_HD);
		String harMImg = getMonthlyChart(monthlyAvailabilityBO, request);
		request.setAttribute("harMImg", harMImg);
		// 硬盘每年统计
		String harYImg = getYearChart(monthlyAvailabilityBO, request);
		request.setAttribute("harYImg", harYImg);
		// 内存每日统计
		dailyAvailabilityBO.setAvailabilityType(AssetConstant.AVAILABILITY_MEM);
		String meDImg = getDailyChart(dailyAvailabilityBO, request);
		request.setAttribute("meDImg", meDImg);
		// 内存每月统计
		monthlyAvailabilityBO
				.setAvailabilityType(AssetConstant.AVAILABILITY_MEM);
		String meMImg = getMonthlyChart(monthlyAvailabilityBO, request);
		request.setAttribute("meMImg", meMImg);
		// 内存每年统计
		String meYImg = getYearChart(monthlyAvailabilityBO, request);
		request.setAttribute("meYImg", meYImg);
		// 网络接口每日统计
		dailyAvailabilityBO.setAvailabilityType(AssetConstant.AVAILABILITY_Net);
		String netDImg = getDailyChart(dailyAvailabilityBO, request);
		request.setAttribute("netDImg", netDImg);
		// 网络接口每月统计
		monthlyAvailabilityBO
				.setAvailabilityType(AssetConstant.AVAILABILITY_Net);
		String netMImg = getMonthlyChart(monthlyAvailabilityBO, request);
		request.setAttribute("netMImg", netMImg);
		// 网络接口每年统计
		String netYImg = getYearChart(monthlyAvailabilityBO, request);
		request.setAttribute("netYImg", netYImg);

		// 网络流量统计
		AssetRawAvailabilityBO rawAvailabilityBO = new AssetRawAvailabilityBO();
		rawAvailabilityBO.setAssetId(assetId);
		rawAvailabilityBO.setAvailabilityType(AssetConstant.AVAILABILITY_Net);
		// 每日流量统计
		List<Integer> hourList = assetRawAvailabilityService
				.getHourChartDataByNet(
						new Timestamp(System.currentTimeMillis()),
						rawAvailabilityBO);
		JFreeChart chart = LineChart.createLineChart(hourList, 1);
		String quDImg = ServletUtilities.saveChartAsPNG(chart, 800, 500,
				request.getSession());
		request.setAttribute("quDImg", quDImg);
		// 每月流量统计
		List<Integer> dayList = assetRawAvailabilityService
				.getDayChartDataByNet(
						new Timestamp(System.currentTimeMillis()),
						rawAvailabilityBO);
		chart = LineChart.createLineChart(dayList, 2);
		String quMImg = ServletUtilities.saveChartAsPNG(chart, 800, 500,
				request.getSession());
		request.setAttribute("quMImg", quMImg);
		// 每年流量统计
		List<Integer> monthList = assetRawAvailabilityService
				.getMonthChartDataByNet(new Timestamp(System
						.currentTimeMillis()), rawAvailabilityBO);
		chart = BarChart.creatBarChart(monthList, 3);
		String quYImg = ServletUtilities.saveChartAsPNG(chart, 800, 500,
				request.getSession());
		request.setAttribute("quYImg", quYImg);

		// 在线统计
		// 每日在线统计
		rawAvailabilityBO.setAvailabilityType(AssetConstant.AVAILABILITY_ALIVE);
		List<Integer> onHourList = assetRawAvailabilityService
				.getHourChartDataByOnline(new Timestamp(System
						.currentTimeMillis()), rawAvailabilityBO);
		chart = LineChart.createLineChart(onHourList, 1);
		String onDImg = ServletUtilities.saveChartAsPNG(chart, 800, 500,
				request.getSession());
		request.setAttribute("onDImg", onDImg);

		List<Integer> onDayList = assetRawAvailabilityService
				.getDayChartDataByOnline(new Timestamp(System
						.currentTimeMillis()), rawAvailabilityBO);
		chart = LineChart.createLineChart(onDayList, 2);
		String onMImg = ServletUtilities.saveChartAsPNG(chart, 800, 500,
				request.getSession());
		request.setAttribute("onMImg", onMImg);

		List<Integer> onMonthList = assetRawAvailabilityService
				.getMonthChartDataByOnline(new Timestamp(System
						.currentTimeMillis()), rawAvailabilityBO);
		chart = BarChart.creatBarChart(onMonthList, 3);
		String onYImg = ServletUtilities.saveChartAsPNG(chart, 800, 500,
				request.getSession());
		request.setAttribute("onYImg", onYImg);

		request.setAttribute("deviceId", Integer.valueOf(request
				.getParameter("deviceId")));
		return mapping.findForward("success");
	}

	// 日表
	private String getDailyChart(AssetDailyAvailabilityBO dailyAvailabilityBO,
			HttpServletRequest request) throws IOException {
		List dailyList = assetDailyAvailabilityService.getDayChartData(
				new Timestamp(System.currentTimeMillis()), dailyAvailabilityBO);
		JFreeChart chart = LineChart.createLineChart(dailyList, 1);
		String image = ServletUtilities.saveChartAsPNG(chart, 800, 500, request
				.getSession());
		return image;
	}

	// 月表
	private String getMonthlyChart(
			AssetMonthlyAvailabilityBO monthlyAvailabilityBO,
			HttpServletRequest request) throws IOException {
		List monthList = assetMonthlyAvailabilityService.getMonthChartData(
				new Timestamp(System.currentTimeMillis()),
				monthlyAvailabilityBO);
		JFreeChart chart = LineChart.createLineChart(monthList, 2);
		String image = ServletUtilities.saveChartAsPNG(chart, 800, 500, request
				.getSession());
		return image;

	}

	// 年表
	private String getYearChart(
			AssetMonthlyAvailabilityBO monthlyAvailabilityBO,
			HttpServletRequest request) throws IOException {
		List yearList = assetMonthlyAvailabilityService.getYearChartData(
				new Timestamp(System.currentTimeMillis()),
				monthlyAvailabilityBO);
		JFreeChart chart = BarChart.creatBarChart(yearList, 3);
		String image = ServletUtilities.saveChartAsPNG(chart, 800, 500, request
				.getSession());
		return image;

	}

	public void setAssetRawAvailabilityService(
			AssetRawAvailabilityService assetRawAvailabilityService) {
		this.assetRawAvailabilityService = assetRawAvailabilityService;
	}

	public AssetDailyAvailabilityService getAssetDailyAvailabilityService() {
		return assetDailyAvailabilityService;
	}

	public void setAssetDailyAvailabilityService(
			AssetDailyAvailabilityService assetDailyAvailabilityService) {
		this.assetDailyAvailabilityService = assetDailyAvailabilityService;
	}

	public AssetMonthlyAvailabilityService getAssetMonthlyAvailabilityService() {
		return assetMonthlyAvailabilityService;
	}

	public void setAssetMonthlyAvailabilityService(
			AssetMonthlyAvailabilityService assetMonthlyAvailabilityService) {
		this.assetMonthlyAvailabilityService = assetMonthlyAvailabilityService;
	}

}
