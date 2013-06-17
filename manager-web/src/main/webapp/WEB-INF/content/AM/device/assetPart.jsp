<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>资产详细信息</title> 
</head>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<body> 
<div  id="data" class="pad1 ">
<table width="100%" height="312" border="0" align="center"
	cellpadding="0" cellspacing="0" class="bian">
	<tr>
		<td width="100%">
		<table>
			<tr>
				<th>
				资产编号：
				</th>
				<td width="33%">${assetBo.sn }</td>
				<th>
				资产名称：
				</th>
				<td>${assetBo.name }</td>
			</tr>
			<tr>
				<th>
				资产类型：
				</th>
				<td><c:if test="${assetBo.assetType!=null}">
					<c:if test="${assetBo.assetType=='1'}"> 网络设备 </c:if>
					<c:if test="${assetBo.assetType=='2'}"> 安全设备 </c:if>
					<c:if test="${assetBo.assetType=='3'}"> 服务器 </c:if>
					<c:if test="${assetBo.assetType=='4'}"> 桌面主机 </c:if>
				</c:if></td>
				<th>
				优 先 级：
				</th>
				<td>${assetBo.priority } （最高等级：5 最低等级：1）</td>
			</tr>
			<tr>
				<th >
				厂 商：
				</th>
				<td>
				${assetBo.manufacturer}
				<!-- <logic:notEmpty name="tmList">
                     <logic:iterate id="al" name="tmList">
                        <c:if test="${assetBo.manufacturer==al.enName}"> ${al.markName} </c:if>
                    </logic:iterate>
                </logic:notEmpty> -->
                  
                 </td>
				<th>
				设备型号：
				</th>
				<td width="39%"> 
				                 ${assetBo.model}
                                    <!-- <logic:notEmpty name="models">
                                    <logic:iterate id="al" name="models">
                                      <c:if test="${al.name eq assetBo.model }">${al.name}</c:if>
                                    </logic:iterate>
                                    </logic:notEmpty> -->
                  </td>
			</tr>
			<tr>
				<th>
				IP 地 址：
				</th>
				<td>${ assetBo.ip}</td>
				<th>
				Mac 地址：
				</th>
				<td>${assetBo.mac}</td>
			</tr>
			<tr>
				<th>
				使 用 人：
				</th>
				<td>${ assetBo.user}</td>
				<th>
				电 话：
				</th>
				<td>${ assetBo.telephone}</td>
			</tr>
			<tr>
				<th>
				单 位 ：
				</th>
				<td>${ assetBo.unit}</td>
				<th>
				部 门：
				</th>
				<td>${assetBo.department }</td>
			</tr>
			<tr>
				<th>
				资产状态：
				</th>
				<td><c:choose>
					<c:when test="${assetBo.status == 1}">
						在用
					</c:when>
					<c:when test="${assetBo.status == 2}"> 
						废弃
					</c:when> 
				</c:choose></td>
				<th>
				采购时间：
				</th>
				<td><bean:write name="assetBo"  property="stockTime" format="yyyy-MM-dd HH:mm" /></td>
			</tr>
			<tr>
				<th>
				有 效 期：
				</th>
				<td>${assetBo.validityPeriod }月</td>
				<th>
				登记时间：
				</th>
				<td><bean:write name="assetBo"  property="registrationTime" format="yyyy-MM-dd HH:mm" /></td>
			</tr>
			<!-- <tr>
				<th>
				数据采集代理：
				</th>
				<td><logic:notEmpty name="agentList" scope="session">
					<logic:iterate id="al" name="agentList" scope="session">
						<c:if test="${assetBo.agentIp==al.ipAddr}"> ${al.ipAddr} </c:if>
						<c:if test="${assetBo.agentIp!=al.ipAddr}"> ${al.name} </c:if>
					</logic:iterate>
				</logic:notEmpty></td>
				<th>
				团体名：
				</th>
				<td>${assetBo.communityName }</td>
			</tr> -->
			<tr>
				<th>
				是否监控设备：
				</th>
				<td>&nbsp; <c:if test="${assetBo.checkAvailable==true}"> 是 </c:if>
				<c:if test="${assetBo.checkAvailable==false}"> 否 </c:if></td>
				<th>
				设备类型：
				</th>
				<td><c:choose>
				<c:when test="${assetBo.deviceType=='switch'}">交换机</c:when>
				<c:when test="${assetBo.deviceType=='server'}">服务器</c:when>
				<c:when test="${assetBo.deviceType=='firewall'}">防火墙</c:when>
				<c:when test="${assetBo.deviceType=='router'}">路由器</c:when>
				<c:when test="${assetBo.deviceType=='pc'}">PC</c:when>
				<c:when test="${assetBo.deviceType=='ids'}">IDS</c:when>
			    <c:otherwise>${assetBo.deviceType}</c:otherwise>
				</c:choose> </td>
			</tr>
			<tr>
				<th>
				所属机构：
				</th>
				<td><logic:notEmpty name="managerbo" scope="session">
                                    <logic:iterate id="m" name="managerbo" scope="session">
                                          <c:choose>
                                            <c:when test="${assetBo.locationId eq m.id}">
                                              ${m.domainName} 
                                            </c:when>
                                            <c:when test="${empty assetBo.locationId}">
                                             <c:set value="true" var="novalue"></c:set>
                                            </c:when>
                                          </c:choose> 
                                        
                                    </logic:iterate>  
                                        
                                </logic:notEmpty>
                                         <c:if test="${novalue == true}">
                                            未指派
                                         </c:if></td>
				<th>
				资产描述：
				</th>
				<td>${assetBo.description }</td>
			</tr>
			<tr>
				<td height="46" colspan="4"><input type="button" class="subbtn"
					value="设备详细信息报表"
					onclick="javascript:location.href='DeviceDetailsInfo.do?deviceId=${aid}'" />
					<div align="center"><input class="submit" type="button" onclick="javascript:history.back(-1);" value="返回" name="Submit3"></div>
					</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</div>
</body>
</html>