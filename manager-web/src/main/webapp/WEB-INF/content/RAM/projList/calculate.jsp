<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> 风险计算</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript">
function toPage(curpage) {
    document.getElementById("currPage").value = curpage;
    window.location.href="${ctx}/ismp/domain/local/ram/CalManager.do?method=showListByTag&currPage="+curpage;
}

function nextStep() {
    window.location.href="${ctx}/ismp/domain/local/ram/reportManager.do?method=preReport";
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
          <td><img src="${ctx}/img/RAM/danger_banner_07.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_08.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_09.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_10.gif" /></td>
          <td><img src="${ctx}/img/RAM/daner_bannera_11.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_12.gif" /></td>
        </tr>
      </table>
    </div>
    <h2> 风险计算 </h2>
    <div id="data">           
        <table width="100%">
          <tr>
            <td><P><b>项目名称</b>:${asseInfoProj.projName }</P>
<P><b>测评开始时间</b>:<fmt:formatDate value="${asseInfoProj.asseBeginTime}" pattern="yyyy-MM-dd HH:mm"  /></P>
<P><b>测评结束时间</b>:<fmt:formatDate value="${asseInfoProj.asseEndTime}" pattern="yyyy-MM-dd HH:mm"  /></P></td>
            <td width="900"><img src="${graphURL }" width="700" height="350" border="0" usemap="#${filename }" /></td>
          </tr>
        </table>         
      <h2 class="martop8">资产列表</h2>
      <div class="pad1 greenborder">
        <table id="senfe" width="100%">
          <tr>
            <th>IP地址</th>
            <th>信息</th>
            <th>高风险点</th>
            <th>中风险点</th>
            <th>低风险点</th>
          </tr>
    <c:forEach items="${calcList }" var="cal" >
          <tr>
           <td>${cal.asse.ip }</td>
            <td>${cal.asse.assetName }</td>
            <td>${cal.vulnHighNum }</td>
            <td>${cal.vulnMiduNum }</td>
            <td>${cal.vulnLowNum }</td>
          </tr>
     </c:forEach>
        </table>
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
        <br /><br /><br />
        <h2> 建议 </h2>
        <form action="${ctx}/ismp/domain/local/ram/CalManager.do?method=saveExpertSuggest" method="post">
		<div  id="data" class="pad1 ">
		<table>
		  <tr>
		    <th> 安全级别 </th>
		    <td>
                 <select size="1" id="secuLeve" name="secuLeve">
                     <option value="">-请选择-</option>
                     <c:forEach items="${dicSecuLeveList }" var="dicSecuLeve">
                        <c:choose>
                         <c:when test="${dicSecuLeve.secuLeveId == secuLeve }">
                           <c:set var="secuLeveSelect" value="selected"></c:set>
                         </c:when>
                         <c:otherwise>
                           <c:set var="secuLeveSelect" value=""></c:set>
                         </c:otherwise>
                        </c:choose>
                     <option value="${dicSecuLeve.secuLeveId}"  ${secuLeveSelect } >
                        ${dicSecuLeve.secuLeveName }
                     </option>
                    </c:forEach>
                 </select>
            </td>
		  </tr>
		  <tr>
		    <th> 建议描述 </th>
		    <td><textarea name="expertSuggest" id="expertSuggest" cols="100" rows="10">${dynaAsseValue.expertSuggest }</textarea></td>
		  </tr>
		  <tr>
		    <td height="35" colspan="4"><input name="提交" type="submit" class="submit" value="保存" /></td>
		  </tr>
		  </table>
		</div>
    </form>

    </div>
    <c:if test="${!empty calcList}">
    <div style="margin:0 auto; padding-top:12px; width:120px; height:30px; clear:both;"><a href="javascript:nextStep();" class="R6">下一步</a></div>
    </c:if>
  </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
