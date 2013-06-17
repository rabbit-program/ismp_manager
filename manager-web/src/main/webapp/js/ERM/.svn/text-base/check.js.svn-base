function  trim(str){
    for(var i=0; i<str.length&&str.charAt(i)==" "; i++)  ;
    for(var j=str.length; j>0&&str.charAt(j-1)==" ";j--)  ;
    if(i>j) return "";  
    return  str.substring(i,j);  
} 

function callTreePost() {
	var name=document.getElementById("name").value ;
	var mp=document.getElementById("mp").value;
	var job = document.getElementById("job").value;
	var fax=document.getElementById("fax").value ;
	var email=document.getElementById("email").value;
	if (trim(name) == ""|| trim(name) == null|| name == undefined|| name.length > 20) {
		alert("姓名必须填写且不能超过20个字");
		name.focus();return;
	} 
	if (trim(mp) == ""|| trim(mp) == null|| mp == undefined|| mp.length > 11) {
		alert("手机号不能超过11个字符");
		mp.focus();
		return;
	} 
 	if (trim(job) == ""|| trim(job) == null|| job == undefined|| job.length > 20) {
		alert("工作角色必须填写正确且不能超过20个字");
		job.focus();
		return;
	} 
 	if (trim(fax) == ""|| trim(fax) == null|| fax == undefined|| !this.isTel(fax)|| fax.length > 10) {
		alert("传真号码必须填写正确且不能超过10个字符");
		fax.focus();return;
	} 
 	if (trim(email) == ""|| trim(email) == null|| email == undefined
			|| !/(\S)+[@]{1}(\S)+[.]{1}(\w)+/.exec(document.getElementById("email").value)|| email.length > 50) {
		alert("邮件地址必须填写正确且不能超过50个字符");
		email.focus();return;
	} 
}

 function checkCallTreeTeam() {
	 var name=document.getElementById("name").value ;
	 var team_code=document.getElementById("team_code").value;
	if (trim(name)== ""|| trim(name)== null|| name== undefined|| name.length > 20) {
		alert("小组名称必须填写且不能超过20个字");
		name.focus();return ;

	} 
	if (trim(team_code)== ""|| trim(team_code)== null|| team_code== undefined|| team_code.length > 5) {
		alert("小组编号必须填写且不能超过5个字符");
		team_code.focus();return ;
	} 
 }

 