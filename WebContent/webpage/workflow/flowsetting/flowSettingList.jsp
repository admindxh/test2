<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;">
<t:datagrid name="jeecgNoteList" title="流程查询" actionUrl="workFlowController.do?datagrid" checkbox="true" idField="id" fit="true" queryMode="group">
	<t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="名称" field="flowName" query="true"  width="300" align="center"></t:dgCol>
	<t:dgCol title="流程类型" field="flowType.demotitle" query="true" ></t:dgCol>
	<t:dgCol title="启用状态" field="isEnable"  query="true" replace="启用_1,禁用_0"></t:dgCol>
	<t:dgCol title="发布状态" field="releaseState" query="true"  replace="未发布_0,已发布_1,有更新_2"></t:dgCol>
	<t:dgCol title="数量" field="versionNum"></t:dgCol>
	<t:dgCol title="发布时间" field="createTime" sortable="true"  formatter="yyyy-MM-dd hh-mm-ss" ></t:dgCol>
	<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
	<t:dgDelOpt title="删除" url="workFlowController.do?del&id={id}" />
	<t:dgFunOpt   funname="szlc(id)" title="设置" />
	<t:dgToolBar title="添加" icon="icon-add" url="wfWorkFlowPowersController.do?addorupdateflow" funname="add" operationCode="add"></t:dgToolBar>
</t:datagrid>

</div>
</div>
<script type="text/javascript">
	function szlc(id) {
		createwindow('流程设置', 'wfWorkFlowPowersController.do?addorupdate&id=' + id);
	}
    function noteAdd(){
        openwindow("自定义按钮","jeecgNoteController.do?addorupdateNoBtn","jeecgNoteList",600,400);
    }
</script>