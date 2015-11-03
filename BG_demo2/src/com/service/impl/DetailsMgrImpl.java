package com.service.impl;

import java.util.Iterator;
import java.util.List;

import com.dao.BusinessdetailsDAO;
import com.domain.Businessdetails;
import com.service.DetailsMgr;

public class DetailsMgrImpl implements DetailsMgr {
	private BusinessdetailsDAO dao=new BusinessdetailsDAO();
	@Override
	public void addDetails(Businessdetails d) {
		// TODO Auto-generated method stub
//		System.out.println("DetailsMgrImpl.addDetails() is called");
		dao.save(d);
	}
	@Override
	public List queryByBid(Integer bid) {
		// TODO Auto-generated method stub
		return dao.findByBusinessId(bid);
	}
	@Override
	public void del_detail_byBizId(Integer bid) {
		// TODO Auto-generated method stub
//		dao.findByBusinessId(bid);
		List<Businessdetails> detailList = dao.findByBusinessId(bid);
		Iterator<Businessdetails> item = detailList.iterator();
		while(item.hasNext()){
			dao.delete(dao.findById(item.next().getId()));
		}
		
		
//		dao.del_detail_byBizId(bid);
	}
	@Override
	public void update(Businessdetails d) {
		// TODO Auto-generated method stub
		dao.attachDirty(d);
	}

}
