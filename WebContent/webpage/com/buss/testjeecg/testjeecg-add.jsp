<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>TestJeecg</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="testjeecgController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${testjeecgPage.id }">
					<input id="createName" name="createName" type="hidden" value="${testjeecgPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${testjeecgPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${testjeecgPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${testjeecgPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${testjeecgPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${testjeecgPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							name:
						</label>
					</td>
					<td class="value">
					     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">name</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sex:
						</label>
					</td>
					<td class="value">
					     	 <input id="sex" name="sex" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">sex</label>
						</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/buss/testjeecg/testjeecg.js"></script>		