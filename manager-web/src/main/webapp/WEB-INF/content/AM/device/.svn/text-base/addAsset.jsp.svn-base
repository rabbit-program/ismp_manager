<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
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
           function breakPage(){
               window.location.history.go(-1);
           } 

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
			
			var regid = document.getElementById("regid").value;
			if(regid==''){
				alert("登记时间不能为空！");
				return false;
			}
			var stockid = document.getElementById("stockid").value;
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
                     alert('IP地址不正确（例：192.168.9.253）');
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
              }else
              {     
                 
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
 
		 function showResponse(response) {
		     var str = response.responseText;
		    
		     var vals= str.split("@");
		     document.getElementById("model").options.length=0;
		     document.getElementById("model").options.length=vals.length-1;
		     
		     for (var i=1;i<vals.length;i++){
		        
		         document.getElementById("model").options[i-1].value=vals[i];  
		         document.getElementById("model").options[i-1].text=vals[i];  
		     }
		
		 }             
</script>  
</head>
<body>

<html:form action="/ismp/domain/local/am/asset.do?method=addAsset"
    onsubmit="return ckeckForm(this)"> 
    <input name="locid" type="hidden" value="${locid }"/> 
  <div id="contant">
<div id="main">          
  <div  id="data" class="pad1 ">
  <table>
    <tbody>
      <tr>
        <th>资产编号</th>
        <td><input name="assetBo.sn" id="sn" type="text"  maxlength="20">
        <span class="font_tip" style="color: #FF0000">*</span></td>
        <th>资产名称</th>
        <td><input name="assetBo.name" id="name" type="text" maxlength="20">
        <span class="font_tip" style="color: #FF0000">*</span></td>
      </tr>
      <tr>
        <th>资产类型</th>
        <td><span style="float:left;">
          <select id="tmtype" name="assetBo.assetType">
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
            </select>
        </span></td>
        <th>优先级</th>
        <td><span style="float:left;">
          <select name="assetBo.priority">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                            </select> 
        </span>（最高等级：5 最低等级：1）<span class="font_tip" style="color: #FF0000">*</span></td>
      </tr>
      <tr>
        <th>设备类型</th>
        <td><span style="float:left;">
          <select id="tmType"  onchange="selectModelsByEn(this.value);" name="assetBo.deviceType">
                                <logic:notEmpty name="tmList">
                                    <logic:iterate id="al" name="tmList">
                                        <option value="${al.markName}">${al.markName}</option>
                                    </logic:iterate>
                                </logic:notEmpty>
                                <option value="unknown">未知</option>
           </select>
        </span></td>
        <th>设备型号</th>
        <td><span style="float:left;">
          <select  id="model"  name="assetBo.model">
                       <logic:notEmpty name="models">
                         <logic:iterate id="al" name="models">
                             <option value="${al.name}">${al.name}</option>
                         </logic:iterate>
                       </logic:notEmpty>
          </select>
        </span></td>
      </tr>
      <tr>
        <th>IP地址</th>
        <td><input name="assetBo.ip" id="ipaddress" type="text"  maxlength="20">
        <span class="font_tip" style="color: #FF0000">*</span></td>
        <th>Mac 地址</th>
        <td><input name="assetBo.mac" type="text" id="macaddress" maxlength="20">
        <span class="font_tip" style="color: #FF0000">*</span>(格式：00:24:81:10:67:D6)</td>
      </tr>
      <tr>
        <th>使用人</th>
        <td><input name="assetBo.user" id="user" type="text" maxlength="20">
        <span class="font_tip" style="color: #FF0000">*</span></td>
        <th>电话</th>
        <td><input name="assetBo.telephone" id="telephone" type="text"  maxlength="20">
        <span class="font_tip" style="color: #FF0000">*</span></td>
      </tr>
      <tr>
        <th>单位</th>
        <td><input name="assetBo.unit" id="unit" type="text" maxlength="20">
        <span class="font_tip" style="color: #FF0000">*</span></td>
        <th>部门:</th>
        <td><input name="assetBo.department" id="department" type="text" maxlength="20">
        <span class="font_tip" style="color: #FF0000">*</span></td>
      </tr>
      <tr>
        <th>资产状态</th>
        <td><span style="float:left;">
          <select name="assetBo.status">
                  <option value="1">在用</option>
                  <option value="2">废弃</option>
          </select>
        </span></td>
        <th>登记时间</th>
        <td><input type="text"  id="regid" 
                                name="registrationtimepage" class="Wdate"
                                onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" />
        <span class="font_tip" style="color: #FF0000">*</span></td>
      </tr>
      <tr>
        <th>有效期</th>
        <td><input name="assetBo.validityPeriod" id="validityPeriod" type="text"  maxlength="6" size="8">月
        <span class="font_tip" style="color: #FF0000">*</span></td>
        <th>采购时间</th>
        <td><input type="text"    id="stockid"
                                name="stocktimepage" class="Wdate"
                                onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" />
        <span class="font_tip" style="color: #FF0000">*</span></td>
      </tr>
      <tr>
        <th>厂商</th>
        <td><span style="float:left;">
        	<input name="assetBo.manufacturer" id="manufacturer" type="text">
          <!-- <select name="assetBo.manufacturer">
                     <logic:notEmpty name="deviceTypeList" scope="request">
                         <logic:iterate id="dy" name="deviceTypeList" scope="request">
                             <option   value="${dy.englishTag }">${dy.name }</option>
                         </logic:iterate>
                     </logic:notEmpty>
          </select> -->
        </span></td>
        <th>所属域</th>
        <td>
        <!-- <input type="text" name="assetBo.communityName" maxlength="20"/>
        <span class="font_tip" style="color: #FF0000">*</span> -->
        <span style="float:left;">
        <select name="assetBo.locationId">
						<logic:notEmpty name="managerbo" scope="session">
							<logic:iterate id="m" name="managerbo" scope="session">
								<option	<c:if test="${locid eq m.id }">selected="selected"</c:if> value="${m.id }">${m.domainName}</option>
							</logic:iterate>
						</logic:notEmpty>
					</select>
        </span>
		</td>
      </tr>
      <tr>
        <th>资产描述</th>
        <td colspan="3"><textarea rows="4" cols="70" name="assetBo.description" id="description"></textarea><span class="font_tip" style="color: #FF0000">*</span></td>
      </tr>
    </tbody>
  </table>
  </div></div>
<div align="center" class="martop8">
                    <input class="submit" type="submit" value="添加"  name="Submit">
                    <input class="submit" type="submit" value="重置"  name="Submit">                      
                    <input class="submit" type="button" onclick="javascript:history.back(-1);" value="返回" name="Submit3">
                  </div>
</div>          
</html:form>
