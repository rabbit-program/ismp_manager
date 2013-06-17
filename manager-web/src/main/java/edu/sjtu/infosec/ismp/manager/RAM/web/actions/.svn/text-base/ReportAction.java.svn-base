package edu.sjtu.infosec.ismp.manager.RAM.web.actions;

import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.actions.DispatchAction;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.TextAnchor;
import org.jfree.util.Rotation;

import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoLeak;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaAsseValue;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaLeak;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaLeakThre;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaThre;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaVuln;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatCVEThre;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatThre;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatVulnPoin;
import edu.sjtu.infosec.ismp.manager.RAM.service.DicSecuLeveService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DynaAsseValueService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DynaLeakService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DynaLeakThreService;
import edu.sjtu.infosec.ismp.manager.RAM.service.LeakScanService;
import edu.sjtu.infosec.ismp.manager.RAM.service.ProjectService;
import edu.sjtu.infosec.ismp.manager.RAM.service.ReportService;
import edu.sjtu.infosec.ismp.manager.RAM.service.StatCVEThreService;
import edu.sjtu.infosec.ismp.manager.RAM.service.StatThreService;
import edu.sjtu.infosec.ismp.manager.RAM.service.StatVulnPoinService;
import edu.sjtu.infosec.ismp.manager.RAM.service.ThreAnalService;
import edu.sjtu.infosec.ismp.manager.RAM.service.VulnAnalService;
import edu.sjtu.infosec.ismp.manager.RAM.web.form.AsseKnowDynaAsseValueForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;
import edu.sjtu.infosec.ismp.util.EscapeUnescape;

/**
 * web层 报表生成Action.
 */
public class ReportAction  extends DispatchAction {
    
    /**
     * 项目管理Manager接口
     */
    private ProjectService projectService;
    /**
     * 报表生成Service接口
     */
    private ReportService reportService;
    /**
     * 知识库项目总体评估值Service接口
     **/
    private DynaAsseValueService dynaAsseValueService;
    
	private DicSecuLeveService dicSecuLeveService;
	
	private VulnAnalService vulnAnalService;
	
	private StatVulnPoinService statVulnPoinService;
	
	private DynaLeakService dynaLeakService;
	
	private LeakScanService leakScanService;
	
	private ThreAnalService threAnalService;
	
	private StatThreService statThreService;
	
	private DynaLeakThreService dynaLeakThreService;
	
	private StatCVEThreService statCVEThreService;
	
	private SystemLogService logService;
	
	public void setLogService(SystemLogService logService) {
		this.logService = logService;
	}
	
    public void setThreAnalService(ThreAnalService threAnalService) {
		this.threAnalService = threAnalService;
	}

	public void setStatThreService(StatThreService statThreService) {
		this.statThreService = statThreService;
	}

	public void setDynaLeakThreService(DynaLeakThreService dynaLeakThreService) {
		this.dynaLeakThreService = dynaLeakThreService;
	}

	public void setStatCVEThreService(StatCVEThreService statCVEThreService) {
		this.statCVEThreService = statCVEThreService;
	}

	public void setVulnAnalService(VulnAnalService vulnAnalService) {
		this.vulnAnalService = vulnAnalService;
	}

	public void setStatVulnPoinService(StatVulnPoinService statVulnPoinService) {
		this.statVulnPoinService = statVulnPoinService;
	}

	public void setDynaLeakService(DynaLeakService dynaLeakService) {
		this.dynaLeakService = dynaLeakService;
	}

	public void setLeakScanService(LeakScanService leakScanService) {
		this.leakScanService = leakScanService;
	}

	public void setDicSecuLeveService(DicSecuLeveService dicSecuLeveService) {
		this.dicSecuLeveService = dicSecuLeveService;
	}
    
