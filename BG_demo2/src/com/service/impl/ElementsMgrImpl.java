package com.service.impl;

import java.util.List;

import com.dao.BusinesselementsDAO;
import com.domain.Businesselements;
import com.service.BusinessElementsMgr;

public class ElementsMgrImpl implements BusinessElementsMgr {

	private BusinesselementsDAO dao=new BusinesselementsDAO();
	@Override
	public void insertElements(Businesselements b) {
		// TODO Auto-generated method stub
		
		dao.save(b);
	}

	@Override
	public List queryAll() {
		// TODO Auto-generated method stub
		
		return dao.findAll();
//		return null;
	}

	@Override
	public Businesselements queryById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
//		System.out.println("ElementMgrImpl.delete() is called");
		dao.delete(queryById( id));
		
	}

	@Override
	public void update(Businesselements e) {
		// TODO Auto-generated method stub
		dao.attachDirty(e);
	}

}
