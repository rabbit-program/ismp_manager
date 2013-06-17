<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>


                <div id="data" class="greenborder overf pad1" >
                    <!-- <form action="#" method="post" name="f4" id="f4" onsubmit="return validateForm4(this);"> -->
                        <table>
                            <tr>
                                <th colspan="7">
                                    <label for="textfield">— Windows日志信息 —</label>
                                </th>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                       上报地址
                                </th>
                                <td colspan="6">
                                    <input type="text" name="centerIp" id="centerIp" value="${winLog.url}"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                       周期
                                </th>
                                <td colspan="6">
                                    <input type="text" name="dataSynPort" id="dataSynPort" value="${winLog.cycle }"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                       是否采集系统日志
                                </th>
                                <td colspan="6">
                                    <input type="text" name="dataSynPort" id="dataSynPort" value="${winLog.cycle }"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                       是否采集应用程序 日志
                                </th>
                                <td colspan="6">
                                    <input type="text" name="dataSynPort" id="dataSynPort" value="${winLog.cycle }"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                       是否采集安全日志
                                </th>
                                <td colspan="6">
                                    <input type="text" name="dataSynPort" id="dataSynPort" value="${winLog.cycle }"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                       是否采集消息
                                </th>
                                <td colspan="6">
                                    <input type="text" name="dataSynPort" id="dataSynPort" value="${winLog.cycle }"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                       是否采集警告
                                </th>
                                <td colspan="6">
                                    <input type="text" name="dataSynPort" id="dataSynPort" value="${winLog.cycle }"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                       是否采集错误
                                </th>
                                <td colspan="6">
                                    <input type="text" name="dataSynPort" id="dataSynPort" value="${winLog.cycle }"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                       是否采集成功审核
                                </th>
                                <td colspan="6">
                                    <input type="text" name="dataSynPort" id="dataSynPort" value="${winLog.cycle }"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                       是否采集失败审核
                                </th>
                                <td colspan="6">
                                    <input type="text" name="dataSynPort" id="dataSynPort" value="${winLog.cycle }"/>
                                </td>
                            </tr>
                        </table>
                        <c:if test="${!empty message4}">
                            <font color="red"><c:out value="${message4}"></c:out></font>
                            <c:remove var="message4"  scope="request" />
                        </c:if>
<!-- 
                <div class="martop8 Height_t">
                    <ul id="page">
                        <li><input class="R6 R7 boxy" type="submit" value="保存"/></li>
                        <li><input class="R6 R7 boxy" type="button" value="重置" onclick="onClean4();"/></li>
                        <li><input class="R6 R7 boxy" type="button" value="关闭" onclick="window.close();"/></li>
                    </ul>
                    <br />
                </div>
 -->
              <!-- </form> -->
              </div>