<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>等级保护知识库管理</title>
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
$(function(){
    $(".boxy").boxy();
});

  // 添加或修改弹出新对话框用到--//v2.0
  function MM_openBrWindow(theURL,winName,features) { 
    window.open(theURL,winName,features);
  }
  // 删除记录是用到
  function onDelete(path,id,isAll,currPage){
      var r = confirm("确认删除吗？")
      if (r==true) {
        window.location.href = path+ "/ismp/domain/local/gosp/updateKB.do?method=delete&id="+id+"&isAll="+isAll+"&currPage="+currPage;
      }
 }
  // 重置按钮用到
  function clean() {
      document.forms[0].dmid.value=-1;
   }  

  // 分页用到
  function toPage(curpage) {
      document.getElementById("currPage").value = curpage;
      document.forms["knowledgeBase"].submit();
  } 
  function subStringSingleCode(singleCode,id){
      var showValue;
      //var strId=id;
      if(singleCode.length>23){
          showValue=singleCode.substring(0,23)+"......";
      }else{
          showValue=singleCode;
      }
      document.getElementById(id).innerHTML=showValue;
  }
</script>
<style type="text/css">
    .Content{    
        width:350px;    
        white-space:nowrap;    
        word-break:keep-all;    
        overflow:hidden;    
        text-overflow:ellipsis;   
    }  
</style>
</head>
<body >
    <form action="${ctx}/ismp/domain/local/gosp/knowledgeBase.do?isAll=${isAll}" id="knowledgeBase" name="knowledgeBase" method="post">
    <input id="currPage" name="currPage" type="hidden" />
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" >
    <li <c:choose><c:when test="${gradeMenu=='LR'}">class='act'</c:when><c:otherwise>class='nor'</c:otherwise></c:choose> id="m"><a href="${ctx}/ismp/domain/local/gosp/findLawRules.do<sec:authorize ifAllGranted='ROLE_AdminAll'>?isAll=1</sec:authorize>"><span style="background:url(${ctx}/img/comm/other/03.gif) no-repeat; padding-left:22px;">法律法规</span></a></li>
    <li <c:choose><c:when test="${gradeMenu=='KB'}">class='act'</c:when><c:otherwise>class='nor'</c:otherwise></c:choose>><a href="${ctx}/ismp/domain/local/gosp/knowledgeBase.do<sec:authorize ifAllGranted='ROLE_AdminAll'>?isAll=1</sec:authorize>"><span style="background:url(${ctx}/img/comm/other/map01.png) no-repeat; padding-left:22px;">知识库</span></a></li>
    <li <c:choose><c:when test="${gradeMenu=='NS'}">class='act'</c:when><c:otherwise>class='nor'</c:otherwise></c:choose>><a href="${ctx}/ismp/domain/local/gosp/netSafe.do<sec:authorize ifAllGranted='ROLE_AdminAll'>?isAll=1</sec:authorize>"><span style="background:url(${ctx}/img/comm/other/map01.png) no-repeat; padding-left:22px;">网络等保状态</span></a></li>
  </div>
 <!-- <div class="contant">
    <h2>选择委办局</h2>
    <div class="greenborder greenback overf pad3 Height_a" >
      <div class="pad3">所属委办局:
        <input id="currPage" name="currPage" type="hidden" />
        <select id="dmid" name="dmid">
                                <option value="-1">==委办局==</option>
                                <logic:present name="udl">
                                    <logic:notEmpty name="udl">
                                        <logic:iterate id="u" name="udl">
                                             <c:choose>
                                               <c:when test="${u.id == selectid}">
                                                <c:set var="select13" value="selected"></c:set>
                                               </c:when>
                                               <c:otherwise>
                                                <c:set var="select13" value=""></c:set>
                                               </c:otherwise>
                                              </c:choose>
                                            <option value="${u.id}"  ${select13 }>${u.domainName}</option>
                                        </logic:iterate>
                                    </logic:notEmpty>
                                </logic:present>
                                <sec:authorize ifAllGranted='ROLE_AdminAll'>
                                   <c:choose>
                                     <c:when test="${selectid == -2}">
                                      <option value="-2" selected="selected">未知域</option>
                                     </c:when>
                                     <c:otherwise>
                                       <option value="-2" >未知域</option>
                                     </c:otherwise>
                                    </c:choose>
                                </sec:authorize>
                            </select>
           <input class="submit" type="submit" value="查询" />
           <input class="submit" type="button" value="重置" onclick="clean()" class="R6" />     
      </div>      
    </div>-->
    <h2 class="martop8">查看列表</h2>
      <ul id="page">
    <li><a href="#" class="R6 R7" onclick="MM_openBrWindow('${ctx}/ismp/domain/local/gosp/addKB.do?isAll=${isAll}&currPage=${currPage}','添加','scrollbars=yes,width=450,height=480')">添加</a></li>
  </ul>
    <div id="data" class="greenborder overf pad1 " >
        <table id="senfe" sortcol="-1">
          <thead>
            <tr>
              <th width="9%" style="cursor:pointer" onclick="sortTable('senfe',0);">序号<span class="webdings">6</span></th>
              <th width="14%" style="cursor:pointer" onclick="sortTable('senfe',0);">名称</th>
              <th width="28%" style="cursor:pointer" onclick="sortTable('senfe',0);">文件内容</th>
              <th width="15%" style="cursor:pointer" onclick="sortTable('senfe',0);">最后更新时间</th>
              <th width="9%" style="cursor:pointer" onclick="sortTable('senfe',0);">编号</th>
              <th width="14%">发布人员</th>
              <th width="11%">操作</th>
            </tr>
          </thead>
          <tbody>
           <c:forEach var="KBInfo" items="${kBList}" >
            <tr>
              <td>${KBInfo.id } </td>
              <td>${KBInfo.name }</td>
              <td id="${KBInfo.id }"><script type="text/javascript">subStringSingleCode('${KBInfo.file_content}','${KBInfo.id }')</script></td>
              <td>${KBInfo.lastUpdateTime}</td>
              <td>${KBInfo.sn }</td>
              <td>${KBInfo.issuer }</td>
              <td class="tdnowrap">
<a href="#" onclick="onDelete('${ctx}','${KBInfo.id}','${isAll}','${currPage}')" class="R6" >删除</a><span style="float:left">|</span>                   
<a href="#" class="R6" onclick="MM_openBrWindow('${ctx}/ismp/domain/local/gosp/updateKB.do?method=updateValue&id=${KBInfo.id}','修改','scrollbars=yes,width=450,height=480')">修改</a>
              </td>
            </tr> 
           </c:forEach> 
             <input type="hidden" id="isAll" name="isAll" value="${isAll}" />                         
          </tbody>
        </table>
    </div>
   <div class="martop8 Height_t">
     <ul id="page">
      <li><a class="first" href="javascript:toPage(1);"></a></li>
      <c:if test="${currPage>1 }">
        <li><a class="pre" href="javascript:toPage(${currPage-1 });"></a></li>
      </c:if>
       <c:if test="${currPage<totalPage }">
         <li><a class="next" href="javascript:toPage(${currPage+1 });"></a></li>
       </c:if>
      <li><a class="last" href="javascript:toPage(${totalPage });"></a></li>
      <li>共${totalPage } 页跳至
        <input id="currPagetest" name="currPage"  type="text" size="2" class="input" value="${currPage }" />
        &nbsp; 
      </li>
     <li><a class="R6" href="javascript:toPage(document.getElementById('currPage').value);">GO</a></li> 
    </ul>
</div>
  </div>
</div>
</form>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
