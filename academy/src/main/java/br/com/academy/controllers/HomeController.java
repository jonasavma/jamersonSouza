package br.com.academy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.academy.model.Aluno;

@Controller
public class HomeController {

    @GetMapping("/index")
    public ModelAndView index() {
	ModelAndView mView = new ModelAndView();
	mView.setViewName("home/index");
	mView.addObject("alunoHomeOBJ",new Aluno());
	return mView;
    }

}
