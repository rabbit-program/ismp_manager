<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

function validateWebMonitorForm(form){
    if (trim(document.getElementById("sn").value) == null
            || document.getElementById("sn").value == undefined
            || trim(document.getElementById("sn").value) == ""
            || document.getElementById("sn").value.length > 50) {
        alert("编号必填且不超过50个字符!");
        return false;
    }  else if (trim(document.getElementById("name").value) == null
            || document.getElementById("name").value == undefined
            || trim(document.getElementById("name").value) == ""
            || document.getElementById("name").value.length > 50) {
        alert("名称必填且不超过50个字符!");
        return false;
    } else if (trim(document.getElementById("timeInterval").value) == null
            || document.getElementById("timeInterval").value == undefined
            || trim(document.getElementById("timeInterval").value) == ""
            || document.getElementById("timeInterval").value.length > 20
            || /^\s*([1-9]\d*)?\s*$/.test(document.getElementById("timeInterval").value)==false ) {
        alert("轮询时间必须为数字且不能超过20个字符!");
        return false;
    }else if (trim(document.getElementById("timeOut").value) == null
            || document.getElementById("timeOut").value == undefined
            || trim(document.getElementById("timeOut").value) == ""
            || /^\s*([1-9]\d*)?\s*$/.test(document.getElementById("timeOut").value)==false ) {
        alert("超时时间必须为数字且不能超过20个字符!");
        return false;
    }  else if (trim(document.getElementById("url").value) == null
            || document.getElementById("url").value == undefined
            || trim(document.getElementById("url").value) == ""
            || document.getElementById("url").value.length >100) {
        alert("URL必填且不能超过100个字符!");
        return false;
    }else if (document.getElementById("domainid").value == null
            || document.getElementById("domainid").value == undefined
            || document.getElementById("domainid").value == "") {
        alert("所属域必选!");
        return false;
    } else if (trim(document.getElementById("desc").value) == null
            || document.getElementById("desc").value == undefined
            || trim(document.getElementById("desc").value) == ""
            || document.getElementById("desc").value.length > 500) {
        alert("描述必填且不超过500个字符!");
        return false;
    }else if (trim(document.getElementById("remark").value) == null
            || document.getElementById("remark").value == undefined
            || trim(document.getElementById("remark").value) == ""
            || document.getElementById("remark").value.length > 500) {
        alert("备注必填且不超过500个字符!");
        return false;
    } else {
        return true;
    }
}


</script>
</head>
<body >



 <c:if test="${webMonitorRecords==null}">
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" >    
    <li class="act" id="m"><a href="#"><span style="background:url(${ctx}/img/comm/other/01.gif) no-repeat; padding-left:22px;">网站安全检测</span></a></li>
</div>
  <form name="f1" id="f1" action="${ctx}/ismp/domain/local/wsm/webMonitor.do?method=saveWebMonitor&isAll=${isAll}&currPage=${currPage}" onsubmit="return validateWebMonitorForm(this);" method="post" >
  <div class="contant">
    <h2 >添加信息</h2>

  <div id="data" class="greenborder overf pad1" >
          <table id="senfe" sortcol="-1">
            <thead>
              <tr>
                
              </tr>
            </thead>
            <tbody>
             <tr>
			      <th>编号</th>
			      <td> 
			      <input type="text" size="20" class="input" name="sn" id="sn" /></td>
			      <th>名称</th>
			      <td><input type="text" name="name" id="name" /></td>
		      </tr>
              <tr>
                  <th>轮询时间</th>
                  <td> 
                  <input type="text" size="20" class="input" name="timeInterval" id="timeInterval" /></td>
                  <th>超时时间</th>
                  <td><input type="text" name="timeOut" id="timeOut" /></td>
              </tr>
              <tr>
                  <th>URL</th>
                  <td> 
                  <input type="text" size="30" class="input" name="url" id="url" /></td>
                  <th>所属域</th>
                  <td> <select id="domainid" name="domainid">
		             <option value="">-请选择-</option>
		             <c:forEach items="${udl}" var="ud">
		                <option value="${ud.id}" >${ud.domainName}</option>
		             </c:forEach>
            </select></td>
              </tr>
               <tr>
                  <th>描述</th>
                  <td> 
                  <textarea cols="85" rows="7" id="desc" name="desc"></textarea></td>
                  <th>&nbsp;</th>
                  <td>&nbsp;</td>
              </tr>
               <tr>
                  <th>备注</th>
                  <td> 
                <textarea cols="85" rows="7" id="remark" name="remark"></textarea>
                  </td>
                  <th>&nbsp;</th>
                  <td>&nbsp;</td>
              </tr>
            </tbody>
          </table>
       
    </div>
    <div class="martop8 Height_t">
    <ul id="page">
    <li><input type="submit" class="R6 R7 boxy" value="添加"/></li>
    <li><input type="reset" class="R6 R7 boxy" value="重置"/></li>
  </ul>
  
    <br />
  </div>
 </form>
  </div>
   
  </div>
