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
           document.getElementById("add").style.display="";
           document.getElementById("updatenotify").style.display="none";
    }
    function noshow(n){
           document.getElementById('No'+n).style.display="none";
    }

    function updateproc(id,name,content){
        document.getElementById("add").style.display="none";
        document.getElementById("updatenotify").style.display="";
        document.getElementById("content").innerText=content;
        document.getElementById("name").value=name;
        document.getElementById("updateid").value=id;
    }

    function Ondelete(id,respname){
    	var currPage=document.getElementById("currPage").value;
        if(confirm("确认删除"))
    	window.location.href ="${ctx }/ismp/domain/local/erm/respnotify.do?method=deletenotify&id="+id+"&currPage="+currPage+"&respname="+respname;
    }
    
    function toPage(curpage) {
        document.getElementById("currPage").value = curpage;
        document.forms[0].submit();
    }
    function  trim(str){
        for(var i=0; i<str.length&&str.charAt(i)==" "; i++)  ;
        for(var j=str.length; j>0&&str.charAt(j-1)==" ";j--)  ;
        if(i>j) return "";  
        return  str.substring(i,j);  
    } 

    function checknotifyProc1() {
        var content=document.getElementById("content").value;
        var name = document.getElementById("name").value;
        if (trim(content)== null||content == undefined||trim(content) == "" ||content.length > 255) {
            alert("请填写应急通知过程内容且不超过255个字符");
            content.focus; return ;
        } else if (trim(name) == null || name == undefined || trim(name) == ""|| name.length > 255) {
            alert("请填写应急通知过程名称且不超过255个字符");
            name.focus; return ;
        } 
        document.updateForm.submit();
    }

    function checknotifyProc2() {
          var content=document.getElementById("content1").value;
          var name = document.getElementById("name1").value;
          if (trim(content)== null || content == undefined || trim(content) == "" || content.length > 255) {
              alert("请填写应急通知过程内容且不超过255个字符");
              content.focus; return ;
          } else if (trim(name) == null || name == undefined || trim(name) == ""|| name.length > 255) {
              alert("请填写应急通知过程名称且不超过255个字符");
              name.focus; return ;
          } 
          document.addForm.submit();
    }
</script>
</head>
<body class="pad3">
<div  id="data" class="pad1 ">
 <div class="contant">
<form action="${ctx}/ismp/domain/local/erm/respnotify.do?method=showNotify&id=${respid}&respname=${respname}" method="post">
    <h2>预案 " ${respname} " 的通知规程列表</h2>
    <table  id="senfesub" >
        <thead>
            <tr>
                <th>ID</th>
                <th>通知规程名称</th>
                <th>通知规程内容</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <logic:present name="notifyList">
                <logic:notEmpty name="notifyList">
                    <logic:iterate id="notify" name="notifyList">
                        <tr>
                            <td>${notify.id }</td>
                            <td>${notify.name } </td>
                            <td>${notify.content } </td>
                            <td><a href="javascript:updateproc('${notify.id }','${notify.name}','${notify.content }')" class="R6">编辑</a><a href="javascript:Ondelete('${notify.id}','${respname}');" class="R6">删除</a></td>
                        </tr>
                    </logic:iterate>
                </logic:notEmpty>
            </logic:present>
        </tbody>
    </table>
    <div class="paddiv"></div>
    <span style="float:left; margin-top:10px;"><a href="#" class="R6 R7" onclick="show()">新建通知规程</a></span>
    <ul id="page">
         <li><a class="first" href="javascript:toPage(1);"></a></li>
      <c:if test="${currPage>1 }">
          <li><a class="pre" href="javascript:toPage(${currPage-1 });"></a></li>
      </c:if>
      <c:if test="${currPage<totalPage }">
          <li><a class="next" href="javascript:toPage(${currPage+1 });"></a></li>
      </c:if>
      <li><a class="last" href="javascript:toPage(${totalPage });"></a></li>
      <li>
                         共 ${totalPage } 页 跳至
          <input id="currPage" name="currPage" type="text" size="2" class="input" value="${currPage }"/>
          &nbsp;
      </li>
      <li><a class="R6" href="javascript:toPage(document.getElementById('currPage').value);">GO</a></li>
    </ul>
    <div class="paddiv"></div>
</form>
</div>
<!-- 编辑 -->
    <div id="updatenotify"  style="display:none;">
    <form action="${ctx}/ismp/domain/local/erm/respnotify.do?method=updatenotify&currPage=${currPage}&respname=${respname}" id="updateForm" name="updateForm" method="post">
        <table>
            <tr>
                <th> 通知规程名称 <span class="alert">*</span></th>
                <td colspan="3"><input type="text" size="12" class="input" id="name" name="name"/></td>
            </tr>
            
            <tr>
                <th> 通知规程内容 <span class="alert">*</span></th>
                <td colspan="3"><textarea cols="60" rows="5" id="content" name="content"></textarea></td>
            </tr>
        </table>
        <input type="hidden" id="updateid" name="updateid" />
        <div class="paddiv"></div>
         <input type="button" value="更新" class="R6 R7" onclick="checknotifyProc1()"/>
        <div class="paddiv"></div><span id="showDiv"></span>
    </form>
    </div>



<!-- 新建-->
    <div id="add"  style="display:none;">
        <form action="${ctx}/ismp/domain/local/erm/respnotify.do?method=addnotify&currPage=${currPage}&respname=${respname}" method="post" id="addForm" name="addForm">
            <h2> 建立新规程  "<span class="alert">*</span>"为必填项</h2>
            <table>
                <tr>
                    <th> 通知规程名称 <span class="alert">*</span></th>
                    <td colspan="3"><input type="text" size="12" class="input" name="name1" id="name1"/></td>
                </tr>
            
                <tr>
                    <th> 通知规程内容 <span class="alert">*</span></th>
                    <td colspan="3"><textarea cols="60" rows="5" name="content1" id="content1"></textarea></td>
                </tr>
            </table>
            <div class="paddiv"></div>
            <input type="button" value="提 交" class="R6 R7" onclick="checknotifyProc2()"/>
            <div class="paddiv"></div>
        </form>
    </div>
</div>
</body>
</html>