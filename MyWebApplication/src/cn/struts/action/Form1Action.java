package cn.struts.action;

import java.util.Arrays;
import java.util.Map;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 获取表单数据的方式一：
 * 创建ActionContext对象
 * @author iustc
 */
public class Form1Action extends ActionSupport{
	@Override
	public String execute() throws Exception {
		//创建ActionContxt对象
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> maps = actionContext.getParameters();
		for(String key : maps.keySet()){
			Object[] values = (Object[]) maps.get(key);
			System.out.println(Arrays.toString(values));
		}
		
		return Action.NONE;
	}
}
