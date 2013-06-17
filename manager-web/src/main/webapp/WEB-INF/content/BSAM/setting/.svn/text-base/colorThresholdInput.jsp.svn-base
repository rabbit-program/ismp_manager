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
<title>态势参数设置</title>
<script type="text/javascript">
  function chk(){
	  var form = document.getElementById("colorThresholdForm");
	  var greenValue = document.getElementById("greenValue").value * 1;
      var yellowValue = document.getElementById("yellowValue").value * 1;
      if(greenValue==null || greenValue==''){
          alert("安全阈值不能为空");
          document.getElementById("greenValue").focus();
          return false;
      }else if(!/^[0-9]*[1-9][0-9]*$/.test(greenValue)){
          alert("安全阈值必须是正整数");
          document.getElementById("greenValue").focus();
          return false;
      }else if(greenValue>100){
          alert("安全阈值不能超过100");
          document.getElementById("greenValue").focus();
          return false;
      }else if(yellowValue==null || yellowValue==''){
          alert("警告阈值不能为空");
          document.getElementById("yellowValue").focus();
          return false;
      }else if(!/^[0-9]*[1-9][0-9]*$/.test(yellowValue)){
          alert("警告阈值必须是正整数");
          document.getElementById("yellowValue").focus();
          return false;
      }else if(yellowValue>100){
          alert("警告阈值不能超过100");
          document.getElementById("yellowValue").focus();
          return false;
      }else if(greenValue > yellowValue){
          alert("警告阈值必须大于安全阈值");
          return false;
      }
	  form.submit();
  }
 </script>
</head>
<body>
<div id="contant" class="mainbg">
    <%@ include file="/WEB-INF/content/BSAM/comm/topMenu.jsp"%>
    <div class="contant" >
        <div class="overf h20 martop10">
          <li >
               <a class="mback" href="${ctx}/ismp/domain/local/bsam/machineAction.do?method=getMachineList<sec:authorize ifAllGranted='ROLE_AdminAll'>&isAll=1</sec:authorize>">
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

          <li id="m">
               <a class="mbacka" href="#">
                    <span class="menus09">颜色阈值设置</span>
               </a>
          </li>
        </div>
        <div id="data" class="greenborder overf pad1" >
            <html:form action="/ismp/domain/local/bsam/colorThresholdAction.do?method=colorThresholdUpdate" >
                <input type="hidden" name="curpage" id="curpage"    value="${curpage}"> 
                <table id="senfe" sortcol="-1">
                    <tr>
                        <th class="head">安全(绿色范围:&nbsp;&nbsp;0~${greenColorThreshold.value })&nbsp;<img src="${ctx}/img/BSAM/green.bmp" width="40" height="20"/></th>
                        <td>
                            <input name="greenValue" type="text" class="main" id="greenValue" size="38" value=${greenColorThreshold.value }>
                        </td>
                    </tr>
                    <tr>
                        <th class="head">警告(黄色范围:${greenColorThreshold.value }~${yellowColorThreshold.value })&nbsp;<img src="${ctx}/img/BSAM/yellow.bmp" width="40" height="20"/></th>
                        <td>
                            <input name="yellowValue" type="text" class="main" id="yellowValue" size="38" value=${yellowColorThreshold.value }>
                        </td>
                    </tr>
                </table>
             </html:form>
        </div>
        <div class="martop8 Height_t">
            <ul id="page">
            <li><input type=button class="R6 R7" value="确定" hidefocus="Add" onclick="chk()" /></li>
<!--            <li><input type="button" class="R6 R7" value="返回" hidefocus="Add" onclick="ret('${curpage}')" /></li>-->
            </ul><br />
        </div>
   </div>
</div>
</body>
</html>