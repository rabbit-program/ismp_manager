<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript" src="${ctx}/js/LM/sysLogValidate.js"></script>
<div  id="data" class="pad1 ">
<form action="snmpTrapConfigAction.do?method=addSnmpTrapSource" method="post" onsubmit="return validate_addSysLogSource();">
  <table>
    <tr>
      <th> 添加SnmpTrap日志源 </th>
<tr>
		<td align="right">名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称</td>
		<td colspan="3"><input name="sourceName" type="text" size="30" /></td>
	</tr>
      <tr>
		<td align="right">部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门</td>
		<td><select id="domainId" name="domain" style="width: 105px;">
			<option id="default" value="noDomain" selected="selected">--选择部门--</option>
			<c:forEach items="${domainList}" var="domain">
					<option value="${domain.id }">${domain.domainName }</option>
			</c:forEach>
		</select></td>
<td align="right">设备</td>
		<td><select name="sourceType" style="width: 140px;">
			<option id="default" value="noSourceType" selected="selected">--选择设备类型--</option>
			<c:forEach items="${sourceTypeList}" var="sourceType">
					<option value="${sourceType.id }" 
							title="设备名:${sourceType.sourceTypeName } ; 类型:${sourceType.type } ; 品牌:${sourceType.brand } ; 型号:${sourceType.category } ;"
					>${sourceType.sourceTypeName }</option>
			</c:forEach>
		</select></td>
		
	</tr>
	<tr>
		<td align="right">主机IP</td>
		<td><input id="ip"  name="deviceIP" type="text" size="15"/></td>
		<td align="right">状态</td>
		<td>  <select id="switch" name="startCollectSwitch">
				<option value="true">启用</option>
                <option value="false" selected="selected">未启用</option> 
			</select><span style="color:red;"> * 默认 未启用</span></td>
	</tr>
	
  </table>
  <div class="paddiv"></div> 
  <input class="submit" type="submit" name="测试" value="提交" />
  <div class="paddiv"></div>
</form>
</div>