package br.com.academy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {
   
    @GetMapping("/")
    public ModelAndView login() {
	
	ModelAndView mView = new ModelAndView();
	
	mView.setViewName("login/login");
	return mView;
	
    }
    
    
}