package com.service;

import java.util.List;

import com.domain.Business;

public interface BusinessMgr {
	public List queryAll();
	public List queryByParentId(Integer id);
	public void addBusiness(Business b);
	public List queryByTitle(String t);
	public Business queryByBid(Integer bid);
	public void del_biz(Integer id);
	public void update(Business b);
}
