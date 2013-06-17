<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ page import="java.util.TreeMap"%>
<%@page import="java.util.Iterator"%>
<%@ page import="edu.sjtu.infosec.ismp.manager.LM.dLog.web.form.SysLogInitQueryBean"%>
<script type="text/javascript" src="${ctx}/js/LM/sysLogValidate.js"></script>
<div  id="data" class="pad1 ">
<form action="sysLogAction.do?method=originalDisplay" method="post" onsubmit="return validate_SysLogQuery();">
  <table>
    <tr>
      <th> 自定义搜索 </th>
      <tr>
		<td>部门</td>
		<td><select name="domain" style="width: 130px;">
			<option id="default" value="all" selected="selected" >--全部--</option>
			<c:forEach items="${sysLogInitQueryBean.domain}" var="domain">
					<option value="${domain.id }" title="${domain.domainName }">${domain.domainName }</option>
			</c:forEach>
		</select></td>
		<td>程序模块</td>
		<td><select name="facility" style="width: 130px;">
			<option id="default" value="all" selected="selected">--全部--</option>
			<%
				TreeMap<Integer,String> facility = ((SysLogInitQueryBean)request.getAttribute("sysLogInitQueryBean")).getFacility();
				Iterator<Integer> facilityIter = facility.keySet().iterator();	
				for(;facilityIter.hasNext();){
					int facilityKey =  facilityIter.next();
					String facilityValue = facility.get(facilityKey);
			%>
					<option value="<%=facilityKey %>" title="<%=facilityKey %>-<%=facilityValue %>"><%=facilityKey %>-<%=facilityValue %></option>
			<%
				}
			%>
		</select></td>
	</tr>
	<tr>
		<td>起始时间</td>
		<td><input id="beginDate" name="beginDate" class="Wdate" readonly="readonly"
			type="text" value="${sysLogInitQueryBean.beginDate }"
			onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" /></td>
		<td>截止时间</td>
		<td><input id="endDate" name="endDate" class="Wdate" readonly="readonly" type="text"
			value="${sysLogInitQueryBean.endDate }"
			onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" /></td>
	</tr>
	<tr>
		<td>主机IP</td>
		<td><input name="hostname" type="text" size="15" value="${sysLogResponseQueryBean.hostname }" /></td>
		<td>严重性</td>
		<td><select name="severity" style="width: 130px;">
			<option id="default" value="all" selected="selected">--全部--</option>
			<%
				TreeMap<Integer,String> severity = ((SysLogInitQueryBean)request.getAttribute("sysLogInitQueryBean")).getSeverity();
				Iterator<Integer> severityIter = severity.keySet().iterator();
				for(;severityIter.hasNext();){
					int severitykey =  severityIter.next();
					String severityValue = severity.get(severitykey);
			%>
					<option value="<%=severitykey %>" title="<%=severitykey %>-<%=severityValue %>"><%=severitykey %>-<%=severityValue %></option>
			<%
				}
			%>
		</select></td>
	</tr>
	<tr>
		<td>消息关键字</td>
		<td colspan="3"><input name="message" type="text" size="50" value="${sysLogResponseQueryBean.message }" /></td>
	</tr>
  </table>
  <div class="paddiv"></div> 
  <input class="submit" type="submit" name="测试" value="提交" />
  <div class="paddiv"></div>
</form>
</div>
