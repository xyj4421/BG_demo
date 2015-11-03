package com.service;

import java.util.List;

import com.domain.Options;

public interface OptionsMgr {
	public List queryAll();
	public List queryByQuestionId(Integer qid);
	public void insertOption(Options o);
	public void del_opt(Integer id);
}
