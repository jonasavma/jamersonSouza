package br.com.academy.enums;

public enum Curso {

    ADMINSTRACAO("Administração"), INFORMATICA("Informatica"), CONTABILIDADE("Contabilidade"), ENFERMAGEM("Enfermagem");

    private String codigoCurso;

    private Curso(String codigoCurso) {
	this.setCodigoCurso(codigoCurso);
    }

    public String getCodigoCurso() {
	return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
	this.codigoCurso = codigoCurso;
    }

}
