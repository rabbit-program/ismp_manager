<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title>病毒补丁--软件分发--软件添加</title>
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Newcommon.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Maincontant.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/common.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/boxy.css" />
        <link rel="stylesheet" href="${ctx}/css/comm/date/skin/WdatePicker.css" type="text/css" />
        <script type="text/javascript" src="${ctx}/js/comm/date/WdatePicker.js"></script>
        <script type="text/javascript" src="${ctx}/js/VPM/PM/jquery.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/js/floatdiv.js"></script>
        <script type="text/javascript">
             $(function(){
                 $.post("${ctx}/ismp/domain/local/vpm/sd/softwareDistributionAction.do?method=findAllSoftwareInfo",function(response){
                     $(response).find('TYPE').each(function(){
                         $("<option  value='" + $(this).children('id').text() + "'>" + $(this).children('name').text() + "</option>").appendTo($("#selectType"));
                     });    
                },'html');
              }); 
             function rclose(){
                 var flag = true;
                 for(var i=1;i<6;i++){
                    var context= document.getElementById("time"+i).value;
                    if(context == ""){
                    	alert("信息没有填完整! 提示： * 是必填项");
                    	flag= false;
                    	break;
                        }
                 }
                 if(flag){
                     $("#tiname").val($("#selectType").find("option:selected").text());
                     document.forms[0].submit();
                     alert("添加成功");
                     window.opener.MM_submit(window);
                 }
             }
        </script>
    </head>
    <body>
<div  id="data" class="pad1 ">
  <h2>添加分发软件</h2>
<form name="uploadFile" id="uploadFile" action="${ctx}/ismp/domain/local/vpm/sd/softwareDistributionAction.do?method=softwareAdd" enctype="multipart/form-data" method="post">
  <table width="100%" >
      <tr>
      <td colspan="2">选择上传的文件: </td>
      <td> <input type="file" id="time5" name="formFile" /> <span class="STYLE9"> *</span></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr> 
    <tr>
      <td><p align="center">软件类别: </td>
      <td>
          <select name="ti.id" id="selectType">
         </select>
         <input type="hidden" name="ti.name" id="tiname"/>
      </td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>    
    <tr class="graytr">
      <td colspan="5"><div align="center" >
          <div align="left">分发策略:
            <input class="noneborder" name="dp.dispatchCheckTag" type="radio" id="radio" value="1" checked />
            分发
            <input class="noneborder" type="radio" name="dp.dispatchCheckTag" id="radio2" value="0" />
            不分发 </div>
        </div></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>分发日期</td>
      <td colspan="3">
<input type="text" size="8" id="time1" name="dp.dispatchStartDate" class="input" readonly="readonly" onclick="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> 
        -  
 <input type="text" size="8" id="time2" name="dp.dispatchEndDate" class="input" readonly="readonly"  onclick="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
        <span lass="STYLE9"> * </span></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>分发时间</td>
      <td colspan="3">
        <input type="text"  class="input" name="starttime" readonly="readonly" id="time3" size="6" style="width: 60px"
                            onFocus="WdatePicker({lang:'zh-cn',dateFmt:'H:mm',maxDate:'#F{$dp.$D(\'d5224\')}'})" />
        --
        <input type="text"  readonly="readonly" class="input" name="endtime"  id="time4" size="6"  style="width: 60px"
                            onFocus="WdatePicker({lang:'zh-cn',dateFmt:'H:mm',maxDate:'#F{$dp.$D(\'d5224\')}'})" />
        <span class="STYLE9"> *</span></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>并发数量</td>
      <td colspan="3"><select name="dp.dispatchThreadNum" id="dispatchThreadNum">
          <option value="5" selected="selected">5</option>
          <option value="10">10</option>
          <option value="15">15</option>
          <option value="20">20</option>
        </select></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>分发优先级</td>
      <td colspan="3"><select name="dp.dispatchPriority" id="dispatchPriority">
          <option value="0" selected="selected">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
        </select></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>支持一致性检测</td>
      <td colspan="3">
            <input class="noneborder" name="dp.consistencyCheckTag" type="radio" id="radio" value="1"  />
            是
            <input class="noneborder" type="radio" name="dp.consistencyCheckTag" id="radio2" value="0" checked/>
            否
      </td>
    </tr>
    <tr class="graytr">
      <td colspan="5"><div align="center" >
          <div align="left">执行策略:
            <input class="noneborder" type="radio" name="ep.executeCheckTag"  id="radio4" value="1"/>
            分发后执行
            <input class="noneborder" name="ep.executeCheckTag" type="radio" id="radio3" value="0" checked="checked" />
            分发不执行 </div>
        </div></td>
    </tr>
    <tr>
      <td rowspan="3"></td>
      <td>执行参数</td>
      <td colspan="3"><input name="ep.executeParameter" value="" type="text"
                            id="executeParameter" class="input" /></td>
    </tr>
    <tr>
      <td>执行路径</td>
      <td colspan="3"><input name="ep.executeFilePath" type="text"
                            id="executeFilePath"  class="input" value="" /></td>
    </tr>
    <tr>
      <td>提示信息</td>
      <td colspan="3"><input name="ep.executePromptingMessage" value="" type="text"
                            id="executePromptingMessage" class="input"/></td>
    </tr>
    <tr class="graytr">
      <td colspan="5"><div align="center" >
          <div align="left">验证策略:
            <input class="noneborder" type="radio" name="vp.validateCheckTag"  id="validateCheckTag"  value="1" />
            进行执行验证
            <input class="noneborder" name="vp.validateCheckTag" type="radio" id="validateCheckTag"  value="0" checked="checked" />
            不进行执行验证 </div>
        </div></td>
    </tr>
    <tr>
      <td rowspan="5">&nbsp;</td>
      <td>若文件</td>
      <td colspan="3"><input name="vp.validateFilePath"  value="" type="text"
                            id="validateFilePath" class="input" />
        存在，且版本不低于
        <input name="vp.validateFileVersion" type="text" id="validateFileVersion" size="4" class="input"  value="" />
        时</td>
    </tr>
    <tr>
      <td>注册表项/键</td>
      <td colspan="3"><input name="vp.validateRegisterKey" type="text" id="validateRegisterKey" class="input"/>
        存在时</td>
    </tr>
    <tr>
      <td>进程</td>
      <td colspan="3"><input name="vp.validateProcess" type="text" class="input" id="validateProcess" />
        存在时</td>
    </tr>
    <tr>
      <td>服务</td>
      <td colspan="3"><input name="vp.validateService" type="text" class="input" id="validateService" />
        存在时</td>
    </tr>
    <tr>
      <td colspan="4">判断软件执行成功</td>
    </tr>
    <tr>
      <td colspan="5">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="5" align="center">
        <input name="button" type="button"" onclick="rclose()"  class="subbtn" id="softwareAdd" value="添  加" />
        <input name="button" type="reset" class="subbtn" id="button"  value="重  置" />
        <input name="button" type="button" class="subbtn" id="button" onclick="window.close()"  value="返回" /></td>
    </tr>
    <tr>
      <td colspan="5">&nbsp;</td>
    </tr>
  </table>
  </form>
</div>
    </body>
</html>
