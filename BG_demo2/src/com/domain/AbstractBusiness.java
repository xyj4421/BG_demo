package com.domain;

/**
 * AbstractBusiness entity provides the base persistence definition of the
 * Business entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBusiness implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private Integer parentId;

	// Constructors

	/** default constructor */
	public AbstractBusiness() {
	}

	/** full constructor */
	public AbstractBusiness(String title, Integer parentId) {
		this.title = title;
		this.parentId = parentId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}