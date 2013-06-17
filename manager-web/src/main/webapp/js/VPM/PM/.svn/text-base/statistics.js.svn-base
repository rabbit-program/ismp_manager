jQuery.fn.extend({
	divTile:function(title,Content){
	return this.after("<div></div>").next().eq(0).attr("id","messageDiv").append("<h2>"+title+"</h2>").append("<div></div>").children("h2").toggle(function(){
		     var msdiv1 = $(this).next();
		     msdiv1.animate({height:'0px',width:'0px',opacity:'0'},500).data('h',msdiv1.height()).data('w',msdiv1.width());
		     
	},function(){
		 var msdiv= $(this).next();
		 msdiv.animate({height:msdiv.data('h'),width:msdiv.data('w'),opacity:'1'},500);
	}).one('click',function(){$.windowDataWidth();}).addClass("martop10").attr("id","clientTitle").next("div").addClass("greenborder greenback overf pad3").css({height:'auto',widht:'auto'}).attr("id","clientInfo").append(Content);
},
trClor:function(){
	 return $(this).find("tr").each(function(index){
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
}
});
jQuery.extend({
	divMessage:function(sm,em){
	return $("<span></span>").html(sm).add($("<b></b>").addClass("font_tip marright10").html(em));
},
windowDataWidth:function(){
	 var innerDiv= $("#setailsInfo");
	 $(window).data("win", $(window).width());
	 $(window).resize(function(){
		 var winw = this;
		  $("div[id=messageDiv]").each(function(){
				 var thisnext = $(this).children("#clientInfo");
		         if($(winw).width() > $(window).data("win") && thisnext.width() > 0){
		        	     thisnext.animate({width:innerDiv.width()},500);
		         }else if($(winw).width() < $(window).data("win") && thisnext.width() > 0){
		        		 var xdiv  = $(winw).width() - $(window).data("win") +  thisnext.width();
		        		 thisnext.animate({width:xdiv},500);
		         }else{
		        	 thisnext.data('w', innerDiv.width());
		         }
		  });;
		$(window).data("win", $(window).width());
	   return false;
	});
},
getUrlMethod:function(url,methodName){
	 var reg = new RegExp("(^|&|\\?)"+ methodName +"=([^&]*)(&|$)"); 
	 var mvalue=url.match(reg);
	 return  mvalue ? mvalue[2] : "";
}
});
function allto(){
	ps.sDoMainAjax("statisticsAction.do?method=getCountDomain&sdid=-1");
}
$(window).load(function(){
	ps.sTree();
	ps.sDoMainAjax("statisticsAction.do?method=getCountDomain&sdid=-1");
});

var ps ={
		sClientAjax:function(urlc){
		 $.post(urlc,function(responseText){
			 $(responseText).find("CLIENT").each(function(){
				 $("#setailsInfo").nextAll("#messageDiv").remove();
				 var msclient = $.divMessage("所属委办局：",$(this).children('doMain').text()).add($.divMessage("&nbsp;&nbsp;客户端名称：",
						 $(this).children('name').text()).add($.divMessage("&nbsp;&nbsp;安装端Ip： ",$(this).children('ip').text())));
				 
				 var mspacth= $.divMessage("补丁总数：",$(this).children('allPatchUpdateInfoNum').text()).add($.divMessage("已安装补丁数： ",
						 $(this).children('allPatchUpdateOkNum').text()).add($.divMessage("安装失败补丁数：",
						 $(this).children('allPatchUpdateFailedNum').text()).add( $.divMessage("需要更新补丁数： ",
						 $(this).children('allPatchUpdateNeedNum').text()).add($.divMessage("未知状态补丁数：",$(this).children('allPatchUpdateNoNum').text())))));
				 $("#setailsInfo").divTile("客户端补丁信息",mspacth);
				 $("#setailsInfo").divTile("客户端信息",msclient);
				 var senfeTR = $("#senfe > thead");
				 if(!(senfeTR.find("tr:eq(0)").css('display') == 'none')){
					 senfeTR.find("tr:eq(0)").hide();
				 }
				 senfeTR.find("tr:eq(1)").show();
				 $("#senfe > tbody").find("tr").remove();
				 $(responseText).find('PATCHINFO').each(function(index){
					 $("#senfe > tbody").append(
							 "<tr><td>"+$(this).children('patchName').text()+"</td>"+
							 "<td><span>"+$(this).children('uptype').text()+"</span></td>"+
							 "<td><span>"+$(this).children('state').text()+"</span></td>"+
							 "<td><span>"+$(this).children('desc').text()+"</span></td></tr>");
					 $("#senfe > tbody").find("tr:eq("+index+") td > span").css({float:'left'});
				 });
				 $("#senfe > tbody").trClor();
				 $(responseText).find('PAGE').each(function(index){
					   var totalpage=$(this).children("totalPage").text();
					   $("#page li span[id='pageSize']").text(totalpage);
					   var url = "statisticsAction.do?method=getCountSensor&scid="+$.getUrlMethod(urlc,"scid");
					   var cpagetext = $(this).children('currentPage').text();
					   Page.onDownPage('pre', $(this).children('hasPrePage').text(),cpagetext,url,"0");
					   Page.onDownPage('next',$(this).children('hasNextPage').text(),cpagetext,url,"0");
					   Page.onDownPage('first','true',1,url,"0");
					   Page.onDownPage('last','true',$(this).children('totalPage').text(),url,"0");
					   Page.goPage(totalpage,url,"0");
			    });
			 });
		 },'html');
},
		sDoMainAjax:function(urld){
		 $.post(urld,function(responseText){
			  //    $(this).children('').text()
			 $("#setailsInfo").nextAll("#messageDiv").remove();
			 var pdiv= $("div[id=doMianInfo] > b");
			 $(responseText).find("CDOMAIN").each(function(){
				 //   $.divMessage("",)
				 var msdomian = $.divMessage("委办局名称：",$(this).children('cname').text()).add($.divMessage("可供更新的补丁数：",
						 $(this).children('allPachInfoNum').text()).add($.divMessage("共有计算机总数：",
								 $(this).children('allComputerNum').text()).add($.divMessage("需要更新的计算机数目：",
										 $(this).children('clientsNumOUpdate').text()))));
				 $("#setailsInfo").divTile("委办局补丁信息",msdomian);
			 });
			  var senfeTRe = $("#senfe > thead");
			  if(!(senfeTRe.find("tr:eq(1)").css('display') == 'none')){
				 senfeTRe.find("tr:eq(1)").hide();
			  }
			  senfeTRe.find("tr:eq(0)").show();
			  $("#senfe > tbody").find("tr").remove();
			  var senfeTboxy = $("#senfe > tbody");
			  $(responseText).find("CDOMAINALL").each(function(index,domData){
				  senfeTboxy.append(
		                 "<tr><td>"+$(this).children('name').text()+"</td>"+
		                 "<td><span>"+$(this).children('allPatchUpdateFailedNUm').text()+"</span> </td>"+
		                 "<td><span>"+$(this).children('allPatchUpdateNeedNum').text()+"</span></td>"+
		                 "<td><span>"+$(this).children('allPatchUpdateOkNum').text()+"</span></td>"+
		                 "<td><a href='javascript:void(0)'>查看</a></td></tr>");
				  senfeTboxy.find("tr:eq("+index+") td > span").css({float:'left'}).parent().next().children('a').click(function(){
					  ps.sClientAjax("statisticsAction.do?method=getCountSensor&scid="+$(domData).children('id').text());
				  }).addClass("R6"); 
			  });
			  $("#senfe > tbody").trClor();
				 $(responseText).find('PAGE').each(function(index){
					   var totalpage=$(this).children("totalPage").text();
					   $("#page li span[id='pageSize']").text(totalpage);
					   //showPageGo(getUrlMethod(url,"domainid"),totalpage,fytime($(this).children('starttime').text(),$(this).children('endtime').text()));
					   var url = "statisticsAction.do?method=getCountDomain&sdid="+$.getUrlMethod(urld,"sdid");
					   var cpagetext = $(this).children('currentPage').text();
					   Page.onDownPage('pre', $(this).children('hasPrePage').text(),cpagetext,url,"1");
					   Page.onDownPage('next',$(this).children('hasNextPage').text(),cpagetext,url,"1");
					   Page.onDownPage('first','true',1,url,"1");
					   Page.onDownPage('last','true',$(this).children('totalPage').text(),url,"1");
					   Page.goPage(totalpage,url,"1");
			    });
		 },'html');
},
		sTree:function(){
		   var  simpleTreeCollection = $('.simpleTree').simpleTree({
		        autoclose: true,
		        drag:false,
		        afterClick:function(node){
		           var name=$('span:first',node).text();
		           var id=$('span:first',node).attr("shid");
		           var isleaf=$('span:first',node).attr("isleaf");
		           if(isleaf == 0){
		        	   ps.sDoMainAjax("statisticsAction.do?method=getCountDomain&sdid="+id);
		           }else{
		        	   ps.sClientAjax("statisticsAction.do?method=getCountSensor&scid="+id);
		           }
		        },
		        animate:true
		    });
},
            pageAjax:function(url){
	          $.post(url,function(responseText){
	          },'html');
	
}
}


var Page = {
		onDownPage:function(cp,ish,curpage,ovlaue,bs){
				   if(ish == "true")
				   {
					   var cpstr = "#page li a[@class="+cp+"]";
					   if(cp == "pre" || cp == "next"){
						   $(cpstr).attr("title","当前页" + curpage);
						   if(cp == "pre"){
							   curpage =Number(curpage)-1;
						   }else if(cp == "next"){
							   curpage =Number(curpage)+1;
						   }
					   }
					   $(cpstr).show().unbind('click').click(function(){
						   var url = ovlaue+"&curpage="+curpage;
						   if(bs == "0"){
							   ps.sClientAjax(url);
						   }else{
							   ps.sDoMainAjax(url);
						   }
					   });
				   }else{
					   $("#page li a[@class="+cp+"]").hide();
				   }
			},
		 goPage:function(totalpabe,ovlaue,bs){
				$("#tpageCount").unbind('keyup').keyup(function(){
					  var v = Number($("#tpageCount").val());
					  var regu = /^[-]{0,1}[0-9]{1,}$/;
					  if(!regu.test(v))return;
					  var v1 =Number(totalpabe);
					  if(v > v1){
						  $("#page li a[@id=pageGo]").html('NO');
						  $("#page li a[@id=pageGo]").unbind('click');
					  }else{
						  $("#page li a[@id=pageGo]").html('GO');
						  $("#pageGo").unbind('click').click(function(){ 
							  var url = ovlaue+"&curpage="+v;
							   if(bs == "0"){
								   ps.sClientAjax(url);
							   }else{
								   ps.sDoMainAjax(url);
							   }
						  });
					  }
				});
			}
			
			
   }
function getUrlMethod(url,methodName)
{
	 var reg = new RegExp("(^|&|\\?)"+ methodName +"=([^&]*)(&|$)"); 
	 var mvalue=url.match(reg);
	 return  mvalue ? mvalue[2] : "";
}
function strDateTime(str)
{
	var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;
	var reg1 = /^\d{4}-\d{1,2}-\d{1,2}$/ ;
    var rqv =str.match(reg);
    var rqv1=str.match(reg1);
    return  str ? rqv ? rqv[0] : rqv1 ? rqv1[0] : ""  : "";
}

