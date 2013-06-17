/**
 * 项目管理界面JS
 * 
 * @return
 */
function gorespDelete(Path,id) {
	var r = confirm("确认删除")
	if (r == true) {
		window.location.href = Path + "addrespinfo.do?method=deteleresp&id="
				+ id;
	}

}

function checkRespInput() {
	if (document.getElementById("itsysname").value == null
			|| document.getElementById("itsysname").value == undefined
			|| document.getElementById("itsysname").value == ""
			|| document.getElementById("itsysname").value.length > 25) {
		alert("系统名称必填且不超过25个字符!");
		return false;
	} else if (document.getElementById("references1").value == null
			|| document.getElementById("references1").value == undefined
			|| document.getElementById("references1").value == ""
			|| document.getElementById("references1").value.length > 500) {
		alert("参考文献必填且不超过500个字符!");
		return false;
	} else if (document.getElementById("department").value == null
			|| document.getElementById("department").value == undefined
			|| document.getElementById("department").value == ""
			|| document.getElementById("department").value.length > 50) {
		alert("所属单位必填且不超过50个字符!");
		return false;
	} else if (document.getElementById("itdescription").value == null
			|| document.getElementById("itdescription").value == undefined
			|| document.getElementById("itdescription").value == ""
			|| document.getElementById("itdescription").value.length > 500) {
		alert("IT系统描述必填且不超过500个字符!");
		return false;
	} else if (document.getElementById("purposes").value == null
			|| document.getElementById("purposes").value == undefined
			|| document.getElementById("purposes").value == ""
			|| document.getElementById("purposes").value.length > 500) {
		alert("应急目标描述必填且不超过500个字符!");
		return false;
	} else if (document.getElementById("assuptions").value == null
			|| document.getElementById("assuptions").value == undefined
			|| document.getElementById("assuptions").value == ""
			|| document.getElementById("assuptions").value.length > 500) {
		alert("预备案的假定必填且不超过500个字符!");
		return false;
	} else {
		return true;
	}

}

function gorespAdd(Path) {
	// alert(Path+"goaddresp.do");
	window.location.href = Path + "goaddresp.do";
	
}

function goIndex(Path) {
	// alert(Path+"goaddresp.do");
	window.location.href = Path + "resplist.do";

}

function buildRespEvent(Path) {
	window.location.href = Path + "/buildRespEvent.do";
}

function goIsmpIndex(Path) {
	window.location.href = Path + "";

}

/**
 * 联系人树方法
 */
function call(url) {
	window
			.open(
					url,
					'newwindow',
					'height=400,width=400,top=200,left=400,toolbar=no,menubar=no,scrollbars=no, resizable=yes,location=no, status=yes')
}

function golinkDelete(Path) {
	var seletevalue = document.getElementById("id").value;

	if (seletevalue == "" || seletevalue == null) {
		alert("请选择 节点！");
	} else {
		var r = confirm("确认删除")
		if (r == true) {
			window.location.href = Path + "/callTree.do?method=deleteNode&linkManId="+seletevalue;
		}
	}
}

function addNode() {

	var seletevalue = document.getElementById("id").value;

	if (seletevalue == "" || seletevalue == null) {
		alert("请选择 要添加子节点所属父节点！");
	} else {
		document.getElementById("editlinkman").style.display = "";
		document.getElementById("editlinkTeam").style.display = "none";
	}
}

function addTeam() {

	var seletevalue = document.getElementById("id").value;

	if (seletevalue == "" || seletevalue == null) {
		alert("请选择 要添加子节点所属父节点！");
	} else {
		document.getElementById("editlinkTeam").style.display = "";
		document.getElementById("editlinkman").style.display = "none";
	}
}

