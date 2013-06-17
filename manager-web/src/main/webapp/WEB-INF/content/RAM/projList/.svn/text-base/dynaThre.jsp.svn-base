<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>威胁分析 </title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript" src="${ctx}/dwr/interface/assetService.js"></script>
<script type="text/javascript" src="${ctx}/dwr/interface/threAnalService.js"></script>
<script type="text/javascript" src="${ctx}/dwr/interface/statThreService.js"></script>
<script type="text/javascript" src="${ctx}/dwr/engine.js"></script>
<script type="text/javascript" src="${ctx}/dwr/util.js"></script>
<script type="text/javascript">
function selectAllDynaThres(){
 
    var checkBoxList = document.all.dynaThreIds;
  if(checkBoxList.length!=undefined){
    for(i=0; i < checkBoxList.length; i++) {
           checkBoxList[i].checked = true;
    }
  }else{
      checkBoxList.checked = true;
  }
}

function deleteDynaThre(){
    var checkBoxList = document.all.dynaThreIds;
    var chk = false;
    if(checkBoxList.length!=undefined){
          for(var i=0;i<checkBoxList.length;i++){
              if(document.all.dynaThreIds[i].checked){
                  chk = true;
                  break;
              }
            }
          }else{
                if(checkBoxList.checked)
                  chk = true;
          }
    if(chk){
        
        if(window.confirm("确定要删除吗？")){
            var currPage=document.getElementById("currPage").value
            var assetKindIdSelect = $("assetKindIdSelect").value;
            var assetCodeSelect = $("assetCodeSelect").value;
        	document.asseKnowDynaThreForm.action="${ctx}/ismp/domain/local/ram/ThreAnalManager.do?method=batchDeleteDynaThre&currPage="+currPage+"&assetKindIdSelect="+assetKindIdSelect+"&assetCodeSelect="+assetCodeSelect;
        	asseKnowDynaThreForm.submit(); 
        }
      }else{
        alert("请选择删除记录。");
      }
}

function search() {
    var form = document.all.searchForm;
    var assetKindIdSelect = document.getElementById("assetKindIdSelect").value;
    var assetCodeSelect = document.getElementById("assetCodeSelect").value;
    if(assetKindIdSelect!='0' && assetKindIdSelect!=undefined){
        if(assetCodeSelect=='0' || assetCodeSelect==undefined){
            alert("请选择资产名称。");
            document.getElementById("assetCodeSelect").focus();
            return false;
         }
     }
    var currPage=document.getElementById("currPage").value
    document.searchForm.action="${ctx}/ismp/domain/local/ram/ThreAnalManager.do?method=showThreAnal&currPage="+currPage+"&assetKindIdSelect="+assetKindIdSelect+"&assetCodeSelect="+assetCodeSelect;
    searchForm.submit(); 
    
  }

function chkRelatedAsseData(){
    var ret=true;
    var assetKindIdSelect = $("assetKindIdSelect").value;
    var assetCodeSelect = $("assetCodeSelect").value;
    if(assetKindIdSelect=='0' || assetKindIdSelect==undefined){
        ret=false;
        alert("请选择资产类别。");
        $("assetKindIdSelect").focus();
        return false;
     }
    if(assetCodeSelect=='0' || assetCodeSelect==undefined){
        ret=false;
        alert("请选择资产名称。");
        $("assetCodeSelect").focus();
        return false;
     }
    return ret;
 }

function relateAssert(){
    var checkBoxList = document.all.dynaThreIds;
    var chk1 = false;
    if(checkBoxList.length!=undefined){
      for(i=0;i<checkBoxList.length;i++){
          if(checkBoxList[i].checked){
              chk1 = true;
              break;
          }
      }
    }else{
        if(checkBoxList.checked)
            chk1 = true;
    }
    
    var chk = chkRelatedAsseData();
    if(chk){
        if(chk1){
        	var currPage=document.getElementById("currPage").value
            var assetKindIdSelect = $("assetKindIdSelect").value;
            var assetCodeSelect = $("assetCodeSelect").value;
            document.asseKnowDynaThreForm.action="${ctx}/ismp/domain/local/ram/ThreAnalManager.do?method=relateToAssert&currPage="+currPage+"&assetKindIdSelect="+assetKindIdSelect+"&assetCodeSelect="+assetCodeSelect;
            asseKnowDynaThreForm.submit(); 
        }else{
          alert("请选择资产要关联的脆弱点。");
      }
    }
}

