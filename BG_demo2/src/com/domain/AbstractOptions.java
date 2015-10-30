package com.domain;

/**
 * AbstractOptions entity provides the base persistence definition of the
 * Options entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOptions implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer questionId;
	private Integer optIndex;
	private String optContent;
	private Integer nextId;
	private Boolean isBusiness;
	private String des;

	// Constructors

	/** default constructor */
	public AbstractOptions() {
	}

	/** minimal constructor */
	public AbstractOptions(Integer questionId, Integer optIndex,
			String optContent, Integer nextId, Boolean isBusiness) {
		this.questionId = questionId;
		this.optIndex = optIndex;
		this.optContent = optContent;
		this.nextId = nextId;
		this.isBusiness = isBusiness;
	}

	/** full constructor */
	public AbstractOptions(Integer questionId, Integer optIndex,
			String optContent, Integer nextId, Boolean isBusiness, String des) {
		this.questionId = questionId;
		this.optIndex = optIndex;
		this.optContent = optContent;
		this.nextId = nextId;
		this.isBusiness = isBusiness;
		this.des = des;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getOptIndex() {
		return this.optIndex;
	}

	public void setOptIndex(Integer optIndex) {
		this.optIndex = optIndex;
	}

	public String getOptContent() {
		return this.optContent;
	}

	public void setOptContent(String optContent) {
		this.optContent = optContent;
	}

	public Integer getNextId() {
		return this.nextId;
	}

	public void setNextId(Integer nextId) {
		this.nextId = nextId;
	}

	public Boolean getIsBusiness() {
		return this.isBusiness;
	}

	public void setIsBusiness(Boolean isBusiness) {
		this.isBusiness = isBusiness;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

}