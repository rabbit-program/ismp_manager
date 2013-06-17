<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title>系统管理--WinSensor配置--详细配置</title>
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Newcommon.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Maincontant.css" />
    </head>
    <body>
        <div id="contant" class="mainbg">
            <div id="banner" class="grayline overf bannerH" ></div>
            <div class="contant">
                <h2>WinSensor配置--详细配置</h2>
                <div class="greenborder greenback overf pad3 Height_a" >
                    <div style="float:left; margin-right:8px;">所属单位:
                        <select id="selectid" name="selectid">
                            <option value="-1">请选择单位</option>
                            <logic:present name="udl">
                                <logic:notEmpty name="udl">
                                    <logic:iterate id="u" name="udl">
                                         <c:choose>
                                           <c:when test="${u.id == selectid}">
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
                                 <c:when test="${selectid == -2}">
                                  <option value="-2" selected="selected">未知域</option>
                                 </c:when>
                                 <c:otherwise>
                                   <option value="-2" >未知域</option>
                                 </c:otherwise>
                                </c:choose>
                            </sec:authorize>
                        </select>
                    </div>
                </div>
                <div class="paddiv"></div>
                <h2>Sensor列表</h2>
                <div id="data" class="greenborder overf pad1 " >
                    <table id="senfe" sortcol="-1">
                        <thead>
                            <tr>
                                <th onclick="sortTable('senfe',0);" style="cursor:pointer">sensorID<span class="webdings">6</span></th>
                                <th>客户端名称</th>
                                <th>所属单位</th>
                                <th>IP</th>
                                <th>MAC</th>
                                <th onclick="sortTable('senfe',5,'date');" style="cursor:pointer">修改时间<span class="webdings">6</span></th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                             <c:forEach var="respInfo" items="${respList}" varStatus="status">
                                <tr>
                                    <td> ${respInfo.id } </td>
                                    <td title="${respInfo.name }"> ${fn:substring(respInfo.name,0,6) }.</td>
                                    <td title="${respInfo.domain.domainName}"> ${fn:substring(respInfo.domain.domainName,0,6) }.</td>
                                    <td title="${respInfo.sysName}"> ${fn:substring(respInfo.sysName,0,6) }.</td>
                                    <td> <c:choose><c:when test="${respInfo.state==1}">完成</c:when><c:otherwise>未完成</c:otherwise></c:choose> </td>
                                    <td> ${respInfo.updateTime } </td>
                                    <td>
                                        <a href="#" class="R6" onclick="MM_openBrWindow('${ctx}/ismp/domain/local/erm/updateResp.do?method=updateValue&id=${respInfo.id }&currPage=1','编辑','scrollbars=yes,width=450,height=480')">编辑</a>
                                        <a class="R6 R7" href="#" onclick="MM_openBrWindow('${ctx}/ismp/domain/local/erm/phoneTree.do?method=showtree&respid=${respInfo.id }&respname=${respInfo.name }&isAll=${isAll}','电话树','scrollbars=yes,width=700,height=400')">电话树</a>
                                        <a class="R6 R7" href="#" onclick="MM_openBrWindow('${ctx}/ismp/domain/local/erm/respnotify.do?method=showNotify&id=${respInfo.id }&respname=${respInfo.name }','应急通知规程','scrollbars=yes,width=600,height=450')">应急通知规程</a>
                                        <a href="#" class="R6 R7" onclick="MM_openBrWindow('${ctx}/ismp/domain/local/erm/respproc.do?method=showRespProc&id=${respInfo.id}&respname=${respInfo.name }','应急响应过程','scrollbars=yes,width=600,height=500')">应急响应过程</a>
                                        <a href="#" class="R6 R7" onclick="MM_openBrWindow('${ctx}/ismp/domain/local/erm/bia.do?method=showBia&id=${respInfo.id}&respname=${respInfo.name }','BIA分析','scrollbars=yes,width=600,height=380')">BIA分析</a>
                                        <a href="#" onclick="onDelete('${ctx}','${respInfo.id }','${isAll}')" class="R6" >删除</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            <input type="hidden" id="isAll" name="isAll" value="${isAll}"/>
                        </tbody>
                    </table>
                </div>
                <div class="paddiv"></div>
                <%@ include file="/common/customTags/page/page.jsp"%>
                <br/><br/>
            </div>
        </div>
    </body>
</html>