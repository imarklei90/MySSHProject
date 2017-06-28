package cn.struts.action;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 创建表单数据的方式二：
 * 创建ServletActionContext对象
 * @author iustc
 *
 */
public class Form2Action extends ActionSupport {
	
	public String execute() throws Exception {
		// 使用ServletActionContext获取表单数据
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + ":" + password);
		
		return Action.NONE;
	}
}
