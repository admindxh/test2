package org.jeecgframework.web.workflow.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="wf_workflow_powers")
public class WfWorkFlowPowersEntity {
     
	@Id
	@GeneratedValue(generator="WfWorkFlowPowersEntity")
	@GenericGenerator(name="WfWorkFlowPowersEntity",strategy="uuid")
	@Column(name="id")
	private  String id ;
	
	@Column(name="work_id")
	private String workid;//流程工作对象ID
	
	@Column(name="power_id")
	private String powerid;//权限id
	
	@Column(name="power_type")
	private String powerType;//权限类型ID 0,所有人  1部门,  2用户
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWorkid() {
		return workid;
	}
	public void setWorkid(String workid) {
		this.workid = workid;
	}
	public String getPowerid() {
		return powerid;
	}
	public void setPowerid(String powerid) {
		this.powerid = powerid;
	}
	public String getPowerType() {
		return powerType;
	}
	public void setPowerType(String powerType) {
		this.powerType = powerType;
	}

	
	
	
	
	
}
