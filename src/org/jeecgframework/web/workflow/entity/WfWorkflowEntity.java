package org.jeecgframework.web.workflow.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.jeecgframework.web.system.pojo.base.TSFlowType;

/**
 * WfWorkflow entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="wf_workflow",schema="")
public class WfWorkflowEntity implements java.io.Serializable {

	// Fields

	/**
	 * @Fields serialVersionUID : 
	 */
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="wfWorkFlow")
	@GenericGenerator(name="wfWorkFlow",strategy="uuid")
	@Column(name="id",nullable=false,length=36)
	private String id;
	/**
	 * 是否可用，1：可用，0:禁用
	 */
	@Column(name="is_enable")
	private Short isEnable;
	/**
	 * 同流程定义id(key)一致
	 */
	@Column(name="flow_id")
	private String flowId;
	/**
	 * 流程类型 字典值
	 *//*
	@Column(name="flow_type")
	private String flowType;*/
	/**
	 * 流程名称 
	 */
	@Column(name="flow_name")
	private String flowName;
	/**
	 * 创建时间
	 */
	@Column(name="create_time")
	private Date createTime;
	/**
	 * 创建人 id
	 */
	@Column(name="create_user_id")
	private String createUserId;
	/**
	 * 备注
	 */
    @Column(name="flow_desc")
	private String flowDesc;
	/**
	 * 发布状态,0 未发布，1已发布,2:已发布，有更新
	 */
    @Column(name="release_state")
	private Short releaseState;
	/**
	 * 现存的版本数量
	 */
    @Column(name="version_num")
	private Integer versionNum;
	/**
	 * 最后更新流程设计的用户id
	 */
    @Column(name="update_user_id")
	private String updateUserId;
	/**
	 * 最后更新流程设计时间
	 */
    @Column(name="update_time")
	private Date updateTime;
	/**
	 * 最后更新流程设计说明
	 */
	@Column(name="update_desc")
	private String updateDesc;
	/**
	 * 流程设计xml内容
	 */
	@Column(name="flow_xml")
	private String flowXml;

	// Constructors

	
	@ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.LAZY)
	@JoinColumn(name="flow_type")
	@NotFound(action=NotFoundAction.IGNORE)
	private  TSFlowType flowType;//流程类型
	
	
	
	
	
	
	/** default constructor */
	public WfWorkflowEntity() {
	}

	/** minimal constructor */
	public WfWorkflowEntity(Short releaseState, Integer versionNum) {
		this.releaseState = releaseState;
		this.versionNum = versionNum;
	}

	/** full constructor */
	public WfWorkflowEntity(Short isEnable, String flowId, String flowType,
			String flowName, Timestamp createTime, String createUserId,
			String flowDesc, Short releaseState, Integer versionNum,
			String updateUserId, Date updateTime, String updateDesc,
			String flowXml) {
		this.isEnable = isEnable;
		this.flowId = flowId;
		//this.flowType = flowType;
		this.flowName = flowName;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.flowDesc = flowDesc;
		this.releaseState = releaseState;
		this.versionNum = versionNum;
		this.updateUserId = updateUserId;
		this.updateTime = updateTime;
		this.updateDesc = updateDesc;
		this.flowXml = flowXml;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Short getIsEnable() {
		return this.isEnable;
	}

	public void setIsEnable(Short isEnable) {
		this.isEnable = isEnable;
	}

	public String getFlowId() {
		return this.flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	

	public String getFlowName() {
		return this.flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getFlowDesc() {
		return this.flowDesc;
	}

	public void setFlowDesc(String flowDesc) {
		this.flowDesc = flowDesc;
	}

	public Short getReleaseState() {
		return this.releaseState;
	}

	public void setReleaseState(Short releaseState) {
		this.releaseState = releaseState;
	}

	public Integer getVersionNum() {
		return this.versionNum;
	}

	public void setVersionNum(Integer versionNum) {
		this.versionNum = versionNum;
	}

	public String getUpdateUserId() {
		return this.updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateDesc() {
		return this.updateDesc;
	}

	public void setUpdateDesc(String updateDesc) {
		this.updateDesc = updateDesc;
	}

	public String getFlowXml() {
		return this.flowXml;
	}

	public void setFlowXml(String flowXml) {
		this.flowXml = flowXml;
	}
	
	public TSFlowType getFlowType() {
		return flowType;
	}

	public void setFlowType(TSFlowType flowType) {
		this.flowType = flowType;
	}
	
	

}