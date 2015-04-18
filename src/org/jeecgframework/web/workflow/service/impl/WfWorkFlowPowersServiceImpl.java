package org.jeecgframework.web.workflow.service.impl;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.web.workflow.service.WfWorkFlowPowersServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 流程工作权限service 
 * @author dxh
 *
 */
@Service("wfWorkFlowPowersService")
@Transactional
public class WfWorkFlowPowersServiceImpl extends CommonServiceImpl implements WfWorkFlowPowersServiceI{
	
}
