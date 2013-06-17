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
<script type="text/javascript">
function sendAlert() {
    window.location.href="${ctx}/ismp/domain/local/ram/reportManager.do?method=sendAlert";
}
</script>
</head>
<body>
<h2>总体报告</h2>
<form action="${ctx}/ismp/domain/local/ram/reportManager.do?method=saveQuesandSugg" method="post">
	<p>&nbsp;&nbsp;&nbsp;&nbsp;本次评估共发现（${TotalRiskNum} ）个风险，其中高级别风险（${HighRiskNum}）个，中级别风险（${MiddRiskNum}）个，低级别风险（${LowRiskNum}）个。具体的风险分布见风险评估分析报告。</p>
	<h2 class="martop8">存在的问题</h2>
	<textarea name="totalAsse" id="totalAsse" cols="60" rows="8">${dynaAsseValue.totalAsse }</textarea>
	<h2 class="martop8">安全建议</h2>
	<textarea name="expertSuggest" id="expertSuggest" cols="60" rows="8">${dynaAsseValue.expertSuggest }</textarea>
	<p class="martop10"><input class="submit" type="submit"  value="保存" /><!--<input class="submit80" type="submit"  value="发送告警"  onclick="sendAlert()"/>  --></p>
</form>
</body>
</html>
