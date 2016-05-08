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
 * @date 2016年1月26日
 * @version 1.0.0
 */
@Entity
@Table(name = "alliance_user")
public class User extends AbstractId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1158577166012223801L;
	
	
	@Column(name ="username")
	private String userName;
	
	@JsonIgnore
	@Column(name = "userpass")
	private String userPass;
	
	@Column(name = "headimage")
	private byte[] headImage;
	
	@Column(name = "nickname")
	private String nickName;
	
	@JsonIgnore
	@Column(name ="email")
	private String email;
	
	@Column(name = "birthday") 
	private Date birthday;
	
	@JsonIgnore
	@Column(name = "cardid")
	private String cardId;
	
	@Column(name = "realname")
	private String realName;
	
	@JsonIgnore
	@Column
	private String mobile;
	
	@Column
	private String hobby;

	@JsonIgnore
	@Column(name = "registrationdate")
	private String registrationDate;
	
	@JsonIgnore
	@Column(name ="updatetime")
	private Date updateTime;
	
	@Column
	private byte vip;
	
	@Column(name = "openid")
	private String openId;
	
	@JsonIgnore
	@Column(name = "logintimes")
	private int loginTimes;

	public User(){
		
	}
	
	public User(Long id){
		setId(id);
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public byte[] getHeadImage() {
		return headImage;
	}

	public void setHeadImage(byte[] headImage) {
		this.headImage = headImage;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public byte getVip() {
		return vip;
	}

	public void setVip(byte vip) {
		this.vip = vip;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public int getLoginTimes() {
		return loginTimes;
	}

	public void setLoginTimes(int loginTimes) {
		this.loginTimes = loginTimes;
	}
	
	
}
