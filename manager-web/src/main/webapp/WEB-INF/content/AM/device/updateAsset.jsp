<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" language="javascript" src="${ctx }/js/comm/date/WdatePicker.js"></script>
<script type='text/javascript' src='${ctx }/dwr/engine.js'></script>
<script type='text/javascript' src='${ctx }/dwr/util.js'></script>
<script type='text/javascript' src='${ctx }/dwr/interface/assetDwr.js'></script>
<script type="text/javascript">
        function ckeckForm(form){
        	var sn = document.getElementById("sn").value;
			if(sn==''){
				alert("资产编号不能为空！");
				return false;
			}else if(sn.length>30){
				alert("资产编号长度不能大于30！");
				return false;
			}
			var name = document.getElementById("name").value;
			if(name==''){
				alert("资产名称不能为空！");
				return false;
			}else if(name.length>15){
				alert("资产名称长度不能大于15！");
				return false;
			}
			var user = document.getElementById("user").value;
			if(user==''){
				alert("使用人不能为空！");
				return false;
			}else if(user.length>30){
				alert("使用人长度不能大于30！");
				return false;
			}
			var telephone = document.getElementById("telephone").value;
			if(telephone==''){
				alert("电话不能为空!");
				return false;
			}
			var unit = document.getElementById("unit").value;
			if(unit==''){
				alert("单位不能为空！");
				return false;
			}else if(unit.length>100){
				alert("单位长度太长！");
				return false;
			}
			var department = document.getElementById("department").value;
			if(department==''){
				alert("部门不能为空！");
				return false;
			}else if(department.length>100){
				alert("部门长度太长！");
				return false;
			}
			var regid = document.getElementById("registrationtimepage").value;
			if(regid==''){
				alert("登记时间不能为空！");
				return false;
			}
			var stockid = document.getElementById("stocktimepage").value;
			if(stockid==''){
				alert("采购时间不能为空！");
				return false;
			}
			var validityPeriod = document.getElementById("validityPeriod").value;
			var vpch = /\d/;
			if(validityPeriod==''){
				alert("有效期不能为空！");
				return false;
			}else{
				if(vpch.test(validityPeriod)==false){
					alert("有效期必须为数字！");
					return false;
				}
			}

			var description = document.getElementById("description").value;
			if(description==''){
				alert("资产描述不能为空！");
				return false;
			}
            
            //验证IP地址
           var ipch= /^([1-9]|[1-9]\d|1\d{2}|2[0-1]\d|22[0-3])(\.(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])){3}$/  ;
           var ip=document.getElementById("ipaddress").value;
            if(ip!=''){
                if(ipch.test(ip)==false){
                   alert('IP地址不正确（IP地址格式为：192.168.9.253）');
                   return false;
                }
            }
            //验证MAC地址
            var macaddress=document.getElementById("macaddress").value;
            var reg_name=/[A-F\d]{2}:[A-F\d]{2}:[A-F\d]{2}:[A-F\d]{2}:[A-F\d]{2}:[A-F\d]{2}/;
            if(macaddress!=''){  
                if(!reg_name.test(macaddress)){  
                  alert("mac地址格式不正确！mac地址格式为00:24:21:19:BD:E4");
                  return false; 
                }
            }
            return validateAssetForm(form);
         }

        function selectModelsByEn(val){
        	if( val == "unknown"){
       		 var sel = document.getElementById("model");
       		 sel.options.length=0;
       		 sel.options.length=1;
       		 sel.options[0].value="unknown";
       		 sel.options[0].text="未知";
                return true;
            }else{
            var enName=val;
            assetDwr.selectModels(enName,function(data){
                alert(data);
				var modleObject = document.getElementById("model");
   				var opt;
   				modleObject.options.length=0;
				for(var i=0;i<data.length;i++){
						opt = new Option(data[i].name,data[i].name);
						modleObject.add(opt);
					}
                }); 
            }
        }
        </script>
