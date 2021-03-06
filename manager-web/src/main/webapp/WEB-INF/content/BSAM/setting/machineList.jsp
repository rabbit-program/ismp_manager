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
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<title>主机列表</title>
<script type="text/javascript">
  
  function toPage(currPage) {
	  var totalPage = document.getElementById("totalPage").value;
      var isAll = document.getElementById("isAll").value;
      if(0 == totalPage){
          totalPage = 1;
      }
      if("number" == typeof(currPage)){
          document.getElementById("currPage").value = currPage;
          window.location.href="${ctx}/ismp/domain/local/bsam/machineAction.do?method=getMachineList&currPage="+currPage+"&isAll="+isAll;
      }else {
          if((currPage.indexOf("-")   ==   0)||!(currPage.indexOf(".")   ==   -1)){
              alert("跳转页数只能是整数!");
          }else if (parseInt(currPage) > parseInt(totalPage) || currPage <= 0) {
              alert("输入的页数范围有误,请重新输入!");
          }else {
              document.getElementById("currPage").value = currPage;
              window.location.href="${ctx}/ismp/domain/local/bsam/machineAction.do?method=getMachineList&currPage="+currPage+"&isAll="+isAll; 
          }
      }

  }
  function modify(id){
	  var currPage=document.getElementById("currPage").value;
      var isAll = document.getElementById("isAll").value;
	  window.location.href="${ctx}/ismp/domain/local/bsam/machineAction.do?method=machineInput&id="+id+"&currPage="+currPage+"&isAll="+isAll;
  }

  function add(){
	  var currPage=document.getElementById("currPage").value;
      var isAll = document.getElementById("isAll").value;
	  window.location.href="${ctx}/ismp/domain/local/bsam/machineAction.do?method=machineInput&currPage="+currPage+"&isAll="+isAll;
  }

  function delet(id){
      if(window.confirm("是否删除？")){
    	  var currPage=document.getElementById("currPage").value;
          var isAll = document.getElementById("isAll").value;
    	  window.location.href="${ctx}/ismp/domain/local/bsam/machineAction.do?method=machineDelete&id="+id+"&isAll="+isAll+"&currPage="+currPage;
      }
  }
 </script>
</head>
<body>
<div id="contant" class="mainbg">
    <%@ include file="/WEB-INF/content/BSAM/comm/topMenu.jsp"%>
    <div class="contant" >
	    <div class="overf h20 martop10">
	      <li id="m">
	           <a class="mbacka" href="${ctx}/ismp/domain/local/bsam/machineAction.do?method=getMachineList<sec:authorize ifAllGranted='ROLE_AdminAll'>&isAll=1</sec:authorize>">
	                <span class="menus10">主机列表</span>
	           </a>
	      </li>

	      <li >
	           <a class="mback" href="${ctx}/ismp/domain/local/bsam/machineCabinetAction.do?method=getMachineCabinetList<sec:authorize ifAllGranted='ROLE_AdminAll'>&isAll=1</sec:authorize>">
	                <span class="menus11">机柜列表</span>
	           </a>
	      </li>
	       
	      <li>
	           <a class="mback" href="${ctx}/ismp/domain/local/bsam/machineRoomAction.do?method=getMachineRoomList<sec:authorize ifAllGranted='ROLE_AdminAll'>&isAll=1</sec:authorize>" >
	                <span class="menus12">机房列表</span>
	           </a>
	      </li>
	
	      <li>
	           <a class="mback" href="${ctx}/ismp/domain/local/bsam/colorThresholdAction.do?method=colorThresholdInput<sec:authorize ifAllGranted='ROLE_AdminAll'>&isAll=1</sec:authorize>" >
	                <span class="menus09">颜色阈值设置</span>
	           </a>
	      </li>
	    </div>
    
        <form name="f1" id="f1" action="/ismp/domain/local/bsam/machineAction.do?method=getMachineList" method="post">
               <input type="hidden" id="isAll" name="isAll" value="${isAll}"/>
