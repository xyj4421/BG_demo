package com.service;

import java.util.List;

import com.domain.Businessdetails;

public interface DetailsMgr {
	public void addDetails(Businessdetails d);
	public List queryByBid(Integer bid);
	public void del_detail_byBizId(Integer bid);
	public void update(Businessdetails d);
}
