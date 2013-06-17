<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<%@ include file="/common/taglibs.jsp"%>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/AIM/alertRule.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/floatdiv.js"></script>
<script type='text/javascript' src='${ctx }/dwr/engine.js'></script>
<script type='text/javascript' src='${ctx }/dwr/util.js'></script>
<script type='text/javascript' src='${ctx }/dwr/interface/checkIfNew.js'></script>
<script type="text/javascript" language="javascript" src="${ctx }/js/AIM/alertRule.js"></script>
</head>
<body>
<br>
<div id="banner" class="grayline overf bannerH" >
  	<jsp:include page="/WEB-INF/content/AIM/top.jsp"></jsp:include>
  </div>


<div  id="data" class="pad1 ">
<html:form action="/ismp/domain/local/aim/alertRule.do">
    <p><input type="hidden" name="method" value="updateAlertRule">
    <input type="hidden" name="alertRulebo.id" value="${alertRulebo.id }" />
    <input type="hidden" name="alertRulebo.deprecated" value="1">
    <input type="hidden" name="curpage" value="${curpage }">
    </p>
<h2>告警触发更新(带<span class="alert">*</span>的为必填)</h2>
  <table width="600">
    <tr>
      <th>事件优先级</th>
      <td>
        <select disabled="disabled">
                    <option>&gt;=</option>
                </select> <span class="STYLE1"> <select name="alertRulebo.priority"
                    id="alertRulebo.priority">
                    <c:forEach begin="1" var="i" end="5">
                        <c:if test="${alertRulebo.priority==i}">
                            <option value="${i }" selected="selected">${i }</option>
                        </c:if>
                        <c:if test="${alertRulebo.priority!=i}">
                            <option value="${i }">${i }</option>
                        </c:if>
                    </c:forEach>
                </select> </span>
      <span class="alert">*</span></td>
      <th>事件类型</th>
      <td><select onChange="checkSubType()"
                    name="alertRulebo.type" id="alertRulebo.type">
                    <logic:notEmpty name="altypeList">
                        <option value="">-请选择-</option>
                        <logic:iterate id="al" name="altypeList">
                            <c:if test="${al.typeMarker==1}">
                                <c:if test="${alertRulebo.type==al.typeName}">
                                    <option value="${al.typeName }" selected="selected">${al.typeName
                                    }</option>
                                </c:if>
                                <c:if test="${alertRulebo.type!=al.typeName}">
                                    <option value="${al.typeName }">${al.typeName }</option>
                                </c:if>
                            </c:if>
                        </logic:iterate>
                    </logic:notEmpty>
                </select>
      <span class="alert">*</span></td>
      <td>子类型</td>
      <td><select name="alertRulebo.subType" id="alertRulebo.subType">
                    <option value="">-请选择-</option>
                    <logic:notEmpty name="subTypeList">
                        <logic:iterate id="al" name="subTypeList">
                            <c:if test="${al.typeMarker==2}">
                                <c:if test="${alertRulebo.subType==al.typeName}">
                                    <option value="${al.typeName }" selected="selected">
                                    ${al.typeName}</option>
                                </c:if>
                                <c:if test="${alertRulebo.subType!=al.typeName}">
                                    <option value="${al.typeName }">${al.typeName }</option>
                                </c:if>
                            </c:if>
                        </logic:iterate>
                    </logic:notEmpty>
                </select> <span class="alert">*</span></td>
      <td><c:if test="${alertRulebo.enabled==1}">
                    <input name="alertRulebo.enabled" type="radio" value="1" checked>
          启用规则 </c:if> <c:if test="${alertRulebo.enabled!=1}">
                    <input name="alertRulebo.enabled" type="radio" value="1">
              启用规则 </c:if>
              
	<c:if test="${alertRulebo.enabled==0}">
                    <input name="alertRulebo.enabled" type="radio" value="0" checked>
          禁用规则 </c:if> <c:if test="${alertRulebo.enabled!=0}">
                    <input name="alertRulebo.enabled" type="radio" value="0">
              禁用规则 </c:if></td>
    </tr>
  </table>
  <h2 class="martop8" >告警发送设置(<span class="alert" style="font-size:12px;">联系方式可填写多个,多个之间用";"号隔开,最多10个</span>)</h2>
  <table width="600">
    <tr>
      <th>桌面消息告警</th>
      <td><c:if test="${alertRulebo.sendMsg==1}">
                    <input name="alertRulebo.sendMsg" type="radio"
                        id="alertRulebo.sendMsg" value="1"
                        onclick="checkDisabled('alertRulebo.msgTarget')" checked="checked">
              启用 </c:if> <c:if test="${alertRulebo.sendMsg!=1}">
                    <input name="alertRulebo.sendMsg" type="radio"
                        onclick="checkDisabled('alertRulebo.msgTarget')" id="alertRulebo.sendMsg" value="1">
                  启用 </c:if>
                    <c:if test="${alertRulebo.sendMsg==0}">
                    <input name="alertRulebo.sendMsg" type="radio"  value="0"
                        onclick="checkDisabledFalse('alertRulebo.msgTarget')"
                        checked="checked" >
              禁用 </c:if> <c:if test="${alertRulebo.sendMsg!=0}">
                    <input name="alertRulebo.sendMsg"
                        onclick="checkDisabledFalse('alertRulebo.msgTarget')" type="radio"
                        value="0">
                  禁用</c:if></td>
      <th>桌面IP地址</th>
      <td><span style="float:left;">
      <c:if  test="${alertRulebo.msgTarget!=null&&alertRulebo.msgTarget!=''}">
                    <input name="alertRulebo.msgTarget" type="text" class="input"
                        id="alertRulebo.msgTarget" value="${alertRulebo.msgTarget }"
                        size="40" maxlength="100">
                </c:if> <c:if
                    test="${alertRulebo.msgTarget==null||alertRulebo.msgTarget==''}">
                    <input name="alertRulebo.msgTarget" type="text" disabled="true"
                        id="alertRulebo.msgTarget" style="background: #B4B4B4"
                        value="${alertRulebo.msgTarget}" size="40" maxlength="100">
                </c:if>
      </span></td>
    </tr>
    <tr>
      <th>Email消息告警</th>
      <td><c:if test="${alertRulebo.sendEmail==1}">
                    <input name="alertRulebo.sendEmail"
                        onclick="checkDisabled('alertRulebo.emailTarget')" type="radio"
                        value="1" checked="checked">
              启用 </c:if> <c:if test="${alertRulebo.sendEmail!=1}">
                    <input name="alertRulebo.sendEmail"
                        onclick="checkDisabled('alertRulebo.emailTarget')" type="radio"
                        value="1" id="alertRulebo.sendEmail">
                  启用 </c:if>
                  <c:if test="${alertRulebo.sendEmail==0}">
                    <input name="alertRulebo.sendEmail"
                        onclick="checkDisabledFalse('alertRulebo.emailTarget')"
                        type="radio" value="0" checked="checked">
              禁用 </c:if> <c:if test="${alertRulebo.sendEmail!=0}">
                    <input name="alertRulebo.sendEmail"
                        onclick="checkDisabledFalse('alertRulebo.emailTarget')"
                        type="radio" value="0">
                  禁用</c:if></td>
      <th>Email地址</th>
      <td><span style="float:left;">
        <c:if test="${alertRulebo.emailTarget!=null&&alertRulebo.emailTarget!=''}">
                    <input name="alertRulebo.emailTarget" type="text" class="input" class="input"
                        id="alertRulebo.emailTarget" value="${alertRulebo.emailTarget }"
                        size="40" maxlength="100">
                </c:if> <c:if
                    test="${alertRulebo.emailTarget==null||alertRulebo.emailTarget==''}">
                    <input name="alertRulebo.emailTarget" type="text" disabled="true"
                        id="alertRulebo.emailTarget" style="background: #B4B4B4"
                        value="${alertRulebo.emailTarget }" size="40" maxlength="100">
                </c:if>
      </span></td>
    </tr>
    <tr>
      <th>短消息告警</th>
      <td><c:if test="${alertRulebo.sendSms==1}">
                    <input name="alertRulebo.sendSms"
                        onclick="checkDisabled('alertRulebo.smsTarget')" type="radio"
                        value="1" checked="checked">
                  启用 </c:if> <c:if test="${alertRulebo.sendSms!=1}">
                    <input name="alertRulebo.sendSms"
                        onclick="checkDisabled('alertRulebo.smsTarget')" type="radio"
                        value="1" id="alertRulebo.sendSms">
                  启用 </c:if>
       <c:if test="${alertRulebo.sendSms==0}">
                    <input name="alertRulebo.sendSms"
                        onclick="checkDisabledFalse('alertRulebo.smsTarget')" type="radio"
                        value="0" checked="checked">
              禁用 </c:if> <c:if test="${alertRulebo.sendSms!=0}">
                    <input name="alertRulebo.sendSms"
                        onclick="checkDisabledFalse('alertRulebo.smsTarget')" type="radio"
                        value="0">
                  禁用</c:if></td>
      <th>短消息号码</th>
      <td><span style="float:left;">
        <c:if  test="${alertRulebo.smsTarget!=null&&alertRulebo.smsTarget!=''}">
                    <input name="alertRulebo.smsTarget" type="text" class="input"
                        id="alertRulebo.smsTarget" value="${alertRulebo.smsTarget }"
                        size="40" maxlength="100">
                </c:if> <c:if
                    test="${alertRulebo.smsTarget==null||alertRulebo.smsTarget==''}">
                    <input name="alertRulebo.smsTarget" type="text" disabled="true"
                        id="alertRulebo.smsTarget" style="background: #B4B4B4" class="input"
                        value="${alertRulebo.smsTarget }" size="40" maxlength="100">
                </c:if>
      </span></td>
    </tr>
  </table>
  <div class="paddiv"></div> 
  <input class="submit" type="button" name="测试" value="添加" onclick="checkRuleForm()"  />
   <input class="submit" type="button" name="测试2" value="返回" onClick="javascript:history.back(-1);"/>
  <a  href="javascript:openOrcloseSearchUser(true)" >使用系统用户的联系方式</a>?
