<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/tree/dtree.css" />
        <script type="text/javascript" src="${ctx}/js/comm/tree/dtree_linkMan.js"></script>
    </head>
    <body>
        <div class="dtree">
            <p><a href="javascript: d.openAll();">全部展开</a> | <a href="javascript: d.closeAll();">全部收起</a></p>
            <script type="text/javascript">
               d=new dTree('d',"${ctx}");
                d.add(1,null,'piaopiao(小组编号:1)','/manager-web/phoneTree.do?method=showedit&id=1','piaopiao');
                d.add(2,1,'bobo(小组编号:2)','/manager-web/phoneTree.do?method=showedit&id=2','bobo');
                d.add(3,1,'wuwu(小组编号:3)','/manager-web/phoneTree.do?method=showedit&id=3','wuwu');
                d.add(4,2,'tang(小组编号:4)','/manager-web/phoneTree.do?method=showedit&id=4','tang');
                document.write(d);
            </script>
        </div>
    </body>
</html>