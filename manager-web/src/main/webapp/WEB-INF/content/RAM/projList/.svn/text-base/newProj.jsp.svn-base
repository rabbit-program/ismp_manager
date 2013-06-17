<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat,java.util.Date" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
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
function  trim(str){
    for(var i=0; i<str.length&&str.charAt(i)==" "; i++)  ;
    for(var j=str.length; j>0&&str.charAt(j-1)==" ";j--)  ;
    if(i>j) return "";  
    return  str.substring(i,j);  
} 
function validateAsseInfoProjForm(form){
	if (trim(document.getElementById("asseComp").value)== null
            || document.getElementById("asseComp").value == undefined
            || trim(document.getElementById("asseComp").value) == ""
            || document.getElementById("asseComp").value.length > 255) {
        alert("评估对象必填且不超过255个字符!");
        return false;
    }  else if (document.getElementById("cpKind").value == null
            || document.getElementById("cpKind").value == undefined
            || document.getElementById("cpKind").value == "") {
        alert("测评类型必选!");
        return false;
    } else if (trim(document.getElementById("projName").value )== null
            || document.getElementById("projName").value == undefined
            || trim(document.getElementById("projName").value) == ""
            || document.getElementById("projName").value.length > 255) {
        alert("测评项目名称必填且不超过255个字符!");
        return false;
    }else if (document.getElementById("offcPers").value== null
            || document.getElementById("offcPers").value == undefined
            || document.getElementById("offcPers").value == "") {
        alert("所属部门必选!");
        return false;
    } else if (trim(document.getElementById("assePers").value) == null
            || document.getElementById("assePers").value == undefined
            || trim(document.getElementById("assePers").value) == ""
            || document.getElementById("assePers").value.length > 255) {
        alert("测评人必填且不超过255个字符!");
        return false;
    } else if (trim(document.getElementById("lawPers").value) == null
            || document.getElementById("lawPers").value == undefined
            || trim(document.getElementById("lawPers").value )== ""
            || document.getElementById("lawPers").value.length > 255) {
        alert("法人必填且不超过255个字符!");
        return false;
    }else if (trim(document.getElementById("address").value) == null
            || document.getElementById("address").value == undefined
            || trim(document.getElementById("address").value) == ""
            || document.getElementById("address").value.length > 255) {
        alert("地址必填且不超过255个字符!");
        return false;
    } else if (trim(document.getElementById("linkway").value) == null
            || document.getElementById("linkway").value == undefined
            ||trim(document.getElementById("linkway").value) == ""
            || document.getElementById("linkway").value.length >11
            ||  /^\s*([1-9]\d*)?\s*$/.test(document.getElementById("linkway").value)==false) {
        alert("联系方式必须为数字且不能超过11个字符!");
        return false;
    } else if (trim(document.getElementById("zipcode").value) == null
            || document.getElementById("zipcode").value == undefined
            || trim(document.getElementById("zipcode").value) == ""
            || document.getElementById("zipcode").value.length > 6
            || /^\s*([1-9]\d*)?\s*$/.test(document.getElementById("zipcode").value)==false ) {
        alert("邮编必须为数字且不能超过6个字符!");
        return false;
    } else if (trim(document.getElementById("phone").value) == null
            || document.getElementById("phone").value == undefined
            || trim(document.getElementById("phone").value) == ""
            || document.getElementById("phone").value.length > 8
            || /^\s*([1-9]\d*)?\s*$/.test(document.getElementById("phone").value)==false) {
        alert("电话必须为数字且不能超过8个字符!");
        return false;
    } else {
        return true;
    }
}
</script>
</head>
<body >
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" >
    <li class="act" id="m"><a href="#"><span style="background:url(${ctx}/img/comm/other/01.gif) no-repeat; padding-left:22px;">风险评估</span></a></li>
  </div>
  <div class="contant pad3 overf">
    <div class="overf pad3  martop10" >
      <table width="100%">
        <tr>
          <td><img src="${ctx}/img/RAM/daner_bannera_01.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_02.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_03.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_05.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_06.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_07.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_08.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_09.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_10.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_11.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_12.gif" /></td>
        </tr>
      </table>
   </div>
    <h2 class="martop10">新建项目 "<span class="alert">*</span>"为必填项</h2>
    <div id="data" class="greenborder overf pad1" >
      <form name="f1" id="f1" action="${ctx}/ismp/domain/local/ram/projManager.do?method=saveNewProject" onsubmit="return validateAsseInfoProjForm(this);" method="post" >
        <table id="senfe" sortcol="-1">
          <thead>
            <tr>
              <th>评估对象<span class="alert">*</span></th>
              <td><input type="text" size="12" class="input" id="asseComp" name="asseComp" value="${asseInfoProj.asseComp}"/></td>
              <th>测评类型<span class="alert">*</span></th>
              <td><select id="cpKind" name="cpKind">
                  <option value="">-请选择-</option>
                  <c:forEach items="${dicCpKindList }" var="dicCpKind">
                  <option value="${dicCpKind.cpKindId}" <c:if test="${dicCpKind.cpKindId == asseInfoProj.cpKind }">selected='selected'</c:if>>${dicCpKind.cpKindName }</option>
                  </c:forEach>
                </select></td>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th>测评项目名称<span class="alert">*</span></th>
              <td><input type="text" size="12" class="input" id="projName" name="projName" value="${asseInfoProj.projName}"/></td>
              <th>所属部门<span class="alert">*</span></th>
              <td>
            <select id="offcPers" name="offcPers">
             <option value="">-请选择-</option>
             <c:forEach items="${udl}" var="ud">
                <option value="${ud.id}" <c:if test="${ud.id == asseInfoProj.domain.id}">selected='selected'</c:if>>${ud.domainName}</option>
             </c:forEach>
            </select>
             </td>
            </tr>
            <tr>
              <th>测评人<span class="alert">*</span></th>
              <td><input type="text" size="12" class="input" id="assePers" name="assePers" value="${asseInfoProj.assePers}"/></td>
              <th> <span style="float:left">法人<span class="alert">*</span></span> </th>
              <td><input type="text" size="12" class="input" id="lawPers" name="lawPers" value="${asseInfoProj.lawPers}"/></td>
            </tr>
            <tr>
              <th>地址<span class="alert">*</span></th>
              <td><input type="text" size="12" class="input" id="address" name="address" value="${asseInfoProj.address}"/></td>
              <th>联系方式<span class="alert">*</span></th>
              <td><input type="text" size="12" class="input" id="linkway" name="linkway" value="${asseInfoProj.linkway}"/></td>
            </tr>
            <tr>
              <th>邮编<span class="alert">*</span></th>
              <td><input type="text" size="12" class="input" id="zipcode" name="zipcode" value="${asseInfoProj.zipcode}"/></td>
              <th>电话<span class="alert">*</span></th>
              <td><input type="text" size="12" class="input" id="phone" name="phone" value="${asseInfoProj.phone}"/></td>
            </tr>
            <tr>
              <th>开始测评时间<span class="alert">*</span></th>
              <td>
                <logic:notPresent name="asseInfoProj">
                    <%SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                       String s = df.format(new Date());
                    %>
                    <%=s%>
                <input type="hidden" id="asseBeginTime" name="asseBeginTime" value="<%=s%>"/> 
                <input type="hidden" id="progress" name="progress" value="prog1"/>
                <input type="hidden" id="asseStatus" name="asseStatus" value="stat01" />
                <input type="hidden" id="secuLeve" name="secuLeve" value="L"/>
                </logic:notPresent>
                <logic:present name="asseInfoProj">
                 ${asseInfoProj.asseBeginTime}
                <input type="hidden" id="asseBeginTime" name="asseBeginTime" value="${asseInfoProj.asseBeginTime}"/>
                <input type="hidden" id="id" name="id" value="${asseInfoProj.id}"/>
				<input type="hidden" id="progress" name="progress" value="${asseInfoProj.progress}"/>
				<input type="hidden" id="asseStatus" name="asseStatus" value="${asseInfoProj.asseStatus}" />
				<input type="hidden" id="secuLeve" name="secuLeve" value="${asseInfoProj.secuLeve}"/>
               </logic:present>
              </td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td height="32" colspan="4" align="center"><input class="submit" type="submit"  value="提交" />
                            <input class="submit" type="reset"  value="重置" /></td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
  </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
