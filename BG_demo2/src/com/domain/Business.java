package com.domain;

/**
 * Business entity. @author MyEclipse Persistence Tools
 */
public class Business extends AbstractBusiness implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Business() {
	}

	/** full constructor */
	public Business(String title, Integer parentId) {
		super(title, parentId);
	}

}
