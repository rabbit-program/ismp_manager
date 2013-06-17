<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/meta.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>态势感知</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/common.css" rel="stylesheet"  type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx}/js/BSAM/jquery-1.4.2.js"></script>
<script type="text/javascript" src="${ctx}/js/BSAM/jquery.ui.core.js"></script>
<script type="text/javascript" src="${ctx}/js/BSAM/jquery.ui.widget.js"></script>
<script type="text/javascript" src="${ctx}/js/BSAM/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="${ctx}/js/BSAM/jquery.ui.draggable.js"></script>
<!--引入DWR框架-->
<script type='text/javascript' src='${ctx}/dwr/interface/securityAreaSituationService.js'></script>
<script type='text/javascript' src='${ctx}/dwr/engine.js'></script>
<!--<script type='text/javascript' src='${ctx}/dwr/util.js'></script>-->
<script type="text/javaScript">
$(function() {
    $(".draggable").draggable({containment: "#DragArea",zIndex: 1000 });
});
//域双击事件 后界面跳转
function getSubSituation(type,id){
    window.location.href="${ctx}/ismp/domain/local/bsam/situationAction.do?method=getSubUnitList&type="+type+"&id="+id;
}
</script>
</head>
<body onload="findSecurityAreaSituation();">
<!--<body >-->
<div id="contant" class="mainbg">
  <%@ include file="/WEB-INF/content/BSAM/comm/topMenu.jsp"%>
  <div class="contant" >
        <div class="overf h20 martop10">
          <li id="m">
               <a class="mback" href="${ctx}/ismp/domain/local/bsam/situationAction.do?method=getSecurityAreaSituationList<sec:authorize ifAllGranted='ROLE_AdminAll'>&isAll=1</sec:authorize>">
                    <span class="menus10">域态势</span>
               </a>
          </li>
        </div>
    
        <form name="f1" id="f1" action="/ismp/domain/local/bsam/situationAction.do?method=getSecurityAreaSituationList" method="post">
               <input type="hidden" id="isAll" name="isAll" value="${isAll}"/>
               <input type="hidden" id="userDomainStr" name="userDomainStr" value="${userDomainStr}"/>
           <div id="data" class="greenborder overf pad1" >
                <table id="titleName" sortcol="-1">
                    <thead>
                      <tr>
                        <th style="text-align: center">域分布图</th>
                      </tr>
                    </thead>
                </table>
                <div style="height: 600px;background-color: #D8E9EC;" id="DragArea" >
                    <logic:notEmpty name="userDomainList">
                       <logic:iterate id="domain" name="userDomainList" indexId="i">
	                        <div style="width: 100px;height: 70px;background-color: #D8E9EC;float: left;margin: 10px"  class="draggable">
	                            <span style="text-align: right">
                                    <a href="#" ondblclick="getSubSituation('AnQuanYu',${domain.id})" title="${domain.domainName}" id="${domain.domainName}" >${domain.domainName}</a>
                                </span>
	                            <img src="${ctx}/img/BSAM/yuntu.png" width="100" height="50" id="${domain.domainName}alert"/>
	                            <span class="domainSituation" id="${domain.id}message">${domain.id}message</span>
	                        </div>
                       </logic:iterate>
                    </logic:notEmpty>    
                    <logic:empty name="userDomainList">
                                                                没有找到域！
                    </logic:empty>
                </div>
                
           </div>
           </form>
      </div>
   </div>
</body>
<script type="text/javascript" language="javascript" defer="defer">
      function findSecurityAreaSituation(){
    	  var userDomainStr = document.getElementById("userDomainStr").value;
    	  securityAreaSituationService.getSecurityAreaSituation(userDomainStr,callbackMethod);
      }
      function callbackMethod(data){
          
    	  var situations = data[0];
          var colors = data[1];
          var errorMessage = data[2];

          if(null != situations && null != colors){
        	  var yellow;
              var green;
              //先取得颜色值
              for(var j = 0;j < colors.length;j++){
                  if(colors[j].color == 'yellow'){
                      yellow = colors[j].value;
                  }
                  if(colors[j].color == 'green'){
                      green = colors[j].value;
                  }
              }

              if(errorMessage != "error"){
            	//循环改变当前 安全域的态势值
                  if(situations.length > 0){
                      
                      for(var k = 0;k < situations.length;k++){
                          var message = document.getElementById(situations[k].id + "message");
                          if(situations[k].wholeSituation < green){
                              message.innerHTML = "<img src='${ctx}/img/BSAM/green.jpg' height=8 width="+(70*(situations[k].wholeSituation/100)+1)+"  hspace=0 vspace=0 />" + situations[k].wholeSituation.toFixed(2);
                          }
                          if(situations[k].wholeSituation >= green && situations[k].wholeSituation <= yellow){
                              message.innerHTML = "<img src='${ctx}/img/BSAM/yellow.jpg' height=8 width="+(70*(situations[k].wholeSituation/100)+1)+"  hspace=0 vspace=0 />" + situations[k].wholeSituation.toFixed(2);
                          }
                          if(situations[k].wholeSituation > yellow){
                              message.innerHTML = "<img src='${ctx}/img/BSAM/red.jpg' height=8 width="+(70*(situations[k].wholeSituation/100)+1)+"  hspace=0 vspace=0 />" + situations[k].wholeSituation.toFixed(2);
                          } 
                      }
                  } 
              }else {
            	    alert("后台连接失败！！");
              }
              
              setTimeout("findSecurityAreaSituation()",3000);
          }
      }
</script>
</html>