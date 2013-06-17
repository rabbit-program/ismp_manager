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
<script type="text/javascript">
	//动态显示时间     
	function showDynamicTime() {
		var de = new Date();
		var dvalue = de.toLocaleString();
		document.getElementById("timeId").value = dvalue;
		setTimeout("showDynamicTime()", "1000");
	}
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
		//document.getElementById("curpage").value = document
		//		.getElementById("mid").value;
		//document.getElementById("curpage").value = curpage;
		document.forms[0].submit();
	}
	function fwdChange() {
		var subType = document.getElementById("alertquer.alertSubType");
		for ( var i = 0; i < subType.options.length; i++) {
			if (subType.options[i].value == '') {
				subType.options[i].selected = true;
			}
		}
		document.forms[0].submit();
	}
	function checkForm() {
		var bid = document.getElementById("bid").value;
		var eid = document.getElementById("eid").value;
		var dip = document.getElementById("dip").value;
		if (eid != '') {
			if (eid.search("^-?\\d+$") != 0) {
				alert('id必须整数');
				return;
			}
		}
		if (bid != '') {
			if (bid.search("^-?\\d+$") != 0) {
				alert('ID必须整数');
				return;
			}
		}

		var ip = /^([1-9]|[1-9]\d|1\d{2}|2[0-1]\d|22[0-3])(\.(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])){3}$/;
		if (dip != '') {
			if (ip.test(dip) == false) {
				alert('IP格式不对（例如:192.168.9.253）');
				return;
			}
		}

		document.forms[0].submit();
	}
	function openAlertDetail(id) {
		window
				.open(
						'alert.do?method=alertRuleFwd&alertLinkageId=' + id + '',
						'newAlertDetailwindow',
						'height=500,width=1000,top=100,left=400,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');

	}
	function updateFusionRule() {
		var fustionTime = document.getElementById("fusioin").value;
		document.getElementById("fusionTime").value = fustionTime;
		document.forms[1].submit();
	}
	
	function flushBySelf(){
	    var queryForm = document.getElementById("myForm");
	        queryForm.submit();
	}
	/**
	function openAlert(){                
		   alertsubWin = window.open ('${ctx }/ismp/domain/local/aim/alert.do?method=getListPageAlertAction&MinWindow=1','newwindow_Alert','height=400,width=900,top=300,left=400,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no') ;
	    }**/
	function MM_openBrWindow(theURL,winName,features) {
		window.open(encodeURI(theURL),winName,features);
	}
