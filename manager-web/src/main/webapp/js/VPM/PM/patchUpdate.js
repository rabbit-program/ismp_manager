
 $(window).load(function(){
     SCContext("?method=getDoMainSensorCenter");
     patchTree();
	});
function allto(){
	 SCContext("?method=getDoMainSensorCenter");
}
function patchTree()
{
	  var simpleTreeCollection;
	  var name="";
	  var id="";
	    simpleTreeCollection = $('.simpleTree').simpleTree({
	        autoclose: true,
	        drag:false,
	        afterClick:function(node){
	           var name=$('span:first',node).text();
	           var id=$('span:first',node).attr("shid");
	           var isleaf=$('span:first',node).attr("isleaf");
	           if(isleaf == 0){
	        	   SCContext("?method=getDoMainSensorCenter&domainid="+id);
	           }else{
	        	   SCContext("?method=getDoMainSensorCenter&clientid="+id);
	           }
	        },
	        animate:true
	    });
	    checkalsj();
}

/**
 * ajax 请求处理
 */
function SCContext(url)
{
	url =$.trim("patchAction.do"+url);
	$.ajax({
		type:"POST",
		url:url,
		contentType:'html',
		cache:false,
		success: function(responce){
			$("#senfe").find("tr:gt(0)").remove(); 
			$(responce).find('SH').each(function(index,edata){
				$("#senfe > tbody").append(
		                "<tr><td><input class=\'noneborder\' type=\'checkbox\' name=\'courseid'\' id=\'"+index+"'\'/></td>"+
		                "<td>"+ $(this).children("ip").text() +"</td>"+
		                "<td><span style=\'float:left\'>"+$(this).children("name").text()+"</span> </td>"+
		                "<td><span style=\'float:left\'>"+$(this).children("update").text()+"</span></td>"+
		                "<td><span style=\'float:left\'>"+$(this).children("uptime").text()+"</span></td>"+
		                "<td> "+$(this).children("uttime").text()+" </td>"+
		                "<td><a href=\'javascript:void(0)\' id=\'wboxcl\'  class=\'R6 R7\'>策略定制</a></td></tr>").
		                find("tr:eq("+index+")").data("d"+index,$(this).children("id").text());
				
				$('#senfe > tbody').find("tr:eq("+index+")").each(function(){
					$(this).find('td a').each(function(indexs,even){
	    				$(even).bind('click', function() {
	    					findTactics($(edata).children('id').text(),$(edata).children('pid').text(),url,"object");
	    					return false;
	    				});
					});
				});
				
                });

	         $('#senfe > tbody').find("tr").each(function(index){
	    		 var cloroStr="#EEEEEE";
	    		 if(index % 2 == 0){  //#FDF4DB
	    			 cloroStr="#FFFFFF"
	    		 }
	    		 $(this).css('backgroundColor',cloroStr);
	    		 $(this).hover(function(){
	    			 $(this).css('backgroundColor','#FDF4DB');
	    		 },function(){
	    			 $(this).css('backgroundColor',cloroStr);
	    		 });
	    	 });
		  
		  $(responce).find('PAGE').each(function(index){
			   var totalpage=$(this).children("totalPage").text();
			   $("#page li span[id='pageSize']").text(totalpage);
			   $("#page").data("dqdata",$(this).children('currentPage').text());
			   showPageGo(getUrlMethod(url,"domainid"),totalpage,fytime($(this).children('starttime').text(),$(this).children('endtime').text()));
			   showPageNext('pre', $(this).children('hasPrePage').text(),getUrlMethod(url,"domainid"),(Number($(this).children('currentPage').text())-1),fytime($(this).children('starttime').text(),$(this).children('endtime').text()));
			   showPageNext('next',$(this).children('hasNextPage').text(),getUrlMethod(url,"domainid"),(Number($(this).children('currentPage').text())+1),fytime($(this).children('starttime').text(),$(this).children('endtime').text()));
			   showPageNext('first',"true",getUrlMethod(url,"domainid"),1,fytime($(this).children('starttime').text(),$(this).children('endtime').text()));
			   showPageNext('last',"true",getUrlMethod(url,"domainid"),$(this).children('totalPage').text(),fytime($(this).children('starttime').text(),$(this).children('endtime').text()));
          });
		  
		  $("#checkall1").click(function(){
				if(this.checked){
					$("input[name=courseid]").each(function(){
						this.checked=true;
					});
				}else{
					$("input[name=courseid]").each(function(){
						this.checked=false;
					});
				}
				
		  });
		  
		  $("#seachdiv a[@name=seachTime]").unbind('click').click(function(){
			 SCContext( "?method=getDoMainSensorCenter&domainid="+getUrlMethod(url,"domainid")+fytime($("#createStartDate").val(),$("#createEndDate").val()));
		  });
		  $("#page a[id=tacitcsa]").unbind('click').click(function(){
				findTactics("",null,url,"list");
				return false;
		  });
	}});
}

