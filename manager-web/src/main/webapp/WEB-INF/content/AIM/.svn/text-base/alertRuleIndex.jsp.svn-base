<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/common/taglibs.jsp"%>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/floatdiv.js"></script>
<script type="text/javascript" language="javascript" src="${ctx }/js/comm/date/WdatePicker.js"></script>

<script type="text/javascript">
    var clickNumber = 0;
    function FirstPage(curpage) {
        document.getElementById("curpage").value = curpage;
        document.forms[0].submit();
    }
    function upPage(curpage) {
        document.getElementById("curpage").value = curpage;
        document.forms[0].submit();
    }
    function nextPage(curpage) {
        document.getElementById("curpage").value = curpage;
        document.forms[0].submit();
    }
    function endPage(curpage) {
        document.getElementById("curpage").value = curpage;
        document.forms[0].submit();
    }
    function fwd(curpage) {
        document.getElementById("curpage").value = document
                .getElementById("mid").value;
        document.forms[0].submit();
    }

    function del() {
        var a = document.getElementsByName("ruleCheckbox");
        var n = a.length;
        var k = 0;
        for ( var i = 0; i < n; i++) {
            if (a[i].checked) {
                k = 1;
            }
        }
        if (k == 0) {
            alert("请选中需要删除项!");
            return;
        }
        if (confirm("确认删除所选项吗？")) {
            document.forms[1].submit();
        } else {
            return;
        }
    }

    function checkAll(e, itemName) {
        var aa = document.getElementsByName(itemName);
        for ( var i = 0; i < aa.length; i++)
            aa[i].checked = e.checked;
    }
    function checkItem(e, allName) {
        var all = document.getElementsByName(allName)[0];
        if (!e.checked)
            all.checked = false;
        else {
            var aa = document.getElementsByName(e.name);
            for ( var i = 0; i < aa.length; i++)
                if (!aa[i].checked)
                    return;
            all.checked = true;
        }
    }
    function disuseSubmit(flag) {
        clickNumber=clickNumber+1;
        if (flag=='1') {
            window.parent.document.getElementById("alertDrFrame").rows = "*,50%";
            document.forms[2].submit();
            return;
        } else {
            window.parent.document.getElementById("alertDrFrame").rows = "100%,*";
            return;
        }
        
    }

    function changeFrameRow() {
        // document.getElementById("frame").cols="0,10,*";
        window.parent.document.getElementById("alertDrFrame").rows = "*,0";
    }
    function addRule() {
        window.parent.document.getElementById("alertDrFrame").rows = "*,0";
        window.location.href = '${ctx}/ismp/domain/local/aim/alertRule.do?method=forward&add=1';
       // Boxy.load('${ctx}/ismp/domain/local/aim/alertRule.do?method=forward&add=1');
    }
    function updateAlert(id,curpage){
    	window.parent.document.getElementById("alertDrFrame").rows = "*,0";
        window.location.href = "${ctx}/ismp/domain/local/aim/alertRule.do?method=getByIdAlertRule&alertRuleId="+id+"&update=1&curpage="+curpage;
    }
    function openAlert(){                
		   alertsubWin = window.open ('${ctx }/ismp/domain/local/aim/alert.do?method=getListPageAlertAction&MinWindow=1','newwindow_Alert','height=400,width=900,top=300,left=400,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no') ;
	    }
    function topLink(linke){
        //alert(link);
    	window.parent.document.getElementById("alertDrFrame").rows = "*,0";
		if(linke=="alertIndex"){
			window.location.href = "${ctx }/ismp/domain/local/aim/alert.do?method=getListPageAlertAction&amp;home=1&amp;first=true";
			return;
		}
		if(linke=="alertFind"){
			window.location.href = "${ctx }/ismp/domain/local/aim/alertRule.do?method=alertFind";
			return;
		}
		if(linke=="alertFindFrame"){
			window.location.href = "${ctx }/ismp/domain/local/aim/alertRule.do?method=alertFindFrame";
			return;
		}
		if(linke=="alertIndex"){
			window.location.href = "${ctx }/ismp/domain/local/aim/alert.do?method=getListPageAlertAction&amp;home=1&amp;first=true";
			return;
		}
    }