<body>
<html:form action="/ismp/domain/local/am/asset.do?method=updateAsset"	onsubmit="return ckeckForm(this)">
	<div id="main">
	<div  id="data" class="pad1 ">
	<input type="hidden" value="${locid}" name="locid">
	<h2 class="martop8">更新设备信息<span class="STYLE1" style="color: #FF0000">(说明：带*号表示必填)</span></h2>
			<table>
				<tbody>
				<tr>
					<th>
					资产编号
					</th>
					<input type="hidden" value="${assetBo.id}" name="assetBo.id">
					<td width="37%"><input name="assetBo.sn" type="text" id="sn"
						value="${assetBo.sn}" maxlength="20" /> <span class="STYLE1" style="color: #FF0000">*</span></td>
					<th>
					资产名称
					</th>
					<td><input name="assetBo.name" type="text" id="name"
						value="${assetBo.name}" maxlength="20" /> <span class="STYLE1" style="color: #FF0000">*</span></td>
					
				</tr>
				
				<tr>
					<th>
					资产类型
					</th>
					<td><select name="assetBo.assetType">
						<option value="1" selected="selected">网络设备</option>
						<c:choose>
							<c:when test="${sessionScope.deviceType == 2}">
								<option value="2" selected="selected">安全设备</option>
							</c:when>
							<c:otherwise>
								<option value="2">安全设备</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${sessionScope.deviceType == 3}">
								<option value="3" selected="selected">服务器</option>
							</c:when>
							<c:otherwise>
								<option value="3">服务器</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${sessionScope.deviceType == 4}">
								<option value="4" selected="selected">桌面主机</option>
							</c:when>
							<c:otherwise>
								<option value="4">桌面主机</option>
							</c:otherwise>
						</c:choose>
					</select></td>
					<th>
					设备类型
					</th>
					<td><select id="tmType"
						onchange="selectModelsByEn(this.value);"
						name="assetBo.deviceType">
						<logic:notEmpty name="tmList">
							<logic:iterate id="al" name="tmList">
								<option value="${al.markName}"
									<c:if test="${al.markName eq assetBo.deviceType }">selected</c:if>>${al.markName}</option>
							</logic:iterate>
						</logic:notEmpty>
						<option value="unknown">未知</option>
					</select></td>
				</tr>
				<tr>
					
					<th>
					设备型号
					</th>
					<td width="36%"><select id="model" name="assetBo.model">
						<logic:notEmpty name="models">
							<logic:iterate id="al" name="models">
								<option value="${al.name}"
									<c:if test="${al.name eq assetBo.model }">selected</c:if>>${al.name}</option>
							</logic:iterate>
						</logic:notEmpty>
					</select>
					
					<!-- <select id="model" name="assetBo.model">
						<logic:notEmpty name="models">
							<logic:iterate id="al" name="models">
								<option value="${al.name}"
									<c:if test="${al.name eq assetBo.model }">selected</c:if>>${al.name}</option>
							</logic:iterate>
						</logic:notEmpty>
					</select> -->
					</td>
					<th>
					优 先 级
					</th>
					<td><select name="assetBo.priority">
						<c:choose>
							<c:when test="${assetBo.priority == 1}">
								<option selected="selected" value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</c:when>
							<c:when test="${assetBo.priority == 2}">
								<option value="1">1</option>
								<option selected="selected" value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>


							</c:when>
							<c:when test="${assetBo.priority == 3}">
								<option value="1">1</option>
								<option value="2">2</option>
								<option selected="selected" value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</c:when>
							<c:when test="${assetBo.priority == 4}">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option selected="selected" value="4">4</option>
								<option value="5">5</option>
							</c:when>
							<c:when test="${assetBo.priority == 5}">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option selected="selected" value="5">5</option>
							</c:when>
							<c:otherwise>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</c:otherwise>

						</c:choose>

					</select> （最高等级：5 最低等级：1）<span class="STYLE1" style="color: #FF0000">*</span></td>
				</tr>
				<tr>
					<th>
					IP 地 址
					</th>
					<td><input name="assetBo.ip" type="text" id="ipaddress"
						value="${assetBo.ip}" maxlength="20" /></td>
					<th>
					Mac 地址
					</th>
					<td nowrap="nowrap"><input name="assetBo.mac" type="text"
						id="macaddress" value="${assetBo.mac}" maxlength="20" />(格式：00:24:81:10:67:D6)</td>
					
				</tr>
				<tr>
					<th>
					使 用 人
					</th>
					<td><input name="assetBo.user" type="text" id="user"
						value="${assetBo.user}" maxlength="20"> <span
						class="STYLE1" style="color: #FF0000">*</span></td>
					<th>
					电 话
					</th>
					<td><input name="assetBo.telephone" type="text" id="telephone"
						value="${assetBo.telephone}" maxlength="20" /> <span
						class="STYLE1" style="color: #FF0000">*</span></td>
				</tr>
				<tr>
					
					<th>
					单 位：
					</th>
					<td><input name="assetBo.unit" type="text" id="unit"
						value="${assetBo.unit}" maxlength="20"> <span
						class="STYLE1" style="color: #FF0000">*</span></td>
					<th>
					部 门
					</th>
					<td><input name="assetBo.department" type="text" id="department"
						value="${assetBo.department}" maxlength="20"> <span
						class="STYLE1" style="color: #FF0000">*</span></td>
				</tr>
				<tr>
					<th>
					资产状态
					</th>
					<td><select name="assetBo.status">
						<c:choose>
							<c:when test="${assetBo.status == 1}">
								<option value="1" selected="selected">在用</option>
								<option value="2">废弃</option>

							</c:when>
							<c:when test="${assetBo.status == 2}">
								<option value="1">在用</option>
								<option value="2" selected="selected">废弃</option>
							</c:when>
							<c:otherwise>
								<option value="1">在用</option>
								<option value="2">废弃</option>
							</c:otherwise>
						</c:choose>
					</select> <span class="STYLE1" style="color: #FF0000">*</span></td>
					<th>
					登记时间
					</th>
					<td><input type="text" name="registrationtimepage" 
						id="registrationtimepage" readonly="readonly"
						value="${registrationtimepage}" class="Wdate"
						onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" /> <span
						class="STYLE1" style="color: #FF0000">*</span></td>
					

				</tr>
				<tr>
					<th>
					有 效 期
					</th>
					<td><input name="assetBo.validityPeriod" type="text" id="validityPeriod"
						maxlength="6" value="${assetBo.validityPeriod}" size="8">月
					<span class="STYLE1" style="color: #FF0000">*</span></td>
					<th>
					采购时间
					</th>
					<td><input type="text" name="stocktimepage"
						id="stocktimepage" readonly="readonly" value="${stocktimepage}"
						class="Wdate"
						onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" /> <span
						class="STYLE1" style="color: #FF0000">*</span></td>
				</tr>
				<tr>
					
					<th>
					厂商
					</th>
					<td>
					<input name="assetBo.manufacturer" id="manufacturer" type="text" value="${assetBo.manufacturer}">
					 <span class="STYLE1" style="color: #FF0000">*</span></td>
					
					<!-- <th>
					团体名
					</th>
					<td><input type="text" name="assetBo.communityName"
						value="${assetBo.communityName}" maxlength="20" /></td> -->
					<th>
					所属域
					</th>
					<td><select name="assetBo.locationId">
						<logic:notEmpty name="managerbo" scope="session">
							<logic:iterate id="m" name="managerbo" scope="session">
								<option
									<c:if test="${locid eq m.id }">selected="selected"</c:if>
									value="${m.id }">${m.domainName}</option>
							</logic:iterate>
						</logic:notEmpty>
					</select> <span class="STYLE1" style="color: #FF0000">*</span></td>
				</tr>
				<tr>
					
					<th>
					资产描述
					</th>
					<td colspan="3"><textarea rows="5" cols="70"
						name="assetBo.description" id="description">${assetBo.description}</textarea> <span
						class="STYLE1" style="color: #FF0000">*</span></td>
				</tr>
			</tbody>
			</table>
		</div>
		</div>			
			<div align="center">
				<input type="submit" class="submit"	name="Submit"  value="更新" />
				 <input type="button" name="Submit3" class="submit" value="返回" onclick="javascript:history.back(-1);">
			</div>
	
		
</html:form>
</body>
</html>