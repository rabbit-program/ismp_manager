<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>脆弱点与威胁关联</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript" src="${ctx}/dwr/interface/threAnalService.js"></script>
<script type="text/javascript" src="${ctx}/dwr/interface/statThreService.js"></script>
<script type="text/javascript" src="${ctx}/dwr/interface/vulnAnalService.js"></script>
<script type="text/javascript" src="${ctx}/dwr/engine.js"></script>
<script type="text/javascript" src="${ctx}/dwr/util.js"></script>
<script type="text/javascript">
function setVulnName(){
    var vulnKindIdSelect=$("vulnKindIdSelect").value;
    var asseInfoProjId=document.getElementById("asseInfoProjId").value;
    vulnAnalService.listDynaVulnPointByKindDwr(asseInfoProjId,vulnKindIdSelect,retDynaVulnPoin);
}

function retDynaVulnPoin(dynaVulnPoinList){
    var array = [{value:'',text:'-请选择-'}];
    if(dynaVulnPoinList!=undefined) {
     DWRUtil.removeAllOptions("vulnIdSelect");
     DWRUtil.addOptions("vulnIdSelect",array,"value","text");
     for(i=0;i<dynaVulnPoinList.length;i++) {
         var obj = dynaVulnPoinList[i];
         var array1 = [{value:obj,text:obj}];
         DWRUtil.addOptions("vulnIdSelect",array1,"value","text");
     }
    }else{
     DWRUtil.removeAllOptions("vulnIdSelect");
     DWRUtil.addOptions("vulnIdSelect",array,"value","text");
    }
}

function viewLeak(leakId){
	//alert(leakId);
	 secondWindow = open("${ctx}/ismp/domain/local/ram/leakScanManager.do?method=look&leakId="+leakId,"detail","height=550,width=800,scrollbars=yes");
}

