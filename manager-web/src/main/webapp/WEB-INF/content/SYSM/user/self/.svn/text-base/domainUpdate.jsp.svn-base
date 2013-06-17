<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<script type="text/javascript">
	var dep=false;
	var des=false;
   
    function  chekcDepartment(){
        var department=document.getElementById("managerName").value;
        if(department==''){
            dep=false;
            document.getElementById("nameMes").innerHTML="× 部门不能为空!";
            document.getElementById("nameMes").className="zc2"; 
            return false;
        }else{
            dep=true;
            document.getElementById("nameMes").innerHTML="√ ";
            document.getElementById("nameMes").className="zc1";
            return true;
        }
    }
    function checkDescription(){
		var description = document.getElementById("depict").value;
		if(description==''){
			des=false;
			document.getElementById("descriptMes").innerHTML="× 部门不能为空!";
			document.getElementById("descriptMes").className="zc2";
			return false;
		}else{
			des=true;
			document.getElementById("descriptMes").innerHTML="√ ";
			document.getElementById("descriptMes").className="zc1";
			return false;
		}
    }
   
    function checkForm(){ 
    	chekcDepartment();
    	checkDescription();
        if(dep==true&&des==true){
            document.forms["updateSubmit"].submit();
        }else{
            alert('请根据出错提示填写正确信息!');
        }
    }
</script>
<html:form action="/ismp/domain/local/userConfig.do" styleId="updateSubmit">
    <input type="hidden" name="method" value="updateManager"/>
    <input type="hidden" value="${domainVO.id }" name="mid" />
    <input type="hidden" name="curpage" value="${curpage }"/>
<div  id="data" class="pad1 ">
<h2>部门更新 "<span class="alert">*</span>"为必填项</h2>
  <table>
	 <tr>
      <th>上级部门</th>
      <td>
       <select name="pid" id="pid">
		<option value="-1">----顶级部门----</option>
		<logic:notEmpty name="domainList">
		<logic:iterate id="domain" name="domainList">
		<option value="${domain.id }" <c:if test="${domainVO.parentDomain.id eq domain.id }">selected="selected"</c:if> >${domain.domainName}</option>
		</logic:iterate>
		</logic:notEmpty> 
	    </select>
      <span class="alert" id="prenameMes">*</span></td>
     </tr>   
  
    <tr>
      <th>部门名称</th>
      <td><input size="12" type="text" onBlur="chekcDepartment();" name="managerName" value="${domainVO.domainName }" 
       id="managerName" />
      <span class="alert" id="nameMes">*</span></td>
    </tr>
    <tr>
      <th>部门描述</th>
      <td>
      <!-- 
      <input size="12" name="description" type="text" id="description" onBlur="checkMobile();" 
      value="${user.mobile}"/>
       -->
      <textarea name="depict" rows="4" cols="20" id="depict" onBlur="checkDescription();">${domainVO.description }</textarea>
      <span class="alert" id="descriptMes">*</span></td>
    </tr>
  </table>
  <div class="paddiv">This is for verticl spacing</div>
<a href="#" class="R6" onclick="checkForm();">保存</a>
<a href="#" class="R6" onclick="javascript:history.go(-1);">返回</a>
<a href="#" class="R6" onclick="javascript:document.forms[0].reset();">重置</a>
<div class="paddiv">This is for verticl spacing</div>
</div>
</html:form>