function setAssertName(){
    var assetKindIdSelect =document.getElementById("assetKindIdSelect").value;
    var domain = document.getElementById("domain").value;
    if(assetKindIdSelect!=undefined && domain!=undefined)
     assetService.findByAsseKindId(domain,assetKindIdSelect,retAsseList);
}

function retAsseList(asseList){
    var array = [{value:'0',text:'-请选择-'}];
    if(asseList!=undefined) {
     DWRUtil.removeAllOptions("assetCodeSelect");
     DWRUtil.addOptions("assetCodeSelect",array,"value","text");
     for(i=0;i<asseList.length;i++) {
         var obj = asseList[i];
         var array1 = [{value:obj[0],text:obj[1]}];
         DWRUtil.addOptions("assetCodeSelect",array1,"value","text");
     }
    }else{
     DWRUtil.removeAllOptions("assetCodeSelect");
     DWRUtil.addOptions("assetCodeSelect",array,"value","text");
    }
}

function loadAssetName(){
    var assetKindIdSelect =document.getElementById("assetKindIdSelect").value;
    var domain = document.getElementById("domain").value;
    if(assetKindIdSelect!=undefined && domain!=undefined)
     assetService.findByAsseKindId(domain,assetKindIdSelect,retLoadAsseList);
    
    
}

function retLoadAsseList(asseList){
    var array = [{value:'0',text:'-请选择-'}];
    var asseInfoAsseCode = document.getElementById("asseInfoAsseCode").value;
    //alert(asseInfoAsseCode);
    if(asseList!=undefined) {
     DWRUtil.removeAllOptions("assetCodeSelect");
     DWRUtil.addOptions("assetCodeSelect",array,"value","text");
     
     for(i=0;i<asseList.length;i++) {
         var obj = asseList[i];
         var array1 = [{value:obj[0],text:obj[1]}];
         DWRUtil.addOptions("assetCodeSelect",array1,"value","text");
     }
     
     DWRUtil.setValue("assetCodeSelect",asseInfoAsseCode);
    }else{
     
     DWRUtil.removeAllOptions("assetCodeSelect");
     DWRUtil.addOptions("assetCodeSelect",array,"value","text");
    }
}


function edit(dynaThreId){
    //更新操作
    //alert(dynaThreId);
    threAnalService.findByDwr(dynaThreId,retDynaThre);
}

function retDynaThre(dynaThre){
	DWRUtil.setValue("id",dynaThre[0]);
    DWRUtil.setValue("code",dynaThre[0]);
    DWRUtil.setValue("threCode",dynaThre[4]);
    if(dynaThre[2]!=undefined){
        DWRUtil.setValue("asseDynaVulnPoinId",dynaThre[2]);
    }
    if(dynaThre[1]!=undefined){
        DWRUtil.setValue("assetCode",dynaThre[1]);
    }
    DWRUtil.setValue("asseKnowStatThreKindId",dynaThre[5]);
    DWRUtil.setValue("possibility",dynaThre[6]);
    DWRUtil.setValue("asseKnowStatThreId",dynaThre[3]);
}

function setStatThreCode(){
    var form = document.all.saveForm;
    var threId = form.asseKnowStatThreId.value;
    statThreService.find(threId,retStatThre);
}

function retStatThre(statThre) {
    DWRUtil.setValue("threCode",statThre.threCode);
}

function addDynaThre(){
    document.getElementById("id").value="";
    document.getElementById("code").value="";
    document.getElementById("threCode").value="";
    document.getElementById("assetCode").value="";
    document.getElementById("asseKnowStatThreKindId").value="";
    document.getElementById("asseKnowStatThreId").value="";
    document.getElementById("possibility").value="";
    document.getElementById("asseDynaVulnPoinId").value="";
}

