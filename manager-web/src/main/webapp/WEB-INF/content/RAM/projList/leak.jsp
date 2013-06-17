<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat,java.util.Date" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>漏洞扫描</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript">

function goIpPage() {
    var ip = document.getElementById("ip").value;
    window.location.href="${ctx}/ismp/domain/local/ram/leakScanManager.do?method=showLeakScan&ip="+ip;
}

function toPage(curpage) {
    var ip = document.getElementById("ip").value;
    document.getElementById("currPage").value = curpage;
    window.location.href="${ctx}/ismp/domain/local/ram/leakScanManager.do?method=showLeakScan&currPage="+curpage+"&ip="+ip;
}

function view(leakId){
    secondWindow = open("${ctx}/ismp/domain/local/ram/leakScanManager.do?method=look&leakId="+leakId,"detail","height=550,width=800,scrollbars=yes");
}

function nextStep() {
    var asseInfoProjId = document.getElementById("asseInfoProjId").value;
    window.location.href="${ctx}/ismp/domain/local/ram/leakScanManager.do?method=nextStep&asseInfoProjId="+asseInfoProjId;
}
</script>
</head>
<body >
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" >
    <li class="act" id="m"><a href="#"><span style="background:url(${ctx}/img/comm/other/01.gif) no-repeat; padding-left:22px;">风险评估</span></a></li>
  </div>
  <div class="contant pad3 overf">
    <div class="overf pad3  martop10" >
      <table width="100%">
        <tr>
          <td><img src="${ctx}/img/RAM/danger_banner_01.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_02.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_03.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_05.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_06.gif" /></td>
          <td><img src="${ctx}/img/RAM/daner_bannera_07.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_08.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_09.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_10.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_11.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_12.gif" /></td>
        </tr>
      </table>
    </div>
    <h2>漏洞扫描</h2>
    <div id="data">
      <div class="greenborder pad3 Height_a">
        <p>先用漏洞扫描器进行扫描，然后将扫描器生成的xml报表进行解析。</p>
      </div>
      <form action="${ctx}/ismp/domain/local/ram/leakScanManager.do?method=importDataByXmlFile" enctype="multipart/form-data" method="post">
      <p class="martop8">报告数据入库: 
    <input type="hidden" name="asseInfoProjId" id="asseInfoProjId" value="${asseInfoProj.id }" />
    <input name="inputXmlFile" type="file" id="inputXmlFile" name="inputXmlFile"/> <input type="submit" class="R6,R7" value="确认导入" /></p>
      </form> 
     <h2 class="martop8">扫描结果</h2>
     <div class="greenborder pad3 Height_a">
        <p>IP地址选择：
           <select name="ip" id="ip" onchange="goIpPage()">
                   <option >-请选择-</option>
                     <c:forEach items="${ipList }" var="ip">
                        <c:choose>
                         <c:when test="${ip == ipAddress }">
                           <c:set var="ipSelect" value="selected"></c:set>
                         </c:when>
                         <c:otherwise>
                           <c:set var="ipSelect" value=""></c:set>
                         </c:otherwise>
                        </c:choose>
                     <option value="${ip}"  ${ipSelect } >
                        ${ip }
                     </option>
                    </c:forEach>
                 </select>
        </p>
      </div>
      <div class="pad1 greenborder">
        <table id="senfe" width="100%">
          <tr>
            <th>IP地址</th>
            <th>漏洞名称</th>
            <th>威胁描述</th>
            <th>建议措施</th>
            <th>查看</th>
          </tr>
        <c:forEach items="${leakList }" var="leak" >
          <tr>
            <td>${leak.ip }</td>
            <td>${fn:substring(leak.location,0,16) }...</td>
            <td><div class="tdcut">${fn:substring(leak.describe,0,16) }...</div></td>
            <td><div class="tdcut"> 
                    <c:if test="${!empty leak.solution}">
                     ${fn:substring(leak.solution,0,16) }...
                    </c:if></div></td>
            <td><a href="javascript:view('${leak.id}')" title="查看" class="boxy"><u>查看</u></a></td>
          </tr>
        </c:forEach>
        </table>
      </div>
      <div class="Heightlist cl">     
      <ul id="page">
        <li><a class="first" href="javascript:toPage(1);"></a></li>
          <c:if test="${currPage>1 }">
              <li><a class="pre" href="javascript:toPage(${currPage-1 });"></a></li>
          </c:if>
          <c:if test="${currPage<totalPage }">
              <li><a class="next" href="javascript:toPage(${currPage+1 });"></a></li>
          </c:if>
          <li><a class="last" href="javascript:toPage(${totalPage });"></a></li>
          <li>
                                                      共 ${totalPage } 页 跳至
              <input id="currPage" name="currPage" type="text" size="2" class="input" value="${currPage }"/>
              &nbsp;
          </li>
          <li><a class="R6" href="javascript:toPage(document.getElementById('currPage').value);">GO</a></li>
      </ul>  
      </div>      
    </div>
    <div style="margin:0 auto; padding-top:12px; width:120px; height:30px; clear:both;"><a href="javascript:nextStep();" class="R6" >下一步</a></div>
  </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
