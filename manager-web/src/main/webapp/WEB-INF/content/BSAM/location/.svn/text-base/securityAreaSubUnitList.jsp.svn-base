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
<!--引入DWR框架-->
<script type='text/javascript' src='${ctx}/dwr/interface/subUnitSituationService.js'></script>
<script type='text/javascript' src='${ctx}/dwr/engine.js'></script>
<script type='text/javascript' src='${ctx}/dwr/util.js'></script>

<title>域下级单位列表</title>
<script type="text/javascript">
  function toPage(currPage) {
      var totalPage = document.getElementById("totalPage").value;
      var type = document.getElementById("type").value;
      var id = document.getElementById("id").value;
      if(0 == totalPage){
          totalPage = 1;
      }
      if("number" == typeof(currPage)){
          document.getElementById("currPage").value = currPage;
          window.location.href="${ctx}/ismp/domain/local/bsam/situationAction.do?method=getSubUnitList&type="+type+"&id="+id+"&currPage="+currPage;
      }else {
          if((currPage.indexOf("-")   ==   0)||!(currPage.indexOf(".")   ==   -1)){
              alert("跳转页数只能是整数!");
          }else if (parseInt(currPage) > parseInt(totalPage) || currPage <= 0) {
              alert("输入的页数范围有误,请重新输入!");
          }else {
              document.getElementById("currPage").value = currPage;
              window.location.href="${ctx}/ismp/domain/local/bsam/situationAction.do?method=getSubUnitList&type="+type+"&id="+id+"&currPage="+currPage; 
          }
      }

  }
  //机房双击事件 后界面跳转
  function getSubSituation(type,id){
      window.location.href="${ctx}/ismp/domain/local/bsam/situationAction.do?method=getSubUnitList&type="+type+"&id="+id;
  }
///返回
  function ret(){
      window.location.href="${ctx}/ismp/domain/local/bsam/situationAction.do?method=getSecurityAreaSituationList";
  }
  //单击事件传值给Applet
  function subOnclick(id,name,scope){
      document.getElementById("situationId").style.display="";
      ///传递给Applet参数：subUnit.id,subUnit.name,subUnit.type(scope类型)
      ///(Applet中定义)scope==1表示机房，scope==2表示机柜，scope==8表示安全域,scope==16表示主机
      document.applets["situationApplet"].setActionById(id,name, scope);
      
  }
  
 </script>
</head>
<body onload="findSubUnitSituation();">
<div id="contant" class="mainbg">
    <%@ include file="/WEB-INF/content/BSAM/comm/topMenu.jsp"%>
    <div class="contant" >
        <div class="overf h20 martop10">
          <li id="m">
               <a class="mbacka" href="${ctx}/ismp/domain/local/bsam/situationAction.do?method=getSubUnitList&type=${type}&id=${id}">
                    <span class="menus10">域子单位列表</span>
               </a>
          </li>
        </div>
    
        <form name="f1" id="f1" action="/ismp/domain/local/bsam/situationAction.do?method=getSubUnitList" method="post">
               <input type="hidden" id="type" name="type" value="${type}"/>
               <input type="hidden" id="id" name="id" value="${id}"/>
               <input type="hidden" id="name" name="name" value="${name}"/>
               <input type="hidden" id="subUnitIds" name="subUnitIds" value="${subUnitIds}"/>
           <div id="data" class="greenborder overf pad1" >
                <table id="titleName" sortcol="-1">
                    <thead>
                      <tr>
                        <th style="text-align: center">${name}&nbsp;&nbsp;&nbsp;&nbsp;子单位列表</th>
                      </tr>
                    </thead>
                </table>
                <div style="height: 180px;background-color: #D8E9EC;">
                    <logic:notEmpty name="subUnitList">
                       <logic:iterate id="subUnit" name="subUnitList" indexId="i">
                            <div style="width: 100px;height: 70px;background-color: #D8E9EC;float: left;margin: 10px"  class="draggable">
