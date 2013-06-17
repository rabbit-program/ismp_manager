 function loadSecurity(lthis,url,para){
         Boxy.shload("appSysInfosecurity.do",{
            afterShow: function() {
              if(this.getPosition()[1] < 0){
                this.moveTo(0,0);        
                this.center('x');
              }
            }
         },function(data){
        	 asr.asrLogin(data,url+"/ismp/sysm/other/appSysRole.do?method=getAppSysRoleInfo&asid="+para);
        	 rar.rarLogin(data,url+"/ismp/sysm/other/rarInfo.do?method=getRARInfo&asid="+para);
	       	 $(data).find("#editAuthority").click(function(){
	    		 upArea(lthis,url+"/ismp/sysm/other/appSysInfo.do?method=getAppSysInfoId&asid="+para,0);
	    		 return false;
	    	 });
         });
      }
var rar ={
	rarLogin:function(rardata,rarurl){
	  rar.findRARIndex(rarurl,rardata);
	  $(rardata).find("#addsucrity").click(function(){
	         Boxy.shload("rarSecurity.do",{
	             afterShow: function() {
	               if(this.getPosition()[1] < 0){
	                 this.moveTo(0,0);        
	                 this.center('x');
	               }
	             }
	          },function(data){
	        	  comm.butshow(data,true); 
	        	   $.post(rarurl.replace("rarInfo.do?method=getRARInfo","appSysRole.do?method=findAll"),function(jr){
	  		         $(jr).find('ROLEALL').each(function(index,evendate){
			        	 $("<option  value='" + $(this).children('id').text()+ "'>" + $(this).children('name').text() + "</option>").appendTo($(data).find("#select2"));
			         });  	               
	        	   },"html");
	     	      $(data).find("#okqr").click(function(){
	     	    	 var $url = comm.getUrl(rarurl,"method","?method=addRARInfo");
	     	    	 $url +="&asrid="+$(data).find("#select2").val()+"&name="+$(data).find("#tname").val()+"&operator="+$(data).find("#toperator").val();
	    	    	  $.post($url,function(){
	    	    		  rar.findRARIndex(rarurl,rardata);
	    	    		  Boxy.get(data).hide();
	    	    	  });
	    	      });
	          });
		  
		  
		  return false;
	  });
},
	findRARIndex:function(rarurl,rarData){
	      $.post(rarurl,function(resonpseHtml){
	         var rarTbody = $(rarData).find("#senfe > tbody");
	         $('tr',rarTbody).remove();
	         $(resonpseHtml).find("RAR").each(function(asrIndex){
	           var $username=$(this).children('username').text();
	           var $ctime=$(this).children('ctime').text();
	           var $operator=$(this).children('operator').text();
	           var $rolename =$(this).children('rolename').text(); 
	           var $roleid = $(this).children('roleid').text(); 
	           var $id = $(this).children('id').text(); 
	           rarTbody.append("<tr><td>"+comm.getstringsub($username,10)+"</td><td>"+comm.getstringsub($rolename,10)+"</td>" +
	        	 "<td>"+$ctime.substr(0,19)+"</td><td>"+comm.getstringsub($operator,10)+"</td>"+
	             "<td><a href='javascript:void(0)'>修改</a>|<a href='javascript:void(0)'>删除</a></td></tr>");
	             var aArray= rarTbody.find('tr').eq(asrIndex).find('td > a');
	             aArray.eq(0).click(function(){
	                 Boxy.shload("rarSecurity.do",{
	                     afterShow: function() {
	                       if(this.getPosition()[1] < 0){
	                         this.moveTo(0,0);        
	                         this.center('x');
	                       }
	                     }
	                  },function(data){
	                	   comm.butshow(data,false);
	                	   $.post(rarurl.replace("rarInfo.do?method=getRARInfo","appSysRole.do?method=findAll"),function(jr){
	          		         $(jr).find('ROLEALL').each(function(index,evendate){
	          		        	 var id=$(this).children('id').text();
	        		        	 $("<option "+ ($.trim(id) == $.trim($roleid) ? "selected='selected'" : " ") +" value='" + id + "'>" + $(this).children('name').text() + "</option>").appendTo($(data).find("#select2"));
	        		         });  	               
	                         $(data).find("#tname").val($username);
	                         $(data).find("#toperator").val($operator);
	                	   },"html");
	             	      $(data).find("#upqr").click(function(){
	            	    	  var $url="rarInfo.do?method=upRARInfo&asrid="+$(data).find("#select2").val()+"&name="+$(data).find("#tname").val()+"&operator="+$(data).find("#toperator").val()+"&rarid="+$id;
	            	    	  $.post($url,function(){
	            	    		  rar.findRARIndex(rarurl,rarData);
	            	    		  Boxy.get(data).hide();
	            	    	  });
	            	      });
	                  });
	                 return false;
	             });
	             aArray.eq(1).click(function(){
	            	 Boxy.confirm("<font size=4>确定要删除吗?<font>", function() { 
	            		 $.post("rarInfo.do?method=delRARInfo&rarid="+$id,function(){
	            			 rar.findRARIndex(rarurl,rarData);
	            		 })
	            	 });
	                 return false;
	             }); 
	         });
             $(resonpseHtml).find('PAGE').each(function(){
                  var $cvrarurl = comm.getUrl(rarurl,"curpage","");
                  var totalpage=$(this).children("totalPage").text();
                  $(rarData).find("#pageSize").html(totalpage);
                  //showPageGo(getUrlMethod(url,"domainid"),totalpage,fytime($(this).children('starttime').text(),$(this).children('endtime').text()));
                  var cpagetext = $(this).children('currentPage').text();
                  Page.onDownPage($cvrarurl,rarData,'a.pre',$(this).children('hasPrePage').text(),cpagetext,rar);
                  Page.onDownPage($cvrarurl,rarData,'a.next',$(this).children('hasNextPage').text(),cpagetext,rar);
                  Page.onDownPage($cvrarurl,rarData,'a.first',true,1,rar);
                  Page.onDownPage($cvrarurl,rarData,'a.last',true,$(this).children('totalPage').text(),rar);
                  Page.goPage($cvrarurl,rarData,totalpage,rar);   
             });
	   },'html');
	},
    nextPage:function(nurl,cupage,nasrData){
        var ntUrl =nurl+"&curpage="+cupage;
        rar.findRARIndex(ntUrl,nasrData);
    }
			
}

