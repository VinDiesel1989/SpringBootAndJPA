/**
 * 
 */
package com.alliance.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.apache.commons.collections4.CollectionUtils;

import com.alliance.model.tree.Tree;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * @author qW
 * @description <em style="color='gray'">行业( 树)</em>
 * @date 2016年2月27日
 * @version 1.0.0
 */
@Entity
@Table(name = "alliance_industry")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,property = "@id")
public class Indus extends Tree<Indus>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3232385545775982695L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	
	@ManyToOne(fetch=FetchType.LAZY,targetEntity=Indus.class , optional = false)
	@JoinColumn(name="parent",updatable=false,insertable=false,nullable=true)
	private  Indus parent;
	
	@Column(name = "description")
	private String description;
	
	@JsonIgnore
	@Column(name = "index_")
	private int index;
	
	@JsonIgnore
	@Column(name = "available")
	private boolean available;
	
	@JsonIgnore
	@Column(name = "editable")
	private boolean editable;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="parent",targetEntity=Indus.class, fetch=FetchType.LAZY )
	@OrderBy("index")
	private Set<Indus> children;
	
	public Indus(){
		
	}
	
	public Indus(long id){
		this.id = id;
	}
	
	public Indus(long id,String name){
		this.id = id;
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public Serializable getId() {
		return id;
	}
	
	@Override
	public boolean isAvailable() {
		return available;
	}
	
	@Override
	public int getIndex() {
		return index;
	}


	@Override
	public void setIndex(int index) {
		this.index = index;
	}


	@Override	
	public Indus getParent() {
		return parent;
	}


	@Override
	public void setParent(Indus parent) {
		this.parent = parent;
	}

	@Override
	public Set<Indus> getChildren() {
		return children;
	}

	
	@Override
	public void setChildren(Set<Indus> children) {
		this.children = children;
	}
	
	@JsonIgnore
	public List<Indus> getEditableChildren() {
		if (children == null || children.isEmpty()) {
			return null;
		}
		List<Indus> editableChildren = null;
		for (Indus industry : children) {
			if (industry.isEditable()) {
				if (editableChildren == null) {
					editableChildren = new ArrayList<Indus>();
				}
				editableChildren.add(industry);
			}
		}
		return editableChildren;
	}
	
	@JsonInclude
	public List<Indus> getAvailableChildren() {
		if (children == null || children.isEmpty()) {
			return null;
		}
		List<Indus> availableChildren = null;
		for (Indus industry : children) {
			if (industry.isAvailable()) {
				if (availableChildren == null) {
					availableChildren = new ArrayList<Indus>();
				}
				availableChildren.add(industry);
			}
		}
		return availableChildren;
	}
	
	public Set<Long> getChildrenId() {
		Set<Long> set = new HashSet<Long>();
		Set<Indus> codeChildren = this.getChildren();
		for (Indus industry : codeChildren) {
			set.add((Long) industry.getId());
		}
		return set;
	}
	
	public void addChildren(Indus industry) {
		if (CollectionUtils.isEmpty(this.children)) {
			this.children = new HashSet<Indus>();
		}
		this.children.add(industry);
	}
	
	@Override
	public String toString() {
		return "Industry [getId()=" + getId() + ", getName()=" + getName() + "]";
	}
}
