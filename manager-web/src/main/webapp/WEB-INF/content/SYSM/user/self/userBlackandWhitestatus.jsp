<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/meta.jsp" %>
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
<script type="text/javascript">
		function checkform(){
			var temp = document.getElementsByName("bwstatus");
			var Checked=false;
		      for (i=0;i<temp.length;i++){
		        if(temp[i].checked)
		        {
		           Checked=true;
		           break;
		        }
		        else
		        {
		            Checked=false;
		        }
		      }
					
			
			if(Checked==false){
					alert("请选择状态!");
					return;
				}else{
					document.forms[0].submit();	
				}
		}
</script>
</head>
<body >
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" >
	<jsp:include page="/WEB-INF/content/SYSM/user/top.jsp"></jsp:include>
  </div>
  <div class="contant">
    <div class="overf h20 martop10">
  	<jsp:include page="/WEB-INF/content/SYSM/user/self/usertop.jsp"></jsp:include>
   </div>
    </div>
    <div class="greenborder pad3 overf">
      <h2 class="martop10">黑白名单状态管理</h2>
      <div id="data" class="greenborder overf pad1 martop10" >
        <form name="f1" id="f1" action="userConfig.do" method="post">
        	<input type="hidden" name="method" value="saveOrUpdateBlackandWhiteStatus">
    		<input type="hidden" name="blsid" value="${blackandwhitestatusbo.id }">
          <table id="senfe" sortcol="-1">
            <tr>
              <th>黑名单</th>
              <td> 
              	<c:if test="${blackandwhitestatusbo.status==0}"><span class="greentxt">√已启用</span></c:if>
              	<c:if test="${blackandwhitestatusbo.status!=0}"><span class="redtext">×未启用</span></c:if>
               </td>
            </tr>
            <tr>
              <th>白名单</th>
              <td>
              	<c:if test="${blackandwhitestatusbo.status==1}"><span class="greentxt">√已启用</span></c:if>
              	<c:if test="${blackandwhitestatusbo.status!=1}"><span class="redtext">×未启用</span></c:if>
              </td>
            </tr>
            <tr>
              <th>操  作</th>
              <td><p>
                <label >
                  <input type="radio" name="bwstatus" value="0" <c:if test="${blackandwhitestatusbo.status eq 0 }">checked="checked"</c:if> style="border:none;"/>
                  黑</label>                
                <label>
                  <input type="radio" name="bwstatus" value="1" <c:if test="${blackandwhitestatusbo.status eq 1 }">checked="checked"</c:if> style="border:none;"/>
                  白</label>
                <label>
                  <input type="radio" name="bwstatus" value="2" <c:if test="${blackandwhitestatusbo.status eq 2 }">checked="checked"</c:if> style="border:none;"/>
                  禁用</label>
              </p>
               </td>
            </tr>
          </table>
          
        </form>
      </div>
      <br />
          <a href="javascript:checkform();" class="R6">保存</a><a href="javascript:history.go(-1)" class="R6">返回</a>
         <br /><br /><br />
    </div>
  </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
