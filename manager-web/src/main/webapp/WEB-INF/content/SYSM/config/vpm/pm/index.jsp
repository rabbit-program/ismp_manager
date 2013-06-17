<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>


                <div id="data" class="greenborder overf pad1" >
                    <form action="${ctx}/ismp/domain/local/sysm/config/vpm/pm/patchDbConfigModify.do" method="post" name="f1" id="f1" onsubmit="return validateForm(this);">
                        <table>
                            <tr>
                                <th colspan="7">
                                    <label for="textfield">— 补丁 —</label>
                                </th>
                            </tr>
                            <tr>
                                <th width="18%">数据库</th>
                                <td colspan="6"><input type="text" name="dbUrl" id="dbUrl"  value="${wsus.dbUrl}"/></td>
                            </tr>
                            <tr>
                                <th width="18%">数据库驱动</th>
                                <td colspan="6"><input type="text" name="dbDriver" id="dbDriver" value="${wsus.dbDriver}"/></td>
                            </tr>
                            <tr>
                                <th width="18%">用户名</th>
                                <td colspan="6"><input type="text" name="username" id="username" value="${wsus.username}"/></td>
                            </tr>
                            <tr>
                                <th width="18%">密码</th>
                                <td colspan="6"><input type="text" name="password" id="password" value="${wsus.password}"/></td>
                            </tr>
                        </table>
                <c:if test="${!empty message}">
                <font color="red"><c:out value="${message}"></c:out></font>
                <c:remove var="message"  scope="request" />
                </c:if>
                <div class="martop8 Height_t">
                    <ul id="page">
                        <li><input class="R6 R7 boxy" type="submit" value="保存"/></li>
                        <li><input class="R6 R7 boxy" type="button" value="重置" onclick="onClean();"/></li>
                    </ul>
                </div>
              </form>
          </div>