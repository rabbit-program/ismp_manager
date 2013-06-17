<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>脆弱性分析</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript" src="${ctx}/dwr/interface/vulnAnalService.js"></script>
<script type="text/javascript" src="${ctx}/dwr/interface/assetService.js"></script>
<script type="text/javascript" src="${ctx}/dwr/engine.js"></script>
<script type="text/javascript" src="${ctx}/dwr/util.js"></script>
<script type="text/javascript">
function setAssertName(){
    var assetKindIdSelect = document.getElementById("assetKindIdSelect").value;
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
	var assetKindIdSelect = document.getElementById("assetKindIdSelect").value;
    var domain = document.getElementById("domain").value;
    if(assetKindIdSelect!=undefined && domain!=undefined)
     assetService.findByAsseKindId(domain,assetKindIdSelect,retLoadAsseList);
}

function retLoadAsseList(asseList){
    var array = [{value:'0',text:'-请选择-'}];
    var asseInfoAsseCode = document.getElementById("asseInfoAsseCode").value;
   // alert(asseInfoAsseCode);
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

function edit(dynaVulnPoinId){
    //更新操作
    vulnAnalService.findByDwr(dynaVulnPoinId,retDynaVulnPoin);
}

function retDynaVulnPoin(ret){

    var dynaVulnPoin = ret[0];
    DWRUtil.setValue("id",dynaVulnPoin[0]);
    DWRUtil.setValue("code",dynaVulnPoin[0]);
    if(dynaVulnPoin[4]!=undefined)
     DWRUtil.setValue("asseInfoBusiId",dynaVulnPoin[3]);

    DWRUtil.setValue("assetCode",ret[1]);
     
    DWRUtil.setValue("asseKnowStatVulnKindId",dynaVulnPoin[2]);

    if(dynaVulnPoin[5]!=undefined)
     DWRUtil.setValue("seriLeve",dynaVulnPoin[4]);
     
    if(dynaVulnPoin[6]!=undefined)
     DWRUtil.setValue("source",dynaVulnPoin[5]);
     
    DWRUtil.setValue("asseKnowStatVulnPoinId",dynaVulnPoin[1]);
}


function search() {
    var assetKindIdSelect = document.getElementById("assetKindIdSelect").value;
    var assetCodeSelect = document.getElementById("assetCodeSelect").value;
    if(assetKindIdSelect!='0' && assetKindIdSelect!=undefined){
        if(assetCodeSelect=='0' || assetCodeSelect==undefined){
            alert("请选择资产名称。");
            document.getElementById("assetCodeSelect").focus();
            return false;
         }
     }
    document.searchForm.action="${ctx}/ismp/domain/local/ram/VulnAnalManager.do?method=showVulnAnal&assetKindIdSelect="+assetKindIdSelect+"&assetCodeSelect="+assetCodeSelect;
    searchForm.submit();
    
  }

function selectAllDynaPoints(){
  var checkBoxList = document.all.dynaVulnPoinIds;
  if(checkBoxList.length!=undefined){
    for(i=0; i < checkBoxList.length; i++) {
           checkBoxList[i].checked = true;
    }
  }else{
      checkBoxList.checked = true;
  }
}


function selectAllDynaLeaks() {
    var checkBoxList = document.all.dynaLeakId;
      if(checkBoxList.length!=undefined){
        for(i=0; i < checkBoxList.length; i++) {
               checkBoxList[i].checked = true;
        }
      }else{
          checkBoxList.checked = true;
      }
}

function add(){
	document.getElementById("code").value="";
	document.getElementById("id").value="";
	document.getElementById("asseInfoBusiId").value="";
	document.getElementById("asseInfoProjId").value="";
	document.getElementById("assetCode").value="";
	document.getElementById("asseKnowStatVulnKindId").value="";
	document.getElementById("asseKnowStatVulnPoinId").value="";
	document.getElementById("source").value="";
	document.getElementById("seriLeve").value="";
}

function deleteDynaPoint(){
    var checkBoxList = document.all.dynaVulnPoinIds;
    var chk = false;
    if(checkBoxList.length!=undefined){
          for(var i=0;i<checkBoxList.length;i++){
              if(document.all.dynaVulnPoinIds[i].checked){
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
         var currPage =document.getElementById("currPage").value;
         var assetKindIdSelect =document.getElementById("assetKindIdSelect").value;
         var assetCodeSelect = document.getElementById("assetCodeSelect").value;
         document.asseKnowDynaVulnForm.action="${ctx}/ismp/domain/local/ram/VulnAnalManager.do?method=batchDeleteDynaPoint&assetKindIdSelect="+assetKindIdSelect+"&assetCodeSelect="+assetCodeSelect+"&currPage="+currPage;
         asseKnowDynaVulnForm.submit(); 
        }
      }else{
        alert("请选择删除记录。");
      }
}

function relateAssert(){
	 var form = document.all.asseKnowDynaVulnForm;
	 var checkBoxList = document.all.dynaVulnPoinIds;
	    var chk = false;
	     if(checkBoxList.length!=undefined){
         for(var i=0;i<checkBoxList.length;i++){
             if(document.all.dynaVulnPoinIds[i].checked){
                 chk = true;
                 break;
             }
           }
         }else{
               if(checkBoxList.checked)
                 chk = true;
         }
    
    var chk1 = chkRelatedAsseData();
    if(chk1){
        if(chk){
        	 var currPage =document.getElementById("currPage").value;
            var assetKindIdSelect =document.getElementById("assetKindIdSelect").value;
            var assetCodeSelect = document.getElementById("assetCodeSelect").value;
            var ip = document.getElementById("ip").value;
            document.asseKnowDynaVulnForm.action="${ctx}/ismp/domain/local/ram/VulnAnalManager.do?method=relateToAssert&assetKindIdSelect="+assetKindIdSelect+"&assetCodeSelect="+assetCodeSelect+"&ip="+ip+"&currPage="+currPage;
            asseKnowDynaVulnForm.submit(); 
        }else{
          alert("请选择资产要关联的脆弱点。");
        }
    }
}

function chkRelatedAsseData(){
    var ret=true;
    var assetKindIdSelect = document.getElementById("assetKindIdSelect").value;
    var assetCodeSelect = document.getElementById("assetCodeSelect").value;
    if(assetKindIdSelect=='0' || assetKindIdSelect==undefined){
        ret=false;
        alert("请选择资产类别。");
        document.getElementById("assetKindIdSelect").focus();
        return false;
     }
    if(assetCodeSelect=='0' || assetCodeSelect==undefined){
        ret=false;
        alert("请选择资产名称。");
        document.getElementById("assetCodeSelect").focus();
        return false;
     }
    return ret;
 }

function viewLeak(leakId){
	secondWindow = open("${ctx}/ismp/domain/local/ram/leakScanManager.do?method=look&leakId="+leakId,"detail","height=550,width=800,scrollbars=yes");
}

function relateLeakToAssert() {
    var checkBoxList = document.all.dynaLeakId;
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
        var assetKindIdSelect = document.getElementById("assetKindIdSelect").value;
        var assetCodeSelect = document.getElementById("assetCodeSelect").value;
        var ip = document.getElementById("ip").value;
        var currPage1 =document.getElementById("currPage1").value;
        document.VulnForm.action="${ctx}/ismp/domain/local/ram/VulnAnalManager.do?method=relateLeakToAssert&assetKindIdSelect="+assetKindIdSelect+"&assetCodeSelect="+assetCodeSelect+"&ip="+ip+"&currPage1="+currPage1;
        VulnForm.submit(); 
        
     }else{
      alert("请选择漏洞要关联的资产。");
     }
  }
}

