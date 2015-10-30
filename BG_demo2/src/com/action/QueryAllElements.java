package com.action;

import java.util.List;

import com.domain.Businesselements;
import com.opensymphony.xwork2.Action;
import com.service.impl.ElementsMgrImpl;

public class QueryAllElements implements Action {


	private List allElements;
	private Integer id;
	private String name;
	private Boolean isRequired;
	private ElementsMgrImpl impl=new ElementsMgrImpl();
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Boolean getIsRequired() {
		return isRequired;
	}


	public void setIsRequired(Boolean isRequired) {
		this.isRequired = isRequired;
	}

	public void delete() {
		System.out.println("------------------------------ɾ��ҵ��Ҫ��");
		ElementsMgrImpl impl=new ElementsMgrImpl();
		System.out.println("Ҫ��id:"+getId());
		impl.delete(getId());
//		return "success";
	}
	public void mod_ele() {
		System.out.println("------------------------------�޸�ҵ��Ҫ��");
		ElementsMgrImpl impl=new ElementsMgrImpl();
		System.out.println("Ҫ��id:"+getId());
		System.out.println("Ҫ������:"+getName());
		System.out.println("����:"+getIsRequired());
		
		Businesselements e = new Businesselements();
		e.setId(getId());
		e.setIsRequired(getIsRequired());
		e.setName(getName());
		impl.update(e);
		//impl.delete(getId());
//		return "success";
	}
	
	public void insert() {
//		System.out.println("name:"+getName());
//		System.out.println("isRequired:"+getIsRequired());
		System.out.println("------------------------------����ҵ��Ҫ��");
		if(getIsRequired()==null){
			setIsRequired(false);
		}else{
			setIsRequired(true);
		}
		
		ElementsMgrImpl impl=new ElementsMgrImpl();
		Businesselements e = new Businesselements();
		e.setIsRequired(getIsRequired());
		e.setName(getName());
		System.out.println("Ҫ������:"+e.getName());
		System.out.println("�Ƿ����:"+e.getIsRequired());
		
		impl.insertElements(e);
		
//		Map<String,Object> result=new HashMap();
//		result.put("success", true);
//		result.put("message", "�����ɹ�");
//		JSONObject json=JSONObject.fromObject(result);
//		return SUCCESS;
	}
	
	
	public String queryAll() throws Exception {
		// TODO Auto-generated method stub
//		ElementsMgrImpl impl=new ElementsMgrImpl();
		System.out.println("------------------------------��ѯ����ҵ��Ҫ��");
		
		allElements=impl.queryAll();
		System.out.println("Ҫ������:"+allElements.size());
		System.out.println("�������:��ѯ�ɹ�");
		
		return SUCCESS;
	}
	public List getAllElements() {
		return allElements;
	}
	public void setAllElements(List allElements) {
		this.allElements = allElements;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

}