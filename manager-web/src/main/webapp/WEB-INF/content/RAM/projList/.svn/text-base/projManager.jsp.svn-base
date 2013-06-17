<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Mainframe</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/floatdiv.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/date/WdatePicker.js"></script>
<script type="text/javascript">
function buildNew(){
  window.location.href="${ctx}/ismp/domain/local/ram/projManager.do?method=preBuildNewProject&again=y";
}
function toPage(curpage) {
    document.getElementById("currPage").value = curpage;
    document.projShow.action="${ctx}/ismp/domain/local/ram/projManager.do?method=showProject&isAll=${isAll}&currPage="+curpage;
    projShow.submit(); 
}
            
function clean(){
    document.forms[0].offcPers.value=-1;
    document.forms[0].assePers.value="";
    document.forms[0].secuLeve.value="";
    document.forms[0].asseBeginTime.value="";
    document.forms[0].asseEndTime.value="";
}  
</script>
</head>
<body>
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" >    
    <li class="act" id="m"><a href="#"><span style="background:url(${ctx}/img/comm/other/01.gif) no-repeat; padding-left:22px;">风险评估</span></a></li>
  </div>
  <div class="contant">   
    <div class="pad3 overf">
    <form name="projShow" id="projShow" action="${ctx}/ismp/domain/local/ram/projManager.do?method=showProject&isAll=${isAll}" method="post">
    <h2 class="martop10">请选择查询条件</h2>
    <div class="greenborder greenback overf pad3 Height_a" >
      <span style="float:left;">部门名称
	   <select id="offcPers" name="offcPers">
          <option value="-1">-请选择-</option>
	   <c:forEach items="${udl}" var="ud">
	      <option value="${ud.id}" <c:if test="${ud.id == offcPers}">selected='selected'</c:if>>${ud.domainName}</option>
	   </c:forEach>
       <sec:authorize ifAllGranted='ROLE_AdminAll'>
          <c:choose>
            <c:when test="${selectid == -2}">
             <option value="-2" selected="selected">未知域</option>
            </c:when>
            <c:otherwise>
              <option value="-2" >未知域</option>
            </c:otherwise>
           </c:choose>
       </sec:authorize>
	   </select>
		 测评人 <input type="text" name="assePers" id="assePers" value="${assePers }"/>
		安全级别称<select id="secuLeve" name="secuLeve">
                   <option value="">-请选择-</option>
		          <c:forEach items="${secuLeve}" var="sec">
		          <option value="${sec.secuLeveId}" <c:if test="${sec.secuLeveId == secuLeve1}">selected='selected'</c:if>>${sec.secuLeveName}</option>
		          </c:forEach>
                 </select>
		创建时间(起始)<input type="text" name="asseBeginTime" id="asseBeginTime" value="${asseBeginTime}"  class="Wdate" onclick="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" readonly="readonly"/>
		创建时间(最末)<input type="text" name="asseEndTime" id="asseEndTime" value="${asseEndTime}"  class="Wdate" onclick="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" readonly="readonly"/>
        </span><span style="float:left;"><a href="#" class="R6" style="margin-left:12px;" onclick="javascript:toPage(1);">搜索</a>
		<a href="#" class="R6" style="margin-left:12px;" onclick="clean()">重置</a></span>
    </div>
      <h2 class="martop10">查看列表</h2>
      <div id="data" class="greenborder overf pad1" >
          <table id="senfe" sortcol="-1">
            <thead>
              <tr>
                <th style="cursor:pointer" onclick="sortTable('senfe',0);"> 项目编号 <span class="webdings">6</span></th>
                <th> 评估对象 </th>
                <th> 测评人 </th>
				<th> 所属部门 </th>
                <th> 测评时间 </th>
                <th>安全级别</th>
                <th>测评状态</th>
              </tr>
            </thead>
            <tbody>
             <c:forEach items="${projList }" var="proj" varStatus="i" step="1">
              <tr>
                <td>
                   <html:link action="/ismp/domain/local/ram/projManager.do?method=contAsse&projId=${proj.id }&asseStatus=${proj.asseStatus}&progress=${proj.progress}">
                   ${proj.id }
                  </html:link>
                </td>
                <td title="${proj.asseComp}">${fn:substring(proj.asseComp,0,6) }.</td>
                <td title="${proj.assePers }">${fn:substring(proj.assePers,0,6) }.</td>
				<td title="${proj.domain.domainName }">${fn:substring(proj.domain.domainName,0,6) }.</td>
                <td> <fmt:formatDate value="${proj.asseBeginTime }" pattern="yyyy-MM-dd HH:mm"  />~
                     <c:choose>
                        <c:when test="${!empty proj.asseEndTime}">
                            <fmt:formatDate value="${proj.asseEndTime }" pattern="yyyy-MM-dd HH:mm"  />
                        </c:when>
                        <c:otherwise>
                                                                           未知
                        </c:otherwise>
                     </c:choose>
                </td>
                <td><c:if test="${!empty proj.secuLeve}">
                        <c:forEach items="${secuLeve }" var="secuLeve">
                          <c:if test="${secuLeve.secuLeveId==proj.secuLeve }">
                            <c:set var="secuLeveName" value="${secuLeve.secuLeveName }" />
                          </c:if>
                        </c:forEach>${secuLeveName }&nbsp;
                    </c:if>
                </td>
                <td><c:if test="${!empty proj.asseStatus}">
                      <c:forEach items="${dicAsseStatList }" var="asseStat">
                       <c:if test="${asseStat.asseStatId==proj.asseStatus }">
                         <c:set var="asseStatName" value="${asseStat.asseStatName }" />
                       </c:if>
                      </c:forEach>${asseStatName}&nbsp;
                     </c:if>
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </form>
      </div>
      <div class="Heightlist">     
      <ul id="page">
      <li style="margin-right:12px;"><a class="R6 R7" href="javascript:buildNew();">新建评测项目</a></li>
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
  </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
