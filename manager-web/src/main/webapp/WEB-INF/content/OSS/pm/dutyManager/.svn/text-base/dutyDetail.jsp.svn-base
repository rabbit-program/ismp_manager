<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title>运维支撑--值班管理--排班管理--排班详细记录</title>
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Newcommon.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Maincontant.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/common.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/boxy.css" />
        <link rel="stylesheet" href="${ctx}/css/comm/date/skin/WdatePicker.css" type="text/css" />
        <script type="text/javascript" src="${ctx}/js/comm/date/WdatePicker.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/js/floatdiv.js"></script>
<script type="text/javascript">
var rosterNum = 0;
var rosterArray = new Array();
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

function addRoster(inElement,rosterSelect){
    var rosterCode = rosterSelect.value;
    if(rosterCode == -1){
        alert("请选择要添加的值班人员！");
    }else{
        var rosterIsHas = false;
        for(var i=0; i<rosterArray.length; i++){
            if(rosterArray[i] == rosterCode){
                rosterIsHas = true;
            }
        }
        if(rosterIsHas){
            alert("您好！该人员已在值班列表中，不可重复添加！");
        }else{
            var rosterName = "";
            if (window.ActiveXObject){
                rosterName = rosterSelect.options[rosterSelect.selectedIndex].innerText;
            }else{
                rosterName = rosterSelect.options[rosterSelect.selectedIndex].text;
            }
            if(rosterName.length>=5){
                rosterName = rosterName.substr(0,5)+"...";
            }
            
            var roster = document.createElement("div");
            //var br = document.createElement("br");
            roster.id = rosterCode;
            if (window.ActiveXObject){
                roster.style.styleFloat = "left";
            }else{
                roster.style.cssFloat = "left";
            }
            roster.style.paddingLeft = "10px";
            
            var inHTML = "<span title='"+rosterName+"' style='float: left; width: 60px;'>"+rosterName+"</span>"
                          +"<input id='rostersList' name='rostersList' type='hidden' value='"+rosterCode+"'/>"
                          +"<a href=javascript:delRoster('"+rosterCode+"') style='float: left; padding-top: 3px;' onmouseout=MM_swapImgRestore() onmouseover=MM_swapImage('Image"+rosterCode+"','','${ctx}/img/comm/other/110.gif',1)>"
                               +"<img src='${ctx}/img/comm/other/109.gif' width='12' height='12' border='0' id='Image"+rosterCode+"' name='Image"+rosterCode+"'/>"
                          +"</a>";

            //var x = Math.floor(rosterNum/6);
            //var y = x*6;
            //alert("rosterNum:="+rosterNum+"x:="+x+"y:="+y);
            //if(y==rosterNum && rosterNum>0){
                //alert("换行");
            //    br.id = "br" + x;
            //    inElement.appendChild(br);
                
            //    inHTML = "<span title='"+rosterName+"'>"+rosterName+"</span>"
            //             +"<a href=javascript:delRoster('"+rosterCode+"','"+x+"') onmouseout=MM_swapImgRestore() onmouseover=MM_swapImage('Image"+rosterCode+"','','${ctx}/img/comm/other/110.gif',1)>"
            //                  +"<img src='${ctx}/img/comm/other/109.gif' width='12' height='12' border='0' id='Image"+rosterCode+"' name='Image"+rosterCode+"'/>"
            //             +"</a>";
            //}
            roster.innerHTML = inHTML;
            inElement.appendChild(roster);
            rosterArray.push(rosterCode);
            rosterNum++;
        }
    }
    //$("table tr:eq(3)").after(
    //        "<tr>"+
    //        "<td><table width='100' border='0' cellspacing='0' cellpadding='0'>"+
    //          "<tr>"+
    //            "<td width='73' align='center'>人员姓名"+(currRows-1)+"</td>"+
    //            "<td width='18'><a href='#' onmouseout='MM_swapImgRestore()' onmouseover=MM_swapImage('Image211','','${ctx}/img/comm/other/110.gif',1)><img src='${ctx}/img/comm/other/109.gif' name='Image211' width='12' height='12' border='0' id='Image211' /></a></td>"+
    //          "</tr>"+
    //        "</table></td>"+
    //      "</tr>");
}

