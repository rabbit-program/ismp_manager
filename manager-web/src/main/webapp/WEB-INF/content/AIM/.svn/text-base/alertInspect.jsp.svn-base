<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>告警监控</title>
<%@ include file="/common/taglibs.jsp"%>
<bgsound id="snd" loop="0" src="">
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx }/js/Calendar/WdatePicker.js"></script>
<script type='text/javascript' src='${ctx }/dwr/engine.js'></script>
<script type='text/javascript' src='${ctx }/dwr/util.js'></script>
<script type='text/javascript' src='${ctx }/dwr/interface/checkIfNew.js'></script>


<script type="text/javascript">
    //DWR 检查是否有新告警信息
    //屏蔽鼠标右键、Ctrl+N、Shift+F10、F11、F5刷新、退格键     
function document.oncontextmenu(){event.returnValue=false;}//屏蔽鼠标右键     
function window.onhelp(){return false;} //屏蔽F1帮助     
function document.onkeydown()     
{     
if ((window.event.altKey)&&     
((window.event.keyCode==37)|| //屏蔽 Alt+ 方向键 ←     
(window.event.keyCode==39))) //屏蔽 Alt+ 方向键 →     
{     
alert("不准你使用ALT+方向键前进或后退网页！");     
event.returnValue=false;     
}     
   
if ((event.keyCode==8) || //屏蔽退格删除键     
(event.keyCode==116)|| //屏蔽 F5 刷新键     
(event.ctrlKey && event.keyCode==82)){ //Ctrl + R     
event.keyCode=0;     
event.returnValue=false;     
}     
if (event.keyCode==122){event.keyCode=0;event.returnValue=false;} //屏蔽F11     
if (event.ctrlKey && event.keyCode==78) event.returnValue=false; //屏蔽 Ctrl+n     
if (event.shiftKey && event.keyCode==121)event.returnValue=false; //屏蔽 shift+F10     
if (window.event.srcElement.tagName == "A" && window.event.shiftKey)     
window.event.returnValue = false; //屏蔽 shift 加鼠标左键新开一网页     
if ((window.event.altKey)&&(window.event.keyCode==115)) //屏蔽Alt+F4     
{     
window.showModelessDialog("about:blank","","dialogWidth:1px;dialogheight:1px");     
return false;     
}     
}  
    window.focus();      
    var f=0;
    var flagmes=0;
    var endArg=0
    var flagtime=1;
    var logintime;
    function backMethod(data) {
        logintime=document.getElementById("logintime").value;
        if (data >flagmes||data<flagmes) {
            endArg=data;
            document.title = "有新告警信息" + data + "条....";           
            //当有新告警信息的加入时 马上执行查询 得到最新的数据           
            var cur=document.getElementById("curpage").value;
            document.getElementById("ifRefresh").value=2;
            var type=document.getElementById("ty").value;
            var subty=document.getElementById("subty").value;
            var status=document.getElementById("status").value;
            var pagesize=document.getElementById("pagesize").value;
            var fusioin=document.getElementById("fusioin").value;
           //声音提示
            if(data>flagmes){
               window.document.getElementById('snd').src="audio/messageCue.wav";
            } 
            if(data==0){
                document.title = "告警监控";
            }    
            flagmes=data;   
                     
            checkIfNew.getPageListAlertDwrService(cur,pagesize,status,type,subty,fusioin,logintime,bk);
            f=1;
        } else {
               if(f==0){
                      //当有新告警信息的加入时 马上执行查询 得到最新的数据           
                    var cur=document.getElementById("curpage").value;
                    var type=document.getElementById("ty").value;
                    var subty=document.getElementById("subty").value;
                    var status=document.getElementById("status").value;
                    var pagesize=document.getElementById("pagesize").value;
                    var fusioin=document.getElementById("fusioin").value;
                    
                    checkIfNew.getPageListAlertDwrService(cur,pagesize,status,type,subty,fusioin,logintime, bk);     
                    f=1;
                    document.title = "告警监控";
               }    
        }
        
        setTimeout("checkIfNew.getChecknNewAlertinfoService('"+logintime+"',backMethod)", 5000);
    }

    function bk(date) {
        var page = date[1];
        var rs = date[0]; 
        var tab = document.getElementById("data");
        var pagetab=document.getElementById("pageTb");
        var rowNum = tab.rows.length;
        var rowPageNum=pagetab.rows.length;
        //清空表格
        for ( var i = 0; i < rowNum; i++) {
            tab.deleteRow(i);
            rowNum = rowNum - 1;
            i = i - 1;
        }
          for ( var i = 0; i < rowPageNum; i++) {
              pagetab.deleteRow(i);
              rowPageNum = rowPageNum - 1;
              i = i - 1;
          }
        //添加新表格
        var newTr = tab.insertRow(-1);

        var th=document.createElement("th");
        th.innerHTML="ID";
        newTr.appendChild(th);
        //添加新表格
        var th1=document.createElement("th");
        th1.innerHTML="时间";
        newTr.appendChild(th1);
        //添加新表格
        var th2=document.createElement("th");
        th2.innerHTML="优先级";
        newTr.appendChild(th2);
        //添加新表格
        var th3=document.createElement("th");
        th3.innerHTML="类型";
        newTr.appendChild(th3);
        //添加新表格
        var th4=document.createElement("th");
        th4.innerHTML="子类型";
        newTr.appendChild(th4);
        //添加新表格
        var th5=document.createElement("th");
        th5.innerHTML="事件描述";
        newTr.appendChild(th5);
        //添加新表格
        var th6=document.createElement("th");
        th6.innerHTML="状态";
        newTr.appendChild(th6);

        //循环打印表格的内容  ;
        for ( var j = 0; j < rs.length; j++) {
            //添加新表格        
            var tabrow = tab.insertRow(-1);
            if(j%2==0){
                tabrow.className="graytr";
            }
            //添加列
            var newTd01 = tabrow.insertCell(-1);
            var newTd11 = tabrow.insertCell(-1);
            var newTd21 = tabrow.insertCell(-1);
            var newTd31 = tabrow.insertCell(-1);
            var newTd41 = tabrow.insertCell(-1);
            var newTd51 = tabrow.insertCell(-1);
            var newTd61 = tabrow.insertCell(-1);
            //设置表头的显示 值 
            newTd01.innerHTML = "<div align='center'><a href='javascript:openAlertDetail("+rs[j].id+")' title='查看详细内容'>" + rs[j].id + "</a></center>";
            if(rs[j].time==null){
                newTd11.innerHTML = "<div align='center'></center>";
            }else{
            newTd11.innerHTML = "<div align='center'>"
                    + rs[j].time.toLocaleString() + "</center>";
            }
            if(rs[j].level==null){
                 newTd21.innerHTML = "<div align='center'></center>";
            }else{
                 newTd21.innerHTML = "<div align='center'>" + rs[j].level
                         + "</center>";
            }if(rs[j].alertType==null){
                 newTd31.innerHTML = "<div align='center'></center>";
            }else{
                 newTd31.innerHTML = "<div align='center'>"+rs[j].alertType
                         + "</center>";
            }if(rs[j].alertSubType==null){
                   newTd41.innerHTML = "<div align='center'></center>"
            }else{            
                   newTd41.innerHTML = "<div align='center'>" + rs[j].alertSubType
                             + "</center>"
            }
            
            if(rs[j].rawContent==null){
                newTd51.innerHTML = "<div align='center'></center>"
            }else{
                  newTd51.innerHTML = "<div align='center'>"+rs[j].rawContent
                          + "</center>"
            }
           
           
           
          
            if (rs[j].status == 0) {
                newTd61.innerHTML = "<div align='center'></center>"
            } else if (rs[j].status == 1) {
                newTd61.innerHTML = "<div align='center'><img src='${ctx}/img/AIM/unread.gif'></img></center>"
            }
        }
        if(rs.length<=0){
             //添加新表格        
            var tabrow = tab.insertRow(-1);
            //添加列
            var newTd01 = tabrow.insertCell(-1);
            var newTd02 = tabrow.insertCell(-1);
            var newTd03 = tabrow.insertCell(-1);
            var newTd04 = tabrow.insertCell(-1);
            var newTd05 = tabrow.insertCell(-1);
            var newTd06 = tabrow.insertCell(-1);
            var newTd07 = tabrow.insertCell(-1);
            newTd05.innerHTML="<p align='center'>暂未收到告警信息</p>";
        }


        //循环完后 打印 分页TR TD
    
        var newTrx = pagetab.insertRow(-1);
        //添加列
        var newTd0x = newTrx.insertCell(-1);
        newTrx.style.width = "100%";        
        newTd0x.style.width = "100%";
        newTd0x.colspan = '7'
        newTd0x.height = "26"
        newTd0x.align = "right"
        newTd0x.bgcolor = "#E6E6E6"
        	  var str="<div id='page'> <ul> <li><a class='first'  href='javaScript:FirstPageNoRefresh(1)'></a>";
        
        if(page.hasPrePage==true){
            str=str+"<li><a  class='pre' href='javaScript:upPageNoRefresh("+(page.currentPage-1)+")'></a></li>";           
        }
        if(page.hasNextPage==true){
            str=str+"<li><a class='next' href='javaScript:nextPageNoRefresh("+(page.currentPage+1)+")'></a><li>";   
        }

        str=str+"<li><a href='javaScript:endPageNoRefresh("+page.totalPage+")'  class='last'></a></li>共"+page.totalPage+"页,跳至";
        str=str+"<input type='hidden' id='maxPagesize' value='"+page.totalPage+"'>";
        str=str+"<input type='hidden' id='curpageSize' value='"+page.currentPage+"'>"
        str=str+"<input type='text' size='3' maxlength='7' value='"+page.currentPage+"' id='mid'"+
        " name='mark' onkeypress='return event.keyCode>=48&&event.keyCode<=57||event.keyCode==46'"+
        " onpaste='return !clipboardData.getData(text).match(/\D/)'"+
        " ondragenter='return false' style='ime-mode: Disabled' />";
        str=str+"<input type='button' value='GO' onclick='checkPagenumber(1)'>";
        newTd0x.innerHTML=str;
        
    }
    function checkPagenumber(typid){
        var maxpagesize=document.getElementById("maxPagesize").value;
        var fwdPagesize=document.getElementById("mid").value;
        if((fwdPagesize.indexOf("-")   ==   0)||!(fwdPagesize.indexOf(".")   ==   -1)){
            alert("跳转页数只能是整数!");
            document.getElementById("mid").focus();
            return ;
        }
        if(parseInt(fwdPagesize)>parseInt(maxpagesize)||fwdPagesize<=0){
            alert("输入的页数范围有误,请重新输入!");
            document.getElementById("mid").focus();
            return;
        }
        fwd(typid);
    }
    
    function FirstPageNoRefresh(curpage) {
          var type=document.getElementById("ty").value;
        var subty=document.getElementById("subty").value;
        var status=document.getElementById("status").value;
        var pagesize=document.getElementById("pagesize").value;
        var fusioin=document.getElementById("fusioin").value;
        document.getElementById("curpage").value = curpage;
       logintime=document.getElementById("logintime").value;
       //int curpage,String pagesize,String status,String type,String subType,String fusioin)
        checkIfNew.getPageListAlertDwrService(curpage,pagesize,status,type,subty,fusioin,logintime, bk);
    }
    function nextPageNoRefresh(curpage) {
        var type=document.getElementById("ty").value;
        var subty=document.getElementById("subty").value;
        var status=document.getElementById("status").value;
        var pagesize=document.getElementById("pagesize").value;
        var fusioin=document.getElementById("fusioin").value;
        document.getElementById("curpage").value = curpage;
        logintime=document.getElementById("logintime").value;
       //int curpage,String pagesize,String status,String type,String subType,String fusioin)
        checkIfNew.getPageListAlertDwrService(curpage,pagesize,status,type,subty,fusioin,logintime, bk);
    }
    function upPageNoRefresh(curpage) {
        var type=document.getElementById("ty").value;
        var subty=document.getElementById("subty").value;
        var status=document.getElementById("status").value;
        var pagesize=document.getElementById("pagesize").value;
        var fusioin=document.getElementById("fusioin").value;
        document.getElementById("curpage").value = curpage;
        logintime=document.getElementById("logintime").value;
       //int curpage,String pagesize,String status,String type,String subType,String fusioin)
        checkIfNew.getPageListAlertDwrService(curpage,pagesize,status,type,subty,fusioin,logintime, bk);
    }
    function endPageNoRefresh(curpage) {
        var type=document.getElementById("ty").value;
        var subty=document.getElementById("subty").value;
        var status=document.getElementById("status").value;
        var pagesize=document.getElementById("pagesize").value;
        var fusioin=document.getElementById("fusioin").value;
        logintime=document.getElementById("logintime").value;
        document.getElementById("curpage").value = curpage;
       //int curpage,String pagesize,String status,String type,String subType,String fusioin)
        checkIfNew.getPageListAlertDwrService(curpage,pagesize,status,type,subty,fusioin,logintime, bk);
    }

    //动态显示时间     
    function showDynamicTime() {
        if(flagtime==1){
            logintime=document.getElementById("logintime").value;
            checkIfNew.getChecknNewAlertinfoService(logintime,backMethod);
        }
        flagtime=0;
        var de = new Date();
        var dvalue = de.toLocaleString();
        document.getElementById("timeId").value = dvalue;
        setTimeout("showDynamicTime()", "1000");
    }
    function fwd(curpage) {
        document.getElementById("curpage").value = document
            .getElementById("mid").value;
        var type=document.getElementById("ty").value;
        var subty=document.getElementById("subty").value;
        var status=document.getElementById("status").value;
        var pagesize=document.getElementById("pagesize").value;
        var fusioin=document.getElementById("fusioin").value;
        logintime=document.getElementById("logintime").value;
       //int curpage,String pagesize,String status,String type,String subType,String fusioin)       
        checkIfNew.getPageListAlertDwrService(document.getElementById("mid").value,pagesize,status,type,subty,fusioin,logintime, bk);
    }
  //类型 下拉框发生值改变事件就根据类型名找出子类型
    function fwdAl() {
              var type=document.getElementById("ty").value;
              var subty=document.getElementById("subty").value;
              var status=document.getElementById("status").value;
              var pagesize=document.getElementById("pagesize").value;
              var fusioin=document.getElementById("fusioin").value;
             //int curpage,String pagesize,String status,String type,String subType,String fusioin)
              var cur=document.getElementById("curpage").value;
              logintime=document.getElementById("logintime").value;
              checkIfNew.getPageListAlertDwrService(cur,pagesize,status,type,subty,fusioin,logintime, bk);
    }
    //回调函数 更改子类型下拉框
    function subblack(data){
         if(data!=null){
            var subty=document.getElementById("subty"); 
            subty.options.length=0;
            var varItem1 = new Option("-全部-","");
            subty.options.add(varItem1); 
             for(var i=0;i<data.length;i++){     
                var varItem = new Option(data[i].typeName,data[i].typeName);
                subty.options.add(varItem);             
            }            
         } 

         var type=document.getElementById("ty").value;       
         var status=document.getElementById("status").value;
         var pagesize=document.getElementById("pagesize").value;
         var fusioin=document.getElementById("fusioin").value;
        //int curpage,String pagesize,String status,String type,String subType,String fusioin)
         var cur=document.getElementById("curpage").value;
         logintime=document.getElementById("logintime").value;
         checkIfNew.getPageListAlertDwrService(cur,pagesize,status,type,"",fusioin,logintime, bk);
    }
    
    function  fwdAlChange() {
        	
             var ifrefresh=document.getElementById("ifRefresh").value
             var type=document.getElementById("ty").value;             
             checkIfNew.getSubTypeByNameService(type,subblack);    
   }

    //查看告警详细内容
    function openAlertDetail(id){
        window.open ('alert.do?method=alertRuleFwd&alertId='+id+'','alertDetailWindow','height=500,width=1000,top=100,left=400,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no') ;
        document.getElementById("curpage").value = document.getElementById("mid").value;
        var type=document.getElementById("ty").value;
        var subty=document.getElementById("subty").value;
        var status=document.getElementById("status").value;
        var pagesize=document.getElementById("pagesize").value;
        var fusioin=document.getElementById("fusioin").value;
        logintime=document.getElementById("logintime").value;
       //int curpage,String pagesize,String status,String type,String subType,String fusioin)       
        checkIfNew.getPageListAlertDwrService(document.getElementById("mid").value,pagesize,status,type,subty,fusioin,logintime, bk);
    }
    function saveOrUpdateFustionRule(){
        var fusion=document.getElementById("fusioin").value;
        checkIfNew.saveOrUpdateAlertFustionRule(fusion);
    }
    
