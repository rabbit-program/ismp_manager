<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>


                <div id="data" class="greenborder overf pad1" >
                    <!-- <form action="#" method="post" name="f6" id="f6" onsubmit="return validateForm6(this);"> -->
                        <table>
                            <tr>
                                <th colspan="7">
                                    <label for="textfield">— WinSensor管理策略 —</label>
                                </th>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                       自动更新地址
                                </th>
                                <td colspan="6">
                                    <input type="text" name="centerIp" id="centerIp" value="${reg.url}"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                       自动更新周期
                                </th>
                                <td colspan="6">
                                    <input type="text" name="dataSynPort" id="dataSynPort" value="${reg.cycle }"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                       本地自动更新周期
                                </th>
                                <td colspan="6">
                                    <input type="text" name="dataSynPort" id="dataSynPort" value="${reg.cycle }"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                       管理端口
                                </th>
                                <td colspan="6">
                                    <input type="text" name="dataSynPort" id="dataSynPort" value="${reg.cycle }"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                       端口开放时间
                                </th>
                                <td colspan="6">
                                    <input type="text" name="dataSynPort" id="dataSynPort" value="${reg.cycle }"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                       是否允许用户关闭WinSensor
                                </th>
                                <td colspan="6">
                                    <input type="text" name="dataSynPort" id="dataSynPort" value="${reg.cycle }"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                       是否允许用户关闭WinSensorService
                                </th>
                                <td colspan="6">
                                    <input type="text" name="dataSynPort" id="dataSynPort" value="${reg.cycle }"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                       是否显示WinSensor小图标
                                </th>
                                <td colspan="6">
                                    <input type="text" name="dataSynPort" id="dataSynPort" value="${reg.cycle }"/>
                                </td>
                            </tr>
                        </table>
                        <c:if test="${!empty message6}">
                            <font color="red"><c:out value="${message6}"></c:out></font>
                            <c:remove var="message6"  scope="request" />
                        </c:if>
<!-- 
                <div class="martop8 Height_t">
                    <ul id="page">
                        <li><input class="R6 R7 boxy" type="submit" value="保存"/></li>
                        <li><input class="R6 R7 boxy" type="button" value="重置" onclick="onClean6();"/></li>
                        <li><input class="R6 R7 boxy" type="button" value="关闭" onclick="window.close();"/></li>
                    </ul>
                    <br />
                </div>
 -->
              <!-- </form> -->
              </div>