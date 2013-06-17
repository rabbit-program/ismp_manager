<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title>病毒补丁--软件分发--软件修改</title>
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Newcommon.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Maincontant.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/common.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/boxy.css" />
        <link rel="stylesheet" href="${ctx}/css/comm/date/skin/WdatePicker.css" type="text/css" />
        <script type="text/javascript" src="${ctx}/js/comm/date/WdatePicker.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/js/floatdiv.js"></script>
        <script type="text/javascript">
             $(function(){
                 $.post("${ctx}/ismp/domain/local/vpm/sd/softwareDistributionAction.do?method=findAllSoftwareInfo",function(response){
                     $(response).find('TYPE').each(function(){
                         $("<option  "+ ($.trim($(this).children('id').text()) == $.trim("<bean:write name='software' property='typeInfo.id' scope='request'/>") ? "selected='selected'" : " ") +" value='" + $(this).children('id').text() + "'>" + $(this).children('name').text() + "</option>").appendTo($("#selectType"));
                     });    
                },'html');
              });
             function rclose(){
                 document.forms[0].submit();
                 alert("修改成功");
                 window.opener.MM_submit(window);
             }
        </script>
    </head>
    <body>
<div  id="data" class="pad1 ">
  <h2>添加分发软件</h2>
  <table width="100%" >
     <form name="uploadFile" id="uploadFile" action="${ctx}/ismp/domain/local/vpm/sd/softwareDistributionAction.do?method=updateSoftwareInfo" enctype="multipart/form-data" method="post">
    <tr>
      <td><p align="center">软件类别: </td>
      <td>
          <select name="ti.id" id="selectType">
         </select>
      </td>
      <td><input type="hidden" name="vp.id" value="<bean:write name='software' property='validatePolicy.id' scope='request'/>"/></td>
      <td><input type="hidden" name="ep.id" value="<bean:write name='software' property='executePolicy.id' scope='request'/>"/></td>
      <td><input type="hidden" name="dp.id" value="<bean:write name='software' property='dispatchPolicy.id' scope='request'/>"/></td>
    </tr>    
    <tr class="graytr">
      <td colspan="5"><div align="center" >
          <div align="left">分发策略:
            <input class="noneborder" name="dp.dispatchCheckTag" type="radio" id="radio" value="true" <logic:equal value="true" name="software" property="dispatchPolicy.dispatchCheckTag">checked</logic:equal>  />
            分发
            <input class="noneborder" type="radio" name="dp.dispatchCheckTag" id="radio2" value="false" <logic:equal value="false" name="software" property="dispatchPolicy.dispatchCheckTag">checked</logic:equal> />
            不分发 </div>
        </div></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>分发日期</td>
      <td colspan="3">
