$(function(){
	   sh.validateDisable(true);
	   $.post("../../../ismp/domain/local/vpm/pm/doManinTree.do?method=getDoMainAll",function(response){
         $(response).find('SH').each(function(index,evendate){
             $("<option value='" + $(this).children('id').text() + "'>" + $(this).children('name').text() + "</option>").appendTo($("#doselect"));
         });    
       },'html');
	   $.post("rosterInfo.do?method=selectRosterAll",function(response){
	        $(response).find('ROSTER').each(function(index,evendate){
	            $("<option value='" + $(this).children('id').text() + "'>" + $(this).children('name').text() + "</option>").appendTo($("#select4"));
	        });    
	   },'html');
	   $("#doselect").change(function(){
		   if($(this)[0].selectedIndex > 0){
			   sh.selectAjax(this);
			   sh.validateDisable(false);
		   }else{
			   sh.validateDisable(true);
		   }
		});
});
var sh ={
		saveComplaint:function(c_data,c_phone,msg){
		    $(c_data).find("#complaintFrom").ajaxSubmit({success:function(addResponseText){
		  	  if($(addResponseText).find("SH:first").children("identifier").text()+"" == "N"){
		  		  Boxy.alert(msg);
		  	  }else{
		   		  Boxy.get($(c_data)).hide();
		   		  sh.selectAjax(c_phone);
		      }
		   }}); 
},
        searchAjax:function($c_id,callback){
			$.post("dsinfo.do?method=searchDomainToComplaint&cid="+$c_id,function(response1){
				callback(response1);
			},"html");
},
       selectAjax:function($select){
		    sh.searchAjax($($select).val(),function(response){
		    	var $data = $(response).find("COMPLAINT:first");
		    	$($select).next("div").empty(); 
		        if($(response).find("SH:first").children("identifier").text()+"" == "Y"){
		        	var $comPlaintPhone =$data.children("complaintPhone").text();
		        	$($select).after("<input type='hidden' id='complaint' value="+ $comPlaintPhone  +" />");
		        	 $($select).css({float:'left',marginTop:'5px'}).after("<div>投诉电话:  <a href='javascript:void(0)'> "+$comPlaintPhone+"</a><div>").next().css({float:'left',marginLeft:'20px',color:'red'}).find("a").click(function(){
		        		 var $phone = this;
		                 Boxy.shload("newOrUpdateComplaint.do",{modal:true,title:"投诉电话"},function(data){
		                     var domain = $(data).find("#domain");
		                     domain.val($($select).val());
		                     sh.searchAjax($($select).val(),function(response1){
		                    	 $(data).find("#complaint").val($data.children("id").text());
		                    	 $(data).find("#phone").val($(response1).find("COMPLAINT:first").children("complaintPhone").text());
		                    	 $(data).find("#type").val($(response1).find("COMPLAINT:first").children("complaintType").text());
		                    	 $(data).find("#help").val($(response1).find("COMPLAINT:first").children("complaintHelp").text());
		                    	 $(data).find("#save").html("更新");
		                     });
		                     domain.after($($select).find("option:selected").text());
		                     $(data).find("#save").click(function(){
		                    	 sh.saveComplaint(data,$select,"修改出错");
		                    });
		              }); 
		          });
		     }else{
		    	 $($select).css({float:'left',marginTop:'5px'}).after("<div>投诉电话是必填项,请点击 <a href='javascript:void(0)'> 添加</a><div>").next().css({float:'left',marginLeft:'20px',color:'red'}).find("a").click(function(){
		    		     var $phone = this;
		                 Boxy.shload("newOrUpdateComplaint.do",{modal:true},function(addData){
		                          var domain = $(addData).find("#domain");
		                          domain.val($($select).val());
		                          domain.after($($select).find("option:selected").text());
		                          $(addData).find("#save").click(function(){
		                        	  sh.saveComplaint(addData,$select,"添加出错");
		                         });
		                   });
		        	 });
		     }
		});		
   },
         validate:function(){
	     if( $("#doselect")[0].selectedIndex > 0 && $("#startTime").val() != ""  && $("#endTime").val() != "" && $("#complaint").val()) {
	    	  return true;
	     }else{
	    	 return false;
	     }           
      },
      validateDisable:function(identifier){
    	 var $select4 = $("#select4");
    	 var $start = $("#startTime");
    	 var $end = $("#endTime");
    	  if($select4.attr("disabled") != identifier) 
    		   $select4.attr("disabled", identifier);
    	  if($start.attr("disabled") != identifier)
    	       $start.attr("disabled",identifier);
    	  if($end.attr("disabled") != identifier)
    	       $end.attr("disabled",identifier);
      }
	
}






