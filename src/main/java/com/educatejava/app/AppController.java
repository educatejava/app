package com.educatejava.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	@RequestMapping(value = "/example")
	public String getExamplePage(Model model) {
		model.addAttribute("message", "Hello World!");
		return "example";
	}

}
