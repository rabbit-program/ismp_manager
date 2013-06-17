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
<title>软件详细信息</title>


</head>
<body onload="top.resizeTo(950,520);" onload="top.moveBy(400,500);">
<div  id="data" class="pad1 ">
<table >
            <tr>
              <th>软件名称:</th>
              <td width="31%"><div align="center">${softinfo.name }</div></td>
              <th>软件类型:</th>
              <td><c:if test="${sessionScope.SoftType=='os'}">
                  <div align="center">操作系统 </div>
              </c:if>
                  <c:if test="${sessionScope.SoftType=='app'}">
                    <div align="center">应用软件 </div>
                  </c:if>
                  <c:if test="${sessionScope.SoftType=='db'}">
                    <div align="center">数据库 </div>
                  </c:if>
                  <c:if test="${sessionScope.SoftType=='oa'}">
                    <div align="center">办公软件 </div>
                  </c:if>
                  <c:if test="${sessionScope.SoftType=='other'}">
                    <div align="center">其他 </div>
                  </c:if></td>
            </tr>
            <tr>
              <th>发行商: </th>
              <td><div align="center">${softinfo.manufacturer } </div></td>
              <th>版本:</th>
              <td><div align="center">${softinfo.version } </div></td>
            </tr>
            <tr>
              <th>登记时间:</th>
              <td><div align="center"><bean:write name="softinfo" property="registrationTime" format="yyyy-MM-dd HH:mm"/> </div></td>
              <th>使用人:</th>
              <td><div align="center">${softinfo.user } </div></td>
            </tr>
            <tr>
              <th>使用人电话:</th>
              <td><div align="center">${softinfo.telephone } </div></td>
              <th>单位:</th>
              <td><div align="center">${softinfo.unit } </div></td>
            </tr>
            <tr>
              <th>部门:</th>
              <td><div align="center">${softinfo.department } </div></td>
              <th>状态:</th>
              <td><div align="center"> 
				<c:choose>
                    <c:when test="${softinfo.status == 1}">
                         在用
                    </c:when>
                    <c:when test="${softinfo.status == 2}"> 
                        废弃
                    </c:when> 
                </c:choose>
		</div></td>
            </tr>
            <tr>
              <th>采购时间:</th>
              <td><div align="center"><bean:write name="softinfo" property="stockTime" format="yyyy-MM-dd HH:mm"/> </div></td>
              <th>有效期:</th>
              <td><div align="center">${softinfo.validityPeriod }月 </div></td>
            </tr>
            <tr>
              <th>描述信息:</th>
              <td><div align="center">${softinfo.description } </div></td>
              <th>所属机构:</th>
              <td><div align="center">

 			<logic:notEmpty name="managerbo" scope="session">
                                    <logic:iterate id="m" name="managerbo" scope="session">
                                          <c:choose>
                                            <c:when test="${softinfo.locationId eq m.id}">
                                              ${m.domainName} 
                                            </c:when>
                                            <c:when test="${empty softinfo.locationId}">
                                             <c:set value="true" var="novalue"></c:set>
                                            </c:when>
                                          </c:choose> 
                                        
                                    </logic:iterate>  
                                        
              </logic:notEmpty>
                                         <c:if test="${novalue == true}">
                                            未指派
                                         </c:if>
</div></td>
            </tr>
        </table>
        <br>
        <div align="center"><input class="submit" type="button" onclick="javascript:history.back(-1);" value="返回" name="Submit3"></div>
        </div>
</body>
</html>