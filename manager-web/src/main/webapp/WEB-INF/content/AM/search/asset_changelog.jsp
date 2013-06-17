<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript">
<!--
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

function checkData(){
  
   var b=document.getElementById("b").value;
   var e=document.getElementById("e").value; 
   if(b==''||e==''){
         alert('两个都是必填项目！请写完整');
         return false;
   }else{
		return true;
	} 
    
}

function submitForm(){
	 if(checkData()){
		 document.forms["changeform"].submit();
	 }
	 
	
}
//-->
</script>
</head>

<body>
<div class="contant">
<div id="data">
	<h2 class="martop8">资产变动信息</h2>
	<html:form action="/ismp/domain/local/am/changelog.do?method=addChangeLog" styleId="changeform" method="post" onsubmit="return checkData();">
                <input type="hidden"  name="chid" value="${chid}"/> 
                <input type="hidden"  name="locid" value="${locid}"/> 
                <input type="hidden"  name="typeid" value="${typeid}"/> 
                <input type="hidden" name="curpage" value="${page.currentPage }"></input>
             <table width="90%" border="0" align="center" cellpadding="0"
                 cellspacing="0" class="css1">
                 <tr>
                     <td colspan="2">&nbsp;</td>
                 </tr>
                 <tr>
                     <td width="49%">
                     <div align="right">更改前状态：</div>                                     </td>
                     <td width="51%"><input type="text" name="statusBefore"
                         id="b"  /></td>
                 </tr>
                 <tr>
                     <td>
                     <div align="right">更改后状态：</div>                                     </td>
                     <td><input type="text" name="statusAfter"
                         id="e" /></td>
                 </tr>
                 <tr>
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                 </tr>
                 <tr>
                 	<td></td>
                     <td  align="center">
                     <div align="center">
                     	
                     	<!-- <a href="#" onclick="submitForm();" class="R6">新增</a> -->
                     	<input name="button3" type="submit"  class="R6 R7" id="button3" value="新增" /> 
                     </div>  
                     </td>
                 </tr>
             </table>
	</html:form> 
</div>
<br />	
		<div id="data">
			<h2 class="martop8">资产变动信息</h2>
			<logic:present name="changelogList">
                       <table >
                           <tr>
                               <th >更改前状态</th>
                               <th >更改后状态</th>
                               <th >创建时间</th>
                               <th >操作</th>
                           </tr>
                              <logic:iterate id="log" name="changelogList">
                                  <tr>
                                      <td>${log.statusBefore }</td>
                                      <td>${log.statusAfter }</td>
                                      <td><bean:write name="log" property="createTime" format="yyyy-MM-dd HH:mm"/></td>
                                      <td><a class="R6" href="changelog.do?method=delLog&chid=${chid}&logId=${log.id }&deviceId=${deviceId }&locid=${locid }&typeid=${typeid }&curpage=${page.currentPage}" onclick="return window.confirm('真的要删除吗？')">删除</a></td>
                                  </tr>
                              </logic:iterate>
                       </table>
              </logic:present>
              
       <ul id="page">
        <li><a class="first" href="javaScript:fwpage('1')"></a></li>
        <li>
        <c:if test="${page.hasPrePage==true}">
			<a class="pre" href="javaScript:fwpage('${page.currentPage-1}')"></a>
		</c:if>
		</li>
        <li>
        <c:if test="${page.hasNextPage==true}">
			<a class="next" href="javaScript:fwpage('${page.currentPage+1 }')"></a>
		</c:if>
		</li>
        <li><a class="last"	href="javaScript:fwpage('${page.totalPage }')"></a></li>
        <li>共${page.totalPage }页 跳至
          <jsp:include page="/WEB-INF/content/AM/comm/pageInfo.jsp"></jsp:include></li>
      </ul>
      
      <!-- <html:form action="/ismp/domain/local/am/changelog.do?method=addChangeLog" styleId="changeform" method="post" onsubmit="return checkData();">
      	<input type="hidden" id="" />
      </html:form> -->
          </div>   
                   
</div>
<script type="text/javascript">
    function fwpage(curpage) {
        //var curpage = document.getElementById("pageid").value;
        location.href = "changelog.do?method=searchChangeLog&chid=${chid}&locid=${locid }&typeid=${typeid }&curpage=" + curpage;
    }
    function fwd(curPage) {
        var curp = document.getElementById("mid").value;
        location.href = "changelog.do?method=searchChangeLog&chid=${chid}&locid=${locid }&typeid=${typeid }&curpage=" + curp;
	} 
</script>
</body>
</html>
