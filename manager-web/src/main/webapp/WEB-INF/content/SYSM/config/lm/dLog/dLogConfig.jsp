<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<table>
    <tr>
        <th colspan="3">日志审计</th>
    </tr>
    <tr>
        <td height="35" width="33.3%" valign="top">
            <table class="martop8" style="margin-bottom:8px;">
                <tr>
                    <th><span style="float:left;">Syslog</span><span style="float:right;"><a href="${ctx}/ismp/domain/local/sysm/config/lm/dlog/sysLogConfigAction.do?method=getSysLogSource" class="R6 martop8">配置</a></span></th>
                </tr>
                <tr>
                    <td class="grayword">Syslog源的配置. </td>
                </tr>
            </table>
        </td>
        <td width="33.3%" valign="top">
            <table class="martop8" style="margin-bottom:8px;">
                <tr>
                    <th><span style="float:left;">Trap</span><span style="float:right;"><a href="${ctx}/ismp/domain/local/sysm/config/lm/dlog/snmpTrapConfigAction.do?method=getSnmpTrapSource" class="R6 martop8">配置</a></span></th>
                </tr>
                <tr>
                    <td class="grayword">Trap配置. </td>
                </tr>
            </table>
        </td>
        <td width="33.3%" valign="top">
            <table class="martop8" style="margin-bottom:8px;">
	            <tr>
	                <th><span style="float:left;">PC</span><span style="float:right;"><a href="${ctx}/ismp/domain/local/sysm/config/lm/dlog/pcConfigAction.do?method=getPcSource" class="R6 martop8">配置</a></span></th>
	            </tr>
	            <tr>
	                <td class="grayword">PC配置. </td>
	            </tr>
            </table>
        </td>
    </tr>
</table>