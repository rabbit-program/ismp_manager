<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
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
      function checkIp(){
    	  var ip = /^([1-9]|[1-9]\d|1\d{2}|2[0-1]\d|22[0-3])(\.(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])){3}$/;
          var ipadd = document       
                  .getElementById("ip").value;             
          if (ipadd!=''&&ip.test(ipadd) == false) {
              alert('Ip地址格式不正确(如:192.168.255.255)');
              return false;
          }  
          return true;       
        } 

      function onReset()
      {
         var inputs =  $("device").getInputs("text");
         for(var i=0; i < inputs.size(); i++)
              inputs[i].value = " ";
      }
      
</script>

</head>
<body>

<div class="contant">
     <div class="overf h20 martop10">
     <ul>
      	<li id="m"><a  class="mbacka" href='device_.do' target='mainchiltFrame'><span class="menus10">设备查询</span></a></li>
      	<li><a  class="mback" href='soft_.do' target='mainchiltFrame'><span class="menus11"> 软件查询</span></a></li>
      	<li><a  class="mback" href='hard_.do' target='mainchiltFrame'><span class="menus12">硬件查询</span></a></li>
       	<li><a  class="mback" href='pos_.do' target='mainchiltFrame'><span class="menus07">物理位置查询</span></a></li>
       </ul>
    </div>
     <div class="greenborder pad3 overf">
   	 <h2 class="martop10">请选择查询条件</h2>
    	<div class="greenborder greenback overf pad3 Height_a" >
    	<form id="device" action="search.do?method=searchDevice" method="post">
			<span style="float:left;">
			<input type="hidden" name="curpage" id="curpage" value="${page.currentPage }"/>
			设备名称<input type="text" name="device.name" value="${device.name}" />
     		 设备编号<input type="text" name="device.sn" value="${device.sn }" />
     		 IP地址<input type="text" name="device.ip" value="${device.ip }" />
     		 Mac地址<input type="text" name="device.mac" 	value="${device.mac }" />
     		 使用人 <input type="text" name="device.user"	value="${device.user }" />
     		 </span><span style="float:left;">单位
     		 <input type="text" name="device.unit" size="8" class="input" value="${device.unit }"/>
     		 </span> 
     		  <input name="button3" type="submit" class="submit" id="button3" value="查 询" />
     		  <input type="reset" class="submit"  value="重 置" />
     	</form>
		</div>
		
		
		  <h2 class="martop8">统计列表</h2>
          <div id="data"><table>
            <tr>
              <th>设备名称</th>
              <th>设备编号</th>
              <th>IP 地 址</th>
              <th>Mac 地 址</th>
              <th>使用人</th>
              <th>单 位</th>
              <th>操作</th>
            </tr>
              <tbody>
                <c:choose>	
                			<c:when test="${deviceList != null}">
								<c:forEach items="${deviceList}" var="device">
									<tr>
										<td>${device.name }</td>
										<td>${device.sn }</td>
										<td>${device.ip }</td>
										<td>${device.mac }</td>
										<td>${device.user }</td>
										<td>${device.unit }</td>
										<td>
										<a class="R6 R7" href="search.do?method=doFrame&id=${device.id }&url=search.do?method=viewDevice">设备详细信息</a>
										<sec:authorize ifAllGranted='ROLE_AdminAll'>
										 <a class="R6" href="javascript:del('${device.id }')">删除</a>
										</sec:authorize>
										</td>
									</tr>
								</c:forEach>
							</c:when>
				</c:choose>
				<logic:empty name="deviceList">
							<tr>
								<td align="center" class="border  minheight" colspan="6"><span class="alert">没有数据显示</span></td>
							</tr>
				</logic:empty>
              </tbody>
            </table>
		<ul id="page">
	        <li><a class="first" href="javaScript:topage('1')"></a></li>
	        <li>
	        <c:if test="${page.hasPrePage==true}">
				<a class="pre" href="javaScript:topage('${page.currentPage-1}')"></a>
			</c:if>
			</li>
	        <li>
	        <c:if test="${page.hasNextPage==true}">
				<a class="next" href="javaScript:topage('${page.currentPage+1 }')"></a>
			</c:if>
			</li>
	        <li><a class="last"	href="javaScript:topage('${page.totalPage }')"></a></li>
	        <li>共${page.totalPage }页 跳至
	          <jsp:include page="/WEB-INF/content/AM/comm/pageInfo.jsp"></jsp:include></li>
     	</ul>
	</div>
  </div>
</div>


<script type="text/javascript">
	
	function fwd(curpage) { 
		var curPage=document.getElementById("mid").value; 
		document.forms[0].action = "search.do?method=searchDevice&curpage=" + curPage;
		document.forms[0].submit();
	} 
	function topage(curpage) {  
		document.forms[0].action = "search.do?method=searchDevice&curpage=" + curpage;
		document.forms[0].submit();
	} 
    function del(id){
        if(window.confirm("你确定要删除吗?")){ 
            var curpage = document.getElementById("curpage").value; 
        	document.forms[0].action="search.do?method=deleteDevice&id="+id+"&curpage="+curpage;
        	document.forms[0].submit();
         }
    }
</script>
<script type="text/javascript">
	parent.topFrame.location.reload();
</script>
 <script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</body>
</html>
