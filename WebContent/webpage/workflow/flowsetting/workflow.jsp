<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>流程创建</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:formvalid formid="formobj" beforeCheck="beforeCheck:function(){var code  = $(\"input[name='flowType.id']\").val();$(\"#btype\").val(code);}" dialog="true" usePlugin="password" layout="table" action="wfWorkFlowPowersController.do?saveWorkFlow">
	
	<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right"><label class="Validform_label"> 流程名称: </label></td>
			<td class="value"><input class="inputxt" id="flowName" name="flowName"   datatype="s1-8"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 使用状态: </label></td>
			<td class="value">
				 <select name="isEnable" id="isEnable">
			    	<option value="1" <c:if test="${wfWorkflowEntity.isEnable==1 }">selected="selected"</c:if>>可用</option>
			    	<option value="0"  <c:if test="${wfWorkflowEntity.isEnable==0 }">selected="selected"</c:if>>禁用</option>
			    </select>
			</td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 流程类型: </label></td>
			<td class="value" id="btree">
				<t:comboTree  url="demoController.do?pDemoList"   name="flowType.id" id="pdemo" ></t:comboTree>
				<input  value="" id="btype" name="flowtype" type="hidden"  datatype="*"/>
				<span class="Validform_checktip"></span>
			</td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_labflowtypeel"> key: </label></td>
			<td class="value"><input class="inputxt" id="flowId" name="flowId"  datatype="*1-16"> <span class="Validform_checktip"></span></td>
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
</body>