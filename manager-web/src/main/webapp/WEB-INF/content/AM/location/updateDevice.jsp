<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style type="text/css">
<!--
.STYLE1 {color: #FF0000}
-->
</style>

<script type="text/javascript">
        function ckeckForm(form){
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
        </script>
<html:form action="location.do?method=updateDevice"
    onsubmit="return ckeckForm(this)">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <input type="hidden" name="pid" value="${pid }">
        <tr>
            <td colspan="2">&nbsp;</td>
        </tr>
        <tr>
            <td colspan="2">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="15"></td>
                    <td width="25"><a href="$"><img
                        src="images/tubiao/045631545.gif" width="16" height="16"
                        border="0" /></a></td>
                    <td width="816" class="css4">更新资产(<font size="2" color="red">说明：带*号表示必填</font>)</td>
                </tr>
            </table>
            </td>
        </tr>
        <tr>
            <td colspan="2">&nbsp;</td>
        </tr>

        <tr>
            <td width="3%" rowspan="3">&nbsp;</td>
            <td>
            <table width="90%" border="0" cellspacing="0" cellpadding="0"
                class="bian">
                <tr>
                    <td height="4" background="images/a-021.gif"></td>
                </tr>
                <tr>
                    <td bgcolor="f9f9fb">
                    <table width="90%" border="0" align="center" cellpadding="0"
                        cellspacing="0" class="css1">
                        <tr>
                            <td colspan="4">&nbsp;</td>
                        </tr>


                        <tr>
                            <td>资产编号：</td>

                            <input type="hidden" value="${assetBo.id}" name="assetBo.id">
                          <td><input type="text" name="assetBo.sn"
                                value="${assetBo.sn}" />
                          <span class="STYLE1">*</span></td>

                            <td><div align="left">资产名称：</div></td>
                          <td><input type="text" name="assetBo.name"
                                value="${assetBo.name}" />
                              <span class="STYLE1">*</span></td>
                        </tr>
                        <tr>
                            <td>资产类型：</td>
                            <td><c:if test="${assetBo.assetType==null}">
                                <input type="text" name="c" value="网络设备" readonly="readonly">
                                <span class="STYLE1">*</span>
                                <input type="hidden" name="assetBo.assetType" value="1">
                            </c:if> <c:if test="${assetBo.assetType!=null}">
                                <c:if test="${assetBo.assetType=='1'}">
                                    <input type="text" name="c" value="网络设备" readonly="readonly">
                                    <span class="STYLE1">*</span>
                                    <input type="hidden" name="assetBo.assetType"
                                        value="${assetBo.assetType}">
                                </c:if>
                                <c:if test="${assetBo.assetType=='2'}">
                                    <input type="text" name="b" value="安全设备" readonly="readonly">
                                    <span class="STYLE1">*</span>
                                    <input type="hidden" name="assetBo.assetType"
                                        value="${assetBo.assetType }">
                                </c:if>
                                <c:if test="${assetBo.assetType=='3'}">
                                    <input type="text" name="a" value="服务器" readonly="readonly">
                                    <span class="STYLE1">*</span>
                                    <input type="hidden" name="assetBo.assetType"
                                        value="${assetBo.assetType }">
                                </c:if>
                                <c:if test="${assetBo.assetType=='4'}">
                                    <input type="text" name="a" value="桌面主机" readonly="readonly">
                                    <span class="STYLE1">*</span>
                                    <input type="hidden" name="assetBo.assetType"
                                        value="${assetBo.assetType }">
                                </c:if>
                            </c:if></td>
                            <td><div align="left">优 先 级：</div></td>
                          <td><input type="text" name="assetBo.priority"
                                value="${assetBo.priority}">
                              <span class="STYLE1">*</span></td>
                        </tr>
                        <tr>
                            <td width="10%">厂 商：</td>
                          <td><input type="text" name="assetBo.manufacturer"
                                value="${assetBo.manufacturer}" />
                              <span class="STYLE1">*</span></td>
                            <td width="13%"><div align="left">设备型号：</div></td>
                          <td width="36%"><input type="text" name="assetBo.model"
                                value="${assetBo.model}">
                              <span class="STYLE1">*</span></td>
                        </tr>
                        <tr>
                            <td>IP 地 址：</td>
                          <td><input type="text" id="ipaddress" name="assetBo.ip"
                                value="${assetBo.ip}" />
                              <span class="STYLE1">*</span></td>
                            <td><div align="left">Mac 地址：</div></td>
                          <td><input type="text" id="macaddress" name="assetBo.mac"
                                value="${assetBo.mac}" />
                              <span class="STYLE1">*</span></td>
                        </tr>
                        <tr>
                            <td>使 用 人：</td>
                          <td><input type="text" name="assetBo.user"
                                value="${assetBo.user}">
                              <span class="STYLE1">*</span></td>
                            <td><div align="left">电 话：</div></td>
                          <td><input type="text" name="assetBo.telephone"
                                value="${assetBo.telephone}" />
                              <span class="STYLE1">*</span></td>
                        </tr>
                        <tr>
                            <td>单 位 ：</td>
                          <td><input type="text" name="assetBo.unit"
                                value="${assetBo.unit}">
                              <span class="STYLE1">*</span></td>
                            <td><div align="left">部 门：</div></td>
                          <td><input type="text" name="assetBo.department"
                                value="${assetBo.department}">
                              <span class="STYLE1">*</span></td>
                        </tr>
                        <tr>
                            <td>资产状态：</td>
                          <td><input type="text" name="assetBo.status"
                                value="${assetBo.status}" />
                              <span class="STYLE1">*</span></td>
                            <td>采购时间</td>
                          <td><input type="text" name="stocktimepage"   readonly="readonly" class="Wdate" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
                              <span class="STYLE1">*</span></td>
                        </tr>
                        <tr>
                            <td>有 效 期：</td>
                          <td><input  name="assetBo.validityPeriod"
                                value="${assetBo.validityPeriod}">
                              <span class="STYLE1">*</span></td>
                            <td>登记时间</td>
                          <td><input type="text" name="registrationtimepage"  " readonly="readonly" class="Wdate" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
                              <span class="STYLE1">*</span></td>
                        </tr>
                        <tr>
                            <td>
                            <div align="center">数据采集代理</div>                            </td>
                          <td><select name="assetBo.agentIp">
                                <logic:notEmpty name="agentList" scope="session">
                                    <logic:iterate id="al" name="agentList" scope="session">
                                        <c:if test="${assetBo.agentIp==al.ipAddr}">
                                            <option value="${al.ipAddr}" selected="selected">${al.name}</option>
                                        </c:if>
                                        <c:if test="${assetBo.agentIp!=al.ipAddr}">
                                            <option value="${al.ipAddr}">${al.name}</option>
                                        </c:if>
                                    </logic:iterate>
                                </logic:notEmpty>
                            </select>
                              <span class="STYLE1">*</span></td>
                            <td>
                              <div align="left">是否监控设备</div></td>
                          <td><select name="assetBo.checkAvailable">
                                <c:if test="${assetBo.checkAvailable==true}">
                                    <option value="1" selected="selected">是</option>
                                </c:if>
                                <c:if test="${assetBo.checkAvailable!=true}">
                                    <option value="1">是</option>
                                </c:if>
                                <c:if test="${assetBo.checkAvailable==false}">
                                    <option value="0" selected="selected">否</option>
                                </c:if>
                                <c:if test="${assetBo.checkAvailable!=false}">
                                    <option value="0">否</option>
                                </c:if>


                            </select>
                              <span class="STYLE1">*</span></td>
                        </tr>

                        <tr>
                            <td>资产描述：</td>
                          <td colspan="3"><textarea rows="5" cols="70"
                                name="assetBo.description">${assetBo.description}</textarea>
                              <span class="STYLE1">*</span></td>
                        </tr>
                        <tr>
                            <td colspan="4">&nbsp;</td>
                        </tr>
                    </table>
                    </td>
                </tr>
                <tr>
                    <td background="images/a-026.gif"></td>
                </tr>
            </table>
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td><label>
            <div align="center"><input type="submit" class="an-1" name="Submit"
                value="更新" /> <input type="button" name="Submit3" class="an-1" value="返回"
                onclick="javascript:history.back(-1);"></div>
            </label></td>
        </tr>
        <tr>
            <td colspan="2">&nbsp;</td>
        </tr>
        <tr>
            <td colspan="2">&nbsp;</td>
        </tr>
        <tr>
            <td colspan="2">&nbsp;</td>
        </tr>

        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td colspan="2">&nbsp;</td>
        </tr>
    </table>
</html:form>
<html:javascript formName="locationForm" bundle="assetResource" />