function callTreePost() {
	if (document.getElementById("ename").value == ""
			|| document.getElementById("ename").value == null
			|| document.getElementById("ename").value == undefined
			|| document.getElementById("ename").value.length > 20) {
		alert("姓名必须填写且不能超过20个字");
		return false;

	} else if (document.getElementById("emp").value == ""
			|| document.getElementById("emp").value == null
			|| document.getElementById("emp").value == undefined
			|| document.getElementById("emp").value.length > 11) {
		alert("手机号不能超过11个字符");
		return false;
	} else if (document.getElementById("ejob").value == ""
			|| document.getElementById("ejob").value == null
			|| document.getElementById("ejob").value == undefined
			|| document.getElementById("ejob").value.length > 20) {
		alert("工作角色必须填写正确且不能超过20个字");
		return false;
	} else if (document.getElementById("efax").value == ""
			|| document.getElementById("efax").value == null
			|| document.getElementById("efax").value == undefined
			|| !this.isTel(document.getElementById("efax").value)
			|| document.getElementById("efax").value.length > 10) {
		alert("传真号码必须填写正确且不能超过10个字符");
		return false;
	} else if (document.getElementById("eemail").value == ""
			|| document.getElementById("eemail").value == null
			|| document.getElementById("eemail").value == undefined
			|| !/(\S)+[@]{1}(\S)+[.]{1}(\w)+/.exec(document
					.getElementById("eemail").value)
			|| document.getElementById("eemail").value.length > 50) {
		alert("邮件地址必须填写正确且不能超过50个字符");
		return false;
	} else {

		return true;

	}
}

 function checkCallTreeTeam() {
	 if (document.getElementById("name1").value == ""
			|| document.getElementById("name1").value == null
			|| document.getElementById("name1").value == undefined
			|| document.getElementById("name1").value.length > 20) {
		alert("小组名称必须填写且不能超过20个字");
		return false;

	} else if (document.getElementById("teamId").value == ""
			|| document.getElementById("teamId").value == null
			|| document.getElementById("teamId").value == undefined
			|| document.getElementById("teamId").value.length > 5) {
		alert("小组编号必须填写且不能超过5个字符");
		return false;
	} 
	 return true;
 }

 function checkCallTree() {
	
	var teamId = document.getElementById("teamId").value;
	if(teamId !="") {
		if(teamId.length > 5) {
			alert("小组编号不能超过5个字符");
			return false;
		}
		
	}
	if (document.getElementById("name").value == ""
			|| document.getElementById("name").value == null
			|| document.getElementById("name").value == undefined
			|| document.getElementById("name").value.length > 20) {
		alert("姓名必须填写且不能超过20个字");
		return false;

	} else if (document.getElementById("mp").value == ""
			|| document.getElementById("mp").value == null
			|| document.getElementById("mp").value == undefined
			|| document.getElementById("mp").value.length > 11) {
		alert("手机号不能超过11个字");
		return false;
	} else if (document.getElementById("job").value == ""
			|| document.getElementById("job").value == null
			|| document.getElementById("job").value == undefined
			|| document.getElementById("job").value.length > 20) {
		alert("工作角色必须填写正确且不能超过20个字");
		return false;
	} else if (document.getElementById("fax").value == ""
			|| document.getElementById("fax").value == null
			|| document.getElementById("fax").value == undefined
			|| !this.isTel(document.getElementById("fax").value)
			|| document.getElementById("fax").value.length > 10) {
		alert("传真号码必须填写正确且不能超过10个字符");
		return false;
	} else if (document.getElementById("email").value == ""
			|| document.getElementById("email").value == null
			|| document.getElementById("email").value == undefined
			|| !/(\S)+[@]{1}(\S)+[.]{1}(\w)+/.exec(document
					.getElementById("email").value)
			|| document.getElementById("email").value.length > 50) {
		alert("邮件地址必须填写正确且不能超过50个字符");
		return false;
	} else {
        return true;
	}

}


 
/**
 * BIA方法
 * 
 * @param values
 * @return
 */
