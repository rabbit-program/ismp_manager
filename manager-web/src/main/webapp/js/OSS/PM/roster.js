
var $roster = {
		addRoster:function(){
			Boxy.shload('newRoster.do',{modal:true,title:'xxxx'},function(data){

	            $.post("../../../ismp/domain/local/vpm/pm/doManinTree.do?method=getDoMainAll",function(response){
                    $(response).find('SH').each(function(index,evendate){
                        $("<option value='" + $(this).children('id').text() + "'>" + $(this).children('name').text() + "</option>").appendTo($(data).find("#doselect"));
                    });    
                },'html');
	            
                $.fn.themeswitcher && $('<div/>').css({
                    position: "absolute",
                    right: 10,
                    top: 10
                }).appendTo($(data)).themeswitcher();
                
                $(data).find("#signupForm").validate({
                    rules: {
                        username: {
                            required: true,
                            minlength: 2
                        },
                        usersn: {
                            required: true,
                            minlength: 5
                        },
                        userposition: {
                            required: true,
                            minlength: 5
                        },
                        usermobile: {
                            required: true,
                            number: true,
                            minlength: 11
                        },
                        userphone:{
                            required: true,
                            number: true,
                            minlength: 8
                        },
                        useremail: {
                            required: true,
                            email: true
                        },
                        userremark: "required"
                    },
                    messages: {
                            username: {
                            required: "您的用户名不能为空",
                            minlength: "您的用户名必须包括至少2个字符"
                        },
                        usersn: {
                            required: "您的编号不能为空",
                            minlength: "您的编号必须包括至少5个字符"
                        },
                        userposition: {
                            required: "您的职务不能为空",
                            minlength: "您的职务必须包括至少5个字符"
                        },
                        usermobile: {
                            required: "您的手机不能为空",
                            minlength: "您的手机必须包括至少11个字符",
                            number: "您的手机必须是数字格式"
                        },
                        userphone: {
                            required: "您的电话不能为空",
                            minlength: "您的电话必须包括至少6个字符",
                            number: "您的手机必须是数字格式"
                        },
                        useremail: "请输入一个有效的电子邮件地址",
                        userremark: "您的备注不能为空"
                    }
                });
                $(data).find("#signupForm input:not(:submit)").addClass("ui-widget-content");
                
                $(data).find(":submit").button();
                
		    });
}
		
}