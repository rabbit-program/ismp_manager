<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type='text/javascript' src='${ctx }/dwr/util.js'></script>
<script type='text/javascript' src='${ctx }/dwr/engine.js'></script>
<script type='text/javascript' src='${ctx }/dwr/interface/UserDwrValidate.js'> </script>
<script type="text/javascript">	
	var use=false;
	var pd= false;
	var iseq=false;
	function checkUserName(){
		var username = document.getElementById("user.username").value;
		if(username==''){
			use=false;
			 document.getElementById("nameMes").innerHTML="× 用户名不能为空!";
			 document.getElementById("nameMes").className="zc2";
			 return false; 
		}else if(username!=''){
			UserDwrValidate.checkUserName(username,function(data){
				if(data){
					user=false;
		            document.getElementById("nameMes").innerHTML="× 用户名不存在!";          
		            document.getElementById("nameMes").className="zc2";
		            return false;
					}else{
						use=true;
					    document.getElementById("nameMes").innerHTML="√ ";
					    document.getElementById("nameMes").className="zc1";
					    return true;
					}
				});
			}
	}

	
	function checkPasswd(){
		var password2 = document.getElementById("user.password2").value;
		if(password2==''){
			 pd=false;
			 document.getElementById("passwdMes").innerHTML="× 密码必须在6-12位之间!";
			 document.getElementById("passwdMes").className="zc2";
			 return false; 
		}else{
			pd=true;
		    document.getElementById("passwdMes").innerHTML="√ ";
		    document.getElementById("passwdMes").className="zc1";
		    return true;
		}
	}
	
	function checkRePasswd(){
		var password2 = document.getElementById("user.password2").value;
		var repasswd = document.getElementById("repasswd").value;
		if(repasswd!=password2){
				iseq=false;
				document.getElementById("repasswdMes").innerHTML="× 两次输入密码不同!";
				document.getElementById("repasswdMes").className="zc2";
				return false;
			}else{
				iseq=true;
				document.getElementById("repasswdMes").innerHTML="√ ";
			    document.getElementById("repasswdMes").className="zc1";
			    return true;
			}
	}

	function checkForm(){
		checkUserName();
		checkPasswd();
		checkRePasswd();
		if(use==true&&pd==true&&iseq==true){
			document.forms("resetform").submit();
		}else{
			alert('请根据出错提示填写正确信息!');
			return false;
		}
	}
</script>

<body >
<div id="contant" >
 
    <form action="${ctx }/ismp/domain/local/userConfig.do" method="post" name="resetform"  id="resetform">
    <input type="hidden" name="method" value="updateResetPass"/>
    <input type="hidden" name="resetPas" value="1"/>
    <div class="greenborder pad3 overf">
    <h2 class="martop10">密码重置</h2>
    
     <div id="data" class="overf pad1 ">
    <table>
	 <tr>
      <th>用户名</th>
      <td>
        <input name="user.username" id="user.username" value="" onBlur="checkUserName();"/>
      <span class="alert" id="nameMes">*</span></td>
     </tr>   
  
    <tr>
      <th>新密码</th>
      <td><input size="12" type="password" onBlur="checkPasswd();" name="user.password2" value="" 
       id="user.password2" />
      <span class="alert" id="passwdMes">*</span></td>
    </tr>
    <tr>
      <th>确认新密码</th>
      <td>
      <input size="12" name="repasswd" type="password" id="repasswd" onBlur="checkRePasswd();" value=""/>
      <span class="alert" id="repasswdMes">*</span></td>
    </tr>
  </table>
      </div>
  </div>
  		<div class="paddiv">This is for verticl spacing</div>
		<a href="#" class="R6" onclick="checkForm();">保存</a>
		<a href="#" class="R6" onclick="javascript:history.go(-1);">返回</a>
		<a href="#" class="R6" onclick="javascript:document.forms[0].reset();">重置</a>
		<div class="paddiv">This is for verticl spacing</div>
</form>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
