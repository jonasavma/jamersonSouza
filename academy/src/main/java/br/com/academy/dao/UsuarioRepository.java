package br.com.academy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.com.academy.model.Usuario;

@Transactional
public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{
    
    
    @Query("select u from Usuario u where u.email = :email " )
    public   Usuario findByEmail(String email);
    
    
    @Query("select usuario from Usuario usuario where usuario.nome = :nome  and usuario.senha= :senha" )
    public Usuario buscarLogin(String nome,String senha);

}
