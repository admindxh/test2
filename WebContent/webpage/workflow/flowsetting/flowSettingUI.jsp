<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>流程设置</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
<form id="formobj" action="wfWorkFlowPowersController.do?save" style="height: 90%" name="formobj" method="post">
<input id="id" name="id" type="hidden"  value="${wfWorkflowEntity.id }">
<table style="width: 600px;height: 100%;"  cellpadding="0" cellspacing="1" class="formtable">
	<tr style="">
		<td align="right"><label class="Validform_label"> 流程类型: </label></td>
		<td class="value">${wfWorkflowEntity.flowType.demotitle }</td>
	</tr>
	<tr>
		<td align="right"><label class="Validform_label"> 流程名称: </label></td>
		<td class="value">${wfWorkflowEntity.flowName}</td>
	</tr>
	<tr>
		<td align="right"><label class="Validform_label"> 流程描述: </label></td>
		<td class="value">${wfWorkflowEntity.flowDesc }</td>
	</tr>
	<tr>
		<td align="right"><label class="Validform_label"> 创建人: </label></td>
		<td class="value">
			${cruser. realName}
		</td>
	</tr>
	<tr>
		<td align="right"><label class="Validform_label"> 创建时间: </label></td>
		<td class="value">${wfWorkflowEntity.createTime }</td>
	</tr>
	<tr>
		<td align="right"><label class="Validform_label"> 发布状态: </label></td>
		<td class="value">
			<c:if test="${wfWorkflowEntity.releaseState==0 }">
				未发布
			</c:if>
			<c:if test="${wfWorkflowEntity.releaseState==1 }">
				已发布
			</c:if>
			<c:if test="${wfWorkflowEntity.releaseState==0 }">
				有更新
			</c:if>
		
		</td>
	</tr>
	<tr>
		<td align="right"><label class="Validform_label"> 版本数量: </label></td>
		<td class="value">${wfWorkflowEntity.versionNum }</td>
	</tr>
	<tr>
		<td align="right"><label class="Validform_label"> 使用状态: </label></td>
		<td class="value">
			 <c:if test="${wfWorkflowEntity.isEnable==1 }">
				可用
			</c:if>
			<c:if test="${wfWorkflowEntity.isEnable==0 }">
				禁用
			</c:if>
		</td>
	</tr>
	
</table>

<link rel="stylesheet" href="plug-in/Validform/css/style.css" type="text/css" />
<link rel="stylesheet" href="plug-in/Validform/css/tablefrom.css" type="text/css" />
</form>
</body>