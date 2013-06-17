<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title>运维支撑--值班管理--人员管理--值班人员详细信息</title>
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Newcommon.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Maincontant.css" />
    </head>
    <body>
        <form action="${ctx}/ismp/oss/pm/rosterInfo.do?method=rosterInfoadd" method="post">
            <div id="data" class="pad1 ">
                <h2>值班人员信息</h2>
                <table>
                    <tr>
                        <th>姓名<span class="alert">*</span></th>
                        <td><input type="text" disabled="disabled" size="8" name="roster.name" value="<bean:write name='roster' property='name'/>" id="name"/></td>
                    </tr>
                    <tr>
                         <th>编号<span class="alert">*</span></th>
                          <td><input type="text" size="8" disabled="disabled" name="roster.sn" id="sn" value="<bean:write name='roster' property='sn'/>"/></td>
                    </tr>
                    <tr>
                         <th>性别<span class="alert">*</span></th>
                          <td> 
								<logic:equal value="1" name="roster" property="sex">女</logic:equal>  
								<logic:equal value="0" name="roster" property="sex">男</logic:equal>  
					     </td>
                    </tr>
                    <tr>
                        <th>所属域<span class="alert">*</span></th>
                       <td><input type="text" size="8" disabled="disabled" name="roster.position" value="<bean:write name='roster' property='domain.domainName'/>" id="name"/></td>
                    </tr>
                    <tr>
                        <th>职务<span class="alert">*</span></th>
                        <td><input type="text" size="8" disabled="disabled" name="roster.position" value="<bean:write name='roster' property='position'/>" id="name"/></td>
                    </tr>
                    <tr>
                        <th>手机<span class="alert">*</span></th>
                        <td><input type="text" size="8" disabled="disabled" value="<bean:write name='roster' property='mobile'/>" name="roster.mobile" id="name"/></td>
                    </tr>
                    <tr>
                        <th>固话<span class="alert">*</span></th>
                        <td><input type="text" size="8" disabled="disabled" name="roster.phone" value="<bean:write name='roster' property='phone'/>" id="name"/></td>
                    </tr>
                    <tr>
                        <th>e-mail<span class="alert">*</span></th>
                        <td><input type="text" size="8" disabled="disabled" name="roster.email" value="<bean:write name='roster' property='EMail'/>" id="name"/></td>
                    </tr>
                    <tr>
                        <th>备注<span class="alert"></span></th>
                        <td colspan="3"><textarea cols="60" rows="5" disabled="disabled" value="<bean:write name='roster' property='remark'/>" id="remark" name="roster.remark"></textarea></td>
                    </tr>
                </table>
                <div class="paddiv"></div>
                <div class="paddiv"></div>
            </div>
        </form>
    </body>
</html>