<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<%--update-end--Author:zhangguoming  Date:20140827 for：添加 组织机构查询条件--%>

<t:datagrid name="userList" title="common.operation" checkbox="true" actionUrl="userController.do?datagrid" fit="true" fitColumns="true" idField="id" >
	<t:dgCol title="common.id" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="common.username" sortable="false" field="userName" ></t:dgCol>
	<t:dgCol title="真实姓名" sortable="false" field="realName" ></t:dgCol>
    
</t:datagrid>
