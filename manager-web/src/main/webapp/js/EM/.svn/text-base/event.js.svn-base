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

function MM_jumpMenu(targ,selObj,restore){ //v3.0
    eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
    if (restore) selObj.selectedIndex=0;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

function goPage() {
    var mark=document.getElementById("mark").value;
    window.location.target="mainFrame";
    window.location.href="${basePath }/eventAction.do?method=showListByTag"+"&mark="+mark;    
   }

function selectAll(){
	var checkBoxList = document.getElementsByName("operate");
	for(i=0; i < checkBoxList.length; i++) {
		   checkBoxList[i].checked = true;
	}
}

function reset(){
	var checkBoxList = document.getElementsByName("operate");
    for(i=0; i < checkBoxList.length; i++) {
           if(checkBoxList[i].checked){
        	   checkBoxList[i].checked = false;
           }
    }
}

function doDelete(){
    var defineName = document.getElementById("defineName").value;
    var defaultMark = document.getElementById("defaultMark").value;
    var deleteIn = "";
    var isSelect = false;
    for(var i = 0; i < document.getElementsByName("operate").length; i ++){
        if(document.getElementsByName("operate")[i].checked){
            deleteIn = deleteIn + document.getElementsByName("operate")[i].value + ",";
            isSelect = true;
        }
    }  
    if(isSelect == false){
        alert("请选择你要删除的记录");
        return;
    }
    if(window.confirm("你确定要删除吗?")){
    	window.location.target="mainFrame";
        window.location.href="${basePath }/eventAction.do?method=deleteEvent&deleteIn="+deleteIn+"&mark="+defaultMark+"&eventName="+defineName;
    }
}

function selectChange(){
	var value = document.getElementById("eventDefine").value;
	if(value=="0"){
		document.getElementById("button3").disabled=true;
	}else{
		document.getElementById("button3").disabled=false;
	}
}

function addDefineEvent(){
	var defineIn = "";
	var isSelect = false;
	var selectValue = document.getElementById("eventDefine").value;
	for(var i = 0; i < document.getElementsByName("operate").length; i ++){
        if(document.getElementsByName("operate")[i].checked){
        	defineIn = defineIn + document.getElementsByName("operate")[i].value + ",";
        	isSelect = true;
        }
    }
	if(isSelect == false){
		alert("请选择你要增加到自定义事件"+selectValue+"的记录");
        return;
	}
	var allCondition = defineIn + selectValue;
	window.location.target="mainFrame";
	window.location.href="${basePath }/eventAction.do?method=addDefineEvent&defineEventCondition="+allCondition;
}