<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<body>
<html:form action="/ismp/domain/local/am/hardware.do?method=getOneHareware">
<!--  -->
<div id="data" class="pad1 ">
 	
  <table> 
  		  
        <tr>
          <th>硬件类型：</th>
          <td width="37%"><c:if test="${sessionScope.hardwareType=='memory'}"> 内存 </c:if>
              <c:if
                test="${sessionScope.hardwareType=='harddisk'}"> 硬盘 </c:if>
              <c:if
                test="${sessionScope.hardwareType=='cpu'}"> cpu </c:if>
              <c:if
                test="${sessionScope.hardwareType=='interface'}"> 网卡 </c:if></td>
          <th>硬&nbsp;&nbsp;件&nbsp;&nbsp;名&nbsp;&nbsp;称：</th>
          <td>${hardware.name }</td>
        </tr>
        <tr>
          <th>硬件版本：</th>
          <td>${hardware.version }</td>
          <th>发&nbsp;&nbsp;&nbsp;&nbsp;行&nbsp;&nbsp;&nbsp;&nbsp;商：</th>
          <td>${hardware.manufacturer } </td>
        </tr>
        <tr>
          <th>状 &nbsp;&nbsp;&nbsp;态：</th>
          <td> 
                <c:choose>
                    <c:when test="${hardware.status  == 1}">
                         在用 
                    </c:when>
                    <c:when test="${hardware.status  == 2}"> 
                         废弃
                    </c:when> 
                </c:choose> 
            </td>
          <th>容量或主频信息：</th>
          <td width="33%">${hardware.capacity }</td>
        </tr>
        <tr>
          <th>有 效 期：</th>
          <td>${hardware.validityPeriod }月</td>
          <th>采&nbsp;&nbsp;购&nbsp;&nbsp;时&nbsp;&nbsp;间：</th>
          <td><bean:write name="hardware" property="stockTime" format="yyyy-MM-dd HH:mm"/></td>
        </tr>
        <tr>
          <th>所属机构：           </th>
          <td><logic:notEmpty name="managerbo" scope="session">
                                    <logic:iterate id="m" name="managerbo" scope="session">
                                          <c:choose>
								<c:when test="${hardware.locationId eq m.id}">
                                              ${m.domainName} 
                                            </c:when>
								<c:when test="${empty hardware.locationId}">
                                             <c:set value="true" var="novalue"></c:set>
                                            </c:when>
                                          </c:choose> 
                                        
                                    </logic:iterate>  
                                        
                                </logic:notEmpty>
                                         <c:if test="${novalue == true}">
                                            未指派
                                         </c:if></td>
          <th>登&nbsp;&nbsp;记&nbsp;&nbsp;时&nbsp;&nbsp;间：</th>
          <td><bean:write name="hardware" property="registrationTime" format="yyyy-MM-dd HH:mm"/></td>
        </tr>
        <tr>
          <th>描&nbsp;&nbsp;&nbsp;&nbsp;述：</th>
          <td>${hardware.description }</td>
          <td>  </td>
          <td> </td>
        </tr>
      </table>
      <br>
      <div align="center">
      <input class="submit" type="button" onclick="javascript:history.back(-1);" value="返回" name="Submit3">
      </div>
  </div>
</html:form>
</body>
</html>