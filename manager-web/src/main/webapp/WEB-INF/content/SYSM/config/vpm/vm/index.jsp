<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>


                <div id="data" class="greenborder overf pad1" >
                    <form action="${ctx}/ismp/domain/local/sysm/config/vpm/vm/virusDbConfigModify.do" method="post" name="f1" id="f1" onsubmit="return validateForm1(this);">
                        <table>
                            <tr>
                                <th colspan="7">
                                    <label for="textfield">— 病毒 —</label>
                                </th>
                            </tr>
                            <tr>
                                <th width="18%">数据库</th>
                                <td colspan="6"><input type="text" name="dbUrl1" id="dbUrl1" value="${rav.dbUrl}"/></td>
                            </tr>
                            <tr>
                                <th width="18%">数据库驱动</th>
                                <td colspan="6"><input type="text" name="dbDriver1" id="dbDriver1" value="${rav.dbDriver}"/></td>
                            </tr>
                            <tr>
                                <th width="18%">用户名</th>
                                <td colspan="6"><input type="text" name="username1" id="username1" value="${rav.username}"/></td>
                            </tr>
                            <tr>
                                <th width="18%">密码</th>
                                <td colspan="6"><input type="text" name="password1" id="password1" value="${rav.password}"/></td>
                            </tr>
                        </table>
                <c:if test="${!empty message1}">
                <font color="red"><c:out value="${message1}"></c:out></font>
                <c:remove var="message1"  scope="request" />
                </c:if>
                <div class="martop8 Height_t">
                    <ul id="page">
                        <li><input class="R6 R7 boxy" type="submit" value="保存"/></li>
                        <li><input class="R6 R7 boxy" type="button" value="重置" onclick="onClean1();"/></li>
                        <li><input class="R6 R7 boxy" type="button" value="关闭" onclick="window.close();"/></li>
                    </ul>
                </div>
              </form>
          </div>