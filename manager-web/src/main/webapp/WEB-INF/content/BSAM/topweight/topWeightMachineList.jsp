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
<title>主机重要性排名</title>
<script type="text/javascript">
</script>    
</head>
<body>
<div id="contant" class="mainbg">
    <%@ include file="/WEB-INF/content/BSAM/comm/topMenu.jsp"%>
    <div class="contant" >
        <div class="overf h20 martop10">
          <li id="m">
               <a class="mbacka" href="${ctx}/ismp/domain/local/bsam/machineAction.do?method=getTopMachineListByWeight<sec:authorize ifAllGranted='ROLE_AdminAll'>&isAll=1</sec:authorize>">
                    <span class="menus10">主机重要性前20名</span>
               </a>
          </li>
        </div>
    
        <form name="f1" id="f1" action="/ismp/domain/local/bsam/machineAction.do?method=getTopMachineListByWeight" method="post">
               <input type="hidden" id="isAll" name="isAll" value="${isAll}"/>
           <div id="data" class="greenborder overf pad1" >
                <table id="titleName" sortcol="-1">
                    <thead>
                      <tr>
<!--                        <th width="16%" style="cursor:pointer" onclick="sortTable('senfe',0);">主机IP</th>-->
                        <th width="16%">主机IP</th>
                        <th width="16%">主机名称</th>
                        <th width="18%">主机信息</th>
                        <th width="19%">上级物理位置类型</th>
                        <th width="15%">上级物理位置</th>
                        <th width="12%">权重</th>
                      </tr>
                    </thead>
                </table>

                <table id="senfe" name="machineTable" sortcol="-1" border="0" cellpadding="0" cellspacing="1">
                    <tbody>
                        <logic:notEmpty name="topMachineListByWeight">
                            <logic:iterate id="machine" name="topMachineListByWeight" indexId="i">
                            <tr>
                              <td width="16%">${machine.ip }</td>
                              <td width="16%">${machine.machineName }</td>
                              <td width="18%">${machine.description }</td>
                              <td width="19%">
                                  <c:if test="${machine.parentType == 'JiGui'}">机柜</c:if>
                                  <c:if test="${machine.parentType == 'JiFang'}">机房</c:if>
                                  <c:if test="${machine.parentType == 'AnQuanYu'}">安全域</c:if>
                              </td>
                              <td width="15%">
                                  <c:if test="${machine.parentType == 'JiGui'}">${machine.machineCabinet.machineCabinetName }</c:if>
                                  <c:if test="${machine.parentType == 'JiFang'}">${machine.machineRoom.machineRoomName }</c:if>
                                  <c:if test="${machine.parentType == 'AnQuanYu'}">${machine.domain.domainName }</c:if>
                              </td>
                              <td width="12%">${machine.weight }</td>
                            </tr>
                            </logic:iterate>
                         </logic:notEmpty>    
                         <logic:empty name="topMachineListByWeight">
                            <tr>
                                <td colspan="6">没有找到权重前20名主机！</td>
                            </tr>
                         </logic:empty>
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
