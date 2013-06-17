<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>客户端问题管理</title>
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Newcommon.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Maincontant.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/common.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/boxy.css" />
        <script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/js/floatdiv.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/date/WdatePicker.js"></script>
        <script type="text/javaScript">
            function toPage(curpage) {
	            document.getElementById("currPage").value = curpage;
	            var isAll = document.getElementById("isAll").value ;
	            document.respShow.action="${ctx}/ismp/domain/local/oss/clientQuestion.do?method=showQuestion&isAll="+isAll+"&currPage="+curpage;
	            respShow.submit(); 
	        }
            function clean()
            {
            	document.forms[0].domain.value=-1;
            	document.forms[0].state.value="";
             }  

            function MM_openBrWindow(theURL,winName,features) { //v2.0
            	  window.open(theURL,winName,features);
            	  window.close(); 
            }


            function OnClose(id){
            	var currPage=document.getElementById("currPage").value;
                var isAll = document.getElementById("isAll").value ;
                var r = confirm("确认关闭")
                if (r==true) {
                  window.location.href ="${ctx}/ismp/domain/local/oss/clientQuestion.do?method=OnClose&isAll="+isAll+"&currPage="+currPage+"&id="+id;
                }
            }
            function lookWorkOrder(){
                var isAll = document.getElementById("isAll").value ;
                window.location.href = "${ctx}/ismp/domain/local/oss/workOrder.do?method=showWorkOrder&isAll="+isAll;
            }

