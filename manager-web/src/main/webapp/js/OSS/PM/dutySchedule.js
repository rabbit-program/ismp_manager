function publish(obj){
           $(obj).hide();
           var $img = $(obj).after("<img />").next().attr("src","../../../img/VPM/pm/spinner.gif").addClass("R6 R7").css({margin:"10px 0px 0px 10px"});
            $.get("dsinfo.do?method=publishDutySchedule",function(response){
                   if($(response).find("SH:first").children("identifier").text()+"" == "Y"){
                	   publishStatus("已发布",obj,"blue", $img,true);
                    }else{
                    	 publishStatus("发布失败",obj,"red", $img,false);
                    }; 
              },"html");
}
function publishStatus(p_msg,p_obj,p_color,p_img,identifier){
    var $tbody=$("tbody > tr"),i = $tbody.size(),j=0,$tr,$td;
    var $int = setInterval(function(){
    	      $tr = $tbody.eq(j);
              $td = $tr.find("td:eq(0)");
              if($td.children().size() == 0){
                  $td.append($("<span>"+p_msg+"</span>").css("color",p_color));
                  if(identifier)
                	  $tr.find("td:last #duty_update").remove();
              }      
              if(j == i){
                  clearInterval($int);
                  p_img.remove();
                  $(p_obj).show();
              }
           j++;
     },700);
}