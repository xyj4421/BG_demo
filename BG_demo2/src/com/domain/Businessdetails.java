package com.domain;

/**
 * Businessdetails entity. @author MyEclipse Persistence Tools
 */
public class Businessdetails extends AbstractBusinessdetails implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Businessdetails() {
	}

	/** minimal constructor */
	public Businessdetails(Integer businessId) {
		super(businessId);
	}

	/** full constructor */
	public Businessdetails(Integer elementId, String element, String desc,
			Integer businessId) {
		super(elementId, element, desc, businessId);
	}

}
