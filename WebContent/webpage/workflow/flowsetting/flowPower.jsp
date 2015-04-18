<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>流程权限设置</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:formvalid formid="formobj1"  dialog="true" usePlugin="password" layout="table" action="wfWorkFlowPowersController.do?save">
	<input id="id" name="workid" type="hidden" value="${wfWorkflowEntity.id }">
	<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right"><label class="Validform_label"> 使用状态: </label></td>
			<td>
			    <select name="isEnable" id="isEnable">
			    	<option value="1" <c:if test="${wfWorkflowEntity.isEnable==1 }">selected="selected"</c:if>>可用</option>
			    	<option value="0"  <c:if test="${wfWorkflowEntity.isEnable==0 }">selected="selected"</c:if>>禁用</option>
			    </select>
			</td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 授权部门: </label></td>
			<td class="value" nowrap>
                <input name="departIds"  type="hidden" value="${departIds}" id="departIds">
                <textarea rows="5" readonly="readonly" cols="10" class="inputxt"  name="departNames" id="departname">${departNames }</textarea>
                <t:choose hiddenName="departIds" hiddenid="id" url="departController.do?departSelect" name="departList"
                          icon="icon-search" title="部门列表" textname="departname" isclear="true"></t:choose>
                <span class="Validform_checktip">请选择授权部门</span>
            </td>
		</tr>
		
		
		
		
		<tr>
			<td align="right"><label class="Validform_label"> 授权用户: </label></td>
			<td class="value" nowrap>
                <input name="userIds"  type="hidden" value="${userIds}" id="userIds">
                <textarea rows="5" readonly="readonly" cols="10" class="inputxt"  name="userNames" id="realName">${userNames }</textarea>
                <t:choose hiddenName="userIds" hiddenid="id" url="userController.do?chooser" name="userList"
                          icon="icon-search" title="用户列表" textname="realName" isclear="true"></t:choose>
                <span class="Validform_checktip">请选择授权用户</span>
            </td>
		</tr>
	</table>
</t:formvalid>

<link rel="stylesheet" href="plug-in/Validform/css/style.css" type="text/css" />
<link rel="stylesheet" href="plug-in/Validform/css/tablefrom.css" type="text/css" />
<script type="text/javascript" src="plug-in/Validform/js/Validform_v5.3.1_min_zh-cn.js"></script> <script type="text/javascript" src="plug-in/Validform/js/Validform_Datatype_zh-cn.js"></script> <script
	type="text/javascript" src="plug-in/Validform/js/datatype_zh-cn.js"></script> <SCRIPT type="text/javascript" src="plug-in/Validform/plugin/passwordStrength/passwordStrength-min.js"></SCRIPT> <script
	type="text/javascript">
			$(function() {
				$("#formobj1").Validform(
						{
							tiptype : 4,
							btnSubmit : "#btn_sub",
							btnReset : "#btn_reset",
							ajaxPost : true,
							usePlugin : {
								passwordstrength : {
									minLen : 6,
									maxLen : 18,
									trigger : function(obj, error) {
										if (error) {
											obj.parent().next().find(
													".Validform_checktip")
													.show();
											obj.find(".passwordStrength")
													.hide();
										} else {
											$(".passwordStrength").show();
											obj.parent().next().find(
													".Validform_checktip")
													.hide();
										}
									}
								}
							},
							callback : function(data) {
								var win = frameElement.api.opener;
								if (data.success == true) {
									frameElement.api.close();
									win.tip(data.msg);
								} else {
									if (data.responseText == ''
											|| data.responseText == undefined)
										$("#formobj1").html(data.msg);
									else
										$("#formobj1").html(data.responseText);
									return false;
								}
								win.reloadTable();
							}
						});
			});
		</script>


</body>