function updateBIA(values) {
	GetassetDao.findAssetByBusiId(values, createList);
}
function createList(asseList) {
	// alert(document.getElementById("asset_name").value);
	DWRUtil.removeAllOptions("asset_name");
	if(asseList!=undefined) {
		    //alert(asseList.length);
		for(i=0;i<asseList.length;i++) {
			data = asseList[i];
			//alert(data[0]);
			//alert(data[1]);
			array = [{value:data[0],text:data[1]}];
			DWRUtil.addOptions("asset_name", array, "value","text");
		}
	}
	
	
}

function updateAesst(assetCode) {
	//alert(values);
	var proj_key = document.getElementById("proj_key").value;
	var selectedIndex = document.getElementById("biz_name").selectedIndex;
	var biz_Names = document.getElementById("biz_name");
	var businessId = biz_Names[selectedIndex].value;
	//alert(biz_Name);alert(asset_name);alert(proj_key);
	bia.findByAesst(businessId, assetCode, proj_key, createProList);
}

function createProList(data) {
	// alert(document.getElementById("asset_name").value);
	if (data == null || data == "") {
		document.getElementById("cp_rpo").value = "";
		document.getElementById("cp_rto").value = "";
		
	} else {
		for ( var i = 0; i < data.length; i++) {
			DWRUtil.setValue("cp_priority",data[i].cp_priority);
			document.getElementById("cp_rpo").value = data[i].cp_rpo;
			document.getElementById("cp_rto").value = data[i].cp_rto;
		}
	}
}



function checkBiaInput() {
	 //alert(document.getElementById("proj_key").value);
	if (!/^\d+$/.test(document.getElementById("cp_rpo").value)
			|| !/^\d+$/.test(document.getElementById("cp_rto").value)) {
		alert("RPO,RTO必须填写且为数字");
		return false;
	} else if (document.getElementById("proj_key").value == null
			|| document.getElementById("proj_key").value == undefined
			|| document.getElementById("proj_key").value == "") {
		alert("请到预案管理页面选择预案");
		return false;
	} else if (document.getElementById("cp_priority").value == null
			|| document.getElementById("cp_priority").value == undefined
			|| document.getElementById("cp_priority").value == "") {
		alert("请选择应急优先等级");
		return false;
	} else if (document.getElementById("asset_name").value == null
			|| document.getElementById("asset_name").value == undefined
			|| document.getElementById("asset_name").value == "") {
		alert("必须选择关键资产");
		return false;
	} else if (document.getElementById("cp_rpo").value == null
			|| document.getElementById("cp_rpo").value == undefined
			|| document.getElementById("cp_rpo").value == "") {
		alert("RPO必须填写");
		return false;
	} else if (document.getElementById("cp_rto").value == null
			|| document.getElementById("cp_rto").value == undefined
			|| document.getElementById("cp_rto").value == "") {
		alert("RTO必须填写");
		return false;
	} else {
		return true;
	}
}

/**
 * 应急响应规程方法
 * 
 * @param values
 * @return
 */
function updatenotice(values) {
	continotifyprocDao.findById(values, createnoticeList);

}
function createnoticeList(data) {

	for ( var i = 0; i < data.length; i++) {
		document.getElementById("notifyname").value = data[i].notify_proc;
		document.getElementById("np_content").value = data[i].np_content;
		// alert(data[i].np_content);
		// alert(data[i].notify_proc);
	}

}
function gonoticedelete(Path,id) {
	try {
	//	var seletevalue = document.getElementById("notify").value;
		var r = confirm("确认删除")
		if (r == true) {
			window.location.href = Path
					+ "/continotifyproc.do?method=deletenotify&id="
					+ id;
		} else {
			return;
		}
	} catch (Exception) {
		alert("wrong");
	}
}

function editdictate(Path,procid,procName,rulesPage) {
		window.location.href = Path
				+ "/continotifyInst.do?method=instInit&procid="+procid+"&procName="+procName+"&rulesPage="+rulesPage;
}

