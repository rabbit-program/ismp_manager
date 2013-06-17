function validate_SysLogQuery() {
	var start = document.getElementById("beginDate").value;
	var end = document.getElementById("endDate").value;
	var hostname = document.getElementById("hostname").value;
	
	if (start.length == "") {
		alert("请输入开始时间");
		return false;
	}
	if (end.length == "") {
		alert("请输入结束时间");
		return false;
	}
	if (start > end) {
		alert("输入的开始时间必须要小于结束时间");
		return false;
	} else {
		if(hostname.length > 0){
			if (!hostname.match(/^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$/)) {
				alert("你输入的IP地址无效"); 
				return false;
			} else {
				return true;
			}
		}else{
			return true;
		}
	}
}

function validate_SysLogSourceQuery(){
	var deviceIP = document.getElementById("deviceIP").value;
	if(deviceIP.length > 0){
		if (!deviceIP.match(/^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$/)) {
			alert("你输入的IP地址无效"); 
			return false;
		} else {
			return false;
		}
	}else{
		return false;
	}
}

function validate_addSysLogSource(){
	var sourceName = document.getElementById("sourceName").value;
	var domain = document.getElementById("domainId").value;
	var sourceType = document.getElementById("sourceType").value;
	var deviceIP = document.getElementById("ip").value;
	
	if(domain!="noDomain"){
		if(sourceType!="noSourceType"){
			if(sourceName.length > 0){
				if(deviceIP.length > 0){
					if (!deviceIP.match(/^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$/)) {
						alert("你输入的IP地址无效"); 
						return false;
					} else {
						return true;
					}
				}else{
					alert("请输入设备IP!");
					return false;
				}
			}else{
				alert("请输入日志源名称!");
				return false;
			}
		}else{
			alert("请选择设备!");
			return false;
		}
	}else{
		alert("请选择部门!");
		return false;
	}
}