function toPage(curpage) {
    document.getElementById("currPage").value = curpage;
    var assetKindIdSelect = $("assetKindIdSelect").value;
    var assetCodeSelect = $("assetCodeSelect").value;
    window.location.href="${ctx}/ismp/domain/local/ram/ThreAnalManager.do?method=showThreAnal&currPage="+curpage+"&assetKindIdSelect="+assetKindIdSelect+"&assetCodeSelect="+assetCodeSelect;
}

function nextStep() {
    window.location.href="${ctx}/ismp/domain/local/ram/VulnThreRelaManager.do?method=showVulnThre";
}

function validateAsseKnowDynaThreForm(form){
    if (document.getElementById("assetCode").value == null
            || document.getElementById("assetCode").value == undefined
            || document.getElementById("assetCode").value == "") {
        alert("资产名称必选!");
        return false;
    }else if (document.getElementById("asseKnowStatThreKindId").value == null
            || document.getElementById("asseKnowStatThreKindId").value == undefined
            || document.getElementById("asseKnowStatThreKindId").value == "") {
        alert("威胁类别必选!");
        return false;
    }else if (document.getElementById("asseKnowStatThreId").value == null
            || document.getElementById("asseKnowStatThreId").value == undefined
            || document.getElementById("asseKnowStatThreId").value == "") {
        alert("威胁点必选!");
        return false;
    } else if (document.getElementById("possibility").value == null
            || document.getElementById("possibility").value == undefined
            || document.getElementById("possibility").value == "") {
        alert("安全事件发生可能性必选!");
        return false;
    }else {
        return true;
    }
}
function onClean(){
    document.getElementById("assetKindIdSelect").value =0;
    document.getElementById("assetCodeSelect").value =0;
}
</script>
</head>
<body onload="loadAssetName();">
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" >
    <li class="act" id="m"><a href="#"><span style="background:url(${ctx}/img/comm/other/01.gif) no-repeat; padding-left:22px;">风险评估</span></a></li>
  </div>
  <div class="contant pad3 overf">
    <div class="overf pad3  martop10" >
      <table width="100%">
        <tr>
          <td><img src="${ctx}/img/RAM/danger_banner_01.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_02.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_03.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_05.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_06.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_07.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_08.gif" /></td>
          <td><img src="${ctx}/img/RAM/daner_bannera_09.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_10.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_11.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_12.gif" /></td>
        </tr>
      </table>
    </div>
    <h2> 威胁分析 </h2>
    <div id="data">
      <form name="searchForm" id="searchForm" action="${ctx}/ismp/domain/local/ram/ThreAnalManager.do?method=showThreAnal" method="post">
      <div class="greenborder pad3 Height_a">
        <p>资产类别：<select name="assetKindIdSelect" id="assetKindIdSelect" onchange="setAssertName();" >
                      <option value="0">-请选择-</option>
                      <c:forEach items="${selectedAsseKindList }" var="selectedAsseKind" >
                          <c:choose>
                           <c:when test="${selectedAsseKind.assetKindId==assetKindIdSelect }">
                            <c:set var="select1" value="selected"></c:set>
                           </c:when>
                           <c:otherwise>
                            <c:set var="select1" value=""></c:set>
                           </c:otherwise>
                          </c:choose>
                         <option value="${selectedAsseKind.assetKindId}" ${select1 } >${selectedAsseKind.assetKindName }</option>
                      </c:forEach>
                    </select>
          <input type="hidden" name="domain" id="domain" value="${asseInfoProj.domain.id }" />
                            资产名称：<input type="hidden" name="asseInfoAsseCode" id="asseInfoAsseCode" value="${asseInfoAsse.assetCode }" />
                     <select name="assetCodeSelect" id="assetCodeSelect">
                    <option value="0">-请选择-</option>
                 </select>
         <input type="button" class="submit" value="查看" onclick="search();"/>
         <input type="button" class="submit" value="清除"  onclick="onClean();"/>