<div class="paddiv"></div>
</html:form>
</div>


















<!-- 下面Div弹出  -->

<div
    style="border: 1px solid #000000; background: #F3F3F3; width: 800px; padding: 0px 0; display: none;"
    id="usSearch" class="dragAble">
 <div class="border divpad">

  <div align="center">
<table width="800" border="0" align="center" cellpadding="0"
    cellspacing="0" class="css1">
    <tr class="biaoge">
      <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td> <a
            href="javascript:openOrcloseSearchUser(false)"
            style="font: colo :   #FFFFFF" class="n"><img src="img/close.gif"
            border="0" alt="关闭" width="16" height="16"></a> &nbsp;<img
            src="img/move.gif" width="16" alt="按住移动" onmousedown="initDrag()"
            style="cursor: move" border="0" height="16"></td>
  </tr>
    <tr class="biaoge">
      <td width="14%">
        <div align="center">用&nbsp;户&nbsp;名:</div>      </td>
            <td width="25%"><input name="uservo.username" type="text" class="input"
            id="uservo.username" maxlength="30"></td>
            <td width="14%">
              <div align="center">真实姓名:</div>            </td>
            <td width="21%"><input name="uservo.soothname" type="text" class="input"
            id="uservo.soothname" maxlength="30"></td>
            <td width="26%">
              <div align="center"><input type="button" name="Submit"
            onClick="queryUser()" class="subbtn" value="查  询"></div>            </td>
            <td width="26%">
              <div align="center"><input type="button" name="Submit2"
            onClick="spiltContacts()" class="subbtn" value="提取联系方式"></div>            </td>
  </tr>
    <tr>
      <td colspan="6" align="right">&nbsp;</td>
  </tr>
</table>
</div>
<div id="mainblock">
  <h1>用户列表</h1>
  <table width="800" border="0" align="center" cellpadding="0"
    cellspacing="0">
    <tr>
      <td>
        <table>
          <tr>
            <td width="100%">
              <table id="alertTbid" >
              </table>
            </td>
                    <table id="pageTb">
                    </table>
          </tr>
        </table>
      </td>
    </tr>
  </table>
</div>
  </div>
</div>

</body>
</html>
