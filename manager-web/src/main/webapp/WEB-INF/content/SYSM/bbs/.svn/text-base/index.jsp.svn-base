<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Mainframe</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/VPM/pm/pmUpdate.css" type="text/css" />
<script type="text/javascript">

        function toPage(curpage) {
            document.getElementById("currPage").value = curpage;
            document.forms["respShow"].submit();
        }
        function del_card(){
               if(confirm("确认删除吗?")){
                   return true;
            }
               return false;
        }
        
</script>
</head>
<body>

     <form name="respShow" id="respShow" action="${ctx}/ismp/sysm/other/bbs.do?method=findAnswersAll" method="post">
        <table id="senfe" name="monitortable" sortcol="-1" border="0" cellpadding="0" cellspacing="1">
                    <tbody>
                         <tr>
                           <td align="center"><a href="${ctx}/ismp/sysm/other/new_card.do" title="添加">发帖 </a></td>
                         </tr>
	                      <tr>
	                        <th width="13%" style="cursor:pointer" onclick="sortTable('senfe',0);">标题</th>
	                        <th width="13%">发布时间</th>
	                        <th width="13%">发布人</th>
	                        <th width="16%">操作</th>
	                      </tr>
                        <logic:notEmpty name="questions">
                            <logic:iterate id="question" name="questions" indexId="i">
	                            <tr>
	                              <td width="13%"><a href="${ctx}/ismp/sysm/other/bbs.do?method=detailAnswers&flag=detail&id=${question.id}">${question.q_title}</a></td>
	                              <td width="13%" align="center">${question.createTime }</td>
	                              <td width="13%" align="center">${question.sender.username }</td>
	                              <td width="16%" align="center">
	                                <a title='删除'   href='${ctx}/ismp/sysm/other/bbs.do?method=delAnswers&id=${question.id}' onclick="return del_card()"><img src='${ctx}/img/SCM/b_delete.gif' border='0'/></a>&nbsp;&nbsp;&nbsp;&nbsp;
	                                <a title='查看'   href='${ctx}/ismp/sysm/other/bbs.do?method=detailAnswers&flag=detail&id=${question.id}'><img src='${ctx}/img/SCM/b_detail.png' border='0'/></a>&nbsp;&nbsp;&nbsp;&nbsp;
	                              </td>
	                            </tr>
                            </logic:iterate>
                         </logic:notEmpty>    
                    </tbody>
                </table>
                <%@ include file="/common/customTags/page/page.jsp"%>
    </form>
        </body>
</html>