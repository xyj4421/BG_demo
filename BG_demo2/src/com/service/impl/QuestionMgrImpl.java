package com.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import com.dao.QuestionsDAO;
import com.domain.Options;
import com.domain.Questions;
import com.service.QuestionMgr;

public class QuestionMgrImpl implements QuestionMgr {

	private QuestionsDAO dao= new QuestionsDAO();

	public JSON queryTree() {
		System.out.println("QuestionMgrImpl.queryTree() is called");
		// TODO Auto-generated method stub
		List<Questions> questionList = queryAll();
		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = null;
		
//		OptionsDAO optionsDao = new OptionsDAO();
//		optionsImpl.queryByQuestionId(qid)
		
		
		for(Questions q:questionList)
		{
			map=new HashMap<String,Object>();
			map.put("id", q.getId().toString());
			map.put("content", q.getContent());
			if(q.getDes()==null){
//				System.out.println("+q.getDesc():"+q.getDesc());
				map.put("desc", "");
			}else{
				map.put("desc", q.getDes());
			}
			
//			System.out.println(optionsImpl.queryByQuestionId(q.getId()));
//			map.put("isBusiness", false);
//			map.put("nextId", "");
			map.put("children", optionsToJSON(q.getId()));
			listMap.add(map);
		}
		System.out.println(JSONArray.fromObject(listMap));
		return JSONArray.fromObject(listMap);
	}
	public JSON optionsToJSON(Integer qid){
		OptionsMgrImpl optionsImpl	= new OptionsMgrImpl(); 
		List<Options> options = optionsImpl.queryByQuestionId(qid);
		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = null;
		for(Options o:options)
		{
			map=new HashMap<String,Object>();
			map.put("id", qid.toString()+o.getOptIndex().toString());
			map.put("content",o.getOptContent());
			if(o.getDes()==null){
//				System.out.println("+q.getDesc():"+q.getDesc());
				map.put("desc", "");
			}else{
				map.put("desc", o.getDes());
			}
//			
//			map.put("isBusiness", o.getIsBusiness());
//			map.put("nextId", o.getNextId());
			listMap.add(map);
		}
		return JSONArray.fromObject(listMap);
	}

	@Override
	public List queryAll() {
		// TODO Auto-generated method stub
//		System.out.println("QuestionMgrImpl.queryAll() is called");
		return dao.findAll();
	}
	@Override
	public void insertQuestion(Questions q) {
		// TODO Auto-generated method stub
//		System.out.println("QuestionMgrImpl.insertQuestion() is called");
		dao.save(q);
	}
	@Override
	public JSON questionToJson() {
//		System.out.println("QuestionMgrImpl.questionToJson() is called");
		// TODO Auto-generated method stub
		List<Questions> questionList = queryAll();
		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = null;
		for(Questions q:questionList)
		{
			map=new HashMap<String,Object>();
			map.put("id", q.getId().toString());
			map.put("text", q.getContent());
			
			listMap.add(map);
		}
//		System.out.println(JSONArray.fromObject(listMap));
		return JSONArray.fromObject(listMap);
	}
	@Override
	public Questions queryById(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("QuestionMgrImpl.queryById() is called");
		return dao.findById(id);
	}
	@Override
	public void del_qst_act(Integer id) {
		// TODO Auto-generated method stub
		dao.delete(dao.findById(id));
	}
	@Override
	public void update(Questions q) {
		// TODO Auto-generated method stub
		dao.attachDirty(q);
	}

}
