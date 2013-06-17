<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title>运维支撑--值班管理--人员管理--修改值班人员</title>
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Newcommon.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Maincontant.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/common.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/boxy.css" />
        <script src="${ctx}/js/OSS/PM/jquery.js" type="text/javascript"></script>
        <script src="${ctx}/js/OSS/PM/jquery.metadata.js" type="text/javascript"></script>
        <script src="${ctx}/js/OSS/PM/jquery.validate.js" type="text/javascript"></script>
        <script type="text/javascript" src="${ctx}/js/VPM/PM/jquery.form.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
        <script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
        <link rel="stylesheet" type="text/css"  href="${ctx}/css/OSS/PM/jquery-ui.css" />
        <script src="${ctx}/js/OSS/PM/jquery.ui.core.js" type="text/javascript"></script>
        <script src="${ctx}/js/OSS/PM/jquery.ui.widget.js" type="text/javascript"></script>
        <script src="${ctx}/js/OSS/PM/jquery.ui.button.js" type="text/javascript"></script>

        <script type="text/javascript">
            $.validator.setDefaults({
                submitHandler: function(form) { 
                   $(form).ajaxSubmit({success:function(){
                        alert("修改成功");
                        window.opener.MM_submit(window);
                    }});
                },
                highlight: function(input) {
                    $(input).addClass("ui-state-highlight");
                },
                unhighlight: function(input) {
                    $(input).removeClass("ui-state-highlight");
                }
            });
            $.validator.addMethod("uname",function(value){
                var patrn =/^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$/; 
                  return  patrn.exec(value);
                },"用户名只含有汉字、数字、字母、下划线不能以下划线开头和结尾");
            $(function(){
            	$.post("${ctx}/ismp/domain/local/vpm/pm/doManinTree.do?method=getDoMainAll",function(response){
                    $(response).find('SH').each(function(index,evendate){
                        $("<option "+ ($.trim($(this).children('id').text()) == $.trim("<bean:write name='roster' property='domain.id'/>") ? "selected='selected'" : " ") +" value='" + $(this).children('id').text() + "'>" + $(this).children('name').text() + "</option>").appendTo($("#doselect"));
                    });  
               },'html');
                
                $.fn.themeswitcher && $('<div/>').css({
                    position: "absolute",
                    right: 10,
                    top: 10
                }).appendTo(document.body).themeswitcher();

                // validate signup form on keyup and submit
                $("#signupForm").validate({
                    rules: {
                        username: "uname",
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
                            minlength: 11,
                            maxlength: 11
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
                            maxlength: "您的手机必须包括11个字符",
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

                $("#signupForm input:not(:submit)").addClass("ui-widget-content");
                
                $(":submit").button();
            });
        </script>
    </head>
    <body>
            <div id="data" class="pad1 ">
                <h2>修改值班人员 "<span class="alert">*</span>"为必填项</h2>
          <form action="${ctx}/ismp/oss/pm/rosterInfo.do?method=rosterInfoUpdate" id="signupForm" method="post">
            <fieldset class="ui-widget ui-widget-content ui-corner-all">
                  <input type="hidden" name="rosterid"  value="<bean:write name='roster' property='id'/>" />
                <table>
                    <tr>
                        <th>姓名<span class="alert">*</span></th>
                        <td><input type="text" size="17" name="username" value="<bean:write name='roster' property='name'/>" id="username"/></td>
                    </tr>
                    <tr>
                         <th>编号<label for="usersn">编号</label></th>
                        <td><input type="text" size="17" name="usersn" value="<bean:write name='roster' property='sn'/>" id="usersn"/></td>
                    </tr>
                    <tr>
                        <th>性别<span class="alert">*</span></th>
                        <td>
                                <label for="user_male">
                                    <input  type="radio" id="user_male"  value="0" name="usersex" <logic:equal value="0" name="roster" property="sex">checked="checked"</logic:equal>/>
                                                                    男
                                </label>
                                <label for="gender_female">
                                    <input  type="radio" id="user_female" value="1" name="usersex" <logic:equal value="1" name="roster" property="sex">checked="checked"</logic:equal>/>
                                                                    女
                                </label>
                        </td>
                    </tr>
                    <tr>
                        <th>所属域<span class="alert">*</span></th>
                        <td>
                            <select id="doselect" name="userdomain"></select>
                        </td>
                    </tr>
                    <tr>
                        <th>职务<span class="alert">*</span></th>
                        <td><input type="text" size="17" name="userposition" value="<bean:write name='roster' property='position'/>" id="userposition"/></td>
                    </tr>
                    <tr>
                        <th>手机<span class="alert">*</span></th>
                        <td><input type="text" size="17" name="usermobile" value="<bean:write name='roster' property='mobile'/>" id="usermobile"/></td>
                    </tr>
                    <tr>
                        <th>固话<span class="alert">*</span></th>
                        <td><input type="text" size="17" name="userphone" value="<bean:write name='roster' property='phone'/>" id="userphone"/></td>
                    </tr>
                    <tr>
                        <th>e-mail<span class="alert">*</span></th>
                        <td><input type="text" size="17" name="useremail" value="<bean:write name='roster' property='EMail'/>" id="useremail"/></td>
                    </tr>
                    <tr>
                        <th>备注<span class="alert"></span></th>
                        <td colspan="3"><textarea cols="60" rows="5" id="userremark" name="userremark"><bean:write name='roster' property='remark'/></textarea></td>
                    </tr>
                </table>
            </fieldset>
                <div class="paddiv"></div>
                 <input type="submit" value="提交" class="submit" />
                 <input type="reset" value="重置" class="submit" />
                <div class="paddiv"></div>
         </form>
       </div>
    </body>
</html>