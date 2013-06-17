
//打开对话框-自己定义大小
function openCustomDialog(url,width,hieght,top,left,windowName){
        window.open (url,windowName,'height='+hieght+',width='+width+',top='+top+',left='+left+',toolbar=no,menubar=no,scrollbars=yes,resizable=no,location=no,status=no')
}
//打开对话框
function openDialog(url,windowName){
      window.open ('alert.do?method=getListPageAlertAction&MinWindow=1',windowName,'height=400,width=900,top=300,left=400,toolbar=no,menubar=no,scrollbars=yes,resizable=no,location=no,status=no')
}


//删除对话框
function del(url,message){
     if(confirm(message)){                        
           location.href=url;
       }else{                         
           return;
       }       
}
//后退 页面 
function backPage(pageNumber){
     history.go(pageNumber);    
}
//替换单击后的高亮图片
function changeCss(id,oldImg,newImg){
		var selectId=document.getElementById("selectId").value;
		document.getElementById(selectId).src=oldImg;
		document.getElementById(id).src=newImg;
		document.getElementById("selectId").value=id;
}

//=========分页====================
function checkPagenumberonblur(typid){
    
    var maxpagesize=document.getElementById("maxPagesize").value;
	var fwdPagesize=document.getElementById("mid").value;
	if((fwdPagesize.indexOf("-")   ==   0)||!(fwdPagesize.indexOf(".")   ==   -1)){
	    alert("跳转页数只能是整数!");
	    return ;
	}
	if(parseInt(fwdPagesize)>parseInt(maxpagesize)||fwdPagesize<=0){
	    alert("输入的页数范围有误,请重新输入!");
	    return;
	}
}
function FirstPage(curpage,formNumber) {
    document.getElementById("curpage").value = curpage;
    document.forms[formNumber].submit();
}
function upPage(curpage,formNumber) {
    document.getElementById("curpage").value = curpage;
    document.forms[formNumber].submit();
}
function nextPage(curpage,formNumber) {
    document.getElementById("curpage").value = curpage;
    document.forms[formNumber].submit();
}
function endPage(curpage,formNumber) {
    document.getElementById("curpage").value = curpage;
    document.forms[formNumber].submit();
}
function fwdCustomPage(curpage,formNumber){
    document.getElementById("curpage").value = document
            .getElementById("mid").value;
    document.forms[formNumber].submit();
}
function checkPagenumberonblur(){
    
    var maxpagesize=document.getElementById("maxPagesize").value;
    var fwdPagesize=document.getElementById("mid").value;
    if((fwdPagesize.indexOf("-")   ==   0)||!(fwdPagesize.indexOf(".")   ==   -1)){
        alert("跳转页数只能是整数!");
        return ;
    }
    if(parseInt(fwdPagesize)>parseInt(maxpagesize)||fwdPagesize<=0){
        alert("输入的页数范围有误,请重新输入!");
        return;
    }
    fwdCustomPage(fwdPagesize,0);
}