    public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}

	public void setDynaAsseValueService(DynaAsseValueService dynaAsseValueService) {
		this.dynaAsseValueService = dynaAsseValueService;
	}

	/**
     * 往session中加载本次测评项目信息
     */
    private AsseInfoProj loadAsseInfoproj(HttpServletRequest request) {
        
        AsseInfoProj asseInfoProj = null;
        if(request.getSession().getAttribute("asseInfoProj") == null) {
            String projId = request.getParameter("projId");
            if(projId != null && !"".equals(projId.trim())) {
             Integer projCode = new Integer(projId);
             asseInfoProj = projectService.find(projCode);
             System.out.println("find asseInfoProj:"+asseInfoProj.toString());
            }
          request.getSession().setAttribute("asseInfoProj", asseInfoProj);
      } else {
          asseInfoProj = (AsseInfoProj) request.getSession().getAttribute("asseInfoProj");  
      }
        return asseInfoProj;
    }
    
    /**
     * 报表生成前工作
     */
    public ActionForward preReport(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

    	AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
    	   try{
   	         reportService.executeSend(asseInfoProj);
    	   }catch(Exception e) {
    		   ActionErrors errors = new ActionErrors();
               errors.add("sendRepoError", new ActionMessage("asse.err.repo.send"));
               saveErrors(request.getSession(), errors);
    	   }
           AsseInfoProj newasseInfoProj = projectService.find(asseInfoProj.getId());
           newasseInfoProj.setProgress("prog12");
           projectService.saveOrUpdate(newasseInfoProj);
           request.getSession().setAttribute("asseInfoProj", newasseInfoProj);
           
           Object[] quesAndAdvice =  dynaAsseValueService.getExpQuesAndAdvice(newasseInfoProj.getId().toString());
    	   String nowQuestion = (String) quesAndAdvice[0];
    	   String advice = (String) quesAndAdvice[1];
    	   request.setAttribute("nowQuestion", EscapeUnescape.escape(StringUtils.stripToEmpty(nowQuestion)));
    	   request.setAttribute("advice", EscapeUnescape.escape(StringUtils.stripToEmpty(advice)));
           return mapping.findForward("report");
    }
    
    /**
     * 报表首页基本信息
     */
    public ActionForward reportInfo(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
    	    AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
    	    AsseKnowDynaAsseValue dynaAsseValue = dynaAsseValueService.find(asseInfoProj.getId().toString());
    	    request.setAttribute("dynaAsseValue", dynaAsseValue);
    	    List dicCpKindList = reportService.getDicCpKindList();
    	    request.setAttribute("dicCpKindList", dicCpKindList);
    	    return mapping.findForward("report1");
    }
    
    /**
     * 保存网络拓扑信息
     */
    public ActionForward saveWebTopoInfo(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
    	    AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
            AsseKnowDynaAsseValue dynaAsseValue = dynaAsseValueService.find(asseInfoProj.getId().toString());
            AsseKnowDynaAsseValueForm dynaAsseValueForm = (AsseKnowDynaAsseValueForm) form;
            dynaAsseValue.setWebTopoInfo(dynaAsseValueForm.getWebTopoInfo());
            dynaAsseValueService.saveOrUpdate(dynaAsseValue);
            
            //添加日志
     		OperatorDetails user = SecurityUserHolder.getCurrentUser();
     		SystemLog log = new SystemLog();
     		log.setUsername(user.getUsername());
     		List<Role> list=user.getRoleList();
     		String roles="";
     		for(Role role:list){
     			roles+=role.getRole()+",";
     		}
     		log.setRoleName(roles.substring(0,roles.length()-1));
     		log.setTime(new Timestamp(new Date().getTime()));
     		log.setModuleName(SystemModelInfo.MOD_RAM);
     		log.setOperationDesc("风险评估模块,报表生成保存网络拓扑信息,ID为:"+dynaAsseValue.getId()+",网络拓扑信息为:"+dynaAsseValueForm.getWebTopoInfo());
     		log.setControl("成功");
     		logService.saveSystemLog(log);
    	    return reportInfo(mapping,form,request,response);
    }
    
    /**
     * 风险评估分析报告
     */
    @SuppressWarnings("deprecation")
	public ActionForward assessmentAnalysisReport(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
    	    AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
    	    Map reportMap = reportService.assessmentAnalysisReport(asseInfoProj);
    	    //饼状图所需数据
    	    Long HighRiskNum = (Long) reportMap.get("HighRiskNum");
    	    Long MiddRiskNum = (Long) reportMap.get("MiddRiskNum");
    	    Long LowRiskNum = (Long) reportMap.get("LowRiskNum");
            DefaultPieDataset dataSet = new DefaultPieDataset();
            dataSet.setValue("高风险点",HighRiskNum.doubleValue());
            dataSet.setValue("中风险点",MiddRiskNum.doubleValue());
            dataSet.setValue("低风险点",LowRiskNum.doubleValue());
            JFreeChart chart=ChartFactory.createPieChart3D("不同风险等级的数量统计",dataSet,true,true,false);
            chart.getTitle().setFont(new Font("宋体",Font.PLAIN,18));
            PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象
            piePlot.setLabelFont(new Font("宋体",Font.BOLD,12));
            chart.getLegend().setItemFont(new Font("宋体",0,12));
            
            PiePlot3D piePlot3D=(PiePlot3D)chart.getPlot();
            piePlot3D.setStartAngle(150D);
            piePlot3D.setDirection(Rotation.CLOCKWISE);
            piePlot3D.setForegroundAlpha(0.5F);
            piePlot3D.setNoDataMessage("无数据显示");
            piePlot3D.setCircular(true);
            piePlot3D.setLabelFont(new Font("宋体",0,18));
            piePlot3D.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}有{1}个 占{2}",
                                         NumberFormat.getNumberInstance(),
                                         new DecimalFormat("0.00%")));
            String filename=ServletUtilities.saveChartAsPNG(chart,700,400,null,request.getSession());
            String graphURL=request.getContextPath()+"/DisplayChart?filename="+filename;
            request.setAttribute("graphURL", graphURL);
            request.setAttribute("filename", filename);
            
            //柱状图所需数据
            double[][] asseData = (double[][]) reportMap.get("asseData");
            String[] asseDataRowKeys = (String[]) reportMap.get("asseDataRowKeys");
   	        String[] asseDataColumnKeys = (String[]) reportMap.get("asseDataColumnKeys");
   	        CategoryDataset dataset1 = DatasetUtilities.createCategoryDataset(asseDataRowKeys, asseDataColumnKeys, asseData); 
   	    
   	        JFreeChart chart1 = ChartFactory.createBarChart3D("重要资产的不同等级风险统计", 
   	                    "风险",
   	                    "风险数目",
   	                    dataset1,
   	                    PlotOrientation.VERTICAL,
   	                    true,
   	                    true,
   	                    false);



           CategoryPlot plot = chart1.getCategoryPlot();
           CategoryAxis domainAxis=plot.getDomainAxis();
           NumberAxis numberaxis = (NumberAxis) plot.getRangeAxis();

           TextTitle textTitle = chart1.getTitle();
           textTitle.setFont(new Font("宋体", Font.PLAIN, 18));
           domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));
           domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));
           numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));
           numberaxis.setLabelFont(new Font("黑体", Font.PLAIN, 12));
           chart1.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));

   	       //设置网格背景颜色
   	       plot.setBackgroundPaint(Color.white);
   	       //设置网格竖线颜色
   	       plot.setDomainGridlinePaint(Color.pink);
   	       //设置网格横线颜色
   	       plot.setRangeGridlinePaint(Color.pink);
   	       Font font = new Font("宋体",0,16);
	       plot.getDomainAxis().setLabelFont(font);
	       plot.getDomainAxis().setTickLabelFont(font);
	       plot.getRangeAxis().setLabelFont(font);
	       plot.getRangeAxis().setTickLabelFont(font);
   	       //显示每个柱的数值，并修改该数值的字体属性
   	       BarRenderer3D renderer = new BarRenderer3D();
   	       renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
   	       renderer.setBaseItemLabelsVisible(true);
   	       //默认的数字显示在柱子中，通过如下两句可调整数字的显示
   	       //注意：此句很关键，若无此句，那数字的显示会被覆盖，给人数字没有显示出来的问题
   	       renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
   	       renderer.setItemLabelAnchorOffset(10D);
   	       //设置每个地区所包含的平行柱的之间距离
   	       renderer.setItemMargin(0.3);
   	       renderer.setItemLabelFont(new Font("宋体",Font.BOLD,12));
   	       plot.setRenderer(renderer);
           plot.setDomainAxisLocation(AxisLocation.TOP_OR_RIGHT);
   	       plot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);

   	       String filename1 = ServletUtilities.saveChartAsPNG(chart1, 700, 400, null, request.getSession());
   	       String graphURL1 = request.getContextPath() + "/DisplayChart?filename=" + filename1;
   	       request.setAttribute("graphURL1", graphURL1);
           request.setAttribute("filename1", filename1);
      
   	       //各资产的风险列表
   	       List repoList = (List) reportMap.get("repoList");
   	       request.setAttribute("repoList", repoList);
   	       List dicSecuLeveList=dicSecuLeveService.findAll();
		   request.setAttribute("dicSecuLeveList", dicSecuLeveList);
   	       return mapping.findForward("report7");
    }
    
    /**
     * 各委办局的资产及其重要性报告
     */
    @SuppressWarnings("unchecked")
	public ActionForward assetImportanceReport(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
    	    Map reportMap = null;
    		AsseInfoProj asseInfoProj= loadAsseInfoproj(request);
    	    reportMap = reportService.assetImportanceReport(asseInfoProj.getDomain());
    	    //饼状图数据
    	    Long HighAsseImpoNum = (Long) reportMap.get("HighAsseImpoNum");
    		Long MiddAsseImpoNum = (Long) reportMap.get("MiddAsseImpoNum");
    		Long LowAsseImpoNum =  (Long) reportMap.get("LowAsseImpoNum");
    		DefaultPieDataset dataSet = new DefaultPieDataset();
            dataSet.setValue("重要性高",HighAsseImpoNum.doubleValue());
            dataSet.setValue("重要性中",MiddAsseImpoNum.doubleValue());
            dataSet.setValue("重要性低",LowAsseImpoNum.doubleValue());
            JFreeChart chart=ChartFactory.createPieChart3D("不同重要等级资产统计",dataSet,true,true,false);
            
            chart.getTitle().setFont(new Font("宋体",Font.PLAIN,18));
            PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象
            piePlot.setLabelFont(new Font("宋体",Font.BOLD,12));
            chart.getLegend().setItemFont(new Font("宋体",0,12));
            
            PiePlot3D piePlot3D=(PiePlot3D)chart.getPlot();
            piePlot3D.setStartAngle(150D);
            piePlot3D.setDirection(Rotation.CLOCKWISE);
            piePlot3D.setForegroundAlpha(0.5F);
            piePlot3D.setNoDataMessage("无数据显示");
            piePlot3D.setCircular(true);
            piePlot3D.setLabelFont(new Font("宋体",0,18));
            piePlot3D.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}有{1}个 占{2}",
                                         NumberFormat.getNumberInstance(),
                                         new DecimalFormat("0.00%")));
            String filename=ServletUtilities.saveChartAsPNG(chart,700,400,null,request.getSession());
            String graphURL=request.getContextPath()+"/DisplayChart?filename="+filename;
            request.setAttribute("graphURL", graphURL);
            request.setAttribute("filename", filename);
    		//资产列表
    	    List assetList = (List) reportMap.get("assetList");
    	    request.setAttribute("assetList", assetList);
    	    List dicSecuLeveList=dicSecuLeveService.findAll();
			request.setAttribute("dicSecuLeveList", dicSecuLeveList);
    	    return mapping.findForward("report4");
    }
    
    /**
     * 各委办局面临的威胁及其可能性报告
     */
    public ActionForward threatPossibilityReport(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
    	    AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
    	    Map reportMap =null;
    	    reportMap = reportService.threatPossibilityReport(asseInfoProj);
    	    //饼状图数据
    	    Long HighThreNum = (Long) reportMap.get("HighThreNum");
    		Long MiddThreNum = (Long) reportMap.get("MiddThreNum");
    		Long LowThreNum = (Long) reportMap.get("LowThreNum");
    		DefaultPieDataset dataSet = new DefaultPieDataset();
            dataSet.setValue("安全事件发生可能性高",HighThreNum.doubleValue());
            dataSet.setValue("安全事件发生可能性中",MiddThreNum.doubleValue());
            dataSet.setValue("安全事件发生可能性低",LowThreNum.doubleValue());
            JFreeChart chart=ChartFactory.createPieChart3D("不同可能性等级的威胁数量统计",dataSet,true,true,false);
           
            chart.getTitle().setFont(new Font("宋体",Font.PLAIN,18));
            PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象
            piePlot.setLabelFont(new Font("宋体",Font.BOLD,12));
            chart.getLegend().setItemFont(new Font("宋体",0,12));
            
            PiePlot3D piePlot3D=(PiePlot3D)chart.getPlot();
            piePlot3D.setStartAngle(150D);
            piePlot3D.setDirection(Rotation.CLOCKWISE);
            piePlot3D.setForegroundAlpha(0.5F);
            piePlot3D.setNoDataMessage("无数据显示");
            piePlot3D.setCircular(true);
            piePlot3D.setLabelFont(new Font("宋体",0,18));
            piePlot3D.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}有{1}个 占{2}",
                                         NumberFormat.getNumberInstance(),
                                         new DecimalFormat("0.00%")));
            String filename=ServletUtilities.saveChartAsPNG(chart,700,400,null,request.getSession());
            String graphURL=request.getContextPath()+"/DisplayChart?filename="+filename;
            request.setAttribute("graphURL", graphURL);
            request.setAttribute("filename", filename);
    		//柱状图数据
            double[][] asseThreData = (double[][]) reportMap.get("asseThreData");
   	        String[] asseThreDataRowKeys = (String[]) reportMap.get("asseThreDataRowKeys");
   	        String[] asseThreDataColumnKeys = (String[]) reportMap.get("asseThreDataColumnKeys");
   	        CategoryDataset dataset1 = DatasetUtilities.createCategoryDataset(asseThreDataRowKeys, asseThreDataColumnKeys, asseThreData); 
  		    
	        JFreeChart chart1 = ChartFactory.createBarChart3D("不同资产各等级威胁数目统计", 
	                    "威胁",
	                    "威胁数量",
	                    dataset1,
	                    PlotOrientation.VERTICAL,
	                    true,
	                    true,
	                    false);
           CategoryPlot plot = chart1.getCategoryPlot();
           CategoryAxis domainAxis=plot.getDomainAxis();
           NumberAxis numberaxis = (NumberAxis) plot.getRangeAxis();

           TextTitle textTitle = chart1.getTitle();
           textTitle.setFont(new Font("宋体", Font.PLAIN, 18));
           domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));
           domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));
           numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));
           numberaxis.setLabelFont(new Font("黑体", Font.PLAIN, 12));
           chart1.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));
           //设置网格背景颜色
	       plot.setBackgroundPaint(Color.white);
	       //设置网格竖线颜色
	       plot.setDomainGridlinePaint(Color.pink);
	       //设置网格横线颜色
	       plot.setRangeGridlinePaint(Color.pink);
	       Font font = new Font("宋体",0,16);
	       plot.getDomainAxis().setLabelFont(font);
	       plot.getDomainAxis().setTickLabelFont(font);
	       plot.getRangeAxis().setLabelFont(font);
	       plot.getRangeAxis().setTickLabelFont(font);
	       //显示每个柱的数值，并修改该数值的字体属性
	       BarRenderer3D renderer = new BarRenderer3D();
	       renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	       renderer.setBaseItemLabelsVisible(true);
	       //默认的数字显示在柱子中，通过如下两句可调整数字的显示
	       //注意：此句很关键，若无此句，那数字的显示会被覆盖，给人数字没有显示出来的问题
	       renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
	       renderer.setItemLabelAnchorOffset(10D);
	       //设置每个地区所包含的平行柱的之间距离
	       renderer.setItemMargin(0.3);
	       renderer.setItemLabelFont(new Font("宋体",Font.BOLD,12));
	       plot.setRenderer(renderer);
           plot.setDomainAxisLocation(AxisLocation.TOP_OR_RIGHT);
	       plot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);

	       String filename1 = ServletUtilities.saveChartAsPNG(chart1, 700, 400, null, request.getSession());
	       String graphURL1 = request.getContextPath() + "/DisplayChart?filename=" + filename1;
	       request.setAttribute("graphURL1", graphURL1);
           request.setAttribute("filename1", filename1);
           
   	       /**
   	        * 各资产的威胁列表 各威胁的详细信息列表
   	        **/
           List dynaThreList = (List) reportMap.get("dynaThreList");
           List dynaLeakThreList = (List) reportMap.get("dynaLeakThreList");
   		   request.setAttribute("dynaThreList", dynaThreList);
   		   request.setAttribute("dynaLeakThreList", dynaLeakThreList);
	   		List dicSecuLeveList=dicSecuLeveService.findAll();
			request.setAttribute("dicSecuLeveList", dicSecuLeveList);
    	   return mapping.findForward("report6");
    }
    
    /**
     * 总体报告
     */
    public ActionForward totalReport(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
    	    AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
    	    ActionErrors errors = (ActionErrors) request.getAttribute("sendAlert");
    	    if(errors!=null) {
    	     saveErrors(request, errors);
    	    }
    	    AsseKnowDynaAsseValue dynaAsseValue = dynaAsseValueService.find(asseInfoProj.getId().toString());
    	    Map RiskNumMap = reportService.totalReport(asseInfoProj.getId());
    	    Long HighRiskNum = (Long) RiskNumMap.get("HighRiskNum");
            Long MiddRiskNum = (Long) RiskNumMap.get("MiddRiskNum");
            Long LowRiskNum = (Long) RiskNumMap.get("LowRiskNum");
            Long TotalRiskNum = (Long) RiskNumMap.get("TotalRiskNum");
            request.setAttribute("HighRiskNum", HighRiskNum);
            request.setAttribute("MiddRiskNum", MiddRiskNum);
            request.setAttribute("LowRiskNum", LowRiskNum);
            request.setAttribute("TotalRiskNum", TotalRiskNum);
            request.setAttribute("dynaAsseValue", dynaAsseValue);
    	    return mapping.findForward("report2");
    }
    
    public ActionForward sendAlert (ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception  {
    	
    	    AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
    	    try{
    	        reportService.saveAlert(asseInfoProj);
    	        ActionErrors errors = new ActionErrors();
                errors.add("sendAlert", new ActionMessage("asse.err.alert.send"));
                saveErrors(request, errors);
    	    }catch(Exception e){
    	    	e.printStackTrace();
    	    }
    	    return totalReport(mapping, form, request, response);
    }
    
    /**
     * 保存存在的问题和安全建议
     */
    public ActionForward saveQuesandSugg(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
    	    AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
	        AsseKnowDynaAsseValue dynaAsseValue = dynaAsseValueService.find(asseInfoProj.getId().toString());
	        AsseKnowDynaAsseValueForm dynaAsseValueForm = (AsseKnowDynaAsseValueForm) form;
	        dynaAsseValue.setTotalAsse(dynaAsseValueForm.getTotalAsse());
	        dynaAsseValue.setExpertSuggest(dynaAsseValueForm.getExpertSuggest());
	        dynaAsseValueService.saveOrUpdate(dynaAsseValue);
	        
	        //添加日志
     		OperatorDetails user = SecurityUserHolder.getCurrentUser();
     		SystemLog log = new SystemLog();
     		log.setUsername(user.getUsername());
     		List<Role> list=user.getRoleList();
     		String roles="";
     		for(Role role:list){
     			roles+=role.getRole()+",";
     		}
     		log.setRoleName(roles.substring(0,roles.length()-1));
     		log.setTime(new Timestamp(new Date().getTime()));
     		log.setModuleName(SystemModelInfo.MOD_RAM);
     		log.setOperationDesc("风险评估模块,报表生成保存存在的问题和安全建议,ID为:"+dynaAsseValue.getId()+",存在的问题为:"+dynaAsseValueForm.getTotalAsse()+"安全建议为:"+dynaAsseValueForm.getExpertSuggest());
     		log.setControl("成功");
     		logService.saveSystemLog(log);
	        
    	    return totalReport(mapping, form, request, response);
	        //return mapping.findForward("console");
    }
    
    /**
     * 各委办局关键资产的脆弱点及其严重性报告
     */
    @SuppressWarnings("deprecation")
	public ActionForward vulnSeriousReport(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
    	    AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
    	    Map reportMap = reportService.vulnSeriousReport(asseInfoProj);
    	  
    	    //饼图数据
    	    Long HighVulnNum = (Long) reportMap.get("HighVulnNum");
    		Long MiddVulnNum = (Long) reportMap.get("MiddVulnNum");
    		Long LowVulnNum = (Long) reportMap.get("LowVulnNum");
    		DefaultPieDataset dataSet = new DefaultPieDataset();
            dataSet.setValue("严重性高",HighVulnNum.doubleValue());
            dataSet.setValue("严重性中",MiddVulnNum.doubleValue());
            dataSet.setValue("严重性低",LowVulnNum.doubleValue());
            JFreeChart chart=ChartFactory.createPieChart3D("不同严重等级的漏洞数量统计",dataSet,true,true,false);
           
            chart.getTitle().setFont(new Font("宋体",Font.PLAIN,18));
            PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象
            piePlot.setLabelFont(new Font("宋体",Font.BOLD,12));
            chart.getLegend().setItemFont(new Font("宋体",0,12));
            
            PiePlot3D piePlot3D=(PiePlot3D)chart.getPlot();
            piePlot3D.setStartAngle(150D);
            piePlot3D.setDirection(Rotation.CLOCKWISE);
            piePlot3D.setForegroundAlpha(0.5F);
            piePlot3D.setNoDataMessage("无数据显示");
            piePlot3D.setCircular(true);
            piePlot3D.setLabelFont(new Font("宋体",0,18));
            piePlot3D.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}有{1}个 占{2}",
                                         NumberFormat.getNumberInstance(),
                                         new DecimalFormat("0.00%")));
            String filename=ServletUtilities.saveChartAsPNG(chart,700,400,null,request.getSession());
            String graphURL=request.getContextPath()+"/DisplayChart?filename="+filename;
            request.setAttribute("graphURL", graphURL);
            request.setAttribute("filename", filename);
    	    //柱状图数据
            double[][] asseVulnData = (double[][]) reportMap.get("asseVulnData");
   	        String[] asseVulnDataRowKeys = (String[]) reportMap.get("asseVulnDataRowKeys");
   	        String[] asseVulnDataColumnKeys = (String[]) reportMap.get("asseVulnDataColumnKeys");
   	        CategoryDataset dataset1 = DatasetUtilities.createCategoryDataset(asseVulnDataRowKeys, asseVulnDataColumnKeys, asseVulnData); 
   	        
	        JFreeChart chart1 = ChartFactory.createBarChart3D("不同资产各等级漏洞数目", 
	                    "漏洞",
	                    "漏洞数量",
	                    dataset1,
	                    PlotOrientation.VERTICAL,
	                    true,
	                    true,
	                    false);
	       CategoryPlot plot = chart1.getCategoryPlot();
           CategoryAxis domainAxis=plot.getDomainAxis();
           NumberAxis numberaxis = (NumberAxis) plot.getRangeAxis();

           TextTitle textTitle = chart1.getTitle();
           textTitle.setFont(new Font("宋体", Font.PLAIN, 18));
           domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));
           domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));
           numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));
           numberaxis.setLabelFont(new Font("黑体", Font.PLAIN, 12));
           chart1.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));

	       Font font = new Font("宋体",0,16);
	       plot.getDomainAxis().setLabelFont(font);
	       plot.getDomainAxis().setTickLabelFont(font);
	       plot.getRangeAxis().setLabelFont(font);
	       plot.getRangeAxis().setTickLabelFont(font);
	       //设置网格背景颜色
	       plot.setBackgroundPaint(Color.white);
	       //设置网格竖线颜色
	       plot.setDomainGridlinePaint(Color.pink);
	       //设置网格横线颜色
	       plot.setRangeGridlinePaint(Color.pink);
	       
	       //显示每个柱的数值，并修改该数值的字体属性
	       BarRenderer3D renderer = new BarRenderer3D();
	       renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	       renderer.setBaseItemLabelsVisible(true);
	       //默认的数字显示在柱子中，通过如下两句可调整数字的显示
	       //注意：此句很关键，若无此句，那数字的显示会被覆盖，给人数字没有显示出来的问题
	       renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
	       renderer.setItemLabelAnchorOffset(10D);
	       //设置每个地区所包含的平行柱的之间距离
	       renderer.setItemMargin(0.3);
	       renderer.setItemLabelFont(new Font("宋体",Font.BOLD,12));//18号宋体
	       plot.setRenderer(renderer);
           plot.setDomainAxisLocation(AxisLocation.TOP_OR_RIGHT);
	       plot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);

	       String filename1 = ServletUtilities.saveChartAsPNG(chart1, 700, 400, null, request.getSession());
	       String graphURL1 = request.getContextPath() + "/DisplayChart?filename=" + filename1;
	       request.setAttribute("graphURL1", graphURL1);
           request.setAttribute("filename1", filename1);
   	       
           /**
            * 各资产的漏洞列表
            * 各漏洞的详细信息列表
            **/
           List dynaVulnList = (List) reportMap.get("dynaVulnList");
           List dynaLeakList = (List) reportMap.get("dynaLeakList");
           request.setAttribute("dynaVulnList", dynaVulnList);
           request.setAttribute("dynaLeakList", dynaLeakList);
           List dicSecuLeveList=dicSecuLeveService.findAll();
			request.setAttribute("dicSecuLeveList", dicSecuLeveList);
    	   return mapping.findForward("report5");
    }
    
    /**
     * 各委办局业务及支撑资产清单
     */
    public ActionForward businessImportanceReport(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
	        AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
    	   List busiImpoList = reportService.businessImportanceReport(asseInfoProj.getDomain());
    	   request.setAttribute("busiImpoList", busiImpoList);
    	    List dicSecuLeveList=dicSecuLeveService.findAll();
			request.setAttribute("dicSecuLeveList", dicSecuLeveList);
    	    return mapping.findForward("report3");
    }
    
    /**
     * 查看漏洞
     */
    public ActionForward look(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
    		String vulnId = request.getParameter("vulnId");
    		if(vulnId!=null&&!"".equals(vulnId)){
    			AsseKnowDynaVuln dynaVuln=vulnAnalService.find(Integer.parseInt(vulnId));
        		Integer poinId=dynaVuln.getAsseKnowStatVulnPoinId();
        		AsseKnowStatVulnPoin vulnPoin=statVulnPoinService.find(poinId.toString());
        		request.setAttribute("dynaVuln", dynaVuln);
        		request.setAttribute("vulnPoin", vulnPoin);
    		}
    		
    		String leakId = request.getParameter("leakId");
    		if(leakId!=null&&!"".equals(leakId)){
    			AsseKnowDynaLeak dynaLeak=dynaLeakService.find(leakId);
        		Integer infoLeakId=dynaLeak.getInfoLeakId();
        		AsseInfoLeak infoLeak = leakScanService.find(infoLeakId.toString());
        		request.setAttribute("dynaLeak", dynaLeak);
        		request.setAttribute("infoLeak", infoLeak);
    		}
    		List dicSecuLeveList=dicSecuLeveService.findAll();
  			request.setAttribute("dicSecuLeveList", dicSecuLeveList);
    		
    	    return mapping.findForward("look");
    }
    
    /**
     * 查看威胁
     */
    public ActionForward lookThre(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
    		String threId = request.getParameter("ThreId");
    		if(threId!=null&&!"".equals(threId)){
    			AsseKnowDynaThre dynaThre = threAnalService.find(threId);
    			AsseKnowStatThre statThre = statThreService.find(dynaThre.getAsseKnowStatThreId().toString());

        		request.setAttribute("dynaThre", dynaThre);
        		request.setAttribute("statThre", statThre);
    		}
    		
    		String leakThreId = request.getParameter("LeakThreId");
    		if(leakThreId!=null&&!"".equals(leakThreId)){
    			AsseKnowDynaLeakThre dynaLeakThre = dynaLeakThreService.find(leakThreId);
    			AsseKnowStatCVEThre statCVEThre = statCVEThreService.findById(dynaLeakThre.getAsseKnowStatCveThreId().toString());

        		request.setAttribute("dynaLeakThre", dynaLeakThre);
        		request.setAttribute("statCVEThre", statCVEThre);
    		}
    		List dicSecuLeveList=dicSecuLeveService.findAll();
  			request.setAttribute("dicSecuLeveList", dicSecuLeveList);
    		
    	    return mapping.findForward("lookThre");
    }
}
