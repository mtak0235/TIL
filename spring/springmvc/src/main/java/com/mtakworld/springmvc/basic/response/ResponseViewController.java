package com.mtakworld.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {
	@RequestMapping("/response-view-v1")
	public ModelAndView responseViewV1() {
		ModelAndView mv = new ModelAndView("response/hello").addObject("data", "ciao!");
		return mv;
	}

	@RequestMapping("/response-view-v2")
	public String responseViewV2(Model model) {
		model.addAttribute("data", "ciao!");
		return "response/hello";
	}

	@RequestMapping("/reponse/hello")
	public void hello(Model model) {
		model.addAttribute("data", "ciao!");
	}
}
