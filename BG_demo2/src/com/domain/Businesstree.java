package com.domain;

/**
 * Businesstree entity. @author MyEclipse Persistence Tools
 */
public class Businesstree extends AbstractBusinesstree implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Businesstree() {
	}

	/** minimal constructor */
	public Businesstree(String name) {
		super(name);
	}

	/** full constructor */
	public Businesstree(Integer parentId, String name) {
		super(parentId, name);
	}

}
