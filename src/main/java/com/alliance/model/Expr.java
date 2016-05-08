/**
 * 
 */
package com.alliance.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author qW
 * @description <em style="color='gray'">用户经验</em>
 * @date 2016年2月28日
 * @version 1.0.0
 */
@Entity
@Table(name = "alliance_experience")
public class Expr extends AbstractId{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2222910860006669691L;
	/** 提问采纳奖励积分：非紧急 */
	public static final int	INVITATION_LV1_EXPR	= 30;
	/** 提问采纳奖励积分：普通 */
	public static final int	INVITATION_LV2_EXPR	= 50;
	/** 提问采纳奖励积分：紧急 */
	public static final int	INVITATION_LV3_EXPR	= 100;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "userid")
	private User user;
	
	@Column(name = "exprvalue")
	private int exprVal;
	
	@JsonIgnore
	@Column(name = "createtime")
	private Date createTime;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public int getExprVal() {
		return exprVal;
	}

	public void setExprVal(int exprVal) {
		this.exprVal = exprVal;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
