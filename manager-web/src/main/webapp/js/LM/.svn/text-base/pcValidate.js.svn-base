function reset(){
	var sensorSenquence = document.getElementsByName("sensorSequence");
    for(i=0; i < sensorSenquence.length; i++) {
        sensorSenquence[i].checked = false;
    }
}
function selectAll(){
	var sensorSenquence = document.getElementsByName("sensorSequence");
    for(k=0; k < sensorSenquence.length; k++) {
        sensorSenquence[k].checked = true;
    }
}

function updateAllStatus(){
	alert("OK");
	var sensorSenquence = document.getElementsByName("sensorSequence");
	var isSelect = false;
	var idList = "";
	for(j = 0; j < sensorSenquence.length; j ++){
		if(sensorSenquence[j].checked == true){
			isSelect = true;
			idList = idList + sensorSenquence[j].value + ",";
		}
	}
    if(isSelect == false){
        alert("请选择要关联的Sensor");
        return;
    }else{
        if(confirm("您是否要  开启  此批Sensor采集!")){
    		window.location.href="pcConfigAction.do?method=updatePcSource&id=" + idList;
        }else{
            return;
        }
    }
}
