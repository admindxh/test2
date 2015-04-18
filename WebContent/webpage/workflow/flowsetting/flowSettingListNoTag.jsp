<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;">
<table id="jeecgEasyUIList" style="width: 700px; height: 300px">
	<thead>
		<tr>
			<th field="id" hidden="hidden">编号</th>
			<th field="flowName" width="50">名称</th>
			<th field="flowType" width="50" >流程类型</th>
			<th field="isEnable" width="50">启用状态</th>
			<th field="releaseState" width="50">发布状态</th>
			<th field="versionNum" width="50">数量</th>
			<th field="createTime" width="50">发布时间</th>
			<th field="opt" width="100">操作</th>
		</tr>
	</thead>
</table>
<div id="tb2" style="height: 30px;" class="datagrid-toolbar">
<span style="float: left;"> 
	<a href="#" id='add' class="easyui-linkbutton" plain="true" icon="icon-add"
	    onclick="add('录入','wfWorkFlowPowersController.do?addorupdateflow','jeecgEasyUIList')" id="">录入</a> 
	 </span> 
	<span style="float: right"> <input id="jeecgEasyUIListsearchbox" class="easyui-searchbox"
	data-options="searcher:jeecgEasyUIListsearchbox,prompt:'请输入关键字',menu:'#jeecgEasyUIListmm'"></input>
	<div id="jeecgEasyUIListmm" style="width: 120px">
	<div data-options="name:'userName',iconCls:'icon-ok'">姓名</div>
	<div data-options="name:'mobilePhone',iconCls:'icon-ok'">手机</div>
	</div>
</span>
</div>
<script type="text/javascript">
	    // 编辑初始化数据
		function getData(data){
			var rows = [];			
			var total = data.total;
			for(var i=0; i<data.rows.length; i++){
				rows.push({
					id: data.rows[i].id,
					flowName: data.rows[i].flowName,
					flowType: data.rows[i].flowtype,
					isEnable: data.rows[i].isEnable,
					releaseState: data.rows[i].releaseState,
					versionNum: data.rows[i].versionNum,
					createTime: data.rows[i].createTime,
					opt: "[<a href=\"#\" onclick=\"delObj('workFlowController.do?del&id="+data.rows[i].id+"','jeecgEasyUIList')\">删除</a>]&nbsp;[<a href='#' onclick=szlc("+data.rows[i].id+")>设置<a/>]"
				});
			}
			var newData={"total":total,"rows":rows};
			return newData;
		}
	    // 筛选
		function jeecgEasyUIListsearchbox(value,name){
    		var queryParams=$('#jeecgEasyUIList').datagrid('options').queryParams;
    		queryParams[name]=value;
    		queryParams.searchfield=name;
    		$('#jeecgEasyUIList').datagrid('load');
    	}
	    // 刷新
	    function reloadTable(){
	    	$('#jeecgEasyUIList').datagrid('reload');
	    }
	    
		// 设置datagrid属性
		$('#jeecgEasyUIList').datagrid({
			title: '常用流程',
	        idField: 'id',
	        fit:true,
	        loadMsg: '数据加载中...',
	        pageSize: 10,
	        pagination:true,
	        sortOrder:'asc',
	        rownumbers:true,
	        singleSelect:true,
	        fitColumns:true,
	        showFooter:true,
	        url:'workFlowController.do?datagrid',  
	        toolbar: '#tb2',
	        loadFilter: function(data){
	        	return getData(data);
	    	}
	        
	    }); 
	    //设置分页控件  
	    $('#jeecgEasyUIList').datagrid('getPager').pagination({  
	        pageSize: 10,  
	        pageList: [10,20,30],  
	        beforePageText: '',  
	        afterPageText: '/{pages}',
	        displayMsg: '{from}-{to}共{total}条',
	        showPageList:true,
	        showRefresh:true,
	        onBeforeRefresh:function(pageNumber, pageSize){
	            $(this).pagination('loading');
	            $(this).pagination('loaded');
	        }
	    });
	    // 设置筛选
    	$('#jeecgEasyUIListsearchbox').searchbox({
    		searcher:function(value,name){
    			jeecgEasyUIListsearchbox(value,name);
    		},
    		menu:'#jeecgEasyUIListmm',
    		prompt:'请输入查询关键字'
    	});
	</script></div>
</div>





<script type="text/javascript">
	function szlc(id) {
		createwindow('流程设置', 'wfWorkFlowPowersController.do?addorupdate&id=' + id);
	}
    function noteAdd(){
        openwindow("自定义按钮","jeecgNoteController.do?addorupdateNoBtn","jeecgNoteList",600,400);
    }
</script>