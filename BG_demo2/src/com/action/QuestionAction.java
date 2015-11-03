package com.action;

import java.util.List;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

import com.domain.Questions;
import com.opensymphony.xwork2.Action;
import com.service.impl.QuestionMgrImpl;

public class QuestionAction implements Action {

	private QuestionMgrImpl impl = new QuestionMgrImpl();
	private JSON qTree;
	private List question;
	private JSON questJson;
	private String q;
	private Integer id;
	
	
public JSON getQuestJson() {
		return questJson;
	}
	public void setQuestJson(JSON questJson) {
		this.questJson = questJson;
	}
private String content;

	public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
	public List getQuestion() {
		return question;
	}
	public void setQuestion(List question) {
		this.question = question;
	}
	public JSON getqTree() {
		return qTree;
	}
	public void setqTree(JSON qTree) {
		this.qTree = qTree;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public String questionTree() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QuestionAction.questionTree() is called");
		qTree = impl.queryTree();
		System.out.println(qTree);
		return SUCCESS;
	}
	public String queryQuestion() throws Exception {
		System.out.println("------------------------------查询导航问题");
		// TODO Auto-generated method stub
//		System.out.println("QuestionAction.queryQuestion() is called");
//		qTree = impl.queryTree();
//		System.out.println(qTree);
		question=impl.queryAll();
		System.out.println("导航问题数量:"+question.size());
		System.out.println("--操作结果:查询导航问题成功");
		return SUCCESS;
	}
	public void insertQuestion() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("------------------------------新增导航问题");
		Questions q = new Questions();
		q.setContent(getContent());
		System.out.println("导航问题内容:"+q.getContent());
		impl.insertQuestion(q);
	}
	
	public String questionToJson() throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("QuestionAction.questionToJson() is called");
//		qTree = impl.queryTree();
//		System.out.println(qTree);
//		question=impl.queryAll();
		questJson=impl.questionToJson();
		
		return SUCCESS;
	}
	public String queryById(){
		System.out.println("QuestionAction.queryByid() is called");
		q=JSONObject.fromObject(impl.queryById(getId())).toString();
//		q=impl.queryById(getId());
		System.out.println(q);
//		return q.toString();
		return SUCCESS;
	}
	public void del_qst_act(){
		System.out.println("------------------------------删除导航问题");
		System.out.println("问题id:"+getId());
		System.out.println("问题内容:"+getContent());
		impl.del_qst_act(id);
	}
	public void mod_qst_act(){
		System.out.println("------------------------------修改导航问题");
		System.out.println("问题id:"+getId());
		System.out.println("问题内容:"+getContent());
		Questions q = new Questions();
		q.setId(getId());
		q.setContent(getContent());
		impl.update(q);
		
	}
	
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
