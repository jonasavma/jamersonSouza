package br.com.academy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.academy.model.Usuario;

@Controller
public class UsuarioController {
   
    @GetMapping("/")
    public ModelAndView login() {
	
	ModelAndView mView = new ModelAndView();
	mView.setViewName("login/login");
	return mView;
	
    }
    
    @GetMapping("/cadastro")
    public ModelAndView cadastrar() {
	
	ModelAndView mView = new ModelAndView();
	mView.addObject("usuarioOBJ",new Usuario());
	mView.setViewName("login/cadastro");
	return mView;
	
    }
    
    
}
