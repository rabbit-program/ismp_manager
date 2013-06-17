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
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/tree/dtree.css" />
<script type="text/javascript" src="${ctx}/js/comm/tree/dtree_linkMan.js"></script>
<script type="text/javascript" src="${ctx}/dwr/interface/assetService.js"></script>
<script type="text/javascript" src="${ctx}/dwr/engine.js"></script>
<script type="text/javascript" src="${ctx}/dwr/util.js"></script>
<script type="text/javascript">
function toPage(curpage) {
    document.getElementById("currPage").value = curpage;
    var asseKindCode =  document.getElementById("asseKindCode").value
    window.location.href="${ctx}/ismp/domain/local/ram/AssetManager.do?method=showAsse&currPage="+curpage+"&asseKindCode="+asseKindCode;
}

function selectAllAsset(){
	  var checkBoxList = document.all.asseCodeSelect;
	  if(checkBoxList.length!=undefined){
	    for(i=0; i < checkBoxList.length; i++) {
	           checkBoxList[i].checked = true;
	    }
	  }else{
	      checkBoxList.checked = true;
	  }
}

function newAsset(asseKindCode){
    document.all.id.value="";
    document.all.assetCode.value="";
    document.all.assetName.value="";
    document.all.asseInfoBusiId.value="";
    document.all.importance.value="";
    document.all.asseKindId.value=asseKindCode;
    document.all.respMan.value="";
    document.all.ip.value="";
    document.all.memo.innerText="";
}

function edit(id,assetCode,assetName,asseInfoBusiId,importance,asseKindId,respMan,ip,memo){
    document.getElementById("id").value=id;
    document.getElementById("assetCode").value=assetCode;
    document.getElementById("assetName").value=assetName;
    document.getElementById("asseInfoBusiId").value=asseInfoBusiId;
    document.getElementById("importance").value=importance;
    document.getElementById("asseKindId").value=asseKindId;
    document.getElementById("respMan").value=respMan;
    document.getElementById("ip").value=ip;
    document.getElementById("memo").innerText=memo;
}
function deleteAsset(){
    var form = document.getElementById("delForm");    
    var checkBoxList = document.all.asseCodeSelect;
    var chk = false;
    if(checkBoxList.length!=undefined){
      for(var i=0;i<checkBoxList.length;i++){
        if(document.all.asseCodeSelect[i].checked){
            chk = true;
            break;
        }
      }
    }else{
          if(checkBoxList.checked)
            chk = true;
    }
      if(chk){
          if(window.confirm("确定要删除吗？"))
          var currPage = document.getElementById("currPage").value;
          var asseKindCode =  document.getElementById("asseKindCode").value
          document.delForm.action="${ctx}/ismp/domain/local/ram/AssetManager.do?method=delAsse&asseKindCode="+asseKindCode+"&currPage="+currPage;
          delForm.submit(); 
      }else{
       alert("请选择删除记录。");
      }
}


function importData(){
    var asseKindCode=document.getElementById("asseKindCode").value;
    window.location.href="${ctx}/ismp/domain/local/ram/AssetManager.do?method=importData&asseKindCode="+asseKindCode;
}
<%--
function nextStep() {
    window.location.href="${ctx}/ismp/domain/local/ram/AssetManager.do?method=showTopoInfo";
}
--%>

function nextStep() {
    var cpKind = document.getElementById("cpKind").value;
    var projId = document.getElementById("projId").value;
    if(cpKind!='cp2') {
        window.location.href="${ctx}/ismp/domain/local/ram/papeManager.do?method=prePaperDesign&projId="+projId;
    }else{
        window.location.href="${ctx}/ismp/domain/local/ram/leakScanManager.do?method=showLeakScan&projId="+projId;
    }
}

function chkExt(data){
    if(data!=null){
        document.getElementById("notice").innerHTML="<font color=red>该资产编号已存在,请修改资产编号!</font>";
    }else{
        document.getElementById("notice").innerHTML="";
    }
}

function validateAsseCodeUnique(){
    var id = document.getElementById("id").value;
    if(id=="") {
        //新增操作
        var assetCode = document.getElementById("assetCode").value;
        assetService.findByAssetCode(assetCode,chkExt);
    }
}

