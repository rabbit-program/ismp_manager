


$(function(){
    $.post("softwareDistributionAction.do?method=findAllSoftwareInfo",function(response){
        $(response).find('TYPE').each(function(){
            $("<option  "+ ($.trim($(this).children('id').text()) == $.trim("<bean:write name='software' property='typeInfo.id' scope='request'/>") ? "selected='selected'" : " ") +" value='" + $(this).children('id').text() + "'>" + $(this).children('name').text() + "</option>").appendTo($("#selectType"));
        });    
   },'html');
	$("#selectAllCheckbox").click(function(){
		selectCheckbox(function(obj){
			if(!$(obj).is(":checked")){
				$(obj).attr("checked",true);
			}
		})
	});
	$("#notSelectCheckbox").click(function(){
		selectCheckbox(function(obj){
			$(obj).attr("checked",$(obj).is(":checked") ? false : true);
		})
	});
	$("#delSelectAll").click(function(){
		if(window.confirm("此操作非常危险,要继续吗?")){
			var her = $(this).attr("href");
			selectCheckbox(function(obj,index){
				  if($(obj).is(":checked")){
					  her +="&sids="+$(obj).val();
				  }
			});
			$(this).attr("href",her);
			return true;
		}
	   return false;
	});
 });
function softwareDetail(url){
	$.post(url,function(response){
         Boxy.shload("software_detail.do",{
             afterShow: function() {
               if(this.getPosition()[1] < 0){
                 this.moveTo(0,0);        
                 this.center('x');
               }
             }
          },function(data){
        		 $(response).find('SOFTWAREINFO').each(function(){
        			 $(data).find("#s_name").html( $(this).children('si_name').text());
        			 $(data).find("#s_typeInfo").html( $(this).children('t_name').text());
        			 $(data).find("#s_type").html( $(this).children('si_type').text());
        			 $(data).find("#s_size").html($(this).children('si_size').text());
        			 $(data).find("#s_uploadTime").html( $(this).children('si_uploadTime').text());
        			 $(data).find("#d_checkTag").html( $(this).children('d_CheckTag').text());
        			 $(data).find("#d_consistencyCheckTag").html( $(this).children('d_consistencyCheckTag').text());
        			 $(data).find("#d_startDate").html($(this).children('d_StartDate').text());
        			 $(data).find("#d_endDate").html($(this).children('d_EndDate').text());
        			 $(data).find("#d_startTime").html( $(this).children('d_StartTime').text());
        			 $(data).find("#d_endTime").html($(this).children('d_EndTime').text());
        			 $(data).find("#d_ThreadNum").html($(this).children('d_ThreadNum').text());
        			 $(data).find("#e_checkTag").html($(this).children('e_Tag').text());
        			 $(data).find("#e_filePath").html($(this).children('e_Path').text());
        			 $(data).find("#e_parameter").html($(this).children('e_Parameter').text());
        			 $(data).find("#e_message").html($(this).children('e_Message').text());
        			 $(data).find("#v_checkTag").html($(this).children('v_CheckTag').text());
        			 $(data).find("#v_patch").html($(this).children('v_FilePath').text());
        			 $(data).find("#v_fileVersion").html( $(this).children('v_FileVersion').text());
        			 $(data).find("#v_process").html($(this).children('v_Process').text());
        			 $(data).find("#v_key").html( $(this).children('v_Key').text());
        			 $(data).find("#v_service").html($(this).children('v_Service').text());
                 });  
          });
	},"html");
}