function checkNotifuProc1() {
	// alert(document.getElementById("notifyname").value.length);
	if (document.getElementById("np_content2").value == null
			|| document.getElementById("np_content2").value == undefined
			|| document.getElementById("np_content2").value == ""
			|| document.getElementById("np_content2").value.length > 500) {
		alert("请填写通知规程内容且不超过500个字符");
		return false;
	} else if (document.getElementById("notifyname").value == null
			|| document.getElementById("notifyname").value == undefined
			|| document.getElementById("notifyname").value == ""
			|| document.getElementById("notifyname").value.length > 50) {
		alert("请填写通知规程名称且不超过50个字符");
		return false;
	} else {
		return true;
	}

}

function checkNotifuProc2() {
	// alert(document.getElementById("notifyname1").value.length);
	if (document.getElementById("np_content1").value == null
			|| document.getElementById("np_content1").value == undefined
			|| document.getElementById("np_content1").value == ""
			|| document.getElementById("np_content1").value.length > 500) {
		alert("请填写通知规程内容且不超过500个字符");
		return false;
	} else if (document.getElementById("notifyname1").value == null
			|| document.getElementById("notifyname1").value == undefined
			|| document.getElementById("notifyname1").value == ""
			|| document.getElementById("notifyname1").value.length > 20) {
		alert("请填写通知规程名称且不超过20个字符");
		return false;
	} else {
		return true;
	}

}

/**
 * 应用通知指令
 * 
 * @param values
 * @return
 */
function updatestruc(values) {
	continotifyinstDao.findById(values, createstrucList);
}
function createstrucList(data1) {

	for ( var i = 0; i < data1.length; i++) {
		document.getElementById("notify_instruct1").value = data1[i].notify_instruct;
		document.getElementById("ni_content1").value = data1[i].ni_content;
		// alert(data[i].np_content);
		// alert(data[i].notify_proc);
	}
}

function gosturcdelete(Path,id) {
		var r = confirm("确认删除")
		if (r == true) {
			window.location.href = Path
					+ "/continotifyInst.do?method=deleteNotifyinst&id="
					+ id;
		} else {
			return;
		}
}

function checkNotifuStrc1() {
	// alert(document.getElementById("ni_content1").value.length);
	if (document.getElementById("ni_content1").value == null
			|| document.getElementById("ni_content1").value == undefined
			|| document.getElementById("ni_content1").value == ""
			|| document.getElementById("ni_content1").value.length > 500) {
		alert("请填写通知指令内容且不超过500个字符");
		return false;
	} else if (document.getElementById("notify_instruct1").value == null
			|| document.getElementById("notify_instruct1").value == undefined
			|| document.getElementById("notify_instruct1").value == ""
			|| document.getElementById("notify_instruct1").value.length > 50) {
		alert("请填写通知指令名称且不超过50个字符");
		return false;
	} else {
		return true;
	}

}

function checkNotifuStrc2() {
	// alert(document.getElementById("ni_content2").value.length);
	if (document.getElementById("ni_content2").value == null
			|| document.getElementById("ni_content2").value == undefined
			|| document.getElementById("ni_content2").value == ""
			|| document.getElementById("ni_content2").value.length > 500) {
		alert("请填写通知指令内容且不超过500个字符");
		return false;
	} else if (document.getElementById("notify_instruct2").value == null
			|| document.getElementById("notify_instruct2").value == undefined
			|| document.getElementById("notify_instruct2").value == ""
			|| document.getElementById("notify_instruct2").value.length > 20) {
		alert("请填写通知指令名称且不超过20个字符");
		return false;
	} else {
		return true;
	}

}

/**
 * 应急响应过程
 */
var respProceeValue;
function threatsUpdate(select) {
	// this.options[this.selectedIndex].value
	values = select.options[select.selectedIndex].value
	bullyName = select.options[select.selectedIndex].innerText;
	document.getElementById("bullyName").value = bullyName;
	document.getElementById("respThreatsName").value = bullyName;
	document.getElementById("respThreatsId").value = values;
	// alert(bullyName+values);
	window.location.href="contiProcessAction.do?method=showBullyToProcess&bullyName="+bullyName;
	//contirespproc.findByThreat(bullyName, createThreatsList);

}

