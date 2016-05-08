/**
 * 
 */
package com.alliance.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author qW
 * @description <em style="color='gray'">TODO</em>
 * @date 2016年2月27日
 * @version 1.0.0
 */
@MappedSuperclass
public class AbstractId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5552602702016786572L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
