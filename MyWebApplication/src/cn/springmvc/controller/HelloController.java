package cn.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		// 封装要显示到视图中的数据
		modelAndView.addObject("msg","hellospringmvc");
		// 设置视图的名称
		modelAndView.setViewName("hello");
		return modelAndView;
	}
}
