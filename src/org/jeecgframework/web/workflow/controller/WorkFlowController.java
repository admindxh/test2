package org.jeecgframework.web.workflow.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.jeecgframework.web.demo.controller.test.JeecgNoteController;
import org.jeecgframework.web.demo.entity.test.JeecgNoteEntity;
import org.jeecgframework.web.demo.service.test.JeecgNoteServiceI;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.workflow.entity.WfWorkflowEntity;
import org.jeecgframework.web.workflow.service.WfWorkFlowServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 流程管理
 * @author dxh
 *
 */
@RequestMapping(value="workFlowController")
@Controller
public class WorkFlowController  extends BaseController{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WorkFlowController.class);

	@Autowired
	private WfWorkFlowServiceI flowService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * 流程列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "workFlow")
	public ModelAndView jeecgNote(HttpServletRequest request) {
		return new ModelAndView("workflow/flowsetting/flowlistiframe");
	}
	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(WfWorkflowEntity  wfWorkflowEntity,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WfWorkflowEntity.class, dataGrid);
		//查询条件组装器
		cq.addOrder("createTime",SortDirection.desc);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wfWorkflowEntity);
		this.flowService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	
	@RequestMapping(params="del")
	@ResponseBody
	public AjaxJson  del(WfWorkflowEntity workflowEntity,HttpServletRequest request,HttpServletResponse  response,ModelMap modelmap){
		AjaxJson ajaxJson =  new AjaxJson();
		message = "删除成功";
		systemService.deleteEntityById(WfWorkflowEntity.class, workflowEntity.getId());
		ajaxJson.setMsg(message);
		return ajaxJson;
	}
	
	
	
	
	
	
	
	
	
	
	
}