<!--           <input type="hidden" id="domainArr" value="${domainArr}" />-->
           <div id="data" class="greenborder overf pad1" >
                <table id="titleName" sortcol="-1">
                    <thead>
                      <tr>
                        <th width="13%" style="cursor:pointer" onclick="sortTable('senfe',0,'int');">主机IP</th>
                        <th width="14%">主机名称</th>
                        <th width="16%">主机信息</th>
                        <th width="17%">上级物理位置类型</th>
                        <th width="13%">上级物理位置</th>
                        <th width="10%">权重</th>
                        <th width="13%">操作</th>
                      </tr>
                    </thead>
                </table>

                <table id="senfe" name="machineTable" sortcol="-1" border="0" cellpadding="0" cellspacing="1">
                    <tbody>
                        <logic:notEmpty name="machineList">
                            <logic:iterate id="machine" name="machineList" indexId="i">
                            <tr>
                              <td width="13%">${machine.ip }</td>
                              <td width="14%">${machine.machineName }</td>
                              <td width="16%">${machine.description }</td>
                              <td width="17%">
                                  <c:if test="${machine.parentType == 'JiGui'}">机柜</c:if>
                                  <c:if test="${machine.parentType == 'JiFang'}">机房</c:if>
                                  <c:if test="${machine.parentType == 'AnQuanYu'}">安全域</c:if>
                              </td>
                              <td width="13%">
                                  <c:if test="${machine.parentType == 'JiGui'}">${machine.machineCabinet.machineCabinetName }</c:if>
                                  <c:if test="${machine.parentType == 'JiFang'}">${machine.machineRoom.machineRoomName }</c:if>
                                  <c:if test="${machine.parentType == 'AnQuanYu'}">${machine.domain.domainName }</c:if>
                              </td>
                              <td width="10%">${machine.weight }</td>
                              <td width="13%">
                                <input type="button" class="commonbtn" value="修改" hidefocus="true" onclick="modify('${machine.id}')" /> 
                                <input type="button" class="commonbtn" value="删除" hidefocus="true" onclick="delet('${machine.id}')" /> 
                              </td>
                            </tr>
                            </logic:iterate>
                         </logic:notEmpty>    
                         <logic:empty name="machineList">
                            <tr>
                                <td colspan="6">没有找到主机！</td>
                            </tr>
                         </logic:empty>
                    </tbody>
                </table>
           </div>
           <div class="paddiv"></div>
                <ul id="page">
                    <li><a class="first" href="javascript:toPage(1);"></a></li>
                    <c:if test="${currPage>1 }">
                        <li><a class="pre" href="javascript:toPage(${currPage-1 });"></a></li>
                    </c:if>
                    <c:if test="${currPage<totalPage }">
                        <li><a class="next" href="javascript:toPage(${currPage+1 });"></a></li>
                    </c:if>
                    <li>
                        <input type="hidden" value="${totalPage }" id="totalPage"/>
                        <a class="last" href="javascript:toPage(${totalPage });"></a>
                    </li>
                    <li>
                                                                共 ${totalPage } 页 跳至
                        <input type="text" class="input" size="3" maxlength="7"
                                value="${currPage}" id="currPage" name="currPage"
                                onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==46"
                                onpaste="return !clipboardData.getData('text').match(/\D/)"
                                ondragenter="return false" style="ime-mode: Disabled" />&nbsp;
<!--                        <input id="currPage" name="currPage" type="text" size="2" class="input" value="${currPage }"/>&nbsp;-->
                    </li>
                    <li><a class="R6" href="javascript:toPage(document.getElementById('currPage').value);">GO</a></li>
                    <li>
                        <input type="button" class="R6 R7" value="新增" hidefocus="Add" onclick="add()" />
                    </li>
                </ul>
                <br/><br/><br/>
        </form>
    </div>
 </div>      
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>  