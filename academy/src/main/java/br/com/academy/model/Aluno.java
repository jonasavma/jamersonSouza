package br.com.academy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.academy.enums.Curso;
import br.com.academy.enums.Status;

@Entity
public class Aluno implements Serializable {

    private static final long serialVersionUID = -6837975360702325268L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
  
    @Column(name = "nome")
    @Size(min = 5, max = 35, message = "O nome deve conter no mínimo 5 caracteres")
    @NotBlank(message = "O nome não pode ser vazio!")
    private String nome;

    @Enumerated(EnumType.STRING)
    private Curso curso;

    @NotNull(message = "Click no botão para gerar matricula. ")
    private String matricula;

    @Enumerated(EnumType.STRING)
    private Status status;

    @NotBlank(message = "O campo não pode ser vazio.")
    @Size(min = 4,message = "Não pode ter meno de 4 caracteres.")
    private String turno;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getMatricula() {
	return matricula;
    }

    public void setMatricula(String matricula) {
	this.matricula = matricula;
    }

    public String getTurno() {
	return turno;
    }

    public void setTurno(String turno) {
	this.turno = turno;
    }

    public Status getStatus() {
	return status;
    }

    public void setStatus(Status status) {
	this.status = status;
    }

    public void setCurso(Curso curso) {
	this.curso = curso;
    }

    public Curso getCurso() {
	return curso;
    }

}
