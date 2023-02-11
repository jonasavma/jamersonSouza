package br.com.academy.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academy.dao.UsuarioRepository;
import br.com.academy.exception.CriptoExistExcepetion;
import br.com.academy.exception.EmailExistsException;
import br.com.academy.model.Usuario;
import br.com.academy.util.Util;

@Service
public class ServiceUsuario {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public void salvarUsuario(Usuario usuario)throws Exception {
	try {
	    
	    if(usuarioRepository.findByEmail(usuario.getEmail())!=null) {
		throw new EmailExistsException("Já existe um email cadastrado para :"+usuario.getEmail());
	    }
	    
	    usuario.setSenha(Util.md5(usuario.getSenha()));
	    
	}catch (NoSuchAlgorithmException e) {
	   throw new CriptoExistExcepetion("Erro na criptografia da senha.");
	}
	
	usuarioRepository.save(usuario);
    }
    
    
    public Usuario loginUsuario(String nome,String senha)throws ServiceExc {
	Usuario usuarioLogin = usuarioRepository.buscarLogin(nome, senha);
	return usuarioLogin;
    }
    

}
