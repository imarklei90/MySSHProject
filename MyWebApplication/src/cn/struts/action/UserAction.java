package cn.struts.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	public String add(){
		System.out.println("add Action...");
		return "add";
	}
	
	public String update(){
		System.out.println("update Action");
		return "update";
	}
	
}
