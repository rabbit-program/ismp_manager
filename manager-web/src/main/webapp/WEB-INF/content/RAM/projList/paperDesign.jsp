<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="org.springframework.web.context.request.RequestScope"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>问卷设计</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/tree/dtree.css" />
<script type="text/javascript" src="${ctx}/js/comm/tree/dtree_linkMan.js"></script>
<script language="JavaScript">
  function saveQuestion(){
      var chk = false;
      var elemCodes="";
   var checkBoxList = document.all.questionId;
   for(j=0;j<checkBoxList.length;j++){
       if(checkBoxList[j].checked && checkBoxList[j].disabled==false){
           elemCodes=elemCodes+checkBoxList[j].value+";"
           chk = true;
    }
  }
    if(chk){
        var elemCodess =document.getElementById("elemCodess").value;
        window.location.href="${ctx}/ismp/domain/local/ram/papeManager.do?method=saveDesignContent&elemCodes="+elemCodes+"&elemCodess="+elemCodess;
   }else{
        alert("请选择安全要素。");
   }
 }

  function nextStep() {
      window.location.href="${ctx}/ismp/domain/local/ram/papeManager.do?method=prePaperAnswer";
  }
  
  String.prototype.startWith=function(str){
	  if(str==null||str==""||this.length==0||str.length>this.length)
	   return false;
	  if(this.substr(0,str.length)==str)
	     return true;
	  else
	     return false;
	  return true;
	 }

  function selectChildren(thisCheckBox){	  
      var splitArray = new Array();
      var parentStartValue = thisCheckBox.value;
      splitArray = parentStartValue.split(".");
      var childStartValue = "";
      for(k=0;k<splitArray.length;k++){
          if(splitArray[k].length==1) {
           childStartValue = childStartValue+"0"+splitArray[k];
          }else if(splitArray[k].length==2) {
           childStartValue = childStartValue+splitArray[k];
          }
      }
      
      var questionIdCheckBoxList = document.all.questionId;
      var parentIdCheckBoxList = document.all.parentQuestionId;
      for(i=0;i<parentIdCheckBoxList.length;i++){
          if(parentIdCheckBoxList[i].value.startWith(parentStartValue)){
             if(thisCheckBox.checked&&parentIdCheckBoxList[i].disabled==false){
                 parentIdCheckBoxList[i].checked=true;
           }else{
                 parentIdCheckBoxList[i].checked=false;
          }
        }
     }

      for(j=0;j<questionIdCheckBoxList.length;j++){
          if(questionIdCheckBoxList[j].value.startWith(childStartValue)){
             if(thisCheckBox.checked){
                 questionIdCheckBoxList[j].checked=true;
           }else if(questionIdCheckBoxList[j].disabled==false){
                 questionIdCheckBoxList[j].checked=false;
          }
        }
     }
  }

  function selectParent(thisCheckBox){
      var childValue = thisCheckBox.value.substring(0,6);
      var firs = childValue.substring(0,2);
      var seco = childValue.substring(2,4);
      var thir = childValue.substring(4,6);
      if(firs.startWith("0")){
          firs = firs.substring(1,2);
      }
      if(seco.startWith("0")){
          seco = seco.substring(1,2);
      }
      if(thir.startWith("0")){
          thir = thir.substring(1,2);
      }
      var parent1 = firs;
      var parent2 = parent1+"."+seco;
      var parent3 = parent2+"."+thir;
      var parentIdCheckBoxList = document.all.parentQuestionId;
      var questionIdCheckBoxList = document.all.questionId;
      for(i=0;i<parentIdCheckBoxList.length;i++){
          if(parentIdCheckBoxList[i].value==parent1 || parentIdCheckBoxList[i].value==parent2 || parentIdCheckBoxList[i].value==parent3){
             if(thisCheckBox.checked){
                 parentIdCheckBoxList[i].checked=true;
           }else{
               parentIdCheckBoxList[i].checked=false;
           }
        }
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
            <td><img src="${ctx}/img/RAM/danger_banner_03.gif" /></td>
            <td><img src="${ctx}/img/RAM/daner_bannera_05.gif" /></td>
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
      <h2>问卷设计</h2>
      <div id="data">
        <table class="martop8">
          <tr>
            <td width="200"><div class="greenback overf pad3" style="width:200px; height:500px; overflow:auto; margin:0;"> 这里是电话树 
              <div id="dtree" class="dtree">
	            <p><a href="javascript: d.openAll();">全部展开</a> | <a href="javascript: d.closeAll();">全部收起</a></p>
	            <script type="text/javascript">
	            d=new dTree('d',"${ctx}");
	            ${treeList}
	            document.write(d);
	            </script>
	          </div>  
            </div></td>
            <td valign="top"><h3>问题编码:${statSecuElem.elemCode }<input type="hidden" id="elemCodess" name="elemCodess" value="${elemCodess}"/></h3>
              <h3>问题描述</h3>
                <textarea  rows="5" cols="170" readonly>${statSecuElem.content}</textarea>
              <h3>问题备注描述</h3>
              <div >
                <textarea rows="10" cols="170"  readonly >${statSecuElem.memo}</textarea>
              </div>
              <div style="margin:0 auto; padding-top:12px; width:320px; height:50px; clear:both; float:left"><a href="javascript:saveQuestion();" class="R6 R7">保存问卷</a></div>
            </td>
          </tr>
        </table>
      </div>
    <c:if test="${papeSaveSucc == 'ok'}">  
    <div style="margin:0 auto; padding-top:12px; width:120px; height:30px; clear:both;"><a href="javascript:nextStep();" class="R6">下一步</a></div>
    </c:if>  
</div>
</div>
<script language="JavaScript">
questionChecked();
function questionChecked(){
        var checkBoxList = document.all.questionId;
        var elemCodess =document.getElementById("elemCodess").value;
        if(elemCodess!=null){
            var stringArray = elemCodess.split(";");
               for(j=0;j<checkBoxList.length;j++){
                   for(i=0;i<stringArray.length;i++){
                       if(checkBoxList[j].value==stringArray[i]){
                           checkBoxList[j].checked=true;
                           checkBoxList[j].disabled=true;
                       }
                   }
              }
        }
}
</script>
</body>
</html>
