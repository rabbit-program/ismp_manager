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
    var ipadd=false;
    var dep=false;

    function checkIp(){            
        var ipaddress=document.getElementById("blackandwhitebo.ipaddress").value;
        if(ipaddress==''){
            ipadd=false;
            document.getElementById("ipaddressMes").innerHTML="× Ip地址不能为空!";
            document.getElementById("ipaddressMes").className="zc2"; 
        }else{
            var  ip=/^([1-9]|[1-9]\d|1\d{2}|2[0-1]\d|22[0-3])(\.(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])){3}$/;
            if(ipaddress!=''&&ip.test(ipaddress)==false){
                document.getElementById("ipaddressMes").innerHTML="× Ip地址格式不正确!";
                document.getElementById("ipaddressMes").className="zc2";
                ipadd=false;
            }else{
                document.getElementById("ipaddressMes").innerHTML="√";
                document.getElementById("ipaddressMes").className="zc1";
                ipadd=true;
            }
            
        }  
          
    }
    function checkDepict(){            
        var username=document.getElementById("blackandwhitebo.depict").value;
        if(username==''){
            dep=false;
            document.getElementById("depictMes").innerHTML="× 描述不能为空!";
            document.getElementById("depictMes").className="zc2"; 
            return false;
        }else if(username.length>200){
        	dep=false;
            document.getElementById("depictMes").innerHTML="× 描述长度太长!";
            document.getElementById("depictMes").className="zc2"; 
            dep=false;
        }else{
            document.getElementById("depictMes").innerHTML="√";
            document.getElementById("depictMes").className="zc1"; 
            dep=true;
        }  
          
    }
    function checkForm(){
        checkIp();
        checkDepict();
        if(ipadd==true&&dep==true){
            document.forms[0].submit();
        }else{
            alert('请根据出错提示填写正确信息!');
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
      <h2 class="martop10">增加黑白名单  "<span class="alert">*</span>"为必填项</h2>
      <div id="data" class="greenborder overf pad1 martop10" >
        <form name="f1" id="f1" action="userConfig.do?method=saveBlackandWhite" method="post">
          <table id="senfe" sortcol="-1">
            <tr>
              <th>类型</th>
              <td><select name="blackandwhitebo.marker">
              <!-- <option value="2">全部</option> -->
       			  
         			<option value="0">黑名单</option>
         			<option value="1">白名单</option>
	       	</select><span class="alert">*</span></td>
            </tr>
            <tr>
              <th>角色</th>
              <td><select name="blackandwhitebo.role">
		<option value="-1">----全部----</option>
		<logic:notEmpty name="rolesSearchList">
		<logic:iterate id="rolelist" name="rolesSearchList">
		<option value="${rolelist.id }">${rolelist.name}</option>
		</logic:iterate>
		</logic:notEmpty> 
	 	</select></td>
            </tr>
            <tr>
              <th>域</th>
              <td><select name="blackandwhitebo.domain">
				<option value="-1">----全部----</option>
				<logic:notEmpty name="domainList">
				<logic:iterate id="domain" name="domainList">
				<option value="${domain.id }">${domain.domainName}</option>
				</logic:iterate>
				</logic:notEmpty> 
	    </select></td>
            </tr>
            <tr>
              <th> IP地址</th>
              <td><input size="16" name="blackandwhitebo.ipaddress" id="blackandwhitebo.ipaddress"  onblur="checkIp();" /><span class="alert">*</span> <span class="zc2" id="ipaddressMes"></span> </td>
            </tr>
            <tr>
              <th> 描述 </th>
              <td><textarea cols="24" rows="4" name="blackandwhitebo.depict" id="blackandwhitebo.depict"  onblur="checkDepict();"></textarea><span class="alert">*</span>
              <span class="zc2" id="depictMes"></span>
               </td>
            </tr>
          </table>
          
        </form>
      </div>
      <br />
          <a href="javascript:checkForm();" class="R6">保存</a><a href="javascript:history.go(-1);" class="R6">返回</a><a href="javascript:document.forms[0].reset();" class="R6">重置</a>
         <br /><br /><br />
    </div>
  </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
