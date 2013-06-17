<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<div id="banner" class="grayline overf bannerH" >
<ul>
    <li class="act" id="m"><a href="fwdPage.do?child=1&assetwelcome=1" target="mainchiltFrame" onclick="changeImg('sb')"><span style="background:url(../../../img/comm/other/03.gif) no-repeat; padding-left:22px;">设备</span></a></li>
    <li class="nor" id="m"><a href="fwdPage.do?assetSoft=1&softwelcome=1" target="mainchiltFrame" onclick="changeImg('soft')"><span style="background:url(../../../img/SYSM/page-edit-icon.png) no-repeat; padding-left:22px;">软件</span></a></li>
    <li class="nor" id="m"><a href="fwdPage.do?hardware=1&hardwarewelcome=1" target="mainchiltFrame" onclick="changeImg('hardware')"><span style="background:url(../../../img/SYSM/HD-icon.png) no-repeat; padding-left:22px;">硬件</span></a></li>
    <li class="nor" id="m"><a href="fwdPage.do?locationFrame=1&locationwelcome=1" onclick="changeImg('location')" target="mainchiltFrame"><span style="background:url(../../../img/SYSM/computers-icon.png) no-repeat; padding-left:22px;">物理位置</span></a></li>
    <li class="nor" id="m"><a href="device_.do" target="mainchiltFrame"	onclick="changeImg('assetsearch')"><span style="background:url(../../../img/SYSM/computer-icon.png) no-repeat; padding-left:22px;">资产查询</span></a></li>
    <li class="nor" id="m"><a href="assetTopoAssociate.do?method=findNotInAssetDevices"	target="mainchiltFrame" onclick="changeImg('assettopo')"><span style="background:url(../../../img/SYSM/database-add-icon.png) no-repeat; padding-left:22px;">关联拓扑设备</span></a></li>
    <li class="nor" id="m"><a href="deviceAnalysis.do" target="mainchiltFrame" onclick="changeImg('deviceAnalysis')"><span style="background:url(../../../img/SYSM/calendar-date-icon.png) no-repeat; padding-left:22px;">设备历年统计</span></a></li>
</ul>
</div>
<div id="subnav">
    <ul> 
        <li><a href="#"></a></li>
        <li style="line-height:180%;"><a  href="DeviceList.do" >批量导出</a></li>
    </ul>
</div>