function createThreatsList(data) {
	// alert(data);
	document.getElementById("proc_content").value = "";
	DWRUtil.removeAllOptions("proc_name");
    DWRUtil.addOptions("proc_name", data, "id", "resp_name");
}

function procUpdate(select) {

	respProceeValue = select.options[select.selectedIndex].value

	bullyName = select.options[select.selectedIndex].innerText;

	document.getElementById("respName").value = bullyName;

	contirespproc.findById(respProceeValue, createProcList);

}

function createProcList(data) {
	// alert(data);
	for ( var i = 0; i < data.length; i++) {
		document.getElementById("proc_content").value = data[i].resp_desp;
	}
}

function gorespProcDelete(Path ,id) {
		var r = confirm("确认删除")
		if (r == true) {
			window.location.href = Path
					+ "contiProcessAction.do?method=deleteProcess&id="
					+ id;
		} else {
			return;
		}
}

function goRespStrucion(Path,id,name,curpage) {
		window.location.href = Path
				+ "/respStructionAction.do?method=StructionList&processId="+id+"&processName="+name+"&processPage="+curpage;
}

function goRespScript(Path,id) {
	
		window.location.href = Path
				+ "/respScriptAction.do?method=showScript&processId="
				+ id;
}

function checkRespProcee() {
	if (document.getElementById("proc_name").value == null
			|| document.getElementById("proc_name").value == undefined
			|| document.getElementById("proc_name").value == "") {
		alert("请选择应急响应过程");
		return false;
	} else if (document.getElementById("proc_content").value == null
			|| document.getElementById("proc_content").value == undefined
			|| document.getElementById("proc_content").value == ""
			|| document.getElementById("proc_content").value.length > 500) {
		alert("请填写应急响应过程内容且不超过500个字符");
		return false;
	} else {
		return true;
	}

}

function checkNewProcee() {
	
    document.getElementById("respThreatsId").value=document.getElementById("bullyId").value;
	if (document.getElementById("respRocename").value == null
			|| document.getElementById("respRocename").value == undefined
			|| document.getElementById("respRocename").value == ""
			|| document.getElementById("respRocename").value.length > 20) {
		alert("请选填写应急响应过程名称且不能超过20个字符");
		return false;
	} else if (document.getElementById("procContent").value == null
			|| document.getElementById("procContent").value == undefined
			|| document.getElementById("procContent").value == ""
			|| document.getElementById("procContent").value.length > 255) {
		alert("请填写应急响应过程内容且不超过255个字符");
		return false;
	} else {
		return true;
	}

}
function checkNewProcee1() {
	
	document.getElementById("respThreatsId1").value=document.getElementById("bullyId").value;
	if (document.getElementById("respRocename1").value == null
			|| document.getElementById("respRocename1").value == undefined
			|| document.getElementById("respRocename1").value == ""
				|| document.getElementById("respRocename").value.length > 20) {
		alert("请选填写应急响应过程名称且不能超过20个字符");
		return false;
	} else if (document.getElementById("procContent1").value == null
			|| document.getElementById("procContent1").value == undefined
			|| document.getElementById("procContent1").value == ""
				|| document.getElementById("procContent1").value.length > 255) {
		alert("请填写应急响应过程内容且不超过255个字符");
		return false;
	} else {
		return true;
	}
	
}

function checkNewProceeScript() {
	

		if (document.getElementById("scriptName").value == null
				|| document.getElementById("scriptName").value == undefined
				|| document.getElementById("scriptName").value == ""
				|| document.getElementById("scriptName").value.length > 20) {
			alert("请选填写应急响应过程名称且不能超过20个字符");
			return false;
		} else if (document.getElementById("sctiptContent").value == null
				|| document.getElementById("sctiptContent").value == undefined
				|| document.getElementById("sctiptContent").value == ""
				|| document.getElementById("sctiptContent").value.length > 255) {
			alert("请填写应急响应过程内容且不超过255个字符");
			return false;
		} else {
			return true;
		}
	
}
/**
 * 应急响应指令
 * 
 * @param values
 * @return
 */
