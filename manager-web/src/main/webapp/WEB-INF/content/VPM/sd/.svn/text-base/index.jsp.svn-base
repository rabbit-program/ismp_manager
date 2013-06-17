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
<link rel="stylesheet" href="${ctx}/css/VPM/pm/pmUpdate.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/date/skin/WdatePicker.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/date/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/floatdiv.js"></script>
<script type="text/javascript" src="${ctx}/js/VPM/PM/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/VPM/SD/software.js"></script>
<script type="text/javascript" src="${ctx}/js/VPM/PM/comm.js"></script>
<script type="text/javascript">
        // 添加或修改弹出新对话框用到--//v2.0
        function MM_openBrWindow(theURL,winName,features) {
              window.open(theURL,winName,features);
        }
         function MM_submit(sh){
              sh.close();
              document.forms[0].submit();
          }
        function toPage(curpage) {
            document.getElementById("currPage").value = curpage;
            document.forms["respShow"].submit();
        }
        function del_software(){
               if(confirm("确认删除吗?")){
                   return true;
            }
               return false;
        }
        function selectCheckbox(funobj){
            $("#senfe > tbody").find("tr :checkbox").each(function(index){
                funobj($(this),index);
            });
         }


        
</script>
</head>
<body >
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" >
    <li class="nor" id="m"><a href="javascript:void(0)" onclick="javascript:to_url('vm','${ctx}',this);return true;"><span style="background:url(${ctx}/img/comm/other/virus.gif) no-repeat; padding-left:22px;">病毒管理</span></a></li>
    <li class="nor" id="m"><a href="javascript:void(0)" onclick="javascript:to_url('pm','${ctx}',this);return true;"><span style="background:url(${ctx}/img/comm/other/01.gif) no-repeat; padding-left:22px;">补丁管理</span></a></li>
    <li class="act"><a href="javascript:void(0)" onclick="javascript:to_url('sd','${ctx}',this);return true;"><span style="background:url(${ctx}/img/comm/other/03.gif) no-repeat; padding-left:22px;">软件分发</span></a></li>
   </div>
  <div class="contant">
    <div class="greenborder pad3 overf">
      <h2 class="martop10">查看方式</h2>
      <div class="greenborder greenback overf pad3 Height_a" > <a href="#" class="R6 R7">本地目录</a>  <a href="#" class="R6 R7" style="margin-left:12px;">分发记录</a> </div>
      <h2 class="martop10">条件查询</h2>
     <form name="respShow" id="respShow" action="${ctx}/ismp/domain/local/vpm/sd/softwareDistributionAction.do?method=softwareAll" method="post">
      <div id="search" class="greenborder greenback overf pad1" >
        <table>
          <tr> 
            <th>软件名称</th>
            <td><input type="text" size="12" name="si.name" class="input" value="<bean:write name='software' property='name' scope='request'/>" /></td>
            <th>软件上传起始时间</th>
            <td><input type="text" size="12" name="starttime"  value="<logic:notEmpty name='startTime' ><bean:write name='startTime'  /></logic:notEmpty>" readonly="readonly" onclick="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="input"/>
              -
              <input type="text" class="input" name="endtime" value="<logic:notEmpty name='endTime' ><bean:write name='endTime'  /></logic:notEmpty>" readonly="readonly" onclick="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" size="12" /></td>
            <th>执行策略</th>  
            <td><select name="isExecute">
                <option value="" <logic:empty name="software" property="executePolicy.executeCheckTag" scope='request'>selected="selected"</logic:empty> >所有</option>
                <option value="true" <logic:equal value="true" name="software" property="executePolicy.executeCheckTag" scope='request'>selected="selected"</logic:equal> >执行</option>
                <option value="false" <logic:equal value="false" name="software" property="executePolicy.executeCheckTag" scope='request'>selected="selected"</logic:equal>>不执行</option>
              </select></td>
          </tr>
          <tr>
            <th>软件类型</th>
            <td><select name="si.type">
                <option value="" <logic:empty name="software" property="type" scope='request'>selected="selected"</logic:empty> >所有</option>
                <option value="FILE" <logic:equal value="FILE" name="software" property="type" scope='request'>selected="selected"</logic:equal>>文件</option>
                <option value="DIR" <logic:equal value="DIR" name="software" property="type" scope='request'>selected="selected"</logic:equal>>目录</option>
              </select></td>
            <th>软件分发起始日期</th>
            <td>
                 <input type="text" size="12" id="startTime" value="<logic:notEmpty name='software' property='dispatchPolicy.dispatchStartDate' scope='request'><bean:write name='software' property='dispatchPolicy.dispatchStartDate' /></logic:notEmpty>" name="commonStartTime" class="input" readonly="readonly" onclick="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> 
                  -  
                 <input type="text" size="12" id="endTime" value="<logic:notEmpty name='software' property='dispatchPolicy.dispatchEndDate' scope='request'><bean:write name='software' property='dispatchPolicy.dispatchEndDate' /></logic:notEmpty>" name="commonEndTime" class="input" readonly="readonly" onclick="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
           </td>
            <th>验证策略</th>
            <td><select name="isValidate">
                 <option value="" <logic:empty name='software' property='validatePolicy.validateCheckTag' scope='request'>selected="selected"</logic:empty> >所有</option>
                 <option value="true" <logic:equal value='true' name='software' property='validatePolicy.validateCheckTag' scope='request'>selected="selected"</logic:equal> >验证</option>
                 <option value="false" <logic:equal value='false' name='software' property='validatePolicy.validateCheckTag' scope='request'>selected="selected"</logic:equal> >不验证</option>
              </select></td>
          </tr>
          <tr>
            <th>软件类别</th>
            <td><select name="ti.id" id="selectType">
                <option value="0" selected="selected">所有</option>
         </select></td>
            <th>分发状态</th>
            <td><select name="isDispatch">
                 <option value=""  <logic:empty name='software' property='dispatchPolicy.dispatchCheckTag' scope='request'>selected="selected"</logic:empty> >所有</option>
                 <option value="true" <logic:equal value='true' name='software' property='dispatchPolicy.dispatchCheckTag' scope='request'>selected="selected"</logic:equal> >分发</option>
                 <option value="false" <logic:equal value='false' name='software' property='dispatchPolicy.dispatchCheckTag' scope='request'>selected="selected"</logic:equal> >不分发</option>
              </select></td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table>
      </div>
      <a href="javascript:void(0)" class="R6 martop8" onclick="javascript:document.forms[0].submit()">查询</a>
      <a href="${ctx}/ismp/domain/local/vpm/sd/softwareDistributionAction.do?method=softwareAll" class="R6 martop8">重置</a>
      <div class="paddiv"></div>
      <h2>软件分发列表</h2>
      <div id="data" class="greenborder overf pad1" >
          <table id="senfe" sortcol="-1">
            <thead>
              <tr>
                <th><a href="javascript:void(0)" id="selectAllCheckbox">全选</a><a href="javascript:void(0)"  id="notSelectCheckbox">反选</a></th>
                <th> 分发软件名 </th>
                <th> 大小(字节) </th>
                <th> 类别 </th>
                <th> 分发策略 </th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody>
         <logic:iterate name="list" id="si" scope="request">
              <tr> 
                <td><input class="noneborder" type="checkbox" name="checkbox" id="checkbox" value="<bean:write name='si' property='id'/>"/></td>
                <td><a href="javascript:void(0)" id="softwareDetail" onclick="softwareDetail('${ctx}/ismp/domain/local/vpm/sd/softwareDistributionAction.do?method=softwareByIdAjax&sid=<bean:write name='si' property='id'/>')" ><span style="float:left"><bean:write name="si" property="name"/></span></a></td>
                <td><span style="float:left"><bean:write name="si" property="size"/></span></td>
                <td><span style="float:left"><bean:write name="si" property="typeInfo.name"/></span></td>
                <td> 
                      <logic:equal value="true" name="si" property="dispatchPolicy.dispatchCheckTag">分发</logic:equal> 
                      <logic:notEqual value="true" name="si" property="dispatchPolicy.dispatchCheckTag">不分发</logic:notEqual>
                </td>
                <td><a href="#" onclick="MM_openBrWindow('${ctx}/ismp/domain/local/vpm/sd/softwareDistributionAction.do?method=softwareById&sid=<bean:write name='si' property='id'/>','修改','scrollbars=yes,width=540,height=590')" class="R6">修改</a> 
                  <a href="${ctx}/ismp/domain/local/vpm/sd/softwareDistributionAction.do?method=delsoftware&sid=<bean:write name='si' property='id'/>" onclick="return del_software()" class="R6">删除</a>
                </td>
              </tr>
         </logic:iterate>
            </tbody>
          </table>
      </div>
         <ul id="page" class="martop8">
           <li><a href="#" onclick="MM_openBrWindow('${ctx}/ismp/domain/local/vpm/sd/software_add.do','添加','scrollbars=yes,width=540,height=650')" class="R6">添加</a></li>
            <li style="margin-right:18px;"><a href="${ctx}/ismp/domain/local/vpm/sd/softwareDistributionAction.do?method=delsoftwareList" id="delSelectAll" class="R6">删除</a></li>
          <%@ include file="/common/customTags/page/page.jsp"%>
         </ul>
       </form>
      <br />
      <br />
      <br />
    </div>
  </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
