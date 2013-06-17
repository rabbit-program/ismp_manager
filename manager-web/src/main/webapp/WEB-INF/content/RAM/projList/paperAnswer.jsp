<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>问卷调查</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/tree/dtree.css" />
<script type="text/javascript" src="${ctx}/js/comm/tree/dtree_linkMan.js"></script>
<script type="text/javascript">
function nextStep() {
	    var asseInfoProjId = document.getElementById("asseInfoProjId").value;
        window.location.href="${ctx}/ismp/domain/local/ram/papeManager.do?method=nextStep&asseInfoProjId="+asseInfoProjId;
    }

function questionChecked(){
    var elemCodes=document.getElementById("elemCode").value;
    var checkBoxList = document.all.questionId;
       for(j=0;j<checkBoxList.length;j++){
           if(checkBoxList[j].value == elemCodes){
        	   checkBoxList[j].checked=true;
               break;
        }
           
      }
}


function validatePaperAnswerForm(form){
	
	if (document.getElementById("papeAnswer").value == null
            || document.getElementById("papeAnswer").value == undefined
            || document.getElementById("papeAnswer").value == "") {
        alert("请选择左边的问卷!");
        return false;
    } 
    var flag=0
    for(i=0;i<form.answer.length;i++){
	    if(form.answer[i].checked==true){
	        flag=1;
	        break;
	    }
    }
    if(!flag){
        alert("选项必选!")
        return false
    }else {
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
            <td><img src="${ctx}/img/RAM/danger_banner_03.gif" /></td>
            <td><img src="${ctx}/img/RAM/danger_banner_05.gif" /></td>
            <td><img src="${ctx}/img/RAM/daner_bannera_06.gif" /></td>
            <td><img src="${ctx}/img/RAM/danger_banner_07.gif" /></td>
            <td><img src="${ctx}/img/RAM/danger_banner_08.gif" /></td>
            <td><img src="${ctx}/img/RAM/danger_banner_09.gif" /></td>
            <td><img src="${ctx}/img/RAM/danger_banner_10.gif" /></td>
            <td><img src="${ctx}/img/RAM/danger_banner_11.gif" /></td>
            <td><img src="${ctx}/img/RAM/danger_banner_12.gif" /></td>
          </tr>
        </table>
      </div>
      <h2>问卷调查</h2>
      <div id="data">
      <form action="${ctx}/ismp/domain/local/ram/papeManager.do?method=nextQuestion" method="post" onsubmit="return validatePaperAnswerForm(this);">
        <table class="martop8">
          <tr>
            <td width="200"><div class="greenback overf pad3" style="width:200px; height:500px; overflow:auto; margin:0;"> 这里是电话树 
                <div id="dtree" class="dtree">
                <p><a href="javascript: d.openAll();">全部展开</a> | <a href="javascript: d.closeAll();">全部收起</a></p>
                <script type="text/javascript">
                d=new dTree('d',"${ctx}");
                ${answerTreeList}
                document.write(d);
                </script>
                </div>  
            </div></td>
            <td valign="top"><h3>问题编码:${selectedStatSecuElem.elemCode }</h3>
              <h3>问题描述</h3>
             <textarea rows="5" cols="170" id="papeAnswer" name="papeAnswer" readonly>${selectedStatSecuElem.content}</textarea>
              <h3>选项</h3>
              <div class="pad3">
                <p>           
                 <input type="hidden" name="id" id="id" value="${asseInfoPape.id }" />
                 <input type="hidden" name="asseInfoProjId" id="asseInfoProjId" value="${asseInfoProj.id }" />&nbsp;
                 <input type="hidden" name="elemCode" id="elemCode" value="${selectedStatSecuElem.elemCode}" />       
                <c:choose>
                      <c:when test="${asseInfoPape.answer == 'yes'}">
                      <label> <input type="radio" name="answer" id="answer"  value="yes" checked /></label>
                  是　　
                      </c:when>
                      <c:otherwise>
                      <label><input type="radio" name="answer" id="answer"  value="yes" onclick="questionChecked()" /></label>
                  是　　
                      </c:otherwise>
                    </c:choose>
                     <c:choose>
                      <c:when test="${asseInfoPape.answer == 'no'}">
                       
                      <label><input type="radio" name="answer" id="answer"  value="no" checked /></label>
                    否　　
                      </c:when>
                      <c:otherwise>
                      
                    <label><input type="radio" name="answer" id="answer"  value="no"  onclick="questionChecked()" /></label>
                    否　　
                      </c:otherwise>
                    </c:choose>
                    <c:choose>
                      <c:when test="${asseInfoPape.answer == 'notCertain'}">
                       
                    <label><input type="radio" name="answer" id="answer"  value="notCertain" checked /></label>
                    不一定
                      </c:when>
                      <c:otherwise>
                      
                   <label> <input type="radio" name="answer" id="answer"  value="notCertain"  onclick="questionChecked()" /></label>
                    不一定
                      </c:otherwise>
                    </c:choose>
</p>
              </div>
              <h3>现场记录</h3>
              <div class="pad3">
               <textarea rows="10" cols="170" id="record" name="record">${asseInfoPape.record }</textarea>
            </div>
            <p class="font_tip">答完题后请点击下一题</p>
            <p><span style="float:left; margin:2px 12px 0 0;"><input class="submit" type="submit" name="测试" value="保存" /></span><a href="#" class="R6 R7">查看帮助</a></p></td>
          </tr>
        </table>
       </form>
      </div>
    <c:if test="${saveAll == 'ok'}">
    <div style="margin:0 auto; padding-top:12px; width:120px; height:30px; clear:both;"><a href="javascript:nextStep();" class="R6 R7">下一步</a></div>
    </c:if> 
 </div>
</div>
</body>
</html>
