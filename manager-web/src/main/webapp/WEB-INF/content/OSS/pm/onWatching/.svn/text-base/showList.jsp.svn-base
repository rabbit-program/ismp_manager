<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title>运维支撑--值班管理--当班人员</title>
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
		    function toPage(curpage) {
		        document.getElementById("currPage").value = curpage;
		        document.forms["respShow"].submit();
		    }
		    function seachDomain(obj){
                var $index = obj.selectedIndex;
                var $form= document.getElementById("seachConditions");
                if($index > 0){
                	$form.action +="&type=seach&doid="+obj.value;
                	 $form.submit();
                   }
                return false;
			}
		</script>
    </head>
    <body>
        <div id="contant" class="mainbg">
            <%@ include file="/WEB-INF/content/OSS/comm/topMenu.jsp"%>
            <div class="contant">
                <div class="overf h20 martop10">
					<li><a  class="mbacka" href="${ctx}/ismp/oss/pm/dsinfo.do?method=dsall&identifier=onduty"><span class="menus11">当班人员</span></a></li>
                    <li><a  class="mback" href="${ctx}/ismp/oss/pm/dsinfo.do?method=dsall&identifier=publishingManagement"><span class="menus12">排班管理</span></a></li>
                </div>
                <div class="greenborder pad3 overf">
                    <h2 class="martop10">请选择委办局</h2>
	                <div class="greenborder greenback overf pad3 Height_a" >
                        <form action="${ctx}/ismp/oss/pm/dsinfo.do?method=dsall&identifier=onduty" id="seachConditions" name="seachConditions" method="post" >
	                    <span style="float:left;">委办局
	                        <label for="select"></label>
	                        <select name="doselect" id="doselect" onchange="seachDomain(this)">
	                            <option>==委办局==</option>
	                        </select>
	                    </span>
				    </form>
	                </div>
                    <h2 class="martop10">列表</h2>
	                <div id="data" class="greenborder overf pad1" >
		                <form name="respShow" id="respShow" action="${ctx}/ismp/oss/pm/dsinfo.do?method=dsall&identifier=onduty" method="post">
                            <table id="senfe" sortcol="-1">
		                        <thead>
		                            <tr>
		                                <th width="6%" style="cursor:pointer" onclick="sortTable('senfe',0);"> 编号 <span class="webdings">6</span></th>
										<th width="4%"> 域</th>
										<th width="6%"> 名称</th>
										<th width="18%"> 职位</th>
										<th width="11%"> 手机 </th>
										<th width="9%">电话</th>
										<th width="16%">Email</th>
										<th width="13%">备注</th>
		                            </tr>
		                        </thead>
		                        <tbody>
                               <logic:iterate name="rosters" id="roster">
									<tr>
										<td> <bean:write name="roster" property="sn"/></td>
										<td> <bean:write name="roster" property="domain.domainName"/></td>
										<td><bean:write name="roster" property="name"/></td>
										<td> <span style="float:left"><bean:write name="roster" property="position"/></span></td>
                                        <td> <bean:write name="roster" property="mobile"/></td>
                                        <td><bean:write name="roster" property="phone"/> </td>
                                        <td><bean:write name="roster" property="EMail"/></td>
                                        <td><bean:write name="roster" property="remark"/></td>
									</tr>
								</logic:iterate>
		                        </tbody>
		                    </table>
		            </div>
		            <%@ include file="/common/customTags/page/page.jsp"%>
					<br />
                     </form>
					<br />
					<br />
                </div>
            </div>
        </div>
    </body>
    <script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>