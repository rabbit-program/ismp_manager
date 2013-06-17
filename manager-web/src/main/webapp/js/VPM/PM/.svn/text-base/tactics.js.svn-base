$(window).load(function(){
	sht.domAjax("TacticsAction.do?method=getTacticsInfoAll");
});
var sht ={
		  boxyAjax:function(responseText){
			    $("#senfe").find("tr:gt(0)").remove();
			    $(responseText).find("TACTICS").each(function(index,edata){
			    	  //    $(this).children('').text()
			    	$("#senfe > tbody").append(
			                "<tr><td>"+$(this).children('tname').text()+"</td>"+
			                "<td><span style='float:left'>"+$(this).children('isup').text()+"</span></td>"+
			                "<td><span style='float:left'>"+$(this).children('uw').text()+"</span></td>"+
			                "<td><span style='float:left'>"+$(this).children('upad').text()+"</span></td>"+
			                "<td>"+$(this).children('ctime').text()+"</td>"+
			                "<td><a href='javascript:void(0)'  class='R6'>修改</a>" +
			                "<a href='javascript:void(0)' class='R6'>删除</a></td></tr>" );
			    	$('#senfe > tbody').find("tr:eq("+index+")").each(function(indexts,trdata){
			    		if($.trim($(edata).children('defProYN').text()) == 'true'){
			    			$(trdata).find('td:eq(0)').append('<font>[全局策略]</font>').children('font').css({color:'red'});;
			    		}
			    		$(this).find('td a').each(function(indexs,even){
			    			if(indexs % 2 == 0){
			    				$(even).bind('click', function() {
			    					Boxy.load("pm_tactics_update.do",{'sve':[{"id":$(edata).children('tid').text(),"data":trdata}],'bc':true});
			    					return false;
			    				});
			    			 }else{
			    				$(even).bind('click', function() {
			    					Boxy.confirm("<font size=4>确定要删除吗?<font>", function() { 
											$.ajax({
												type:"POST",
												url:"TacticsAction.do?method=delTacticsInfo&tid="+$(edata).children('tid').text(),
												contentType:'html',
												cache:false,
												success: function(){
													 sht.pageAjax($("#page").data('cp'));
											    },
											    error: function(){
											    	 alert('因为客户端跟策略绑定着，请解除后删除?');
											    }
									      }); 
			    					 });
			    				});
			    			 }
			    		 });
			    	});
					 $(responseText).find('PAGE').each(function(index){
					   var totalpage=$(this).children("totalPage").text();
					   $("#page li span[id='pageSize']").text(totalpage);
					   //showPageGo(getUrlMethod(url,"domainid"),totalpage,fytime($(this).children('starttime').text(),$(this).children('endtime').text()));
					   var cpagetext = $(this).children('currentPage').text();
					   Page.onDownPage('pre', $(this).children('hasPrePage').text(),cpagetext);
					   Page.onDownPage('next',$(this).children('hasNextPage').text(),cpagetext);
					   Page.onDownPage('first','true',1);
					   Page.onDownPage('last','true',$(this).children('totalPage').text());
					   Page.goPage(totalpage);
					   $("#page").removeData('cp');
					   $("#page").data('cp',$(this).children("countPage").text()); 
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
		},
		upajax:function(data,value){
			//getContent()
			var options = {
              url:'TacticsAction.do?method=updateTacticsInfo&t.id='+value[0].id,
              type:'POST',
              success:function(responseText){
		    	$(responseText).find("TACTICS").each(function(){
		    		//  $(this).children('').text()
		    		var tr= $(value[0].data);
		    		var td=tr.find("td:eq(0)");
		    		td.html($(this).children('name').text());
		    		if($.trim($(this).children('defProYN').text()) == 'true'){
		    			$('#senfe > tbody').find("tr td:nth-child(1)").each(function(){
		    				$(this).children('font').remove();
		    			});
		    			td.append('<font>[全局策略]</font>').children('font').css({color:'red'});
		    		}
		    		tr.find("td > span").eq(0).html($(this).children('isup').text());
		    		tr.find("td > span").eq(1).html($(this).children('upw').text());
		    		tr.find("td > span").eq(2).html($(this).children('updateAddress').text());
		    		tr.find("td").eq(4).html($(this).children('updateTime').text());
		    	});
		    	 data.hide();
			   }
			};
			data.getContent().find("#tfrom").ajaxSubmit(options);
			return false;
		},
		findajax:function(data,value){
			 $.ajax({
				   type:"POST",
				   url:"TacticsAction.do?method=getTacticsInfo&tid="+value[0].id,
				   success:function(responce){
					  $(responce).find("TACTICS").each(function(){
						  //    $(this).children('').text()
						  var td = $(data).find("td");
						  td.find("#tname").val($(this).children('name').text());
						  td.find("#ites"+$(this).children('isAutoUpdate').text()+"")[0].checked=true;
						  td.find('#tupW')[0].value=$(this).children('updateWay').text();
						  td.find("#uptime").val($(this).children('updateTime').text()); 
						  var ptdefault =td.find("#qdpt");
						  td.find("#ipdress").html($(this).children('defAddress').text());
						  ptdefault.val($(this).children('defAddress').text());
						  var vdefault =$(this).children('updateAddress').text();
						  if(ptdefault.val() == vdefault){
							  ptdefault[0].checked=true;
						  }else{
							  td.find("#xyaddress").val(vdefault);
							  td.find("#optionalAddress").show('slow');
						  }
						 // $(data).find("td > #"+($(this).children('isAutoUpdate').text())).checked=true;
					  });
			       }
			 });
		},
		//添加操作
		addAjax:function(data){
				data.getContent().find("#tfrom").ajaxSubmit({success:function(responseText){
					  sht.boxyAjax(responseText);
					  data.hide();
				}});
		},
		pageAjax:function(pageValue){
        	$("#tSearchForm").ajaxSubmit({data:{curpage:pageValue},success:function(dataValue){
        		sht.boxyAjax(dataValue);
        	}});
		},
		searchaAjax:function(){
			$("#tSearchForm").ajaxSubmit({success:function(responseText){
				 sht.boxyAjax(responseText);
			}});
		},
		//文档加载
		domAjax:function(t_url){
				$.ajax({
					type:"POST",
					url:t_url,
					contentType:'html',
					cache:false,
					success: function(responce){
					   sht.boxyAjax(responce);
				   }
			 });
			 $("#addTactics").click(function(){
				   $.post('TacticsAction.do?method=getDefaultAddess',function(responseTest){
					  var address =  $(responseTest).find("ADDESS").children('address').text();
					  Boxy.shload('pm_tactics_add.do',{},function(data){
						   $(data).find("#ipdress").html(address);
						   $(data).find("#qdpt").val(address);
					   });
				   },'html');
			   });	
		   return false;
		}
		
		
}


var Page = {
		//分页
		/*cp 
		 * ish 元素名
		 * domainid 委办局id
		 * curpage 查询第几页
		 * strPage 查询时间字符串
		 * */
		onDownPage:function(cp,ish,curpage){
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
						   sht.pageAjax(curpage);
					   });
				   }else{
					   $("#page li a[@class="+cp+"]").hide();
				   }
			},
		/*
		 * totalpabe 总页数
		 * strPage 查询时间字符串
		 * */
		goPage:function(totalpabe){
				$("#page li input[@id=tpageCount]").unbind('keyup').keyup(function(){
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
							  sht.pageAjax(v);
						  });
					  }
				});
			}
			
			
   }

var utilPage={
		authenticationTime:function(str){
			var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;
		    var rqv =str.match(reg);
		    return  str ? rqv ? rqv[0] : "" : "";
        },
        formReset:function(){
        	$("#tSearchForm")[0].reset();
        }
}








