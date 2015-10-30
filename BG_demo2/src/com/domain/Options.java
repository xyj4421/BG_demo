package com.domain;

/**
 * Options entity. @author MyEclipse Persistence Tools
 */
public class Options extends AbstractOptions implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Options() {
	}

	/** minimal constructor */
	public Options(Integer questionId, Integer index, String option,
			Integer nextId, Boolean isBusiness) {
		super(questionId, index, option, nextId, isBusiness);
	}

	/** full constructor */
	public Options(Integer questionId, Integer index, String option,
			Integer nextId, Boolean isBusiness, String desc) {
		super(questionId, index, option, nextId, isBusiness, desc);
	}

}
