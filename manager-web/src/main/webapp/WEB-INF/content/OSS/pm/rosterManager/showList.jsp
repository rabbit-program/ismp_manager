<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title>运维支撑--值班管理--人员管理</title>
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Newcommon.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Maincontant.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/common.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/boxy.css" />
        <script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/js/floatdiv.js"></script>
        <script type="text/javascript">
            $(function(){
                $(".boxy").boxy();
                $.post("${ctx}/ismp/domain/local/vpm/pm/doManinTree.do?method=getDoMainAll",function(response){
                    $(response).find('SH').each(function(index,evendate){
                        $("<option value='" + $(this).children('id').text() + "'>" + $(this).children('name').text() + "</option>").appendTo($("#doselect"));
                    });    
               },'html');
            });
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
            function seach(){
                var $form= document.getElementById("seachConditions");
                var $action=$form.action;
                var $domain=document.getElementById("doselect");
                var $domain_value=$domain.selectedIndex;
                $action += $domain_value > 0 ? "&doid="+$domain.value : "" ;
                $form.action = $action;
                $form.submit();
                return false;
            }
            function delRoster(){
            	  return confirm("确认要删除吗?") ? true : false;
            }
        </script>
    </head>
    <body>
        <div id="contant" class="mainbg">
            <%@ include file="/WEB-INF/content/OSS/comm/topMenu.jsp"%>
            <div class="contant">
                <div class="overf h20 martop10"> 
                    <li><a  class="mback" href="${ctx}/ismp/oss/pm/dsinfo.do?method=dsall&identifier=onduty"><span class="menus11">当班人员</span></a></li>
                    <li><a  class="mbacka" href="${ctx}/ismp/oss/pm/dsinfo.do?method=dsall&identifier=publishingManagement"><span class="menus12">排班管理</span></a></li>
                </div>
                <div class="greenborder pad3 overf">
                    <h2 class="martop10">请选择委办局</h2>
                    <div class="greenborder greenback overf pad3 Height_a" >
                      <form action="${ctx}/ismp/oss/pm/rosterInfo.do?method=rosterInfoAll&type=seach" id="seachConditions" name="seachConditions" method="post" >
                        <span style="float:left;">委办局
                            <select name="doselect" id="doselect" >
                                <option>==委办局==</option>
                            </select>
                        </span>
                        <span style="float:left;">
                                                                            姓名
                            <input id="rname" name="roster.name" type="text"/>
                        </span>
					  </form>
                        <a href="#" class="R6" onclick="seach()" style="margin-left:12px;">查询</a>
                        <a href="#" onclick="MM_openBrWindow('newRoster.do','添加','scrollbars=yes,width=450,height=480')" class="R6 R7" style="margin-left:12px;">新增人员</a>
                    </div>
                    <h2 class="martop10">列表</h2>
                    <div id="data" class="greenborder overf pad1" >
                         <form name="respShow" id="respShow" action="${ctx}/ismp/oss/pm/rosterInfo.do?method=rosterInfoAll" method="post">
                            <table id="senfe" sortcol="-1">
                                <thead>
                                    <tr>
                                        <th width="15%" style="cursor:pointer">姓名</th>
                                        <!--<th width="15%">性别</th>-->
                                        <th width="20%"> 职务</th>
                                        <th width="30%"> 联系方式</th>
                                        <th width="25%"> 备注</th>
                                        <th width="10%"> 操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                  <logic:iterate name="list" id="roster" scope="request">
                                    <tr>
                                        <td><bean:write name="roster" property="name"/></td>
                                        <!--<td>
                                             <logic:equal value="0" name="roster" property="sex">女</logic:equal>  
                                             <logic:equal value="1" name="roster" property="sex">男</logic:equal>  
                                        </td>-->
                                        <td> <span style="float:left"><bean:write name="roster" property="position"/></span></td>
                                        <td><bean:write name="roster" property="phone"/> </td>
                                        <td><bean:write name="roster" property="remark"/></td>
                                        <td><span class="tdnowrap"><a href="#" onclick="MM_openBrWindow('rosterInfo.do?method=rosterInfoById&identifier=rosterDetail&rid=<bean:write name="roster" property="id"/>','查看','scrollbars=yes,width=450,height=480')" >查看</a>| 
                                   <a href="#" onclick="MM_openBrWindow('rosterInfo.do?method=rosterInfoById&identifier=modifyRoster&rid=<bean:write name="roster" property="id"/>','修改','scrollbars=yes,width=450,height=480')">修改|</a>
                                   <a href="rosterInfo.do?method=rosterInfoDel&identifier=rosterDetail&rid=<bean:write name='roster' property='id'/>" onclick="return delRoster()">删除</a></span></td>
                                    </tr>
                                </logic:iterate>
                                </tbody>
                            </table>
                       </div>
                    <%@ include file="/common/customTags/page/page.jsp"%>
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