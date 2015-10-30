package com.service;

import java.util.List;

import com.domain.Businesselements;

public interface BusinessElementsMgr {
//public void addElement
	public void insertElements(Businesselements b);
	public List queryAll();
	public Businesselements queryById(Integer id);
	public void delete(Integer id);
	public void update(Businesselements e);
}