function updateRespStruc(values) {
	contiRespStrcu.dwrfindById(values, createStrucText);
}
function createStrucText(data1) {
	// alert(data1);
	for ( var i = 0; i < data1.length; i++) {
		document.getElementById("resp_content").value = data1[i].ri_content;
		document.getElementById("resp_instruct").value = data1[i].rep_instuct;
		// alert(data[i].np_content);
		// alert(data[i].notify_proc);
	}
}

function goStructionDelete(Path) {
	var seletevalue = document.getElementById("respInst").value;
	if (seletevalue == "" || seletevalue == null) {
		alert("请选择指令！");
	} else {
		var r = confirm("确认删除")
		if (r == true) {
			window.location.href = Path
					+ "respStructionAction.do?method=deleteRespStruc&id="
					+ seletevalue;
		} else {
			return;
		}
	}
}

function checkSelect() {
	var strucIdvalue = document.getElementById("resp_proc_id").value;

	// alert(strucIdvalue);
	if (strucIdvalue == "" || strucIdvalue == null) {
		// document.getElementById("resp_name").readonly = "readonly";

		alert("请到应急响应过程页面选择响应过程！");
		return false;
	} else {
		return false;
	}
}

function callBack(Path) {

	window.location.href = Path + "contiProcessAction.do?method=showProcess";
}

function checkRespStrucEdit() {
	if (document.getElementById("resp_instruct").value == null
			|| document.getElementById("resp_instruct").value == undefined
			|| document.getElementById("resp_instruct").value == ""
			|| document.getElementById("resp_instruct").value.length > 20) {
		alert("请填写应急响应指令名称且不超过20个字符");
		return false;
	} else if (document.getElementById("resp_content").value == null
			|| document.getElementById("resp_content").value == undefined
			|| document.getElementById("resp_content").value == ""
			|| document.getElementById("resp_content").value.length > 500) {
		alert("请填写应急响应指令内容且不超过500个字符");
		return false;
	} else {
		return true;
	}

}

function checkRespManager(){
	if(document.getElementById("processContent").value != null || document.getElementById("processContent").value != ""){
	 if (document.getElementById("processContent").value.length > 2000) {
		alert("应急通知内容不超过2000个字");
		document.getElementById("processContent").focus;
		return false;
	 } 
	}
	
	if(document.getElementById("resp_summary").value != null || document.getElementById("resp_summary").value != ""){
	 if (document.getElementById("resp_summary").value.length > 2000) {
		alert("应急过程总结不超过2000个字");
		document.getElementById("resp_summary").focus;
		return false;
	 }
	}
		return true;
}

function checkRespEvent() {
	if (document.getElementById("event_name").value == null
			|| document.getElementById("event_name").value == undefined
			|| document.getElementById("event_name").value == ""
			|| document.getElementById("event_name").value.length > 20) {
		alert("请填写事件名称且不超过20个字符");
		return false;
	} else if (document.getElementById("event_type").value == null
			|| document.getElementById("event_type").value == undefined
			|| document.getElementById("event_type").value == ""
			|| document.getElementById("event_type").value.length > 20) {
		alert("请填写事件类型且不超过20个字符");
		return false;
	} else if (document.getElementById("system").value == null
			|| document.getElementById("system").value == undefined
			|| document.getElementById("system").value == ""
			|| document.getElementById("system").value.length > 20) {
		alert("请填写对应系统且不超过20个字符");
		return false;
	} else if (document.getElementById("eventContent").value == null
			|| document.getElementById("eventContent").value == undefined
			|| document.getElementById("eventContent").value == "") {
		alert("请填写事件内容");
		return false;
	} else {

		return true;

	}
}

