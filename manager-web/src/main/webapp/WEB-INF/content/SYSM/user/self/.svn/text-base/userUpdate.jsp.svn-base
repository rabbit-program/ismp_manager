<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript">
var ph=false;
    var mob=false;
    var jb=false;
    var dep=false;
    var sooh=false;
    var em=false;
    var us=false;
    var roles=false;

    function checkRoles() {
		var a = document.getElementsByName("roleid");
		var n = a.length;
		var k = 0;
		for ( var i = 0; i < n; i++) {
			if (a[i].checked) {
				k = 1;
			}
		}
		if (k == 0) {
			alert("没有分配角色");
			roles=false;
			return false;
		}
		roles=true;
		return true;
	}
    function checkuname(){            
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
            document.getElementById("usernameMes").innerHTML="√";
            document.getElementById("usernameMes").className="zc1";  
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
             document.getElementById("jobMes").innerHTML="× 职位太长!";
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
         var soothname=document.getElementById("user.soothname").value;
         if(soothname==''||soothname.length<5){
             sooh=false;
             document.getElementById("sootnameMes").innerHTML="× 用户名最少5位!";
             document.getElementById("sootnameMes").className="zc2"; 
             return false;
         }else{
             sooh=true;
             document.getElementById("sootnameMes").innerHTML="√ ";
             document.getElementById("sootnameMes").className="zc1";
             return true;
         }
    }   
    function checkForm(){ 
        checkMobile();
        checkEmail();
        checkPhone();
        checkSoothname();
        checkuname();
        checkJob();
        checkRoles();
        if(ph==true&&mob==true&&sooh==true&&em==true&&us==true&&roles==true){
            document.forms["updateSubmit"].submit();
        }else{
            alert('请根据出错提示填写正确信息!');
        }
    }
</script>
</head>
<html:form action="/ismp/domain/local/userConfig.do" styleId="updateSubmit">
    <input type="hidden" name="method" value="updateUser"/>
    <input type="hidden" value="${search }" name="search"/>
    <input type="hidden" value="${user.id }" name="userupdatevo.id"/>
    <input type="hidden" value="${curpage } " name="curpage"/>
<div  id="data" class="pad1 ">
<h2>用户资料更新 "<span class="alert">*</span>"为必填项</h2>
  <table>
    <tr>
      <th>用户名</th>
      <td>
      <input size="12" type="text" onBlur="checkSoothname();" value="${user.loginName }" name="userupdatevo.loginName" id="user.soothname"  readonly="readonly"  style="background: #cccccc"/>
      <span class="alert" id="sootnameMes">*</span>
     </td>
      <th>真实姓名</th>
      <td>
       <input size="12" type="text" onBlur="checkuname()" name="userupdatevo.username" value="${user.username}" id="user.username"/>
       <span class="alert" id="usernameMes">*</span>
       </td>
    </tr>
    <tr>
      <th>手机</th>
      <td><input size="12" name="userupdatevo.mobile" type="text" id="user.mobile" onBlur="checkMobile();" 
      value="${user.mobile}"/><span class="alert" id="mobileMes">*</span></td>
      <th>邮箱</th>
      <td><input size="12" name="userupdatevo.email" type="text"  id="user.email" onBlur="checkEmail();"
      value="${user.email }"/><span class="alert" id="emailMes">*</span></td>
    </tr>
    <tr>
      <th>电话</th>
      <td><input size="12" name="userupdatevo.phone" type="text" id="user.phone" onBlur="checkPhone();"
	  value="${user.phone }"/><span class="alert" id="phoneMes">*</span></td>
	  <th>职位</th>
      <td><input size="12" name="userupdatevo.job" type="text"  id="user.job" onBlur="checkJob();"
      value="${user.job }"/><span class="alert" id="jobMes">*</span></td>
    </tr>
    <tr>
      <th>角色</th>
      <td colspan="3"><logic:notEmpty name="rolelist">
     	 <logic:iterate id="rl" indexId="s" name="rolelist">
     	 			<c:set value="0" var="flag"></c:set>
					<logic:iterate id="rol" name="rlist" indexId="i">
						<c:if test="${rol.role==rl.role}">
							<c:set value="1" var="flag"></c:set>
							<input type="checkbox" name="roleid" value="${rl.id }" checked="checked">${rl.name}&nbsp;
						</c:if>
					</logic:iterate>
					<c:if test="${flag==0}">
					<input type="checkbox" name="roleid" value="${rl.id }">${rl.name}&nbsp;
					</c:if>
		</logic:iterate>
		</logic:notEmpty>
		<span class="alert" id="roleMes">*</span></td>
    </tr>
  </table>
  <div class="paddiv">This is for verticl spacing</div>
<a href="#" class="R6" onclick="checkForm();">保存</a>
<div class="paddiv">This is for verticl spacing</div>
</div>
</html:form>
