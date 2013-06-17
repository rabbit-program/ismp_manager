<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/common/taglibs.jsp"%>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/floatdiv.js"></script>
<script type="text/javascript" language="javascript" src="${ctx }/js/comm/date/WdatePicker.js"></script>
<script type="text/javascript">
	function FirstPage(curpage) {
		document.getElementById("curpage").value = curpage;
		document.forms[0].submit();
	}
	function upPage(curpage) {
		document.getElementById("curpage").value = curpage;
		document.forms[0].submit();
	}
	function nextPage(curpage) {
		document.getElementById("curpage").value = curpage;
		document.forms[0].submit();
	}
	function endPage(curpage) {
		document.getElementById("curpage").value = curpage;
		document.forms[0].submit();
	}
	function fwd(curpage) {
		document.getElementById("curpage").value = document
				.getElementById("mid").value;
		document.forms[0].submit();
	}
	function MM_openBrWindow(theURL,winName,features) {
		window.open(encodeURI(theURL),winName,features);
	}
</script>
</head>
<body>
<div id="contant" class="mainbg">
  <div class="contant">
  <form action="alertRule.do">
	<input type="hidden" value="getPageAlertRuleDisuse" name="method"> 
	<input type="hidden" name="disuse" value="0">
	<input type="hidden" name="curpage" id="curpage">
  </form>
  <h2 class="martop10">废弃规则列表</h2>
      <div id="data" class="greenborder overf pad1" >
        <form name="f1" id="f1" action="" method="post">
          <table id="senfe" sortcol="-1">
            <thead>
            <tr>
            <th style="cursor:pointer" onclick="sortTable('senfe',0);">ID <span class="webdings">6</span></th>
            <th>
			<div align="center">优先级条件</div>
			</th>
			<th>
			<div align="center">类型条件</div>
			</th>
			<th>
			<div align="center">桌面消息告警</div>
			</th>
			<th>
			<div align="center">Email消息告警</div>
			</th>
			<th>
			<div align="center">短消息告警</div>
			</th>
			<th>
			<div align="center">子类型条件</div>
			</th>
			<th>
			<div align="center">状态</div>
			</th>
              </tr>
            </thead>
            <tbody>
             <logic:iterate id="l" name="list" indexId="index">
				<tr >
				<td width="6%">
				<div align="center">
				<!-- <a href="javaScript:openAlertRuleDetail('alertRule.do?method=getByIdAlertRule&alertRuleId=${l.id }')" title="查看详细内容">${l.id }</a> -->
				
				<a href="#" class="R6" onclick="MM_openBrWindow('${ctx}/ismp/domain/local/aim/alertRule.do?method=getByIdAlertRule&alertRuleId=${l.id }','告警规则详情','scrollbars=yes,width=600,height=500');" title="查看详细内容">${l.id }</a>
				</div>
				</td>
				<td>
				<div align="center">${l.priority }</div>
				</td>
				<td>
				<div align="center">${l.type }</div>
				</td>
				<td>
				<div align="center"><c:if test="${l.sendMsg==1}">
                                                 是
                   </c:if> <c:if test="${l.sendMsg==0}">
                                                                         否
                   </c:if></div>
				</td>
				<td>
				<div align="center"><c:if test="${ l.sendEmail==1}">是</c:if> <c:if
					test="${ l.sendEmail==0}">否</c:if></div>
				</td>
				<td>
				<div align="center"><c:if test="${ l.sendSms==1}">是</c:if> <c:if
					test="${ l.sendSms==0}">否</c:if></div>
				</td>
				<td>
				<div align="center">${l.subType }</div>
				</td>
				<td>
				<div align="center"><c:if test="${l.deprecated==1}">
                                                                                                                             正常
                                    </c:if> <c:if test="${l.deprecated==0}">
                                                                                                                           已废弃
                                    </c:if></div>
				</td>

				</tr>
			</logic:iterate>
            </tbody>
          </table>
        </form>
      </div>
    <ul id="page">
    <li><a class="first" href="javaScript:FirstPage('1')"></a></li>
	<li><c:if test="${page.hasPrePage==true}"><a class="pre" href="javaScript:upPage('${page.currentPage-1}')"></a></c:if></li>
	<li><c:if test="${page.hasNextPage==true}"><a class="next" href="javaScript:nextPage('${page.currentPage+1 }')"></a></c:if></li>
	<li><a class="last"	href="javaScript:endPage('${page.totalPage }')"></a></li>
	<li>共${page.totalPage } 页 跳至<jsp:include	page="/WEB-INF/content/SYSM/user/other/pageInfo.jsp"></jsp:include></li>
    </ul><br />
      <br />
      <br />
  </div>
  </div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