function findTactics(idvalue,pid,url,bs){
	Boxy.shload("pmUpdateTacticsAction.do",{'sve':[{"id":idvalue,"data":this}]},function(data){
		var tselect =$(data).find("#tactics");
		$.post('TacticsAction.do?method=getPatchUpdateTacicsAll',function(responceText){
	         $(responceText).find('UPTACTICS').each(function(index,evendate){
	        	 $("<Option "+ (pid == $(this).children('tid').text() ? "selected = selected" : " ") +" value='" + $(this).children('tid').text() + "'>" + $(this).children('tname').text() + "</Option>").appendTo(tselect);
	         });  
		},'html');
		if(pid){
			selectTacticsName(pid,data);
		}
		tselect.change(function(){
			if($(this)[0].selectedIndex > 0){
				selectTacticsName(tselect.val(),data);
				  $(data).find("#formok").click(function(){
					  if(bs == "list"){
						  var valueArray = new Array();
							$("#senfe > tbody").find("tr").each(function(index,checkedData){
								 var tdObject= $(checkedData).find("td").children(".noneborder");
								 if(tdObject[0].checked){
									 valueArray.push("sidList="+$(checkedData).data("d"+tdObject.attr("id")));
								 }
							});
						var turl ="?method=updateListTactics&"+valueArray.join('&')+"&tid="+tselect.val()+"&domainid="+
							  getUrlMethod(url,"domainid")+"&curpage="+$("#page").data("dqdata")+"&clientid=" + getUrlMethod(url,"clientid");
						SCContext(turl);
					  }else if(bs =="object"){
						  var turl ="?method=updateTactics&sid="+Boxy.getEleValue(data)[0].id +"&tid="+tselect.val()+"&domainid="+
						  getUrlMethod(url,"domainid")+"&curpage="+$("#page").data("dqdata")+"&clientid=" + getUrlMethod(url,"clientid");
						  SCContext(turl);
					  }
					  Boxy.get(data).hide();
				  });
			 }else{
				 $(data).find("#formok").unbind('click');
			 }
			 
			
		});
	});
}

function selectTacticsName(tselect,data){
	 $.ajax({
		   type:"POST",
		   url:"TacticsAction.do?method=getTacticsInfo&tid="+tselect,
		   success:function(responce){
			  $(responce).find("TACTICS").each(function(){
				  //    $(this).children('').text()
				  var td = $(data).find("td");
				  td.find("#ites"+$(this).children('isAutoUpdate').text()+"")[0].checked=true;
				  td.find('#tupW')[0].value=$(this).children('updateWay').text();
				  td.find("#uptime").val($(this).children('updateTime').text()); 
				  var ptdefault =td.find("#qdpt");
				  var vdefault =$(this).children('updateAddress').text();
				  if(ptdefault.val() == $.trim(vdefault)){
					  ptdefault[0].checked=true;
					  td.find("#optionalAddress").hide('slow');
				  }else{
					  ptdefault[0].checked=false;
					  td.find("#xyaddress").val(vdefault);
					  td.find("#optionalAddress").show('slow');
				  }
				 // $(data).find("td > #"+($(this).children('isAutoUpdate').text())).checked=true;
			  });
	       }
	 });
}

//全选事件 初始事件
function checkalsj()
{
	  $("#checkall1but").toggle(function(){
		  
		  $("input[name=courseid]").each(function(){
			  this.checked=true;
			});
		  $("#page li a[@id=checkall1but]").html("反选");
	  },function(){
		  $("input[name=courseid]").each(function(){
			   this.checked = this.checked ? false : true;
			});
		  $("#page li a[@id=checkall1but]").html("全选");
	  });	
	  $("#seachdiv  a[@name=resetdate]").click(function(){
		 $("#seachdiv input[type=text]").attr("value","");
	  });
	 
	  
	  
}

function getUrlMethod(url,methodName)
{
	 var reg = new RegExp("(^|&|\\?)"+ methodName +"=([^&]*)(&|$)"); 
	 var mvalue=url.match(reg);
	 return  mvalue ? mvalue[2] : "";
}

function fytime(statdate,enddate)
{
	 return (statdate ? "&createStartDate=" + statdate : "") + (enddate ? "&createEndDate=" + enddate : "") ;
}
function showPageGo(domainid,totalpabe,strPage)
{
	$("#page li input[@id=tpageCount]").unbind('keyup').keyup(function(){
		         
		$("#senfe > tbody").find("tr").each(function(index){
			alert($(this).data("d"+index));
		});
		  var v = Number($("#page li input[@id=tpageCount]").attr("value"));
		  var regu = /^[-]{0,1}[0-9]{1,}$/;
		  if(!regu.test(v))return;
		  var v1 =Number(totalpabe);
		  if(v > v1){
			  $("#page li a[@id=pageGo]").html('NO');
			  $("#page li a[@id=pageGo]").unbind('click');
		  }else{
			  $("#page li a[@id=pageGo]").html('GO');
			  $("#page li a[@id=pageGo]").unbind('click').click(function(){ 
				  SCContext("?method=getDoMainSensorCenter&domainid="+domainid+"&curpage="+$('#page li input[@id=tpageCount]').attr('value')+strPage);  
			  });
		  }
	});
}

function showPageNext(cp,ish,domainid,curpage,strPage)
{
	   if(eval(ish))
	   {
		   $("#page li a[@class="+cp+"]").show().unbind('click').click(function(){
			   var url="?method=getDoMainSensorCenter&domainid="+domainid+"&curpage="+curpage+strPage;
			   SCContext(url);    
		   });
	   }else{
		   $("#page li a[@class="+cp+"]").hide();
	   }
}
