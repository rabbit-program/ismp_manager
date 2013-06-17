<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<table>
    <tr>
        <th colspan="3">系统配置</th>
    </tr>
    <tr>
        <td height="35" width="33.3%" valign="top">
            <table class="martop8" style="margin-bottom:8px;">
                <tr>
                    <th><span style="float:left;">数据上报</span><span style="float:right;"><a href="${ctx}/ismp/domain/local/sysm/config/ds/dataSynConfigFind.do" class="R6 martop8" target="_black">配置</a></span></th>
                </tr>
                <tr>
                    <td class="grayword">设置数据上报至中心端接口及其相关参数.</td>
                </tr>
            </table>
        </td>
        <td width="33.3%" valign="top">
            <table class="martop8" style="margin-bottom:8px;">
                <tr>
                    <th><span style="float:left;">病毒补丁</span><span style="float:right;"><a href="${ctx}/ismp/domain/local/sysm/config/vpm/vpmDbConfigFindAction.do" class="R6 martop8" target="_black">配置</a></span></th>
                </tr>
                <tr>
                    <td class="grayword">设置病毒补丁数据库接口及其相关参数.</td>
                </tr>
            </table>
        </td>
        <td width="33.3%" valign="top">
            <table class="martop8" style="margin-bottom:8px;">
                <tr>
                    <th><span style="float:left;">信息发送</span><span style="float:right;"><a href="${ctx}/ismp/domain/local/sysm/config/sms/smsConfigFind.do" class="R6 martop8" target="_black">配置</a></span></th>
                </tr>
                <tr>
                    <td class="grayword">设置信息发送接口及其相关参数.  </td>
                </tr>
            </table>
        </td>
    </tr>
</table>