</div>
</c:if>

 <c:if test="${webMonitorRecords!=null}">
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" >    
    <li class="act" id="m"><a href="#"><span style="background:url(${ctx}/img/comm/other/01.gif) no-repeat; padding-left:22px;">网站安全检测</span></a></li>
</div>
   <form  name="f1" id="f1" action="${ctx}/ismp/domain/local/wsm/webMonitor.do?method=saveWebMonitor&isAll=${isAll}&currPage=${currPage}" onsubmit="return validateWebMonitorForm(this);" method="post" >
  <div class="contant">
    <h2 >添加信息</h2>
 
  <div id="data" class="greenborder overf pad1" >
          <table id="senfe" sortcol="-1">
            <thead>
              <tr>
                
              </tr>
            </thead>
            <tbody>
             <tr>
                  <th>编号</th>
                  <td> 
                  <input type="hidden" id="id" name="id" value="${webMonitorRecords.id}" />
                  <input type="text" size="20" class="input" name="sn" id="sn" value="${webMonitorRecords.sn}" /></td>
                  <th>名称</th>
                  <td><input type="text" size="20" name="name" id="name"  value="${webMonitorRecords.name}"/></td>
              </tr>
              <tr>
                  <th>轮询时间</th>
                  <td> 
                  <input type="text" size="20" class="input" name="timeInterval" id="timeInterval" value="${webMonitorRecords.timeInterval}"/></td>
                  <th>超时时间</th>
                  <td><input type="text" size="20" name="timeOut" id="timeOut" value="${webMonitorRecords.timeOut}"/></td>
              </tr>
              <tr>
                  <th>URL</th>
                  <td> 
                  <input type="text" size="30" class="input" name="url" id="url" value="${webMonitorRecords.url}"/></td>
                  <th>所属域</th>
                  <td> <select id="domainid" name="domainid">
			             <option value="">-请选择-</option>
			             <c:forEach items="${udl}" var="ud">
			                <option value="${ud.id}" <c:if test="${ud.id == webMonitorRecords.domain.id}">selected='selected'</c:if>>${ud.domainName}</option>
			             </c:forEach>
			            </select></td>
              </tr>
               <tr>
                  <th>描述</th>
                  <td> 
                  <textarea cols="85" rows="7" id="desc" name="desc" >${webMonitorRecords.desc}</textarea></td>
                  <th>&nbsp;</th>
                  <td>&nbsp;</td>
              </tr>
               <tr>
                  <th>备注</th>
                  <td> 
                <textarea cols="85" rows="7" id="remark" name="remark" >${webMonitorRecords.remark}</textarea>
                  </td>
                  <th>&nbsp;</th>
                  <td>&nbsp;</td>
              </tr>
            </tbody>
          </table>
        
    </div>
    <div class="martop8 Height_t">
    
   <input type="submit" class="R6 R7 boxy" value="修改"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <input type="button" class="R6 R7 boxy" value="返回" onClick="history.back(-1)" />
  
    <br />
  </div>
</form>
  </div>
   
  </div>
</div>
</c:if>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
