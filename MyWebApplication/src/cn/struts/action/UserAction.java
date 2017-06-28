package cn.struts.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	public String add(){
		System.out.println("add Action...");
		return "global";
	}
	
	public String update(){
		System.out.println("update Action");
		return "global";
	}
	
}
