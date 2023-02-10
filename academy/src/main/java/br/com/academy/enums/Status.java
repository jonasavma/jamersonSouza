package br.com.academy.enums;

public enum Status {

    ATIVO("Ativo"), INATIVO("Inativo"), TRANCADO("Trancado"), CANCELAO("Cancelado");

    private String codigoStatus;

    private Status(String status) {
	this.setCodigoStatus(codigoStatus);
    }

    public String getCodigoStatus() {
        return codigoStatus;
    }

    public void setCodigoStatus(String codigoStatus) {
        this.codigoStatus = codigoStatus;
    }

   

}