function searchProj(){
	var system = document.getElementById("system").value;
	respManagerService.findProjBySystem(system, retProjList);
}

function retProjList(data){
	
	if(!data.length) {
	    alert("对应系统无相关预案");
	}else{
		var projKey = $("projKey").value;
		DWRUtil.removeAllOptions("proj_key");
		DWRUtil.addOptions("proj_key",data,"projid","projname");
		DWRUtil.setValue("proj_key",projKey);
	 }
}

function selectProcessContent(Path){
	
	var projKey = document.getElementById("proj_key").value;
	if(projKey == "" || projKey == null){
	  alert("请选择预案");
	}else{
	  var pageno = document.getElementById("pageno").value;
	  var contiProManageId = document.getElementById("id").value;
	  forward=Path+"/continotifyproc.do?method=selectProcessContent"
		  +"&pageno="+pageno+"&contiProManageId="+contiProManageId+"&projKey="+projKey;
	  //alert(forward);
	  window.location.href=forward;
	}
}

 function sendMessage(Path) {
	var contiProManageId = document.getElementById("id").value;
	var projKey = document.getElementById("proj_key").value;
	if(projKey == "" || projKey == null){
	  alert("请选择预案");
	}else{
	  url=Path+"/respManagerAction.do?method=sendMessage"
	          +"&contiProManageId="+contiProManageId+"&projid="+projKey;
	  secondWindow = open(url,"detail","height=400,width=300,scrollbars=yes");
	}
}

 function sendEmail() {
	 var contiProManageId = document.getElementById("contiProManageId").value;
	 var checkBoxList = document.all.linkmanId;
	 var chk = false;
	 var linkmanId="";
	 if(checkBoxList.length != undefined){
	  for(j=0;j<checkBoxList.length;j++){
		   if(checkBoxList[j].checked){
			   linkmanId=linkmanId+checkBoxList[j].value+";"
			   chk = true;
			   
		}
		   
	  }
	 }else{
		    if(checkBoxList.checked){
		    	linkmanId = checkBoxList.value+";"
			      chk = true;
			}
		  }
	 if(chk){
	    	alert("已发送");
	    	respManagerService.sendEmail(contiProManageId, linkmanId, retSendInfo);
	   }else{
	        alert("请选择小组联系人");
	   }
 }

 function retSendInfo(data) {
	 alert(data);
 }
 
 function copyProcessContent(Path) {
	var notifyId = document.getElementById("notify").value;
	if (notifyId == "" || notifyId == null) {
		alert("请选择通知过程");
	} else {
		forward=Path+"/continotifyproc.do?method=copyProcessContent"
		  +"&notifyId="+notifyId;
		window.location.href=forward;
	}
}
 
 function showScript(Path) {
	 var proj_key = document.getElementById("proj_key").value;
	 if(proj_key == "" || proj_key==null || proj_key==undefined){
		 alert("尚未关联应急预案");
	 }else{
		 secondWindow = open(Path+"/frame/resp/scriptInfo.jsp?projKey="+proj_key,"detail","height=550,width=500,scrollbars=yes");
		 
	 }
 }
 
 function copyProcessContentInstruction(Path) {
	 var notifyInstId = document.getElementById("notifyInst").value;
	 if (notifyInstId == "" || notifyInstId == null) {
			alert("请选择通知指令");
		} else {
			forward=Path+"/continotifyInst.do?method=copyProcessInstructionContent"
			  +"&notifyInstId="+notifyInstId;
			window.location.href=forward;
		}
 }
 
 function generateYuAnFile(Path){
	 var proj_key = document.getElementById("proj_key").value;
	 if(proj_key == "" || proj_key==null || proj_key==undefined){
		 alert("请选择预案");
	 }else{
		 var contiBasicInfoId = document.getElementById("contiBasicInfoId").value;
		 //alert(contiBasicInfoId);
		 url=Path+"/RespSchemeReport.do?schemeId="+contiBasicInfoId;
		 window.open(url,"report","scrollbars=yes");
	 }
 }
 
 function checkRespPrint() {
	 var proj_key = document.getElementById("proj_key").value;
	 if(proj_key == "" || proj_key==null || proj_key==undefined){
		 alert("请选择预案");
		 return false;
	 }else{
		 return true;
	 }
 }
 
 function printFile() {
	 var inputRtfFile = document.getElementById("cp_content").innerHTML;
	 if(inputRtfFile == "" || inputRtfFile==null || inputRtfFile==undefined){
		 alert("请选择预案文件");
		 
	 }else{
		 alert(inputRtfFile);
		 window.print(inputRtfFile);
	 }
 }
 
 function getContiFileMime(path) {
	 var proj_key = document.getElementById("proj_key").value;
	 forward=path+"/respPrintAction.do?method=getContiFileMime"
	  +"&proj_key="+proj_key;
	window.location.href=forward;
 }

