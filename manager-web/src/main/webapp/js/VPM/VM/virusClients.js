$(window).load(function(){
	 vc.domAjax("virusMappedAction.do?method=getVirusClientsAll");
});
var vc={
		supName:function(boxy,dv){
			vc.upajax("virusMappedAction.do?method=uvcs&vcid="+dv[0].id+"&vcname="+boxy.getContent().find("input").val(),dv);
			boxy.hide();
		},
		supAsset:function(boxy,dv){
	       vc.upajax("virusMappedAction.do?method=uvcs&vcid="+dv[0].id+"&vcasset=" +boxy.getContent().find("option:selected").val(),dv);
	       boxy.hide();
		},
		supdoMain:function(boxy,dv){
			vc.upajax("virusMappedAction.do?method=uvcs&vcid="+dv[0].id+"&vcdomain=" +boxy.getContent().find("option:selected").val(),dv);
			boxy.hide();
		},
		unlink:function(boxy,pid){
			$.post("virusMappedAction.do?method=uvcs&unlink=unlink&vcid="+boxy,function(){
                   vc.pageAjax(pid);
			});
		},
		boxyAjax:function(responseText){
			 $("#senfe").find("tr:gt(0)").remove(); 
	         $(responseText).find('VCS').each(function(index,evendate){
			  //    $(this).children('').text()
	               $("#senfe > tbody").append(
	     	    	   "<tr><td>"+$(this).children('ip').text()+"</td>"+
	     	    	   "<td> <span id='sname' style='float:left'>"+$(this).children('name').text()+"</span>" +
	     	           "<span class='edit'><a href='javascript:void(0)'  title='编辑'></a></span></td>"+
	     	           "<td>"+$(this).children('cid').text()+"</td>"+
	     	           "<td> <span style='float:left'>"+$(this).children('accode').text()+"</span>" +
	     	           "<span class='edit'><a href='javascript:void(0)'  title='编辑'></a></span> </td>"+
	     	           "<td> <span style='float:left'>"+$(this).children('dmname').text()+"</span>" +
	     	           "<span class='edit'><a href='javascript:void(0)'  title='编辑'></a></span> </td>"+
	     	           "<td>"+$(this).children('rTime').text()+"</td><td><a href='javascript:void(0)' class='R6 R7'>删除</a></td></tr>");
	             $('#senfe > tbody').find("tr:eq("+index+")").each(function(indexts,trdata){
	            	 $(this).find('td a').each(function(indexs,even){
		        		  if($(trdata).find('td a').size() == (Number(indexs)+1)){
		        			  $(even).bind('click', function() {  
		        				  Boxy.confirm("<font size=4>确定要删除吗?<font>", function(){
		        					  vc.unlink($(evendate).children('id').text(),$(responseText).find('PAGE').children("countPage").text());
		        				  });
		        				  return false;
		        			  });
		       			 }else{ 
		               		 $(even).bind('click', function() {
		               			 Boxy.shload("../pm/pm_assets_update_0"+(Number(indexs)+1)+".do",{'sve':[{"id":$(evendate).children('id').text(),"data":this,"lw":evendate}]},function(data){
		               				if(indexs == 1){
		               				   //映射资产回调函数
		               					vc.assetsAjax(data,$(evendate).children('acid').text());
		               					$(data).find("#save").unbind('click').click(function(){
		               						vc.supAsset(Boxy.get(data),Boxy.getEleValue(data));
		               					});
		               				}else if(indexs ==2){
		               					//弹出委办局回调函数
		               					vc.doMainAjax(data,$(evendate).children('dmid').text());
		               					$(data).find("#save").unbind('click').click(function(){
		               						vc.supdoMain(Boxy.get(data),Boxy.getEleValue(data));
		               					});
		               				}else if(indexs == 0){
		               					$(data).find("#save").unbind('click').click(function(){
		               						vc.supName(Boxy.get(data),Boxy.getEleValue(data));
		               					});
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
				   //vcowPageGo(getUrlMethod(url,"domainid"),totalpage,fytime($(this).children('starttime').text(),$(this).children('endtime').text()));
				   var cpagetext = $(this).children('currentPage').text();
				   $("#page li input[@id=tpageCount]").attr("value","");
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
					   vc.boxyAjax(responce);
				   }
			 });
		},
		doMainAjax:function(data,did){
			$.post("../pm/doManinTree.do?method=getDoMainAll",function(response){
		         $(response).find('SH').each(function(index,evendate){
		        	 var id=$(this).children('id').text();
		        	 $("<option "+ ($.trim(id) == $.trim(did) ? "selected='selected'" : " ") +" value='" + id + "'>" + $(this).children('name').text() + "</option>").appendTo($(data).find("#doselect"));
		         });  	
			},'html');
		},
		assetsAjax:function(data,acid){
			$.post("../pm/patchAction.do?method=getADL",function(response){
		         $(response).find('ADL').each(function(index,evendate){
		        	 var id=$(this).children('acid').text();
		        	 $("<option "+ ($.trim(id) ==$.trim(acid) ? "selected='selected'" : " ") +" value='" + id + "'>" + $(this).children('accode').text() + "</option>").appendTo($(data).find("#adselect"))
		         });  	
			},'html');
		},
		pageAjax:function(pageValue){
        	$("#searchForm").ajaxSubmit({data:{curpage:pageValue},success:function(responce){
        		 vc.boxyAjax(responce);
        	}});
        },
        formReset:function(){
        	$("#searchForm")[0].reset();
        }
}


var Page = {
		onDownPage:function(cp,ivc,curpage){
				   if(ivc == "true")
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
						   vc.pageAjax(curpage);
						   return false;
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
							  vc.pageAjax(v);
							  return false;
						  });
					  }
				});
			}
				
   }