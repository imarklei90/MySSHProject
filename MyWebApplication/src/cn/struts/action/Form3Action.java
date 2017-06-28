package cn.struts.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import cn.struts.entity.User;

/**
 * 封装表单数据(传统方式)
 * @author iustc
 *
 */
public class Form3Action extends ActionSupport {
	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		System.out.println(username + "-----" + password);
		System.out.println(user);
		
		return Action.NONE;
	}
}
