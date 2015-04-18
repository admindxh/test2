package org.jeecgframework.web.workflow.service.impl;

import java.util.List;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.web.workflow.entity.WfWorkflowEntity;
import org.jeecgframework.web.workflow.service.WfWorkFlowServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 流程设置实现类
 * @author dxh
 *
 */
@Transactional
@Service("wfWorkFlowService")
public class WfWorkFlowServiceImpl extends CommonServiceImpl implements WfWorkFlowServiceI {

	@Override
	public List<WfWorkflowEntity> gett() {
		// TODO Auto-generated method stub
		return  this.getSession().createCriteria(WfWorkflowEntity.class).list();
	}

}
