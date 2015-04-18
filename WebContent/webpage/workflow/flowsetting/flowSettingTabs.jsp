<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>流程设置</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
		<t:tabs id="tt" iframe="false" tabPosition="bottom">
		  	<t:tab title="流程基本信息" heigth="300px" id="flowbase"  href="wfWorkFlowPowersController.do?loadFlowBase&id=${workflowEntity.id }"></t:tab>
		  	<t:tab title="流程权限" id="flowpower" href="wfWorkFlowPowersController.do?loadFlowPower&id=${workflowEntity.id }"></t:tab>
		</t:tabs>
</body>