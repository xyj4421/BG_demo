package com.domain;

/**
 * AbstractBusinesstree entity provides the base persistence definition of the
 * Businesstree entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBusinesstree implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer parentId;
	private String name;

	// Constructors

	/** default constructor */
	public AbstractBusinesstree() {
	}

	/** minimal constructor */
	public AbstractBusinesstree(String name) {
		this.name = name;
	}

	/** full constructor */
	public AbstractBusinesstree(Integer parentId, String name) {
		this.parentId = parentId;
		this.name = name;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}