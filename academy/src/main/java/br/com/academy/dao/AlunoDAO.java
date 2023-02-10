package br.com.academy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.academy.model.Aluno;


public interface AlunoDAO extends JpaRepository<Aluno, Long> {
    
    
    @Query("select a from Aluno a where a.status='ATIVO' ")
    public List<Aluno>  findByStatusAtivos();
    
    
    @Query("select a from Aluno a where a.status='INATIVO' ")
    public List<Aluno>  findByStatusInativos();

    
    @Query("select a from Aluno a where a.status='CANCELAO' ")
    public List<Aluno>  findByStatusCancelados();
    
    @Query("select a from Aluno a where a.status='TRANCADO' ")
    public List<Aluno>  findByStatusTrancados();
    
    
    public  List<Aluno> findByNomeContainingIgnoreCase(String nome);
    
    
}
