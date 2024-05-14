package model;

import dao.AmigoDAO;

public class Amigo {
    private int idAmigo;
    private String nomeCliente;
    private String telefone;

    public Amigo() {
        this("", "");
    }

    public Amigo(String nomeCliente, String telefone) {
        this.nomeCliente = nomeCliente;
        this.telefone = telefone;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

