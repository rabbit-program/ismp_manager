function to_url(obj,pc,data){
	//病毒
	var vm ="/ismp/domain/local/vpm/vm/vmAction.do";
	//补丁
	var pm ="/ismp/domain/local/vpm/pm/pmAction.do";
	//软件分发
	var sd="/ismp/domain/local/vpm/sd/softwareDistributionAction.do?method=softwareAll";
	data.href = pc += obj == 'vm' ? vm : obj == 'pm' ? pm : obj == 'sd' ? sd :"";
}