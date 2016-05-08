/**
 * 
 */
package com.alliance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author qW
 * @description <em style="color='gray'">用户初始化</em>
 * @date 2016年2月27日
 * @version 1.0.0
 */
@Entity
@Table(name = "alliance_initial")
public class Initial extends AbstractId{

/**
	 * 
	 */
	private static final long serialVersionUID = -1895372958756265615L;

	@Column(name = "userId")
	private Long userId;
	
	@Column(name = "weixinid")
	private String weiXinId;
	
	@Column(name = "ispay")
	private boolean isPay;
	/**
	 * 行业
	 */
	@Column(name = "industry")
	private Long industry;
	/**
	 * 职能
	 */
	@Column(name = "occupation")
	private Long occupation;
	/**
	 * 职位
	 */
	@Column(name = "positions")
	private Long positions;
	/**
	 * 职称
	 */
	@Column(name = "jobtitle")
	private Long jobTitle;
	/**
	 * 建议
	 */
	@Column(name = "opinion")
	private String opinion;
	
	@Column(name = "createtime")
	private Date createTime;
	
	@Column(name = "updatetime")
	private Date updateTime;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getWeiXinId() {
		return weiXinId;
	}

	public void setWeiXinId(String weiXinId) {
		this.weiXinId = weiXinId;
	}

	public boolean isPay() {
		return isPay;
	}

	public void setPay(boolean isPay) {
		this.isPay = isPay;
	}

	public Long getIndustry() {
		return industry;
	}

	public void setIndustry(Long industry) {
		this.industry = industry;
	}

	public Long getOccupation() {
		return occupation;
	}

	public void setOccupation(Long occupation) {
		this.occupation = occupation;
	}

	public Long getPositions() {
		return positions;
	}

	public void setPositions(Long positions) {
		this.positions = positions;
	}

	public Long getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(Long jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