</script>
</head>
<body>
<form action="${ctx}/ismp/domain/local/oss/clientQuestion.do?method=showQuestion&isAll=${isAll}" id="respShow" name="respShow" method="post">
        <div id="contant" class="mainbg">
            <%@ include file="/WEB-INF/content/OSS/comm/topMenu.jsp"%>
                <div class="contant">
			     <%@ include file="/WEB-INF/content/OSS/wom/comm/topmenu.jsp"%>
                   <div class="greenborder pad3 overf">
                    <h2>客户端问题查询</h2>
                    <div class="greenborder greenback overf pad3 Height_a" >
                        <div style="float:left; margin-right:8px;">所属域:
                            <select id="domain" name="domain">
                                <option value="-1">请选择单位</option>
                                <logic:present name="udl">
                                    <logic:notEmpty name="udl">
                                        <logic:iterate id="u" name="udl">
	                                         <c:choose>
		                                       <c:when test="${u.id == domain}">
		                                        <c:set var="select13" value="selected"></c:set>
		                                       </c:when>
		                                       <c:otherwise>
		                                        <c:set var="select13" value=""></c:set>
		                                       </c:otherwise>
		                                      </c:choose>
                                            <option value="${u.id}"  ${select13 }>${u.domainName}</option>
                                        </logic:iterate>
                                    </logic:notEmpty>
                                </logic:present>
                                <sec:authorize ifAllGranted='ROLE_AdminAll'>
                                   <c:choose>
                                     <c:when test="${domain == -2}">
                                      <option value="-2" selected="selected">未知域</option>
                                     </c:when>
                                     <c:otherwise>
                                       <option value="-2" >未知域</option>
                                     </c:otherwise>
                                    </c:choose>
                                </sec:authorize>
                            </select>
                                                                           问题状态：
                            <select id="state" name="state">
                            <option value="">请选择状态</option>
                                <c:choose>
                                 <c:when test="${state==1}">
                                   <c:set var="select1" value="selected"></c:set>
                                 </c:when>
                                 <c:otherwise>
                                   <c:set var="select1" value=""></c:set>
                                 </c:otherwise>
                                </c:choose>  
                             <c:choose>
                                 <c:when test="${state==2}">
                                   <c:set var="select2" value="selected"></c:set>
                                 </c:when>
                                 <c:otherwise>
                                   <c:set var="select2" value=""></c:set>
                                 </c:otherwise>
                                </c:choose>  
                            <c:choose>
                                 <c:when test="${state==3}">
                                   <c:set var="select3" value="selected"></c:set>
                                 </c:when>
                                 <c:otherwise>
                                   <c:set var="select3" value=""></c:set>
                                 </c:otherwise>
                                </c:choose>  
                            <c:choose>
                                 <c:when test="${state==4}">
                                   <c:set var="select4" value="selected"></c:set>
                                 </c:when>
                                 <c:otherwise>
                                   <c:set var="select4" value=""></c:set>
                                 </c:otherwise>
                                </c:choose>  

                             <c:choose>
                                 <c:when test="${state==5}">
                                   <c:set var="select5" value="selected"></c:set>
                                 </c:when>
                                 <c:otherwise>
                                   <c:set var="select5" value=""></c:set>
                                 </c:otherwise>
                                </c:choose>  
							<option value="1" ${select1}>未处理</option>
							<option value="2" ${select2}>处理中</option>
							<option value="3" ${select3}>已处理</option>
							<option value="4" ${select4}>已关闭</option>
							<option value="5" ${select5}>未知</option>
                            </select>
                        </div>
                        <span style="float:left;"><a href="#" class="R6" style="margin-left:12px;"  onclick="javascript:toPage(1);">搜索</a><a href="#" class="R6" style="margin-left:12px;"  onclick="clean()">重置</a></span>
                    </div>
                    <div class="paddiv"></div>
                    <h2>问题列表(表格现有排序功能,点击带箭头单元格)</h2>
                    <div id="data" class="greenborder overf pad1 " >
                        <table id="senfe" sortcol="-1">
                            <thead>
                                <tr>
                                    <th onclick="sortTable('senfe',0);" style="cursor:pointer">问题ID<span class="webdings">6</span></th>
                                    <th>联系人</th>
                                    <th>问题状态</th>
                                    <th>提交时间</th>
                                    <th>问题名称</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                 <c:forEach var="question" items="${questionList}" varStatus="status">
                                    <tr>
                                        <td> ${question.id } </td>
                                        <td> ${question.linkman } </td>
                                        <td> <c:choose><c:when test="${question.state==1}">未处理</c:when>
										<c:when test="${question.state==2}">处理中</c:when>
										<c:when test="${question.state==3}">已处理</c:when>
										<c:when test="${question.state==4}">已关闭</c:when>
                                        <c:otherwise>未知</c:otherwise></c:choose> </td>
                                        <td> ${question.createTime } </td>
                                        <td> ${question.name } </td>
                                        <td>
                                          <c:if test="${question.state!=4}">
                                            <c:if test="${question.state!=3}">
                                            <a href="#" onclick="OnClose('${question.id }')" class="R6" >关闭</a>
                                            </c:if>
                                            <c:if test="${question.state==1}">
                                             <a class="R6 R7" href="#" onclick="MM_openBrWindow('${ctx}/ismp/domain/local/oss/workOrder.do?method=preAddWorkOrder&id=${question.id}&isAll=${isAll}','新建工单','scrollbars=yes,width=480,height=580')">生成工单</a>
											</c:if>										 
										 </c:if>                                           
										  <a class="R6 R7" href="#" onclick="MM_openBrWindow('${ctx}/ismp/domain/local/oss/clientQuestion.do?method=lookQuestion&id=${question.id}','查看','scrollbars=yes,width=800,height=500')">查看</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <input type="hidden" id="isAll" name="isAll" value="${isAll}"/>
                            </tbody>
                        </table>
                    </div>
                    <div class="paddiv"></div>
             <ul id="page">
			    <li><a class="first" href="javascript:toPage(1);"></a></li>
			    <c:if test="${currPage>1 }">
			        <li><a class="pre" href="javascript:toPage(${currPage-1 });"></a></li>
			    </c:if>
			    <c:if test="${currPage<totalPage }">
			        <li><a class="next" href="javascript:toPage(${currPage+1 });"></a></li>
			    </c:if>
			    <li><a class="last" href="javascript:toPage(${totalPage });"></a></li>
			    <li>
			                             共 ${totalPage } 页 跳至
			        <input id="currPage" name="currPage" type="text" size="2" class="input" value="${currPage }"/>
			        &nbsp;
			    </li>
			    <li><a class="R6" href="javascript:toPage(document.getElementById('currPage').value);">GO</a></li>
            </ul>
                    <br/><br/>
                </div>
        </div>
</form>
    </body>
    <script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>