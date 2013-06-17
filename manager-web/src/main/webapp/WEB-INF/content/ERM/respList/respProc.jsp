<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Mainframe</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Newcommon.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Maincontant.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/common.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/boxy.css" />

<script language="javascript">
    function show(){
    	   var safe=document.getElementById("safethreat").value;
    	   if(safe==''||safe==null){
    		    alert("请选择安全列表");
    	   }else{
    		   document.getElementById("updateproc").style.display="none";
               document.getElementById("addproc").style.display="";
           }
    }
    function noshow(n){
           document.getElementById('No'+n).style.display="none";
    }
    function updateproc(id,name,content){
        document.getElementById("addproc").style.display="none";
        document.getElementById("updateproc").style.display="";
        document.getElementById("proccontent").innerText=content;
        document.getElementById("procname").value=name;
        document.getElementById("procid").value=id;
    }

    function OnDelete(id,respname){
    	var currPage=document.getElementById("currPage").value;
        if(confirm("确认删除"))
        window.location.href ="${ctx }/ismp/domain/local/erm/respproc.do?method=deleteproc&id="+id+"&currPage="+currPage+"&respname="+respname;
    	
    }
    
    function toPage(curpage,respname) {
        document.getElementById("currPage").value = curpage;
        var id = document.getElementById("respid").value;
        window.location.href ="${ctx}/ismp/domain/local/erm/respproc.do?method=showRespProc&id="+id+"&currPage="+curpage+"&respname="+respname;
    }
    function  trim(str){
        for(var i=0; i<str.length&&str.charAt(i)==" "; i++)  ;
        for(var j=str.length; j>0&&str.charAt(j-1)==" ";j--)  ;
        if(i>j) return "";  
        return  str.substring(i,j);  
    } 
    function checkProc1() {
    	var proccontent=document.getElementById("proccontent").value;
    	var procname = document.getElementById("procname").value;
        if (trim(proccontent)== null||proccontent == undefined||trim(proccontent) == "" ||proccontent.length > 255) {
            alert("请填写应急响应过程内容且不超过255个字符");
            proccontent.focus; return ;
        } else if (trim(procname) == null || procname == undefined || trim(procname) == ""|| procname.length > 255) {
            alert("请填写应急响应过程名称且不超过255个字符");
            procname.focus; return ;
        } 
        document.updateForm.submit();
    }

    function checkProc2() {
    	  var proccontent=document.getElementById("proccontent1").value;
          var procname = document.getElementById("procname1").value;
          if (trim(proccontent)== null || proccontent == undefined || trim(proccontent) == "" || proccontent.length > 255) {
              alert("请填写应急响应过程内容且不超过255个字符");
              proccontent.focus; return ;
          } else if (trim(procname) == null || procname == undefined || trim(procname) == ""|| procname.length > 255) {
              alert("请填写应急响应过程名称且不超过255个字符");
              procname.focus; return ;
          } 
          document.addForm.submit();
    }
</script>
</head>
<body class="pad3">
<div id="data" class="pad1 ">
    <form action="${ctx}/ismp/domain/local/erm/respproc.do?method=showRespProcBySafe&currPage=1&respname=${respname}" method="post">
        <h2>安全威胁列表</h2>
        <div class="greenborder greenback overf pad3 Height_t" >
            <ul style="line-height:40px;">
              <li>
                <select id="safethreat" name="safethreat" onchange="javascript:submit()"> 
                     <option value="">请选择威胁列表</option>
                     <logic:present name="safeThreatList">
                         <logic:notEmpty name="safeThreatList">
                             <logic:iterate id="safe" name="safeThreatList">
                                  <c:choose>
                                    <c:when test="${safe.id == safeid}">
                                     <c:set var="select13" value="selected"></c:set>
                                    </c:when>
                                    <c:otherwise>
                                     <c:set var="select13" value=""></c:set>
                                    </c:otherwise>
                                   </c:choose>
                                 <option value="${safe.id}"  ${select13}>${safe.name}</option>
                             </logic:iterate>
                         </logic:notEmpty>
                     </logic:present>
                 </select></li>
            </ul>
        </div>
    <form>