function viewDynaVulnThre(dynaVulnThreId){
    secondWindow = open("${ctx}/ismp/domain/local/ram/VulnThreRelaManager.do?method=look&dynaVulnThreId="+dynaVulnThreId,"detail","height=550,width=800,scrollbars=yes");
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


function loadVulnName(){
	 var vulnKindIdSelect=$("vulnKindIdSelect").value;
	 var asseInfoProjId=document.getElementById("asseInfoProjId").value;
    if(vulnKindIdSelect!=undefined)
    	vulnAnalService.listDynaVulnPointByKindDwr(asseInfoProjId,vulnKindIdSelect,retLoadDynaVulnPoin);
}

function retLoadDynaVulnPoin(dynaVulnPoinList){
    var array = [{value:'',text:'-请选择-'}];
    var vulnPointId = document.getElementById("vulnPointId").value;
    if(dynaVulnPoinList!=undefined) {
        DWRUtil.removeAllOptions("vulnIdSelect");
        DWRUtil.addOptions("vulnIdSelect",array,"value","text");
        for(i=0;i<dynaVulnPoinList.length;i++) {
            var obj = dynaVulnPoinList[i];
            var array1 = [{value:obj,text:obj}];
            DWRUtil.addOptions("vulnIdSelect",array1,"value","text");
        }
        DWRUtil.setValue("vulnIdSelect",vulnPointId);
       }else{
        
        DWRUtil.removeAllOptions("vulnIdSelect");
        DWRUtil.addOptions("vulnIdSelect",array,"value","text");
       }
}



function setStatThreCode(){
    var form = document.all.asseKnowDynaThreForm;
    var threId = form.asseKnowStatThreId.value;
    statThreService.find(threId,retStatThre);
}

function retStatThre(statThre) {
    DWRUtil.setValue("threCode",statThre.threCode);
}

function search() {
    var form = document.all.searchForm;
    var vulnKindIdSelect = document.getElementById("vulnKindIdSelect").value;
    var vulnIdSelect = document.getElementById("vulnIdSelect").value;
    if(vulnKindIdSelect!='0' && vulnKindIdSelect!=undefined){
        if(vulnIdSelect=='' || vulnIdSelect==undefined){
            alert("请选择动态脆弱点Id。");
            document.getElementById("vulnIdSelect").focus();
            return false;
         }
     }
    form.submit();
  }

function chkRelatedVulnData(){
    var ret=true;
    var vulnKindIdSelect = $("vulnKindIdSelect").value;
    var vulnIdSelect = $("vulnIdSelect").value;
    if(vulnKindIdSelect=='0' || vulnKindIdSelect==undefined){
        ret=false;
        alert("请选择脆弱点类别。");
        $("vulnKindIdSelect").focus();
        return false;
     }
    if(vulnIdSelect=='' || vulnIdSelect==undefined){
        ret=false;
        alert("请选择动态脆弱点Id。");
        $("vulnIdSelect").focus();
        return false;
     }
    return ret;
 }

function relateToVuln(){
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
    
    var chk = chkRelatedVulnData();
    if(chk){
        if(chk1){
        	var currPage= document.getElementById("currPage").value;
            var vulnKindIdSelect = $("vulnKindIdSelect").value;
            var vulnIdSelect = $("vulnIdSelect").value;
            document.dynathre.action="${ctx}/ismp/domain/local/ram/VulnThreRelaManager.do?method=relateToVuln&vulnKindIdSelect="+vulnKindIdSelect+"&vulnIdSelect="+vulnIdSelect+"&currPage="+currPage;
            dynathre.submit(); 
        }else{
          alert("请选择威胁要关联的动态脆弱点。");
      }
    }
}

function relateLeakToThre() {
    var form = document.all.relateLeakToThre;
    var checkBoxList = document.all.leakThreId;
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

    if(chk1){
        var action=form.action;
        var vulnKindIdSelect = $("vulnKindIdSelect").value;
        var vulnIdSelect = $("vulnIdSelect").value;
        var ip = document.getElementById("ip").value;
        action+="&vulnKindIdSelect="+vulnKindIdSelect+"&vulnIdSelect="+vulnIdSelect+"&ip="+ip;
        form.action=action;
        form.submit();
    }else{
      alert("请选择漏洞要关联的威胁。");
   }
    
}

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

function selectAllDynaLeakThres() {
    var checkBoxList = document.all.leakThreId;
      if(checkBoxList.length!=undefined){
        for(i=0; i < checkBoxList.length; i++) {
               checkBoxList[i].checked = true;
        }
      }else{
          checkBoxList.checked = true;
      }
}

function addDynaVulnThre(){
    DWRUtil.setValue("id","");
    DWRUtil.setValue("code","");
    DWRUtil.setValue("threCode","");
    DWRUtil.setValue("asseDynaVulnPoinId","");
    DWRUtil.setValue("assetCode","");
    DWRUtil.setValue("asseKnowStatThreKindId","");
    DWRUtil.setValue("asseKnowStatThreId","");
    DWRUtil.setValue("possibility","");
   
}

function nextStep(){
    window.location.href="${ctx}/ismp/domain/local/ram/CalManager.do?method=preCal";
}

function goIpPage() {
    var vulnKindIdSelect=document.getElementById("vulnKindIdSelect").value;
    var vulnIdSelect = document.getElementById("vulnIdSelect").value;
    var ip = document.getElementById("ip").value;
    window.location.href="${ctx}/ismp/domain/local/ram/VulnThreRelaManager.do?method=showVulnThre&vulnKindIdSelect="+vulnKindIdSelect+"&vulnIdSelect="+vulnIdSelect+"&ip="+ip;
}


function toPage(curpage) {
    document.getElementById("currPage").value = curpage;
    var vulnKindIdSelect=document.getElementById("vulnKindIdSelect").value;
    var vulnIdSelect = document.getElementById("vulnIdSelect").value;
    window.location.href="${ctx}/ismp/domain/local/ram/VulnThreRelaManager.do?method=showVulnThre&currPage="+curpage+"&vulnKindIdSelect="+vulnKindIdSelect+"&vulnIdSelect="+vulnIdSelect;
}

function toPage1(curpage1) {
    document.getElementById("currPage1").value = curpage1;
    var ip = document.getElementById("ip").value;
    window.location.href="${ctx}/ismp/domain/local/ram/VulnThreRelaManager.do?method=showVulnThre&currPage1="+curpage1+"&ip="+ip;
}

function validateAsseKnowDynaVulnThreForm(form){
   if (document.getElementById("asseDynaVulnPoinId").value == null
            || document.getElementById("asseDynaVulnPoinId").value == undefined
            || document.getElementById("asseDynaVulnPoinId").value == "") {
        alert("动态脆弱点编号必选!");
        return false;
    } else if (document.getElementById("possibility").value == null
            || document.getElementById("possibility").value == undefined
            || document.getElementById("possibility").value == "") {
        alert("安全事件发生可能性必选!");
        return false;
    }else if (document.getElementById("asseKnowStatThreKindId").value == null
            || document.getElementById("asseKnowStatThreKindId").value == undefined
            || document.getElementById("asseKnowStatThreKindId").value == "") {
        alert("威胁类别必选!");
        return false;
    }else if (document.getElementById("asseKnowStatThreId").value == null
            || document.getElementById("asseKnowStatThreId").value == undefined
            || document.getElementById("asseKnowStatThreId").value == "") {
        alert("威胁名称必选!");
        return false;
    }else {
        return true;
    }
}

function onClean(){
    document.getElementById("vulnKindIdSelect").value =0;
    document.getElementById("vulnIdSelect").value ="";
}
</script>
</head>
<body onload="loadVulnName();">
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
          <td><img src="${ctx}/img/RAM/danger_banner_09.gif" /></td>
          <td><img src="${ctx}/img/RAM/daner_bannera_10.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_11.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_12.gif" /></td>
        </tr>
      </table>
    </div>
    <h2> 脆弱性威胁关联 </h2>
    <div id="data">
      <form name="searchForm" id="searchForm" action="${ctx}/ismp/domain/local/ram/VulnThreRelaManager.do?method=showVulnThre" method="post">
      <div class="greenborder pad3 Height_a">
        <p>脆弱点类别：
          <select name="vulnKindIdSelect" id="vulnKindIdSelect" onchange="setVulnName();" >
                      <option value="0">-请选择-</option>
                      <c:forEach items="${statVulnKindList }" var="selectedVulnKind" >
                          <c:choose>
                           <c:when test="${selectedVulnKind.id==vulnKindSelect }">
                            <c:set var="select1" value="selected"></c:set>
                           </c:when>
                           <c:otherwise>
                            <c:set var="select1" value=""></c:set>
                           </c:otherwise>
                          </c:choose>
                         <option value="${selectedVulnKind.id}" ${select1 } >${selectedVulnKind.id}:${selectedVulnKind.kind }</option>
                      </c:forEach>
                    </select>
          动态脆弱点Id：
          <input type="hidden" name="vulnPointId" id="vulnPointId" value="${vulnPoint.id }" />
               <select name="vulnIdSelect" id="vulnIdSelect"  >
                <option value="">-请选择-</option>
               </select>
          <input type="button" class="submit" value="查看" onclick="search();"  />
         <input type="button" class="submit" value="清除"  onclick="onClean();"/>
        </p>
      </div>
      </form>
      <h2 class="martop8"> 脆弱性威胁关联列表 </h2>
      <div class="pad1 greenborder">
      <form action="${ctx}/ismp/domain/local/ram/VulnThreRelaManager.do?method=showVulnThre" method="post" id="dynathre" name="dynathre" >
        <table id="senfe" width="100%">
          <tr>
            <th><a href="javascript:selectAllDynaThres();"><u>全选</u></a></th>
            <th> 动态威胁编号 </th>
            <th> 威胁类别 </th>
            <th> 威胁名称</th>
            <th> 查看 </th>
          </tr>
        <c:forEach items="${vulnThreAnalList }" var="vulnThreAnal" >
          <tr>    
            <td><input class="noneborder" type="checkbox" name="dynaThreIds" id="dynaThreIds" value="${vulnThreAnal.id}" /></td>
            <td> <a href="javascript:edit('${vulnThreAnal.id}')" >${vulnThreAnal.id}</a>
                   <c:choose>
                    <c:when test="${!empty vulnThreAnal.dynaVuln}">
                       (已关联脆弱点${vulnThreAnal.dynaVuln.id})
                    </c:when>
                    <c:otherwise>
                       (未关联脆弱点)
                    </c:otherwise>
                  </c:choose></td>
            <td><c:forEach items="${statThreKindList}" var="threKind">
                          <c:if test="${threKind.id == vulnThreAnal.asseKnowStatThreKindId}">
                               ${threKind.kind}                                              
                          </c:if>
                </c:forEach></td>
            <td><div class="tdcut">
               <c:forEach items="${statThreList}" var="thre">
                          <c:if test="${thre.id == vulnThreAnal.asseKnowStatThreId}">
                               ${thre.threat}                                             
                          </c:if>
                </c:forEach></div></td>
            <td><a href="javascript:viewDynaVulnThre('${vulnThreAnal.id}')" title="资产脆弱性查看" class="boxy"><u>查看</u></a></td>
          </tr>
        </c:forEach> 
        </table>
        </form>
      </div>
      <div class="Heightlist cl">
        <ul id="page">
          <li><a href="javascript:addDynaVulnThre();" class="R6 boxy" title="添加">添加</a></li>
          <li style="margin-right:12px;"><a href="javascript:relateToVuln();" class="R6 R7">与脆弱点关联</a></li>
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
        <h2 class="cl">脆弱点和威胁关联添加/修改</h2>
		<div  id="data" class="pad1 ">
        <form action="${ctx}/ismp/domain/local/ram/VulnThreRelaManager.do?method=saveOrUpdateThre&currPage=${currPage}" method="post" id="asseKnowDynaThreForm" name="asseKnowDynaThreForm" onsubmit="return validateAsseKnowDynaVulnThreForm(this);">
		<table>
          <tr>
            <th>动态威胁编号</th>
            <td><input type="text" name="code" id="code" value="${asseKnowDynaThre.id }" readonly/></td>
                <input type="hidden" name="id" id="id" value="${asseKnowDynaThre.id }" />
                <input type="hidden" name="asseInfoProjId" id="asseInfoProjId" value="${asseInfoProj.id }" />
            <th>静态威胁编号</th>
            <td><input type="text" name="threCode" id="threCode" value="${asseKnowDynaThre.threCode }" readonly/></td>
          </tr>
		  <tr>
		   <!-- <th> 资产名称 </th>
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
                   </select></td>-->
		    <th> 动态脆弱点编号 </th>
		    <td><select name="asseDynaVulnPoinId" id="asseDynaVulnPoinId" >
                   <option value="">-请选择-</option>
                     <c:forEach items="${dynaVulnList}" var="vuln">
                          <c:choose>
                           <c:when test="${asseKnowDynaThre.dynaVuln.id == vuln.id}">
                            <c:set var="select19" value="selected"></c:set>
                           </c:when>
                           <c:otherwise>
                            <c:set var="select19" value=""></c:set>
                           </c:otherwise>
                          </c:choose>
                       <option value="${vuln.id}" ${select19 }>${vuln.id}</option>
                      </c:forEach>
                  </select></td>
            <th>安全事件发生可能性 </th>
            <td><select name="possibility" id="possibility" >
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
                         <option value="${secuLeve.secuLeveId}"  ${select9 } > ${secuLeve.secuLeveName}</option>
                       </c:forEach>
                  </select></td>
		  </tr>
		  <tr>
		    <th> 威胁类别</th>
		    <td><select name="asseKnowStatThreKindId" id="asseKnowStatThreKindId" style="width:200px">
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
		    <th>威胁名称 </th>
		    <td><select name="asseKnowStatThreId" id="asseKnowStatThreId" style="width:250px" onchange="setStatThreCode();" >
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
                       <option value="${allStatThre.id}"   ${select8 }>类别编号:${allStatThre.threKind.id}名称:${allStatThre.threat}</option>
                      </c:forEach>
                  </select></td>
		  </tr>
		  <tr>
		    <td height="35" colspan="4"><input name="提交" type="submit" class="submit" value="保存" /></td>
		  </tr>
		  </table>
		</form>
		</div>


      <div class="paddiv"></div>
      <h2 class="cl">漏洞威胁列表</h2>
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
                     <option value="${ip}"  ${ipSelect }>
                        ${ip }
                     </option>
                    </c:forEach>
                 </select>
        </p>
      </div>
      <div class="pad1 greenborder">
        <table id="senfesub" width="100%">
          <tr>
            <th><a href="javascript:selectAllDynaLeakThres();"><u>全选</u></a></th>
            <th> 资产名称 </th>
            <th>CVE_ID</th>
            <th> 威胁类别 </th>
            <th> 威胁名称 </th>
            <th> 威胁级别 </th>
            <th>查看</th>
          </tr>
       <form action="${ctx}/ismp/domain/local/ram/VulnThreRelaManager.do?method=relateLeakToThre" method="post"  id="relateLeakToThre" name="relateLeakToThre">
          <c:forEach items="${leakThreList }" var="leakThre" >
          <tr>
            <td><input class="noneborder" type="checkbox" name="leakThreId" id="leakThreId" value="${leakThre.id}" /></td>
            <td>${leakThre.asse.assetName}</td>
            <td>${leakThre.dynaLeak.cveId}</td>
            <td><select name="leakThreKindId" id="leakThreKindId" >
                     <c:forEach items="${statThreKindList}" var="threKind">
                       <c:choose>
                         <c:when test="${threKind.id == leakThre.asseKnowStatThreKindId}">
                             <c:set var="select14" value="selected"></c:set>
                         </c:when>
                         <c:otherwise>
                             <c:set var="select14" value=""></c:set>
                          </c:otherwise>
                       </c:choose>
                       <option value="${threKind.id}" ${select14}>${threKind.kind}</option>
                      </c:forEach>
                    </select></td>
            <td><div class="tdcut" >
            <select name="leakCveThreId" id="leakCveThreId" >
                     <c:forEach items="${statCveThreList}" var="cveThre">
                       <c:choose>
                         <c:when test="${cveThre.id == leakThre.asseKnowStatCveThreId}">
                             <c:set var="select15" value="selected"></c:set>
                         </c:when>
                         <c:otherwise>
                             <c:set var="select15" value=""></c:set>
                          </c:otherwise>
                       </c:choose>
                       <option value="${cveThre.id}"   ${select15 }>${cveThre.threat}</option>
                      </c:forEach>
                    </select>
            </div></td>
            <td><select name="dynaLeakThreLeve" id="dynaLeakThreLeve">
                       <c:forEach items="${dicSecuLeveList }" var="secuLeve">
                         <c:choose>
                           <c:when test="${secuLeve.secuLeveId == leakThre.possibility}">
                            <c:set var="select13" value="selected"></c:set>
                           </c:when>
                           <c:otherwise>
                            <c:set var="select13" value=""></c:set>
                           </c:otherwise>
                          </c:choose>
                         <option value="${secuLeve.secuLeveId}"   ${select13 }>${secuLeve.secuLeveName}</option>
                       </c:forEach>
                  </select></td>
            <td><a href="javascript:viewLeak('${leakThre.dynaLeak.id}')" class="boxy"><u>查看</u></a></td>
          </tr>
        </c:forEach>
       </form>
        </table>
      </div>
      <div class="Heightlist cl">
        <ul id="page">
          <li><a href="javascript:relateLeakToThre();" class="R6 R7">与威胁关联</a></li>
          <li style="margin-right:12px;"><a href="#" class="R6 R7" onclick="javascript:alert(' 高: 其安全属性破坏后可能对组织的关键业务造成比较严重的损失\n 中: 其安全属性破坏后可能对组织的非关键业务造成损失 \n 低: 其安全属性破坏后可能对组织造成较低的损失，甚至忽略不计');" >定级说明</a></li>
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
    <div style="margin:0 auto; padding-top:12px; width:120px; height:30px; clear:both;"><a href="javascript:nextStep();" class="R6" >下一步</a></div>
  </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