function validateAsseInfoAsseForm(form){
	var notice=document.getElementById("notice").innerHTML;
    if (document.getElementById("assetCode").value == null
            || document.getElementById("assetCode").value == undefined
            || document.getElementById("assetCode").value == ""
            || document.getElementById("assetCode").value.length > 50
            || notice!="") {
        alert("资产编号不能超过50个字符且不能重复!");
        return false;
    }else if (document.getElementById("assetName").value == null
            || document.getElementById("assetName").value == undefined
            || document.getElementById("assetName").value == ""
            || document.getElementById("assetName").value.length > 50) {
        alert("资产名称必填且不能超过50个字符!");
        return false;
    } else if (document.getElementById("asseInfoBusiId").value == null
            || document.getElementById("asseInfoBusiId").value == undefined
            || document.getElementById("asseInfoBusiId").value == "") {
        alert("所属业务必选!");
        return false;
    } else if (document.getElementById("importance").value == null
            || document.getElementById("importance").value == undefined
            || document.getElementById("importance").value == "") {
        alert("重要性必选!");
        return false;
    } else if (document.getElementById("asseKindId").value == null
            || document.getElementById("asseKindId").value == undefined
            || document.getElementById("asseKindId").value == "") {
        alert("资产类别必选!");
        return false;
    }else if (document.getElementById("respMan").value == null
            || document.getElementById("respMan").value == undefined
            || document.getElementById("respMan").value == ""
            || document.getElementById("respMan").value.length > 20) {
        alert("资产负责人必填且不能超过20个字符!");
        return false;
    } else if (document.getElementById("ip").value == null
            || document.getElementById("ip").value == undefined
            || document.getElementById("ip").value == ""
            || checkIP(document.getElementById("ip").value)==false) {
        alert("资产IP必填且IP地址必须合法!");
        return false;
    }   else if (document.getElementById("memo").value == null
            || document.getElementById("memo").value == undefined
            || document.getElementById("memo").value == ""
            || document.getElementById("memo").value.length > 500) {
        alert("备注说明必填且不能超过500个字符!");
        return false;
    } else {
        return true;
    }
}

function checkIP(obj) { 
	var exp=/^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/; 
	var reg = obj.match(exp); 
	if(reg==null) { 
		return false;
	} 
	else { 
		return true;
	} 
}    

</script>
</head>
<body >
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
          <td><img src="${ctx}/img/RAM/daner_bannera_03.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_05.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_06.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_07.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_08.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_09.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_10.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_11.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_12.gif" /></td>
        </tr>
      </table>
    </div>
    <h2 >资产录入</h2>
    <div id="data">
      <table class="martop8">
        <tr>
          <td width="200" valign="top"><div class="greenback overf pad3" style="width:200px; height:580px; overflow:auto; margin:0 0;"> 这里是电话树
            <div id="dtree" class="dtree">
            <p><a href="javascript: d.openAll();">全部展开</a> | <a href="javascript: d.closeAll();">全部收起</a></p>
            <script type="text/javascript">
            d=new dTree('d',"${ctx}");
            ${treeList}
            document.write(d);
            </script>
        </div>  

         </div></td>
          <c:choose>
          <c:when test="${welcome != 'yes'}">
          <td valign="top">
          <form name="delForm" id="delForm" action="${ctx}/ismp/domain/local/ram/AssetManager.do?method=delAsse" method="post">
            <input type="hidden" id="cpKind"  name="cpKind" value="${asseInfoProj.cpKind}" />
            <input type="hidden" id="projId" name="projId" value="${asseInfoProj.id}" />
            <table id="senfe" sortcol="-1" class="martop8">
              <thead>
                <tr>
                  <th ><a href="javascript:selectAllAsset()"><u>全选</u></a></th>
                  <th > 项目编号</th>
                  <th> 资产名称 </th>
                  <th> 负责人 </th>
                  <th>重要性</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${asseList }" var="asse" >
                <tr>
 
                  <td><input class="noneborder" type="checkbox" name="asseCodeSelect" id="asseCodeSelect"  value="${asse.assetCode}"/></td>
                  <td> <a href="javascript:edit('${asse.id}','${asse.assetCode}','${asse.assetName}','${asse.asseInfoBusiId}','${asse.importance}','${asse.asseKind.id}','${asse.respMan}','${asse.ip}','${asse.memo}')" >           
		            ${asse.assetCode}
		          </a></td>
                  <td>${asse.assetName}</td>
                  <td>${asse.respMan}</td>
                  <td>${asse.importance}</td>
                </tr>
                </c:forEach>
              </tbody>
            </table>
            </form>
            <ul id="page">
              <li><a class="R6 boxy" title="新增" href="javascript:newAsset('${assekindid}');">新增</a></li>
              <li><a class="R6" title="删除" href="javascript:deleteAsset();">删除</a></li>
              <li style="margin-right:12px;"><a class="R6 R7 boxy" title="信息导入" href="javascript:importData();">信息导入</a></li>
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

        <br/><br />