</p>
      </div>      
      </form>
      <h2 class="martop8"> 威胁性分析列表 </h2>
      <div class="pad1 greenborder">
        <form action="/ismp/domain/local/ram/ThreAnalManager.do"  id="asseKnowDynaThreForm" name="asseKnowDynaThreForm" method="post">
        <table id="senfe" width="100%">
          <tr>
            <th><a href="javascript:selectAllDynaThres()"><u>全选</u></a></th>
            <th> 动态威胁编号 </th>
            <th> 威胁类别 </th>
            <th> 威胁点 </th>
            <th> 安全事件可能性 </th>
          </tr>
          <c:forEach items="${threAnalList }" var="threAnal" >
          <tr>              
            <td><input class="noneborder" type="checkbox" name="dynaThreIds" id="dynaThreIds" value="${threAnal.id}" /></td>
            <td><a href="javascript:edit('${threAnal.id}')" >${threAnal.id}</a>
                    <c:choose>
                    <c:when test="${!empty threAnal.asse}">
                       (已关联${threAnal.asse.asseKind.assetKindName }类资产)
                    </c:when>
                    <c:otherwise>
                       (未关联资产)
                    </c:otherwise>
                    </c:choose></td>
            <td><select name="statThreKindIds" id="statThreKindIds" style="width:130px" disabled="disabled">
                      <c:forEach items="${statThreKindList}" var="threKind">
                       <c:choose>
                         <c:when test="${threKind.id == threAnal.asseKnowStatThreKindId}">
                             <c:set var="select3" value="selected"></c:set>
                         </c:when>
                         <c:otherwise>
                             <c:set var="select3" value=""></c:set>
                          </c:otherwise>
                       </c:choose>
                       <option value="${threKind.id}" ${select3}>${threKind.kind}</option>
                      </c:forEach>
                  </select></td>
            <td><div class="tdcut"> 
            <select name="statThreIds" id="statThreIds" style="width:200px" disabled="disabled">
                     <c:forEach items="${statThreList}" var="thre">
                       <c:choose>
                         <c:when test="${thre.id == threAnal.asseKnowStatThreId}">
                             <c:set var="select3" value="selected"></c:set>
                         </c:when>
                         <c:otherwise>
                             <c:set var="select3" value=""></c:set>
                          </c:otherwise>
                       </c:choose>
                       <option value="${thre.id}" ${select3}>${thre.threat}</option>
                      </c:forEach>
                  </select>
            </div></td>
            <td><select name="possibilities" id="possibilities" style="width:150px" disabled="disabled">
                  <c:forEach items="${dicSecuLeveList }" var="secuLeve">
                   <c:choose>
                   <c:when test="${secuLeve.secuLeveId==threAnal.possibility }">
                     <c:set var="select5" value="selected" />
                   </c:when>
                   <c:otherwise>
                     <c:set var="select5" value=""></c:set>
                   </c:otherwise>
                   </c:choose>
                   <option value="${secuLeve.secuLeveId}" ${select5}>${secuLeve.secuLeveName}</option>
                   </c:forEach>
                   </select></td>
          </tr>
         </c:forEach>
        </table>
        </form>
      </div>
      <div class="Heightlist cl">     
      <ul id="page">
        <li><a href="javascript:addDynaThre();" class="R6 boxy" title="添加">添加</a></li>
        <li><a href="javascript:deleteDynaThre();" class="R6">删除</a></li>
        <li><a href="javascript:relateAssert();" class="R6 R7">与资产关联</a></li>
        <li style="margin-right:12px;"><a href="#" class="R6 R7"  onclick="javascript:alert(' 高: 其安全属性破坏后可能对组织的关键业务造成比较严重的损失。\n 中: 其安全属性破坏后可能对组织的非关键业务造成损失 。\n 低: 其安全属性破坏后可能对组织造成较低的损失，甚至忽略不计。');" >定级说明</a></li>
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
      </div>       
    </div>
    <br/><br/>    <br/><br/> 
    <h2>资产威胁添加/修改</h2>
	<div  id="data" class="pad1 ">
    <form action="${ctx}/ismp/domain/local/ram/ThreAnalManager.do?method=saveOrUpdateThre&currPage=${currPage}" method="post" id="saveForm" name="saveForm" onsubmit="return validateAsseKnowDynaThreForm(this);">
	<table>
        <tr>
        <th>动态威胁编号</th>
        <td><input type="text" name="code" id="code" value="${asseKnowDynaThre.id }" readonly/> </td>
                  <input type="hidden" name="id" id="id" value="${asseKnowDynaThre.id }" />
                  <input type="hidden" name="asseInfoProjId" id="asseInfoProjId" value="${asseInfoProj.id }" />
                 <input type="hidden" name="asseDynaVulnPoinId" id="asseDynaVulnPoinId" value="${asseKnowDynaThre.dynaVuln.id }" />
        <th> 静态威胁编号 </th>
        <td><input type="text" name="threCode" id="threCode" value="${asseKnowDynaThre.threCode }" readonly/></td>
      </tr>
	  <tr>
	    <th> 资产名称 </th>
	    <td><select name="assetCode" id="assetCode">
                      <option value="">-请选择-</option>
                       <c:forEach items="${assertList}" var="assert">
                          <c:choose>
                           <c:when test="${asseKnowDynaThre.asse.assetCode == assert[0]}">
                            <c:set var="select6" value="selected"></c:set>
                           </c:when>
                           <c:otherwise>
                            <c:set var="select6" value=""></c:set>
                           </c:otherwise>
                          </c:choose>
                         <option value="${assert[0]}" ${select6 }>${assert[1]}</option>
                       </c:forEach>
                   </select></td>
	    <th> 威胁类别 </th>
	    <td><select name="asseKnowStatThreKindId" id="asseKnowStatThreKindId"  style="width:180px">
                     <option value="">-请选择-</option>
                      <c:forEach items="${statThreKindList}" var="threKind">
                          <c:choose>
                           <c:when test="${asseKnowDynaThre.asseKnowStatThreKindId == threKind.id}">
                            <c:set var="select7" value="selected"></c:set>
                           </c:when>
                           <c:otherwise>
                            <c:set var="select7" value=""></c:set>
                           </c:otherwise>
                          </c:choose>
                       <option value="${threKind.id}" ${select7 }>编号:${threKind.id}名称:${threKind.kind}</option>
                      </c:forEach>
                  </select></td>
	  </tr>
	  <tr>
	    <th> 威胁点 </th>
	    <td><select name="asseKnowStatThreId" id="asseKnowStatThreId"  onchange="setStatThreCode();"  style="width:180px">
                      <option value="">-请选择-</option>
                      <c:forEach items="${statThreList}" var="allStatThre">
                          <c:choose>
                           <c:when test="${allStatThre.id == asseKnowDynaThre.asseKnowStatThreId}">
                            <c:set var="select8" value="selected"></c:set>
                           </c:when>
                           <c:otherwise>
                            <c:set var="select8" value=""></c:set>
                           </c:otherwise>
                          </c:choose>
                       <option value="${allStatThre.id}" ${select8 }>类别编号:${allStatThre.threKind.id}名称:${allStatThre.threat}</option>
                      </c:forEach>
                    </select></td>
	    <th> 安全事件发生可能性 </th>
	    <td><select name="possibility" id="possibility" style="width:180px">
                       <option value="">-请选择-</option>
                       <c:forEach items="${dicSecuLeveList }" var="secuLeve">
                         <c:choose>
                           <c:when test="${secuLeve.secuLeveId == asseKnowDynaThre.possibility}">
                            <c:set var="select9" value="selected"></c:set>
                           </c:when>
                           <c:otherwise>
                            <c:set var="select9" value=""></c:set>
                           </c:otherwise>
                          </c:choose>
                         <option value="${secuLeve.secuLeveId}" ${select9 }>${secuLeve.secuLeveName}</option>
                       </c:forEach>
                  </select></td>
	  </tr>
	  <tr>
	    <td height="35" colspan="4"><input name="提交" type="submit" class="submit" value="保存" /></td>
	  </tr>
	  </table>
	</form>
	</div>


    <div style="margin:0 auto; padding-top:12px; width:120px; height:30px; clear:both;"><a href="javascript:nextStep();" class="R6">下一步</a></div>
  </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
