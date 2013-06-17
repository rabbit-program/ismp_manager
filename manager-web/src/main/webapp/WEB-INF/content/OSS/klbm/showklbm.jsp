<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title>运维支撑--运维知识库--查询</title>
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
			// 删除记录是用到
			function onDelete(path,id,isAll){
				var r = confirm("确认删除吗？")
				if (r==true) {
				    window.location.href = path+ "/ismp/domain/local/oss/updateOssKB.do?method=delete&id="+id+"&isAll="+isAll;
				}
			}

			// 分页用到
		    function toPage(curpage) {
		        document.getElementById("currPage").value = curpage;
		        document.forms["respShow"].submit();
		    }
		</script>
    </head>
    <body>
         <form action="${ctx}/ismp/domain/local/oss/ossKnowledgeBase.do?isAll=${isAll}" id="respShow" name="respShow" method="post">
        <div id="contant" class="mainbg">
            <%@ include file="/WEB-INF/content/OSS/comm/topMenu.jsp"%>
			<div class="contant">
            <div class="greenborder pad3 overf">
	            <h2 class="martop8">查看列表</h2>
                <div id="data" class="greenborder overf pad1 " >
                        <table id="senfe" sortcol="-1">
                            <thead>
                                <tr>
                                    <th width="9%" style="cursor:pointer" onclick="sortTable('senfe',0);">序号<span class="webdings">6</span></th>
                                    <th width="14%" style="cursor:pointer" onclick="sortTable('senfe',0);">名称</th>
                                    <th width="18%" style="cursor:pointer" onclick="sortTable('senfe',0);">文件内容</th>
                                    <th width="21%" style="cursor:pointer" onclick="sortTable('senfe',0);">更新日期</th>
                                    <th width="13%" style="cursor:pointer" onclick="sortTable('senfe',0);">编号</th>
                                    <th width="14%">编写人员</th>
                                    <th width="11%">操作</th>
                                </tr>
                            </thead>
                            <tbody>
                  <c:forEach var="OKList" items="${OKList}" >
		            <tr>
		              <td>${OKList.id } </td>
		              <td>${OKList.name }</td>
		              <td>${OKList.file_content}</td>
		              <td>${OKList.lastUpdateTime}</td>
		              <td>${OKList.sn }</td>
		              <td>${OKList.issuer }</td>
		              <td class="tdnowrap">
<a href="#" onclick="onDelete('${ctx}','${OKList.id}','${isAll}')" class="R6" >删除</a><span style="float:left">|</span>                   
              </td>
            </tr> 
           </c:forEach> 
             <input type="hidden" id="isAll" name="isAll" value="${isAll}" />                     
                            </tbody>
                        </table>
                </div>
                <div class="martop8 Height_t">
                <%@ include file="/common/customTags/page/page.jsp"%>
                </div>
            </div>
        </div>
        </form>
    </body>
    <script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>