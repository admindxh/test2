package org.jeecgframework.web.workflow.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.demo.entity.test.JeecgNoteEntity;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSFlowType;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.workflow.entity.WfWorkFlowPowersEntity;
import org.jeecgframework.web.workflow.entity.WfWorkflowEntity;
import org.jeecgframework.web.workflow.service.WfWorkFlowPowersServiceI;
import org.jeecgframework.web.workflow.service.WfWorkFlowServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("wfWorkFlowPowersController")
public class WfWorkFlowPowersController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WfWorkFlowPowersController.class);

	@Autowired
	private SystemService systemService;
	@Autowired
	private WfWorkFlowPowersServiceI wfWorkFlowPowersService;
	
	@Autowired
	private WfWorkFlowServiceI wfWorkFlowService;
	
	
	
	/**
	 * 添加或者修改方法
	 * @return
	 */
	@RequestMapping(params="addorupdate")
	public String addorupdate(WfWorkflowEntity workflowEntity,WfWorkFlowPowersEntity workFlowPowersEntity,ModelMap  modelMap){
		modelMap.put("workflowEntity", workflowEntity);
		return "workflow/flowsetting/flowSettingTabs";
	}
	
	/**
	 * 流程基本信息
	 * @return
	 */
	@RequestMapping(params="loadFlowBase")
	public String loadFlowBase(WfWorkflowEntity workflowEntity,WfWorkFlowPowersEntity workFlowPowersEntity,ModelMap  modelMap){
		if (StringUtils.isNotBlank(workflowEntity.getId())) {
			//工作流程对象信息
			WfWorkflowEntity wfWorkflowEntity = wfWorkFlowService.getEntity(WfWorkflowEntity.class, workflowEntity.getId());
			//流程工作 权限信息
			List<WfWorkFlowPowersEntity> wfflowList = wfWorkFlowPowersService.findByProperty(WfWorkFlowPowersEntity.class, "workid", workflowEntity.getId());
			//1 部门  2  用户 ,
			String departIds="";//部门ids 和 names
			String departNames=""; //部门名称
			String userIds  = "";//用户ids 
			String userNames = "";//用户names
			for (WfWorkFlowPowersEntity wfWorkFlowPowersEntity : wfflowList) {
				String powerTyp = wfWorkFlowPowersEntity.getPowerType();
				//查询部门   
				if (StringUtils.isNotBlank(powerTyp)&&powerTyp.equals("1")) {
					
					TSDepart tsDepart = (TSDepart) systemService.getEntity(TSDepart.class,  wfWorkFlowPowersEntity.getPowerid());
					departIds = departIds +tsDepart.getId()+",";
					departNames = departNames + tsDepart.getDepartname()+",";
				}else if(StringUtils.isNotBlank(powerTyp)&&powerTyp.equals("2")){
					TSUser tsUser =  (TSUser) systemService.getEntity(TSUser.class, wfWorkFlowPowersEntity.getPowerid());
					userIds = userIds  +  tsUser.getId()+",";
					userNames  = userNames   + tsUser.getUserName()+",";
				}
			}
			modelMap.put("departIds", departIds);
			modelMap.put("departNames", departNames);
			modelMap.put("userIds", userIds);
			modelMap.put("userNames", userNames);
			modelMap.put("wfWorkflowEntity", wfWorkflowEntity);
			//创建人
			TSUser cruserEntity  =  (TSUser) systemService.getEntity(TSUser.class, wfWorkflowEntity.getCreateUserId());
			//修改人
			
			modelMap.put("cruser", cruserEntity);
			if (wfWorkflowEntity.getUpdateUserId()!=null) {
				TSUser upuserEntity  =  (TSUser)systemService.getEntity(TSUser.class, wfWorkflowEntity.getUpdateUserId());
				modelMap.put("upuser", upuserEntity);
				
			}
		}
		
		return "workflow/flowsetting/flowSettingUI";
	}
	
	
	
	/**
	 * 流程权限控制
	 * @return
	 */
	@RequestMapping(params="loadFlowPower")
	public String loadFlowPower(WfWorkflowEntity workflowEntity,WfWorkFlowPowersEntity workFlowPowersEntity,ModelMap  modelMap){
		if (StringUtils.isNotBlank(workflowEntity.getId())) {
			//工作流程对象信息
			WfWorkflowEntity wfWorkflowEntity = wfWorkFlowService.getEntity(WfWorkflowEntity.class, workflowEntity.getId());
			//流程工作 权限信息
			List<WfWorkFlowPowersEntity> wfflowList = wfWorkFlowPowersService.findByProperty(WfWorkFlowPowersEntity.class, "workid", workflowEntity.getId());
			//1 部门  2  用户 ,
			String departIds="";//部门ids 和 names
			String departNames=""; //部门名称
			String userIds  = "";//用户ids 
			String userNames = "";//用户names
			for (WfWorkFlowPowersEntity wfWorkFlowPowersEntity : wfflowList) {
				String powerTyp = wfWorkFlowPowersEntity.getPowerType();
				//查询部门   
				if (StringUtils.isNotBlank(powerTyp)&&powerTyp.equals("1")) {
					TSDepart tsDepart = (TSDepart) systemService.getEntity(TSDepart.class,  wfWorkFlowPowersEntity.getPowerid());
					departIds = departIds +tsDepart.getId()+",";
					departNames = departNames + tsDepart.getDepartname()+",";
				}else if(StringUtils.isNotBlank(powerTyp)&&powerTyp.equals("2")){
					TSUser tsUser =  (TSUser) systemService.getEntity(TSUser.class, wfWorkFlowPowersEntity.getPowerid());
					userIds = userIds  +  tsUser.getId()+",";
					userNames  = userNames   + tsUser.getRealName()+",";
				}
			}
			modelMap.put("departIds", departIds);
			modelMap.put("departNames", departNames);
			modelMap.put("userIds", userIds);
			modelMap.put("userNames", userNames);
			modelMap.put("wfWorkflowEntity", wfWorkflowEntity);
			//创建人
			TSUser cruserEntity  =  (TSUser) systemService.getEntity(TSUser.class, wfWorkflowEntity.getCreateUserId());
			//修改人
			modelMap.put("cruser", cruserEntity);
			if(wfWorkflowEntity.getUpdateUserId()!=null){
			TSUser upuserEntity  =  (TSUser)systemService.getEntity(TSUser.class, wfWorkflowEntity.getUpdateUserId());
			modelMap.put("upuser", upuserEntity);
			}
		}
		
		return "workflow/flowsetting/flowPower";
	}
	
	
	@RequestMapping(params="save")
	@ResponseBody
	public AjaxJson  save(WfWorkFlowPowersEntity flowPowersEntity,HttpServletRequest request){
		AjaxJson t = new AjaxJson();
		//删除原来的权限设置,保存现在的权限设置
		if (StringUtils.isNotBlank(flowPowersEntity.getWorkid())) {
			String workid  =  flowPowersEntity.getWorkid();
			String isEnalbe  = request.getParameter("isEnable");
			WfWorkflowEntity workflowEntity = systemService.getEntity(WfWorkflowEntity.class, workid);
			workflowEntity.setIsEnable(Short.parseShort(isEnalbe));
			systemService.updateEntitie(workflowEntity);
			//删除原来的权限
			systemService.deleteByProperty(WfWorkFlowPowersEntity.class, "workid", flowPowersEntity.getId());
			//更新状态
			String departIds  = request.getParameter("departIds");
			if (StringUtils.isNotBlank(departIds)) {
				String [] departId  =  departIds.split(",");
				for (String depart : departId) {
					WfWorkFlowPowersEntity powersEntity =  new WfWorkFlowPowersEntity();
					powersEntity.setPowerid(depart);
					powersEntity.setPowerType("1");
					powersEntity.setWorkid(workid);
					systemService.save(powersEntity);
				}
			}
			String userIds  = request.getParameter("userIds");
			if (StringUtils.isNotBlank(userIds)) {
				String [] userid  =  userIds.split(",");
				for (String uid : userid) {
					WfWorkFlowPowersEntity powersEntity =  new WfWorkFlowPowersEntity();
					powersEntity.setPowerid(uid);
					powersEntity.setPowerType("2");
					powersEntity.setWorkid(workid);
					systemService.save(powersEntity);
				}
			}
		}
		
		return t;
	}
	
	
	/**
	 * 用户选择角色跳转页面
	 * 
	 * @return
	 */
	@RequestMapping(params = "departs")
	public String departs() {
		return "system/user/users";
	}
	
	
	/**
	 * 流程创建页面
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdateflow")
	public ModelAndView addorupdateflow(WfWorkflowEntity  wfWorkflowEntity, HttpServletRequest req) {
		
		return new ModelAndView("workflow/flowsetting/workflow");
	}
	
	
	@RequestMapping(params="saveWorkFlow")
	@ResponseBody
	public AjaxJson  saveWorkFlow(WfWorkFlowPowersEntity flowPowersEntity,HttpServletRequest request){
		AjaxJson t = new AjaxJson();
		TSUser sessionUserName = ResourceUtil.getSessionUserName();
		WfWorkflowEntity  entity =  new WfWorkflowEntity();
		String flowName  = request.getParameter("flowName");
		String isEnable  = request.getParameter("isEnable");
		String flowtype  = request.getParameter("flowtype");
		entity.setCreateTime(new Date());
		entity.setCreateUserId(sessionUserName.getId());
		entity.setFlowId(request.getParameter("flowId"));
		TSFlowType tsFlowType = new TSFlowType();
		tsFlowType.setId(flowtype);
		entity.setFlowType(tsFlowType);
		entity.setVersionNum(1);
		entity.setFlowName(flowName);
		entity.setReleaseState((short)0);
		entity.setIsEnable(Short.parseShort(isEnable));
		String  workid = (String) systemService.save(entity);
		
		//删除原来的权限设置,保存现在的权限设置
		if (StringUtils.isNotBlank(workid)) {
			//更新状态
			String departIds  = request.getParameter("departIds");
			if (StringUtils.isNotBlank(departIds)) {
				String [] departId  =  departIds.split(",");
				for (String depart : departId) {
					WfWorkFlowPowersEntity powersEntity =  new WfWorkFlowPowersEntity();
					powersEntity.setPowerid(depart);
					powersEntity.setPowerType("1");
					powersEntity.setId(workid);;
					systemService.save(powersEntity);
				}
			}
			String userIds  = request.getParameter("userIds");
			if (StringUtils.isNotBlank(userIds)) {
				String [] userid  =  userIds.split(",");
				for (String uid : userid) {
					WfWorkFlowPowersEntity powersEntity =  new WfWorkFlowPowersEntity();
					powersEntity.setPowerid(uid);
					powersEntity.setPowerType("2");
					powersEntity.setWorkid(workid);
					systemService.save(powersEntity);
				}
			}
		}
		
		return t;
	}
	
	
	
	public SystemService getSystemService() {
		return systemService;
	}
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}
	public WfWorkFlowPowersServiceI getWfWorkFlowPowersService() {
		return wfWorkFlowPowersService;
	}
	public void setWfWorkFlowPowersService(
			WfWorkFlowPowersServiceI wfWorkFlowPowersService) {
		this.wfWorkFlowPowersService = wfWorkFlowPowersService;
	}
	
	
	
}
