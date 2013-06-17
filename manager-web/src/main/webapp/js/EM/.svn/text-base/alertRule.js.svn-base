        var ie=document.all; 
        var nn6=document.getElementById&&!document.all; 
        var isdrag=false; 
        var y,x; 
        var oDragObj; 
        
        function moveMouse(e) { 
        if (isdrag) { 
        oDragObj.style.top  =  (nn6 ? nTY + e.clientY - y : nTY + event.clientY - y)+"px"; 
        oDragObj.style.left  =  (nn6 ? nTX + e.clientX - x : nTX + event.clientX - x)+"px"; 
        return false; 
        } 
        } 
        
        function initDrag(e) { 
        var oDragHandle = nn6 ? e.target : event.srcElement; 
        var topElement = "HTML"; 
        while (oDragHandle.tagName != topElement && oDragHandle.className != "dragAble") { 
        oDragHandle = nn6 ? oDragHandle.parentNode : oDragHandle.parentElement; 
        } 
        if (oDragHandle.className=="dragAble") { 
        isdrag = true; 
        oDragObj = oDragHandle; 
        nTY = parseInt(oDragObj.style.top+0); 
        y = nn6 ? e.clientY : event.clientY; 
        nTX = parseInt(oDragObj.style.left+0); 
        x = nn6 ? e.clientX : event.clientX; 
        document.onmousemove=moveMouse; 
        return false; 
        } 
        } 
        document.onmouseup=new Function("isdrag=false"); 
        
        function mouseOut(){
         alert("dddd");
        
        }
        var newWindowObject;
        function checkRuleForm(){
             var subType=document.getElementById("alertRulebo.subType").value;
             var type=document.getElementById("alertRulebo.type").value;
             var priority=document.getElementById("alertRulebo.priority").value;
             if(subType==''||type==''||priority==''){
                 alert('带红色*号的为必填!');
                 return;
             }
             var sendMsg=document.getElementsByName("alertRulebo.sendMsg");
             for(var i=0;i<sendMsg.length;i++){
                  if(sendMsg[i].checked == true){
                      if(sendMsg[i].value==1){
                            var msgTarget=document.getElementById("alertRulebo.msgTarget").value;
                            if(msgTarget==''){
                                alert('启用了桌面消息告警后！桌面IP地址不能为空');
                                return ;
                            }else{
                                var msgTargets=msgTarget.split(";");
                                if(msgTargets.length>10){
                                    alert("桌面IP地址不能大于10个");
                                    return ;
                                }
                            }
                                                                   
                      }
                  }
             }
             var email=document.getElementsByName("alertRulebo.sendEmail");
             for(var j=0;j<email.length;j++){
                  if(email[j].checked == true){
                      if(email[j].value==1){
                            var emailTarget=document.getElementById("alertRulebo.emailTarget").value;
                            if(emailTarget==''){
                                alert('启用了Email消息告警后！Email地址不能为空');
                                return ;
                            }else{
                                var emails=emailTarget.split(";");
                                if(emails.length>10){
                                    alert("Email地址不能大于10个");
                                    return ;
                                }
                            }
                            if(!/(\S)+[@]{1}(\S)+[.]{1}(\w)+/.test(emailTarget)){
                                alert('Email地址格式不正确(例如:*****@****.com)');
                                return ;
                            }
                      }
                  }
             }
             var sms=document.getElementsByName("alertRulebo.sendSms");
             for(var k=0;k<sms.length;k++){
                  if(sms[k].checked == true){
                      if(sms[k].value==1){
                            var smsTarget=document.getElementById("alertRulebo.smsTarget").value;
                            if(smsTarget==''){
                                alert('启用了短消息告警后！短消息号码不能为空');
                                return;
                            }else{
                                var smss=smsTarget.split(";");
                                if(smss.length>10){
                                    alert("手机号码地址不能大于10个");
                                    return ;
                                }
                            }
                           
                      }
                  }
             }             
             document.forms[0].submit();
        }
        function checkDisabled(disabledId){
             document.getElementById(disabledId).style.background='#FFFFFF';
             document.getElementById(disabledId).disabled=false;
        }
        function checkDisabledFalse(disabledId){
            document.getElementById(disabledId).value="";
            document.getElementById(disabledId).style.background='#B4B4B4';
            document.getElementById(disabledId).disabled=true;
       }

       function checkSubType(){
           var type=document.getElementById("alertRulebo.type").value;
           checkIfNew.getSubTypeByNameService(type,subblack); 
       }
     //回调函数 更改子类型下拉框
       function subblack(data){
            if(data!=null){
               var subty=document.getElementById("alertRulebo.subType"); 
               subty.options.length=0;
               var varItem1 = new Option("-请选择-","");
               subty.options.add(varItem1); 
                for(var i=0;i<data.length;i++){     
                   var varItem = new Option(data[i].typeName,data[i].typeName);
                   subty.options.add(varItem);             
               }            
            } 
       }

       function openOrcloseSearchUser(flag){
           if(flag==true){
               document.getElementById("usSearch").style.top=-200;
               document.getElementById("usSearch").style.left=200;
               var tab = document.getElementById("alertTbid");
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
               document.getElementById("usSearch").style.display="";
           }
           if(flag==false){
               document.getElementById("usSearch").style.display="none";
           }
       }
     function queryUser() {
         var userName=document.getElementById("uservo.username").value;
         var trueName=document.getElementById("uservo.soothname").value;
         checkIfNew.getUserPageListService(userName,trueName,1,bk); 
     }
     function FirstPageNoRefresh(curpage) {
         var userName=document.getElementById("uservo.username").value;
         var trueName=document.getElementById("uservo.soothname").value;
         checkIfNew.getUserPageListService(userName,trueName,curpage,bk); 
     }
     function nextPageNoRefresh(curpage) {
         var userName=document.getElementById("uservo.username").value;
         var trueName=document.getElementById("uservo.soothname").value;
         checkIfNew.getUserPageListService(userName,trueName,curpage,bk); 
     }
     function upPageNoRefresh(curpage) {
         var userName=document.getElementById("uservo.username").value;
         var trueName=document.getElementById("uservo.soothname").value;
         checkIfNew.getUserPageListService(userName,trueName,curpage,bk); 
     }
     function endPageNoRefresh(curpage) {
         var userName=document.getElementById("uservo.username").value;
         var trueName=document.getElementById("uservo.soothname").value;
         checkIfNew.getUserPageListService(userName,trueName,curpage,bk); 
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
         fwd(fwdPagesize);
     }
     function fwd(curpage) {
         var userName=document.getElementById("uservo.username").value;
         var trueName=document.getElementById("uservo.soothname").value;
         checkIfNew.getUserPageListService(userName,trueName,curpage,bk); 
     }
     function bk(date) {
           var page = date[1];
           var rs = date[0];      
           var tab = document.getElementById("alertTbid");
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
           th.innerHTML="";
           newTr.appendChild(th);
           //添加新表格
           var th1=document.createElement("th");
           th1.innerHTML="用户名";
           newTr.appendChild(th1);
           //添加新表格
           var th2=document.createElement("th");
           th2.innerHTML="真实姓名";
           newTr.appendChild(th2);
           //添加新表格
           var th3=document.createElement("th");
           th3.innerHTML="Email";
           newTr.appendChild(th3);
           //添加新表格
           var th4=document.createElement("th");
           th4.innerHTML="手机号码";
           newTr.appendChild(th4);
           //添加新表格
           var th5=document.createElement("th");
           th5.innerHTML="终端IP";
           newTr.appendChild(th5);

           //循环打印表格的内容  ;
           for ( var j = 0; j < rs.length; j++) {
               //添加新表格        
               var tabrow = tab.insertRow(-1);
               if(j%2==0){
            	   tabrow.className="graytr";
        	   }
               tabrow.onmousemove="trMouseUp('"+j+"')" ;
               tabrow.id=j;
               //添加列
               var newTd01 = tabrow.insertCell(-1);
               var newTd11 = tabrow.insertCell(-1);
               var newTd21 = tabrow.insertCell(-1);
               var newTd31 = tabrow.insertCell(-1);
               var newTd41 = tabrow.insertCell(-1);
               var newTd51 = tabrow.insertCell(-1);
               //设置表头的显示 值 
               var contacts=rs[j].terminalIp+":"+rs[j].email+":"+rs[j].mobile;
               newTd01.innerHTML = "<input type=checkBox name='checkBoxcontacts' id='checkBoxcontacts' value='"+contacts+"'>";
               if(rs[j].username==null){
                   newTd11.innerHTML = "<div align='center'></center>";
               }else{
                    newTd11.innerHTML = "<div align='center'>"
                       + rs[j].username + "</center>";
               }
               if(rs[j].soothname==null){
                    newTd21.innerHTML = "<div align='center'></center>";
               }else{
                    newTd21.innerHTML = "<div align='center'>" + rs[j].soothname
                            + "</center>";
               }if(rs[j].email==null){
                    newTd31.innerHTML = "<div align='center'></center>";
               }else{
                    newTd31.innerHTML = "<div align='center'>"+rs[j].email
                            + "</center>";
               }if(rs[j].mobile==null){
                      newTd41.innerHTML = "<div align='center'></center>"
               }else{            
                      newTd41.innerHTML = "<div align='center'>" + rs[j].mobile
                                + "</center>"
               }
               
               if(rs[j].terminalIp==null){
                   newTd51.innerHTML = "<div align='center'></center>"
               }else{
                     newTd51.innerHTML = "<div align='center'>"+rs[j].terminalIp
                             + "</center>"
               }
           }
           if(rs.length<=0){
        	   //添加新表格\
        	   var message="<ul class='border  minheight'>"
      				+"<li style='width: 100%'><img src='images/no_records.png'/>没有找到记录!"
      				+"<span class='alert'>(If there is no records, use this block) </span></li></ul>";
               var newTrmes = tab.insertRow(-1);
               var td=document.createElement("TD");
               td.colSpan=6
               td.innerHTML=message;
               newTrmes.appendChild(td);
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

       function spiltContacts(){
           var a = document.getElementsByName("checkBoxcontacts");
           var n = a.length;
           var k = 0;
           for (var i=0; i<n; i++){
                if(a[i].checked){
                    var contactsList=a[i].value.split(":");
                    for(var j=0;j<contactsList.length;j++){
                    	if(contactsList[j]!= 'null'){
	                        if(j==0){
	                              var msg=document.getElementById("alertRulebo.msgTarget").value;
	                              if(msg==''){
	                                  document.getElementById("alertRulebo.msgTarget").value=contactsList[j];
	                              }else{
	                                  msg=msg+";"+contactsList[j]
	                                  document.getElementById("alertRulebo.msgTarget").value=msg;                                                       
	                              }
	                              document.getElementById("alertRulebo.sendMsg").checked=true;
	                              checkDisabled("alertRulebo.msgTarget");
	                        }
	                        if(j==1){ 
	                             var email=document.getElementById("alertRulebo.emailTarget").value;
	                             if(email==''){
	                                 document.getElementById("alertRulebo.emailTarget").value=contactsList[j];
	                             }else{
	                                 email=email+";"+contactsList[j]
	                                 document.getElementById("alertRulebo.emailTarget").value=email;                                                       
	                             }
	                             document.getElementById("alertRulebo.sendEmail").checked=true;
	                             checkDisabled("alertRulebo.emailTarget");
	                        }
	                        if(j==2){
	                             var sms=document.getElementById("alertRulebo.smsTarget").value;
	                             if(sms==''){
	                                 document.getElementById("alertRulebo.smsTarget").value=contactsList[j];
	                             }else{
	                                 sms=sms+";"+contactsList[j]
	                                 document.getElementById("alertRulebo.smsTarget").value=sms;                                                       
	                             }
	                             document.getElementById("alertRulebo.sendSms").checked=true;
	                             checkDisabled("alertRulebo.smsTarget");
	                        }
                    	}
                    }
                    k = 1;
                }
            }
            if(k==0){
                alert("选择至少选择一个用户!");    
                return;
            }else{
                 document.getElementById("usSearch").style.display="none";
                 return ;
            }
       }  //单选按钮全选
       function checkAll(e, itemName) 
       { 
         var aa = document.getElementsByName(itemName); 
         for (var i=0; i<aa.length; i++) 
          aa[i].checked = e.checked; 
       } 
       function checkItem(e, allName) 
       { 
         var all = document.getElementsByName(allName)[0]; 
         if(!e.checked) all.checked = false; 
         else 
         { 
           var aa = document.getElementsByName(e.name); 
           for (var i=0; i<aa.length; i++) 
            if(!aa[i].checked) return; 
           all.checked = true; 
         } 
       } 
