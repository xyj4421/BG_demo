package com.service;

import java.util.List;

import net.sf.json.JSON;

import com.domain.Questions;

public interface QuestionMgr {
	public List queryAll();
	public void insertQuestion(Questions q);
	public JSON questionToJson();
	public Questions queryById(Integer id);
}
