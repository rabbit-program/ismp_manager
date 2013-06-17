<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>


                <div id="data" class="greenborder overf pad1" >
                    <!-- <form action="#" method="post" name="f5" id="f5" onsubmit="return validateForm5(this);"> -->
                        <table>
                            <tr>
                                <th colspan="7">
                                    <label for="textfield">— 补丁更新 —</label>
                                </th>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                       配置文件地址
                                </th>
                                <td colspan="6">
                                    <input type="text" name="centerIp" id="centerIp" value="${patchUpdate.url}"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="18%">
                                                                                                       周期
                                </th>
                                <td colspan="6">
                                    <input type="text" name="dataSynPort" id="dataSynPort" value="${patchUpdate.cycle }"/>
                                </td>
                            </tr>
                        </table>
                        <c:if test="${!empty message5}">
                            <font color="red"><c:out value="${message5}"></c:out></font>
                            <c:remove var="message5"  scope="request" />
                        </c:if>
<!-- 
                <div class="martop8 Height_t">
                    <ul id="page">
                        <li><input class="R6 R7 boxy" type="submit" value="保存"/></li>
                        <li><input class="R6 R7 boxy" type="button" value="重置" onclick="onClean5();"/></li>
                        <li><input class="R6 R7 boxy" type="button" value="关闭" onclick="window.close();"/></li>
                    </ul>
                    <br />
                </div>
 -->
              <!-- </form> -->
              </div>