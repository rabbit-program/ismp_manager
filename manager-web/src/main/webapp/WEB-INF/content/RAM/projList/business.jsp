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
<script type="text/javascript" src="${ctx}/dwr/interface/businessService.js"></script>
<script type="text/javascript" src="${ctx}/dwr/engine.js"></script>
<script type="text/javascript" src="${ctx}/dwr/util.js"></script>
<script type="text/javascript">
function nextStep() {
    window.location.href="${ctx}/ismp/domain/local/ram/AssetManager.do?method=preInputAsset";
}

function toPage(curpage) {
    document.getElementById("currPage").value = curpage;
    window.location.href="${ctx}/ismp/domain/local/ram/businessManager.do?method=showBusiness&currPage="+curpage;
}
function selectAllBusiness(){
  var checkBoxList = document.all.busiIdSelect;
  if(checkBoxList.length!=undefined){
    for(i=0; i < checkBoxList.length; i++) {
           checkBoxList[i].checked = true;
    }
  }else{
      checkBoxList.checked = true;
  }
}

function deleteBusiness(){
	  var form = document.getElementById("delForm");    
	  var checkBoxList = document.all.busiIdSelect;
	  var chk = false;
	  if(checkBoxList.length!=undefined){
	    for(var i=0;i<checkBoxList.length;i++){
	      if(document.all.busiIdSelect[i].checked){
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
	        form.submit();
	    }else{
	     alert("请选择删除记录。");
	    }
}

function newBusiness(){
    document.all.id.value="";
    document.all.businessId.value="";
    document.all.businessName.value="";
    document.all.respMan.value="";
    document.all.importance.value="";
}

function edit(id,businessId,businessName,respMan,importance){
    document.getElementById("id").value=id;
    document.getElementById("businessId").value=businessId;
    document.getElementById("businessName").value=businessName;
    document.getElementById("respMan").value=respMan;
    document.getElementById("importance").value=importance;
}



function chkExt(data){
    if(data!=null){
    	document.getElementById("notice").innerHTML="<font color=red>该业务编号已存在,请修改业务编号!</font>";
    }else{
    	document.getElementById("notice").innerHTML="";
    }
}
function validateBusinessIdUnique(){
	var id = document.getElementById("id").value;
    if(id=="") {
        //新增操作
        var busiId = document.getElementById("businessId").value;
        businessService.findByBusinessId(busiId,chkExt);
    }
}

function  trim(str){
    for(var i=0; i<str.length&&str.charAt(i)==" "; i++)  ;
    for(var j=str.length; j>0&&str.charAt(j-1)==" ";j--)  ;
    if(i>j) return "";  
    return  str.substring(i,j);  
} 

function validateAsseInfoBusiForm(form){
	validateBusinessIdUnique();
	var notice=document.getElementById("notice").innerHTML;
    if (trim(document.getElementById("businessId").value) == null
            || document.getElementById("businessId").value == undefined
            || trim(document.getElementById("businessId").value) == ""
            || notice!="") {
        alert("业务编号必填且不能重复!");
        return false;
    } else if (trim(document.getElementById("businessName").value) == null
            || document.getElementById("businessName").value == undefined
            || trim(document.getElementById("businessName").value) == ""
            || document.getElementById("businessName").value.length > 50) {
        alert("业务名称必填且不能超过50个字符!");
        return false;
    } else if (document.getElementById("importance").value == null
            || document.getElementById("importance").value == undefined
            || document.getElementById("importance").value == "") {
        alert("关键性必选!");
        return false;
    } else if (trim(document.getElementById("respMan").value) == null
            || document.getElementById("respMan").value == undefined
            || trim(document.getElementById("respMan").value) == ""
            || document.getElementById("respMan").value.length > 20) {
        alert("负责人必填且不能超过20个字符!");
        return false;
    } else {
        return true;
    }
}

function onClean(){
	document.getElementById("businessId").value="";
    document.getElementById("businessName").value="";
    document.getElementById("importance").value="";
    document.getElementById("respMan").value="";
		
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
          <td><img src="${ctx}/img/RAM/daner_bannera_02.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_03.gif" /></td>
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
    <h2 class="martop10">业务录入</h2>
    <div id="data" class="greenborder overf pad1" >
      <form name="delForm" id="delForm" action="${ctx}/ismp/domain/local/ram/businessManager.do?method=delBusiness&currPage=${currPage}" method="post">
        <table id="senfe" sortcol="-1">
          <thead>
            <tr>
              <th><a href="javascript:selectAllBusiness()"><u>全选</u></a></th>
              <th> 项目编号</th>
              <th> 业务名称 </th>
              <th> 负责人 </th>
              <th>关键性</th>
            </tr>
          </thead>
          <tbody>
           <c:forEach items="${bussList}" var="busi"  step="1">
            <tr>
              <td><input class="noneborder" type="checkbox"  name="busiIdSelect" id="busiIdSelect" value="${busi.businessId}" /></td>
              <td><a href="javascript:edit('${busi.id}','${busi.businessId}','${busi.businessName}','${busi.respMan}','${busi.importance}')" >
                  ${busi.businessId}</a>    
              </td>
              <td>${busi.businessName}</td>
              <td>${busi.respMan}</td>
              <td><c:forEach items="${dicSecuLeveList }" var="secuLeve">
               <c:if test="${secuLeve.secuLeveId==busi.importance }">
                 <c:set var="busiImpo" value="${secuLeve.secuLeveName }" />
               </c:if>
              </c:forEach>${busiImpo}&nbsp;
             </td>
            </tr>
           </c:forEach>
          </tbody>
        </table>
      </form>
    </div>
    <div class="Heightlist">
    <ul id="page" class="martop8">
      <li style="margin-right:4px;">
          <a href="javascript:newBusiness();" class="R6 boxy" title="新建业务" >新建</a>
      </li>
      <li style="margin-right:12px;"><a class="R6" href="javascript:deleteBusiness();">删除</a></li>
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
    <br />
    <br />
    <div  id="data" class="pad1 "> <span class="font_tip">注意:业务编号唯一! </span>
  <form method="post" action="${ctx}/ismp/domain/local/ram/businessManager.do?method=saveNewBusiness&currPage=${currPage}" id="saveForm" class="boxy" onsubmit="return validateAsseInfoBusiForm(this);"><table width="100%">
    <tr>
      <th> 业务编号<span class="alert">*</span> </th>
      <td>
      <input type="hidden" id="id"  name="id" value="${asseInfoBusi.id}"/>
      <input type="text" size="12" class="input"  id="businessId" name="businessId" value="${asseInfoBusi.businessId}" onchange="validateBusinessIdUnique()"/><div id="notice"/></td>
      <th> 业务名称 <span class="alert">*</span></th>
      <td><input type="text" size="12" class="input" id="businessName" name="businessName" value="${asseInfoBusi.businessName}"/></td>
    </tr>
    <tr>
      <th>关键性<span class="alert">*</span> </th>
      <td>
      <select name="importance" id="importance">
         <option value="">-请选择-</option>
        <c:forEach items="${dicSecuLeveList}" var="sec">
         <option value="${sec.secuLeveId}" <c:if test="${sec.secuLeveId == asseInfoBusi.importance}">selected='selected'</c:if>>${sec.secuLeveName}</option>
        </c:forEach>
       </select>
      </td>
      <th> 负责人<span class="alert">*</span> </th>
      <td><input type="text" size="12" class="input" id="respMan"  name="respMan" value="${asseInfoBusi.respMan}"/></td>
    </tr>
    <tr>
      <td height="32" colspan="4" align="center">
      <input class="submit" type="submit"  value="提交" />&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="button" value="重置" class="submit"  onclick="onClean();" />
        </td>
    </tr>
  </table></form>
</div>
    
    <div style="margin:0 auto; padding-top:12px; width:120px; height:30px; clear:both;"><a href="javascript:nextStep();" class="R6">下一步</a></div>
  </div>
</div>

</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
