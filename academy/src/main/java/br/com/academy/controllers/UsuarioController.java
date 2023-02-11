package br.com.academy.controllers;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.academy.dao.UsuarioRepository;
import br.com.academy.model.Aluno;
import br.com.academy.model.Usuario;
import br.com.academy.service.ServiceExc;
import br.com.academy.service.ServiceUsuario;
import br.com.academy.util.Util;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ServiceUsuario serviceUsuario;

    @GetMapping("/")
    public ModelAndView login() {

	ModelAndView mView = new ModelAndView();
	mView.setViewName("login/login");
	mView.addObject("usuarioOBJ", new Usuario());
	return mView;

    }
    
   
    
    @GetMapping("/index")
    public ModelAndView index() {
	ModelAndView mView = new ModelAndView();
	mView.setViewName("home/index");
	mView.addObject("alunoHomeOBJ", new Aluno());
	return mView;
    }

    @GetMapping("/cadastro")
    public ModelAndView cadastrar() {

	ModelAndView mView = new ModelAndView();
	mView.addObject("usuarioOBJ", new Usuario());
	mView.setViewName("login/cadastro");
	return mView;

    }

    @PostMapping("/salvarUsuario")
    public ModelAndView cadastarUsuario(Usuario usuario) throws Exception {

	ModelAndView mView = new ModelAndView();
	serviceUsuario.salvarUsuario(usuario);
	mView.setViewName("redirect:/");
	return mView;

    }

    @PostMapping("/login")
    public ModelAndView login(@Valid Usuario usuario, BindingResult br, HttpSession session)
	    throws NoSuchAlgorithmException, ServiceExc {

	ModelAndView mView = new ModelAndView();
	mView.addObject("usuario", new Usuario());

	if (br.hasErrors()) {
	    mView.setViewName("login/login");
	}

	Usuario usuarioLogin = serviceUsuario.loginUsuario(usuario.getNome(), Util.md5(usuario.getSenha()));

	if (usuarioLogin == null) {
	    mView.addObject("msg", "Usuario não encontrado .Tente novamente");
	} else {
	    session.setAttribute("usuarioLogado", usuarioLogin);
	    return index();
	}

	return mView;

    }

   

}
