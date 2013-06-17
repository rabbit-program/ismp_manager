function goPage(totalPage,href) {
    var mark=document.getElementById("mark").value;
    if(mark > totalPage){
        alert("最大页码值为："+totalPage);
        document.getElementById("mark").value = "";
        document.getElementById("mark").focus();
        return;
    }if(mark <= 0 || isNaN(mark)){
        alert("请输入有效的页码值!!");
        document.getElementById("mark").value = "";
        document.getElementById("mark").focus();
        return;
    }else{
	   window.location.href=href+"&pageNo="+mark;
    }
}