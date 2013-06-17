<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache"> 
<meta http-equiv="cache-control" content="no-cache"> 
<meta http-equiv="expires" content="0">    
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<title>Mainframe</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/floatdiv.js"></script>
<script type="text/javascript" src="${ctx}/js/SYSM/appsysinfo.js"></script>
<script type="text/javascript" >
  function jumpUrl(even,data1){even.href="${ctx}/ismp/sysm/other/appSysInfo.do?method=getAppSysInfo&curpage="+data1;}
    function addArea(){
       Boxy.shload("${ctx}/ismp/sysm/other/appSysInfoadd.do",{},function(data){
           $.post("${ctx}/ismp/domain/local/vpm/pm/doManinTree.do?method=getDoMainAll",function(response){
                 $(response).find('SH').each(function(){
                     $("<option  value='" + $(this).children('id').text() + "'>" + $(this).children('name').text() + "</option>").appendTo($(data).find("#doselect"));
                 });    
            },'html');
          $(data).find("#cz").click(function(){
             $(data).find("#asiform")[0].reset();
             return false;
          });
          $(data).find('#yadd').click(function(){
                 $(data).find("#asiform")[0].submit();
                 return false;
           });
        });
  }
  function upArea(dthis,url,did){
     Boxy.shload("${ctx}/ismp/sysm/other/appSysInfoup.do",{},function(data){
            $.post("${ctx}/ismp/domain/local/vpm/pm/doManinTree.do?method=getDoMainAll",function(response){
                 $(response).find('SH').each(function(){
                      var id=$(this).children('id').text();
                     $("<option " + ($.trim(id+"") == $.trim(did+"") ? "selected='selected'" : " " ) +  " value='" + id + "'>" + $(this).children('name').text() + "</option>").appendTo($(data).find("#doselect"));
                 });    
            },'html');
           $.post(url,function(responseHtml){
              $(responseHtml).find('asi').each(function(){       
                  $(data).find("#textfieldName").val($(this).children('name').text());
                  $(data).find("#textfieldDesc").val($(this).children('desc').text());
                  $(data).find("#upasiform").attr('action','${ctx}/ismp/sysm/other/appSysInfo.do?method=upAppSysInfo&asid='+$(this).children('id').text());
             });
           },'html');
          $(data).find("#cz").click(function(){
               Boxy.get(data).hide();
               return false;
          });
          $(data).find('#yadd').click(function(){
              var $data = $(dthis).parents("tr");
                 $data.find("td > a:eq(0)").html($(data).find("#textfieldName").val());
                 $data.find("td:eq(1)").html($(data).find("#textfieldDesc").val());
                 $.get($(data).find("#upasiform").attr('action')+"&asi.name="+$(data).find("#textfieldName").val()+"&asi.desc="+$(data).find("#textfieldDesc").val()+"&domainId="+$(data).find("#doselect").val());
                 did = $(data).find("#doselect").val();
                 Boxy.get(data).hide();
                return false;
          });
      });
  }
  function delArea(url){
	 return  confirm("确认要删除吗?");
  }                      
</script>
</head>
<body>
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" > </div>
  <div class="contant">
    <h2 >应用系统</h2>
  <div id="data" class="greenborder overf pad1" >
        <form name="f1" id="f1" action="" method="post">
          <table id="senfe" sortcol="-1">
            <thead>
              <tr>
                <th width="21%" style="cursor:pointer" onclick="sortTable('senfe',0);">名称</th>
                <th width="67%">简述</th>
                <th width="12%">操作</th>
              </tr>
            </thead>
            <tbody>
            <logic:iterate name="list" scope="request" id="as">
              <tr>
                <td><a href="javascript:void(0)" onclick="javascript:loadSecurity(this,'${ctx}','<bean:write name='as' property='id'/>')"><bean:write name="as" property="name"/></a></td>
                <td><bean:write name="as" property="desc"/></td>
                <td>
                    <a href="javascript:void(0)" 
                     onclick="javascript:upArea(this,'${ctx}/ismp/sysm/other/appSysInfo.do?method=getAppSysInfoId&asid=<bean:write name='as' property='id'/>',<bean:write name='as' property='domain.id'/>)">修改</a>| 
                    <a href="${ctx}/ismp/sysm/other/appSysInfo.do?method=delAppSysInfo&asid=<bean:write name='as' property='id'/>"  onclick="return delArea()">删除</a>
                </td>
              </tr>
             </logic:iterate>
            </tbody>
          </table>
        </form>
    </div>
    <div class="martop8 Height_t">
    <ul id="page">
        <li><a href="javascript:void(0)" onclick="addArea()" class="R6 R7 boxy" title="添加">添加</a></li>
        <li><a class="first" href="javascript:void(0)" onclick="javascript:jumpUrl(this,1);return true;"></a></li>
          <logic:equal name="page" property="hasPrePage" value="true">
             <li><a class="pre" href="javascript:void(0)" onclick="javascript:jumpUrl(this,${page.currentPage - 1});return true;"></a></li>
          </logic:equal>
          <logic:equal name="page" property="hasNextPage" value="true">
             <li><a class="next" href="javascript:void(0)" onclick="javascript:jumpUrl(this,${page.currentPage + 1});return true;"></a></li>
          </logic:equal>
        <li><a class="last" href="javascript:void(0)" onclick="javascript:jumpUrl(this,<bean:write name='page' property='totalPage'/>);return true;"></a></li>
        <li>共 <bean:write name='page' property='totalPage'/> 页 跳至
          <input type="text" size="2" class="input" id="gocount"/>
          &nbsp; </li>
        <li><a class="R6" href="javascript:void(0)" onclick="javascript:jumpUrl(this,$('#gocount').val());return true;">GO</a></li>
  </ul>
    <br />
  </div>
     </div>
  </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>