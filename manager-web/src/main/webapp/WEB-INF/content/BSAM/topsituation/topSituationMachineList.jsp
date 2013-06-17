<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/meta.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Mainframe</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<title>主机态势排名</title>

<!--引入DWR框架-->
<script type='text/javascript' src='${ctx}/dwr/interface/machineSituationService.js'></script>
<script type='text/javascript' src='${ctx}/dwr/engine.js'></script>
<script type='text/javascript' src='${ctx}/dwr/util.js'></script>
     
<script type="text/javascript">
          function getTopMachineSituation(){
              var isAll = document.getElementById("isAll").value;
              var isAllAndtopNum = isAll + ",20";
        	  machineSituationService.getTopMachineSituation(isAllAndtopNum,callbackMethod2);
          }
          function callbackMethod2(data){
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
                	  var tab = document.getElementById("datatbody");
                      var rowNum = tab.rows.length;
                      //清空表格
                      for ( var i = 0; i < rowNum; i++) {
                          tab.deleteRow(i);
                          rowNum = rowNum - 1;
                          i = i - 1;
                      }
                      //循环改变当前 机房的状态
                      if(situations.length > 0){
                          
                          for(var k = 0;k < situations.length;k++){
                              //添加行        
                              var tabrow = tab.insertRow(-1);
                              //添加单元格
                              var ipTD = tabrow.insertCell(-1);
                              ipTD.width = "16%";
                              var machineNameTD = tabrow.insertCell(-1);
                              machineNameTD.width = "14%";
                              var machineDescriptionTD = tabrow.insertCell(-1);
                              machineDescriptionTD.width = "18%";
                              var parentTypeTD = tabrow.insertCell(-1);
                              parentTypeTD.width = "15%";
                              var parentNameTD = tabrow.insertCell(-1);
                              parentNameTD.width = "16%";
                              var wholeSituationTD = tabrow.insertCell(-1);
                              wholeSituationTD.width = "19%";
                              //设置单元格的显示 值 
                              ipTD.innerHTML = situations[k].ip;
                              machineNameTD.innerHTML = situations[k].machineName;
                              machineDescriptionTD.innerHTML = situations[k].machineDescription;
                              parentTypeTD.innerHTML = situations[k].parentType;
                              parentNameTD.innerHTML = situations[k].parentName;
            
                              if(situations[k].wholeSituation < green){
                                  wholeSituationTD.innerHTML = "<img src='${ctx}/img/BSAM/green.jpg' height=20 width="+(137*(situations[k].wholeSituation/100)+1)+"  hspace=0 vspace=0 />" + situations[k].wholeSituation.toFixed(2);
                              }
                              if(situations[k].wholeSituation >= green && situations[k].wholeSituation <= yellow){
                                  wholeSituationTD.innerHTML = "<img src='${ctx}/img/BSAM/yellow.jpg' height=20 width="+(137*(situations[k].wholeSituation/100)+1)+"  hspace=0 vspace=0 />" + situations[k].wholeSituation.toFixed(2);
                              }
                              if(situations[k].wholeSituation > yellow){
                                  wholeSituationTD.innerHTML = "<img src='${ctx}/img/BSAM/red.jpg' height=20 width="+(137*(situations[k].wholeSituation/100)+1)+"  hspace=0 vspace=0 />" + situations[k].wholeSituation.toFixed(2);
                              }       
                          }
                      }else{
                          //添加行
                          var tabrow2 = tab.insertRow(-1);
                          //添加单元格
                          var TD = tabrow2.insertCell(-1);
                          TD.colSpan="6";
                          TD.innerHTML="<p align='center'>当前时间暂无态势!</p>";
                      }
                      // JavaScript Document
                      senfe("senfe","#fff","#eee","#fdf4db","");
                      //senfe("表格名称","奇数行背景","偶数行背景","鼠标经过背景","点击后背景");
                      senfesub("senfe","#fff","#eee","#fdf4db",""); 
                  }else {
                      alert("后台连接失败！！");
                  }
                  
                  setTimeout("getTopMachineSituation()",3000);
              }
        	  ///alert("回调结束！");
          }