<form id="form2" name="form2" action="${ctx}/ismp/domain/local/erm/respproc.do?method=showRespProc&id=${respid}&currPage=${currPage}" method="post" >
    <input type="hidden" value="${respid}" id="respid"/>
    <div class="paddiv"></div>

    <h2>预案  " ${respname } " 的响应过程列表</h2>
    <table  id="senfesub" >
        <thead>
            <tr>
                <th>ID</th>
                <th>响应过程名称</th>
                <th>响应过程内容</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <logic:present name="respprocList">
                <logic:notEmpty name="respprocList">
                    <logic:iterate id="info" name="respprocList">
                        <tr>
                            <td>${info.id }</td>
                            <td>${info.name }</td>
                            <td>${info.content } </td>
                            <td><a href="javascript:updateproc('${info.id }','${info.name}','${info.content }')" class="R6">编辑</a><a href="javascript:OnDelete('${info.id }','${respname}')" class="R6">删除</a></td>
                        </tr>
                    </logic:iterate>
                </logic:notEmpty>   
            </logic:present>
        </tbody>
    </table>
    <div class="paddiv"></div>
    <span style="float:left; margin-top:10px;"><a href="#" class="R6 R7" onclick="show(2)">新建响应过程</a></span>
    <ul id="page">
      <li><a class="first" href="javascript:toPage(1,'${respname}');"></a></li>
      <c:if test="${currPage>1 }">
          <li><a class="pre" href="javascript:toPage('${currPage-1 }','${respname}');"></a></li>
      </c:if>
      <c:if test="${currPage<totalPage }">
          <li><a class="next" href="javascript:toPage('${currPage+1 }','${respname}');"></a></li>
      </c:if>
      <li><a class="last" href="javascript:toPage('${totalPage }','${respname}');"></a></li>
      <li>
                         共 ${totalPage } 页 跳至
          <input id="currPage" name="currPage" type="text" size="2" class="input" value="${currPage }"/>
          &nbsp;
      </li>
      <li><a class="R6" href="javascript:toPage(document.getElementById('currPage').value,'${respname}');">GO</a></li>
  </ul>
    <div class="paddiv"></div>
</form>

<!-- 更新应急响应过程 -->
    <div id="updateproc" style="display:none;">
       <form action="${ctx}/ismp/domain/local/erm/respproc.do?method=updateproc&currPage=${currPage}&respname=${respname}" method="post" id="updateForm" name="updateForm">
            <table>
                <tr>
                    <th> 应急响应过程内容 <span class="alert">*</span></th>
                    <td colspan="3"><textarea cols="60" rows="5" name="proccontent" id="proccontent"></textarea></td>
                </tr>
                <tr>
                    <th> 应急响应过程名称 <span class="alert">*</span></th>
                    <td colspan="3"><input type="text" size="12" class="input" name="procname" id="procname" /></td>
                </tr>
            </table>
            <input type="hidden" id="procid" name="procid" />
            <div class="paddiv"></div>
            <input type="button" value="更新" class="R6 R7" onclick="checkProc1()"/>
            <div class="paddiv"></div>
        </form>
    </div>


<!-- 新建应急响应过程 -->
  <div id="addproc"  style="display:none;"> 
    <form action="${ctx}/ismp/domain/local/erm/respproc.do?method=addRespProcInfo&currPage=${currPage}&respname=${respname}" method="post" id="addForm" name="addForm">
            <h2> 新建应急响应过程 至 <b>${safeName }</b> "<span class="alert">*</span>"为必填项</h2>
            <table>
                <tr>
                    <th> 应急响应过程内容 <span class="alert">*</span></th>
                    <td colspan="3"><textarea cols="60" rows="5" name="proccontent1" id="proccontent1"></textarea></td>
                </tr>
                <tr>
                    <th> 应急响应过程名称 <span class="alert">*</span></th>
                    <td colspan="3"><input type="text" size="12" class="input" name="procname1" id="procname1"/></td>
                </tr>
            </table>
            <div class="paddiv"></div>
            <input type="button" value="保存" class="R6 R7" onclick="checkProc2()"/>
            <div class="paddiv"></div>
    </form>
</div>
</div>
</body>
</html>
