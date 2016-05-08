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
 * @description <em style="color='gray'">回帖</em>
 * @date 2016年2月28日
 * @version 1.0.0
 */
@Entity
@Table(name = "alliance_reply")
public class Reply extends AbstractId{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2945217275101614065L;

	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "userid", updatable = false , nullable=false)
	private User  replyUser;
	
	@Column(name = "context")
	private String replyContext;
	
//	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@Column(name = "topicid")
	private Long topicId;
	
	@Column
	private int praise;
	
	@Column
	private int tread;
	
	@Column
	private boolean adopted;
	
	@Column(name = "replytime")
	private Date replyTime;
	
	@JsonIgnore
	@Column(name = "updatetime")
	private Date updateTime;

	public User getReplyUser() {
		return replyUser;
	}

	public void setReplyUser(User replyUser) {
		this.replyUser = replyUser;
	}

	public String getReplyContext() {
		return replyContext;
	}

	public void setReplyContext(String replyContext) {
		this.replyContext = replyContext;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public int getPraise() {
		return praise;
	}

	public void setPraise(int praise) {
		this.praise = praise;
	}

	public int getTread() {
		return tread;
	}

	public void setTread(int tread) {
		this.tread = tread;
	}

	public boolean isAdopted() {
		return adopted;
	}

	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
