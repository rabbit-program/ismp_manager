<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>


                <div id="data" class="greenborder overf pad1" >
                    <!-- <form action="#" method="post" name="f3" id="f3" onsubmit="return validateForm3(this);"> -->
                        <table>
                            <tr>
                                <th colspan="7">
                                    <label for="textfield">— 软件分发 —</label>
                                </th>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                       下载服务器IP
                                </th>
                                <td colspan="6">
                                    <input type="text" name="centerIp" id="centerIp" value="${softwareUpdate.dIp}"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                       下载服务器端口
                                </th>
                                <td colspan="6">
                                    <input type="text" name="dataSynPort" id="dataSynPort" value="${softwareUpdate.dPort }"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                      下载周期
                                </th>
                                <td colspan="6">
                                    <input type="text" name="dataSynPort" id="dataSynPort" value="${softwareUpdate.dCycle }"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                       尝试安装次数
                                </th>
                                <td colspan="6">
                                    <input type="text" name="dataSynPort" id="dataSynPort" value="${softwareUpdate.tryTimes }"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                       上报服务器IP
                                </th>
                                <td colspan="6">
                                    <input type="text" name="dataSynPort" id="dataSynPort" value="${softwareUpdate.rIp }"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                      上报服务器 端口
                                </th>
                                <td colspan="6">
                                    <input type="text" name="dataSynPort" id="dataSynPort" value="${softwareUpdate.rPort }"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                      上报周期
                                </th>
                                <td colspan="6">
                                    <input type="text" name="dataSynPort" id="dataSynPort" value="${softwareUpdate.rCycle }"/>
                                </td>
                            </tr>
                        </table>
                        <c:if test="${!empty message3}">
                            <font color="red"><c:out value="${message3}"></c:out></font>
                            <c:remove var="message3"  scope="request" />
                        </c:if>
<!-- 
                <div class="martop8 Height_t">
                    <ul id="page">
                        <li><input class="R6 R7 boxy" type="submit" value="保存"/></li>
                        <li><input class="R6 R7 boxy" type="button" value="重置" onclick="onClean3();"/></li>
                        <li><input class="R6 R7 boxy" type="button" value="关闭" onclick="window.close();"/></li>
                    </ul>
                    <br />
                </div>
 -->
              <!-- </form> -->
              </div>