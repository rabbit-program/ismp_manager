<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript">
	function submit(id){
		var intervalCollectTime = document.getElementById("intervalCollectTime").value;
		var op = document.getElementById("switch").value;

		window.location.href="pcConfigAction.do?method=updatePcSource&id=" + id + "&startCollect=" + op + "&intervalCollectTime=" + intervalCollectTime;
	}
</script>
<div  id="data" class="pad1 ">
  <table>
    <tr>
      <th> 修改 Sensor 采集时间 </th>
	</tr>
	<tr>
		<td colspan="4"><hr/></td>
	</tr>
	<tr>
		<td align="right">计算机名称</td>
		<td><input  type="text" size="15" readonly="readonly" value="${sensorObject.computerName }"/></td>
		<td align="right">Mac</td>
		<td><input  type="text" size="15" readonly="readonly" value="${sensorObject.sensorMac }"/></td>
	</tr>	
	<tr>
		<td align="right">设备IP</td>
		<td><input  type="text" size="15" readonly="readonly" value="${sensorObject.sensorIp }"/></td>
		<td align="right">所属部门</td>
		<td><input type="text" size="15" readonly="readonly" value="${sensorObject.domain.domainName }"/></td>
	</tr>
	
	<tr>
		<td colspan="4"><hr/></td>
	</tr>

	<tr>
		<td align="right">采集时间</td>
		<td><select name="intervalCollectTime">
				<option value="${10*60 }"> 10   分</option>
                <option value="${30*60 }"> 30 分</option>
				<option value="${60*60 }" selected="selected"> 1 小时</option>
				<option value="${6*3600 }"> 6   小时</option>
                <option value="${12*3600 }"> 12小时</option>
				<option value="${24*3600 }"> 1   天</option>
				<option value="${3*24*3600 }"> 3     天</option>
				<option value="${5*24*3600 }"> 5     天</option>
				<option value="${7*24*3600 }"> 7     天</option>
			</select>
		<td align="right">状态</td>
		<td>  <select id="switch" name="startCollectSwitch">
				<option value="true">启用</option>
                <option value="flase" selected="selected">未启用</option> 
			</select><span style="color:red;"> * 默认 未启用</span></td>
	</tr>
	
  </table>
  <div class="paddiv"></div> 
  <input class="submit" type="button" name="测试" value="提交" onclick="submit(${sensorObject.id })" />
  <div class="paddiv"></div>
</div>