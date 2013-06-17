<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<html>
	<head>
		<link href="/css/css.css" rel="stylesheet" type="text/css" />
		<title>病毒管理_客户端管理_客户端名称修改</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>
	<body>
		<form action="${ctx}/ismp/domain/local/vpm/vm/virusMappingModify.do" method="post">
            <input id="mok" name="mok" type="hidden" value="1">
            <input id="virusClientId" name="virusClientId" type="hidden" value="${virusClients.id }">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			  <tr>
			    <td width="5" height="3"><img src="/images/a-020.gif" width="5" height="3" /></td>
			    <td height="3" background="/images/a-021.gif"></td>
			    <td width="5" height="3"><img src="/images/a-022.gif" width="5" height="3" /></td>
			  </tr>
			  <tr>
			    <td background="/images/a-023.gif">&nbsp;</td>
			    <td bgcolor="f9f9fb">
	                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="css1">
			          <tr align="center">
			              <td colspan="4">
	                        <font size="2">
	                            <p class="STYLE2"><br/>客户端名称更新</p>
	                        </font>
			                <hr size="5" />
	                      </td>
			          </tr>
				      <tr align="left">
				        <td width="35%" align="right">客户端名称&nbsp;：</td>
				        <td width="33%" align="left">&nbsp;&nbsp;
				         <input id="virusClientName" name="virusClientName" type="text" value="${virusClients.name }" width="290px"/>
				        </td>
				      </tr>
				      <tr align="center">
				        <td>&nbsp;</td>
				        <td>&nbsp;</td>
				        <td>&nbsp;</td>
				        <td>&nbsp;</td>
				      </tr>
				      <tr align="center">
				        <td ><br><br><br><br><br><br><br><br></td>
				        <td>
				            <input name="button" type="submit" class="an-2" id="button" value="保 存"/> 
				            <input name="button3" type="button" class="an-2" id="button3" value="关 闭" onclick="window.close();"/>
				        </td>
				     </tr>
			        </table>
	            </td>
			    <td background="/images/a-023.gif">&nbsp;</td>
			  </tr>
			  <tr>
			    <td><img src="/images/a-025.gif" width="4" height="3" /></td>
			    <td background="/images/a-026.gif"></td>
			    <td><img src="/images/a-027.gif" width="4" height="3" /></td>
			  </tr>
			</table>
		</form>
	</body>
</html>