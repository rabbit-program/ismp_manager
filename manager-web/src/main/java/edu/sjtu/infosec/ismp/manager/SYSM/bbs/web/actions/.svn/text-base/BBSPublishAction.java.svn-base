package edu.sjtu.infosec.ismp.manager.SYSM.bbs.web.actions;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import edu.sjtu.infosec.ismp.manager.SYSM.bbs.model.Questions;
import edu.sjtu.infosec.ismp.manager.SYSM.bbs.service.QuestionsService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.UserService;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.HtmlFactory;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.security.IdEntity;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.User;

public class BBSPublishAction extends DispatchAction {

	/**
	 * @return the questionsService
	 */
	public QuestionsService getQuestionsService() {
		return questionsService;
	}

	/**
	 * @param questionsService the questionsService to set
	 */
	public void setQuestionsService(QuestionsService questionsService) {
		this.questionsService = questionsService;
	}

	private QuestionsService questionsService;
	
	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private UserService userService;
	 /**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ActionForward findAnswersAll(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws IOException {
		 
		 try {
				PMPage page = new PMPage();
				String curpage = request.getParameter("currPage") != null
						&& (!request.getParameter("currPage").equals("")) ? request
						.getParameter("currPage") : "1";
				page.setCurrentPage(Integer.parseInt(curpage));
				page.setBeginIndex((page.getCurrentPage() - 1) * page.getEveryPage());		
			   List<Questions> lists = questionsService.findAll(page);
			   request.setAttribute("page", page.getPageInfo());
			   request.setAttribute("currPage", page.getPageInfo().getCurrentPage());
			   request.setAttribute("totalPage", page.getPageInfo().getTotalPage());
			// System.out.println(user.getId());
			// System.out.println(user.getUsername());
			request.setAttribute("questions", lists);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return mapping.findForward("index");
	 }

	public ActionForward addAnswers(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
	 
	 try {
		 OperatorDetails userDetails = SecurityUserHolder.getCurrentUser();
		 
		 User user =userService.getUserinfoByNameService(userDetails.getUsername());
		 Questions questions = new Questions();
		 
		 String title = request.getParameter("title");
		 String context = request.getParameter("contextDetails");
		 
		 System.out.println(context);
		 
		 questions.setIp(request.getLocalAddr());
		 questions.setQ_details(context);
		 questions.setQ_title(title);
		 questions.setSender(user);
		 questions.setCreateTime(new Timestamp(new Date().getTime()));
	
		 
		 questionsService.add(questions);
		 
		//List<Questions> lists = questionsService.findAll();
		
	//	request.setAttribute("questions", lists);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	 return findAnswersAll(mapping,null,request,response);
 }
	
	public ActionForward detailAnswers(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
	 try {
		 
		 String flag = request.getParameter("flag");
		 String id = request.getParameter("id");
		 
		 if(HtmlFactory.isNotEmpty(id) && HtmlFactory.isNotEmpty(flag)){
			 
			 Questions questions = questionsService.findById(Integer.valueOf(id));
			 
			 request.setAttribute("questions", questions);
			 
			 return mapping.findForward(flag);
		 }
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	 return  findAnswersAll(mapping,null,request,response);
 }
	public ActionForward delAnswers(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
	 try {
		 String id = request.getParameter("id");
		 if(HtmlFactory.isNotEmpty(id) ){
			 Questions questions = new Questions();
			 questions.setId(Integer.valueOf(id));
			 questionsService.delete(questions);
		 }
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	 return  findAnswersAll(mapping,null,request,response);
 }
	
}
