package org.jeecgframework.web.workflow.service;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.web.workflow.entity.WfWorkflowEntity;

/**
 * 流程设置 service
 * @author dxh
 *
 */
public interface WfWorkFlowServiceI  extends CommonService{
		public List<WfWorkflowEntity> gett();
}
