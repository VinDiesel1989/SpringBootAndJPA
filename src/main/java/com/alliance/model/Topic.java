/**
 * 
 */
package com.alliance.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * @author qW
 * @description <em style="color='gray'">主贴</em>
 * @date 2016年2月27日
 * @version 1.0.0
 */
@Entity
@Table(name = "alliance_topic")
public class Topic extends AbstractId {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1126082916375760101L;

	 /* 主题帖类型, (普通主题帖和 提问性主题帖 (1,2,3级别)) */
	
	/**
	 * 普通主题帖
	 */
	public static final int NORMAL_INVITATION = 0;
	/**
	 * 非紧急提问帖
	 */
	public static final int NOT_URGENT_QUESTION = 1;
	/**
	 * 普通性质提问帖
	 */
	public static final int NORMAL_QUESTION = 2;
	/**
	 * 紧急性质提问帖
	 */
	public static final int INSTANCY_QUESTION = 3;
	
	@Column
	private String title;
	
	@Column
	private String context;
	
	@Column
	private String images;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "userid",updatable=false,insertable=false,nullable=false)
	private User targetUser;
	/**
	 * 赞
	 */
	@Column
	private int praise;
	/**
	 * 踩
	 */
	@Column
	private int tread;
	
	@Column
	private int browse;
	
	@Column(name = "level")
	private byte level;
	
	@Column
	private int status;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "indusid",updatable=false,insertable=false,nullable=false)
	private Indus indus;
	
	@Column(name = "createtime")
	private Date createTime;
	
	@Column(name = "relytime")
	private Date  relyTime;
	
	/**
	 * 回帖
	 */
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="topicId")
	@OrderBy("replyTime DESC")
	private Set<Reply> replys;
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
	
	public User getTargetUser() {
		return targetUser;
	}

	public void setTargetUser(User targetUser) {
		this.targetUser = targetUser;
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

	public Indus getIndus() {
		return indus;
	}

	public void setIndus(Indus indus) {
		this.indus = indus;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getRelyTime() {
		return relyTime;
	}

	public void setRelyTime(Date relyTime) {
		this.relyTime = relyTime;
	}

	public int getBrowse() {
		return browse;
	}

	public void setBrowse(int browse) {
		this.browse = browse;
	}

	public byte getLevel() {
		return level;
	}

	public void setLevel(byte level) {
		this.level = level;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Set<Reply> getReplys() {
		return replys;
	}

	public void setReplys(Set<Reply> replys) {
		this.replys = replys;
	}

	
}
