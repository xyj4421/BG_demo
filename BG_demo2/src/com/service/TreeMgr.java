package com.service;

import java.util.List;

import com.domain.Businesselements;
import com.domain.Businesstree;

public interface TreeMgr {
	public List queryTree();
	public void addNode(Businesstree b);
	public void deleteNode(Integer id);
	public void update(Businesstree t);
}
