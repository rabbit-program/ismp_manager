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
<script type='text/javascript' src='${ctx }/dwr/util.js'></script>
<script type='text/javascript' src='${ctx }/dwr/engine.js'></script>
<script type='text/javascript' src='${ctx }/dwr/interface/UserDwrValidate.js'> </script>
<script type="text/javascript">
    var us=false;
    var pwd=false;
    var pwd1=false;
    var ph=false;
    var mob=false;
    var jb=false;
    var dep=false;
    var sooh=false;
    var em=false;
    function checkuname(){            
         var soothname=document.getElementById("user.loginName").value;
         if(soothname==''|| soothname.length<5){
        	 sooh=false;
             document.getElementById("sootnameMes").innerHTML="× 用户名最少五位!";
             document.getElementById("sootnameMes").className="zc2";  
             return false;  
         }else{
             var username = document.getElementById("user.loginName").value;
        	 return UserDwrValidate.checkUserName(username,backName);
        	// sooh=true;
            // document.getElementById("sootnameMes").innerHTML="√";
            // document.getElementById("sootnameMes").className="zc1";
            // return true;  
         }
     }
	function backName(data){
		if(data==false){
			sooh=false;
            document.getElementById("sootnameMes").innerHTML="× 用户名已经存在!";          
            document.getElementById("sootnameMes").className="zc2";
            return false;
       }else{
    	   sooh=true;
            document.getElementById("sootnameMes").innerHTML="√";          
            document.getElementById("sootnameMes").className="zc1";
            return true;
       }
	}
    
    function  checkJob(){
        var department=document.getElementById("user.job").value;
        if(department==''){
            jb=false;
            document.getElementById("jobMes").innerHTML="× 职位不能为空!";
            document.getElementById("jobMes").className="zc2"; 
            return false;
        }else{
            jb=true;
            document.getElementById("jobMes").innerHTML="√";
            document.getElementById("jobMes").className="zc1";
            return true;
        }
    }
     function checkPassword(){   
        var s=document.getElementById("user.password").value;
        //if(s.length < 6||s.length>12){ 
        if(eval(s.length) < 6 || eval(s.length)>12 ){
             pwd=false; 
             document.getElementById("pwdMes").innerHTML="× 密码必须在6-12位之间!";
             document.getElementById("pwdMes").className="zc2"; 
             return false;
         }   
         var ls = 0;  
         if(s.match(/([a-z])+/)){   
           ls++;           
         }            
         if(s.match(/([0-9])+/)){   
              ls++;     
         }             
         if(s.match(/([A-Z])+/)){          
                ls++;          
         }   
         if(s.match(/[^a-zA-Z0-9]+/)){     
              ls++;               
         }          
         if(ls<2){     
             pwd=false;      
             document.getElementById("pwdMes").innerHTML="× 密码必须字母数字或者字符任意两种组合!";
             document.getElementById("pwdMes").className="zc2";
             return false;                            
         }else{
             pwd=true;
             document.getElementById("pwdMes").innerHTML="√ ";
             document.getElementById("pwdMes").className="zc1";
             return true; 
         }
     } 
     function checkPassword1(){   
         var password1=document.getElementById("user.password1").value;
         var password=document.getElementById("user.password").value;
         if(password!=password1||password1==''){
             pwd1=false;             
             document.getElementById("pwdMes1").innerHTML="× 确认密码不一致!";          
             document.getElementById("pwdMes1").className="zc2";
             return false;
         }else{
             pwd1=true;
             document.getElementById("pwdMes1").innerHTML="√ ";
             document.getElementById("pwdMes1").className="zc1";
             return true; 
         }
      } 
     function checkMobile(){
         var mobile=document.getElementById("user.mobile").value;
         var reg0 = /^13\d{5,9}$/; 
         var reg1 = /^15\d{5,9}$/; 
         var reg2 = /^18\d{5,9}$/;          
         var my = false; 
         if (reg0.test(mobile))my=true; 
         if (reg1.test(mobile))my=true; 
         if (reg2.test(mobile))my=true;  
         if (!my||mobile.length!=11){ 
             mob=false;
             document.getElementById("mobileMes").innerHTML="× 手机号码格式不正确! ";
             document.getElementById("mobileMes").className="zc2";        
             return false;     
         } else{
             mob=true;
             document.getElementById("mobileMes").innerHTML="√ ";
             document.getElementById("mobileMes").className="zc1";
             return true; 
         }        
     }
     function checkEmail(){
         var email=document.getElementById("user.email").value;
         if (email.charAt(0) == "." || email.charAt(0) == "@" || email.indexOf('@', 0) == -1|| email.indexOf('.', 0) == -1 || email.lastIndexOf("@") == email.length-1 || email.lastIndexOf(".") == email.length-1){
             em=false;
             document.getElementById("emailMes").innerHTML="× Email格式不正确! ";
             document.getElementById("emailMes").className="zc2";
             return false;
         }            
        else{
             em=true;
             document.getElementById("emailMes").innerHTML="√ ";
             document.getElementById("emailMes").className="zc1";
             return true; 
         }          
     }
     function checkPhone(){
         var phone=document.getElementById("user.phone").value; 
         var p1 = /^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/; 
         if (!p1.test(phone)){ 
             ph=false;
             document.getElementById("phoneMes").innerHTML="× 电话号码格式不正确!";
             document.getElementById("phoneMes").className="zc2";      
             return false;    
         }else{
             ph=true;
             document.getElementById("phoneMes").innerHTML="√ ";
             document.getElementById("phoneMes").className="zc1";
             return true;
         } 
         
    }
    function  chekcDepartment(){
        var department=document.getElementById("user.department").value;
        if(department==''){
            dep=false;
            document.getElementById("departmentMes").innerHTML="× 部门不能为空!";
            document.getElementById("departmentMes").className="zc2"; 
            return false;
        }else if(department.length>50){
        	dep=false;
        	document.getElementById("departmentMes").innerHTML="× 部门太长!";
        	document.getElementById("departmentMes").className="zc2"; 
        	return false;
        }else{
            dep=true;
            document.getElementById("departmentMes").innerHTML="√ ";
            document.getElementById("departmentMes").className="zc1";
            return true;
        }
    }
    function  checkJob(){
        var department=document.getElementById("user.job").value;
        if(department==''){
            jb=false;
            document.getElementById("jobMes").innerHTML="× 职位不能为空!";
            document.getElementById("jobMes").className="zc2"; 
            return false;
        }else if(department.length>50){
        	jb=false;
        	document.getElementById("jobMes").innerHTML="× 部门太长!";
        	document.getElementById("jobMes").className="zc2"; 
        	return false;
        }else{
            jb=true;
            document.getElementById("jobMes").innerHTML="√";
            document.getElementById("jobMes").className="zc1";
            return true;
        }
    }
    function checkSoothname(){
         var username=document.getElementById("user.username").value;
         if(username==''){
             us=false;
             document.getElementById("usernameMes").innerHTML="× 姓名不能为空!";
             document.getElementById("usernameMes").className="zc2"; 
             return false;
         }else if(username.length>50){
        	us=false;
        	document.getElementById("usernameMes").innerHTML="× 姓名太长!";
        	document.getElementById("usernameMes").className="zc2"; 
        	return false;
        }else{
             us=true;
             document.getElementById("usernameMes").innerHTML="√ ";
             document.getElementById("usernameMes").className="zc1";
             return true;
         }
    }   
    function checkForm(){ 
        checkuname();
        checkPassword();
        checkPassword1();
        checkMobile();
        checkEmail();
        checkJob();
        checkPhone();
        checkSoothname();
        if(jb==true&&us==true&&pwd==true&&pwd1==true&&ph==true&&mob==true&&sooh==true&&em==true){
        	document.forms["f1"].submit();
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
      <h2 class="martop10">添加用户  "<span class="alert">*</span>"为必填项</h2>
      <div class="greenborder greenback overf pad3 Height_a" > 提示： 请认真填写下面信息,像Email,终端IP地址等联系方式可能被告警的发送设置引用. </div>
      <div id="data" class="greenborder overf pad1 martop10" >
        <form name="f1" id="f1" action="userConfig.do" method="post">
       	  <input type="hidden" name="method" value="saveUser"/>
          <table id="senfe" sortcol="-1">
            <tr>
              <th>用户名</th>
              <td><input size="12" name="user.loginName" id="user.loginName" onblur="checkuname();"/>
                <span class="alert" id="sootnameMes">*</span></td>
              <th>手机</th>
              <td><input size="12" name="user.mobile" type="text" id="user.mobile" onblur="checkMobile();"/>
                <span class="alert" id="mobileMes">*</span></td>
            </tr>
            <tr>
              <th> 密码</th>
              <td><input size="12" name="user.password" type="password" id="user.password" onblur="checkPassword();"/>
                <span class="alert" id="pwdMes">*</span></td>
              <th>确认密码</th>
              <td><input size="12" name="user.password2" type="password" id="user.password1" onblur="checkPassword1();"/>
                <span class="alert" id="pwdMes1">*</span></td>
            </tr>
            <tr>
              <th> 邮箱 </th>
              <td><input size="12" name="user.email" type="text" id="user.email" onblur="checkEmail();"/>
                <span class="alert" id="emailMes">*</span></td>
              <th> 电话</th>
              <td><input size="12" name="user.phone" type="text" id="user.phone" onblur="checkPhone();"/>
                <span class="alert" id="phoneMes">*</span></td>
            </tr>
            <tr>
              <th> 职位 </th>
              <td><input size="12" onblur="checkJob()" name="user.job" id="user.job"/>
                <span class="alert" id="jobMes">*</span></td>
              <th> 真实姓名</th>
              <td><input size="12" type="text" onblur="checkSoothname()" name="user.username" id="user.username" />
                <span class="alert" id="usernameMes">*</span></td>
            </tr>
          </table>
          
        </form>
      </div>
      <br />
          <a href="#" class="R6" onclick="checkForm();">保存</a><a href="#" class="R6" onclick="javascript:history.go(-1)">返回</a><a href="#" class="R6">重置</a>
         <br /><br /><br />
    </div>
  </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
