package com.service.impl;

import java.util.List;

import com.dao.OptionsDAO;
import com.domain.Options;
import com.service.OptionsMgr;

public class OptionsMgrImpl implements OptionsMgr {

	private OptionsDAO dao = new OptionsDAO();
	@Override
	public List queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public JSON queryByQuestionId(Integer qid) {
//		// TODO Auto-generated method stub
//		
//		return JSONArray.fromObject(dao.findByQuestionId(qid));
//	}
	
	public List queryByQuestionId(Integer qid) {
		// TODO Auto-generated method stub
		System.out.println("OptionsMgrImpl.queryByQuestionId() is called");
		return dao.findByQuestionId(qid);
	}

	@Override
	public void insertOption(Options o) {
		// TODO Auto-generated method stub
		dao.save(o);
	}

}