<input type="text" size="8" id="startTime" name="dp.dispatchStartDate" value="<bean:write name='software' property='dispatchPolicy.dispatchStartDate' scope='request'/>" class="input" readonly="readonly" onclick="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> 
        -  
 <input type="text" size="8" id="endTime" name="dp.dispatchEndDate" value="<bean:write name='software' property='dispatchPolicy.dispatchEndDate' scope='request'/>" class="input" readonly="readonly" onclick="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
        <span lass="STYLE9"> * </span></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>分发时间</td>
      <td colspan="3">
        <input type="text" class="input" name="starttime" readonly="readonly" id="d5223" size="6" style="width: 60px" value="<bean:write name='up_start_Time'  scope='request'/>"
                            onFocus="var d5224=$dp.$('d5224');WdatePicker({onpicked:function(){d5224.focus();},dateFmt:'H:mm',maxDate:'#F{$dp.$D(\'d5224\')}'})" />
        --
        <input type="text" readonly="readonly" class="input" name="endtime"  id="d5224" size="6"  style="width: 60px" value="<bean:write name='up_end_Time'  scope='request'/>"
                            onFocus="var d5224=$dp.$('d5224');WdatePicker({onpicked:function(){d5224.focus();},dateFmt:'H:mm',maxDate:'#F{$dp.$D(\'d5224\')}'})" />
        <span class="STYLE9"> *</span></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>并发数量</td>
      <td colspan="3"><select name="dp.dispatchThreadNum" id="dispatchThreadNum">
          <option value="5" <logic:equal value="5" name="software" property="dispatchPolicy.dispatchThreadNum">selected="selected"</logic:equal> >5</option>
          <option value="10" <logic:equal value="10" name="software" property="dispatchPolicy.dispatchThreadNum">selected="selected"</logic:equal>>10</option>
          <option value="15" <logic:equal value="15" name="software" property="dispatchPolicy.dispatchThreadNum">selected="selected"</logic:equal>>15</option>
          <option value="20" <logic:equal value="20" name="software" property="dispatchPolicy.dispatchThreadNum">selected="selected"</logic:equal>>20</option>
        </select></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>分发优先级</td>
      <td colspan="3"><select name="dp.dispatchPriority" id="dispatchPriority">
          <option value="0"  <logic:equal value="0" name="software" property="dispatchPolicy.dispatchPriority">selected="selected"</logic:equal> >0</option>
          <option value="1" <logic:equal value="1" name="software" property="dispatchPolicy.dispatchPriority">selected="selected"</logic:equal> >1</option>
          <option value="2"<logic:equal value="2" name="software" property="dispatchPolicy.dispatchPriority">selected="selected"</logic:equal> >2</option>
        </select></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>支持一致性检测</td>
      <td colspan="3">
         <input class="noneborder" type="checkbox" name="dp.consistencyCheckTag" id="checkbox2" <logic:equal value="true" name="software" property="dispatchPolicy.consistencyCheckTag">checked</logic:equal> />
      </td>
    </tr>
    <tr class="graytr">
      <td colspan="5"><div align="center" >
          <div align="left">执行策略:
            <input class="noneborder" type="radio" name="ep.executeCheckTag"  <logic:equal value="true" name="software" property="executePolicy.executeCheckTag">checked</logic:equal>
                                onClick="changeDispContext('true')" id="radio4" value="true"/>
            分发后执行
            <input class="noneborder" name="ep.executeCheckTag" type="radio"  <logic:equal value="false" name="software" property="executePolicy.executeCheckTag">checked</logic:equal>
            id="radio3" value="false"  onClick="changeDispContext('false')" />
            分发不执行 </div>
        </div></td>
    </tr>
    <tr>
      <td rowspan="3"></td>
      <td>执行参数</td>
      <td colspan="3"><input name="ep.executeParameter" value="<bean:write name='software' property='executePolicy.executeParameter' scope='request'/>" type="text"
                            id="executeParameter" class="input" /></td>
    </tr>
    <tr>
      <td>执行路径</td>
      <td colspan="3"><input name="ep.executeFilePath" type="text"
                            id="executeFilePath"  class="input" value="<bean:write name='software' property='executePolicy.executeFilePath' scope='request'/>" /></td>
    </tr>
    <tr>
      <td>提示信息</td>
      <td colspan="3"><input name="ep.executePromptingMessage" value="<bean:write name='software' property='executePolicy.executePromptingMessage' scope='request'/>" type="text"
                            id="executePromptingMessage" class="input"/></td>
    </tr>
    <tr class="graytr">
      <td colspan="5"><div align="center" >
          <div align="left">验证策略:
            <input class="noneborder" type="radio" name="vp.validateCheckTag" <logic:equal value="true" name="software" property="validatePolicy.validateCheckTag">checked</logic:equal>
             onClick="changeVlide('true')" id="validateCheckTag"  value="true" />
            进行执行验证
            <input class="noneborder" name="vp.validateCheckTag" type="radio" <logic:equal value="false" name="software" property="validatePolicy.validateCheckTag">checked</logic:equal>
             id="validateCheckTag" onClick="changeVlide('false')" value="false" />
            不进行执行验证 </div>
        </div></td>
    </tr>
    <tr>
      <td rowspan="5">&nbsp;</td>
      <td>若文件</td>
      <td colspan="3"><input name="vp.validateFilePath"  value="<bean:write name='software' property='validatePolicy.validateFilePath' scope='request'/>" type="text"
                            id="validateFilePath" class="input" />
        存在，且版本不低于
        <input name="vp.validateFileVersion" type="text"  value="<bean:write name='software' property='validatePolicy.validateFileVersion' scope='request'/>"
        id="validateFileVersion" size="4" class="input"  />
        时</td>
    </tr>
    <tr>
      <td>注册表项/键</td>
      <td colspan="3"><input name="vp.validateRegisterKey" type="text" value="<bean:write name='software' property='validatePolicy.validateRegisterKey' scope='request'/>"
      id="validateRegisterKey" class="input"/>
        存在时</td>
    </tr>
    <tr>
      <td>进程</td>
      <td colspan="3"><input name="vp.validateProcess" type="text" value="<bean:write name='software' property='validatePolicy.validateProcess' scope='request'/>"
      class="input" id="validateProcess" />
        存在时</td>
    </tr>
    <tr>
      <td>服务</td>
      <td colspan="3"><input name="vp.validateService" type="text" value="<bean:write name='software' property='validatePolicy.validateService' scope='request'/>"
      class="input" id="validateService" />
        存在时</td>
    </tr>
    <tr>
      <td colspan="4">判断软件执行成功</td>
    </tr>
    <tr>
      <td colspan="5"><input type="hidden" name="si.id" value="<bean:write name='software' property='id' scope='request'/>"/></td>
    </tr>
    <tr>
      <td colspan="5" align="center">
        <input name="button" type="button"" onclick="rclose()"  class="subbtn" id="softwareAdd" value="修    改" />
        <input name="button" type="button" class="subbtn" id="button" onclick="window.close()" value="返    回" /></td>
    </tr>
    <tr>
      <td colspan="5">&nbsp;</td>
    </tr>
  </form>
  </table>
</div>
    </body>
    <script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
