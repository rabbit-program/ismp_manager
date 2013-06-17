<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style type="text/css">
<!--
body {
    margin-left: 0px;
    margin-top: 0px;
    margin-right: 0px;
    margin-bottom: 0px;
}

-->
</style>
    <link href="css/assessmentCss.css" rel="stylesheet" type="text/css" />
        <link href="css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
<!--
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

 
//-->
</script>
</head>
<body>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td width="4" valign="top"></td>
        <td valign="top">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            
            <tr>
                <td height="36" background="images/a-019.jpg">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="15"></td>
                        <td width="35"><img src="images/tubiao/045631187.gif"
                            width="16" height="16" border="0" /></td>
                        <td class="css2">软件详细页</td>
                    </tr>
                </table>                </td>
            </tr>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="4" valign="top"></td>
                <td valign="top">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td colspan="2">&nbsp;</td>
                    </tr>


                    <tr>
                        <td width="3%" rowspan="3">&nbsp;</td>
                        <td> 
                        <table width="90%" border="0" cellspacing="0" cellpadding="0" class="bian">
                            <tr>
                                <td height="4" background="images/a-021.gif"></td>
                            </tr>
                            <tr>
                                <td bgcolor="f9f9fb">
                                <form action="search.do?method=updateSoftware" method="post">
                                <input type="hidden" name="id" value="${soft.id }" />
                                <table width="90%" border="0" align="center" cellpadding="0"
                                    cellspacing="0" class="css1">
                                    <tr>
                                        <td colspan="4">&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td>软件名称：</td>
                                        <td><input type="text" name="name"
                                            value="${soft.name }" /></td>
                                        <td>软件类型：</td>
                                        <td><input type="text" name="softwareType"
                                            value="${soft.softwareType}" /></td>
                                    </tr>

                                    <tr>
                                        <td>版本：</td>
                                        <td><input type="text" name="version" value="${soft.version }" /></td>
                                        <td>发行商：</td>
                                        <td><input type="text" name="manufacturer" value="${soft.manufacturer }" /></td>  
                                    </tr>
                                    <tr>
                                        <td>有效期：</td>
                                        <td><input type="text" name="validityPeriod"
                                            value="${soft.validityPeriod }" /></td>
                                        <td>当前状态：</td>
                                        <td><input type="text" name="status"
                                            value="${soft.status }" /></td>
                                    </tr>
                                    <tr>
                                        <td>使 用 人：</td>
                                        <td><input type="text" name="user"
                                            value="${soft.user }" /></td>
                                        <td>联系方式：</td>
                                        <td><input type="text" name="telephone"
                                            value="${soft.telephone }" /></td>
                                    </tr>
                                    <tr>
                                        <td>采购时间：</td>
                                        <td><input type="text" name="stockTime" value="<bean:write property='stockTime' name='soft' format='yyyy-MM-dd HH:mm:ss'/>" />   </td>
                                        <td>单位：</td>
                                        <td><input type="text" name="unit"
                                            value="${soft.unit }" /></td>
                                    </tr>
                                    <tr>
                                        <td colspan="4">
                                        <div align="center"><input name="button3" type="submit"
                                            class="an-1" id="button3" value="修 改" /></div>                                      </td>
                                    </tr>
                                </table>
                                </form>                             </td>
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
                        <td></td>
                    </tr>
                    <tr>
                        <td colspan="2">&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                        <table width="100%" border="0" cellpadding="0" cellspacing="0"
                            class="test">
                            <tr>
                                <td width="5"></td>
                                <td width="5"></td>
                                <td width="5"></td>
                                <td width="5"></td>

                                <td width="85"><a href="111111111"><img
                                    src="images/tubiao/05375362.gif" width="16" height="16"
                                    border="0" /> 软件信息</a></td>
                                <td width="85"><a href="#"><img
                                    src="images/tubiao/045631187.gif" width="16" height="16"
                                    border="0" /> 硬件信息</a></td>
                                <td width="100"><a href="$"><img
                                    src="images/tubiao/05375392.gif" width="16" height="16"
                                    border="0" /> 地理位置信息</a></td>
                                <td width="100"><a href="$"><img
                                    src="images/tubiao/04563159.gif" width="16" height="16"
                                    border="0" /> 资产变动信息</a></td>
                                <td width="125"><a href="$"><img
                                    src="images/tubiao/05375364.gif" width="16" height="16"
                                    border="0" /> 可用性统计查看</a></td>
                                <td width="356" align="right">&nbsp;</td>
                            </tr>
                        </table>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">&nbsp;</td>
                    </tr>

                    <tr>
                        <td rowspan="3">&nbsp;</td>
                        <td>
                        <table width="90%" border="0" cellpadding="0" cellspacing="0"
                            class="bian">
                            <tr>
                                <td>
                                <table width="100%" border="0" cellpadding="0" cellspacing="1"
                                    class="biaoge">
                                    <tr>
                                        <td width="13%" background="images/a-028.gif" class="css2">名称</td>
                                        <td width="26%" background="images/a-028.gif" class="css2">描述</td>
                                        <td width="14%" background="images/a-028.gif" class="css2">版本</td>
                                        <td width="23%" background="images/a-028.gif" class="css2">厂商</td>
                                        <td width="24%" background="images/a-028.gif" class="css2">创建时间</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                    </tr>

                                </table>
                                </td>
                            </tr>
                        </table>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td><input name="button" type="submit" class="an-1"
                            id="button" value="关联软件" /></td>
                    </tr>


                    <tr>
                        <td colspan="2">&nbsp;</td>
                    </tr>
                </table>
                </td>
            </tr>
        </table>
        </td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td height="21">&nbsp;</td>
    </tr>
</table>
</body>
</html>
