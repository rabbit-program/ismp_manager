<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript" src="${ctx}/js/comm/date/WdatePicker.js"></script>

<script type="text/javaScript">
function toPage(curpage) {
    document.getElementById("currPage").value = curpage;
    document.forms["virusMapped"].submit();
}

function del(){
    var msg="确认删除记录吗？";
if (confirm(msg) == true) {
    return true; 
} else {
    return false; 
    }
}   
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>病毒管理_客户端管理</title>
</head>

<body>
<%@ include file="/WEB-INF/content/VPM/vm/comm/topmenu.jsp"%>
    <form id="virusMapped" name="virusMapped" action="${ctx}/ismp/domain/local/vpm/vm/virusMappedAction.do" method="post">
    <div id="mainblock">
            <h1>条件查询</h1>
            <div class="border divpad">
                <table class="css1">
                      <tr>    
                        <td>客户端名称</td>
                        <td><input type="text" name="name" value="${condition.name }"/></td>
                        <td><p>客户端编号</p></td>
                        <td><input type="text" name="clientID"  value="${condition.clientID }"/></td>
                        <td>客户端IP</td>
                        <td><input type="text" name="clientIP" value="${condition.clientIP }" /></td>
                      </tr>
                   
                    <tr>
                        <td>录入时间(开始)</td>
                        <td>
                            <input type="text" id="bgTime" name="bgTime" value="${condition.bgTime }" class="Wdate" onClick="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" readonly="readonly"/>
                        </td>
                        
                         <td>录入时间(结束)</td>
                        <td><input type="text" id="endTime" name="endTime" value="${condition.endTime }"  class="Wdate" onClick="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" readonly="readonly"/></td> 
                        
                   </tr>
                </table>
            </div>
        </div>
        <p>
         <input name="button" type="submit" class="subbtn" id="button" value="查 询" />
         <input name="button3" type="reset" class="subbtn" id="button3" value="重 置"/>
        </p>
    <div id="mainblock">
     
      <div class="border " style="padding:10px 0px; background:#F0EEEE;">  
      <table>
       <tr>
        <th><div align="center">客户端IP</div></th>
        <th><div align="center">客户端名称</div></th>
        <th><div align="center">客户端编号</div></th>
        <th><div align="center">资产编号</div></th>
        <th><div align="center">部门名称</div></th>
        <th><div align="center">录入时间</div></th>
        <th><div align="center">操  作</div></th>
       </tr>
       <c:forEach var="virusClients" items="${virusClientsList}" varStatus="status">
        <tr <c:if test="${status.count%2==0}">bgcolor="#E8E8E8"</c:if>>
         <td>
          <div  align="center">${virusClients.clientIP }</div>
         </td>
         <td>
          <div style="float:left;text-align:center;margin-left:10px;">
              ${virusClients.name }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          </div>
          <a href="${ctx}/ismp/domain/local/vpm/vm/virusMappingModify.do?mok=0&opname=mvcn&vci=${virusClients.id }" style="float:right;margin-right:10px;" target="_blank">修 改</a>
         </td>
         <td>
          <div  align="center">${virusClients.clientID }</div>
         </td>
         <td>
          <c:choose>
           <c:when test="${empty virusClients.assetDevice }">
               <div style="float:left;text-align:center;margin-left:10px;">
                                            未关联
               </div>
           </c:when>
           <c:otherwise>
               <div style="float:left;text-align:center;margin-left:10px;">
                   ${virusClients.assetDevice.singleCode }
                   (${virusClients.assetDevice.ip })
               </div>
           </c:otherwise>
          </c:choose>
          <a href="${ctx}/ismp/domain/local/vpm/vm/virusMappingModify.do?mok=0&opname=mad&vci=${virusClients.id }" style="float:right;margin-right:10px;" target="_blank">修 改</a>
         </td>
         <td>
          <c:choose>
           <c:when test="${empty virusClients.department }">
              <div style="float:left;text-align:center;margin-left:10px;">
                                         未关联
              </div>
           </c:when>
           <c:otherwise>
              <div style="float:left;text-align:center;margin-left:10px;">
                 ${virusClients.department.managerName }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              </div>
           </c:otherwise>
          </c:choose>
          <a href="${ctx}/ismp/domain/local/vpm/vm/virusMappingModify.do?mok=0&opname=mm&vci=${virusClients.id }" style="float:right;margin-right:10px;" target="_blank">修 改</a>
         </td>
         <td>
          <div align="center">${virusClients.recordTime }</div>
         </td>
         <td>
          <div align="center"><a href="${ctx}/ismp/domain/local/vpm/vm/virusMappingModify.do?mok=0&mdel=1&vci=${virusClients.id }" onclick="javascript:return del()">删  除</a></div>
         </td>
        </tr>
      </c:forEach>
      </table> 
         <div id="page">
        <ul>
          <li><a class="first" href="javascript:toPage(1);"></a></li>
          <c:if test="${currPage>1 }">
              <li>
                    <a class="pre" href="javascript:toPage(${currPage-1 });"></a>
              </li>
          </c:if>
          <c:if test="${currPage<totalPage }">
              <li>
                    <a class="next" href="javascript:toPage(${currPage+1 });"></a> 
              </li>
          </c:if>
          <li><a class="last" href="javascript:toPage(${totalPage });"></a></li>
          <li>共 ${totalPage }页 跳至
             <input id="currPage" name="currPage" type="text" size="2" class="input" value="${currPage }"/>
          </li>
            <li><a class="btn" href="javascript:toPage(document.getElementById('currPage').value);">GO</a></li>
        </ul>
       </div>
 </div>
    </div>
    </form>
</body>
</html>