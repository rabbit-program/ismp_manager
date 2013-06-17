function checklogin() {
        var uname = document.getElementById("user.username").value;
        var pwd = document.getElementById("pwd").value;
        if (uname == '' || pwd == '') {
            alert('用户名或者密码不能为空！');
            document.getElementById("user.username").focus();
            return;
        }
        document.forms[0].submit();
}
function resetForm() {
        var uname = document.getElementById("user.username").value = "";
        var pwd = document.getElementById("pwd").value = "";
}

document.onkeypress = function() {
        if (event.keyCode == 13){
            checklogin();
         }
} 
function UserNamefoucs(){
      document.getElementById("user.username").focus();  
      document.getElementById("user.username").select();
}  

function checkPagenumber(typid){
   
    var maxpagesize=document.getElementById("maxPagesize").value;
    var fwdPagesize=document.getElementById("mid").value;
    if((fwdPagesize.indexOf("-")   ==   0)||!(fwdPagesize.indexOf(".")   ==   -1)){
        alert("跳转页数只能是整数!");
        document.getElementById("mid").value=1;
        document.getElementById("mid").select();
        return ;
    }
    if(parseInt(fwdPagesize)>parseInt(maxpagesize)||fwdPagesize<=0){
        alert("输入的页数范围有误,请重新输入!");
        document.getElementById("mid").value=1;
        document.getElementById("mid").select();
        return;
    }
    var curPage=document.getElementById("mid").value;
    fwd(typid);
}

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