function goIpPage() {
    var assetKindIdSelect=document.getElementById("assetKindIdSelect").value;
    var assetCodeSelect = document.getElementById("assetCodeSelect").value;
    var ip = document.getElementById("ip").value;
    window.location.href="${ctx}/ismp/domain/local/ram/VulnAnalManager.do?method=showVulnAnal"
        +"&assetKindIdSelect="+assetKindIdSelect+"&assetCodeSelect="+assetCodeSelect+"&ip="+ip;
}

function saveOrupdate(form){
	 var validate=validateAsseKnowDynaVulnForm(form);
	 if(validate==true){
		 var assetKindIdSelect=document.getElementById("assetKindIdSelect").value;
	     var assetCodeSelect = document.getElementById("assetCodeSelect").value;
	     var currPage=document.getElementById("currPage").value
	     document.saveOrupdateForm.action="${ctx}/ismp/domain/local/ram/VulnAnalManager.do?method=saveOrUpdatePoint&assetKindIdSelect="+assetKindIdSelect+"&assetCodeSelect="+assetCodeSelect+"&currPage="+currPage;
	     saveOrupdateForm.submit(); 
	 }
}

function toPage(curpage) {
	    var assetKindIdSelect=document.getElementById("assetKindIdSelect").value;
	    var assetCodeSelect = document.getElementById("assetCodeSelect").value;
	    document.getElementById("currPage").value = curpage;
	    window.location.href="${ctx}/ismp/domain/local/ram/VulnAnalManager.do?method=showVulnAnal&currPage="+curpage+"&assetKindIdSelect="+assetKindIdSelect+"&assetCodeSelect="+assetCodeSelect;
}

