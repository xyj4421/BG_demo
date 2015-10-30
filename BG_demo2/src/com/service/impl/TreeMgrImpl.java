package com.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import com.dao.BusinesstreeDAO;
import com.domain.Businesstree;
import com.service.TreeMgr;

public class TreeMgrImpl implements TreeMgr {

	private BusinesstreeDAO dao=new BusinesstreeDAO();
	@Override
	public List queryTree() {
		// TODO Auto-generated method stub
		
		return dao.findAll();
	}
	public JSON createTree(){
		List<Businesstree>	tree=dao.findAll();
		List<Map<String,Object>> lm = new ArrayList<Map<String,Object>>();
		Map<String ,Object> map=new HashMap<String,Object>();
		Iterator<Businesstree> item = tree.iterator();
		while(item.hasNext()){
			Businesstree b = item.next();
			if(b.getId().equals(new Integer(0))){
				map.put("id", b.getId());
				map.put("text", b.getName());
//				map.put("children", value)
				lm.add(map);
			}
			
		}
		System.out.println(JSONArray.fromObject(lm));
		return JSONArray.fromObject(lm);
	}
	public JSON createTree(List<Businesstree> tree,Integer pid){
//		System.out.println("tree size is :"+tree.size());
		List<Map<String,Object>> lmjson = new ArrayList<Map<String,Object>>();
		Map<String,Object> jsonMap = null;
		for(Businesstree node:tree){
//			System.out.println("pid is :"+pid);
//			System.out.println("node.getParentId() is :"+node.getParentId());
			if(pid.equals(node.getParentId())){
				jsonMap=new HashMap<String,Object>();
				jsonMap.put("id", node.getId());
				jsonMap.put("text", node.getName());
				jsonMap.put("state", "open");
				
//				System.out.println("jsonMap.toString() :"+jsonMap.toString());
				jsonMap.put("children", createTree(tree,node.getId()));
				lmjson.add(jsonMap);
			}
		}
		
//		System.out.println(JSONArray.fromObject(lmjson));
		return JSONArray.fromObject(lmjson);
	}
	public void addNode(Businesstree b){
		dao.save(b);
	}
	@Override
	public void deleteNode(Integer id) {
		// TODO Auto-generated method stub
//		System.out.println("dddd");
		dao.delete(dao.findById(id));
		
	}
	@Override
	public void update(Businesstree t) {
		// TODO Auto-generated method stub
		dao.attachDirty(t);
	}
	
	
}
