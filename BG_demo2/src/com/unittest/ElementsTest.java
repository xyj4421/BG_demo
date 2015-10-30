package com.unittest;

import java.util.Iterator;
import java.util.List;

import com.domain.Businesselements;
import com.service.impl.ElementsMgrImpl;

public class ElementsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		insertTest();
		queryAll();
		
	}
	public static void insertTest(){
		Businesselements e=new Businesselements();
		e.setName("test");
		e.setIsRequired(false);
		ElementsMgrImpl impl=new ElementsMgrImpl();
		impl.insertElements(e);
	}
	public static void queryAll(){
		ElementsMgrImpl impl=new ElementsMgrImpl();
		List l=impl.queryAll();
		Iterator i=l.iterator();
		while(i.hasNext())
		{
			Businesselements b=(Businesselements)i.next();
			System.out.println(b.getId()+" "+b.getName()+" "+b.getIsRequired());
		}
//		return impl.queryAll();
		
	}

}