var asr={
     asrLogin:function(data,toasrurl){
	    $(data).find("#DesignatedAuthority").click(function(){
	        Boxy.shload("asrinfo.do",{},function(dataObj){
	               asr.findASRIndex(toasrurl,dataObj);
	               var setForm = $(dataObj).find("#addform"); 
	               $(dataObj).find("#addsucrity,#axyshowtable,#addPermissions").click(function(){
	              	 setForm.get(0).reset();
	              	 comm.butshow(dataObj,true);
	                 comm.divShow(dataObj);
	                   return false;
	               }); 
	               $(dataObj).find("#noreset").click(function(){
	                   setForm.get(0).reset();
	                   return false;
	               });
	               $(dataObj).find("#okqr").click(function(){
	                   var $addurl = comm.getUrl(toasrurl,"method","?method=addAppSysRoleInfo");
	                   $addurl+="&asrname="+$(dataObj).find("#asrname").val()+"&asrdesc="+$(dataObj).find("#asrdesc").val()+"&asrremark="+$(dataObj).find("#asrremark").val();
	                   $.post($addurl,function(){
	                           asr.findASRIndex(toasrurl,dataObj);
	                       });
	                   comm.divShow(dataObj);
	                   setForm.get(0).reset();
	                   return false;
	               });
	               $(dataObj).find("#upqr").click(function(){
	                   var $butupurl = $(dataObj).find("#addform").attr('action');
	                   if($butupurl){
	                        $butupurl+="&asrname="+$(dataObj).find("#asrname").val()+"&asrdesc="+$(dataObj).find("#asrdesc").val()+"&asrremark="+$(dataObj).find("#asrremark").val();
	                        $.post($butupurl,function(){
	                             asr.findASRIndex(toasrurl,dataObj);
	                        });
	                        $(dataObj).find("#addform").removeAttr('action');
	                   }else{
	                	   //$.divMessage('添加提示',"添加出错啦");
	                   }
	                   comm.divShow(dataObj);
	                   setForm.get(0).reset();
	                   return false;
	               });
	               $(dataObj).find("#backqr").click(function(){
	                   setForm.get(0).reset();
	                   comm.divShow(dataObj);
	                   return false;
	               });
	        });
	        return false;
	     });
     },
     findASRIndex:function(asrurl,asrData){
           var setForm = $(asrData).find("#addform"); 
           $.post(asrurl,function(resonpseHtml){
              var asrTbody = $(asrData).find("#senfe > tbody");
              $('tr',asrTbody).remove();
              var $heightCount =113;
              $(resonpseHtml).find("ASR").each(function(asrIndex){
            	$heightCount+=31;
                var $id=$(this).children('id').text();
                var $name=$(this).children('name').text();
                var $desc=$(this).children('desc').text();
                var $remark=$(this).children('remark').text();
                asrTbody.append(
                  "<tr><td>"+ comm.getstringsub($name,5) +"</td>"+
                  "<td>"+ comm.getstringsub($desc,25) +"</td><td>"+ comm.getstringsub($remark,20) +"</td>"+
                  "<td><a href='javascript:void(0)'>修改</a> |"+
                  "<a href='javascript:void(0'>删除</a></td></tr>");
                  var aArray= asrTbody.find('tr').eq(asrIndex).find('td > a');
                  aArray.eq(0).click(function(){
                      setForm.get(0).reset();
                      $(asrData).find("#asrname").val($name);
                      $(asrData).find("#asrdesc").val($desc);
                      $(asrData).find("#asrremark").val($remark);
                      var $upurl = comm.getUrl(asrurl,"method","?method=upasri") + "&asrid=" + $id;
                      $(asrData).find("#addform").attr('action',$upurl);
                      comm.butshow(asrData,false);
                      comm.divShow(asrData);
                      return false;
                  });
                  aArray.eq(1).click(function(){
                	  Boxy.confirm("<font size=4>确定要删除吗?<font>", function() { 
                		  var $delurl = comm.getUrl(asrurl,"method","?method=delasri");
                		  $delurl+="&asrid=" + $id;
                		  $.post($delurl,function(){
                			  asr.findASRIndex(asrurl,asrData);
                		  });
                	  });
                      return false;
                  }); 
            });
             $(asrData).find("#xyshowtable").data('height',$heightCount);
              $(resonpseHtml).find('PAGE').each(function(){
                var cvUrl = comm.getUrl(asrurl,"curpage","");
                 var totalpage=$(this).children("totalPage").text();
                 $(asrData).find("#pageSize").html(totalpage);
                 var cpagetext = $(this).children('currentPage').text();
                 Page.onDownPage(cvUrl,asrData,'a.pre',$(this).children('hasPrePage').text(),cpagetext,asr);
                 Page.onDownPage(cvUrl,asrData,'a.next',$(this).children('hasNextPage').text(),cpagetext,asr);
                 Page.onDownPage(cvUrl,asrData,'a.first',true,1,asr);
                 Page.onDownPage(cvUrl,asrData,'a.last',true,$(this).children('totalPage').text(),asr);
                 Page.goPage(cvUrl,asrData,totalpage,asr);   
            });
        },'html');
     },
     nextPage:function(nurl,cupage,nasrData){
         var ntUrl =nurl+"&curpage="+cupage;
         asr.findASRIndex(ntUrl,nasrData);
     }
}    
var comm={
       divShow:function(asrDataShow){
            var $xyshowtable=$(asrDataShow).find("#xyshowtable");
            var $ishiden = $xyshowtable.is(":hidden");
            var $height = $xyshowtable.data('height');
            var x = $ishiden ?  ($height > 267 ?  $height :  $height + 31)  + "px" : "0px" ;
            var y = $ishiden ? "0px" : "225px" ;
            $(asrDataShow).find("#contantAdd").animate({height:y},'normal',function(){
            	comm.divshow($(this),$ishiden);
            });
            $xyshowtable.animate({height:x},'normal',function(){
                comm.divshow($(this),!$ishiden );
            });
    },
    divshow:function(obj,ist){
        if(ist){
            if(!(obj.is(":hidden")))
            	obj.hide();
        } else {
        	if(obj.is(":hidden"))
        	   obj.show();
        }
    },   
    butshow:function(obj,bstr){
            var $butok=$(obj).find("#okqr");
            var $butno=$(obj).find("#noreset");
            var $butup=$(obj).find("#upqr");
            var $butback=$(obj).find("#backqr");
            var $butdisplay = bstr ?　false　: true ;
        	comm.divshow($butok,$butdisplay);
        	comm.divshow($butno,$butdisplay);
        	comm.divshow($butup,!$butdisplay);
        	comm.divshow($butback,!$butdisplay);
    },
    getUrl:function(url,regStr,repStr){
        var reg = new RegExp("(^|&|\\?)"+regStr+"([^&]*)");
        return reg.test(url) ? url.replace(reg,repStr) : url;
    },
    getstringsub:function(str,len){
         return str.length > len ? str.substr(0,len)+"..." : str ;
    }
}
var Page = {
        onDownPage:function(purl,asrDataObj,cp,ish,curpage,obj){
                   if(eval(ish))
                   {
                       var cpstr =$(asrDataObj).find(cp+"");
                       if(cp == "a.pre" || cp == "a.next"){
                           $(cpstr).attr("title","当前页" + curpage);
                           if(cp == "a.pre"){
                               curpage =Number(curpage)-1;
                           }else if(cp == "a.next"){
                               curpage =Number(curpage)+1;
                           }
                       }
                       $(cpstr).show().unbind('click').click(function(){
                    	   obj.nextPage(purl,curpage,asrDataObj);
                       });
                   }else{
                       $(asrDataObj).find(cp+"").hide();
                   }
            } ,
          goPage:function(gurl,asrDataObj,totalpabe,obj){
                 $(asrDataObj).find("#tpageCount").unbind('keyup').keyup(function(){
                      var v = Number($(asrDataObj).find("#tpageCount").val());
                      var regu = /^[-]{0,1}[0-9]{1,}$/;
                      if(!regu.test(v))return;
                      var v1 =Number(totalpabe);
                      if(v > v1){
                           $(asrDataObj).find("#pageGo").html('NO');
                           $(asrDataObj).find("#pageGo").unbind('click');
                      }else{
                           $(asrDataObj).find("#pageGo").html('GO');
                           $(asrDataObj).find("#pageGo").unbind('click').click(function(){ 
                        	   obj.nextPage(gurl,v,asrDataObj);
                          });
                      }
                });
            }
   }