function delRoster(rosterCode){
    for(var i=0; i<rosterArray.length; i++){
        if(rosterArray[i] == rosterCode){
            //alert("删除前：="+rosterArray.length);
            rosterArray.splice(i,1);
            //alert("删除后：="+rosterArray.length);
        }
    }
    //for(var j=0; j<rosterArray.length; j++){alert(rosterArray[j])}
    rosterNum--;
    var delElement = document.getElementById(rosterCode);
    delElement.style.display = "none";
    while(delElement.hasChildNodes()){
        delElement.removeChild(delElement.firstChild);
    }
    delElement.id="hasDel";
}

//function delRoster(rosterCode, brCode){
//    for(var i=0; i<rosterArray.length; i++){
//        if(rosterArray[i] == rosterCode){
//            rosterArray.splice(i,1);
//        }
//    }
//    rosterNum--;
    
//    document.getElementById(rosterCode).style.display = "none";
//    var x = Math.floor(rosterNum/6);
//    var y = x*6;
   // if(){
        
   // }
//    document.getElementById("br"+brCode).style.display = "none";
//}
</script>
</head>
<body onload="MM_preloadImages('${ctx}/img/comm/other/109.gif','${ctx}/img/comm/other/110.gif')" >
<div id="contant" class="mainbg" style="width: 700px;">
  <div id="banner" class="grayline overf bannerH" > </div>
  <div class="contant">
    <h2 >值班信息</h2>
  <div id="data" class="greenborder overf pad1" >
       <form action="${ctx}/ismp/oss/pm/dsinfo.do?method=dsadd" method="post" name="f1" id="f1">
          <table width="100%" id="senfe" sortcol="-1">
              <tr>
                 <th width="18%" style="">委办局<span class="webdings"></span></th>
                <td colspan="5"><label for="textfield"></label>
                      <input type="text" id="doselect" value="<bean:write name='dutySchedule' property='domain.domainName'/>" disabled="disabled"/>
              <span style="color: red;margin-left: 5px">投诉电话：<bean:write name="phoneComplaint"/> </span></td>
              </tr>
              <tr>
                <th width="18%" style="">时间<span class="webdings"></span></th>
               <td colspan="6">
                    <input type="text" size="8" id="startTime" name="startTime" class="input" value="<bean:write name='dutySchedule' property='startTime'/>" disabled="disabled"/> 
                    —
                    <input type="text" size="8" id="endTime" name="endTime" class="input" value="<bean:write name='dutySchedule' property='endTime'/>" disabled="disabled"/>
                </td>
              </tr>
              <tr>
             <th width="18%" style="">人员指定<span class="webdings"></span></th>
                <td colspan="5">
                    <div style="padding-top: 15px;padding-bottom: 5px;float: left;">
                        <div style="border: 1px solid #A4CE31;float: left;min-width: 500px;max-width: 546px;">
                            <div id="rosterShow" style="line-height: 20px;">
                                <input id="rosterNum" name="rosterNum" type="hidden" value="0"/>
                             <logic:iterate id="ds" name="dutySchedule" property="roster" scope="request" indexId="len">
                                <div id="<bean:write name='len' />" style="float: left; padding-left: 10px;">
                                    <span title="<bean:write name='ds' property='id' />" style="float: left; width: 60px;"><bean:write name='ds' property='name'/></span>
                                    <input id='rostersList' name='rostersList' type='checkbox' value='03' style='display: none;'/>
                                    <a href="javascript:delRoster('03')" style="float: left; padding-top: 3px;" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image03','','${ctx}/img/comm/other/110.gif',1)">
                                        <img src="${ctx}/img/comm/other/109.gif" width="12" height="12" border="0" id="Image03" name="Image03"/>
                                    </a>
                                </div>
                          </logic:iterate>
                            </div>
                        </div>
                    </div>
                    
                </td>
              </tr>
              </tr>
              <tr>
                <th width="18%" style="">值班<span class="webdings"></span></th>
                <td colspan="5"><textarea name="textfield" cols="100%" rows="5" id="textfield"    disabled="disabled"><bean:write name='dutySchedule' property='task'/></textarea></td>
              </tr>
          </table>
       
    </div>  


    <div class="martop8 Height_t">
  </div>
  </div>
    </form>
  </div>
</div>
<script type="text/javascript">
      rosterNum =3;// document.getElementById('rosterNum').value;
      rosterArray.push(01);
      rosterArray.push(02);
      rosterArray.push(03);
</script>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>