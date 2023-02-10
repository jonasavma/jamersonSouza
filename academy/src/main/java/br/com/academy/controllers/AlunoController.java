package br.com.academy.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.academy.dao.AlunoDAO;
import br.com.academy.model.Aluno;

@Controller
public class AlunoController {

    @Autowired
    private AlunoDAO alunoDAO;

    @GetMapping("/inserirAluno")
    public ModelAndView insertAluno(Aluno aluno) {
	ModelAndView mView = new ModelAndView();
	mView.setViewName("aluno/formAluno");
	mView.addObject("alunoOBJ", new Aluno());

	return mView;

    }

    @PostMapping("/insertAluno")
    public ModelAndView inserirAluno(@Valid Aluno aluno, BindingResult br) {

	ModelAndView mView = new ModelAndView();

	if (br.hasErrors()) {
	    mView.setViewName("aluno/formAluno");
	    mView.addObject("alunoOBJ", aluno);
	} else {

	    mView.setViewName("redirect:/alunos-adicionados");
	    alunoDAO.save(aluno);
	}
	return mView;

    }

    @GetMapping("alunos-adicionados")
    public ModelAndView listagemAluno() {

	ModelAndView mv = new ModelAndView();
	mv.setViewName("aluno/listAluno");
	mv.addObject("alunosList", alunoDAO.findAll());
	return mv;

    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Long id) {
	ModelAndView mView = new ModelAndView();
	mView.setViewName("aluno/alterar");
	Optional<Aluno> aluno = alunoDAO.findById(id);
	mView.addObject("alunoOBJ", aluno.get());

	return mView;

    }

    @PostMapping("/alterar")
    public ModelAndView alterar(Aluno aluno) {

	ModelAndView mView = new ModelAndView();
	alunoDAO.save(aluno);
	mView.setViewName("redirect:/alunos-adicionados");
	return mView;

    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
	alunoDAO.deleteById(id);
	return "redirect:/alunos-adicionados";

    }

    @GetMapping("filtro-alunos")
    public ModelAndView filtroAlunos() {

	ModelAndView mView = new ModelAndView();
	mView.setViewName("aluno/filtrosAlunos");
	return mView;

    }

    @GetMapping("alunos-ativos")
    public ModelAndView listagemAlunoAtivos() {

	ModelAndView mv = new ModelAndView();
	mv.setViewName("aluno/alunos-ativos");
	mv.addObject("alunosAtivosOBJ", alunoDAO.findByStatusAtivos());
	return mv;

    }

    @GetMapping("alunos-inativos")
    public ModelAndView listagemAlunoInativos() {

	ModelAndView mv = new ModelAndView();
	mv.setViewName("aluno/alunos-inativos");
	mv.addObject("alunosInativosOBJ", alunoDAO.findByStatusInativos());
	return mv;

    }

    @GetMapping("alunos-cancelados")
    public ModelAndView listagemAlunoCancelados() {

	ModelAndView mv = new ModelAndView();
	mv.setViewName("aluno/alunos-cancelados");
	mv.addObject("alunoscanceladosOBJ", alunoDAO.findByStatusCancelados());
	return mv;

    }

    @GetMapping("alunos-trancados")
    public ModelAndView listagemAlunoTrancados() {

	ModelAndView mv = new ModelAndView();
	mv.setViewName("aluno/alunos-trancados");
	mv.addObject("alunostrancadosOBJ", alunoDAO.findByStatusTrancados());
	return mv;
    }

    @PostMapping("pesquisar-aluno")
    public ModelAndView pesquisarAluno(@RequestParam(required = false) String nome) {
	ModelAndView mView = new ModelAndView();
	List<Aluno> listAluno;

	if (nome == null || nome.trim().isEmpty()) {
	    listAluno = alunoDAO.findAll();
	} else {
	    listAluno = alunoDAO.findByNomeContainingIgnoreCase(nome);
	}

	mView.addObject("listaDeAlunosOBJ", listAluno);
	mView.setViewName("aluno/pesquisa-resultado");

	return mView;

    }

}
