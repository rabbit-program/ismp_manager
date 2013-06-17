<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<title>index</title>
</head>
<body>
 <br /><h2>评估对象 : <b>${asseInfoProj.asseComp}</b></h2> <br />
<h2 class="martop8">评估时间 : <b><fmt:formatDate value="${asseInfoProj.asseBeginTime }" pattern="yyyy-MM-dd HH:mm"  />至<fmt:formatDate value="${asseInfoProj.asseEndTime }" pattern="yyyy-MM-dd HH:mm"  /></b></h2>
 <br /><h2 class="martop8">评估人员 : <b>${asseInfoProj.assePers }</b></h2>
 <br /><h2 class="martop8">评估方式 : <b>
                    <c:choose>
                         <c:when test="${asseInfoProj.cpKind == 'cp1' }">
                                                                    调查问卷
                         </c:when>
                         <c:when test="${asseInfoProj.cpKind == 'cp2' }">
                                                                     扫描
                         </c:when>
                         <c:when test="${asseInfoProj.cpKind == 'cp3' }">
                                                                    扫描+调查问卷
                         </c:when>
                    </c:choose>
</b></h2>
 <br /><h2 class="martop8">评估类型 : <b>
                    <c:forEach items="${dicCpKindList }" var="dicCpKind">
                        <c:choose>
                         <c:when test="${dicCpKind.cpKindId eq asseInfoProj.cpKind }">
                           <c:set var="cpKindSelect" value="${dicCpKind.cpKindName }" />
                         </c:when>
                        </c:choose>
                      </c:forEach>
                      ${cpKindSelect }
</b></h2>
 <br /><h2 class="martop8">评估目标 : </h2>
<div class="greenborder pad3">
&nbsp;&nbsp;&nbsp;&nbsp;为了充分了解${asseInfoProj.domain.domainName }专用网络信息系统的当前安全状况（安全
                                             隐患），因此需要对${asseInfoProj.domain.domainName }的信息专用网络系统中的重要资产进行一次抽样扫描和安全弱点分析， <br />识别${asseInfoProj.domain.domainName }信息系统的风险点。最终，
                                            根据安全风险分析报告，作为提高${asseInfoProj.domain.domainName }信息专用网络系统整体安全
                                            的重要的参考依据之一。
                <br />
</div>
 <br /><h2 class="martop8">评估对象网络拓扑</h2>
<form action="${ctx }/ismp/domain/local/ram/reportManager.do?method=saveWebTopoInfo" method="post">
	<textarea name="webTopoInfo" id="webTopoInfo"  cols="60" rows="8">${dynaAsseValue.webTopoInfo }</textarea>
	<p class="martop10"><input class="submit" type="submit" name="测试" value="保存" /></p>
</form>
</body>
</html>
