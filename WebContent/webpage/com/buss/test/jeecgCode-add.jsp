<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>jeecg_code</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="jeecgCodeController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${jeecgCodePage.id }">
					<input id="createName" name="createName" type="hidden" value="${jeecgCodePage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${jeecgCodePage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${jeecgCodePage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${jeecgCodePage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${jeecgCodePage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${jeecgCodePage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							test:
						</label>
					</td>
					<td class="value">
					     	 <input id="test" name="test" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">test</label>
						</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/buss/test/jeecgCode.js"></script>		