
$(window).load(function(){
	 sh.domAjax("patchAction.do?method=getWinSensorAssetInfo&isAll="+$("#qxid").val());
});
var sh={
		supName:function(boxy,dv){
			sh.upajax("patchAction.do?method=usai&sid="+dv[0].id+"&sname="+boxy.getContent().find("input").val(),dv);
			boxy.hide();
		},
		supAsset:function(boxy,dv){
	       sh.upajax("patchAction.do?method=usai&sid="+dv[0].id+"&sasset=" +boxy.getContent().find("option:selected").val(),dv);
	       boxy.hide();
		},
		supdoMain:function(boxy,dv){
			sh.upajax("patchAction.do?method=usai&sid="+dv[0].id+"&sdomain=" +boxy.getContent().find("option:selected").val(),dv);
			boxy.hide();
		},
		unlink:function(boxy,method){
			$.post("patchAction.do?method=usai&unlink=unlink&sid="+boxy,function(){
                   sh.pageAjax($("#page").data("page"));
			});
		},
		boxyAjax:function(responseText){
			 $("#senfe").find("tr:gt(0)").remove(); 
	         $(responseText).find('SH').each(function(index,evendate){
			  //    $(this).children('').text()
	               $("#senfe > tbody").append(
	     	    	   "<tr><td>"+$(this).children('ip').text()+"</td>"+
	     	    	   "<td> <span id='sname' style='float:left'>"+$(this).children('name').text()+"</span>" +
	     	           "<span class='edit'><a href='javascript:void(0)'  title='编辑'></a></span></td>"+
	     	           "<td> <span style='float:left'>"+$(this).children('accode').text()+"</span>" +
	     	           "<span class='edit'><a href='javascript:void(0)'  title='编辑'></a></span> </td>"+
	     	           "<td> <span style='float:left'>"+$(this).children('dmname').text()+"</span>" +
	     	           "<span class='edit'><a href='javascript:void(0)'  title='编辑'></a></span> </td>"+
	     	           "<td>"+$(this).children('gltime').text()+"</td><td><a href='javascript:void(0)' class='R6 R7'>取消关联</a></td></tr>");
	             $('#senfe > tbody').find("tr:eq("+index+")").each(function(indexts,trdata){
	            	 $(this).find('td a').each(function(indexs,even){
		        		  if($(trdata).find('td a').size() == (Number(indexs)+1)){
		        			  $(even).bind('click', function() {  
		        				  // 取消关联
		        			       //alert("xx");
		        			      sh.unlink($(evendate).children('id').text());
		        			  });
		       			 }else{ 
		               		 $(even).bind('click', function() {
		               			 Boxy.shload("pm_assets_update_0"+(Number(indexs)+1)+".do",{'sve':[{"id":$(evendate).children('id').text(),"data":this,"lw":evendate}]},function(data){
		               				if(indexs == 1){
		               				   //映射资产回调函数
		               					sh.assetsAjax(data,$(evendate).children('acid').text());
		               				}else if(indexs ==2){
		               					//弹出委办局回调函数
		               					sh.doMainAjax(data,$(evendate).children('dmid').text());
		               				}
		               			 });
		                   	 });
		       			  }
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
			 $(responseText).find('PAGE').each(function(index){
				   var totalpage=$(this).children("totalPage").text();
				   $("#page li span[id='pageSize']").text(totalpage);
				   //showPageGo(getUrlMethod(url,"domainid"),totalpage,fytime($(this).children('starttime').text(),$(this).children('endtime').text()));
				   var cpagetext = $(this).children('currentPage').text();
				   $("#page").data("page",cpagetext);
				   Page.onDownPage('pre',$(this).children('hasPrePage').text(),cpagetext);
				   Page.onDownPage('next',$(this).children('hasNextPage').text(),cpagetext);
				   Page.onDownPage('first','true',1);
				   Page.onDownPage('last','true',$(this).children('totalPage').text());
				   Page.goPage(totalpage);   
	        });
		},
		upajax:function(url,data){
			 $.ajax({
				   type:"POST",
				   url:url,
				   contentType:'html',
				   cache:false,
				   success:function(responce){
					   $(responce).find("UPNAME").each(function(){
						   $(data[0].data).parent().prev().html($(this).children('data').text());
						   var general=$(this).children('general').text();
						   if(general){
							   $(data[0].lw).children(general).text($(this).children(general).text());
						   }
					   });
			       }
			 });
		},
		domAjax:function(t_url){
				$.ajax({
					type:"POST",
					url:t_url,
					contentType:'html',
					cache:false,
					success: function(responce){
					   sh.boxyAjax(responce);
				   }
			 });
		},
		doMainAjax:function(data,did){
			$.post("doManinTree.do?method=getDoMainAll",function(response){
		         $(response).find('SH').each(function(index,evendate){
		        	 var id=$(this).children('id').text();
		        	 $("<option "+ ($.trim(id) == $.trim(did) ? "selected='selected'" : " ") +" value='" + id + "'>" + $(this).children('name').text() + "</option>").appendTo($(data).find("#doselect"));
		         });  	
			},'html');
		},
		assetsAjax:function(data,acid){
			$.post("patchAction.do?method=getADL",function(response){
		         $(response).find('ADL').each(function(index,evendate){
		        	 var id=$(this).children('acid').text();
		        	 $("<option "+ ($.trim(id) ==$.trim(acid) ? "selected='selected'" : " ") +" value='" + id + "'>" + $(this).children('accode').text() + "</option>").appendTo($(data).find("#adselect"))
		         });  	
			},'html');
		},
		pageAjax:function(pageValue){
        	$("#searchForm").ajaxSubmit({data:{curpage:pageValue},success:function(responce){
        		 sh.boxyAjax(responce);
        	}});
        },
        formReset:function(){
        	$("#searchForm")[0].reset();
        }
}


var Page = {
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
						   sh.pageAjax(curpage);
					   });
				   }else{
					   $("#page li a[@class="+cp+"]").hide();
				   }
			},
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
							  sh.pageAjax(v);
						  });
					  }
				});
			}
				
   }