function checkRespStrucNew() {

    if (document.getElementById("resp_name").value == null
			|| document.getElementById("resp_name").value == undefined
			|| document.getElementById("resp_name").value == ""
			|| document.getElementById("resp_name").value.length > 20) {
		alert("请填写应急响应指令名称且不超过20个字符");
		return false;
	} else if (document.getElementById("inStruction_Content").value == null
			|| document.getElementById("inStruction_Content").value == undefined
			|| document.getElementById("inStruction_Content").value == ""
			|| document.getElementById("inStruction_Content").value.length > 500) {
		alert("请填写应急响应指令内容且不超过500个字符");
		return false;
	} else {

		return true;

	}

}

function addScript() {
	if (document.getElementById("script_id").value == null
			|| document.getElementById("script_id").value == undefined
			|| document.getElementById("script_id").value == "") {
		alert("请选择脚本");
		return false;
	} else {

		return true;
	}

}

function callScritpBack(Path) {

	window.location.href = Path + "contiProcessAction.do?method=showProcess";
}

/**
 * 通用方法：检测邮箱地址合法性
 * 
 * @param object
 * @return
 */
function checkEmail(emailAddress) {
	var pattern = /^[a-zA-Z0-9_\-]{1,}@[a-zA-Z0-9_\-]{1,}\.[a-zA-Z0-9_\-.]{1,}$/;
	if (emailAddress != "") {
		if (!pattern.exec(emailAddress)) {
			alert('请输入正确的邮箱地址');
			return false;
		} else {

			return true;
		}
	}
}

String.prototype.Trim = function() 
{ 
return this.replace(/(^\s*)|(\s*$)/g, ""); 
} 
String.prototype.LTrim = function() 
{ 
return this.replace(/(^\s*)/g, ""); 
} 
String.prototype.RTrim = function() 
{ 
return this.replace(/(\s*$)/g, ""); 
}

/**
 * 通用方法：检测手机号码合法性
 * 
 * @param object
 * @return
 */
function isMobile(mp) {
	var reg0 = /^13\d{5,9}$/;
	var reg1 = /^153\d{4,8}$/;
	var reg2 = /^159\d{4,8}$/;
	var reg3 = /^0\d{10,11}$/;
	var reg4 = /^189\d{4,8}$/;
	var my = false;
	if (reg0.test(mp))
		my = true;
	if (reg1.test(mp))
		my = true;
	if (reg2.test(mp))
		my = true;
	if (reg3.test(mp))
		my = true;
	if (reg4.test(mp))
		my = true;
	if (!my) {
		// alert('请输入正确的手机号码');
		return false;
	} else {

		return true;
	}

}

function isTel(fax) {
	// var patrn=/^[+]{0,1}(\d){1,3}[ ]?([-]?(\d){1,12})+$/;
	var patrn = /^[+]{0,1}(\d){1,3}[   ]?([-]?((\d)|[   ]){1,12})+$/;
	if (!patrn.test(fax)) {
		return false
	} else {
		return true
	}
}