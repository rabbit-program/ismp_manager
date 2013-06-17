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
<title>Excel上传</title>
<script type="text/javascript">
	function checkFile(){
		var filename = document.getElementById("fi").value;
		if(filename.length==0 || filename ==''){
			return false;
		}else {
			if(filename.indexOf(".xls") == -1 && filename.indexOf(".XLS") == -1){
			alert("上传文件类型错误");
			return false;
			}
		}   
	}
</script>
</head>
<body>
<div id="data" class="pad1 greenborder">
<table width="90%" border="0" cellspacing="0" cellpadding="0" 
	class="css4">
	 
		<tr>
			<td>
			<p style="color: red">数据填写规则：</p>
			</td>
		</tr>
		<tr>
			<td>
			<p style="color: red">
			&nbsp;&nbsp;&nbsp;&nbsp;每个excel单元格内的汉字不超过100个，IP地址填写格式：例192.168.9.100,设备mac地址填写格式：用冒号加以区分-例00:24:81:10:67:D6</p>
			</td>
		</tr>
		<tr>
			<td>
			<p style="color: red">资产状态：只能填写1（在线）或2（报废），采购时间/登记时间格式(yyyy-MM-dd)例：填写2009-10-10，优先级：1到5之间的数字，1最低5最高</p>
			</td>
		</tr>
		<tr>
			<td>
			<p style="color: red">是否可变动（true/false）只能填写true或false。有效期格式为：0到9数字，最大输入数位为6位。</p>
			</td>
		</tr>

		<tr>
			<td>
			<div align="left">
			<form action="asset.do?method=excelImport"
				enctype="multipart/form-data" method="post"
				onsubmit="return checkFile()"><input type="hidden"
				name="assettypeid" value="${deviceType }" />  <input type="hidden"
				name="locid" value="${locid}" />  <span>批量导入：</span> <input
				type="file" name="excelFile" size="25" id="fi" /> <input
				name="submit" type="submit" value="上传" class="an-1" onsubmit=checkFile();/> <a
				href="${ctx }/reports/AM/asset_device.xls" target="_blank" title="批量导入资产信息的模板">下载文件模版</a></form>
			</div>
			</td>
		</tr>
</table>
</div>
</body>
</html>