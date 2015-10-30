package com.domain;

/**
 * Questions entity. @author MyEclipse Persistence Tools
 */
public class Questions extends AbstractQuestions implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Questions() {
	}

	/** full constructor */
	public Questions(String content, String desc) {
		super(content, desc);
	}

}
