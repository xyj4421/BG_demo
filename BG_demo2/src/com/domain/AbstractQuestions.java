package com.domain;

/**
 * AbstractQuestions entity provides the base persistence definition of the
 * Questions entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractQuestions implements java.io.Serializable {

	// Fields

	private Integer id;
	private String content;
	private String des;

	// Constructors

	/** default constructor */
	public AbstractQuestions() {
	}

	/** full constructor */
	public AbstractQuestions(String content, String des) {
		this.content = content;
		this.des = des;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

}