</script>
</head>
<body>
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" >
  	<!-- <jsp:include page="/WEB-INF/content/AIM/top.jsp"></jsp:include> -->
  	<ul>
    <li <c:choose><c:when test="${topcss=='alertIndex'}">class='act'</c:when><c:otherwise>class='nor'</c:otherwise></c:choose>   id="m"><a href="#" onclick="topLink('alertIndex')"><span style="background:url(${ctx}/img/SYSM/page-edit-icon.png) no-repeat; padding-left:22px;">告警浏览</span></a></li> 
    <li <c:choose><c:when test="${topcss=='alertFind'}">class='act'</c:when><c:otherwise>class='nor'</c:otherwise></c:choose>   id="m"><a href="#" onclick="topLink('alertFind')"><span style="background:url(${ctx}/img/SYSM/page-search-icon.png) no-repeat; padding-left:22px;">告警查询</span></a></li> 
    <li <c:choose><c:when test="${topcss=='alertFindFrame'}">class='act'</c:when><c:otherwise>class='nor'</c:otherwise></c:choose>   id="m"><a href="#" onclick="topLink('alertFindFrame')"><span style="background:url(${ctx}/img/SYSM/usersearch.png) no-repeat; padding-left:22px;">告警规则</span></a></li> 
    <li <c:choose><c:when test="${topcss=='userconfig'}">class='act'</c:when><c:otherwise>class='nor'</c:otherwise></c:choose>   id="m"><a href="#" onclick="openAlert();"><span style="background:url(${ctx}/img/comm/other/03.gif) no-repeat; padding-left:22px;">告警监控</span></a></li>   
	</ul>
	<!--  -->
  </div>
  <div class="contant">
  <h2 class="martop10">告警规则列表</h2> 
      <div id="data" class="greenborder overf pad1" >
       <html:form action="/ismp/domain/local/aim/alertRule.do" method="post">
			<input type="hidden" name="method" value="getPageAlertRule">
			<input type="hidden" name="curpage" id="curpage">
			<input type="hidden" name="disuse" value="1">
	   </html:form>
        <form name="f1" id="f1" action="alertRule.do" method="post">
        	<input type="hidden" name="method" value="deleteAlertRule">
        	<input type="hidden" name="currpage" value="${page.currentPage}">
          <table id="senfe" sortcol="-1">
            <thead>
              <tr>
              	<th><div align="center">全选<input type="checkBox" onclick="checkAll(this,'ruleCheckbox')">反选</div></th>
                <th style="cursor:pointer" onclick="sortTable('senfe',0);">ID <span class="webdings">6</span></th>
                <th>优先级</th>
                <th>类型</th>
                <th>子类型</th>
                <th>状态</th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody>
              <logic:iterate id="l" name="list" indexId="index">
				<tr>
				<td><div align="center"><input type="checkbox" name="ruleCheckbox"
					id="ruleCheckbox" value="${l.id }"></div>
				</td>
				<td>${l.id }</td>
				<td><div align="center">${l.priority }</div>
				</td>
				<td><div align="center">${l.type }</div>
				</td>
				<!-- 
					<td><div align="center"><c:if test="${l.sendMsg==1}">是
				</c:if> <c:if test="${l.sendMsg==0}">
                                                                        否                                                                   
                            </c:if></div>
				</td>
				<td><div align="center"><c:if test="${ l.sendEmail==1}">
                              是
                            </c:if> <c:if test="${ l.sendEmail==0}">
                              否
                            </c:if></div>
				</td>
				<td><div align="center"><c:if test="${ l.sendSms==1}">是	</c:if> 
										<c:if test="${ l.sendSms==0}">否</c:if></div>
				</td>
				 -->
				
				<td><div align="center">${l.subType }</div>
				</td>
				<td><div align="center"><c:if test="${l.enabled==1}">
					<div align="center">已启用</div>
				</c:if> <c:if test="${l.enabled==0}">
					未启用
				</c:if></div>
				</td>
				<!-- 
				<td><div align="center"><c:set value="0" var="flag"></c:set> <logic:notEmpty
					name="roleList">
					<logic:iterate id="role" name="roleList">
						<c:if test="${(role.rolename=='admin'||role.rolename=='user')&&flag==0}">
							<c:set value="1" var="flag"></c:set>
							<div align="center"><a onClick="changeFrameRow()"
								href="alertRule.do?method=getByIdAlertRule&alertRuleId=${l.id }&update=1&curpage=${page.currentPage}">更新</a>
							</div>
						</c:if>
					</logic:iterate>
					<c:if test="${flag==0}"> -- </c:if>
				</logic:notEmpty></div>
				</td>
				 -->
				
				<td>
				<sec:authorize ifAllGranted='ROLE_AdminAll'>
					<div align="center"><a href="#" class="R6" onclick="updateAlert(${l.id },${page.currentPage})">更新</a></div>
				</sec:authorize>
				</td>
				</tr>
				
			</logic:iterate>
            </tbody>
          </table>
        </form>
      </div>
    <ul id="page">
    <sec:authorize ifAllGranted='ROLE_AdminAll'>
    <li><a href="#" class="R6 R7 boxy" title="添加告警规则" onclick="addRule();">添加告警规则</a></li>
    <li><a href="#" class="R6 R7" onclick="javaScript:del()">删除告警规则</a></li>
    </sec:authorize>
    <li><a href="#" class="R6 R7" onClick="disuseSubmit('1')">显示废弃规则</a></li>
    <li><a href="#" class="R6 R7" onClick="disuseSubmit('2')">隐藏废弃规则</a></li>
    <li><a class="first" href="javaScript:FirstPage('1')"></a></li>
	<li><c:if test="${page.hasPrePage==true}"><a class="pre" href="javaScript:upPage('${page.currentPage-1}')"></a></c:if></li>
	<li><c:if test="${page.hasNextPage==true}"><a class="next" href="javaScript:nextPage('${page.currentPage+1 }')"></a></c:if></li>
	<li><a class="last"	href="javaScript:endPage('${page.totalPage }')"></a></li>
	<li>共${page.totalPage } 页 跳至<jsp:include	page="/WEB-INF/content/SYSM/user/other/pageInfo.jsp"></jsp:include></li>
    </ul><br />
      <br />
      <br />
  </div>
  </div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
