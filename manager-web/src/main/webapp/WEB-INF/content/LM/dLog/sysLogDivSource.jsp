<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<logic:present name="showFlag">

	<logic:equal name="showFlag" value="HillStoneFireWall_0.0">
		<h2 class="martop10">Syslog列表</h2>
      <div id="data" class="greenborder overf pad1" >
          <table id="senfe" sortcol="-1">
            <thead>
              <tr>
                <th style="cursor:pointer" onclick="sortTable('senfe',0);"> 序号 <span class="webdings">↓ </span></th>
                <th> 时间</th>
                <th> 设备名 </th>
                <th> 设备IP </th>
				<th> 消息类型 </th>
				<th> 源IP </th>
				<th> 源端口 </th>
				<th> 目标IP </th>
				<th> 目标端口 </th>
				<th> 协议类型 </th>
				<th> 消息内容 </th>
				<th> 部门 </th>
				<th> 严重性 </th>
				<th> 产生模块 </th>
              </tr>
            </thead>
            <tbody>
				<c:if test="${empty pageBean.pageResult }">
					<tr>
					<td align="center" colspan="14">Sorry ! 暂无相应的数据...</td>
					</tr>
				</c:if>
              <c:forEach items="${pageBean.pageResult }" var="hillStone" varStatus="status">
				<tr>
					<td>${status.index + 1 }</td>
					<td>${hillStone.timestamp }</td>
					<td>${hillStone.hostname }</td>
					<td>${hillStone.ipaddr }</td>
					<td>${hillStone.messageType }</td>
					<td>${hillStone.srcip }</td>
					<td>${hillStone.srcport }</td>
					<td>${hillStone.dstip }</td>
					<td>${hillStone.dstport }</td>
					<td>${hillStone.protocol }</td>
					<td> <div class="tdcut" title="${hillStone.msg }">${hillStone.msg }</div></td>
					<td>${hillStone.domain.domainName }</td>
					<td>${hillStone.severity.severityDescribe }</td>
					<td>${hillStone.facility.facilityDescribe }</td>
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
        <li><a class="first" href="javascript:showAddDivBox('sysLogDivSourceAction.do?method=sysLogDeviceForward&pageNo=1','sysLogDisplay')"></a></li>

		<c:if test="${pageBean.pageNo-1 >= 1}">
        	<li><a class="pre" href="javascript:showAddDivBox('sysLogDivSourceAction.do?method=sysLogDeviceForward&pageNo=${pageBean.pageNo-1 }','sysLogDisplay')"></a></li>
		</c:if>
		<c:if test="${pageBean.pageNo-1 == 0}">
        	<li><a class="pre" href="javascript:showAddDivBox('sysLogDivSourceAction.do?method=sysLogDeviceForward&pageNo=1','sysLogDisplay')"></a></li>
		</c:if>

		<c:if test="${pageBean.pageNo+1 < pageBean.pageMaxSum}">
        	<li><a class="next" href="javascript:showAddDivBox('sysLogDivSourceAction.do?method=sysLogDeviceForward&pageNo=${pageBean.pageNo+1 }','sysLogDisplay')"></a></li>
		</c:if>
		<c:if test="${pageBean.pageNo+1 >= pageBean.pageMaxSum}">
        	<li><a class="next" href="javascript:showAddDivBox('sysLogDivSourceAction.do?method=sysLogDeviceForward&pageNo=${pageBean.pageMaxSum }','sysLogDisplay')"></a></li>
		</c:if>

			<li><a class="last" href="javascript:showAddDivBox('sysLogDivSourceAction.do?method=sysLogDeviceForward&pageNo=${pageBean.pageMaxSum }','sysLogDisplay')"></a></li>
        <li>共 ${pageBean.pageMaxSum } 页 跳至
          <input type="text" size="2" class="input" name="mark"/>
          &nbsp; </li>
        <li><a class="R6" href="javascript:goDivPage('${pageBean.pageMaxSum }','sysLogDivSourceAction.do?method=sysLogDeviceForward','sysLogDisplay');">GO</a></li>
	</ul>
	<br />
	<br />
	<br />
</logic:present>