</script>
</head>
<body onLoad="showDynamicTime();">
<form id="myForm"  action="alert.do" method="post">
<input type="hidden" name="method" value="getListPageAlertAction"> 
<input type="hidden" name="home" value="1"> 
<input type="hidden" name="curpage"	id="curpage" value="${page.currentPage}">
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" >
  	<jsp:include page="/WEB-INF/content/AIM/top.jsp"></jsp:include>
  </div>
  <div class="contant">
  <h2 class="martop10">请选择查询条件</h2>
    <div class="greenborder greenback overf pad3 Height_a" >
      <span style="float:left;">每页
      <select name="pageSize" onChange="fwd()">
			<c:if test="${pageSize== null}">
				<option value="10" selected="selected">10</option>
			</c:if>
			<c:forEach begin="1" end="50" var="i">
				<c:if test="${i%5==0}">
					<c:if test="${pageSize==i}">
						<option value="${i }" selected="selected">${i }</option>
					</c:if>
					<c:if test="${pageSize!=i}">
						<option value="${i }">${i }</option>
					</c:if>
				</c:if>
			</c:forEach>
			<option value="">-全部-</option>
		</select>
      条状态
      <select name="alertquer.status" onChange="fwd()">
			<option value="2">-全部-</option>
			<c:if test="${alertinfoQuery.status==0}">
				<option value="0" selected="selected">已读</option>
			</c:if>
			<c:if test="${alertinfoQuery.status!=0}">
				<option value="0">已读</option>
			</c:if>
			<c:if test="${alertinfoQuery.status==1}">
				<option value="1" selected="selected">未读</option>
			</c:if>
			<c:if test="${alertinfoQuery.status!=1}">
				<option value="1">未读</option>
			</c:if>
		</select>
      类型<select name="alertquer.alertType" onChange="fwdChange()">
			<logic:notEmpty name="altypeList">
				<option value="">-全部-</option>
				<logic:iterate id="al" name="altypeList">
					<c:if test="${al.typeMarker==1}">
						<c:if test="${al.typeName==alertinfoQuery.alertType}">
							<option value="${al.typeName}" selected="selected">${al.typeName}</option>
						</c:if>
						<c:if test="${al.typeName!=alertinfoQuery.alertType}">
							<option value="${al.typeName}">${al.typeName }</option>
						</c:if>
					</c:if>
				</logic:iterate>
			</logic:notEmpty>
		</select>
      子类型<select id="alertquer.alertSubType" name="alertquer.alertSubType"
			onChange="fwd()">
			<option value="">-全部-</option>
			<logic:notEmpty name="subTypeList">
				<logic:iterate id="al" name="subTypeList">
					<c:if test="${al.typeName==alertinfoQuery.alertSubType}">
						<option value="${al.typeName }" selected="selected">${al.typeName}</option>
					</c:if>
					<c:if test="${al.typeName!=alertinfoQuery.alertSubType}">
						<option value="${al.typeName }">${al.typeName }</option>
					</c:if>
				</logic:iterate>
			</logic:notEmpty>
		</select>
      
      <input type="text" class="input" name="textfield" readonly="readonly" id="timeId"	size="24" />归并窗
     <select name="alertquer.fusiontimepage"
			onChange="updateFusionRule()" id="fusioin">
			<c:if test="${1==alertFusionRuleBO.fusionTime}">
				<option value="1" selected="selected">1分钟</option>
			</c:if>
			<c:if test="${5==alertFusionRuleBO.fusionTime}">
				<option value="5" selected="selected">5分钟</option>
			</c:if>
			<c:if test="${30==alertFusionRuleBO.fusionTime}">
				<option value="30" selected="selected">30分钟</option>
			</c:if>
			<c:if test="${60==alertFusionRuleBO.fusionTime}">
				<option value="60" selected="selected">1小时</option>
			</c:if>
			<c:if test="${120==alertFusionRuleBO.fusionTime}">
				<option value="120" selected="selected">2小时</option>
			</c:if>
			<c:if test="${240==alertFusionRuleBO.fusionTime}">
				<option value="240" selected="selected">4小时</option>
			</c:if>
			<c:if test="${480==alertFusionRuleBO.fusionTime}">
				<option value="480" selected="selected">8小时</option>
			</c:if>
			<c:if test="${1!=alertFusionRuleBO.fusionTime}">
				<option value="1">1分钟</option>
			</c:if>
			<c:if test="${5!=alertFusionRuleBO.fusionTime}">
				<option value="5">5分钟</option>
			</c:if>
			<c:if test="${30!=alertFusionRuleBO.fusionTime}">
				<option value="30">30分钟</option>
			</c:if>
			<c:if test="${60!=alertFusionRuleBO.fusionTime}">
				<option value="60">1小时</option>
			</c:if>
			<c:if test="${120!=alertFusionRuleBO.fusionTime}">
				<option value="120">2小时</option>
			</c:if>
			<c:if test="${240!=alertFusionRuleBO.fusionTime}">
				<option value="240">4小时</option>
			</c:if>
			<c:if test="${480!=alertFusionRuleBO.fusionTime}">
				<option value="480">8小时</option>
			</c:if>
		</select></span> 
    </div>
    <div class="pad3 overf">
      <h2 class="martop10">查看列表</h2>
      <logic:notEmpty name="list">
      <div id="data" class="greenborder overf pad1" >
          <table id="senfe" sortcol="-1">
            <thead>
              <tr>
                <th style="cursor:pointer" onclick="sortTable('senfe',0);">ID <span class="webdings">6</span></th>
                <th>时间</th>
                <th>优先级</th>
                <th>类型</th>
                <th>子类型</th>
                <th>类别</th>
                <th>事件描述</th>
                <th>状态</th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody>
            <logic:iterate id="l" name="list" indexId="index">
              <tr>
                <td> ${l.id } </td>
                <td><div align="center"> <bean:write property="time" name="l" format="yyyy年MM月dd日  HH:mm:ss" /></div> </td>
                <td><div align="center">${l.level }</div></td>
                <td><div align="center">${l.alertType }</div></td>
                <td><div align="center">${l.alertSubType }</div></td>
                <td><div align="center">${l.type}</div></td>
                <td><div align="center">${l.rawContent }</div></td>
                <td><div align="center"><c:if test="${l.status==1}"><img src="${ctx }/img/AIM/unread.gif" /></c:if></div></td>
                <td><a href="#" class="R6" onclick="MM_openBrWindow('${ctx}/ismp/domain/local/aim/alert.do?method=getByIdAlert&alertId=${l.id }','告警详情','scrollbars=yes,width=600,height=500');" title="查看详细内容">查看</a></td>
              </tr>
             </logic:iterate>
            </tbody>
          </table>
      </div>
      
      <ul id="page">
        	<li><a class="first" href="javaScript:FirstPage('1')"></a></li>
            <li><c:if test="${page.hasPrePage==true}"> <a class="pre" href="javaScript:upPage('${page.currentPage-1}')"></a></c:if></li>
            <li><c:if test="${page.hasNextPage==true}"><a class="next" href="javaScript:nextPage('${page.currentPage+1 }')"></a></c:if></li>
            <li><a class="last" href="javaScript:endPage('${page.totalPage }')"></a></li>
            <li>共${page.totalPage } 页 跳至<jsp:include page="/WEB-INF/content/SYSM/user/other/pageInfo.jsp"></jsp:include></li>
      </ul>
      </logic:notEmpty>
      <logic:empty name="list">
      	<div align="center">没有相关记录</div>
      </logic:empty>
      <br />
      <br />
      <br />
    </div>
  </div>
</div>
</form>

<html:form action="/ismp/domain/local/aim/alert.do" method="post">
	<input type="hidden" name="method" value="alertSorUfusion">
	<input type="hidden" name="home" value="1">
	<input type="hidden" name="fusionTime" id="fusionTime">
</html:form>

</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>