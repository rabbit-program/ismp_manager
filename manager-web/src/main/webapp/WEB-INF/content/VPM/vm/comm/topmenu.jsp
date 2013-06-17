<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<link href="css/assessmentCss.css" rel="stylesheet" type="text/css" />
<link href="css/css.css" rel="stylesheet" type="text/css" />
<div id="contant">
    <div id="main">
        <div id="nav">
          <ul>
              <li class="map02"><a href="#"></a></li>
              <li><a class="list" href="${ctx}/ismp/domain/local/vpm/vm/virusMappedAction.do" target="_self" title="客户端管理">客户端管理</a></li>
              <li class="map03"><a href="#"></a></li>
              <!-- <li><a class="list" href="${ctx}/ismp/domain/local/vpm/vm/virusAction.do?method=getSoftInfo" target="_self" title="病毒管理">病毒管理</a></li> -->
              <li><a class="list" href="${ctx}/ismp/domain/local/vpm/vm/virusInfo.do" target="_self" title="病毒管理">病毒管理</a></li>
<!-- 
              <li class="map01"><a href="#"></a></li>
              <li><a class="list" href="#" target="_self" title="病毒统计">病毒统计</a></li>
-->
          </ul>
          <div class="help">
           <ul>
               <li class="maphelp"></li>
               <li><a class="list" href="Help/virusHelp.html" target="_black" title="Help">帮助</a></li>
           </ul>
          </div>
        </div>
    </div>
</div> 