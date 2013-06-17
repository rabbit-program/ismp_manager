<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<logic:present name="showFlag">

	<logic:equal name="showFlag" value="SanLingIDS_0.0">
		<h2 class="martop10">SnmpTrap列表</h2>
      <div id="data" class="greenborder overf pad1" >
          <table id="senfe" sortcol="-1">
            <thead>
              <tr>
                <th style="cursor:pointer" onclick="sortTable('senfe',0);"> 序号 <span class="webdings">↓ </span></th>
				<th> 时间 </th>                
				<th> 源IP</th>
                <th> 源端口 </th>
                <th> 目的IP </th>
				<th> 目的端口 </th>
				<th> 事件类型 </th>
				<th> 协议类型 </th>
				<th> 威胁等级 </th>
				<th> 事件的描述 </th>
				<th> 设备IP </th>
				<th> 部门 </th>
              </tr>
            </thead>
            <tbody>
				<c:if test="${empty pageBean.pageResult }">
					<tr>
					<td align="center" colspan="12">Sorry ! 暂无相应的数据...</td>
					</tr>
				</c:if>
              <c:forEach items="${pageBean.pageResult }" var="sanLing" varStatus="status">
				<tr>
					<td>${status.index + 1 }</td>
					<td>${sanLing.eventTime }</td>
					<td>${sanLing.sourceIp }</td>
					<td>${sanLing.sourcePort }</td>
					<td>${sanLing.destIp }</td>
					<td>${sanLing.destPort }</td>
					<td>${sanLing.eventType }</td>
					<td>${sanLing.protocolType }</td>
					<td>${sanLing.threatenRank }</td>
					<td> <div class="tdcut" title="${sanLing.descrip }">${sanLing.descrip }</div></td>
					<td>${sanLing.facilityIp }</td>
					<td>${sanLing.domain.domainName }</td>
				</tr>
			</c:forEach>
            </tbody>
          </table>
      </div>
	</logic:equal>
	
	<logic:equal name="showFlag" value="addToTempSuccess">
		<table width="655" height="501" border="0" cellpadding="0"
			cellspacing="2" bgcolor="#99B1BD">
			<tr><td>222222222222222222222222222</td>
			</tr>
	  </table>
	</logic:equal>

	<ul id="page" onmouseover="javascript:senfe('senfe','#fff','#eee','#fdf4db','')">
        <li><a class="first" href="javascript:showAddDivBox('snmpTrapDivSourceAction.do?method=snmpTrapDeviceForward&pageNo=1','snmpTrapDisplay')"></a></li>

		<c:if test="${pageBean.pageNo-1 >= 1}">
        	<li><a class="pre" href="javascript:showAddDivBox('snmpTrapDivSourceAction.do?method=snmpTrapDeviceForward&pageNo=${pageBean.pageNo-1 }','snmpTrapDisplay')"></a></li>
		</c:if>
		<c:if test="${pageBean.pageNo-1 == 0}">
        	<li><a class="pre" href="javascript:showAddDivBox('snmpTrapDivSourceAction.do?method=snmpTrapDeviceForward&pageNo=1','snmpTrapDisplay')"></a></li>
		</c:if>

		<c:if test="${pageBean.pageNo+1 < pageBean.pageMaxSum}">
        	<li><a class="next" href="javascript:showAddDivBox('snmpTrapDivSourceAction.do?method=snmpTrapDeviceForward&pageNo=${pageBean.pageNo+1 }','snmpTrapDisplay')"></a></li>
		</c:if>
		<c:if test="${pageBean.pageNo+1 >= pageBean.pageMaxSum}">
        	<li><a class="next" href="javascript:showAddDivBox('snmpTrapDivSourceAction.do?method=snmpTrapDeviceForward&pageNo=${pageBean.pageMaxSum }','snmpTrapDisplay')"></a></li>
		</c:if>

			<li><a class="last" href="javascript:showAddDivBox('snmpTrapDivSourceAction.do?method=snmpTrapDeviceForward&pageNo=${pageBean.pageMaxSum }','snmpTrapDisplay')"></a></li>
        <li>共 ${pageBean.pageMaxSum } 页 跳至
          <input type="text" size="2" class="input" name="mark"/>
          &nbsp; </li>
        <li><a class="R6" href="javascript:goDivPage('${pageBean.pageMaxSum }','snmpTrapDivSourceAction.do?method=snmpTrapDeviceForward','snmpTrapDisplay');">GO</a></li>
	</ul>
	<br />
      <br />
      <br />
</logic:present>