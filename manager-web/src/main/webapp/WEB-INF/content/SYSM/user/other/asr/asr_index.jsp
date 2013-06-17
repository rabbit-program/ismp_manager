<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<div id="contant" style="width:550px;">
        <div class="contant" id="xyshowtable" style="padding-top:0px;">
           <h2><a href="javascript:void(0)" id="axyshowtable">现有权限</a></h2>
            <div id="data" class="greenborder overf pad1" >
                <form name="f1" id="f1" action="" method="post">
                    <table id="senfe" sortcol="-1">
                         <thead>
                            <tr>
                                 <th width="21%" style="cursor:pointer" onclick="sortTable('senfe',0);">名称</th>
                                 <th width="33%">简述</th>
                                 <th width="33%">备注</th>
                                 <th width="13%">操作</th>
                            </tr>
                          </thead>
                           <tbody>
                           </tbody>
                   </table>
                 </form>
              </div>
        <div class="Height_t">
            <ul id="page" class="martop10">
                 <li style="margin-right: 12px;"><a href="javascript:void(0)"  id="addsucrity" class="R6">添加</a></li>
                 <li><a class="first" href="javascript:void(0)"></a></li>
                 <li><a class="pre" href="javascript:void(0)" title=""></a></li>
                 <li><a class="next" href="javascript:void(0)"></a></li>
                 <li><a class="last" href="javascript:void(0)"></a></li>
                 <li>共 <span id="pageSize"></span> 页 跳至
                   <input type="text" id="tpageCount" size="2" class="input"/> &nbsp; </li>
                 <li><a class="R6" href="javascript:void(0)" id="pageGo">GO</a></li>
            </ul> 
        <br />
       </div>
      </div>
        <div class="contant" id="contantAdd" style="display:none;height:0px;padding-top:0px">
            <h2><a href="javascript:void(0)" id="addPermissions">权限信息</a></h2>
			  <div id="data" class="greenborder overf pad1" >
			        <form method="post"  name="addform" id="addform">
			          <table id="senfe" sortcol="-1">
			            <thead>
			              <tr>
			              </tr>
			            </thead>
			            <tbody>
			              <tr>
			                 <th width="18%" style="cursor:pointer" onclick="sortTable('senfe',0);">名称<span class="webdings"></span></th>
			                <td colspan="6"><label for="textfield"></label>
			                <input type="text" name="asr.name" id="asrname"  /></td>
			              </tr>
			              <tr>
			                <th width="18%" style="cursor:pointer" onclick="sortTable('senfe',0);">描述<span class="webdings"></span></th>
			                <td colspan="6"><textarea name="asr.desc" id="asrdesc" cols="100%"  rows="3" ></textarea></td>
			              </tr>
			              <tr>
			             <th width="18%" style="cursor:pointer" onclick="sortTable('senfe',0);">备注</th>
			                <td colspan="6"><input type="text" name="asr.remark"  id="asrremark" /></td>
			              </tr>
			              <tr>
			              </tr>
			            </tbody>
			          </table>
			        </form> 
			    </div>
			    <div class="martop8 Height_t">
				    <ul id="page">
				        <li><a href="javascript:void(0)" class="R6 R7 boxy" id="okqr">确认</a></li>
				        <li><a href="javascript:void(0)" class="R6 R7 boxy" id="noreset">重置</a></li>
                        <li><a href="javascript:void(0)" class="R6 R7 boxy" id="upqr" style="display:none">更新</a></li>
                        <li><a href="javascript:void(0)" class="R6 R7 boxy" id="backqr" style="display:none">返回</a></li>
				    </ul>
			        <br />
			   </div>
      </div>
  </div>