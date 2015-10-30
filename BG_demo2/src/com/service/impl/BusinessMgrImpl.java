package com.service.impl;

import java.util.List;

import com.dao.BusinessDAO;
import com.domain.Business;
import com.service.BusinessMgr;

public class BusinessMgrImpl implements BusinessMgr{

	private BusinessDAO dao=new BusinessDAO();
	@Override
	public List queryAll() {
		// TODO Auto-generated method stub
		System.out.println("--BusinessMgrImpl.queryAll() is called");
		return dao.findAll();
	}
	@Override
	public List queryByParentId(Integer id) {
		// TODO Auto-generated method stub
		
//		System.out.println("--BusinessMgrImpl.queryByParentId() is called");
		return dao.findByParentId(id);
	}
	@Override
	public void addBusiness(Business b) {
//		System.out.println("--BusinessMgrImpl.addBusiness() is called");
//		System.out.println(b.getTitle()+"  "+b.getParentId());
		// TODO Auto-generated method stub
		dao.save(b);
		
		
	}
	@Override
	public List queryByTitle(String t) {
		// TODO Auto-generated method stub
		
		return dao.findByTitle(t);
	}
	@Override
	public Business queryByBid(Integer bid) {
		// TODO Auto-generated method stub
		
		return dao.findById(bid);
	}
	@Override
	public void del_biz(Integer id) {
		// TODO Auto-generated method stub
		dao.delete(dao.findById(id));
	}

	

}
