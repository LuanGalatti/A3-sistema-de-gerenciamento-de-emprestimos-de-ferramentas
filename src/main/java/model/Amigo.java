package model;

import dao.AmigoDAO;

public class Amigo {
    private int idAmigo;
    private String nomeAmigo;
    private String telefone;

    public Amigo() {
        this(0,"", "");
    }

    public Amigo(int idAmigo, String nomeCliente, String telefone) {
        this.idAmigo=idAmigo;
        this.nomeAmigo = nomeCliente;
        this.telefone = telefone;
    }

    public String getNomeAmigo() {
        return nomeAmigo;
    }

    public void setNomeAmigo(String nomeCliente) {
        this.nomeAmigo = nomeCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(int idAmigo) {
        this.idAmigo = idAmigo;
    }

}

