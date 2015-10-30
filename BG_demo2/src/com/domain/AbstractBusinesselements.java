package com.domain;

/**
 * AbstractBusinesselements entity provides the base persistence definition of
 * the Businesselements entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBusinesselements implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Boolean isRequired;

	// Constructors

	/** default constructor */
	public AbstractBusinesselements() {
	}

	/** full constructor */
	public AbstractBusinesselements(String name, Boolean isRequired) {
		this.name = name;
		this.isRequired = isRequired;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsRequired() {
		return this.isRequired;
	}

	public void setIsRequired(Boolean isRequired) {
		this.isRequired = isRequired;
	}

}