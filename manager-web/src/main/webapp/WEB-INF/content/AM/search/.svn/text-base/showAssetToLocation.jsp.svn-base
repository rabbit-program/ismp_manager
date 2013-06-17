<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript">
                  function fwd(typid){                      
                      var curpage=document.getElementById("mid").value;
                      location.href="hardware.do?method=getAssetToHardware&hid="+typid+"&curpage="+curpage;
                  }
                  function fwdAdd(){                     
                      location.href="fwdPage.do?addHardware=1"
                  }
                  function del(id,tid){
                      if(confirm("确认删除吗？")){                        
                        location.href="hardware.do?method=deleteHardware&hid="+id+"&tid="+tid;
                      }else{                         
                         return;
                      }
                  }
           </script>


</head>
<body>

<div id="data">
      <h2 class="martop8">物理位置信息</h2>
		<table >
          <tr> 
            <th width="50%">委办局名称:</th>
            <td >${weibanju} </td>
          </tr>
          <tr>
            <th>楼号:</th>
            <td>${foom }</td>
          </tr>
          <tr>
            <th>房号:</th>
            <td>${room }</td>
          </tr>
        </table>
</div>  
 
</body>
</html>