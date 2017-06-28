package cn.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.struts.entity.User;
/**
 * 使用模型驱动的方式获取表单数据
 * @author iustc
 *
 */
public class Form5Action extends ActionSupport implements ModelDriven<User> {

	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println(user);
		return NONE;
	}

}
