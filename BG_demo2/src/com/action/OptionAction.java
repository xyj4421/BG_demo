package com.action;

import java.util.List;

import com.domain.Options;
import com.opensymphony.xwork2.Action;
import com.service.impl.OptionsMgrImpl;

public class OptionAction implements Action {

	private Integer qid;
	private Integer nextId;
	private String optContent;
	private Boolean isBusiness;
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNextId() {
		return nextId;
	}

	public void setNextId(Integer nextId) {
		this.nextId = nextId;
	}

	public String getOptContent() {
		return optContent;
	}

	public void setOptContent(String optContent) {
		this.optContent = optContent;
	}

	public Boolean getIsBusiness() {
		return isBusiness;
	}

	public void setIsBusiness(Boolean isBusiness) {
		this.isBusiness = isBusiness;
	}
	private OptionsMgrImpl impl = new OptionsMgrImpl();
	private List question;
	public List getQuestion() {
		return question;
	}

	public void setQuestion(List question) {
		this.question = question;
	}

	public Integer getQid() {
		return qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String queryByQid(){
//		System.out.println("OptionAction.queryByQid() is called");
		question=impl.queryByQuestionId(getQid());
		
		return SUCCESS;
	}
	public void insertOption(){
		System.out.println("------------------------------����ѡ��");
		Options o = new Options();
		if(getIsBusiness()==null){
			setIsBusiness(false);
		}else{
			setIsBusiness(true);
		}
		o.setIsBusiness(getIsBusiness());
		o.setNextId(getNextId());
		o.setOptContent(getOptContent());
		o.setOptIndex(1);
		o.setQuestionId(getQid());
//		System.out.println("ѡ������:"+o.getOptContent());
//		System.out.println("�Ƿ�ָ��ҵ��:"+o.getIsBusiness());
//		System.out.println("ָ��id:"+o.getNextId());
//		System.out.println("������������id:"+o.getQuestionId());
		
		impl.insertOption(o);
	}
	public void del_opt_act(){
		System.out.println("------------------------------ɾ��ѡ��");
		System.out.println("ѡ��id:"+getId());
		impl.del_opt(getId());
//		System.out.println("�Ƿ�ָ��ҵ��:"+o.getIsBusiness());
//		System.out.println("ָ��id:"+o.getNextId());
//		System.out.println("������������id:"+o.getQuestionId());
		
		
		
	}
	public String nextStep(){
		if(getIsBusiness()){
			System.out.print(getIsBusiness());
			
		}else{
			System.out.print(getIsBusiness());
		}
		
		return SUCCESS;
	}
	
}
