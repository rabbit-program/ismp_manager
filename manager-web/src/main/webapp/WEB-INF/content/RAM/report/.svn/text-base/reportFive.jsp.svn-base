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
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript">

function viewLeak(leakId){
     secondWindow = open("${ctx}/ismp/domain/local/ram/reportManager.do?method=look&leakId="+leakId,"detail","height=350,width=700,scrollbars=yes");
}

function viewVuln(vulnId){
    secondWindow = open("${ctx}/ismp/domain/local/ram/reportManager.do?method=look&vulnId="+vulnId,"detail","height=350,width=700,scrollbars=yes");
}
</script>
<title>index</title>
</head>
<body>
<div id="data">
<table width="100%">
  <tr>
    <td width="700"><center><br /><img src="${graphURL }" width="700" height="350" border="0" usemap="#${filename }" /><br /><br/><img src="${graphURL1 }" width="700" height="350" border="0" usemap="#${filename1 }" /></center></td>
  </tr>
</table>
<h2 class="martop10">${asseInfoProj.domain.domainName }各资产的漏洞列表 </h2>
<table width="100%">
  <tr>
    <th> 资产名称 </th>
    <th> 漏洞名称 </th>
    <th> 漏洞严重性 </th>
    <th> 查看 </th>
  </tr>
 <c:forEach items="${dynaVulnList }" var="objectArray" >
  <tr>
    <td>${objectArray[0].asse.assetName }</td>
    <td><div class="tdcut"><a href="#vuln${objectArray[0].id }">
                     ${objectArray[1].describe }
                    </a></div></td>
    <td> <c:forEach items="${dicSecuLeveList }" var="secuLeve">
                      <c:if test="${secuLeve.secuLeveId==objectArray[0].seriLeve }">
                       <c:set var="secuLeveName" value="${secuLeve.secuLeveName }" />
                      </c:if>
                     </c:forEach>${secuLeveName }
                    </td>
    <td><a class="boxy" href="javascript:viewVuln('${objectArray[0].id}')" title="查看"><u>查看</u></a></td>
    </tr>
    </c:forEach>

     <c:forEach items="${dynaLeakList }" var="objectArray" >
           <tr>
            <td>${objectArray[0].asse.assetName }</td>
            <td><div class="tdcut">
            <a href="#leak${objectArray[0].id }"> 
            ${objectArray[0].location }
            </a></div>
            </td>
            <td>
             <c:forEach items="${dicSecuLeveList }" var="secuLeve">
              <c:if test="${secuLeve.secuLeveId==objectArray[0].seriLeve }">
               <c:set var="secuLeveName" value="${secuLeve.secuLeveName }" />
              </c:if>
             </c:forEach>${secuLeveName }
            </td>
            <td><a class="boxy" href="javascript:viewLeak('${objectArray[0].id}')" title="查看"><u>查看</u></a></td>
           </tr>
      </c:forEach>

</table>
</div>
</body>
</html>