///newTd61.innerHTML ="<div style='position:relative'><div style='z-index:1; width:100%; display:block;text-align: left'><img src='images/green.jpg' height=20 width="+(137*(situations[i].wholeSituation/100)+1)+"  hspace=0 vspace=0 /></div><div style='z-index:100; text-align:center; width:100%; position:absolute; left:0; top:0; display:block;'>"+situations[i].wholeSituation+"</div></div>";
///  newTd61.innerHTML ="<div style='position:relative'><div style='z-index:1; width:100%; display:block;text-align: left'><img src='images/yello.jpg' height=20 width="+(137*(situations[i].wholeSituation/100)+1)+"  hspace=0 vspace=0 /></div><div style='z-index:100; text-align:center; width:100%; position:absolute; left:0; top:0; display:block;'>"+situations[i].wholeSituation+"</div></div>"; 
  ///newTd61.innerHTML ="<div style='position:relative'><div style='z-index:1; width:100%; display:block;text-align: left'><img src='images/red.jpg' height=20 width="+(137*(situations[i].wholeSituation/100)+1)+"  hspace=0 vspace=0 /></div><div style='z-index:100; text-align:center; width:100%; position:absolute; left:0; top:0; display:block;'>"+situations[i].wholeSituation+"</div></div>";
</script>           
</head>
<!--<body onload="getSituationRanking20()">-->
<!--<body >-->
<body onload="getTopMachineSituation()">
<div id="contant" class="mainbg">
    <%@ include file="/WEB-INF/content/BSAM/comm/topMenu.jsp"%>
    <div class="contant" >
        <div class="overf h20 martop10">
          <li id="m">
               <a class="mbacka" href="${ctx}/ismp/domain/local/bsam/situationAction.do?method=getTopMachineSituationList<sec:authorize ifAllGranted='ROLE_AdminAll'>&isAll=1</sec:authorize>">
                    <span class="menus10">主机态势前20名</span>
               </a>
          </li>
        </div>
    
        <form name="f1" id="f1" action="/ismp/domain/local/bsam/situationAction.do?method=getTopMachineSituationList" method="post">
               <input type="hidden" id="isAll" name="isAll" value="${isAll}"/>
           <div id="data" class="greenborder overf pad1" >
                <table id="titleName" sortcol="-1">
                    <thead>
                      <tr>
<!--                        <th width="16%" style="cursor:pointer" onclick="sortTable('senfe',0);">主机IP</th>-->
                        <th width="16%">主机IP</th>
                        <th width="14%">主机名称</th>
                        <th width="18%">主机信息</th>
                        <th width="15%">上级物理位置类型</th>
                        <th width="16%">上级物理位置</th>
                        <th width="19%" style="cursor:pointer" onclick="sortTable('senfe',0);">状态</th>
                      </tr>
                    </thead>
                </table>

                <table id="senfe" name="machineTable" sortcol="-1" border="1" cellpadding="0" cellspacing="1">
                    <tbody id="datatbody">
<!--                        <logic:notEmpty name="topMachineListByWeight">-->
<!--                            <logic:iterate id="machine" name="topMachineListByWeight" indexId="i">-->
<!--                            <tr>-->
<!--                              <td width="16%">${machine.ip }</td>-->
<!--                              <td width="16%">${machine.machineName }</td>-->
<!--                              <td width="18%">${machine.description }</td>-->
<!--                              <td width="19%">-->
<!--                                  <c:if test="${machine.parentType == 'JiGui'}">机柜</c:if>-->
<!--                                  <c:if test="${machine.parentType == 'JiFang'}">机房</c:if>-->
<!--                                  <c:if test="${machine.parentType == 'AnQuanYu'}">安全域</c:if>-->
<!--                              </td>-->
<!--                              <td width="15%">-->
<!--                                  <c:if test="${machine.parentType == 'JiGui'}">${machine.machineCabinet.machineCabinetName }</c:if>-->
<!--                                  <c:if test="${machine.parentType == 'JiFang'}">${machine.machineRoom.machineRoomName }</c:if>-->
<!--                                  <c:if test="${machine.parentType == 'AnQuanYu'}">${machine.domain.domainName }</c:if>-->
<!--                              </td>-->
<!--                              <td width="12%">${machine.weight }</td>-->
<!--                            </tr>-->
<!--                            </logic:iterate>-->
<!--                         </logic:notEmpty>    -->
<!--                         <logic:empty name="topMachineListByWeight">-->
<!--                            <tr>-->
<!--                                <td colspan="6">没有找到态势前20名主机！</td>-->
<!--                            </tr>-->
<!--                         </logic:empty>-->
                    </tbody>
                </table>
           </div>
           <div class="paddiv"></div>
        </form>
    </div>
 </div>      
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
