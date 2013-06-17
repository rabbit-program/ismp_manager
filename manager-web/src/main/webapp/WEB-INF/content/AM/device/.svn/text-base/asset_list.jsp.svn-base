<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" language="javascript" src="${ctx }/js/comm/date/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/floatdiv.js"></script>
<script type="text/javascript">
	function fwd(typid) {
		var curpage = document.getElementById("mid").value;
		var locid = document.getElementById("locid").value;
		var typeid = document.getElementById("typeid").value;
		location.href = "asset.do?method=findAssetByLoc&tid=" + typid+"&locid="+locid+"&typeid="+typeid
				+ "&curpage=" + curpage;
	}
	function fwdAdd(deviceType, locid) {
		location.href = "fwdPage.do?addAsset=1&deviceType=" + deviceType
				+ "&locid=" + locid;
	}
	function delLoc(id, tid, locid) {
		if (confirm("确认删除吗？")) { 
			location.href = "asset.do?method=deleteAsset&aid=" + id + "&tid="
					+ tid+"&locid=" + locid;
		} else {
			return;
		}
	}
	function del(id, tid) {
		if (confirm("确认删除吗？")) {
			location.href = "asset.do?method=delAsset&aid=" + id + "&tid="
					+ tid;
		} else {
			return;
		}
	}
	function checkFile(form1) {
		var fi = document.getElementById("fi").value;
		if (fi == '') {
			alert("请选择文件!");
			return false;
		}
		if (fi.indexOf(".xls") <= 0) {
			alert("文件格式不对,请重新选择!");
			return false;
		}
		return true;
	}

	function chooseAction(tid, curpage) {
		var locid = document.getElementById("locid").value;
		if (locid != "")
			location.href = "asset.do?method=findAssetByLoc&tid=" + tid
					+ "&curpage=" + curpage + "&locid=" + locid;
		else
			location.href = "asset.do?method=findAssetAll&tid=" + tid
					+ "&curpage=" + curpage;
	}
</script>
</head>
<body>
<input type="hidden" id="locid" value="${locid }" name="locid" />
<input type="hidden" id="typeid" value="${typid }" name="typeid" />
<div class="contant">

    <div id="data">
      <h2 class="martop8">资产列表</h2>
          <table>
            <tr>
              <th>名称</th>
              <th>厂商</th>
              <th>型号</th>
              <th>登记时间</th>
              <th>操作</th>
            </tr>
              <tbody>
              <logic:present name="listd">
			<logic:iterate id="s" name="listd">
                <tr>
                  <td>${s.name }</td>
                  <td>
					<!-- <logic:notEmpty name="tmList">
						<logic:iterate id="al" name="tmList">
							<c:if test="${s.manufacturer==al.enName}"> ${al.markName} </c:if>
						</logic:iterate>
					</logic:notEmpty> -->
					${s.manufacturer}
					</td>
                  <td>
					<!-- <logic:notEmpty name="models">
						<logic:iterate id="al" name="models">
							<c:if test="${al.name eq s.model }">${al.name}</c:if>
						</logic:iterate>
					</logic:notEmpty> -->
					${s.model }</td>
                  <td><bean:write property="registrationTime" name="s" format="yyyy-MM-dd" /></td>
                  <td> 	<a href="asset.do?method=getOneAsset&aid=${s.id }&part=1" class="R6 R7">详细信息</a> <!-- 如果有权限的情况下才给修改按钮 --> 
                  <!-- <a href="#" class="R6 R7" onclick="Boxy.load('asset.do?method=getOneAsset&aid=${s.id }&part=1');" >详细信息</a> -->
                 <sec:authorize ifAllGranted='ROLE_AdminAll'>
                 	<a class="R6 R7"  href="changelog.do?method=searchChangeLog&chid=${s.id }&locid=${locid }&typeid=${s.assetType }">变动信息</a>
                  	<a href="asset.do?method=getOneAsset&aid=${s.id }&locid=${locid }" class="R6">修改</a>
                 	<!-- <a href="#" class="R6"  onclick="Boxy.load('asset.do?method=getOneAsset&aid=${s.id }&locid=${locid }');">修改</a> -->
                 	<c:if test="${empty locid}">
						<a href="javaScript:del('${s.id }','${s.assetType }')" class="R6" >删除</a>
				  	</c:if>
				 	 <c:if test="${!empty locid}">
                        <a href="javaScript:delLoc('${s.id }','${s.assetType }','${locid }')" class="R6" >删除</a>
                 	 </c:if>
                 	 <c:if test="${s.monitorStatus eq 0}">
						<a class="R6 R7" 	href="asset.do?method=monitor&deviceId=${s.id}&locid=${locid }"	title="添加到拓扑面板">添加到拓扑</a>
					 </c:if>
                 </sec:authorize> 
                   </td>
                </tr>
                </logic:iterate>
		   </logic:present>
		   
		   <logic:empty name="listd">
			<tr>
				<td align="center" class="border  minheight" colspan="6"><span class="alert">没有数据显示</span></td>
			</tr>
			</logic:empty>
              </tbody>
            </table>
            
            
      <ul id="page">
        <li><a class="first" href="javaScript:fwd('1')"></a></li>
        <li>
        <c:if test="${page.hasPrePage==true}">
			<a class="pre" href="javaScript:fwd('${page.currentPage-1}')"></a>
		</c:if>
		</li>
        <li>
        <c:if test="${page.hasNextPage==true}">
			<a class="next" href="javaScript:fwd('${page.currentPage+1 }')"></a>
		</c:if>
		</li>
        <li><a class="last"	href="javaScript:fwd('${page.totalPage }')"></a></li>
        <li>共${page.totalPage }页 跳至
          <jsp:include page="/WEB-INF/content/AM/comm/pageInfo.jsp"></jsp:include></li>
          <sec:authorize ifAllGranted='ROLE_AdminAll'>
	       	<li style="margin-left:12px;">
	       	<!-- <a href="#" onclick="Boxy.load('${ctx}/ismp/domain/local/am/fwdPage.do?addAsset=1&deviceType=${deviceType}&locid=${locid}');" class="R6 R7 boxy" title="添加资产">添加资产</a> -->
	       	<a href="${ctx}/ismp/domain/local/am/fwdPage.do?addAsset=1&deviceType=${deviceType}&locid=${locid}" class="R6 R7 boxy" title="添加资产">添加资产</a>
	       	</li>
	        <li><a href="asset.do?method=doExcel&locid=${locid}&devTy=${deviceType }" class="R6 R7 boxy" title="Excel导入数据">Excel导入数据</a></li>
      	  </sec:authorize>
      </ul>
      <br />
      <br />
    </div>
  </div>
  <script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</body>
</html>
