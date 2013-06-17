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
<script type='text/javascript' src='${ctx }/dwr/interface/checkIfNew.js'></script>
<script type='text/javascript' src='${ctx }/dwr/engine.js'></script>
<script type='text/javascript' src='${ctx }/dwr/util.js'></script>
<script type="text/javascript">

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
    function fwdCustomPage(curpage){
        document.getElementById("curpage").value = document
                .getElementById("mid").value;
        document.forms[0].submit();
    }

    function fwd(curpage) {
		//document.getElementById("curpage").value = document
		//		.getElementById("mid").value;
		//document.getElementById("curpage").value = curpage;
		document.forms[0].submit();
	}

    function checkForm() {
        var bid = document.getElementById("bid").value;
        var eid = document.getElementById("eid").value;

        if (eid != '') {
            if (eid.search("^-?\\d+$") != 0) {
                alert('ID必须整数');
                return;
            }
        }
        if (bid != '') {
            if (bid.search("^-?\\d+$") != 0) {
                alert('ID必须整数');
                return;
            }
        }
        document.forms[0].submit();
    }
    function onchangeCheckForm() {
        var bid = document.getElementById("bid").value;
        var eid = document.getElementById("eid").value;
        var subType=document.getElementById("alertquer.subType");
        for(var i=0;i<subType.options.length;i++)
        {         
            if(subType.options[i].value==''){
                 subType.options[i].selected=true; 
            }                 
        }
        if (eid != '') {
            if (eid.search("^-?\\d+$") != 0) {
                alert('ID必须整数');
                return;
            }
        }
        if (bid != '') {
            if (bid.search("^-?\\d+$") != 0) {
                alert('ID必须整数');
                return;
            }
        }
     

        document.forms[0].submit();
    }

    function openAlertDetail(id){
        window.open ('alert.do?method=alertRuleFwd&alertLinkageId='+id+'','newAlertDetailwindow','height=500,width=1000,top=100,left=400,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no') ;
        
    }

    //告警 的类型 下拉框改变后 动态查询 出子类型
    function  changeChilType() {
             var type=document.getElementById("alertquer.alertType").value;          
             checkIfNew.getSubTypeByNameService(type,subblack);    
   }
    //回调函数 更改子类型下拉框
    function subblack(data){
         if(data!=null){
            var subty=document.getElementById("alertquer.alertSubType"); 
            subty.options.length=0;
            var varItem1 = new Option("-全部-","");
            subty.options.add(varItem1); 
             for(var i=0;i<data.length;i++){  
                var varItem = new Option(data[i].typeName,data[i].typeName);
                subty.options.add(varItem);             
            }            
         } 
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
<body >
 <form id="myForm" action="alert.do" method="post">
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" >
    <jsp:include page="/WEB-INF/content/AIM/top.jsp"></jsp:include>
  </div>
  <div class="contant">
  <h2 class="martop10">请选择查看方式</h2>   
<div id="data" class="greenborder overf pad1" >
   
		<input type="hidden" name="method" value="getListPageAlertAction">
		<input type="hidden" name="curpage" id="curpage" value="${page.currentPage}">
		<input value="2" name="alertquer.status" type="hidden">
          <table>
            <thead>
              <tr>
                <th>告警ID</th>
                <td>
                  <input name="alertquer.beginIdpage" type="text" size="10"
					style="width: 73px" id="bid" maxlength="12" class="input"
					value=${alertinfoQuery.beginIdpage }> 到 <input
					name="alertquer.endIdpage" type="text" size="10" class="input"
					value="${alertinfoQuery.endIdpage }" style="width: 73px" id="eid"
					maxlength="12"></td>
                <th>告警时间</th>
                <td><input id="d5221" class="Wdate" style="width: 141px"
					readonly="readonly" name="alertquer.beginDatepage" size="18"
					type="text" value="${ alertinfoQuery.beginDatepage}"
					onFocus="var d5222=$dp.$('d5222');WdatePicker({onpicked:function(){d5222.focus();},dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'d5222\')}'})" />
				至 <input id="d5222" readonly="readonly" style="width: 141px"
					name="alertquer.endDatepage" class="Wdate" size="18" type="text"
					value="${alertinfoQuery.endDatepage }"
					onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'d5221\')}'})" /></td>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th>告警原因</th>
                <td><input type="text" class="input" name="alertquer.alertReason"
					value="${alertinfoQuery.alertReason }" style="width: 174px"></td>
                <th>节 点 ID</th>
                <td><input type="text" class="input" name="alertquer.nodeId"
					value="${alertinfoQuery.nodeId }" style="width: 141px"></td>
              </tr>
              <tr>
                <th>告 警 源IP</th>
                <td><input type="text" class="input" name="alertquer.srcIp"
					value="${alertinfoQuery.srcIp }" style="width: 174px"></td>
                <th>告警类型:</th>
                <td><input type="text" class="input" name="alertquer.type"
					value="${alertinfoQuery.type }" style="width: 141px"></td>
              </tr>
              <tr>
                <th>类    型</th>
                <td><span style="float:left;">
                  <select name="alertquer.alertType" id="alertquer.alertType"
					style="width: 177px" onChange="changeChilType();">
					<logic:notEmpty name="altypeList">
						<option value="">-全部-</option>
						<logic:iterate id="al" name="altypeList">
							<c:if test="${al.typeMarker==1}">
								<c:if test="${al.typeName==alertinfoQuery.alertType}">
									<option value="${al.typeName }" selected="selected">${al.typeName
									}</option>
								</c:if>
								<c:if test="${al.typeName!=alertinfoQuery.alertType}">
									<option value="${al.typeName }">${al.typeName }</option>
								</c:if>
							</c:if>
						</logic:iterate>
					</logic:notEmpty>
				</select>
                </span></td>
                <th>子 类 型</th>
                <td><span style="float:left;">
                  <select id="alertquer.alertSubType" style="width: 145px"
					name="alertquer.alertSubType">
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
                </span></td>
              </tr>
              <tr>
                <th>优 先 级</th>
                <td>
                <select name="alertquer.beginPrioritypage"
					style="width: 76px">
					<option value="">-全部-</option>
					<c:forEach begin="1" var="i" end="5">
						<c:if test="${alertinfoQuery.beginPriority==i}">
							<option value="${i }" selected="selected">${i }</option>
						</c:if>
						<c:if test="${alertinfoQuery.beginPriority!=i}">
							<option value="${i }">${i }</option>
						</c:if>
					</c:forEach>
				</select> 到 <select name="alertquer.endPrioritypage" style="width: 77px">
					<option value="">-全部-</option>
					<c:forEach begin="1" var="i" end="5">
						<c:if test="${alertinfoQuery.endPriority==i }">
							<option value="${i }" selected="selected">${i }</option>
						</c:if>
						<c:if test="${alertinfoQuery.endPriority!=i }">
							<option value="${i }">${i }</option>
						</c:if>
					</c:forEach>
				</select>
                </td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
            </tbody>
          </table>
          
      </div>
      <br />
      <span class="martop10">
      <input name="button2" type="button" onclick="checkForm()"	class="submit" id="button2" value="搜 索" />
      </span>
      <c:if test="${page!=null}">
       <h2 class="martop10">查看列表</h2>
    <div id="data" class="greenborder overf pad1" >
        <logic:notEmpty name="list">
          <table id="senfe" sortcol="-1">
            <thead>
              <tr>
                <th style="cursor:pointer" onclick="sortTable('senfe',0);">ID <span class="webdings">6</span></th>
                <th><div align="center">时间</div> </th>
                <th><div align="center">优先级</div> </th>
                <th><div align="center">类型</div> </th>
                <th><div align="center">子类型</div> </th>
                <th><div align="center">类别</div> </th>
                <th><div align="center">事件描述</div> </th>
                <th><div align="center">状态</div> </th>
                <th><div align="center">操作</div> </th>
              </tr>
            </thead>
            <tbody>
              <logic:iterate id="l" name="list" indexId="index">
						<tr >
						<td>${l.id}	</td>
						<td>
							<div align="center"><bean:write property="time" name="l"
								format="yyyy年MM月dd日  HH:mm:ss" /></div>
						</td>
						<td>
							<div align="center">${l.level }</div>
						</td>
						<td>
							<div align="center">${l.alertType }</div>
						</td>
						<td>
							<div align="center">${l.alertSubType }</div>
						</td>
						<td>
							<div align="center">${l.type}</div>
						</td>
						<td>
							<div align="center">${l.rawContent }</div>
						</td>
						<td>
							<div align="center"><c:if test="${l.status==1}">
								<img src="${ctx }/img/AIM/unread.gif">
							</c:if> </div>
						</td>
						<td>
							<div align="center">
							<a href="#" class="R6" onclick="MM_openBrWindow('${ctx}/ismp/domain/local/aim/alert.do?method=getByIdAlert&alertId=${l.id }','告警详情','scrollbars=yes,width=600,height=500');" title="查看详细内容"r>查看</a>
							</div>
						</td>
						</tr>
					</logic:iterate>
            </tbody>
          </table>
          </logic:notEmpty>
      </div>
    <ul id="page">
       			<li><a class="first" href="javaScript:FirstPage('1')"></a></li>
				<li><c:if test="${page.hasPrePage==true}">
					<a class="pre" href="javaScript:upPage('${page.currentPage-1}')"></a>
				</c:if></li>
				<li><c:if test="${page.hasNextPage==true}">
					<a class="next"
						href="javaScript:nextPage('${page.currentPage+1 }')"></a>
				</c:if></li>
				<li><a class="last"
					href="javaScript:endPage('${page.totalPage }')"></a></li>
				<li>共${page.totalPage } 页 跳至<jsp:include page="/WEB-INF/content/SYSM/user/other/pageInfo.jsp"></jsp:include></li>
    </ul><br />
    </c:if>
      <br />
      <br />
  </div>
  </div>
  </form>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
