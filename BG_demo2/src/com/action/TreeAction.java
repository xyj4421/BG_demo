package com.action;

import java.util.List;

import net.sf.json.JSON;

import com.domain.Businesselements;
import com.domain.Businesstree;
import com.opensymphony.xwork2.Action;
import com.service.impl.ElementsMgrImpl;
import com.service.impl.TreeMgrImpl;

public class TreeAction implements Action{
	private List<Businesstree>  Businesstree;
	private JSON jsonTree;
	private String name;
	private Integer id;
	private Integer nodeId;
	private Integer parentId;
	private String title;
	
	public Integer getNodeId() {
		return nodeId;
	}
	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
public void	mod_classify_act(){
	System.out.println("------------------------------�޸�ҵ�����");
	TreeMgrImpl impl=new TreeMgrImpl();
	System.out.println("����id:"+getId());
	System.out.println("��������:"+getName());
//	System.out.println("�ϼ�����id:"+getParentId());
	
	Businesstree t = new Businesstree();
	t.setId(getId());
//	e.setIsRequired(getIsRequired());
	t.setParentId(getParentId());
	t.setName(getName());
	impl.update(t);
	}
public JSON getJsonTree() {
		return jsonTree;
	}

	public void setJsonTree(JSON jsonTree) {
		this.jsonTree = jsonTree;
	}
	//����ҵ�����
	public void addNode(){
		System.out.println("------------------------------����ҵ�����");
//		System.out.println(getId()+"   "+getName());
		TreeMgrImpl impl=new TreeMgrImpl();
		Businesstree b = new Businesstree();
		System.out.println("��������:"+getName());
		System.out.println("�ϼ�����id:"+getId());
		
		b.setName(getName());
		b.setParentId(getId());
		impl.addNode(b);
		
	}
	public void deleteNode(){
//		System.out.println(getId());
		TreeMgrImpl impl=new TreeMgrImpl();
		impl.deleteNode(getId());
//		Businesstree b = new Businesstree();
//		b.setName(getName());
//		b.setParentId(getId());
//		impl.addNode(b);
	}
	
public String queryTree(){
	System.out.println("------------------------------��ѯҵ���������Ŀ¼");
	TreeMgrImpl impl=new TreeMgrImpl();
	
//	System.out.println("--TreeAction.queryTree() is called");
	jsonTree=impl.createTree(impl.queryTree(),0);
//	jsonTree.size();
	System.out.println("��������:"+jsonTree.size());
	System.out.println("--�������:��ѯ�ɹ�");
	
//	jsonTree= impl.createTree();
//	System.out.println("-----------------------"+jsonTree);
	return SUCCESS;
}

@Override
public String execute() throws Exception {
	// TODO Auto-generated method stub
	return null;
}
public Integer getParentId() {
	return parentId;
}
public void setParentId(Integer parentId) {
	this.parentId = parentId;
}
}