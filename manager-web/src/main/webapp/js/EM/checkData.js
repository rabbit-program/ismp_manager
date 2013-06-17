/**
 * 配置界面JS
 * 
 * @return
 */
var ipPattern=/^\d{1,3}(\.\d{1,3}){3}$/;
var numPattern = /^[-]{0,1}[0-9]{1,}$/;
var mailPattern = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
function checkForm() {
	if (document.getElementById("centerIp").value == null
			|| document.getElementById("centerIp").value == undefined
			|| document.getElementById("centerIp").value == ""
			|| !ipPattern.exec(document.getElementById("centerIp").value)){
		alert("请输入有效的Center中心IP地址!");
		return false;
	} else if (document.getElementById("dataPort").value == null
			|| document.getElementById("dataPort").value == undefined
			|| document.getElementById("dataPort").value == ""
			|| !numPattern.test(document.getElementById("dataPort").value)) {
		alert("请输入有效的Mina通信数据传输端口号!");
		return false;
	} else if (document.getElementById("jettyPort").value == null
			|| document.getElementById("jettyPort").value == undefined
			|| document.getElementById("jettyPort").value == ""
			|| !numPattern.test(document.getElementById("jettyPort").value)){
		alert("请输入有效的与Center通信的jetty的端口号!");
		return false;
	} else if (document.getElementById("authorizationCode").value == null
			|| document.getElementById("authorizationCode").value == undefined
			|| document.getElementById("authorizationCode").value == "") {
		alert("请输入有效的Manger在Center的注册码!");
		return false;
	} else if (document.getElementById("jettyServerPort").value == null
			|| document.getElementById("jettyServerPort").value == undefined
			|| document.getElementById("jettyServerPort").value == ""
			|| !numPattern.test(document.getElementById("jettyServerPort").value)) {
		alert("请输入有效的与采集代理通信的jetty端口!");
		return false;
	} else if (document.getElementById("webPrefix").value == null
			|| document.getElementById("webPrefix").value == undefined
			|| document.getElementById("webPrefix").value == "") {
		alert("请输入有效的web.prefix!");
		return false;
	} else if (document.getElementById("echoService").value == null
			|| document.getElementById("echoService").value == undefined
			|| document.getElementById("echoService").value == "") {
		alert("请输入有效的echoService!");
		return false;
	} else if (document.getElementById("centerServer").value == null
			|| document.getElementById("centerServer").value == undefined
			|| document.getElementById("centerServer").value == ""){
		alert("请输入有效的centerServer!");
		return false;
	} else if (document.getElementById("insertTime").value == null
			|| document.getElementById("insertTime").value == undefined
			|| document.getElementById("insertTime").value == ""
			||!numPattern.test(document.getElementById("insertTime").value)) {
		alert("请输入有效的事件插入时间窗!");
		return false;
	} else if (document.getElementById("faciListenerTime").value == null
			|| document.getElementById("faciListenerTime").value == undefined
			|| document.getElementById("faciListenerTime").value == ""
			|| !numPattern.test(document.getElementById("faciListenerTime").value)) {
		alert("请输入有效的IP事件统计监听器处理时间!");
		return false;
	} else if (document.getElementById("aggreListenerTime").value == null
			|| document.getElementById("aggreListenerTime").value == undefined
			|| document.getElementById("aggreListenerTime").value == ""
			|| !numPattern.test(document.getElementById("aggreListenerTime").value)) {
		alert("请输入有效的归并事件监听器处理时间!");
		return false;
	} else if (document.getElementById("mailAddress").value == null
			|| document.getElementById("mailAddress").value == undefined
			|| document.getElementById("mailAddress").value == "") {
		alert("请输入有效的mailAddress!");
		return false;
	} else if (document.getElementById("mailFrom").value == null
			|| document.getElementById("mailFrom").value == undefined
			|| document.getElementById("mailFrom").value == ""
			|| !mailPattern.test(document.getElementById("mailFrom").value)) {
		alert("请输入有效的mailFrom!");
		return false;
	} else if (document.getElementById("mailPassword").value == null
			|| document.getElementById("mailPassword").value == undefined
			|| document.getElementById("mailPassword").value == "") {
		alert("请输入有效的mailPassword!");
		return false;
	}  else if (document.getElementById("centerSocktPort").value == null
			|| document.getElementById("centerSocktPort").value == undefined
			|| document.getElementById("centerSocktPort").value == ""
			|| !numPattern.test(document.getElementById("centerSocktPort").value)) {
		alert("请输入有效的管理中心Socket端口!");
		return false;
	}  else if (document.getElementById("messIp").value == null
			|| document.getElementById("messIp").value == undefined
			|| document.getElementById("messIp").value == ""
			|| !ipPattern.test(document.getElementById("messIp").value)) {
		alert("请输入有效的短信平台IP!");
		return false;
	}  else if (document.getElementById("messPort").value == null
			|| document.getElementById("messPort").value == undefined
			|| document.getElementById("messPort").value == ""
			|| !numPattern.test(document.getElementById("messPort").value)) {
		alert("请输入有效的短信平台端口!");
		return false;
	}  else {
		return true;
	}

}