<div  id="data" class="pad1 " align="left"> <span class="font_tip">注意:业务编号唯一! </span>
  <form action="${ctx}/ismp/domain/local/ram/AssetManager.do?method=saveAsse&currPage=${currPage}" id="addForm" name="addForm" class="boxy" method="post" onsubmit="return validateAsseInfoAsseForm(this);">
<table width="100%">
    <tr>
      <th>资产编号<span class="alert">*</span></th>
      <td> 
      <input type="hidden" id="id" name="id" value="${asseInfoAsse.id}" />
      <input type="hidden" name="asseKindCode" id="asseKindCode" value="${asseKindCode}"/>&nbsp;
      <input type="text" size="12" class="input" name="assetCode" id="assetCode" value="${asseInfoAsse.assetCode}" onchange="validateAsseCodeUnique()"/><div id="notice"></div></td>
      <th>资产名称<span class="alert">*</span></th>
      <td><input type="text" name="assetName" id="assetName" value="${asseInfoAsse.assetName}"/></td>
    </tr>
    <tr>
      <th>所属业务<span class="alert">*</span></th>
      <td><select id="asseInfoBusiId" name="asseInfoBusiId">
                   <option value="">-请选择-</option>
                  <c:forEach items="${busiList}" var="sec">
                  <option value="${sec.id}" <c:if test="${sec.id == asseInfoAsse.asseInfoBusiId}">selected='selected'</c:if>>${sec.businessName}</option>
                  </c:forEach>
                 </select></td>
      <th>重要性<span class="alert">*</span></th>
      <td><select name="importance" id="importance">
                       <option value="">-请选择-</option>
                       <c:forEach items="${dicSecuLeveList }" var="secuLeve">
                         <c:choose>
                         <c:when test="${secuLeve.secuLeveId == asseInfoAsse.importance }">
                           <c:set var="secuLeveSelect" value="selected" />
                         </c:when>
                         <c:otherwise>
                           <c:set var="secuLeveSelect" value="" />
                         </c:otherwise>
                         </c:choose>
                        <option value="${secuLeve.secuLeveId}" ${secuLeveSelect}>
                        ${secuLeve.secuLeveName }(${secuLeve.secuLeveId })
                        </option>
                      </c:forEach>
            </select></td>
    </tr>
    <tr>
      <th>资产类别<span class="alert">*</span></th>
      <td><select id="asseKindId" name="asseKindId">
                   <option value="">-请选择-</option>
                  <c:forEach items="${asseKindList}" var="sec">
                  <option value="${sec.id}" <c:if test="${sec.id == asseInfoAsse.asseKind.id}">selected='selected'</c:if>>${sec.assetKindName}</option>
                  </c:forEach>
                 </select>
</td>
      <th>资产负责人<span class="alert">*</span></th>
      <td><input type="text" name="respMan" id="respMan" value="${asseInfoAsse.respMan}"/></td>
    </tr>
    <tr>
      <th>资产IP<span class="alert">*</span></th>
      <td><input type="text" name="ip" id="ip" value="${asseInfoAsse.ip}"/></td>
      <th></th>
      <td>
     </td>
    </tr>
    <tr>
      <th>备注说明<span class="alert">*</span></th>
      <td colspan="3"><label>
        <textarea name="memo" id="memo" cols="75" rows="5">${asseInfoAsse.memo}</textarea>
        </label></td>
    </tr>
    <tr>
      <td height="32" colspan="4" align="center"><input class="submit" type="submit" value="保存" />
        </td>
    </tr>
  </table>
</form>
</div>
        </td>
      </tr>
      </table>
    </div>
    <div style="margin:0 auto; padding-top:12px; width:120px; height:30px; clear:both;"><a href="javascript:nextStep();" class="R6">下一步</a></div>
  </div>
</div>
</c:when>
<c:otherwise>
<td valign="top"> 请到左边选择资产类别。 </td>
</c:otherwise>
</c:choose>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
