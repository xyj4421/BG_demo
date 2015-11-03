package com.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.domain.Business;
import com.domain.Businessdetails;
import com.domain.Businesselements;
import com.domain.Questions;
import com.opensymphony.xwork2.Action;
import com.service.impl.BusinessMgrImpl;
import com.service.impl.DetailsMgrImpl;
import com.service.impl.ElementsMgrImpl;

public class BusinessAction implements Action {

	private List allBusiness;
	private List business;
	private Integer nodeId;
	private String title;
	private String details ;
	private Integer bid;
	private String b;
	private Integer id;
	private Integer parentId;
	
	public String getB() {
		return b;
	}




	public void setB(String b) {
		this.b = b;
	}




	public String getDetails() {
		return details;
	}




	public void setDetails(String details) {
		this.details = details;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public Integer getNodeId() {
		return nodeId;
	}




	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	public void del_biz_act(){
		BusinessMgrImpl impl=new BusinessMgrImpl();
		DetailsMgrImpl detailsImpl=new DetailsMgrImpl();
		System.out.println("------------------------------删除业务");
		System.out.println("业务id:"+getId());
		System.out.println("业务标题:"+getTitle());
		System.out.println("所属分类id:"+getParentId());
		impl.del_biz(getId());
		System.out.println("------------------------------删除业务明细");
		System.out.println("所属业务id:"+getId());
		detailsImpl.del_detail_byBizId(getId());
		
	}



	public String queryByNode() throws Exception {

		System.out.println("------------------------------查询分类下的业务");
		BusinessMgrImpl impl=new BusinessMgrImpl();
		business=impl.queryByParentId(getNodeId());
		System.out.println("业务数量:"+business.size());
		System.out.println("--操作结果:查询分类下的业务成功");
		
//		for(Iterator i = business.iterator();i.hasNext();){
//			Business n=(Business)i.next();
//			System.out.println(n.getId()+"  "+n.getTitle()+"  "+n.getParentId());
//		}
		return SUCCESS;
	}
	public void addBusiness(){
		BusinessMgrImpl impl=new BusinessMgrImpl();
		DetailsMgrImpl detailsImpl=new DetailsMgrImpl();
		Business b = new Business();

		b.setTitle(getTitle());
		b.setParentId(getNodeId());
		System.out.println("------------------------------新增业务");
//		String title = new String(b.getTitle().getBytes("utf-8"),"gb2312");
		System.out.println("业务名称:"+b.getTitle()+"  \n所属分类id:"+b.getParentId());
		impl.addBusiness(b);
		Integer businessId = null;
		List<Business> listBusiness = impl.queryByTitle(getTitle());
//		System.out.println("listBusiness.size():"+listBusiness.size());
		Iterator<Business> item=listBusiness.iterator();
		while(item.hasNext()){
			Business i=item.next();
			if(i.getParentId().equals(getNodeId())){
				businessId=i.getId();
				
				break;
			}
			
		}
		System.out.println("------------------------------新增业务明细");
//		System.out.println("业务id:"+businessId);
		JSONArray jsonArray = JSONArray.fromObject(getDetails());
//		System.out.println("bbb"+getDetails());
//		System.out.println("jsonArray.size():"+jsonArray.size());
		for(int i=0;i<jsonArray.size();i++){
			JSONObject jsonObj = jsonArray.getJSONObject(i);

//			System.out.println(jsonObj.get("id")+" "+jsonObj.get("isRequired")+" "+jsonObj.get("name")+" "+jsonObj.get("content"));
			String element = (String)jsonObj.get("content");
			if(element==null||element.equals("")){
				element=" ";
			}
			Businessdetails d =new Businessdetails();
			d.setElementId(new Integer(jsonObj.get("id").toString()));
//			d.setElement(jsonObj.get("content").toString()==null?"":jsonObj.get("content").toString());
			d.setElement(element);
			d.setBusinessId(businessId);
			d.setDes("");
//			System.out.println("------");
			System.out.println("业务要素id:"+d.getElementId());
			System.out.println("所属业务id:"+d.getBusinessId());
			System.out.println("业务要素内容:"+d.getElement());
//			System.out.println(d.getElementId()+"  "+d.getElement()+"  "+d.getBusinessId());
			detailsImpl.addDetails(d);
		}
		
	}
	
	
	
	public List getBusiness() {
		return business;
	}




	public void setBusiness(List business) {
		this.business = business;
	}




	public String queryAll() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BusinessAction.queryAll() is called");
		BusinessMgrImpl impl=new BusinessMgrImpl();
		allBusiness=impl.queryAll();
//		setAllElements(impl.queryAll());
//		System.out.println("query action is called");
		System.out.println("there is "+allBusiness.size()+" Business.");
//		map.put("row",allElements);
//		JSONObject json=JSONObject.fromObject(map);
//		ActionContext.getContext().getValueStack().set("json", json);
//		System.out.println(json.toString());
		return SUCCESS;
	}
	public List getAllBusiness() {
		return allBusiness;
	}
	public void setAllBusiness(List allBusiness) {
		this.allBusiness = allBusiness;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String queryByBid(){
		BusinessMgrImpl impl=new BusinessMgrImpl();
		b = JSONObject.fromObject(impl.queryByBid(getBid())).toString();
		return SUCCESS;
	}

	public void mod_biz_act(){
		System.out.println("------------------------------修改业务");
		BusinessMgrImpl impl=new BusinessMgrImpl();
//		ElementsMgrImpl impl=new ElementsMgrImpl();
		System.out.println("业务id:"+getId());
		System.out.println("业务名称:"+getTitle());
//		System.out.println("必填:"+getIsRequired());
		Business b = new Business();
		b.setId(getId());
		b.setParentId(getParentId());
		b.setTitle(getTitle());
		impl.update(b);
		
		System.out.println("------------------------------修改业务明细");
//		System.out.println("业务id:"+businessId);
		JSONArray jsonArray = JSONArray.fromObject(getDetails());
//		System.out.println("bbb"+getDetails());
//		System.out.println("jsonArray.size():"+jsonArray.size());
		
		DetailsMgrImpl detailMgrImpl = new DetailsMgrImpl();
		for(int i=0;i<jsonArray.size();i++){
			JSONObject jsonObj = jsonArray.getJSONObject(i);

//			System.out.println(jsonObj.get("id")+" "+jsonObj.get("name")+" "+jsonObj.get("isRequired")+" "+jsonObj.get("content"));
			
			System.out.println("明细id:"+jsonObj.get("id"));
			System.out.println("所属业务id:"+getId());
			System.out.println("要素id:"+jsonObj.get("elementId"));
			System.out.println("要素内容:"+jsonObj.get("content"));
//			System.out.println("明细id:"+jsonObj.get("id"));
			
			
			Businessdetails d = new Businessdetails();
			d.setId((Integer)jsonObj.get("id"));
			d.setBusinessId(getId());
			d.setElementId((Integer)jsonObj.get("elementId"));
			d.setElement(jsonObj.get("content").toString());
			
			detailMgrImpl.update(d);

		}
		
	}


	public Integer getBid() {
		return bid;
	}




	public void setBid(Integer bid) {
		this.bid = bid;
	}




	public Integer getParentId() {
		return parentId;
	}




	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}

}
