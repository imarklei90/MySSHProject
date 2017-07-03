package cn.ssh.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.ssh.service.UserService;

public class UserAction extends ActionSupport{
	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("Struts和Spring进行整合......");
		userService.add();
		return NONE;
	}


}