function toPage1(curpage1) {
    var ip = document.getElementById("ip").value;
    document.getElementById("currPage1").value = curpage1;
    window.location.href="${ctx}/ismp/domain/local/ram/VulnAnalManager.do?method=showVulnAnal&currPage1="+curpage1+"&ip="+ip;
}

function nextStep() {
    var asseInfoProjId = document.getElementById("asseInfoProjId").value;
    window.location.href="${ctx}/ismp/domain/local/ram/VulnAnalManager.do?method=nextStep&asseInfoProjId="+asseInfoProjId;
}

function view(vulnId){
    secondWindow = open("${ctx}/ismp/domain/local/ram/VulnAnalManager.do?method=look&vulnId="+vulnId,"detail","height=550,width=800,scrollbars=yes");
}

function validateAsseKnowDynaVulnForm(form){
	if (document.getElementById("assetCode").value == null
            || document.getElementById("assetCode").value == undefined
            || document.getElementById("assetCode").value == "") {
        alert("资产名称必选!");
        return false;
    }else if (document.getElementById("asseKnowStatVulnKindId").value == null
            || document.getElementById("asseKnowStatVulnKindId").value == undefined
            || document.getElementById("asseKnowStatVulnKindId").value == "") {
        alert("脆弱点类别必选!");
        return false;
    }else if (document.getElementById("asseKnowStatVulnPoinId").value == null
            || document.getElementById("asseKnowStatVulnPoinId").value == undefined
            || document.getElementById("asseKnowStatVulnPoinId").value == "") {
        alert("脆弱点必选!");
        return false;
    } else if (document.getElementById("source").value == null
            || document.getElementById("source").value == undefined
            || document.getElementById("source").value == "") {
        alert("脆弱点来源必选!");
        return false;
    }else if (document.getElementById("seriLeve").value == null
            || document.getElementById("seriLeve").value == undefined
            || document.getElementById("seriLeve").value == "") {
        alert("严重程度必选!");
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
          <td><img src="${ctx}/img/RAM/daner_bannera_08.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_09.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_10.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_11.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_12.gif" /></td>
        </tr>
      </table>
    </div>
    <h2>脆弱性分析</h2>
    <div id="data">
      <form name="searchForm" id="searchForm" action="${ctx}/ismp/domain/local/ram/VulnAnalManager.do?method=showVulnAnal" method="post">
      <div class="greenborder pad3 Height_a">
        <p>资产类别：
          <select name="assetKindIdSelect" id="assetKindIdSelect" onchange="setAssertName();" >
                      <option value="0">-请选择-</option>
                      <c:forEach items="${selectedAsseKindList }" var="selectedAsseKind" >
                          <c:choose>
                           <c:when test="${selectedAsseKind.assetKindId==asseKindSelect }">
                            <c:set var="select11" value="selected"></c:set>
                           </c:when>
                           <c:otherwise>
                            <c:set var="select11" value=""></c:set>
                           </c:otherwise>
                          </c:choose>
                         <option value="${selectedAsseKind.assetKindId}" ${select11 } >${selectedAsseKind.assetKindName }</option>
                      </c:forEach>
           </select>
          资产名称：
           <input type="hidden" name="domain" id="domain" value="${asseInfoProj.domain.id }" />
           <input type="hidden" name="asseInfoAsseCode" id="asseInfoAsseCode" value="${asseInfoAsse.assetCode }" />
            <select name="assetCodeSelect" id="assetCodeSelect">
               <option value="0">-请选择-</option>
            </select>
          <input type="button" class="submit" value="查看"  onclick="search();"/>
		 <input type="button" class="submit" value="清除"  onclick="onClean();" />
        </p>
      </div>
    </form>
      <h2 class="martop8">资产脆弱性列表</h2>
      <div class="pad1 greenborder">
    <form id="asseKnowDynaVulnForm" name="asseKnowDynaVulnForm" action="${ctx}/ismp/domain/local/ram/VulnAnalManager.do"  method="post">
        <table id="senfe" width="100%">
          <tr>
            <th><a href="javascript:selectAllDynaPoints()"><u>全选</u></a></th>
            <th>资产脆弱性编号</th>
            <th>脆弱性类别</th>
            <th>脆弱点</th>
            <th>严重程度</th>
            <th>查看</th>
          </tr>
        <c:forEach items="${vulnAnalList }" var="vulnAnal" >
          <tr>
            <td><input class="noneborder" type="checkbox" value="${vulnAnal.id}"  name="dynaVulnPoinIds" id="dynaVulnPoinIds" /></td>
            <td><a href="javascript:edit('${vulnAnal.id}')" >${vulnAnal.id}
                <c:choose>
                    <c:when test="${!empty vulnAnal.asse}">
                       (${vulnAnal.asse.asseKind.assetKindName }类)
                    </c:when>
                    <c:otherwise>
                       (未关联资产)
                    </c:otherwise>
                  </c:choose></a>
			</td>
            <td>
                <c:forEach items="${vulnKindList}" var="vulnKind">
                 <c:if  test="${vulnKind.id == vulnAnal.asseKnowStatVulnKindId}">
                  ${vulnKind.kind}
                 </c:if>
                </c:forEach>
            </td>
            <td><div class="tdcut">
                <c:forEach items="${allStatVulnPoinList}" var="vulnPoin">
                    <c:if test="${vulnPoin.id == vulnAnal.asseKnowStatVulnPoinId}">
                        ${vulnPoin.describe}
                    </c:if>
                </c:forEach>
             </div></td>
            <td>
                <c:forEach items="${dicSecuLeveList }" var="secuLeve">
                   <c:if test="${secuLeve.secuLeveId==vulnAnal.seriLeve }">
                     ${secuLeve.secuLeveName}
                   </c:if>
                </c:forEach>
            </td>
            <td><a href="javascript:view('${vulnAnal.id}')"  class="boxy"><u>查看</u></a></td>
          </tr>
        </c:forEach>
        </table>
       </form>
      </div>
      <div class="Heightlist cl">
        <ul id="page">
          <li><a href="javascript:add();" class="R6 boxy" title="添加">添加</a></li>
          <li><a href="javascript:deleteDynaPoint();" class="R6">删除</a></li>
          <li><a href="javascript:relateAssert();" class="R6 R7">与资产关联</a></li>
          <li style="margin-right:12px;"><a href="#" class="R6 R7" onclick="javascript:alert(' 高: 其安全属性破坏后可能对组织的关键业务造成比较严重的损失。 \n 中: 其安全属性破坏后可能对组织的非关键业务造成损失。\n 低: 其安全属性破坏后可能对组织造成较低的损失，甚至忽略不计。');" >定级说明</a></li>
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
       <br /> <br /><br /> 
        <h2 class="cl">资产脆弱性添加/修改</h2>
         <form action="${ctx}/ismp/domain/local/ram/VulnAnalManager.do?method=saveOrUpdatePoint&currPage=${currPage}"  method="post" id="saveOrupdateForm" name="saveOrupdateForm" onsubmit="return validateAsseKnowDynaVulnForm(this);">
			<div  id="data" class="pad1 ">
			<table>
              <tr>
                <th>动态脆弱点编号 </th>
                <td><input type="text" name="code" id="code" value="${asseKnowDynaVuln.id }" readonly/>
                  <input type="hidden" name="id" id="id" value="${asseKnowDynaVuln.id }" />
                  <input type="hidden" name="asseInfoBusiId" id="asseInfoBusiId" value="${asseKnowDynaVuln.asseInfoBusiId }" />
                  <input type="hidden" name="asseInfoProjId" id="asseInfoProjId" value="${asseInfoProj.id }" />
                </td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
			  <tr>
			    <th> 资产名称 </th>
			    <td>
                    <select name="assetCode" id="assetCode">
                      <option value="">-请选择-</option>
                       <c:forEach items="${assertList}" var="assert">
                          <c:choose>
                           <c:when test="${asseKnowDynaVuln.asse.assetCode == assert[0]}">
                            <c:set var="select6" value="selected"></c:set>
                           </c:when>
                           <c:otherwise>
                            <c:set var="select6" value=""></c:set>
                           </c:otherwise>
                          </c:choose>
                         <option value="${assert[0]}" ${select6 }>${assert[1]}</option>
                       </c:forEach>
                   </select>
                </td>
			    <th> 脆弱点类别 </th>
			    <td>
                    <select name="asseKnowStatVulnKindId" id="asseKnowStatVulnKindId" >
                     <option value="">-请选择-</option>
                      <c:forEach items="${vulnKindList}" var="vulnKind">
                          <c:choose>
                           <c:when test="${asseKnowDynaVuln.asseKnowStatVulnKindId == vulnKind.id}">
                            <c:set var="select7" value="selected"></c:set>
                           </c:when>
                           <c:otherwise>
                            <c:set var="select7" value=""></c:set>
                           </c:otherwise>
                          </c:choose>
                       <option value="${vulnKind.id}" ${select7 }>编号:${vulnKind.id}名称:${vulnKind.kind}</option>
                      </c:forEach>
                  </select>
                </td>
			  </tr>
			  <tr>
			    <th> 脆弱点 </th>
			    <td><select name="asseKnowStatVulnPoinId" id="asseKnowStatVulnPoinId"  >
                      <option value="">-请选择-</option>
                      <c:forEach items="${allStatVulnPoinList}" var="allStatVulnPoin">
                          <c:choose>
                           <c:when test="${allStatVulnPoin.id == asseKnowDynaVuln.asseKnowStatVulnPoinId}">
                            <c:set var="select8" value="selected"></c:set>
                           </c:when>
                           <c:otherwise>
                            <c:set var="select8" value=""></c:set>
                           </c:otherwise>
                          </c:choose>
                       <option value="${allStatVulnPoin.id}" ${select8 }>类别编号:${allStatVulnPoin.vulnKind.id}名称: ${fn:substring(allStatVulnPoin.describe,0,35) }...</option>
                      </c:forEach>
                    </select></td>
                     <th> 脆弱点来源 </th>
                <td><select name="source" id="source">
                      <option value="">-请选择-</option>
                          <c:choose>
                           <c:when test="${'漏洞扫描' == asseKnowDynaVuln.source}">
                            <c:set var="select10" value="selected"></c:set>
                           </c:when>
                           <c:otherwise>
                            <c:set var="select10" value=""></c:set>
                           </c:otherwise>
                          </c:choose>
                         <c:choose>
                           <c:when test="${'知识库' == asseKnowDynaVuln.source}">
                            <c:set var="select11" value="selected"></c:set>
                           </c:when>
                           <c:otherwise>
                            <c:set var="select11" value=""></c:set>
                           </c:otherwise>
                          </c:choose>
                      <option value="知识库" ${select11 }>-知识库-</option>
                      <option value="漏洞扫描" ${select10 }>-漏洞扫描-</option>
                  </select></td>
			  </tr>
			  <tr>
			    <th> 严重程度 </th>
			    <td><select name="seriLeve" id="seriLeve">
                       <option value="">-请选择-</option>
                       <c:forEach items="${dicSecuLeveList }" var="secuLeve">
                         <c:choose>
                           <c:when test="${secuLeve.secuLeveId == asseKnowDynaVuln.seriLeve}">
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
			    <td height="35" colspan="4"><input name="提交" type="button" class="submit" value="保存" onclick="saveOrupdate(this)"/></td>
			  </tr>
			  </table>
			
			</div>
        </form>

      <div class="paddiv"></div>
      <h2 class="cl">资产漏洞列表</h2>
      <div class="greenborder pad3 Height_a">
        <p>IP地址选择：
           <select name="ip" id="ip" onchange="goIpPage()">
                   <option >-请选择-</option>
                     <c:forEach items="${ipList }" var="ip">
                        <c:choose>
                         <c:when test="${ip == ipAddress }">
                           <c:set var="ipSelect" value="selected"></c:set>
                         </c:when>
                         <c:otherwise>
                           <c:set var="ipSelect" value=""></c:set>
                         </c:otherwise>
                        </c:choose>
                     <option value="${ip}"  ${ipSelect } >
                        ${ip }
                     </option>
                    </c:forEach>
                 </select>
        </p>
      </div>
      <div class="pad1 greenborder">
       <form id="VulnForm" name="VulnForm" action="${ctx}/ismp/domain/local/ram/VulnAnalManager.do" method="post">
        <table id="senfesub" width="100%">
          <tr>
            <th><a href="javascript:selectAllDynaLeaks()"><u>全选</u></a></th>
            <th>资产</th>
            <th>漏洞类别</th>
            <th>漏洞名称</th>
            <th>安全级别</th>
            <th>查看</th>
          </tr>
         <c:forEach items="${dynaLeakList }" var="dynaLeak" >
          <tr>
            <td><input type="checkBox" class="noneborder" name="dynaLeakId" id="dynaLeakId" value="${dynaLeak.id}" /></td>
            <td> <c:forEach items="${dynaLeakAsseList}" var="assert">
                     <c:if test="${dynaLeak.asse.assetCode == assert.assetCode}">
                        ${assert.assetName}
                     </c:if>
                 </c:forEach></td>
            <td><c:forEach items="${vulnKindList}" var="vulnKind">
                          <c:if test="${dynaLeak.asseKnowStatVulnKindId == vulnKind.id}">
                                                                                         编号:${vulnKind.id}名称:${vulnKind.kind}
                          </c:if>
                      </c:forEach></td>
            <td><div class="tdcut"> ${fn:substring(dynaLeak.location,0,26) }...</div></td>
            <td> 
            <select name="secuLeves" id="secuLeves">
            <c:forEach items="${dicSecuLeveList }" var="secuLeve">
                        <c:choose>
                           <c:when test="${secuLeve.secuLeveId == dynaLeak.seriLeve}">
                            <c:set var="selectx3" value="selected"></c:set>
                           </c:when>
                           <c:otherwise>
                            <c:set var="selectx3" value=""></c:set>
                           </c:otherwise>
                          </c:choose>
                         <option value="${secuLeve.secuLeveId}"   ${selectx3 }> ${secuLeve.secuLeveName}</option>
                 </c:forEach>
            </select></td>
            <!-- view2.html -->
            <td><a href="javascript:viewLeak('${dynaLeak.infoLeakId}')" title="资产脆弱性查看" class="boxy"><u>查看</u></a></td>
          </tr>
        </c:forEach>
        </table>
        </form>
      </div>
      <div class="Heightlist cl">
        <ul id="page">
          <li><a href="javascript:relateLeakToAssert();" class="R6 R7">与资产关联</a></li>
          <li style="margin-right:12px;"><a href="#" class="R6 R7"  onclick="javascript:alert(' 高: 其安全属性破坏后可能对组织的关键业务造成比较严重的损失\n 中: 其安全属性破坏后可能对组织的非关键业务造成损失 \n 低: 其安全属性破坏后可能对组织造成较低的损失，甚至忽略不计');">定级说明</a></li>
           <li><a class="first" href="javascript:toPage1(1);"></a></li>
          <c:if test="${currPage1>1 }">
              <li><a class="pre" href="javascript:toPage1(${currPage1-1 });"></a></li>
          </c:if>
          <c:if test="${currPage1<totalPage1 }">
              <li><a class="next" href="javascript:toPage1(${currPage1+1 });"></a></li>
          </c:if>
          <li><a class="last" href="javascript:toPage1(${totalPage1 });"></a></li>
          <li>
                                                      共 ${totalPage1 } 页 跳至
              <input id="currPage1" name="currPage1" type="text" size="2" class="input" value="${currPage1 }"/>
              &nbsp;
          </li>
          <li><a class="R6" href="javascript:toPage1(document.getElementById('currPage1').value);">GO</a></li>

        </ul>
      </div>
    </div>
    <div style="margin:0 auto; padding-top:12px; width:120px; height:30px; clear:both;"><a href="javascript:nextStep();" class="R6">下一步</a></div>
  </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
