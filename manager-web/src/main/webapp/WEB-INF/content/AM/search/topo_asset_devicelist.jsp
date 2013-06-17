<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${basePath }/js/prototype-1.6.0.3.js"></script>
<script type="text/javascript">
	function doSubmit(id) {
		if (id != "")
			location.href = "assetTopoAssociate.do?method=saveOrUpdateDevice"
					+ "&deviceId=" + id +"&curpage=${page.currentPage }";

	}
	function del(id) {
		if(confirm("确定删除关系？")){
			if (id != "")
				location.href = "assetTopoAssociate.do?method=deleteByTopoId"
						+ "&topoId=" + id +"&curpage=${page.currentPage }";
		}

	}

	function forwardDialog(value) {
		returnValue = showModalDialog("assetTopoAssociate.do?method=openDialog"
				+ "&topoId=" + value + "&Rnd=" + Math.random(), window,
				'status:no;resizable:yes;dialogHeight:500px;dialogWidth:1000px;unadorne:yes');

		var ids = returnValue.split(",");
		location.href = "assetTopoAssociate.do?method=saveDialog"
				+ "&deviceId=" + ids[0] + "&topoId=" + ids[1]+"&curpage=${page.currentPage }";
	}
	 
    function gopage(curPage) {  
        location.href = "assetTopoAssociate.do?method=findNotInAssetDevices&curpage=" + curPage; 
    } 
</script>
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	 
	<tr>
		<td colspan="2">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="2">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="3%"></td>
				<td width="1%"><img src="images/tubiao/05375363.gif" /></td>
				<td width="70%" class="css4"><font size="2">关联拓扑设备</font></td>
			</tr>

		</table>
		</td>
	</tr>
	<tr>
		<td width="38">&nbsp;</td>
		<td>
		<table width="85%" border="0" cellpadding="0" cellspacing="0"
			class="bian">
			<tr>
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="1"
					class="biaoge">
					<tr>
						<td width="30%" background="images/a-028.gif" class="css2">操作</td> 
						<td width="25%" background="images/a-028.gif" class="css2">拓扑设备</td>
						<td width="50%" background="images/a-028.gif" class="css2">资产信息</td>
					</tr>
					<logic:present name="deviceList">
						<logic:iterate id="d" name="deviceList">
							<tr>
								<td>
								<input type="button" class="an-1" value="新增关系"
                                    <c:if test="${d.exist eq true }"> disabled="disabled"</c:if>
                                    onclick="doSubmit('${d.topoDeviceId}')" /> 
                                <input type="button"
                                    class="an-1" onclick="forwardDialog('${d.topoDeviceId}')"
                                    <c:if test="${d.exist != 'true' }"> disabled="disabled"</c:if>
                                    value="更新关系" />
                                 <input type="button" class="an-1" onclick="del('${d.topoDeviceId}')"
                                    <c:if test="${d.exist != 'true' }"> disabled="disabled"</c:if>
                                    value="删除关系" />
								
								</td>
								<td>${d.name }</td>
								<td>
								<logic:equal name="d" property="exist" value="true">
                                    <logic:present name="d" property="deviceBO">
                                        <c:if test="${empty d.deviceBO.locationId}">
                                   		      未分配
                                        </c:if>
                                        <c:forEach items="${managerbo}" var="m">
                                        <c:choose>
                                            <c:when test="${d.deviceBO.locationId eq m.id}">
                                              ${m.managerName}  
                                            </c:when> 
                                          </c:choose> 
                                        </c:forEach>
                                       	 /
                                      	<c:if test="${d.deviceBO.assetType == '1'}">
                                                                                                                       网络设备
                                        </c:if>
                                        <c:if test="${d.deviceBO.assetType == '2'}">
                                                                                                                      安全设备
                                            </c:if>
                                        <c:if test="${d.deviceBO.assetType == '3'}">
                                                                                                                      服务器
                                            </c:if>
                                        <c:if test="${d.deviceBO.assetType == '4'}">
                                                                                                                       桌面主机
                                        </c:if>
                                            /${d.deviceBO.name }
                                    </logic:present>
                                </logic:equal>
                                </td>
							</tr>
						</logic:iterate>
					</logic:present>
				</table>
				</td>
			</tr>
			<tr><td>  
                        <div align="center"><logic:present name="page">
                            <logic:equal name="page" property="currentPage" value="1">
                           首页
                           </logic:equal>
                            <logic:greaterThan name="page" property="currentPage" value="1">
                                <a href="javascript:gopage('1')">首页</a> 
                        </logic:greaterThan>
                            <c:if test="${page.hasPrePage==true}">
                                <a href="javascript:gopage(${page.currentPage-1 })">上一页</a>
                            </c:if>
                            <c:if test="${page.hasPrePage==false}">
                                                                                     上一页
                  </c:if>
                            <c:if test="${page.hasNextPage==true}">
                                <a href="javascript:gopage('${page.currentPage+1}')"> 下一页</a>
                            </c:if>
                            <c:if test="${page.hasNextPage==false}">
                                                                           下一页
                  </c:if>
                            <logic:lessThan name="page" property="currentPage"
                                value="${page.totalPage}">
                                <a href="javascript:gopage(${page.totalPage })">末页</a>
                            </logic:lessThan>
                            <logic:equal name="page" property="currentPage"
                                value="${page.totalPage}">
                                  末页
                            </logic:equal>  
                        共${page.totalCount}条记录,当前第<span id="cupId">${page.currentPage
                            }</span>页,共${page.totalPage
                        }页,转到第 <select id="pageid"
                                onchange="javascript:gopage(value)">
                                <c:forEach var="i" begin="1" end="${page.totalPage}">
                                    <c:choose>
                                        <c:when test="${page.currentPage == i}">
                                            <option value="${i }" selected="selected">${i}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${i }">${i}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select> 页</logic:present></div>
                        </td>
                    </tr> 
		</table>
		</td>
	</tr>
    <tr>
        <td colspan="2">&nbsp;</td>
    </tr>
    <tr>
        <td colspan="2">&nbsp;</td>
    </tr>
</table>
</body>
</html>