</script>
<style type="text/css">
<!--
.STYLE1 {
	color: #FFFFFF;
	font-weight: bold;
	font-size: 14px;
}

body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body onLoad="showDynamicTime();">
<div id="contant" >
<div id="main">
<html:form action="/ismp/domain/local/aim/alert.do" method="post">
	<input type="hidden" name="method" value="getListPageAlertAction">
	<input type="hidden" name="curpage" id="curpage"
		value="${page.currentPage}">
	<input name="MinWindow" value="1" type="hidden">
	<input type="hidden" name="ifRefresh" value="1" id="ifRefresh">
	<input name="first" type="hidden" value="${first}">
	<input type="hidden" id="logintime" value="${monitorTime }">
	 <div class="greenborder greenback overf pad3 Height_a">
		<div align="center">
		<div align="center"><input type="text" class="input" name="textfield"
			readonly="readonly" id="timeId" size="24" /> 每页 <select
			name="pageSize" onChange="fwdAl()" id="pagesize">
			<option value="">-全部-</option>
			<c:forEach begin="1" end="50" var="i">
				<c:if test="${i%5==0}">
					<option value="${i }">${i }</option>
				</c:if>
			</c:forEach>
		</select> 条 状态 <select name="alertquer.status" onChange="fwdAl()" id="status">
			<option value="2">-全部-</option>
			<option value="0">已读</option>
			<option value="1">未读</option>
		</select> 类型 <select name="alertquer.type" onChange="fwdAlChange();" id="ty">
			<logic:notEmpty name="altypeList">
				<option value="">-全部-</option>
				<logic:iterate id="al" name="altypeList">
					<c:if test="${al.typeMarker==1}">
						<option value="${al.typeName }">${al.typeName }</option>
					</c:if>
				</logic:iterate>
			</logic:notEmpty>
		</select> 子类型 <select name="alertquer.subType" onChange="fwdAl()" id="subty">
			<logic:notEmpty name="altypeList">
				<option value="">-全部-</option>
				<logic:notEmpty name="subTypeList">
					<logic:iterate id="al" name="subTypeList">
						<option value="${al.typeName }">${al.typeName }</option>
					</logic:iterate>
				</logic:notEmpty>
			</logic:notEmpty>
		</select> 归并窗 <select name="alertquer.fusiontimepage"
			onChange="saveOrUpdateFustionRule()" id="fusioin">
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
		</select></div>
		</div>
     </div> 
     <br />
     <div id="mainblock">
        
		<table width="100%" border="0" align="left" cellpadding="0"
			cellspacing="1" id="data" class="biaoge">
		</table>
		<br><br><br><br><br><br>
		<table id="pageTb" width="100%" border="0" align="left" cellpadding="0"
			cellspacing="1" class="biaoge">
		</table>
    </div>
</html:form>
 </div>
</div>
</body>
</html>
