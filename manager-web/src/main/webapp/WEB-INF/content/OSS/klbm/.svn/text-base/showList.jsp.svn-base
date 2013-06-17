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
			$(function(){
			    $(".boxy").boxy();
			});

		    // 添加或修改弹出新对话框用到--//v2.0
			function MM_openBrWindow(theURL,winName,features) { 
			    window.open(theURL,winName,features);
			}
			// 删除记录是用到
			function onDelete(path,id,isAll){
				var r = confirm("确认删除吗？")
				if (r==true) {
				    window.location.href = path+ "/ismp/domain/local/oss/updateOssKB.do?method=delete&id="+id+"&isAll="+isAll;
				}
			}
			// 重置按钮用到
			function clean() {
			    //document.forms[0].dmid.value=-1;
				document.forms[0].file_content.value="";
			}  

			// 分页用到
		    function toPage(curpage) {
		        document.getElementById("currPage").value = curpage;
		        document.forms["respShow"].submit();
		    }
		    function find(){
		        var isAll=document.getElementById("isAll").value;
		        window.location.href="${ctx}/ismp/domain/local/oss/ListOssKB.do?isAll="+isAll+"&filecontent=测试";
			}
			// 控制内容显示长度
		    function subStringSingleCode(singleCode,id){
		        var showValue;
		        //var strId=id;
		        if(singleCode.length>18){
		            showValue=singleCode.substring(0,18)+"......";
		        }else{
		            showValue=singleCode;
		        }
		        document.getElementById(id).innerHTML=showValue;
		    }
		</script>
    </head>
    <body>
         <form action="${ctx}/ismp/domain/local/oss/ossKnowledgeBase.do?isAll=${isAll}" id="respShow" name="respShow" method="post">
         <input id="currPage" name="currPage" type="hidden" />
        <div id="contant" class="mainbg">
            <%@ include file="/WEB-INF/content/OSS/comm/topMenu.jsp"%>
            <div class="contant">
               <!--<h2>选择委办局</h2>
                <div class="greenborder greenback overf pad3 Height_a" >
                    <div class="pad3">所属委办局:
                       <input id="currPage" name="currPage" type="hidden" />
                             <select id="dmid" name="dmid">
                                <option value="-1">==委办局==</option>
                                <logic:present name="udl">
                                    <logic:notEmpty name="udl">
                                        <logic:iterate id="u" name="udl">
                                             <c:choose>
                                               <c:when test="${u.id == selectid}">
                                                <c:set var="select13" value="selected"></c:set>
                                               </c:when>
                                               <c:otherwise>
                                                <c:set var="select13" value=""></c:set>
                                               </c:otherwise>
                                              </c:choose>
                                            <option value="${u.id}"  ${select13 }>${u.domainName}</option>
                                        </logic:iterate>
                                    </logic:notEmpty>
                                </logic:present>
                                <sec:authorize ifAllGranted='ROLE_AdminAll'>
                                   <c:choose>
                                     <c:when test="${selectid == -2}">
                                      <option value="-2" selected="selected">未知域</option>
                                     </c:when>
                                     <c:otherwise>
                                       <option value="-2" >未知域</option>
                                     </c:otherwise>
                                    </c:choose>
                                </sec:authorize>
                            </select>-->
                文件内容:<input type="text" id="file_content" name="file_content" value="${filecontent}">
           <input class="submit" type="submit" value="查询" />
           <input class="submit" type="button" value="重置" onclick="clean()" class="R6" />  
           <input class="submit" type="button" value="检索" onclick="find()" class="R6"/>
                    </div>      
                </div>
                <h2 class="martop8">查看列表</h2>
                <ul id="page">
                    <li><a href="#" class="R6 R7" onclick="MM_openBrWindow('${ctx}/ismp/domain/local/oss/addOssKB.do?isAll=${isAll}','添加','scrollbars=yes,width=450,height=480')" title="添加">添加</a></li>
                </ul>
                <div id="data" class="greenborder overf pad1 " >
                    <form name="f1" id="f1" action="" method="post">
                        <table id="senfe" sortcol="-1">
                            <thead>
                                <tr>
                                    <th width="9%" style="cursor:pointer" onclick="sortTable('senfe',0);">序号<span class="webdings">6</span></th>
                                    <th width="15%" style="cursor:pointer" onclick="sortTable('senfe',0);">名称</th>
                                    <th width="24%" style="cursor:pointer" onclick="sortTable('senfe',0);">文件内容</th>
                                    <th width="15%" style="cursor:pointer" onclick="sortTable('senfe',0);">更新日期</th>
                                    <th width="12%" style="cursor:pointer" onclick="sortTable('senfe',0);">编号</th>
                                    <th width="14%">编写人员</th>
                                    <th width="11%">操作</th>
                                </tr>
                            </thead>
                            <tbody>
                  <c:forEach var="OKList" items="${OKList}" >
		            <tr>
		              <td>${OKList.id } </td>
		              <td>${OKList.name }</td>
		              <td id="${OKList.id }"><script type="text/javascript">subStringSingleCode('${OKList.file_content}','${OKList.id }')</script></td>
		              <td>${OKList.lastUpdateTime}</td>
		              <td>${OKList.sn }</td>
		              <td>${OKList.issuer }</td>
		              <td class="tdnowrap">
<a href="#" onclick="onDelete('${ctx}','${OKList.id}','${isAll}')" class="R6" >删除</a><span style="float:left">|</span>                   
<a href="#" class="R6" onclick="MM_openBrWindow('${ctx}/ismp/domain/local/oss/updateOssKB.do?method=updateValue&id=${OKList.id}','修改','scrollbars=yes,width=450,height=480')">修改</a>
              </td>
            </tr> 
           </c:forEach> 
             <input type="hidden" id="isAll" name="isAll" value="${isAll}" />                     
                            </tbody>
                        </table>
                    </form>
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