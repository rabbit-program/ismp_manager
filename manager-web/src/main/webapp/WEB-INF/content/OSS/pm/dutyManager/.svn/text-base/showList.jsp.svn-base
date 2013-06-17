<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title>运维支撑--值班管理--排班管理</title>
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Newcommon.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Maincontant.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/common.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/boxy.css" />
        <link rel="stylesheet" href="${ctx}/css/comm/date/skin/WdatePicker.css" type="text/css" />
        <script type="text/javascript" src="${ctx}/js/comm/date/WdatePicker.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
        <script type="text/javascript" src="${ctx}/js/OSS/PM/dutySchedule.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/js/floatdiv.js"></script>
		<script type="text/javascript">
        $(function(){
            $(".boxy").boxy();
            $.post("${ctx}/ismp/domain/local/vpm/pm/doManinTree.do?method=getDoMainAll",function(response){
                $(response).find('SH').each(function(index,evendate){
                    $("<option value='" + $(this).children('id').text() + "'>" + $(this).children('name').text() + "</option>").appendTo($("#doselect"));
                });    
           },'html');
        });
        // 添加或修改弹出新对话框用到--//v2.0
        function MM_openBrWindow(theURL,winName,features) {
              window.open(theURL,winName,features);
            
        }
         function MM_submit(sh){
              sh.close();
              document.forms[0].submit();
          }
		    function toPage(curpage) {
		        document.getElementById("currPage").value = curpage;
		        document.forms[1].submit();
		    }
		  function seach(){
              var $form= document.getElementById("seachConditions");
              var $action=$form.action;
              var $domain=document.getElementById("doselect");
              var $domain_value=$domain.selectedIndex;
              var $time =document.getElementById("selectTime").value;
              $action += $domain_value > 0 ? "&type=seach&doid="+$domain.value  : "" + $time ? "&seachTime="+$time : "" ;
              if(!($form.action.trim() == $action.trim())){
            	     $form.action = $action;
            	     $form.submit();
                  }
              return false;
		}
	    function delDuty(){
                return confirm("确认要删除吗?") ? true : false;
		}
		</script>
    </head>
    <body>
        <div id="contant" class="mainbg">
            <%@ include file="/WEB-INF/content/OSS/comm/topMenu.jsp"%>
            <div class="contant"> 
                <div class="overf h20 martop10"> 
                    <li><a  class="mback" href="${ctx}/ismp/oss/pm/dsinfo.do?method=dsall&identifier=onduty"><span class="menus11">当班人员</span></a></li>
                    <li><a  class="mbacka" href="${ctx}/ismp/oss/pm/dsinfo.do?method=dsall&identifier=publishingManagement"><span class="menus12">排班管理</span></a></li>
                </div>
                <div class="greenborder pad3 overf">
              <form action="${ctx}/ismp/oss/pm/dsinfo.do?method=dsall&identifier=publishingManagement" id="seachConditions" name="seachConditions" method="post" >
                    <h2 class="martop10">请选择委办局</h2>
                    <div class="greenborder greenback overf pad3 Height_a" >
                        <span style="float:left;">委办局
                            <select name="doselect" id="doselect" onchange="selectDomain(this)">
                                <option>==委办局==</option>
                            </select>
                        </span>
                        <span style="float:left;">
                                                                            选择时间
                            <input type="text" size="8" id="selectTime" name="selectTime" class="input" readonly="readonly" onclick="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
                        </span>
                        <a href="#" onclick="seach()" class="R6" style="margin-left:12px;">查询</a>
                        <a href="#" onclick="MM_openBrWindow('newDuty.do','添加','scrollbars=yes,width=720,height=400')" class="R6" style="margin-left:12px;">排班</a>
                        <a href="javascript:void(0)" onclick="publish(this)" class="R6" style="margin-left:12px;">发布</a>
                        <a href="${ctx}/ismp/oss/pm/rosterInfo.do?method=rosterInfoAll" class="R6 R7" style="margin-left:12px;">人员变更</a>
                    </div>
                  </form>   
                    <h2 class="martop10">列表</h2>
                    <div id="data" class="greenborder overf pad1" >
                            <table id="senfe" sortcol="-1">
                                <thead>
									<tr>
										<th width="21%" style="cursor:pointer" onclick="sortTable('senfe',0);">时间</th>
										<th width="41%"> 备注</th>
										<th width="21%"> 人员</th>
										<th width="17%"> 操作</th>
									</tr>
								</thead>
								<tbody>
                                <logic:iterate id="ds" name="list" scope="request"  >
									<tr>
										<td> <bean:write name="ds" property="startTime" format="yyyy-MM-dd HH:mm:ss"/>  
                                                <logic:equal value="1" name="ds" property="isPublished">
                                                  <span style="color: blue;">已发布</span>
                                                 </logic:equal></td>
										<td>
                                           <c:choose>
                                             <c:when test="${fn:length(ds.task) > 30}">
                                                ${fn:substring(ds.task,0,30)}.....
                                             </c:when>
                                             <c:otherwise>
                                               <bean:write name="ds" property="task"/>
                                             </c:otherwise>
                                           </c:choose>
                                        
                                        </td>
										<td>
										<logic:iterate name="ds" id="roster" property="roster" indexId="x" >
										     [<bean:write name="roster" property="name"/>]&nbsp;
                                        </logic:iterate></td>
										<td><span class="tdnowrap">
                                         <a href="javascript:void(0)" onclick="javascript:MM_openBrWindow('dsinfo.do?method=dsById&identifier=dutyDetail&dsid=<bean:write name='ds' property='id'/>','查看','scrollbars=yes,width=710,height=480')">查看</a>
                                            <span id="duty_update">|
                                                  <logic:equal value="0" name="ds" property="isPublished"><a href="javascript:void(0)"  onclick="MM_openBrWindow('dsinfo.do?method=dsById&identifier=modifyDuty&dsid=<bean:write name='ds' property='id'/>','修改','scrollbars=yes,width=710,height=480')">修改</a>
                                            </span>|
                                         </logic:equal>
                                         <a href="${ctx}/ismp/oss/pm/dsinfo.do?method=dsDel&identifier=publishingManagement&dsid=<bean:write name='ds' property='id'/>"  onclick="return delDuty()">删除</a></span></td>
									</tr>
                               
                                </logic:iterate>
								</tbody>
                            </table>
                       
                    </div>
                  <form name="f1" id="f1" action="${ctx}/ismp/oss/pm/dsinfo.do?method=dsall&identifier=publishingManagement" method="post">
                    <%@ include file="/common/customTags/page/page.jsp"%>
                  </form>
					<br />
					<br />
					<br />
                </div>
            </div>
        </div>
    </body>
    <script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>