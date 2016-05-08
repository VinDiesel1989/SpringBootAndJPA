/**
 * 
 */
package com.alliance.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author qW
 * @description <em style="color='gray'">TODO</em>
 * @date 2016年2月23日
 * @version 1.0.0
 */
@Entity
@Table(name = "alliance_weix")
public class WeiXin extends AbstractId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3858978143582904387L;
	
	@Column(name = "openid")
	private String openId;
	
	@Column(name = "weixinnick")
	private String weiXinNick;
	
	@Column(name = "sex")
	private byte sex;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "province")
	private String province;
	
	@Column(name = "weixinhead")
	private byte[] weiXinHead;
	
	@Column(name = "subscribetime")
	private Date subscribeTime;
	
	@JsonIgnore
	@Column(name = "updatetime")
	private Date updateTime;
	
	@JsonIgnore
	@Column(name = "createtime")
	private Date createTime;

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getWeiXinNick() {
		return weiXinNick;
	}

	public void setWeiXinNick(String weiXinNick) {
		this.weiXinNick = weiXinNick;
	}

	public byte getSex() {
		return sex;
	}

	public void setSex(byte sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public byte[] getWeiXinHead() {
		return weiXinHead;
	}

	public void setWeiXinHead(byte[] weiXinHead) {
		this.weiXinHead = weiXinHead;
	}

	public Date getSubscribeTime() {
		return subscribeTime;
	}

	public void setSubscribeTime(Date subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
