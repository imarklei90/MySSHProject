package cn.springmvc.annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/hellospringmvc")
	public ModelAndView hello(HttpServletRequest req, HttpServletResponse resp){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", "springmvc annotation");
		modelAndView.setViewName("hello");
		return modelAndView;
	}
}