<!--                                <span style="text-align: right">-->
<!--                                    <a href="#" ondblclick="getSubSituation('AnQuanYu',${domain.id})" title="${domain.domainName}" id="${domain.domainName}" >${domain.domainName}</a>-->
<!--                                </span>-->
                                <c:if test="${subUnit.type == 'JiFang'}">
                                    <a href="#" 
                                        onclick="subOnclick('${subUnit.id}','${subUnit.name}','1')"
                                        ondblclick="getSubSituation('JiFang',${subUnit.id})" title="${subUnit.name}" id="${subUnit.name}" >
                                        <img src="${ctx}/img/BSAM/lg-a.gif"  id="${subUnit.name}alert"/>
                                    </a>
                                </c:if>
                                <c:if test="${subUnit.type == 'ZhuJi'}">
                                    <a href="#" 
                                        onclick="subOnclick('${subUnit.id}','${subUnit.name}','16')"
                                        title="${subUnit.name}" id="${subUnit.name}" >
                                        <img src="${ctx}/img/BSAM/icon_03.gif"  id="${subUnit.name}alert"/>
                                    </a>
                                </c:if>
                                <br />
                                <span class="subUnitSituation" id="${subUnit.id}${subUnit.type}message">状态：安全</span>
                                <br />
                                <span class="subUnitSituation" id="${subUnit.id}${subUnit.type}situation">当前态势：0.00</span>
                                <br />
                                <span class="subUnitSituation" id="${subUnit.id}${subUnit.type}name">${subUnit.name}</span>
                            </div>
                       </logic:iterate>
                    </logic:notEmpty>    
                    <logic:empty name="subUnitList">
                                                                没有找到${name}下子单位！
                    </logic:empty>
                </div>
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
<!--                        <input id="currPage" name="currPage" type="text" size="2" class="input" value="${currPage}"/>&nbsp;-->
                    </li>
                    <li><a class="R6" href="javascript:toPage(document.getElementById('currPage').value);">GO</a></li>
                    <li><input type="button" class="R6 R7" value="返回" hidefocus="Add" onclick="ret()" /></li>
                </ul>
                <br/><br/><br/>
            <!--Applet页面-->
            <div id="situationId" style="POSITION: absolute; TOP: 360px;display: none"> 
                <jsp:include page="/WEB-INF/content/BSAM/applet/situationApplet.jsp"></jsp:include>
            </div>           
         </form>
      </div>
   </div>
</body>
<script type="text/javascript" language="javascript" defer="defer">
    function findSubUnitSituation(){
        var subUnitIds = document.getElementById("subUnitIds").value;
        subUnitSituationService.getSubUnitSituation(subUnitIds,callbackMethod);
    }
    function callbackMethod(data){
        var situations = data[0];
        var colors = data[1];
        var errorMessage = data[2];
        if(null != situations && null != colors){
            var yellow;
            var green;
            //先取得颜色值
            for(var j = 0;j < colors.length;j++){
                if(colors[j].color == 'yellow'){
                    yellow = colors[j].value;
                }
                if(colors[j].color == 'green'){
                    green = colors[j].value;
                }
            }

            if(errorMessage != "error"){
            	//循环改变当前 域下子单位的态势值
                if(situations.length > 0){
                    for(var k = 0;k < situations.length;k++){
                        var message = document.getElementById(situations[k].id + situations[k].type + "message");
                        var situation = document.getElementById(situations[k].id + situations[k].type + "situation");
                        if(situations[k].wholeSituation < green){
                            message.innerHTML = "状态：安全";
                            situation.innerHTML = "<img src='${ctx}/img/BSAM/green.jpg' height=8 width="+(70*(situations[k].wholeSituation/100)+1)+"  hspace=0 vspace=0 />" + situations[k].wholeSituation.toFixed(2);
                        }
                        if(situations[k].wholeSituation >= green && situations[k].wholeSituation <= yellow){
                            message.innerHTML = "状态：良好";
                            situation.innerHTML = "<img src='${ctx}/img/BSAM/yellow.jpg' height=8 width="+(70*(situations[k].wholeSituation/100)+1)+"  hspace=0 vspace=0 />" + situations[k].wholeSituation.toFixed(2);
                        }
                        if(situations[k].wholeSituation > yellow){
                            message.innerHTML = "状态 ： 危险";
                            situation.innerHTML = "<img src='${ctx}/img/BSAM/red.jpg' height=8 width="+(70*(situations[k].wholeSituation/100)+1)+"  hspace=0 vspace=0 />" + situations[k].wholeSituation.toFixed(2);
                        } 
                    }
                }
            }else {
                alert("后台连接失败！！");
            }

            setTimeout("findSubUnitSituation()",3000);
        }
    }
</script>
</html>  